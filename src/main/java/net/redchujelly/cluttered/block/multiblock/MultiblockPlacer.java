package net.redchujelly.cluttered.block.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.Nullable;

public class MultiblockPlacer extends Block {

    public static final IntegerProperty MULTIBLOCK_PART = IntegerProperty.create("part", 1, 2);
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    //3D Array of the shape of the multiblock.
    //The first layer is supposed to be height(y), second is width(x) and third is depth(z)
    private final int[][][] MULTIBLOCK_SHAPE = {
            {
                    {1},
            },
    };

    //New multiblocks will simply override these with their own 3D array and max parts.
    public int[][][] getMultiblockShape(){
        return MULTIBLOCK_SHAPE;
    }

    public IntegerProperty getMultiblockPart(){
        return MULTIBLOCK_PART;
    }

    //Weird stuff happens when it's pushed by a piston.
    public @Nullable PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.IMMOVEABLE;
    }

    public MultiblockPlacer(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any()
                        .setValue(getMultiblockPart(), 1)
                        .setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING).add(getMultiblockPart());
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Level level = pContext.getLevel();
        BlockPos OGpos = pContext.getClickedPos();
        Direction direction = pContext.getHorizontalDirection();
        int[][][] multiblockShape = getMultiblockShape();

        int maxHeight = getMultiblockShape().length;
        int OGx = OGpos.getX();
        int OGy = OGpos.getY();
        int OGz = OGpos.getZ();
        int xOffset = 0;
        int zOffset = 0;

        if (!(OGpos.getY() + maxHeight < level.getMaxY())) {
            return null;
        }
        for(int y = 0; y < maxHeight; y++) {
            for(int x = 0; x < multiblockShape[y].length; x++) {
                for(int z = 0; z < multiblockShape[y][x].length; z++) {
                    //0 in this case refers to no block being there, so it gets ignored.
                    if(multiblockShape[y][x][z] != 0) {
                        //setting the direction to properly reflect the players facing direction
                        xOffset = getXOffset(direction, x, z);
                        zOffset = getZOffset(direction, x, z);
                        if (!level.getBlockState(new BlockPos(OGx + xOffset, OGy + y, OGz + zOffset)).canBeReplaced()) {
                            return null;
                        }
                    }
                }
            }
        }
        return this.defaultBlockState().setValue(FACING, direction);
    }

    protected int getXOffset(Direction facing, int x, int z) {
        int xOffset = 0;

        if (facing.equals(Direction.NORTH)) {xOffset = x;}
        if (facing.equals(Direction.SOUTH)) {xOffset = -x;}
        if (facing.equals(Direction.EAST)) {xOffset = z;}
        if (facing.equals(Direction.WEST)) {xOffset = -z;}
        return xOffset;
    }

    protected int getZOffset(Direction facing, int x, int z) {
        int zOffset = 0;

        if (facing.equals(Direction.NORTH)) {zOffset = -z;}
        if (facing.equals(Direction.SOUTH)) {zOffset = z;}
        if (facing.equals(Direction.EAST)) {zOffset = x;}
        if (facing.equals(Direction.WEST)) {zOffset = -x;}
        return zOffset;
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!hasMultiblockProperties(pState)) {
            return;
        }
        BlockPos state1Pos = null;
        if (pState.getValue(getMultiblockPart()) != 1) {
            state1Pos = findBlockState1(pPos, pLevel);
        } else {
            state1Pos = pPos;
        }
        if (state1Pos != null) {
            if (!canSurvive(pLevel.getBlockState(state1Pos), pLevel, state1Pos)) {
                pLevel.destroyBlock(pPos, true);
            }
        }
        else {
            pLevel.destroyBlock(pPos, true);
        }
    }

    @Override
    protected BlockState updateShape(BlockState pState, net.minecraft.world.level.LevelReader pLevel, net.minecraft.world.level.ScheduledTickAccess pTicks, BlockPos pCurrentPos, Direction pDirection, BlockPos pNeighborPos, BlockState pNeighborState, net.minecraft.util.RandomSource pRandom) {
        if (!hasMultiblockProperties(pState)) {
            return super.updateShape(pState, pLevel, pTicks, pCurrentPos, pDirection, pNeighborPos, pNeighborState, pRandom);
        }
        BlockPos state1Pos = null;
        if (pState.getValue(getMultiblockPart()) != 1) {
            state1Pos = findBlockState1(pCurrentPos, pLevel);
        } else {
            state1Pos = pCurrentPos;
        }
        if (state1Pos != null) {
            if (!canSurvive(pLevel.getBlockState(state1Pos), pLevel, state1Pos)) {
                pTicks.scheduleTick(pCurrentPos, this, 0);
            }
        } else {
            pTicks.scheduleTick(pCurrentPos, this, 0);
        }
        return super.updateShape(pState, pLevel, pTicks, pCurrentPos, pDirection, pNeighborPos, pNeighborState, pRandom);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        //this lets you place the block
        if (!pLevel.getBlockState(pPos).is(this)) {return true;}
        if (!hasMultiblockProperties(pState)) {return true;}

        Direction facing = pState.getValue(FACING);
        if (pState.getValue(getMultiblockPart()) != 1) {
            return true;
        }

        int OGx = pPos.getX();
        int OGy = pPos.getY();
        int OGz = pPos.getZ();
        int[][][] multiblockShape = this.getMultiblockShape();
        for(int y = 0; y < multiblockShape.length; y++) {
            for (int x = 0; x < multiblockShape[y].length; x++) {
                for (int z = 0; z < multiblockShape[y][x].length; z++) {
                    int xOffset = getXOffset(facing, x, z);
                    int zOffset = getZOffset(facing, x, z);
                    int part = 0;
                    BlockState state = pLevel.getBlockState(new BlockPos(OGx + xOffset, OGy + y, OGz + zOffset));

                    if (state.hasProperty(getMultiblockPart()))
                        part = state.getValue(getMultiblockPart());
                    if (multiblockShape[y][x][z] != 0) {
                        if (multiblockShape[y][x][z] != part) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    protected BlockPos findBlockState1(BlockPos currentPos, LevelReader level) {

        BlockState currentState = level.getBlockState(currentPos);
        if (!hasMultiblockProperties(currentState)) {
            return null;
        }
        Direction facing = currentState.getValue(FACING);
        int[][][] multiblockShape = getMultiblockShape();

        int partNum = currentState.getValue(getMultiblockPart());

        //Subtracts relative X, Y, Z from blockpos. This probably works.
        for(int y = 0; y < multiblockShape.length; y++) {
            for (int x = 0; x < multiblockShape[y].length; x++) {
                for (int z = 0; z < multiblockShape[y][x].length; z++) {
                    if (multiblockShape[y][x][z] == partNum) {
                        int xOffset = -getXOffset(facing, x, z);
                        int zOffset = -getZOffset(facing, x, z);
                        BlockPos possibleState1 = new BlockPos(currentPos.getX() + xOffset, currentPos.getY() - y, currentPos.getZ() + zOffset);
                        BlockState possibleState = level.getBlockState(possibleState1);
                        if (possibleState.is(this.asBlock()) && possibleState.hasProperty(FACING) && possibleState.getValue(FACING).equals(facing)) {
                            return possibleState1;
                        }
                    }
                }
            }
        }
        return null;
    }

    //Computers love doing nested loops, btw. its their favorite activity; they told me that. its good for them.
    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (!pLevel.isClientSide()) {
            if (!hasMultiblockProperties(pState)) {
                return;
            }
            Direction direction = pState.getValue(FACING);
            int[][][] multiblockShape = getMultiblockShape();
            int OGx = pPos.getX();
            int OGy = pPos.getY();
            int OGz = pPos.getZ();
            //Only the original block placed by the player should place the rest.
            //Is this a good system? No clue honestly. It works, though!
            if (pState.getValue(getMultiblockPart()) == 1 && !pOldState.is(this.asBlock())) {
                for (int y = 0; y < multiblockShape.length; y++) {
                    for (int x = 0; x < multiblockShape[y].length; x++) {
                        for (int z = 0; z < multiblockShape[y][x].length; z++) {
                            if (x + y + z != 0 && multiblockShape[y][x][z] != 0) {
                                int xOffset = getXOffset(direction, x, z);
                                int zOffset = getZOffset(direction, x, z);
                                pLevel.setBlock(new BlockPos(OGx + xOffset, OGy + y, OGz + zOffset), defaultBlockState().setValue(getMultiblockPart(), multiblockShape[y][x][z]).setValue(FACING, direction), 2);
                            }
                        }
                    }
                }
            }
        }
    }

    protected boolean hasMultiblockProperties(BlockState state) {
        return state.hasProperty(FACING) && state.hasProperty(getMultiblockPart());
    }

    protected int getMultiblockPartValue(BlockState state) {
        return state.hasProperty(getMultiblockPart()) ? state.getValue(getMultiblockPart()) : 1;
    }
}
