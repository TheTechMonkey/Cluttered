package net.redchujelly.cluttered.setup;

import java.util.Set;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ints.ConstantValue;

/** Adds Cluttered tree starters to vanilla survival loot without replacing vanilla pools. */
public final class LootTableModifiers {
    private static final Set<ResourceKey<LootTable>> VILLAGE_CHESTS = Set.of(
            BuiltInLootTables.VILLAGE_WEAPONSMITH,
            BuiltInLootTables.VILLAGE_TOOLSMITH,
            BuiltInLootTables.VILLAGE_ARMORER,
            BuiltInLootTables.VILLAGE_CARTOGRAPHER,
            BuiltInLootTables.VILLAGE_MASON,
            BuiltInLootTables.VILLAGE_SHEPHERD,
            BuiltInLootTables.VILLAGE_BUTCHER,
            BuiltInLootTables.VILLAGE_FLETCHER,
            BuiltInLootTables.VILLAGE_FISHER,
            BuiltInLootTables.VILLAGE_TANNERY,
            BuiltInLootTables.VILLAGE_TEMPLE,
            BuiltInLootTables.VILLAGE_DESERT_HOUSE,
            BuiltInLootTables.VILLAGE_PLAINS_HOUSE,
            BuiltInLootTables.VILLAGE_TAIGA_HOUSE,
            BuiltInLootTables.VILLAGE_SNOWY_HOUSE,
            BuiltInLootTables.VILLAGE_SAVANNA_HOUSE);

    private LootTableModifiers() {
    }

    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (!source.isBuiltin()) {
                return;
            }

            if (VILLAGE_CHESTS.contains(key)) {
                // Seven starters plus 63 empty weight: 10% for any starter, 1.43% per type.
                tableBuilder.withPool(starterPool(63));
            } else if (BuiltInLootTables.SIMPLE_DUNGEON.equals(key)) {
                // Seven starters plus 133 empty weight: 5% for any starter, 0.71% per type.
                tableBuilder.withPool(starterPool(133));
            }
        });
    }

    private static LootPool.Builder starterPool(int emptyWeight) {
        return LootPool.lootPool()
                .setRolls(Holder.direct(new ConstantValue(1)))
                .add(LootItem.lootTableItem(BlockRegistration.WILLOW_SAPLING.get()))
                .add(LootItem.lootTableItem(BlockRegistration.POPLAR_SAPLING.get()))
                .add(LootItem.lootTableItem(BlockRegistration.CRABAPPLE_SAPLING.get()))
                .add(LootItem.lootTableItem(BlockRegistration.SYCAMORE_SAPLING.get()))
                .add(LootItem.lootTableItem(BlockRegistration.MAPLE_SAPLING.get()))
                .add(LootItem.lootTableItem(BlockRegistration.BLUE_MUSHROOM_SAPLING.get()))
                .add(LootItem.lootTableItem(BlockRegistration.RED_MUSHROOM_SAPLING.get()))
                .add(EmptyLootItem.emptyItem().setWeight(emptyWeight));
    }
}
