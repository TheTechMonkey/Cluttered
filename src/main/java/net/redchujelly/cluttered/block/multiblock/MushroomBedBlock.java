package net.redchujelly.cluttered.block.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.attribute.BedRule;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractBedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MushroomBedBlock extends MultiblockBedBlock{

    private static final VoxelShape SHAPE_BASE = Block.box(0,0,0,16,9,16);

    private static final VoxelShape SHAPE_N_1 = Shapes.or(SHAPE_BASE, Block.box(0,0,14,16,15,16));
    private static final VoxelShape SHAPE_S_1 = Shapes.or(SHAPE_BASE, Block.box(0,0,0,16,15,2));
    private static final VoxelShape SHAPE_E_1 = Shapes.or(SHAPE_BASE, Block.box(0,0,0,2,15,16));
    private static final VoxelShape SHAPE_W_1 = Shapes.or(SHAPE_BASE, Block.box(14,0,0,16,15,16));

    private static final VoxelShape SHAPE_N_2 = Shapes.or(SHAPE_BASE, Block.box(0,0,0,16,17,3));
    private static final VoxelShape SHAPE_S_2 = Shapes.or(SHAPE_BASE, Block.box(0,0,13,16,17,16));
    private static final VoxelShape SHAPE_E_2 = Shapes.or(SHAPE_BASE, Block.box(13,0,0,16,17,16));
    private static final VoxelShape SHAPE_W_2 = Shapes.or(SHAPE_BASE, Block.box(0,0,0,3,17,16));

    public static final IntegerProperty MULTIBLOCK_PART = IntegerProperty.create("part", 1, 2);
    private static final int[][][] MULTIBLOCK_SHAPE = {
            {
                    {1,2}
            },
    };

    public MushroomBedBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction facing = pState.getValue(FACING);
        if (getMultiblockPartValue(pState) == 1){
            return switch (facing){
                case SOUTH -> SHAPE_S_1;
                case EAST -> SHAPE_E_1;
                case WEST -> SHAPE_W_1;
                default -> SHAPE_N_1;
            };
        }
        else return switch (facing){
                case SOUTH -> SHAPE_S_2;
                case EAST -> SHAPE_E_2;
                case WEST -> SHAPE_W_2;
                default -> SHAPE_N_2;
            };
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
            if (part == 1){
                pPos = pPos.relative(pState.getValue(FACING));
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

    @Override
    public IntegerProperty getMultiblockPart() {
        return MULTIBLOCK_PART;
    }

    @Override
    public int[][][] getMultiblockShape() {
        return MULTIBLOCK_SHAPE;
    }
}
