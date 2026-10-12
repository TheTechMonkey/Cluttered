package net.redchujelly.cluttered.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.redchujelly.cluttered.Cluttered;

/** Resource keys for Cluttered's data-driven tree features. */
public final class ClutteredConfiguredFeatures {
    public static final ResourceKey<Feature> WILLOW_KEY = registerKey("willow");
    public static final ResourceKey<Feature> POPLAR_KEY = registerKey("poplar");
    public static final ResourceKey<Feature> BLUE_MUSHROOM_KEY = registerKey("blue_mushroom");
    public static final ResourceKey<Feature> RED_MUSHROOM_KEY = registerKey("red_mushroom");
    public static final ResourceKey<Feature> CRABAPPLE_KEY = registerKey("crabapple");
    public static final ResourceKey<Feature> SYCAMORE_KEY = registerKey("sycamore");
    public static final ResourceKey<Feature> MAPLE_KEY = registerKey("fluorescent_maple");

    private ClutteredConfiguredFeatures() {
    }

    private static ResourceKey<Feature> registerKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(Cluttered.MODID, name));
    }
}
