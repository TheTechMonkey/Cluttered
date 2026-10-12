package net.redchujelly.cluttered.worldgen.tree;

import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.redchujelly.cluttered.worldgen.ClutteredConfiguredFeatures;


public final class SycamoreTreeGrower {
    public static final TreeGrower INSTANCE = new TreeGrower(
            "cluttered_sycamore",
            WeightedList.of(ClutteredConfiguredFeatures.SYCAMORE_KEY),
            WeightedList.of(),
            WeightedList.of(),
            ClutteredConfiguredFeatures.SYCAMORE_KEY);

    private SycamoreTreeGrower() {
    }
}
