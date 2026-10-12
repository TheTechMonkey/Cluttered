package net.redchujelly.cluttered.block.custom.furniture;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.redchujelly.cluttered.block.custom.CustomHorizontalBlock;
import net.redchujelly.cluttered.entity.ChairEntity;
import net.redchujelly.cluttered.setup.EntityTypeRegistration;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChairBlock extends CustomHorizontalBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE = Block.box(0,0,0, 16, 8, 16);
    private static final float SEAT_OFFSET = 0.5f;

    public ChairBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(OCCUPIED, false).setValue(WATERLOGGED, false));
    }

    @Override
    protected InteractionResult useItemOn(net.minecraft.world.item.ItemStack pUsedStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pState.getValue(OCCUPIED) && !pPlayer.isShiftKeyDown()){
            Direction sittingDirection = pState.getValue(FACING);
            if (pLevel.isClientSide()) {
                ChairEntity.snapPassengerRotation(pPlayer, sittingDirection);
            } else {
                pLevel.setBlock(pPos, pState.setValue(OCCUPIED, true), 2);
                ChairEntity seat = new ChairEntity(EntityTypeRegistration.CHAIR_ENTITY.get(), pLevel, pPos, sittingDirection);
                seat.setPos(pPos.getX() + .5f, pPos.getY() - 1 + getSeatOffset(), pPos.getZ() + .5f);
                pLevel.addFreshEntity(seat);
                seat.mountPlayer(pPlayer);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected BlockState updateShape(BlockState pState, net.minecraft.world.level.LevelReader pLevel, net.minecraft.world.level.ScheduledTickAccess pTicks, BlockPos pPos, Direction pDirection, BlockPos pNeighborPos, BlockState pNeighborState, net.minecraft.util.RandomSource pRandom) {
        if(pState.getValue(WATERLOGGED)){
            pTicks.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }
        return super.updateShape(pState, pLevel, pTicks, pPos, pDirection, pNeighborPos, pNeighborState, pRandom);
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        boolean isWaterlogged = pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(WATERLOGGED, isWaterlogged).setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }
    public @Nullable PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.IMMOVEABLE;
    }

    public float getSeatOffset(){
        return SEAT_OFFSET;
    }

    @Override
    protected void affectNeighborsAfterRemoval(BlockState pState, net.minecraft.server.level.ServerLevel pLevel, BlockPos pPos, boolean pMovedByPiston) {
        List<ChairEntity> chairBlocks = pLevel.getEntitiesOfClass(ChairEntity.class, new AABB(pPos));
        for (ChairEntity chair : chairBlocks){
            chair.kill(pLevel);
        }
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
            return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(OCCUPIED).add(WATERLOGGED);
    }
}
