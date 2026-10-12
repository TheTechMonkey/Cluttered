package net.redchujelly.cluttered.worldgen.tree;

import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.redchujelly.cluttered.worldgen.ClutteredConfiguredFeatures;


public final class RedMushroomTreeGrower {
    public static final TreeGrower INSTANCE = new TreeGrower(
            "cluttered_red_mushroom",
            WeightedList.of(ClutteredConfiguredFeatures.RED_MUSHROOM_KEY),
            WeightedList.of(),
            WeightedList.of(),
            ClutteredConfiguredFeatures.RED_MUSHROOM_KEY);

    private RedMushroomTreeGrower() {
    }
}
