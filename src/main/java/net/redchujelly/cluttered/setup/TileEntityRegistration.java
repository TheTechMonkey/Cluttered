package net.redchujelly.cluttered.setup;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.redchujelly.cluttered.platform.BusGroup;
import net.redchujelly.cluttered.platform.DeferredRegister;
import net.redchujelly.cluttered.platform.FabricRegistries;
import net.redchujelly.cluttered.platform.RegistryObject;
import net.redchujelly.cluttered.Cluttered;
import net.redchujelly.cluttered.block.entity.*;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TileEntityRegistration {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(FabricRegistries.BLOCK_ENTITY_TYPES, Cluttered.MODID);

    private static final List<RegistryObject<? extends Block>> ONE_ROW = List.of(
            BlockRegistration.KITCHEN_SET_BROWN_CABINET_MINI,
            BlockRegistration.KITCHEN_SET_BROWN_CABINET_OUTER_CORNER,
            BlockRegistration.KITCHEN_SET_PINK_CABINET_MINI,
            BlockRegistration.KITCHEN_SET_PINK_CABINET_OUTER_CORNER,
            BlockRegistration.KITCHEN_SET_LIGHT_GREEN_CABINET_MINI,
            BlockRegistration.KITCHEN_SET_LIGHT_GREEN_CABINET_OUTER_CORNER,
            BlockRegistration.KITCHEN_SET_PURPLE_CABINET_MINI,
            BlockRegistration.KITCHEN_SET_PURPLE_CABINET_OUTER_CORNER,
            BlockRegistration.KITCHEN_SET_WHITE_CABINET_MINI,
            BlockRegistration.KITCHEN_SET_WHITE_CABINET_OUTER_CORNER,
            BlockRegistration.KITCHEN_SET_YELLOW_CABINET_MINI,
            BlockRegistration.KITCHEN_SET_YELLOW_CABINET_OUTER_CORNER,

            BlockRegistration.ENDTABLE_AMETHYST,
            BlockRegistration.ENDTABLE_BUBBLEGUM,
            BlockRegistration.ENDTABLE_CHARCOAL,
            BlockRegistration.ENDTABLE_MEADOW,
            BlockRegistration.ENDTABLE_PERIWINKLE,
            BlockRegistration.ENDTABLE_SUNSHINE,
            BlockRegistration.ENDTABLE_WOOD,
            BlockRegistration.COTTAGE_SIDE_TABLE,
            BlockRegistration.NIGHTSTAND_GREEN
    );

    private static final List<RegistryObject<? extends Block>> TWO_ROWS = List.of(
            BlockRegistration.KITCHEN_SET_BROWN_CABINET,
            BlockRegistration.KITCHEN_SET_BROWN_CABINET_INNER_CORNER,
            BlockRegistration.KITCHEN_SET_BROWN_CABINET_OPEN,
            BlockRegistration.KITCHEN_SET_BROWN_CABINET_GLASS,
            BlockRegistration.KITCHEN_SET_PINK_CABINET,
            BlockRegistration.KITCHEN_SET_PINK_CABINET_INNER_CORNER,
            BlockRegistration.KITCHEN_SET_PINK_CABINET_OPEN,
            BlockRegistration.KITCHEN_SET_PINK_CABINET_GLASS,
            BlockRegistration.KITCHEN_SET_LIGHT_GREEN_CABINET,
            BlockRegistration.KITCHEN_SET_LIGHT_GREEN_CABINET_INNER_CORNER,
            BlockRegistration.KITCHEN_SET_LIGHT_GREEN_CABINET_OPEN,
            BlockRegistration.KITCHEN_SET_LIGHT_GREEN_CABINET_GLASS,
            BlockRegistration.KITCHEN_SET_PURPLE_CABINET,
            BlockRegistration.KITCHEN_SET_PURPLE_CABINET_INNER_CORNER,
            BlockRegistration.KITCHEN_SET_PURPLE_CABINET_OPEN,
            BlockRegistration.KITCHEN_SET_PURPLE_CABINET_GLASS,
            BlockRegistration.KITCHEN_SET_WHITE_CABINET,
            BlockRegistration.KITCHEN_SET_WHITE_CABINET_INNER_CORNER,
            BlockRegistration.KITCHEN_SET_WHITE_CABINET_OPEN,
            BlockRegistration.KITCHEN_SET_WHITE_CABINET_GLASS,
            BlockRegistration.KITCHEN_SET_YELLOW_CABINET,
            BlockRegistration.KITCHEN_SET_YELLOW_CABINET_INNER_CORNER,
            BlockRegistration.KITCHEN_SET_YELLOW_CABINET_OPEN,
            BlockRegistration.KITCHEN_SET_YELLOW_CABINET_GLASS,

            BlockRegistration.DESK_GREEN,
            BlockRegistration.DESK_GREEN_CLUTTERED,
            BlockRegistration.DESK_BROWN,
            BlockRegistration.DESK_BROWN_CLUTTERED,
            BlockRegistration.FILING_BOX
    );

    private static final List<RegistryObject<? extends Block>> THREE_ROWS = List.of(
            BlockRegistration.KITCHEN_SET_BROWN_COUNTER,
            BlockRegistration.KITCHEN_SET_BROWN_COUNTER_OUTER_CORNER_LEFT,
            BlockRegistration.KITCHEN_SET_BROWN_COUNTER_OUTER_CORNER_RIGHT,
            BlockRegistration.KITCHEN_SET_PINK_COUNTER,
            BlockRegistration.KITCHEN_SET_PINK_COUNTER_OUTER_CORNER_LEFT,
            BlockRegistration.KITCHEN_SET_PINK_COUNTER_OUTER_CORNER_RIGHT,
            BlockRegistration.KITCHEN_SET_LIGHT_GREEN_COUNTER,
            BlockRegistration.KITCHEN_SET_LIGHT_GREEN_COUNTER_OUTER_CORNER_LEFT,
            BlockRegistration.KITCHEN_SET_LIGHT_GREEN_COUNTER_OUTER_CORNER_RIGHT,
            BlockRegistration.KITCHEN_SET_PURPLE_COUNTER,
            BlockRegistration.KITCHEN_SET_PURPLE_COUNTER_OUTER_CORNER_LEFT,
            BlockRegistration.KITCHEN_SET_PURPLE_COUNTER_OUTER_CORNER_RIGHT,
            BlockRegistration.KITCHEN_SET_WHITE_COUNTER,
            BlockRegistration.KITCHEN_SET_WHITE_COUNTER_OUTER_CORNER_LEFT,
            BlockRegistration.KITCHEN_SET_WHITE_COUNTER_OUTER_CORNER_RIGHT,
            BlockRegistration.KITCHEN_SET_YELLOW_COUNTER,
            BlockRegistration.KITCHEN_SET_YELLOW_COUNTER_OUTER_CORNER_LEFT,
            BlockRegistration.KITCHEN_SET_YELLOW_COUNTER_OUTER_CORNER_RIGHT,

            BlockRegistration.BLACK_CAT_COUNTER_DRAWERS,
            BlockRegistration.BLACK_CAT_COUNTER_RIGHT_DOOR,
            BlockRegistration.BLACK_CAT_COUNTER_LEFT_DOOR,
            BlockRegistration.SWEETHEART_COUNTER_DRAWERS,
            BlockRegistration.SWEETHEART_COUNTER_RIGHT_DOOR,
            BlockRegistration.SWEETHEART_COUNTER_LEFT_DOOR,

            BlockRegistration.BRIEFCASE_BLANK,
            BlockRegistration.BRIEFCASE_ROVER,

            BlockRegistration.CHINA_CABINET,
            BlockRegistration.COTTAGE_BOOKCASE,

            BlockRegistration.PASTEL_CABINET
    );

    private static final List<RegistryObject<? extends Block>> SIX_ROWS = List.of(
            BlockRegistration.CARD_INDEX,
            BlockRegistration.GENERAL_STORE_CABINET,
            BlockRegistration.DARKWOOD_CABINET,
            BlockRegistration.DORADO_CABINET,
            BlockRegistration.DORADO_CABINET_CLUTTERED,
            BlockRegistration.HAVANA_CABINET,
            BlockRegistration.HAVANA_CABINET_CLUTTERED,
            BlockRegistration.MUREX_CABINET,
            BlockRegistration.MUREX_CABINET_CLUTTERED,
            BlockRegistration.RED_MUSHROOM_WARDROBE,
            BlockRegistration.BLUE_MUSHROOM_WARDROBE,
            BlockRegistration.PASTEL_WARDROBE,
            BlockRegistration.MERMAID_DRESSER
    );

    private static final List<RegistryObject<? extends Block>> FRIDGES = List.of(
            BlockRegistration.RETRO_FRIDGE_BLACK,
            BlockRegistration.RETRO_FRIDGE_BLUE,
            BlockRegistration.RETRO_FRIDGE_PINK,
            BlockRegistration.RETRO_FRIDGE_RED,
            BlockRegistration.RETRO_FRIDGE_PURPLE,
            BlockRegistration.RETRO_FRIDGE_YELLOW,
            BlockRegistration.RETRO_FRIDGE_TURQUOISE,
            BlockRegistration.RETRO_FRIDGE_WHITE
    );

    private static final List<RegistryObject<? extends Block>> CARDBOARD_BOX = List.of(
            BlockRegistration.CARDBOARD_BOX
    );

    private static final List<RegistryObject<? extends Block>> SAFE = List.of(
            BlockRegistration.SAFE_NOVAKID
    );

    public static final RegistryObject<BlockEntityType<CustomStorageBlockEntity>> ONE_ROW_BE = registerWithStorage(
            () -> TileEntityRegistration.ONE_ROW_BE, 1, ONE_ROW, "one_row_be");
    public static final RegistryObject<BlockEntityType<CustomStorageBlockEntity>> TWO_ROWS_BE = registerWithStorage(
            () -> TileEntityRegistration.TWO_ROWS_BE, 2, TWO_ROWS, "two_rows_be");
    public static final RegistryObject<BlockEntityType<CustomStorageBlockEntity>> THREE_ROWS_BE = registerWithStorage(
            () -> TileEntityRegistration.THREE_ROWS_BE, 3, THREE_ROWS, "three_rows_be");

    public static final RegistryObject<BlockEntityType<CustomStorageBlockEntity>> SIX_ROWS_BE = registerWithStorage(
            () -> TileEntityRegistration.SIX_ROWS_BE, 6, SIX_ROWS, "six_rows_be");

    public static final RegistryObject<BlockEntityType<CustomStorageBlockEntity>> SAFE_BE = registerWithStorageAndSounds(
            () -> TileEntityRegistration.SAFE_BE, 4, SAFE, "safe_be", SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.IRON_TRAPDOOR_CLOSE);
    public static final RegistryObject<BlockEntityType<FridgeBlockEntity>> RETRO_FRIDGE_BE = registerFridge(
            () -> TileEntityRegistration.RETRO_FRIDGE_BE, 6, FRIDGES, "retro_fridge_be");
    public static final RegistryObject<BlockEntityType<CardboardBoxBlockEntity>> CARDBOARD_BOX_BE = registerCardboardBox(
            () -> TileEntityRegistration.CARDBOARD_BOX_BE, 2, CARDBOARD_BOX, "cardboard_box_be");

    public static final RegistryObject<BlockEntityType<ClutteredSignBlockEntity>> CLUTTERED_SIGN_BE = BLOCK_ENTITIES.register(
            "cluttered_sign", () -> FabricBlockEntityTypeBuilder.create(ClutteredSignBlockEntity::new,
                            BlockRegistration.WILLOW_SIGN.get(),
                            BlockRegistration.WILLOW_WALL_SIGN.get(),
                            BlockRegistration.FLOWERING_WILLOW_SIGN.get(),
                            BlockRegistration.FLOWERING_WILLOW_WALL_SIGN.get(),
                            BlockRegistration.POPLAR_SIGN.get(),
                            BlockRegistration.POPLAR_WALL_SIGN.get(),
                            BlockRegistration.FLOWERING_POPLAR_SIGN.get(),
                            BlockRegistration.FLOWERING_POPLAR_WALL_SIGN.get(),
                            BlockRegistration.CRABAPPLE_SIGN.get(),
                            BlockRegistration.CRABAPPLE_WALL_SIGN.get(),
                            BlockRegistration.FLOWERING_CRABAPPLE_SIGN.get(),
                            BlockRegistration.FLOWERING_CRABAPPLE_WALL_SIGN.get(),
                            BlockRegistration.SYCAMORE_SIGN.get(),
                            BlockRegistration.SYCAMORE_WALL_SIGN.get(),
                            BlockRegistration.MAPLE_SIGN.get(),
                            BlockRegistration.MAPLE_WALL_SIGN.get(),
                            BlockRegistration.BLUE_MUSHROOM_SIGN.get(),
                            BlockRegistration.BLUE_MUSHROOM_WALL_SIGN.get(),
                            BlockRegistration.RED_MUSHROOM_SIGN.get(),
                            BlockRegistration.RED_MUSHROOM_WALL_SIGN.get()
                    ).build()
    );

    public static final RegistryObject<BlockEntityType<ClutteredHangingSignBlockEntity>> CLUTTERED_HANGING_SIGN_BE = BLOCK_ENTITIES.register(
            "cluttered_hanging_sign", () -> FabricBlockEntityTypeBuilder.create(ClutteredHangingSignBlockEntity::new,
                            BlockRegistration.WILLOW_HANGING_SIGN.get(),
                            BlockRegistration.WILLOW_WALL_HANGING_SIGN.get(),
                            BlockRegistration.FLOWERING_WILLOW_HANGING_SIGN.get(),
                            BlockRegistration.FLOWERING_WILLOW_WALL_HANGING_SIGN.get(),
                            BlockRegistration.POPLAR_HANGING_SIGN.get(),
                            BlockRegistration.POPLAR_WALL_HANGING_SIGN.get(),
                            BlockRegistration.FLOWERING_POPLAR_HANGING_SIGN.get(),
                            BlockRegistration.FLOWERING_POPLAR_WALL_HANGING_SIGN.get(),
                            BlockRegistration.CRABAPPLE_HANGING_SIGN.get(),
                            BlockRegistration.CRABAPPLE_WALL_HANGING_SIGN.get(),
                            BlockRegistration.FLOWERING_CRABAPPLE_HANGING_SIGN.get(),
                            BlockRegistration.FLOWERING_CRABAPPLE_WALL_HANGING_SIGN.get(),
                            BlockRegistration.SYCAMORE_HANGING_SIGN.get(),
                            BlockRegistration.SYCAMORE_WALL_HANGING_SIGN.get(),
                            BlockRegistration.MAPLE_HANGING_SIGN.get(),
                            BlockRegistration.MAPLE_WALL_HANGING_SIGN.get(),
                            BlockRegistration.BLUE_MUSHROOM_HANGING_SIGN.get(),
                            BlockRegistration.BLUE_MUSHROOM_WALL_HANGING_SIGN.get(),
                            BlockRegistration.RED_MUSHROOM_HANGING_SIGN.get(),
                            BlockRegistration.RED_MUSHROOM_WALL_HANGING_SIGN.get()
                    ).build()
    );




    public static void register(BusGroup eventBus) {
        BLOCK_ENTITIES.register(eventBus);
        registerJukeboxBlocks();
    }

    private static void registerJukeboxBlocks() {
        FabricBlockEntityType jukeboxType = (FabricBlockEntityType) (Object) BlockEntityTypes.JUKEBOX;
        jukeboxType.addValidBlock(BlockRegistration.TRADITIONAL_RADIO.get());
        jukeboxType.addValidBlock(BlockRegistration.RECORD_PLAYER_BLUE.get());
        jukeboxType.addValidBlock(BlockRegistration.RECORD_PLAYER_BROWN.get());
        jukeboxType.addValidBlock(BlockRegistration.RECORD_PLAYER_PINK.get());
        jukeboxType.addValidBlock(BlockRegistration.RECORD_PLAYER_PURPLE.get());
        jukeboxType.addValidBlock(BlockRegistration.RECORD_PLAYER_RED.get());
        jukeboxType.addValidBlock(BlockRegistration.RECORD_PLAYER_WHITE.get());
        jukeboxType.addValidBlock(BlockRegistration.RECORD_PLAYER_YELLOW.get());
    }


    private static RegistryObject<BlockEntityType<CustomStorageBlockEntity>> registerWithStorage(Supplier<Supplier<BlockEntityType<CustomStorageBlockEntity>>> type, int rows, List<RegistryObject<? extends Block>> block, String name){

        return BLOCK_ENTITIES.register(name, () -> FabricBlockEntityTypeBuilder
                .create((blockPos, blockState) -> new CustomStorageBlockEntity(type.get().get(), blockPos, blockState, rows))
                .addBlocks(blockSet(block))
                .build());
    }

    private static RegistryObject<BlockEntityType<CustomStorageBlockEntity>> registerWithStorageAndSounds(Supplier<Supplier<BlockEntityType<CustomStorageBlockEntity>>> type, int rows, List<RegistryObject<? extends Block>> block, String name, SoundEvent openSound, SoundEvent closeSound){

        return BLOCK_ENTITIES.register(name, () -> FabricBlockEntityTypeBuilder
                .create((blockPos, blockState) -> new CustomStorageBlockEntity(type.get().get(), blockPos, blockState, rows, openSound, closeSound))
                .addBlocks(blockSet(block))
                .build());
    }

    private static RegistryObject<BlockEntityType<FridgeBlockEntity>> registerFridge(Supplier<Supplier<BlockEntityType<FridgeBlockEntity>>> type, int rows, List<RegistryObject<? extends Block>> block, String name){

        return BLOCK_ENTITIES.register(name, () -> FabricBlockEntityTypeBuilder
                .create((blockPos, blockState) -> new FridgeBlockEntity(type.get().get(), blockPos, blockState, rows))
                .addBlocks(blockSet(block))
                .build());
    }

    private static RegistryObject<BlockEntityType<CardboardBoxBlockEntity>> registerCardboardBox(Supplier<Supplier<BlockEntityType<CardboardBoxBlockEntity>>> type, int rows, List<RegistryObject<? extends Block>> block, String name){

        return BLOCK_ENTITIES.register(name, () -> FabricBlockEntityTypeBuilder
                .create((blockPos, blockState) -> new CardboardBoxBlockEntity(type.get().get(), blockPos, blockState, rows))
                .addBlocks(blockSet(block))
                .build());
    }

    private static Set<Block> blockSet(List<RegistryObject<? extends Block>> blocks) {
        return blocks.stream().map(RegistryObject::get).collect(Collectors.toSet());
    }

}
