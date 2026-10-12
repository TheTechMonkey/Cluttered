package net.redchujelly.cluttered.worldgen.tree;

import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.redchujelly.cluttered.worldgen.ClutteredConfiguredFeatures;


public final class WillowTreeGrower {
    public static final TreeGrower INSTANCE = new TreeGrower(
            "cluttered_willow",
            WeightedList.of(ClutteredConfiguredFeatures.WILLOW_KEY),
            WeightedList.of(),
            WeightedList.of(),
            ClutteredConfiguredFeatures.WILLOW_KEY);

    private WillowTreeGrower() {
    }
}
