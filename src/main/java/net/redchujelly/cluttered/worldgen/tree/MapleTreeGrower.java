package net.redchujelly.cluttered.worldgen.tree;

import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.redchujelly.cluttered.worldgen.ClutteredConfiguredFeatures;


public final class MapleTreeGrower {
    public static final TreeGrower INSTANCE = new TreeGrower(
            "cluttered_maple",
            WeightedList.of(ClutteredConfiguredFeatures.MAPLE_KEY),
            WeightedList.of(),
            WeightedList.of(),
            ClutteredConfiguredFeatures.MAPLE_KEY);

    private MapleTreeGrower() {
    }
}
