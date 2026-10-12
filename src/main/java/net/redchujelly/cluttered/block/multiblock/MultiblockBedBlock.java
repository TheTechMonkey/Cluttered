package net.redchujelly.cluttered.block.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.attribute.BedRule;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AbstractBedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class MultiblockBedBlock extends MultiblockPlacer{
    private static final VoxelShape SHAPE = Block.box(0,0,0,16,9,16);
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;

    public static final IntegerProperty MULTIBLOCK_PART = IntegerProperty.create("part", 1, 6);
    private static final int[][][] MULTIBLOCK_SHAPE = {
            {
                    {1,3,5},
                    {2,4,6},
            },
    };

    public MultiblockBedBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(OCCUPIED, false));
    }

    // Forge-compatible bed hooks kept for parity with the official jar; Fabric paths are bridged by mixins.
    public boolean isBed(BlockState state, BlockGetter level, BlockPos pos, @Nullable Entity player) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public Direction getBedDirection(BlockState state, LevelReader level, BlockPos pos) {
        return state.getValue(FACING);
    }

    public void setBedOccupied(BlockState state, Level level, BlockPos pos, LivingEntity sleeper, boolean occupied) {
        level.setBlock(pos, state.setValue(OCCUPIED, occupied), 2);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHit) {
        return useBed(pState, pLevel, pPos, pPlayer);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack pUsedStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        return useBed(pState, pLevel, pPos, pPlayer);
    }

    private InteractionResult useBed(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        if (pLevel.isClientSide()) {
            return InteractionResult.CONSUME;
        } else {
            if (!hasMultiblockProperties(pState)) {
                return InteractionResult.CONSUME;
            }
            int part = getMultiblockPartValue(pState);
            if(part == 3 || part == 4){
                pPos = pPos.relative(pState.getValue(FACING));
                pState = pLevel.getBlockState(pPos);
                if (!pState.is(this) || !hasMultiblockProperties(pState)) {
                    return InteractionResult.CONSUME;
                }
            }
            if (part == 1 || part == 2){
                pPos = pPos.relative(pState.getValue(FACING), 2);
                pState = pLevel.getBlockState(pPos);
                if (!pState.is(this) || !hasMultiblockProperties(pState)) {
                    return InteractionResult.CONSUME;
                }
            }

            BedRule bedRule = pLevel.environmentAttributes().getValue(EnvironmentAttributes.BED_RULE, pPos);
            if (bedRule.destroyOnUse()) {
                bedRule.errorMessage().ifPresent(pPlayer::sendOverlayMessage);
                pLevel.removeBlock(pPos, false);
                BlockPos removePos = pPos.relative((pState.getValue(FACING)).getOpposite());
                if (pLevel.getBlockState(removePos).is(this)) {
                    pLevel.removeBlock(removePos, false);
                }

                Vec3 center = Vec3.atCenterOf(pPos);
                pLevel.explode(null, pLevel.damageSources().badRespawnPointExplosion(center), null, center, 5.0F, true, Level.ExplosionInteraction.BLOCK);
            } else if (pState.getValue(OCCUPIED)) {
                pPlayer.sendOverlayMessage(Component.translatable("block.minecraft.bed.occupied"));

                return InteractionResult.SUCCESS;
            } else {
                BlockPos sleepPos = pPos;
                BlockState sleepState = pState;
                AbstractBedBlock vanillaBed = (AbstractBedBlock) Blocks.BED.pick(DyeColor.WHITE);
                var sleepResult = pPlayer.startSleepInBed(vanillaBed, sleepState, bedRule, sleepPos);
                sleepResult.ifLeft((sleepingProblem) -> {
                    if (sleepingProblem.message() != null) {
                        pPlayer.sendOverlayMessage(sleepingProblem.message());
                    }
                });
                sleepResult.ifRight((unit) -> pLevel.setBlock(sleepPos, sleepState.setValue(OCCUPIED, true), 3));
            }
            return InteractionResult.SUCCESS;
        }
    }

    public static boolean canSetSpawn(Level pLevel) {
        return pLevel.environmentAttributes().getValue(EnvironmentAttributes.BED_RULE, BlockPos.ZERO).canSetSpawn(pLevel);
    }

    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, double pFallDistance) {
        super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance * 0.5F);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(OCCUPIED);
    }

    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

    @Override
    public IntegerProperty getMultiblockPart() {
        return MULTIBLOCK_PART;
    }

    @Override
    public int[][][] getMultiblockShape() {
        return MULTIBLOCK_SHAPE;
    }
}
