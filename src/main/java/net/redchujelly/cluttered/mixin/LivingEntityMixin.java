package net.redchujelly.cluttered.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.redchujelly.cluttered.block.multiblock.MultiblockBedBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(method = "startSleeping", at = @At("HEAD"), cancellable = true)
    private void cluttered$startSleepingInCustomBed(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        BlockState state = entity.level().getBlockState(pos);
        if (!(state.getBlock() instanceof MultiblockBedBlock)) {
            return;
        }

        var shape = state.getShape(entity.level(), pos);
        if (shape.isEmpty()) {
            cir.setReturnValue(false);
            return;
        }

        if (entity.isPassenger()) {
            entity.stopRiding();
        }
        double sleepHeight = shape.max(Direction.Axis.Y);
        entity.setPos(pos.getX() + 0.5, pos.getY() + sleepHeight + 0.125, pos.getZ() + 0.5);
        entity.setPose(Pose.SLEEPING);
        entity.setSleepingPos(pos);
        entity.setDeltaMovement(Vec3.ZERO);
        entity.needsSync = true;
        cir.setReturnValue(true);
    }

    @Inject(method = "lambda$checkBedExists$0", at = @At("HEAD"), cancellable = true)
    private void cluttered$checkCustomBedExists(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (entity.level().getBlockState(pos).getBlock() instanceof MultiblockBedBlock) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "lambda$stopSleeping$0", at = @At("HEAD"), cancellable = true)
    private void cluttered$stopSleepingInCustomBed(BlockPos pos, CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        BlockState state = entity.level().getBlockState(pos);
        if (!(state.getBlock() instanceof MultiblockBedBlock) || !state.hasProperty(MultiblockBedBlock.OCCUPIED)) {
            return;
        }

        entity.level().setBlock(pos, state.setValue(MultiblockBedBlock.OCCUPIED, false), 3);
        Vec3 standUpPos = BedBlock.findStandUpPosition(entity.getType(), entity.level(), pos, state.getValue(MultiblockBedBlock.FACING), entity.getYRot())
                .orElseGet(() -> Vec3.atBottomCenterOf(pos.above()));
        Vec3 lookDirection = Vec3.atBottomCenterOf(pos).subtract(standUpPos).normalize();
        float yRot = (float) Mth.wrapDegrees(Mth.atan2(lookDirection.z, lookDirection.x) * (180.0F / (float) Math.PI) - 90.0);
        entity.setPos(standUpPos.x, standUpPos.y, standUpPos.z);
        entity.setYRot(yRot);
        entity.setXRot(0.0F);
        ci.cancel();
    }
}
