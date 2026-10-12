package net.redchujelly.cluttered.worldgen.tree;

import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.redchujelly.cluttered.worldgen.ClutteredConfiguredFeatures;


public final class CrabappleTreeGrower {
    public static final TreeGrower INSTANCE = new TreeGrower(
            "cluttered_crabapple",
            WeightedList.of(ClutteredConfiguredFeatures.CRABAPPLE_KEY),
            WeightedList.of(),
            WeightedList.of(),
            ClutteredConfiguredFeatures.CRABAPPLE_KEY);

    private CrabappleTreeGrower() {
    }
}
