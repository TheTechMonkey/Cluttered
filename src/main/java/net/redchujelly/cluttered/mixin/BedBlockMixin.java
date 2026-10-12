package net.redchujelly.cluttered.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.AbstractBedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.redchujelly.cluttered.block.multiblock.MultiblockBedBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBedBlock.class)
public abstract class BedBlockMixin {
    @Inject(method = "getBedOrientation", at = @At("HEAD"), cancellable = true)
    private static void cluttered$getCustomBedOrientation(BlockGetter level, BlockPos pos, CallbackInfoReturnable<Direction> cir) {
        BlockState state = level.getBlockState(pos);
        if (state.getBlock() instanceof MultiblockBedBlock && state.hasProperty(MultiblockBedBlock.FACING)) {
            cir.setReturnValue(state.getValue(MultiblockBedBlock.FACING));
        }
    }
}
