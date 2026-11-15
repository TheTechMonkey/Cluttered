package net.redchujelly.cluttered.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import net.redchujelly.cluttered.block.custom.furniture.ChairBlock;
import net.redchujelly.cluttered.block.multiblock.MultiblockChair;

public class ChairEntity extends Entity {

    private BlockPos chairPos;
    private final Level CHAIR_LEVEL;

    public ChairEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        chairPos = BlockPos.ZERO;
        CHAIR_LEVEL = pLevel;
    }
    public ChairEntity(EntityType<?> pEntityType, Level pLevel, BlockPos pos) {
        super(pEntityType, pLevel);
        chairPos = pos;
        CHAIR_LEVEL = pLevel;
    }

    public ChairEntity(EntityType<?> pEntityType, Level pLevel, BlockPos pos, Direction sittingDirection) {
        this(pEntityType, pLevel, pos);
        setSittingDirection(sittingDirection);
    }

    private void setSittingDirection(Direction sittingDirection) {
        absSnapRotationTo(sittingDirection.toYRot(), 0.0F);
    }

    public void mountPlayer(Player player) {
        if (player.startRiding(this)) {
            snapPassengerRotation(player, getYRot());
        }
    }

    public static void snapPassengerRotation(Entity passenger, Direction sittingDirection) {
        snapPassengerRotation(passenger, sittingDirection.toYRot());
    }

    private static void snapPassengerRotation(Entity passenger, float yRot) {
        passenger.absSnapRotationTo(yRot, 0.0F);
        passenger.setYHeadRot(yRot);
        passenger.setYBodyRot(yRot);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder entityData) {
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        chairPos = new BlockPos(
                input.getIntOr("ChairX", blockPosition().getX()),
                input.getIntOr("ChairY", blockPosition().getY()),
                input.getIntOr("ChairZ", blockPosition().getZ()));
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        BlockPos pos = resolveChairPos();
        output.putInt("ChairX", pos.getX());
        output.putInt("ChairY", pos.getY());
        output.putInt("ChairZ", pos.getZ());
    }

    @Override
    protected void removePassenger(Entity pPassenger) {
        super.removePassenger(pPassenger);
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity passenger) {
        BlockPos chair = resolveChairPos();
        Direction facing = Direction.fromYRot(getYRot());
        for (int[] offset : DismountHelper.offsetsForDirection(facing)) {
            BlockPos candidate = chair.offset(offset[0], 0, offset[1]);
            Vec3 safePosition = DismountHelper.findSafeDismountLocation(passenger.getType(), level(), candidate, false);
            if (safePosition != null) {
                return safePosition;
            }
        }
        return Vec3.atBottomCenterOf(chair.above());
    }

    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide() && getPassengers().isEmpty()) {
            clearChair();
            discard();
        }
    }

    @Override
    public void kill(ServerLevel level) {
        clearChair();
        super.kill(level);
    }

    private void clearChair() {
        BlockPos pos = resolveChairPos();
        BlockState chair = CHAIR_LEVEL.getBlockState(pos);
        if (chair.hasProperty(BlockStateProperties.OCCUPIED)) {
            CHAIR_LEVEL.setBlock(pos, chair.setValue(BlockStateProperties.OCCUPIED, false), 2);
        }
    }

    /** Finds the owning block for seats saved by older port versions that did not persist it. */
    private BlockPos resolveChairPos() {
        BlockState savedState = CHAIR_LEVEL.getBlockState(chairPos);
        if (savedState.getBlock() instanceof ChairBlock || savedState.getBlock() instanceof MultiblockChair) {
            return chairPos;
        }

        BlockPos center = blockPosition();
        BlockPos nearest = null;
        double nearestDistance = Double.MAX_VALUE;
        for (BlockPos candidate : BlockPos.betweenClosed(center.offset(-2, -2, -2), center.offset(2, 2, 2))) {
            BlockState state = CHAIR_LEVEL.getBlockState(candidate);
            if (!(state.getBlock() instanceof ChairBlock) && !(state.getBlock() instanceof MultiblockChair)) {
                continue;
            }
            if (!state.hasProperty(BlockStateProperties.OCCUPIED) || !state.getValue(BlockStateProperties.OCCUPIED)) {
                continue;
            }
            double distance = candidate.distToCenterSqr(position());
            if (distance < nearestDistance) {
                nearest = candidate.immutable();
                nearestDistance = distance;
            }
        }
        if (nearest != null) {
            chairPos = nearest;
        }
        return chairPos;
    }

    @Override
    public void dismountTo(double pX, double pY, double pZ) {
        super.dismountTo(pX, pY, pZ);
    }

    @Override
    public boolean canBeCollidedWith(Entity other) {
        return false;
    }

    @Override
    public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
        return false;
    }

    @Override
    public boolean isInvisible() {
        return true;
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

}
