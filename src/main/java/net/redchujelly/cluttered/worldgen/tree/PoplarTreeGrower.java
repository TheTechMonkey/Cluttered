package net.redchujelly.cluttered.worldgen.tree;

import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.redchujelly.cluttered.worldgen.ClutteredConfiguredFeatures;


public final class PoplarTreeGrower {
    public static final TreeGrower INSTANCE = new TreeGrower(
            "cluttered_poplar",
            WeightedList.of(ClutteredConfiguredFeatures.POPLAR_KEY),
            WeightedList.of(),
            WeightedList.of(),
            ClutteredConfiguredFeatures.POPLAR_KEY);

    private PoplarTreeGrower() {
    }
}
