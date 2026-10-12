package net.redchujelly.cluttered.mixin;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.redchujelly.cluttered.block.multiblock.MultiblockBedBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin {
    @Redirect(
            method = "findRespawnAndUseSpawnBlock",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;",
                    ordinal = 0
            )
    )
    private static Block cluttered$treatCustomBedAsVanillaBed(BlockState state) {
        Block block = state.getBlock();
        if (block instanceof MultiblockBedBlock) {
            // Let vanilla run its BedBlock respawn branch while keeping the real Cluttered state for facing/position.
            return Blocks.BED.pick(DyeColor.WHITE);
        }

        return block;
    }
}
