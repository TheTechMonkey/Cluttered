package net.redchujelly.cluttered.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BouncyMushroomBlock extends CustomWoodBlock {
    public BouncyMushroomBlock(Properties pProperties) {
        super(pProperties);
    }

    //copied from slime block class
    @Override
    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, double pFallDistance) {
        if (pEntity.isSuppressingBounce()) {
            super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
        } else {
            Vec3 movement = pEntity.getDeltaMovement();
            if (movement.y < -0.35D) {
                pLevel.playSound(null, pPos, SoundEvents.SHROOMLIGHT_PLACE, SoundSource.BLOCKS,
                        Math.min(2.0F, (float) -movement.y),
                        Math.max(Math.min(2.0F, (float) (-movement.y * 1.3D)), 0.8F));
            }
            pEntity.causeFallDamage(pFallDistance, 0.0F, pLevel.damageSources().fall());
        }
    }
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("cluttered.bouncymushroom.tooltip"));
    }
}
