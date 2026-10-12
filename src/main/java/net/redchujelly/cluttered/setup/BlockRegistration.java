package net.redchujelly.cluttered.setup;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.item.v1.BlockTransformerHelper;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.CookingFuel;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.storage.loot.providers.number.floats.ResolvableFloat;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.minecraft.world.level.storage.loot.providers.number.ints.ResolvableInt;
import net.redchujelly.cluttered.platform.BusGroup;
import net.redchujelly.cluttered.platform.DeferredRegister;
import net.redchujelly.cluttered.platform.FabricRegistries;
import net.redchujelly.cluttered.platform.RegistryObject;
import net.redchujelly.cluttered.Cluttered;
import net.redchujelly.cluttered.block.custom.*;
import net.redchujelly.cluttered.block.custom.food.BerryCakeBlock;
import net.redchujelly.cluttered.block.custom.food.HeartCakeBlock;
import net.redchujelly.cluttered.block.custom.food.PastryBlock;
import net.redchujelly.cluttered.block.custom.food.PastryPlateBlock;
import net.redchujelly.cluttered.block.custom.furniture.*;
import net.redchujelly.cluttered.block.custom.furniture.storage.*;
import net.redchujelly.cluttered.block.multiblock.*;
import net.redchujelly.cluttered.block.multiblock.storage.ChinaCabinetBlock;
import net.redchujelly.cluttered.block.multiblock.storage.*;
import net.redchujelly.cluttered.util.ClutteredWoodTypes;
import net.redchujelly.cluttered.worldgen.tree.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlockRegistration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(FabricRegistries.BLOCKS, Cluttered.MODID);
    private static final ResourceKey<ContextIntProvider> COMPOSTABLE_VERY_LOW = ResourceKey.create(
            Registries.CONTEXT_INT_PROVIDER,
            Identifier.fromNamespaceAndPath(Cluttered.MODID, "compostable/very_low"));


    //WILLOW WOODSET
    public static final RegistryObject<Block> WILLOW_LOG = registerFuelBlock("willow_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("willow_log")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> STRIPPED_WILLOW_LOG = registerFuelBlock("stripped_willow_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(BLOCKS.key("stripped_willow_log")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_WOOD = registerFuelBlock("willow_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("willow_wood")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> STRIPPED_WILLOW_WOOD = registerFuelBlock("stripped_willow_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(BLOCKS.key("stripped_willow_wood")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_PLANKS = registerFuelBlock("willow_planks",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("willow_planks")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_SLAB = registerFuelBlock("willow_slab",
            () -> new CustomWoodSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(BLOCKS.key("willow_slab")).mapColor(DyeColor.PURPLE)), 150);
    public static final RegistryObject<Block> WILLOW_STAIRS = registerFuelBlock("willow_stairs",
            () -> new CustomWoodStairs(() -> BlockRegistration.WILLOW_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(BLOCKS.key("willow_stairs")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_FENCE = registerFuelBlock("willow_fence",
            () -> new CustomWoodFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(BLOCKS.key("willow_fence")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_FENCE_GATE = registerFuelBlock("willow_fence_gate",
            () -> new CustomWoodFenceGate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(BLOCKS.key("willow_fence_gate")).mapColor(DyeColor.PURPLE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE), 300);
    public static final RegistryObject<Block> WILLOW_LOG_DOOR = registerFuelBlock("willow_log_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("willow_log_door")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_GARDEN_DOOR = registerFuelBlock("willow_garden_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("willow_garden_door")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_DOOR = registerFuelBlock("willow_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("willow_door")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_TRAPDOOR = registerFuelBlock("willow_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(BLOCKS.key("willow_trapdoor")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_BUTTON = registerFuelBlock("willow_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("willow_button")).mapColor(DyeColor.PURPLE)), 100);
    public static final RegistryObject<Block> WILLOW_PRESSURE_PLATE = registerFuelBlock("willow_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("willow_pressure_plate")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_LEAVES = registerBlock("willow_leaves",
            () -> new CustomLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(BLOCKS.key("willow_leaves")).mapColor(DyeColor.PURPLE)));
    public static final RegistryObject<Block> WILLOW_VINES = registerBlock("willow_vines",
            () -> new WillowVinesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.VINE).setId(BLOCKS.key("willow_vines")).mapColor(DyeColor.PURPLE)));
    public static final RegistryObject<Block> WILLOW_SAPLING = registerFuelBlock("willow_sapling",
            () -> new SaplingBlock(WillowTreeGrower.INSTANCE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(BLOCKS.key("willow_sapling")).mapColor(DyeColor.PURPLE)), 100);
    public static final RegistryObject<Block> POTTED_WILLOW_SAPLING = BLOCKS.register("potted_willow_sapling",
            () -> new FlowerPotBlock(BlockRegistration.WILLOW_SAPLING.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BIRCH_SAPLING).setId(BLOCKS.key("potted_willow_sapling"))));

    public static final RegistryObject<Block> WILLOW_SIGN = BLOCKS.register("willow_sign",
            () -> new CustomStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(BLOCKS.key("willow_sign")).mapColor(DyeColor.PURPLE), ClutteredWoodTypes.WILLOW));
    public static final RegistryObject<Block> WILLOW_WALL_SIGN = BLOCKS.register("willow_wall_sign",
            () -> new CustomWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(BLOCKS.key("willow_wall_sign")).mapColor(DyeColor.PURPLE), ClutteredWoodTypes.WILLOW));
    public static final RegistryObject<Block> WILLOW_HANGING_SIGN = BLOCKS.register("willow_hanging_sign",
            () -> new CustomHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(BLOCKS.key("willow_hanging_sign")).mapColor(DyeColor.PURPLE), ClutteredWoodTypes.WILLOW));
    public static final RegistryObject<Block> WILLOW_WALL_HANGING_SIGN = BLOCKS.register("willow_wall_hanging_sign",
            () -> new CustomWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(BLOCKS.key("willow_wall_hanging_sign")).mapColor(DyeColor.PURPLE), ClutteredWoodTypes.WILLOW));

    public static final RegistryObject<Block> WILLOW_BOOKSHELF_BLACK_CAT = registerFuelBlock("willow_bookshelf_black_cat",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("willow_bookshelf_black_cat")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_BOOKSHELF_CALICO_CAT = registerFuelBlock("willow_bookshelf_calico_cat",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("willow_bookshelf_calico_cat")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_BOOKSHELF_COBWEB = registerFuelBlock("willow_bookshelf_cobweb",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("willow_bookshelf_cobweb")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_BOOKSHELF_BOTTLES = registerFuelBlock("willow_bookshelf_bottles",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("willow_bookshelf_bottles")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_BOOKSHELF_VASE = registerFuelBlock("willow_bookshelf_vase",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("willow_bookshelf_vase")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> WILLOW_WINDOW = registerBlock("willow_window",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("willow_window")).mapColor(DyeColor.PURPLE).noOcclusion()));
    public static final RegistryObject<Block> WILLOW_WINDOW_PANE = registerBlock("willow_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).setId(BLOCKS.key("willow_window_pane")).mapColor(DyeColor.PURPLE).noOcclusion()));

    //FLOWERING WILLOW WOODSET
    public static final RegistryObject<Block> FLOWERING_WILLOW_LOG = registerFuelBlock("flowering_willow_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("flowering_willow_log")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> STRIPPED_FLOWERING_WILLOW_LOG = registerFuelBlock("stripped_flowering_willow_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("stripped_flowering_willow_log")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> FLOWERING_WILLOW_WOOD = registerFuelBlock("flowering_willow_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("flowering_willow_wood")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> STRIPPED_FLOWERING_WILLOW_WOOD = registerFuelBlock("stripped_flowering_willow_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("stripped_flowering_willow_wood")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> FLOWERING_WILLOW_PLANKS = registerFuelBlock("flowering_willow_planks",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("flowering_willow_planks")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> FLOWERING_WILLOW_SLAB = registerFuelBlock("flowering_willow_slab",
            () -> new CustomWoodSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(BLOCKS.key("flowering_willow_slab")).mapColor(DyeColor.PURPLE)), 150);
    public static final RegistryObject<Block> FLOWERING_WILLOW_STAIRS = registerFuelBlock("flowering_willow_stairs",
            () -> new CustomWoodStairs(() -> BlockRegistration.FLOWERING_WILLOW_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(BLOCKS.key("flowering_willow_stairs")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> FLOWERING_WILLOW_FENCE = registerFuelBlock("flowering_willow_fence",
            () -> new CustomWoodFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(BLOCKS.key("flowering_willow_fence")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> FLOWERING_WILLOW_FENCE_GATE = registerFuelBlock("flowering_willow_fence_gate",
            () -> new CustomWoodFenceGate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(BLOCKS.key("flowering_willow_fence_gate")).mapColor(DyeColor.PURPLE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE), 300);
    public static final RegistryObject<Block> FLOWERING_WILLOW_DOOR = registerFuelBlock("flowering_willow_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("flowering_willow_door")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> FLOWERING_WILLOW_TRAPDOOR = registerFuelBlock("flowering_willow_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(BLOCKS.key("flowering_willow_trapdoor")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> FLOWERING_WILLOW_BUTTON = registerFuelBlock("flowering_willow_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("flowering_willow_button")).mapColor(DyeColor.PURPLE)), 100);
    public static final RegistryObject<Block> FLOWERING_WILLOW_PRESSURE_PLATE = registerFuelBlock("flowering_willow_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("flowering_willow_pressure_plate")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> FLOWERING_WILLOW_LEAVES = registerBlock("flowering_willow_leaves",
            () -> new CustomLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(BLOCKS.key("flowering_willow_leaves")).mapColor(DyeColor.PURPLE)));
    public static final RegistryObject<Block> FLOWERING_WILLOW_WINDOW = registerBlock("flowering_willow_window",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("flowering_willow_window")).mapColor(DyeColor.PURPLE).noOcclusion()));
    public static final RegistryObject<Block> FLOWERING_WILLOW_WINDOW_PANE = registerBlock("flowering_willow_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).setId(BLOCKS.key("flowering_willow_window_pane")).mapColor(DyeColor.PURPLE).noOcclusion()));

    public static final RegistryObject<Block> FLOWERING_WILLOW_SIGN = BLOCKS.register("flowering_willow_sign",
            () -> new CustomStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(BLOCKS.key("flowering_willow_sign")).mapColor(DyeColor.PURPLE), ClutteredWoodTypes.FLOWERING_WILLOW));
    public static final RegistryObject<Block> FLOWERING_WILLOW_WALL_SIGN = BLOCKS.register("flowering_willow_wall_sign",
            () -> new CustomWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(BLOCKS.key("flowering_willow_wall_sign")).mapColor(DyeColor.PURPLE), ClutteredWoodTypes.FLOWERING_WILLOW));
    public static final RegistryObject<Block> FLOWERING_WILLOW_HANGING_SIGN = BLOCKS.register("flowering_willow_hanging_sign",
            () -> new CustomHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(BLOCKS.key("flowering_willow_hanging_sign")).mapColor(DyeColor.PURPLE), ClutteredWoodTypes.FLOWERING_WILLOW));
    public static final RegistryObject<Block> FLOWERING_WILLOW_WALL_HANGING_SIGN = BLOCKS.register("flowering_willow_wall_hanging_sign",
            () -> new CustomWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(BLOCKS.key("flowering_willow_wall_hanging_sign")).mapColor(DyeColor.PURPLE), ClutteredWoodTypes.FLOWERING_WILLOW));

    //POPLAR WOODSET
    public static final RegistryObject<Block> POPLAR_LOG = registerFuelBlock("poplar_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("poplar_log")).mapColor(DyeColor.YELLOW)), 300);
    public static final RegistryObject<Block> STRIPPED_POPLAR_LOG = registerFuelBlock("stripped_poplar_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("stripped_poplar_log")).mapColor(DyeColor.YELLOW)), 300);
    public static final RegistryObject<Block> POPLAR_WOOD = registerFuelBlock("poplar_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("poplar_wood")).mapColor(DyeColor.YELLOW)), 300);
    public static final RegistryObject<Block> STRIPPED_POPLAR_WOOD = registerFuelBlock("stripped_poplar_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("stripped_poplar_wood")).mapColor(DyeColor.YELLOW)), 300);
    public static final RegistryObject<Block> POPLAR_PLANKS = registerFuelBlock("poplar_planks",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("poplar_planks")).mapColor(DyeColor.YELLOW)), 300);
    public static final RegistryObject<Block> POPLAR_SLAB = registerFuelBlock("poplar_slab",
            () -> new CustomWoodSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(BLOCKS.key("poplar_slab")).mapColor(DyeColor.YELLOW)), 150);
    public static final RegistryObject<Block> POPLAR_STAIRS = registerFuelBlock("poplar_stairs",
            () -> new CustomWoodStairs(() -> BlockRegistration.POPLAR_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(BLOCKS.key("poplar_stairs")).mapColor(DyeColor.YELLOW)), 300);
    public static final RegistryObject<Block> POPLAR_FENCE = registerFuelBlock("poplar_fence",
            () -> new CustomWoodFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(BLOCKS.key("poplar_fence")).mapColor(DyeColor.YELLOW)), 300);
    public static final RegistryObject<Block> POPLAR_FENCE_GATE = registerFuelBlock("poplar_fence_gate",
            () -> new CustomWoodFenceGate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(BLOCKS.key("poplar_fence_gate")).mapColor(DyeColor.YELLOW), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE), 300);
    public static final RegistryObject<Block> POPLAR_DOOR = registerFuelBlock("poplar_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("poplar_door")).mapColor(DyeColor.YELLOW)), 300);
    public static final RegistryObject<Block> POPLAR_TRAPDOOR = registerFuelBlock("poplar_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(BLOCKS.key("poplar_trapdoor")).mapColor(DyeColor.YELLOW)), 300);
    public static final RegistryObject<Block> POPLAR_BUTTON = registerFuelBlock("poplar_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("poplar_button")).mapColor(DyeColor.YELLOW)), 100);
    public static final RegistryObject<Block> POPLAR_PRESSURE_PLATE = registerFuelBlock("poplar_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("poplar_pressure_plate")).mapColor(DyeColor.YELLOW)), 300);
    public static final RegistryObject<Block> POPLAR_BOOKSHELF = registerFuelBlock("poplar_bookshelf",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("poplar_bookshelf")).mapColor(DyeColor.YELLOW)), 300);
    public static final RegistryObject<Block> POPLAR_WINDOW = registerBlock("poplar_window",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("poplar_window")).mapColor(DyeColor.YELLOW).noOcclusion()));
    public static final RegistryObject<Block> POPLAR_WINDOW_PANE = registerBlock("poplar_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).setId(BLOCKS.key("poplar_window_pane")).mapColor(DyeColor.YELLOW).noOcclusion()));
    public static final RegistryObject<Block> POPLAR_LEAVES = registerBlock("poplar_leaves",
            () -> new CustomLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(BLOCKS.key("poplar_leaves")).mapColor(DyeColor.YELLOW)));
    public static final RegistryObject<Block> POPLAR_SAPLING = registerFuelBlock("poplar_sapling",
            () -> new SaplingBlock(PoplarTreeGrower.INSTANCE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(BLOCKS.key("poplar_sapling")).mapColor(DyeColor.YELLOW)), 100);
    public static final RegistryObject<Block> POTTED_POPLAR_SAPLING = BLOCKS.register("potted_poplar_sapling",
            () -> new FlowerPotBlock(BlockRegistration.POPLAR_SAPLING.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BIRCH_SAPLING).setId(BLOCKS.key("potted_poplar_sapling"))));
    
    public static final RegistryObject<Block> POPLAR_SIGN = BLOCKS.register("poplar_sign",
            () -> new CustomStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(BLOCKS.key("poplar_sign")).mapColor(DyeColor.YELLOW), ClutteredWoodTypes.POPLAR));
    public static final RegistryObject<Block> POPLAR_WALL_SIGN = BLOCKS.register("poplar_wall_sign",
            () -> new CustomWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(BLOCKS.key("poplar_wall_sign")).mapColor(DyeColor.YELLOW), ClutteredWoodTypes.POPLAR));
    public static final RegistryObject<Block> POPLAR_HANGING_SIGN = BLOCKS.register("poplar_hanging_sign",
            () -> new CustomHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(BLOCKS.key("poplar_hanging_sign")).mapColor(DyeColor.YELLOW), ClutteredWoodTypes.POPLAR));
    public static final RegistryObject<Block> POPLAR_WALL_HANGING_SIGN = BLOCKS.register("poplar_wall_hanging_sign",
            () -> new CustomWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(BLOCKS.key("poplar_wall_hanging_sign")).mapColor(DyeColor.YELLOW), ClutteredWoodTypes.POPLAR));


    //FLOWERING POPLAR WOODSET
    public static final RegistryObject<Block> FLOWERING_POPLAR_LOG = registerFuelBlock("flowering_poplar_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("flowering_poplar_log")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> STRIPPED_FLOWERING_POPLAR_LOG = registerFuelBlock("stripped_flowering_poplar_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("stripped_flowering_poplar_log")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_POPLAR_WOOD = registerFuelBlock("flowering_poplar_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("flowering_poplar_wood")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> STRIPPED_FLOWERING_POPLAR_WOOD = registerFuelBlock("stripped_flowering_poplar_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("stripped_flowering_poplar_wood")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_POPLAR_PLANKS = registerFuelBlock("flowering_poplar_planks",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("flowering_poplar_planks")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_POPLAR_SLAB = registerFuelBlock("flowering_poplar_slab",
            () -> new CustomWoodSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(BLOCKS.key("flowering_poplar_slab")).mapColor(DyeColor.PINK)), 150);
    public static final RegistryObject<Block> FLOWERING_POPLAR_STAIRS = registerFuelBlock("flowering_poplar_stairs",
            () -> new CustomWoodStairs(() -> BlockRegistration.FLOWERING_POPLAR_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(BLOCKS.key("flowering_poplar_stairs")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_POPLAR_FENCE = registerFuelBlock("flowering_poplar_fence",
            () -> new CustomWoodFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(BLOCKS.key("flowering_poplar_fence")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_POPLAR_FENCE_GATE = registerFuelBlock("flowering_poplar_fence_gate",
            () -> new CustomWoodFenceGate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(BLOCKS.key("flowering_poplar_fence_gate")).mapColor(DyeColor.PINK), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE), 300);
    public static final RegistryObject<Block> FLOWERING_POPLAR_DOOR = registerFuelBlock("flowering_poplar_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("flowering_poplar_door")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_POPLAR_TRAPDOOR = registerFuelBlock("flowering_poplar_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(BLOCKS.key("flowering_poplar_trapdoor")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_POPLAR_BUTTON = registerFuelBlock("flowering_poplar_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("flowering_poplar_button")).mapColor(DyeColor.PINK)), 100);
    public static final RegistryObject<Block> FLOWERING_POPLAR_PRESSURE_PLATE = registerFuelBlock("flowering_poplar_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("flowering_poplar_pressure_plate")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_POPLAR_BOOKSHELF = registerFuelBlock("flowering_poplar_bookshelf",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("flowering_poplar_bookshelf")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_POPLAR_WINDOW = registerBlock("flowering_poplar_window",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("flowering_poplar_window")).mapColor(DyeColor.PINK).noOcclusion()));
    public static final RegistryObject<Block> FLOWERING_POPLAR_WINDOW_PANE = registerBlock("flowering_poplar_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).setId(BLOCKS.key("flowering_poplar_window_pane")).mapColor(DyeColor.PINK).noOcclusion()));
    public static final RegistryObject<Block> FLOWERING_POPLAR_LEAVES = registerBlock("flowering_poplar_leaves",
            () -> new CustomLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(BLOCKS.key("flowering_poplar_leaves")).mapColor(DyeColor.PINK)));

    public static final RegistryObject<Block> FLOWERING_POPLAR_SIGN = BLOCKS.register("flowering_poplar_sign",
            () -> new CustomStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(BLOCKS.key("flowering_poplar_sign")).mapColor(DyeColor.YELLOW), ClutteredWoodTypes.FLOWERING_POPLAR));
    public static final RegistryObject<Block> FLOWERING_POPLAR_WALL_SIGN = BLOCKS.register("flowering_poplar_wall_sign",
            () -> new CustomWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(BLOCKS.key("flowering_poplar_wall_sign")).mapColor(DyeColor.YELLOW), ClutteredWoodTypes.FLOWERING_POPLAR));
    public static final RegistryObject<Block> FLOWERING_POPLAR_HANGING_SIGN = BLOCKS.register("flowering_poplar_hanging_sign",
            () -> new CustomHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(BLOCKS.key("flowering_poplar_hanging_sign")).mapColor(DyeColor.YELLOW), ClutteredWoodTypes.FLOWERING_POPLAR));
    public static final RegistryObject<Block> FLOWERING_POPLAR_WALL_HANGING_SIGN = BLOCKS.register("flowering_poplar_wall_hanging_sign",
            () -> new CustomWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(BLOCKS.key("flowering_poplar_wall_hanging_sign")).mapColor(DyeColor.YELLOW), ClutteredWoodTypes.FLOWERING_POPLAR));

    //CRABAPPLE WOODSET
    public static final RegistryObject<Block> CRABAPPLE_LOG = registerFuelBlock("crabapple_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("crabapple_log")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> STRIPPED_CRABAPPLE_LOG = registerFuelBlock("stripped_crabapple_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("stripped_crabapple_log")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> CRABAPPLE_WOOD = registerFuelBlock("crabapple_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("crabapple_wood")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> STRIPPED_CRABAPPLE_WOOD = registerFuelBlock("stripped_crabapple_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("stripped_crabapple_wood")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> CRABAPPLE_PLANKS = registerFuelBlock("crabapple_planks",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("crabapple_planks")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> CRABAPPLE_SLAB = registerFuelBlock("crabapple_slab",
            () -> new CustomWoodSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(BLOCKS.key("crabapple_slab")).mapColor(DyeColor.PINK)), 150);
    public static final RegistryObject<Block> CRABAPPLE_STAIRS = registerFuelBlock("crabapple_stairs",
            () -> new CustomWoodStairs(() -> BlockRegistration.CRABAPPLE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(BLOCKS.key("crabapple_stairs")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> CRABAPPLE_FENCE = registerFuelBlock("crabapple_fence",
            () -> new CustomWoodFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(BLOCKS.key("crabapple_fence")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> CRABAPPLE_FENCE_GATE = registerFuelBlock("crabapple_fence_gate",
            () -> new CustomWoodFenceGate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(BLOCKS.key("crabapple_fence_gate")).mapColor(DyeColor.PINK), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE), 300);
    public static final RegistryObject<Block> CRABAPPLE_DOOR = registerFuelBlock("crabapple_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("crabapple_door")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> CRABAPPLE_TRAPDOOR = registerFuelBlock("crabapple_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(BLOCKS.key("crabapple_trapdoor")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> CRABAPPLE_BUTTON = registerFuelBlock("crabapple_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("crabapple_button")).mapColor(DyeColor.PINK)), 100);
    public static final RegistryObject<Block> CRABAPPLE_PRESSURE_PLATE = registerFuelBlock("crabapple_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("crabapple_pressure_plate")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> CRABAPPLE_BOOKSHELF = registerFuelBlock("crabapple_bookshelf",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("crabapple_bookshelf")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> CRABAPPLE_WINDOW = registerBlock("crabapple_window",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("crabapple_window")).mapColor(DyeColor.PINK).noOcclusion()));
    public static final RegistryObject<Block> CRABAPPLE_WINDOW_PANE = registerBlock("crabapple_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).setId(BLOCKS.key("crabapple_window_pane")).mapColor(DyeColor.PINK).noOcclusion()));
    public static final RegistryObject<Block> CRABAPPLE_LEAVES = registerBlock("crabapple_leaves",
            () -> new CustomLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(BLOCKS.key("crabapple_leaves")).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> CRABAPPLE_SAPLING = registerFuelBlock("crabapple_sapling",
            () -> new SaplingBlock(CrabappleTreeGrower.INSTANCE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(BLOCKS.key("crabapple_sapling")).mapColor(DyeColor.PINK)), 100);
    public static final RegistryObject<Block> POTTED_CRABAPPLE_SAPLING = BLOCKS.register("potted_crabapple_sapling",
            () -> new FlowerPotBlock(BlockRegistration.CRABAPPLE_SAPLING.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BIRCH_SAPLING).setId(BLOCKS.key("potted_crabapple_sapling"))));

    public static final RegistryObject<Block> CRABAPPLE_SIGN = BLOCKS.register("crabapple_sign",
            () -> new CustomStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(BLOCKS.key("crabapple_sign")).mapColor(DyeColor.PINK), ClutteredWoodTypes.CRABAPPLE));
    public static final RegistryObject<Block> CRABAPPLE_WALL_SIGN = BLOCKS.register("crabapple_wall_sign",
            () -> new CustomWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(BLOCKS.key("crabapple_wall_sign")).mapColor(DyeColor.PINK), ClutteredWoodTypes.CRABAPPLE));
    public static final RegistryObject<Block> CRABAPPLE_HANGING_SIGN = BLOCKS.register("crabapple_hanging_sign",
            () -> new CustomHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(BLOCKS.key("crabapple_hanging_sign")).mapColor(DyeColor.PINK), ClutteredWoodTypes.CRABAPPLE));
    public static final RegistryObject<Block> CRABAPPLE_WALL_HANGING_SIGN = BLOCKS.register("crabapple_wall_hanging_sign",
            () -> new CustomWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(BLOCKS.key("crabapple_wall_hanging_sign")).mapColor(DyeColor.PINK), ClutteredWoodTypes.CRABAPPLE));

    //FLOWERING CRABAPPLE WOODSET
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_LOG = registerFuelBlock("flowering_crabapple_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("flowering_crabapple_log")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> STRIPPED_FLOWERING_CRABAPPLE_LOG = registerFuelBlock("stripped_flowering_crabapple_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("stripped_flowering_crabapple_log")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_WOOD = registerFuelBlock("flowering_crabapple_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("flowering_crabapple_wood")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> STRIPPED_FLOWERING_CRABAPPLE_WOOD = registerFuelBlock("stripped_flowering_crabapple_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("stripped_flowering_crabapple_wood")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_PLANKS = registerFuelBlock("flowering_crabapple_planks",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("flowering_crabapple_planks")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_SLAB = registerFuelBlock("flowering_crabapple_slab",
            () -> new CustomWoodSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(BLOCKS.key("flowering_crabapple_slab")).mapColor(DyeColor.PINK)), 150);
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_STAIRS = registerFuelBlock("flowering_crabapple_stairs",
            () -> new CustomWoodStairs(() -> BlockRegistration.FLOWERING_CRABAPPLE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(BLOCKS.key("flowering_crabapple_stairs")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_FENCE = registerFuelBlock("flowering_crabapple_fence",
            () -> new CustomWoodFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(BLOCKS.key("flowering_crabapple_fence")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_FENCE_GATE = registerFuelBlock("flowering_crabapple_fence_gate",
            () -> new CustomWoodFenceGate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(BLOCKS.key("flowering_crabapple_fence_gate")).mapColor(DyeColor.PINK), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE), 300);
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_DOOR = registerFuelBlock("flowering_crabapple_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("flowering_crabapple_door")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_TRAPDOOR = registerFuelBlock("flowering_crabapple_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(BLOCKS.key("flowering_crabapple_trapdoor")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_BUTTON = registerFuelBlock("flowering_crabapple_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("flowering_crabapple_button")).mapColor(DyeColor.PINK)), 100);
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_PRESSURE_PLATE = registerFuelBlock("flowering_crabapple_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("flowering_crabapple_pressure_plate")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_LEAVES = registerBlock("flowering_crabapple_leaves",
            () -> new CustomLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(BLOCKS.key("flowering_crabapple_leaves")).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_BOOKSHELF = registerFuelBlock("flowering_crabapple_bookshelf",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("flowering_crabapple_bookshelf")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_WINDOW = registerBlock("flowering_crabapple_window",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("flowering_crabapple_window")).mapColor(DyeColor.PINK).noOcclusion()));
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_WINDOW_PANE = registerBlock("flowering_crabapple_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).setId(BLOCKS.key("flowering_crabapple_window_pane")).mapColor(DyeColor.PINK).noOcclusion()));

    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_SIGN = BLOCKS.register("flowering_crabapple_sign",
            () -> new CustomStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(BLOCKS.key("flowering_crabapple_sign")).mapColor(DyeColor.PINK), ClutteredWoodTypes.FLOWERING_CRABAPPLE));
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_WALL_SIGN = BLOCKS.register("flowering_crabapple_wall_sign",
            () -> new CustomWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(BLOCKS.key("flowering_crabapple_wall_sign")).mapColor(DyeColor.PINK), ClutteredWoodTypes.FLOWERING_CRABAPPLE));
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_HANGING_SIGN = BLOCKS.register("flowering_crabapple_hanging_sign",
            () -> new CustomHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(BLOCKS.key("flowering_crabapple_hanging_sign")).mapColor(DyeColor.PINK), ClutteredWoodTypes.FLOWERING_CRABAPPLE));
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_WALL_HANGING_SIGN = BLOCKS.register("flowering_crabapple_wall_hanging_sign",
            () -> new CustomWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(BLOCKS.key("flowering_crabapple_wall_hanging_sign")).mapColor(DyeColor.PINK), ClutteredWoodTypes.FLOWERING_CRABAPPLE));


    //SYCAMORE WOODSET
    public static final RegistryObject<Block> SYCAMORE_LOG = registerFuelBlock("sycamore_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("sycamore_log")).mapColor(DyeColor.GREEN)), 300);
    public static final RegistryObject<Block> STRIPPED_SYCAMORE_LOG = registerFuelBlock("stripped_sycamore_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("stripped_sycamore_log")).mapColor(DyeColor.GREEN)), 300);
    public static final RegistryObject<Block> SYCAMORE_WOOD = registerFuelBlock("sycamore_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("sycamore_wood")).mapColor(DyeColor.GREEN)), 300);
    public static final RegistryObject<Block> STRIPPED_SYCAMORE_WOOD = registerFuelBlock("stripped_sycamore_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("stripped_sycamore_wood")).mapColor(DyeColor.GREEN)), 300);
    public static final RegistryObject<Block> SYCAMORE_PLANKS = registerFuelBlock("sycamore_planks",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("sycamore_planks")).mapColor(DyeColor.GREEN)), 300);
    public static final RegistryObject<Block> SYCAMORE_SLAB = registerFuelBlock("sycamore_slab",
            () -> new CustomWoodSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(BLOCKS.key("sycamore_slab")).mapColor(DyeColor.GREEN)), 150);
    public static final RegistryObject<Block> SYCAMORE_STAIRS = registerFuelBlock("sycamore_stairs",
            () -> new CustomWoodStairs(() -> BlockRegistration.SYCAMORE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(BLOCKS.key("sycamore_stairs")).mapColor(DyeColor.GREEN)), 300);
    public static final RegistryObject<Block> SYCAMORE_FENCE = registerFuelBlock("sycamore_fence",
            () -> new CustomWoodFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(BLOCKS.key("sycamore_fence")).mapColor(DyeColor.GREEN)), 300);
    public static final RegistryObject<Block> SYCAMORE_FENCE_GATE = registerFuelBlock("sycamore_fence_gate",
            () -> new CustomWoodFenceGate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(BLOCKS.key("sycamore_fence_gate")).mapColor(DyeColor.GREEN), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE), 300);
    public static final RegistryObject<Block> SYCAMORE_DOOR = registerFuelBlock("sycamore_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("sycamore_door")).mapColor(DyeColor.GREEN)), 300);
    public static final RegistryObject<Block> SYCAMORE_TRAPDOOR = registerFuelBlock("sycamore_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(BLOCKS.key("sycamore_trapdoor")).mapColor(DyeColor.GREEN)), 300);
    public static final RegistryObject<Block> SYCAMORE_BUTTON = registerFuelBlock("sycamore_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("sycamore_button")).mapColor(DyeColor.GREEN)), 100);
    public static final RegistryObject<Block> SYCAMORE_PRESSURE_PLATE = registerFuelBlock("sycamore_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("sycamore_pressure_plate")).mapColor(DyeColor.GREEN)), 300);
    public static final RegistryObject<Block> SYCAMORE_BOOKSHELF = registerFuelBlock("sycamore_bookshelf",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("sycamore_bookshelf")).mapColor(DyeColor.GREEN)), 300);
    public static final RegistryObject<Block> SYCAMORE_WINDOW = registerBlock("sycamore_window",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("sycamore_window")).mapColor(DyeColor.GREEN).noOcclusion()));
    public static final RegistryObject<Block> SYCAMORE_WINDOW_PANE = registerBlock("sycamore_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).setId(BLOCKS.key("sycamore_window_pane")).mapColor(DyeColor.GREEN).noOcclusion()));
    public static final RegistryObject<Block> SYCAMORE_LEAVES = registerBlock("sycamore_leaves",
            () -> new CustomLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(BLOCKS.key("sycamore_leaves")).mapColor(DyeColor.GREEN)));
    public static final RegistryObject<Block> SYCAMORE_SAPLING = registerFuelBlock("sycamore_sapling",
            () -> new SaplingBlock(SycamoreTreeGrower.INSTANCE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(BLOCKS.key("sycamore_sapling")).mapColor(DyeColor.GREEN)), 100);
    public static final RegistryObject<Block> POTTED_SYCAMORE_SAPLING = BLOCKS.register("potted_sycamore_sapling",
            () -> new FlowerPotBlock(BlockRegistration.SYCAMORE_SAPLING.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BIRCH_SAPLING).setId(BLOCKS.key("potted_sycamore_sapling"))));

    public static final RegistryObject<Block> SYCAMORE_SIGN = BLOCKS.register("sycamore_sign",
            () -> new CustomStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(BLOCKS.key("sycamore_sign")).mapColor(DyeColor.GREEN), ClutteredWoodTypes.SYCAMORE));
    public static final RegistryObject<Block> SYCAMORE_WALL_SIGN = BLOCKS.register("sycamore_wall_sign",
            () -> new CustomWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(BLOCKS.key("sycamore_wall_sign")).mapColor(DyeColor.GREEN), ClutteredWoodTypes.SYCAMORE));
    public static final RegistryObject<Block> SYCAMORE_HANGING_SIGN = BLOCKS.register("sycamore_hanging_sign",
            () -> new CustomHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(BLOCKS.key("sycamore_hanging_sign")).mapColor(DyeColor.GREEN), ClutteredWoodTypes.SYCAMORE));
    public static final RegistryObject<Block> SYCAMORE_WALL_HANGING_SIGN = BLOCKS.register("sycamore_wall_hanging_sign",
            () -> new CustomWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(BLOCKS.key("sycamore_wall_hanging_sign")).mapColor(DyeColor.GREEN), ClutteredWoodTypes.SYCAMORE));

    //FLUORESCENT MAPLE WOODSET
    public static final RegistryObject<Block> MAPLE_LOG = registerFuelBlock("fluorescent_maple_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("fluorescent_maple_log")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()), 300);
    public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = registerFuelBlock("stripped_fluorescent_maple_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("stripped_fluorescent_maple_log")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()), 300);
    public static final RegistryObject<Block> MAPLE_WOOD = registerFuelBlock("fluorescent_maple_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("fluorescent_maple_wood")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()), 300);
    public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = registerFuelBlock("stripped_fluorescent_maple_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("stripped_fluorescent_maple_wood")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()), 300);
    public static final RegistryObject<Block> MAPLE_PLANKS = registerFuelBlock("fluorescent_maple_planks",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("fluorescent_maple_planks")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()), 300);
    public static final RegistryObject<Block> MAPLE_SLAB = registerFuelBlock("fluorescent_maple_slab",
            () -> new CustomWoodSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(BLOCKS.key("fluorescent_maple_slab")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()), 150);
    public static final RegistryObject<Block> MAPLE_STAIRS = registerFuelBlock("fluorescent_maple_stairs",
            () -> new CustomWoodStairs(() -> BlockRegistration.MAPLE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(BLOCKS.key("fluorescent_maple_stairs")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()), 300);
    public static final RegistryObject<Block> MAPLE_FENCE = registerFuelBlock("fluorescent_maple_fence",
            () -> new CustomWoodFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(BLOCKS.key("fluorescent_maple_fence")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()), 300);
    public static final RegistryObject<Block> MAPLE_FENCE_GATE = registerFuelBlock("fluorescent_maple_fence_gate",
            () -> new CustomWoodFenceGate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(BLOCKS.key("fluorescent_maple_fence_gate")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion(), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE), 300);
    public static final RegistryObject<Block> MAPLE_DOOR = registerFuelBlock("fluorescent_maple_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("fluorescent_maple_door")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()), 300);
    public static final RegistryObject<Block> MAPLE_TRAPDOOR = registerFuelBlock("fluorescent_maple_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(BLOCKS.key("fluorescent_maple_trapdoor")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()), 300);
    public static final RegistryObject<Block> MAPLE_BUTTON = registerFuelBlock("fluorescent_maple_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("fluorescent_maple_button")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()), 100);
    public static final RegistryObject<Block> MAPLE_PRESSURE_PLATE = registerFuelBlock("fluorescent_maple_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("fluorescent_maple_pressure_plate")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()), 300);
    public static final RegistryObject<Block> MAPLE_BOOKSHELF = registerFuelBlock("fluorescent_maple_bookshelf",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("fluorescent_maple_bookshelf")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()), 300);
    public static final RegistryObject<Block> MAPLE_WINDOW = registerBlock("fluorescent_maple_window",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("fluorescent_maple_window")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()));
    public static final RegistryObject<Block> MAPLE_WINDOW_PANE = registerBlock("fluorescent_maple_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).setId(BLOCKS.key("fluorescent_maple_window_pane")).mapColor(DyeColor.CYAN).lightLevel(p -> 4).noOcclusion()));
    public static final RegistryObject<Block> MAPLE_LEAVES = registerBlock("fluorescent_maple_leaves",
            () -> new CustomLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(BLOCKS.key("fluorescent_maple_leaves")).mapColor(DyeColor.CYAN).lightLevel(p -> 4)));
    public static final RegistryObject<Block> MAPLE_LEAVES_FLOWERING = registerBlock("flowering_fluorescent_maple_leaves",
            () -> new CustomLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(BLOCKS.key("flowering_fluorescent_maple_leaves")).mapColor(DyeColor.CYAN).lightLevel(p -> 12)));
    public static final RegistryObject<Block> MAPLE_SAPLING = registerFuelBlock("fluorescent_maple_sapling",
            () -> new SaplingBlock(MapleTreeGrower.INSTANCE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(BLOCKS.key("fluorescent_maple_sapling")).lightLevel(p -> 6).mapColor(DyeColor.CYAN)), 100);
    public static final RegistryObject<Block> POTTED_MAPLE_SAPLING = BLOCKS.register("potted_fluorescent_maple_sapling",
            () -> new FlowerPotBlock(BlockRegistration.MAPLE_SAPLING.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BIRCH_SAPLING).setId(BLOCKS.key("potted_fluorescent_maple_sapling")).lightLevel(p -> 6)));

    public static final RegistryObject<Block> MAPLE_SIGN = BLOCKS.register("fluorescent_maple_sign",
            () -> new CustomStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(BLOCKS.key("fluorescent_maple_sign")).mapColor(DyeColor.CYAN).lightLevel(p -> 4), ClutteredWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_WALL_SIGN = BLOCKS.register("fluorescent_maple_wall_sign",
            () -> new CustomWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(BLOCKS.key("fluorescent_maple_wall_sign")).mapColor(DyeColor.CYAN).lightLevel(p -> 4), ClutteredWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_HANGING_SIGN = BLOCKS.register("fluorescent_maple_hanging_sign",
            () -> new CustomHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(BLOCKS.key("fluorescent_maple_hanging_sign")).mapColor(DyeColor.CYAN).lightLevel(p -> 4), ClutteredWoodTypes.MAPLE));
    public static final RegistryObject<Block> MAPLE_WALL_HANGING_SIGN = BLOCKS.register("fluorescent_maple_wall_hanging_sign",
            () -> new CustomWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(BLOCKS.key("fluorescent_maple_wall_hanging_sign")).mapColor(DyeColor.CYAN).lightLevel(p -> 4), ClutteredWoodTypes.MAPLE));


    //BLUE MUSHROOM WOODSET
    public static final RegistryObject<Block> BLUE_MUSHROOM_LOG = registerFuelBlock("blue_mushroom_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("blue_mushroom_log")).mapColor(DyeColor.BLUE).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> BLUE_MUSHROOM_WOOD = registerFuelBlock("blue_mushroom_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("blue_mushroom_wood")).mapColor(DyeColor.BLUE).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> BLUE_MUSHROOM_PLANKS = registerFuelBlock("blue_mushroom_planks",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("blue_mushroom_planks")).mapColor(DyeColor.BLUE).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> BLUE_MUSHROOM_CAP = registerBlock("blue_mushroom_cap",
            () -> new BouncyMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM_BLOCK).setId(BLOCKS.key("blue_mushroom_cap")).mapColor(DyeColor.BLUE).sound(SoundType.SHROOMLIGHT).bounceRestitution(1.0F)));
    public static final RegistryObject<Block> BLUE_MUSHROOM_SAPLING = registerBlock("blue_roundhead",
            () -> new MushroomSaplingBlock(BlueMushroomTreeGrower.INSTANCE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(BLOCKS.key("blue_roundhead")).mapColor(DyeColor.BLUE)));
    public static final RegistryObject<Block> BLUE_MUSHROOM_SLAB = registerFuelBlock("blue_mushroom_slab",
            () -> new CustomWoodSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(BLOCKS.key("blue_mushroom_slab")).mapColor(DyeColor.BLUE).sound(SoundType.NETHER_WOOD)), 150);
    public static final RegistryObject<Block> BLUE_MUSHROOM_STAIRS = registerFuelBlock("blue_mushroom_stairs",
            () -> new CustomWoodStairs(() -> BlockRegistration.BLUE_MUSHROOM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(BLOCKS.key("blue_mushroom_stairs")).mapColor(DyeColor.BLUE).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> BLUE_MUSHROOM_FENCE = registerFuelBlock("blue_mushroom_fence",
            () -> new CustomWoodFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(BLOCKS.key("blue_mushroom_fence")).mapColor(DyeColor.BLUE).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> BLUE_MUSHROOM_FENCE_GATE = registerFuelBlock("blue_mushroom_fence_gate",
            () -> new CustomWoodFenceGate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(BLOCKS.key("blue_mushroom_fence_gate")).mapColor(DyeColor.BLUE).sound(SoundType.NETHER_WOOD), SoundEvents.NETHER_WOOD_FENCE_GATE_OPEN, SoundEvents.NETHER_WOOD_FENCE_GATE_CLOSE), 300);
    public static final RegistryObject<Block> BLUE_MUSHROOM_DOOR = registerFuelBlock("blue_mushroom_door",
            () -> new DoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("blue_mushroom_door")).mapColor(DyeColor.BLUE).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> BLUE_MUSHROOM_TRAPDOOR = registerFuelBlock("blue_mushroom_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(BLOCKS.key("blue_mushroom_trapdoor")).mapColor(DyeColor.BLUE).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> BLUE_MUSHROOM_BUTTON = registerFuelBlock("blue_mushroom_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("blue_mushroom_button")).mapColor(DyeColor.BLUE).sound(SoundType.NETHER_WOOD)), 100);
    public static final RegistryObject<Block> BLUE_MUSHROOM_PRESSURE_PLATE = registerFuelBlock("blue_mushroom_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("blue_mushroom_pressure_plate")).mapColor(DyeColor.BLUE).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> BLUE_MUSHROOM_BOOKSHELF = registerFuelBlock("blue_mushroom_bookshelf",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("blue_mushroom_bookshelf")).mapColor(DyeColor.BLUE).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> BLUE_MUSHROOM_WINDOW = registerBlock("blue_mushroom_window",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("blue_mushroom_window")).mapColor(DyeColor.BLUE).noOcclusion()));
    public static final RegistryObject<Block> BLUE_MUSHROOM_WINDOW_PANE = registerBlock("blue_mushroom_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).setId(BLOCKS.key("blue_mushroom_window_pane")).mapColor(DyeColor.BLUE).noOcclusion()));
    public static final RegistryObject<Block> POTTED_BLUE_MUSHROOM_SAPLING = BLOCKS.register("potted_blue_roundhead",
            () -> new FlowerPotBlock(BlockRegistration.BLUE_MUSHROOM_SAPLING.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BIRCH_SAPLING).setId(BLOCKS.key("potted_blue_roundhead"))));

    public static final RegistryObject<Block> BLUE_MUSHROOM_SIGN = BLOCKS.register("blue_mushroom_sign",
            () -> new CustomStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SIGN).setId(BLOCKS.key("blue_mushroom_sign")).mapColor(DyeColor.BLUE), ClutteredWoodTypes.BLUE_MUSHROOM));
    public static final RegistryObject<Block> BLUE_MUSHROOM_WALL_SIGN = BLOCKS.register("blue_mushroom_wall_sign",
            () -> new CustomWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_WALL_SIGN).setId(BLOCKS.key("blue_mushroom_wall_sign")).mapColor(DyeColor.BLUE), ClutteredWoodTypes.BLUE_MUSHROOM));
    public static final RegistryObject<Block> BLUE_MUSHROOM_HANGING_SIGN = BLOCKS.register("blue_mushroom_hanging_sign",
            () -> new CustomHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_HANGING_SIGN).setId(BLOCKS.key("blue_mushroom_hanging_sign")).mapColor(DyeColor.BLUE), ClutteredWoodTypes.BLUE_MUSHROOM));
    public static final RegistryObject<Block> BLUE_MUSHROOM_WALL_HANGING_SIGN = BLOCKS.register("blue_mushroom_wall_hanging_sign",
            () -> new CustomWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_WALL_HANGING_SIGN).setId(BLOCKS.key("blue_mushroom_wall_hanging_sign")).mapColor(DyeColor.BLUE), ClutteredWoodTypes.BLUE_MUSHROOM));

    //RED MUSHROOM WOODSET
    public static final RegistryObject<Block> RED_MUSHROOM_LOG = registerFuelBlock("red_mushroom_log",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("red_mushroom_log")).mapColor(DyeColor.RED).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> RED_MUSHROOM_WOOD = registerFuelBlock("red_mushroom_wood",
            () -> new CustomLogLikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(BLOCKS.key("red_mushroom_wood")).mapColor(DyeColor.RED).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> RED_MUSHROOM_PLANKS = registerFuelBlock("red_mushroom_planks",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("red_mushroom_planks")).mapColor(DyeColor.RED).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> RED_MUSHROOM_CAP = registerFuelBlock("red_mushroom_cap",
            () -> new BouncyMushroomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("red_mushroom_cap")).mapColor(DyeColor.RED).sound(SoundType.SHROOMLIGHT).bounceRestitution(1.0F)), 300);
    public static final RegistryObject<Block> RED_MUSHROOM_SAPLING = registerBlock("fly_agaric",
            () -> new MushroomSaplingBlock(RedMushroomTreeGrower.INSTANCE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(BLOCKS.key("fly_agaric")).mapColor(DyeColor.RED)));
    public static final RegistryObject<Block> RED_MUSHROOM_SLAB = registerFuelBlock("red_mushroom_slab",
            () -> new CustomWoodSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(BLOCKS.key("red_mushroom_slab")).mapColor(DyeColor.RED).sound(SoundType.NETHER_WOOD)), 150);
    public static final RegistryObject<Block> RED_MUSHROOM_STAIRS = registerFuelBlock("red_mushroom_stairs",
            () -> new CustomWoodStairs(() -> BlockRegistration.RED_MUSHROOM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(BLOCKS.key("red_mushroom_stairs")).mapColor(DyeColor.RED).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> RED_MUSHROOM_FENCE = registerFuelBlock("red_mushroom_fence",
            () -> new CustomWoodFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(BLOCKS.key("red_mushroom_fence")).mapColor(DyeColor.RED).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> RED_MUSHROOM_FENCE_GATE = registerFuelBlock("red_mushroom_fence_gate",
            () -> new CustomWoodFenceGate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(BLOCKS.key("red_mushroom_fence_gate")).mapColor(DyeColor.RED).sound(SoundType.NETHER_WOOD), SoundEvents.NETHER_WOOD_FENCE_GATE_OPEN, SoundEvents.NETHER_WOOD_FENCE_GATE_CLOSE), 300);
    public static final RegistryObject<Block> RED_MUSHROOM_DOOR = registerFuelBlock("red_mushroom_door",
            () -> new DoorBlock(BlockSetType.CRIMSON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("red_mushroom_door")).mapColor(DyeColor.RED).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> RED_MUSHROOM_TRAPDOOR = registerFuelBlock("red_mushroom_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.CRIMSON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(BLOCKS.key("red_mushroom_trapdoor")).mapColor(DyeColor.RED).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> RED_MUSHROOM_BUTTON = registerFuelBlock("red_mushroom_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("red_mushroom_button")).mapColor(DyeColor.RED).sound(SoundType.NETHER_WOOD)), 100);
    public static final RegistryObject<Block> RED_MUSHROOM_PRESSURE_PLATE = registerFuelBlock("red_mushroom_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(BLOCKS.key("red_mushroom_pressure_plate")).mapColor(DyeColor.RED).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> RED_MUSHROOM_BOOKSHELF = registerFuelBlock("red_mushroom_bookshelf",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("red_mushroom_bookshelf")).mapColor(DyeColor.RED).sound(SoundType.NETHER_WOOD)), 300);
    public static final RegistryObject<Block> RED_MUSHROOM_WINDOW = registerBlock("red_mushroom_window",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("red_mushroom_window")).mapColor(DyeColor.RED).noOcclusion()));
    public static final RegistryObject<Block> RED_MUSHROOM_WINDOW_PANE = registerBlock("red_mushroom_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).setId(BLOCKS.key("red_mushroom_window_pane")).mapColor(DyeColor.RED).noOcclusion()));
    public static final RegistryObject<Block> POTTED_RED_MUSHROOM_SAPLING = BLOCKS.register("potted_fly_agaric",
            () -> new FlowerPotBlock(BlockRegistration.RED_MUSHROOM_SAPLING.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BIRCH_SAPLING).setId(BLOCKS.key("potted_fly_agaric"))));

    public static final RegistryObject<Block> RED_MUSHROOM_SIGN = BLOCKS.register("red_mushroom_sign",
            () -> new CustomStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SIGN).setId(BLOCKS.key("red_mushroom_sign")).mapColor(DyeColor.RED), ClutteredWoodTypes.RED_MUSHROOM));
    public static final RegistryObject<Block> RED_MUSHROOM_WALL_SIGN = BLOCKS.register("red_mushroom_wall_sign",
            () -> new CustomWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_SIGN).setId(BLOCKS.key("red_mushroom_wall_sign")).mapColor(DyeColor.RED), ClutteredWoodTypes.RED_MUSHROOM));
    public static final RegistryObject<Block> RED_MUSHROOM_HANGING_SIGN = BLOCKS.register("red_mushroom_hanging_sign",
            () -> new CustomHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_HANGING_SIGN).setId(BLOCKS.key("red_mushroom_hanging_sign")).mapColor(DyeColor.RED), ClutteredWoodTypes.RED_MUSHROOM));
    public static final RegistryObject<Block> RED_MUSHROOM_WALL_HANGING_SIGN = BLOCKS.register("red_mushroom_wall_hanging_sign",
            () -> new CustomWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_HANGING_SIGN).setId(BLOCKS.key("red_mushroom_wall_hanging_sign")).mapColor(DyeColor.RED), ClutteredWoodTypes.RED_MUSHROOM));


    //CHALCEDONY SET
    public static final RegistryObject<Block> CHALCEDONY = registerBlock("raw_chalcedony",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("raw_chalcedony")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_STAIRS = registerBlock("chalcedony_stairs",
            () -> new StairBlock(BlockRegistration.CHALCEDONY.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_STAIRS).setId(BLOCKS.key("chalcedony_stairs")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_SLAB = registerBlock("chalcedony_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_SLAB).setId(BLOCKS.key("chalcedony_slab")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_BRICKS = registerBlock("chalcedony_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("chalcedony_bricks")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_BRICK_STAIRS = registerBlock("chalcedony_brick_stairs",
            () -> new StairBlock(BlockRegistration.CHALCEDONY.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_STAIRS).setId(BLOCKS.key("chalcedony_brick_stairs")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_BRICK_SLAB = registerBlock("chalcedony_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_SLAB).setId(BLOCKS.key("chalcedony_brick_slab")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_TILES = registerBlock("chalcedony_tiles",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("chalcedony_tiles")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_SMALL_TILES = registerBlock("chalcedony_subway_tiles",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("chalcedony_subway_tiles")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> POLISHED_CHALCEDONY = registerBlock("chalcedony_polished",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("chalcedony_polished")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHISELED_CHALCEDONY = registerBlock("chalcedony_chiseled_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("chalcedony_chiseled_block")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_BORDER = registerBlock("chalcedony_border",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("chalcedony_border")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_ACANTHUS = registerBlock("chalcedony_acanthus",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("chalcedony_acanthus")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_HELIX = registerBlock("chalcedony_helix",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("chalcedony_helix")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_MEANDER = registerBlock("chalcedony_meander",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("chalcedony_meander")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> STARRY_CHISELED_CHALCEDONY = registerBlock("chalcedony_sun_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("chalcedony_sun_block")).mapColor(DyeColor.WHITE).lightLevel(p -> 10).noOcclusion()));
    public static final RegistryObject<Block> CHALCEDONY_PILLAR = registerBlock("chalcedony_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("chalcedony_pillar")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_PILLAR_BASE = registerBlock("chalcedony_pillar_base",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("chalcedony_pillar_base")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_PILLAR_DORIC = registerBlock("chalcedony_pillar_doric",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("chalcedony_pillar_doric")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_PILLAR_IONIC = registerBlock("chalcedony_pillar_ionic",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("chalcedony_pillar_ionic")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> STARRY_CHALCEDONY_PILLAR = registerBlock("chalcedony_pillar_starry",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("chalcedony_pillar_starry")).noOcclusion().mapColor(DyeColor.WHITE).lightLevel(p -> 7)));
    public static final RegistryObject<Block> STARRY_CHALCEDONY_PILLAR_BASE = registerBlock("chalcedony_pillar_starry_base",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("chalcedony_pillar_starry_base")).noOcclusion().mapColor(DyeColor.WHITE).lightLevel(p -> 7)));
    public static final RegistryObject<Block> STARRY_CHALCEDONY_PILLAR_DORIC = registerBlock("chalcedony_pillar_starry_doric",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("chalcedony_pillar_starry_doric")).noOcclusion().mapColor(DyeColor.WHITE).lightLevel(p -> 7)));
    public static final RegistryObject<Block> STARRY_CHALCEDONY_PILLAR_IONIC = registerBlock("chalcedony_pillar_starry_ionic",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("chalcedony_pillar_starry_ionic")).noOcclusion().mapColor(DyeColor.WHITE).lightLevel(p -> 7)));
    public static final RegistryObject<Block> CHALCEDONY_TEXTILES = registerBlock("textile_block_chalcedony",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("textile_block_chalcedony")).mapColor(DyeColor.WHITE)));

    public static final RegistryObject<Block> CHALCEDONY_BRACKET_VICTORIAN = registerBlock("chalcedony_victorian_bracket",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("chalcedony_victorian_bracket")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> CHALCEDONY_BRACKET_BOW = registerBlock("chalcedony_victorian_bracket_bow",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("chalcedony_victorian_bracket_bow")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> CHALCEDONY_BRACKET_BOW_SCROLL = registerBlock("chalcedony_victorian_bracket_bow_scroll",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("chalcedony_victorian_bracket_bow_scroll")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> CHALCEDONY_BRACKET_SCROLL = registerBlock("chalcedony_victorian_bracket_scroll",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("chalcedony_victorian_bracket_scroll")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> CHALCEDONY_BRACKET_STAR = registerBlock("chalcedony_victorian_bracket_star",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("chalcedony_victorian_bracket_star")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> CHALCEDONY_BRACKET_STAR_SCROLL = registerBlock("chalcedony_victorian_bracket_star_scroll",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("chalcedony_victorian_bracket_star_scroll")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> CHALCEDONY_BRACKET_SCROLL_SHELF = registerBlock("chalcedony_victorian_bracket_scroll_shelf",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("chalcedony_victorian_bracket_scroll_shelf")).mapColor(DyeColor.WHITE).noOcclusion()));

    public static final RegistryObject<Block> CHALCEDONY_WINDOW = registerBlock("chalcedony_window",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("chalcedony_window")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_WINDOW_PANE = registerBlock("chalcedony_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("chalcedony_window_pane")).mapColor(DyeColor.WHITE)));

    //DEEP CHALCEDONY SET
    public static final RegistryObject<Block> DEEP_CHALCEDONY = registerBlock("deep_raw_chalcedony",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("deep_raw_chalcedony")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_STAIRS = registerBlock("deep_chalcedony_stairs",
            () -> new StairBlock(BlockRegistration.DEEP_CHALCEDONY.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_STAIRS).setId(BLOCKS.key("deep_chalcedony_stairs")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_SLAB = registerBlock("deep_chalcedony_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_SLAB).setId(BLOCKS.key("deep_chalcedony_slab")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_BRICKS = registerBlock("deep_chalcedony_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("deep_chalcedony_bricks")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_BRICK_STAIRS = registerBlock("deep_chalcedony_brick_stairs",
            () -> new StairBlock(BlockRegistration.DEEP_CHALCEDONY.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_STAIRS).setId(BLOCKS.key("deep_chalcedony_brick_stairs")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_BRICK_SLAB = registerBlock("deep_chalcedony_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_SLAB).setId(BLOCKS.key("deep_chalcedony_brick_slab")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_TILES = registerBlock("deep_chalcedony_tiles",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("deep_chalcedony_tiles")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_SMALL_TILES = registerBlock("deep_chalcedony_subway_tiles",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("deep_chalcedony_subway_tiles")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_POLISHED_CHALCEDONY = registerBlock("deep_chalcedony_polished",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("deep_chalcedony_polished")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHISELED_CHALCEDONY = registerBlock("deep_chalcedony_chiseled_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("deep_chalcedony_chiseled_block")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_BORDER = registerBlock("deep_chalcedony_border",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("deep_chalcedony_border")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_ACANTHUS = registerBlock("deep_chalcedony_acanthus",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("deep_chalcedony_acanthus")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_HELIX = registerBlock("deep_chalcedony_helix",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("deep_chalcedony_helix")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_MEANDER = registerBlock("deep_chalcedony_meander",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("deep_chalcedony_meander")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_STARRY_CHISELED_CHALCEDONY = registerBlock("deep_chalcedony_sun_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("deep_chalcedony_sun_block")).mapColor(DyeColor.LIGHT_BLUE).lightLevel(p -> 10).noOcclusion()));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_PILLAR = registerBlock("deep_chalcedony_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("deep_chalcedony_pillar")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_PILLAR_BASE = registerBlock("deep_chalcedony_pillar_base",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("deep_chalcedony_pillar_base")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_PILLAR_DORIC = registerBlock("deep_chalcedony_pillar_doric",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("deep_chalcedony_pillar_doric")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_PILLAR_IONIC = registerBlock("deep_chalcedony_pillar_ionic",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("deep_chalcedony_pillar_ionic")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_STARRY_CHALCEDONY_PILLAR = registerBlock("deep_chalcedony_pillar_starry",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("deep_chalcedony_pillar_starry")).noOcclusion().mapColor(DyeColor.LIGHT_BLUE).lightLevel(p -> 7)));
    public static final RegistryObject<Block> DEEP_STARRY_CHALCEDONY_PILLAR_BASE = registerBlock("deep_chalcedony_pillar_starry_base",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("deep_chalcedony_pillar_starry_base")).noOcclusion().mapColor(DyeColor.LIGHT_BLUE).lightLevel(p -> 7)));
    public static final RegistryObject<Block> DEEP_STARRY_CHALCEDONY_PILLAR_DORIC = registerBlock("deep_chalcedony_pillar_starry_doric",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("deep_chalcedony_pillar_starry_doric")).noOcclusion().mapColor(DyeColor.LIGHT_BLUE).lightLevel(p -> 7)));
    public static final RegistryObject<Block> DEEP_STARRY_CHALCEDONY_PILLAR_IONIC = registerBlock("deep_chalcedony_pillar_starry_ionic",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("deep_chalcedony_pillar_starry_ionic")).noOcclusion().mapColor(DyeColor.LIGHT_BLUE).lightLevel(p -> 7)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_TEXTILES = registerBlock("textile_block_deep_chalcedony",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("textile_block_deep_chalcedony")).mapColor(DyeColor.LIGHT_BLUE)));

    public static final RegistryObject<Block> DEEP_CHALCEDONY_BRACKET_VICTORIAN = registerBlock("deep_chalcedony_victorian_bracket",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("deep_chalcedony_victorian_bracket")).mapColor(DyeColor.LIGHT_BLUE).noOcclusion()));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_BRACKET_BOW = registerBlock("deep_chalcedony_victorian_bracket_bow",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("deep_chalcedony_victorian_bracket_bow")).mapColor(DyeColor.LIGHT_BLUE).noOcclusion()));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_BRACKET_BOW_SCROLL = registerBlock("deep_chalcedony_victorian_bracket_bow_scroll",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("deep_chalcedony_victorian_bracket_bow_scroll")).mapColor(DyeColor.LIGHT_BLUE).noOcclusion()));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_BRACKET_SCROLL = registerBlock("deep_chalcedony_victorian_bracket_scroll",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("deep_chalcedony_victorian_bracket_scroll")).mapColor(DyeColor.LIGHT_BLUE).noOcclusion()));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_BRACKET_STAR = registerBlock("deep_chalcedony_victorian_bracket_star",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("deep_chalcedony_victorian_bracket_star")).mapColor(DyeColor.LIGHT_BLUE).noOcclusion()));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_BRACKET_STAR_SCROLL = registerBlock("deep_chalcedony_victorian_bracket_star_scroll",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("deep_chalcedony_victorian_bracket_star_scroll")).mapColor(DyeColor.LIGHT_BLUE).noOcclusion()));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_BRACKET_SCROLL_SHELF = registerBlock("deep_chalcedony_victorian_bracket_scroll_shelf",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("deep_chalcedony_victorian_bracket_scroll_shelf")).mapColor(DyeColor.LIGHT_BLUE).noOcclusion()));


    public static final RegistryObject<Block> DEEP_CHALCEDONY_WINDOW = registerBlock("deep_chalcedony_window",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("deep_chalcedony_window")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_WINDOW_PANE = registerBlock("deep_chalcedony_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("deep_chalcedony_window_pane")).mapColor(DyeColor.LIGHT_BLUE)));
    //MARBLE SET
    public static final RegistryObject<Block> MARBLE = registerBlock("raw_marble",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("raw_marble")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_STAIRS = registerBlock("marble_stairs",
            () -> new StairBlock(BlockRegistration.MARBLE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_STAIRS).setId(BLOCKS.key("marble_stairs")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_SLAB = registerBlock("marble_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_SLAB).setId(BLOCKS.key("marble_slab")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_BRICKS = registerBlock("marble_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("marble_bricks")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_BRICK_STAIRS = registerBlock("marble_brick_stairs",
            () -> new StairBlock(BlockRegistration.MARBLE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_STAIRS).setId(BLOCKS.key("marble_brick_stairs")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_BRICK_SLAB = registerBlock("marble_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_SLAB).setId(BLOCKS.key("marble_brick_slab")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_TILES = registerBlock("marble_tiles",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("marble_tiles")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_SMALL_TILES = registerBlock("marble_subway_tiles",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("marble_subway_tiles")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> POLISHED_MARBLE = registerBlock("marble_polished",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("marble_polished")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHISELED_MARBLE = registerBlock("marble_chiseled_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("marble_chiseled_block")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_BORDER = registerBlock("marble_border",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("marble_border")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_ACANTHUS = registerBlock("marble_acanthus",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("marble_acanthus")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_HELIX = registerBlock("marble_helix",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("marble_helix")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_MEANDER = registerBlock("marble_meander",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("marble_meander")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> STARRY_CHISELED_MARBLE = registerBlock("marble_sun_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("marble_sun_block")).mapColor(DyeColor.WHITE).lightLevel(p -> 10).noOcclusion()));
    public static final RegistryObject<Block> MARBLE_PILLAR = registerBlock("marble_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("marble_pillar")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_PILLAR_BASE = registerBlock("marble_pillar_base",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("marble_pillar_base")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_PILLAR_DORIC = registerBlock("marble_pillar_doric",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("marble_pillar_doric")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_PILLAR_IONIC = registerBlock("marble_pillar_ionic",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("marble_pillar_ionic")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_TEXTILES = registerBlock("textile_block_marble",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(BLOCKS.key("textile_block_marble")).mapColor(DyeColor.WHITE)));

    public static final RegistryObject<Block> MARBLE_BRACKET_VICTORIAN = registerBlock("marble_victorian_bracket",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("marble_victorian_bracket")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> MARBLE_BRACKET_BOW = registerBlock("marble_victorian_bracket_bow",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("marble_victorian_bracket_bow")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> MARBLE_BRACKET_BOW_SCROLL = registerBlock("marble_victorian_bracket_bow_scroll",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("marble_victorian_bracket_bow_scroll")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> MARBLE_BRACKET_SCROLL = registerBlock("marble_victorian_bracket_scroll",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("marble_victorian_bracket_scroll")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> MARBLE_BRACKET_STAR = registerBlock("marble_victorian_bracket_star",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("marble_victorian_bracket_star")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> MARBLE_BRACKET_STAR_SCROLL = registerBlock("marble_victorian_bracket_star_scroll",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("marble_victorian_bracket_star_scroll")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> MARBLE_BRACKET_SCROLL_SHELF = registerBlock("marble_victorian_bracket_scroll_shelf",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("marble_victorian_bracket_scroll_shelf")).mapColor(DyeColor.WHITE).noOcclusion()));

    public static final RegistryObject<Block> WOODEN_BRACKET_VICTORIAN = registerBlock("wooden_victorian_bracket",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("wooden_victorian_bracket")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> WOODEN_BRACKET_BOW = registerBlock("wooden_victorian_bracket_bow",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("wooden_victorian_bracket_bow")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> WOODEN_BRACKET_BOW_SCROLL = registerBlock("wooden_victorian_bracket_bow_scroll",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("wooden_victorian_bracket_bow_scroll")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> WOODEN_BRACKET_SCROLL = registerBlock("wooden_victorian_bracket_scroll",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("wooden_victorian_bracket_scroll")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> WOODEN_BRACKET_STAR = registerBlock("wooden_victorian_bracket_star",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("wooden_victorian_bracket_star")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> WOODEN_BRACKET_STAR_SCROLL = registerBlock("wooden_victorian_bracket_star_scroll",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("wooden_victorian_bracket_star_scroll")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> WOODEN_BRACKET_SCROLL_SHELF = registerBlock("wooden_victorian_bracket_scroll_shelf",
            () -> new BracketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("wooden_victorian_bracket_scroll_shelf")).mapColor(DyeColor.BROWN).noOcclusion()));

    //MISC FULL BLOCKS
    //CAT WINDOWS
    public static final RegistryObject<Block> BLACK_CAT_WINDOW = registerBlock("black_cat_window",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("black_cat_window"))));
    public static final RegistryObject<Block> BLACK_CAT_WINDOW_PANE = registerBlock("black_cat_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).setId(BLOCKS.key("black_cat_window_pane"))));

    //PLANTER BOXES
    public static final RegistryObject<Block> YELLOW_PLANTER = registerBlock("tarrey_town_planter_yellow",
            () -> new PlanterBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FARMLAND).setId(BLOCKS.key("tarrey_town_planter_yellow")).mapColor(DyeColor.YELLOW).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PINK_PLANTER = registerBlock("tarrey_town_planter_pink",
            () -> new PlanterBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FARMLAND).setId(BLOCKS.key("tarrey_town_planter_pink")).mapColor(DyeColor.PINK).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GREEN_PLANTER = registerBlock("tarrey_town_planter_green",
            () -> new PlanterBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FARMLAND).setId(BLOCKS.key("tarrey_town_planter_green")).mapColor(DyeColor.GREEN).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PURPLE_PLANTER = registerBlock("tarrey_town_planter_purple",
            () -> new PlanterBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FARMLAND).setId(BLOCKS.key("tarrey_town_planter_purple")).mapColor(DyeColor.PURPLE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FLUORESCENT_PLANTER = registerBlock("tarrey_town_planter_fluorescent",
            () -> new PlanterBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FARMLAND).setId(BLOCKS.key("tarrey_town_planter_fluorescent")).mapColor(DyeColor.LIGHT_BLUE).sound(SoundType.WOOD).noOcclusion().lightLevel(p -> 4)));
    public static final RegistryObject<Block> BEIGE_PLANTER = registerBlock("tarrey_town_planter_beige",
            () -> new PlanterBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FARMLAND).setId(BLOCKS.key("tarrey_town_planter_beige")).mapColor(DyeColor.LIGHT_GRAY).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BLUE_PLANTER = registerBlock("tarrey_town_planter_blue",
            () -> new PlanterBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FARMLAND).setId(BLOCKS.key("tarrey_town_planter_blue")).mapColor(DyeColor.BLUE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> RED_PLANTER = registerBlock("tarrey_town_planter_red",
            () -> new PlanterBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FARMLAND).setId(BLOCKS.key("tarrey_town_planter_red")).mapColor(DyeColor.RED).sound(SoundType.WOOD)));

    //WALLPAPERS
    public static final RegistryObject<Block> STARRY_WALLPAPER = registerBlock("starry_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("starry_wallpaper")).sound(SoundType.SPORE_BLOSSOM).lightLevel(p -> 4).noOcclusion()));
    public static final RegistryObject<Block> STARRY_WALLPAPER_TOP = registerBlock("starry_wallpaper_upper_trim",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("starry_wallpaper_upper_trim")).sound(SoundType.SPORE_BLOSSOM).lightLevel(p -> 4).noOcclusion()));
    public static final RegistryObject<Block> STARRY_WALLPAPER_BOTTOM = registerBlock("starry_wallpaper_lower_trim",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("starry_wallpaper_lower_trim")).sound(SoundType.SPORE_BLOSSOM).lightLevel(p -> 4).noOcclusion()));
    public static final RegistryObject<Block> DARK_STARRY_WALLPAPER = registerBlock("dark_starry_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("dark_starry_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DARK_STARRY_WALLPAPER_TOP = registerBlock("dark_starry_wallpaper_upper_trim",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("dark_starry_wallpaper_upper_trim")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DARK_STARRY_WALLPAPER_BOTTOM = registerBlock("dark_starry_wallpaper_lower_trim",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("dark_starry_wallpaper_lower_trim")).sound(SoundType.SPORE_BLOSSOM)));

    public static final RegistryObject<Block> RETRO_RAINBOW_WALLPAPER = registerBlock("retro_rainbow_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).setId(BLOCKS.key("retro_rainbow_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> APPLE_WALLPAPER = registerBlock("apple_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GREEN)).setId(BLOCKS.key("apple_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> BLUE_ROSE_STRIPED_WALLPAPER = registerBlock("blue_rose_striped_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("blue_rose_striped_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> CHECKERED_FRUIT_WALLPAPER = registerBlock("checkered_fruit_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GREEN)).setId(BLOCKS.key("checkered_fruit_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> CHECKERED_GREEN_WALLPAPER = registerBlock("checkered_green_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GREEN)).setId(BLOCKS.key("checkered_green_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> CHECKERED_GREEN_STRAWBERRY_WALLPAPER = registerBlock("checkered_green_strawberry_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GREEN)).setId(BLOCKS.key("checkered_green_strawberry_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> CHECKERED_PINK_WALLPAPER = registerBlock("checkered_pink_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("checkered_pink_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> CHECKERED_PINK_STRAWBERRY_WALLPAPER = registerBlock("checkered_pink_strawberry_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("checkered_pink_strawberry_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> CHIC_WALLPAPER = registerBlock("chic_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("chic_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> CHIC_WALLPAPER_UPPER_TRIM = registerBlock("chic_wallpaper_upper_trim",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("chic_wallpaper_upper_trim")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> CHIC_WALLPAPER_LOWER_TRIM = registerBlock("chic_wallpaper_lower_trim",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("chic_wallpaper_lower_trim")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> CONFECTIONARY_WALLPAPER = registerBlock("confectionary_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("confectionary_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> FLORAL_BERRY_WALLPAPER = registerBlock("floral_berry_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("floral_berry_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> FLORAL_BORDER_WALLPAPER = registerBlock("floral_border_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GREEN)).setId(BLOCKS.key("floral_border_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> GHOST_WALLPAPER = registerBlock("ghost_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("ghost_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> GHOST_WALLPAPER_TRIM = registerBlock("ghost_wallpaper_trim",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("ghost_wallpaper_trim")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> GHOST_WALLPAPER_BOTTOM = registerBlock("ghost_wallpaper_bottom",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("ghost_wallpaper_bottom")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> GHOST_WALLPAPER_TOP = registerBlock("ghost_wallpaper_top",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("ghost_wallpaper_top")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> GHOST_WALLPAPER_WAINSCOTING = registerBlock("ghost_wallpaper_wainscoting",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("ghost_wallpaper_wainscoting")).mapColor(DyeColor.PURPLE)));
    public static final RegistryObject<Block> HALLOWEEN_WALLPAPER = registerBlock("halloween_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).setId(BLOCKS.key("halloween_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> HALLOWEEN_WALLPAPER_BOTTOM = registerBlock("halloween_wallpaper_bottom",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).setId(BLOCKS.key("halloween_wallpaper_bottom")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> HALLOWEEN_WALLPAPER_TOP = registerBlock("halloween_wallpaper_top",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).setId(BLOCKS.key("halloween_wallpaper_top")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> HALLOWEEN_WAINSCOTING = registerBlock("halloween_wainscoting",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("halloween_wainscoting")).mapColor(DyeColor.PURPLE)));
    public static final RegistryObject<Block> RIALTO_GOLD_WALLPAPER = registerBlock("rialto_gold_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("rialto_gold_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> RIALTO_GOLD_WALLPAPER_TOP = registerBlock("rialto_wallpaper_upper_trim",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("rialto_wallpaper_upper_trim")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> RIALTO_GOLD_WALLPAPER_BOTTOM = registerBlock("rialto_wallpaper_lower_trim",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("rialto_wallpaper_lower_trim")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> MARIGOLD_WALLPAPER = registerBlock("marigold_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("marigold_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> MARIGOLD_WALLPAPER_BOTTOM = registerBlock("marigold_wallpaper_bottom",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("marigold_wallpaper_bottom")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> MARIGOLD_WALLPAPER_TOP = registerBlock("marigold_wallpaper_top",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("marigold_wallpaper_top")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> MINT_WALLPAPER = registerBlock("mint_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("mint_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> PINK_STRIPE_WALLPAPER = registerBlock("pink_striped_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("pink_striped_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> PINK_STRIPE_WALLPAPER_LOWER_TRIM = registerBlock("pink_striped_wallpaper_lower_trim",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("pink_striped_wallpaper_lower_trim")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> PINK_STRIPE_WALLPAPER_UPPER_TRIM = registerBlock("pink_striped_wallpaper_upper_trim",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("pink_striped_wallpaper_upper_trim")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> FISH_WALLPAPER = registerBlock("fish_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("fish_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> TROPICAL_FISH_WALLPAPER = registerBlock("fish_wallpaper_tropical",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIGHT_BLUE)).setId(BLOCKS.key("fish_wallpaper_tropical")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> TARTAN_YELLOW_WALLPAPER = registerBlock("tartan_yellow_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("tartan_yellow_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));


    //DIAMOND WALLPAPER
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_APPLE = registerBlock("diamond_wallpaper_apple",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_apple")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_APPLE_BOTTOM_BROWN = registerBlock("diamond_wallpaper_apple_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_apple_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_APPLE_TOP_BROWN = registerBlock("diamond_wallpaper_apple_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_apple_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_APPLE_BOTTOM_WHITE = registerBlock("diamond_wallpaper_apple_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_apple_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_APPLE_TOP_WHITE = registerBlock("diamond_wallpaper_apple_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_apple_top_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_APPLE_BOTTOM_COLOR = registerBlock("diamond_wallpaper_apple_bottom_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_apple_bottom_color")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_APPLE_TOP_COLOR = registerBlock("diamond_wallpaper_apple_top_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_apple_top_color")).sound(SoundType.SPORE_BLOSSOM)));

    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BLACKBERRY = registerBlock("diamond_wallpaper_blackberry",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_blackberry")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BLACKBERRY_BOTTOM_BROWN = registerBlock("diamond_wallpaper_blackberry_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_blackberry_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BLACKBERRY_TOP_BROWN = registerBlock("diamond_wallpaper_blackberry_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_blackberry_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BLACKBERRY_BOTTOM_WHITE = registerBlock("diamond_wallpaper_blackberry_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_blackberry_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BLACKBERRY_TOP_WHITE = registerBlock("diamond_wallpaper_blackberry_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_blackberry_top_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BLACKBERRY_BOTTOM_COLOR = registerBlock("diamond_wallpaper_blackberry_bottom_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_blackberry_bottom_color")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BLACKBERRY_TOP_COLOR = registerBlock("diamond_wallpaper_blackberry_top_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_blackberry_top_color")).sound(SoundType.SPORE_BLOSSOM)));

    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BLUEBERRY = registerBlock("diamond_wallpaper_blueberry",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("diamond_wallpaper_blueberry")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BLUEBERRY_BOTTOM_BROWN = registerBlock("diamond_wallpaper_blueberry_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("diamond_wallpaper_blueberry_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BLUEBERRY_TOP_BROWN = registerBlock("diamond_wallpaper_blueberry_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("diamond_wallpaper_blueberry_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BLUEBERRY_BOTTOM_WHITE = registerBlock("diamond_wallpaper_blueberry_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("diamond_wallpaper_blueberry_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BLUEBERRY_TOP_WHITE = registerBlock("diamond_wallpaper_blueberry_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("diamond_wallpaper_blueberry_top_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BLUEBERRY_BOTTOM_COLOR = registerBlock("diamond_wallpaper_blueberry_bottom_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("diamond_wallpaper_blueberry_bottom_color")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BLUEBERRY_TOP_COLOR = registerBlock("diamond_wallpaper_blueberry_top_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("diamond_wallpaper_blueberry_top_color")).sound(SoundType.SPORE_BLOSSOM)));

    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BONES = registerBlock("diamond_wallpaper_bones",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLACK)).setId(BLOCKS.key("diamond_wallpaper_bones")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BONES_BOTTOM_BROWN = registerBlock("diamond_wallpaper_bones_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLACK)).setId(BLOCKS.key("diamond_wallpaper_bones_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BONES_TOP_BROWN = registerBlock("diamond_wallpaper_bones_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLACK)).setId(BLOCKS.key("diamond_wallpaper_bones_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BONES_BOTTOM_WHITE = registerBlock("diamond_wallpaper_bones_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLACK)).setId(BLOCKS.key("diamond_wallpaper_bones_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BONES_TOP_WHITE = registerBlock("diamond_wallpaper_bones_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLACK)).setId(BLOCKS.key("diamond_wallpaper_bones_top_white")).sound(SoundType.SPORE_BLOSSOM)));

    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BOUQUET = registerBlock("diamond_wallpaper_bouquet",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.MAGENTA)).setId(BLOCKS.key("diamond_wallpaper_bouquet")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BOUQUET_BOTTOM_BROWN = registerBlock("diamond_wallpaper_bouquet_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.MAGENTA)).setId(BLOCKS.key("diamond_wallpaper_bouquet_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BOUQUET_TOP_BROWN = registerBlock("diamond_wallpaper_bouquet_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.MAGENTA)).setId(BLOCKS.key("diamond_wallpaper_bouquet_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BOUQUET_BOTTOM_WHITE = registerBlock("diamond_wallpaper_bouquet_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.MAGENTA)).setId(BLOCKS.key("diamond_wallpaper_bouquet_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BOUQUET_TOP_WHITE = registerBlock("diamond_wallpaper_bouquet_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.MAGENTA)).setId(BLOCKS.key("diamond_wallpaper_bouquet_top_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BOUQUET_BOTTOM_COLOR = registerBlock("diamond_wallpaper_bouquet_bottom_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.MAGENTA)).setId(BLOCKS.key("diamond_wallpaper_bouquet_bottom_color")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BOUQUET_TOP_COLOR = registerBlock("diamond_wallpaper_bouquet_top_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.MAGENTA)).setId(BLOCKS.key("diamond_wallpaper_bouquet_top_color")).sound(SoundType.SPORE_BLOSSOM)));

    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BROWN_MUSHROOM = registerBlock("diamond_wallpaper_brown_mushroom",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("diamond_wallpaper_brown_mushroom")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BROWN_MUSHROOM_BOTTOM_BROWN = registerBlock("diamond_wallpaper_brown_mushroom_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("diamond_wallpaper_brown_mushroom_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BROWN_MUSHROOM_TOP_BROWN = registerBlock("diamond_wallpaper_brown_mushroom_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("diamond_wallpaper_brown_mushroom_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BROWN_MUSHROOM_BOTTOM_WHITE = registerBlock("diamond_wallpaper_brown_mushroom_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("diamond_wallpaper_brown_mushroom_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BROWN_MUSHROOM_TOP_WHITE = registerBlock("diamond_wallpaper_brown_mushroom_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("diamond_wallpaper_brown_mushroom_top_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BROWN_MUSHROOM_BOTTOM_COLOR = registerBlock("diamond_wallpaper_brown_mushroom_bottom_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("diamond_wallpaper_brown_mushroom_bottom_color")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_BROWN_MUSHROOM_TOP_COLOR = registerBlock("diamond_wallpaper_brown_mushroom_top_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("diamond_wallpaper_brown_mushroom_top_color")).sound(SoundType.SPORE_BLOSSOM)));


    public static final RegistryObject<Block> DIAMOND_WALLPAPER_GREEN_GRAPES = registerBlock("diamond_wallpaper_green_grapes",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("diamond_wallpaper_green_grapes")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_GREEN_GRAPES_BOTTOM_BROWN = registerBlock("diamond_wallpaper_green_grapes_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("diamond_wallpaper_green_grapes_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_GREEN_GRAPES_TOP_BROWN = registerBlock("diamond_wallpaper_green_grapes_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("diamond_wallpaper_green_grapes_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_GREEN_GRAPES_BOTTOM_WHITE = registerBlock("diamond_wallpaper_green_grapes_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("diamond_wallpaper_green_grapes_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_GREEN_GRAPES_TOP_WHITE = registerBlock("diamond_wallpaper_green_grapes_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("diamond_wallpaper_green_grapes_top_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_GREEN_GRAPES_BOTTOM_COLOR = registerBlock("diamond_wallpaper_green_grapes_bottom_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("diamond_wallpaper_green_grapes_bottom_color")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_GREEN_GRAPES_TOP_COLOR = registerBlock("diamond_wallpaper_green_grapes_top_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("diamond_wallpaper_green_grapes_top_color")).sound(SoundType.SPORE_BLOSSOM)));

    public static final RegistryObject<Block> DIAMOND_WALLPAPER_LEMON = registerBlock("diamond_wallpaper_lemon",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("diamond_wallpaper_lemon")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_LEMON_BOTTOM_BROWN = registerBlock("diamond_wallpaper_lemon_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("diamond_wallpaper_lemon_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_LEMON_TOP_BROWN = registerBlock("diamond_wallpaper_lemon_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("diamond_wallpaper_lemon_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_LEMON_BOTTOM_WHITE = registerBlock("diamond_wallpaper_lemon_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("diamond_wallpaper_lemon_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_LEMON_TOP_WHITE = registerBlock("diamond_wallpaper_lemon_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("diamond_wallpaper_lemon_top_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_LEMON_BOTTOM_COLOR = registerBlock("diamond_wallpaper_lemon_bottom_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("diamond_wallpaper_lemon_bottom_color")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_LEMON_TOP_COLOR = registerBlock("diamond_wallpaper_lemon_top_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("diamond_wallpaper_lemon_top_color")).sound(SoundType.SPORE_BLOSSOM)));

    public static final RegistryObject<Block> DIAMOND_WALLPAPER_ORANGE = registerBlock("diamond_wallpaper_orange",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).setId(BLOCKS.key("diamond_wallpaper_orange")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_ORANGE_BOTTOM_BROWN = registerBlock("diamond_wallpaper_orange_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).setId(BLOCKS.key("diamond_wallpaper_orange_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_ORANGE_TOP_BROWN = registerBlock("diamond_wallpaper_orange_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).setId(BLOCKS.key("diamond_wallpaper_orange_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_ORANGE_BOTTOM_WHITE = registerBlock("diamond_wallpaper_orange_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).setId(BLOCKS.key("diamond_wallpaper_orange_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_ORANGE_TOP_WHITE = registerBlock("diamond_wallpaper_orange_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).setId(BLOCKS.key("diamond_wallpaper_orange_top_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_ORANGE_BOTTOM_COLOR = registerBlock("diamond_wallpaper_orange_bottom_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).setId(BLOCKS.key("diamond_wallpaper_orange_bottom_color")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_ORANGE_TOP_COLOR = registerBlock("diamond_wallpaper_orange_top_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).setId(BLOCKS.key("diamond_wallpaper_orange_top_color")).sound(SoundType.SPORE_BLOSSOM)));

    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PEAR = registerBlock("diamond_wallpaper_pear",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("diamond_wallpaper_pear")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PEAR_BOTTOM_BROWN = registerBlock("diamond_wallpaper_pear_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("diamond_wallpaper_pear_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PEAR_TOP_BROWN = registerBlock("diamond_wallpaper_pear_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("diamond_wallpaper_pear_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PEAR_BOTTOM_WHITE = registerBlock("diamond_wallpaper_pear_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("diamond_wallpaper_pear_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PEAR_TOP_WHITE = registerBlock("diamond_wallpaper_pear_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("diamond_wallpaper_pear_top_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PEAR_BOTTOM_COLOR = registerBlock("diamond_wallpaper_pear_bottom_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("diamond_wallpaper_pear_bottom_color")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PEAR_TOP_COLOR = registerBlock("diamond_wallpaper_pear_top_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("diamond_wallpaper_pear_top_color")).sound(SoundType.SPORE_BLOSSOM)));

    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PLUM = registerBlock("diamond_wallpaper_plum",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_plum")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PLUM_BOTTOM_BROWN = registerBlock("diamond_wallpaper_plum_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_plum_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PLUM_TOP_BROWN = registerBlock("diamond_wallpaper_plum_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_plum_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PLUM_BOTTOM_WHITE = registerBlock("diamond_wallpaper_plum_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_plum_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PLUM_TOP_WHITE = registerBlock("diamond_wallpaper_plum_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_plum_top_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PLUM_BOTTOM_COLOR = registerBlock("diamond_wallpaper_plum_bottom_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_plum_bottom_color")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PLUM_TOP_COLOR = registerBlock("diamond_wallpaper_plum_top_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_plum_top_color")).sound(SoundType.SPORE_BLOSSOM)));

    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PURPLE_GRAPES = registerBlock("diamond_wallpaper_purple_grapes",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_purple_grapes")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PURPLE_GRAPES_BOTTOM_BROWN = registerBlock("diamond_wallpaper_purple_grapes_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_purple_grapes_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PURPLE_GRAPES_TOP_BROWN = registerBlock("diamond_wallpaper_purple_grapes_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_purple_grapes_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PURPLE_GRAPES_BOTTOM_WHITE = registerBlock("diamond_wallpaper_purple_grapes_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_purple_grapes_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PURPLE_GRAPES_TOP_WHITE = registerBlock("diamond_wallpaper_purple_grapes_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_purple_grapes_top_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PURPLE_GRAPES_BOTTOM_COLOR = registerBlock("diamond_wallpaper_purple_grapes_bottom_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_purple_grapes_bottom_color")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_PURPLE_GRAPES_TOP_COLOR = registerBlock("diamond_wallpaper_purple_grapes_top_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("diamond_wallpaper_purple_grapes_top_color")).sound(SoundType.SPORE_BLOSSOM)));

    public static final RegistryObject<Block> DIAMOND_WALLPAPER_STRAWBERRY = registerBlock("diamond_wallpaper_strawberry",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_strawberry")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_STRAWBERRY_BOTTOM_BROWN = registerBlock("diamond_wallpaper_strawberry_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_strawberry_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_STRAWBERRY_TOP_BROWN = registerBlock("diamond_wallpaper_strawberry_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_strawberry_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_STRAWBERRY_BOTTOM_WHITE = registerBlock("diamond_wallpaper_strawberry_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_strawberry_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_STRAWBERRY_TOP_WHITE = registerBlock("diamond_wallpaper_strawberry_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_strawberry_top_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_STRAWBERRY_BOTTOM_COLOR = registerBlock("diamond_wallpaper_strawberry_bottom_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_strawberry_bottom_color")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_STRAWBERRY_TOP_COLOR = registerBlock("diamond_wallpaper_strawberry_top_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_strawberry_top_color")).sound(SoundType.SPORE_BLOSSOM)));

    public static final RegistryObject<Block> DIAMOND_WALLPAPER_RED_MUSHROOM = registerBlock("diamond_wallpaper_red_mushroom",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_red_mushroom")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_RED_MUSHROOM_BOTTOM_BROWN = registerBlock("diamond_wallpaper_red_mushroom_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_red_mushroom_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_RED_MUSHROOM_TOP_BROWN = registerBlock("diamond_wallpaper_red_mushroom_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_red_mushroom_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_RED_MUSHROOM_BOTTOM_WHITE = registerBlock("diamond_wallpaper_red_mushroom_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_red_mushroom_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_RED_MUSHROOM_TOP_WHITE = registerBlock("diamond_wallpaper_red_mushroom_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_red_mushroom_top_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_RED_MUSHROOM_BOTTOM_COLOR = registerBlock("diamond_wallpaper_red_mushroom_bottom_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_red_mushroom_bottom_color")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_RED_MUSHROOM_TOP_COLOR = registerBlock("diamond_wallpaper_red_mushroom_top_color",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("diamond_wallpaper_red_mushroom_top_color")).sound(SoundType.SPORE_BLOSSOM)));

    public static final RegistryObject<Block> DIAMOND_WALLPAPER_ANCHOR = registerBlock("diamond_wallpaper_anchor",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("diamond_wallpaper_anchor")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_ANCHOR_BOTTOM_BROWN = registerBlock("diamond_wallpaper_anchor_bottom_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("diamond_wallpaper_anchor_bottom_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_ANCHOR_TOP_BROWN = registerBlock("diamond_wallpaper_anchor_top_brown",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("diamond_wallpaper_anchor_top_brown")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_ANCHOR_BOTTOM_WHITE = registerBlock("diamond_wallpaper_anchor_bottom_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("diamond_wallpaper_anchor_bottom_white")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> DIAMOND_WALLPAPER_ANCHOR_TOP_WHITE = registerBlock("diamond_wallpaper_anchor_top_white",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("diamond_wallpaper_anchor_top_white")).sound(SoundType.SPORE_BLOSSOM)));

    //TODO ? WALLPAPER TRIMS
    public static final RegistryObject<Block> BLUE_ROSE_STRIPED_WALLPAPER_BOTTOM = registerBlock("blue_rose_striped_wallpaper_bottom",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("blue_rose_striped_wallpaper_bottom")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> BLUE_ROSE_STRIPED_WALLPAPER_TOP = registerBlock("blue_rose_striped_wallpaper_top",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("blue_rose_striped_wallpaper_top")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> CONFECTIONARY_WALLPAPER_BOTTOM = registerBlock("confectionary_wallpaper_bottom",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("confectionary_wallpaper_bottom")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> CONFECTIONARY_WALLPAPER_TOP = registerBlock("confectionary_wallpaper_top",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("confectionary_wallpaper_top")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> MINT_WALLPAPER_BOTTOM = registerBlock("mint_wallpaper_bottom",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GREEN)).setId(BLOCKS.key("mint_wallpaper_bottom")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> MINT_WALLPAPER_TOP = registerBlock("mint_wallpaper_top",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GREEN)).setId(BLOCKS.key("mint_wallpaper_top")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> STRIPED_FLORAL_WALLPAPER = registerBlock("striped_floral_wallpaper",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("striped_floral_wallpaper")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> STRIPED_FLORAL_WALLPAPER_BOTTOM = registerBlock("striped_floral_wallpaper_bottom",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("striped_floral_wallpaper_bottom")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> STRIPED_FLORAL_WALLPAPER_TOP = registerBlock("striped_floral_wallpaper_top",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("striped_floral_wallpaper_top")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> FLORAL_BERRY_WALLPAPER_BOTTOM = registerBlock("floral_berry_wallpaper_bottom",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("floral_berry_wallpaper_bottom")).sound(SoundType.SPORE_BLOSSOM)));
    public static final RegistryObject<Block> FLORAL_BERRY_WALLPAPER_TOP = registerBlock("floral_berry_wallpaper_top",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("floral_berry_wallpaper_top")).sound(SoundType.SPORE_BLOSSOM)));

    //WAINSCOTING
    public static final RegistryObject<Block> BLUE_WAINSCOTING = registerFuelBlock("blue_wainscoting",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("blue_wainscoting")).mapColor(DyeColor.BLUE)), 300);
    public static final RegistryObject<Block> BROWN_WAINSCOTING = registerFuelBlock("brown_wainscoting",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("brown_wainscoting")).mapColor(DyeColor.BLUE)), 300);
    public static final RegistryObject<Block> WILLOW_WAINSCOTING = registerFuelBlock("willow_wainscoting",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("willow_wainscoting")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> FLOWERING_WILLOW_WAINSCOTING = registerFuelBlock("flowering_willow_wainscoting",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("flowering_willow_wainscoting")).mapColor(DyeColor.PURPLE)), 300);
    public static final RegistryObject<Block> POPLAR_WAINSCOTING = registerFuelBlock("poplar_wainscoting",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("poplar_wainscoting")).mapColor(DyeColor.YELLOW)), 300);
    public static final RegistryObject<Block> FLOWERING_POPLAR_WAINSCOTING = registerFuelBlock("flowering_poplar_wainscoting",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("flowering_poplar_wainscoting")).mapColor(DyeColor.YELLOW)), 300);
    public static final RegistryObject<Block> CRABAPPLE_WAINSCOTING = registerFuelBlock("crabapple_wainscoting",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("crabapple_wainscoting")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> FLOWERING_CRABAPPLE_WAINSCOTING = registerFuelBlock("flowering_crabapple_wainscoting",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("flowering_crabapple_wainscoting")).mapColor(DyeColor.PINK)), 300);
    public static final RegistryObject<Block> SYCAMORE_WAINSCOTING = registerFuelBlock("sycamore_wainscoting",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("sycamore_wainscoting")).mapColor(DyeColor.GREEN)), 300);
    public static final RegistryObject<Block> MAPLE_WAINSCOTING = registerFuelBlock("fluorescent_maple_wainscoting",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("fluorescent_maple_wainscoting")).mapColor(DyeColor.LIGHT_BLUE).lightLevel(p -> 4).noOcclusion()), 300);
    public static final RegistryObject<Block> BLUE_MUSHROOM_WAINSCOTING = registerFuelBlock("blue_mushroom_wainscoting",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("blue_mushroom_wainscoting")).mapColor(DyeColor.BLUE).sound(SoundType.SHROOMLIGHT)), 300);
    public static final RegistryObject<Block> RED_MUSHROOM_WAINSCOTING = registerFuelBlock("red_mushroom_wainscoting",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("red_mushroom_wainscoting")).mapColor(DyeColor.RED).sound(SoundType.SHROOMLIGHT)), 300);
    public static final RegistryObject<Block> ALABASTER_WAINSCOTING = registerBlock("alabaster_wainscoting",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("alabaster_wainscoting"))));

    //BRICKS AND TILES
    public static final RegistryObject<Block> GINGERBREAD_BRICKS = registerBlock("gingerbread_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).setId(BLOCKS.key("gingerbread_bricks")).mapColor(DyeColor.BROWN).sound(SoundType.CHERRY_WOOD)));
    public static final RegistryObject<Block> GINGERBREAD_BRICKS_TOP = registerBlock("gingerbread_bricks_top",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).setId(BLOCKS.key("gingerbread_bricks_top")).mapColor(DyeColor.BROWN).sound(SoundType.CHERRY_WOOD)));
    public static final RegistryObject<Block> GINGERBREAD_BRICKS_SIDE = registerBlock("gingerbread_bricks_corner",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).setId(BLOCKS.key("gingerbread_bricks_corner")).mapColor(DyeColor.BROWN).sound(SoundType.CHERRY_WOOD)));
    public static final RegistryObject<Block> GINGERBREAD_BRICKS_TOP_CORNER = registerBlock("gingerbread_bricks_top_corner",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).setId(BLOCKS.key("gingerbread_bricks_top_corner")).mapColor(DyeColor.BROWN).sound(SoundType.CHERRY_WOOD)));
    public static final RegistryObject<Block> GINGERBREAD_BRICK_STAIRS = registerBlock("gingerbread_brick_stairs",
            () -> new StairBlock(BlockRegistration.GINGERBREAD_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_STAIRS).setId(BLOCKS.key("gingerbread_brick_stairs")).mapColor(DyeColor.BROWN).sound(SoundType.CHERRY_WOOD)));
    public static final RegistryObject<Block> GINGERBREAD_BRICK_SLAB = registerBlock("gingerbread_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).setId(BLOCKS.key("gingerbread_brick_slab")).mapColor(DyeColor.BROWN).sound(SoundType.CHERRY_WOOD)));

    public static final RegistryObject<Block> ESPERANCA_TILE = registerBlock("esperanca_tile",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("esperanca_tile")).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> LILIY_HILLS_TILE = registerBlock("lily_hills_tile",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("lily_hills_tile")).mapColor(DyeColor.BROWN)));
    public static final RegistryObject<Block> HANNISH_TILE = registerBlock("hannish_tile",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("hannish_tile")).mapColor(DyeColor.PURPLE)));
    public static final RegistryObject<Block> AURA_TILES = registerBlock("aura_tiles",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("aura_tiles")).mapColor(DyeColor.ORANGE)));
    public static final RegistryObject<Block> BIFURCATING_TILES = registerBlock("bifurcating_tiles",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("bifurcating_tiles")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> BLACK_AMARYLLIS_TILES = registerBlock("black_amaryllis_tiles",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("black_amaryllis_tiles")).mapColor(DyeColor.BLACK)));
    public static final RegistryObject<Block> ROSETTE_TILES = registerBlock("rosette_tiles",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("rosette_tiles")).mapColor(DyeColor.ORANGE)));
    public static final RegistryObject<Block> SEISMIC_TILES = registerBlock("seismic_tiles",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("seismic_tiles")).mapColor(DyeColor.LIGHT_GRAY)));

    public static final RegistryObject<Block> VERDANT_TILE = registerBlock("verdant_tile",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("verdant_tile")).mapColor(DyeColor.GREEN)));
    public static final RegistryObject<Block> VERDANT_TILE_EDGE = registerBlock("verdant_tile_edge",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("verdant_tile_edge")).mapColor(DyeColor.GREEN)));
    public static final RegistryObject<Block> VERDANT_TILE_CORNER = registerBlock("verdant_tile_corner",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("verdant_tile_corner")).mapColor(DyeColor.GREEN)));

    public static final RegistryObject<Block> MARBLE_TILE = registerBlock("marble_tile",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("marble_tile")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_TILE_CHISELED = registerBlock("marble_tile_chiseled",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("marble_tile_chiseled")).mapColor(DyeColor.YELLOW)));
    public static final RegistryObject<Block> MARBLE_TILE_BORDER = registerBlock("marble_tile_border",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("marble_tile_border")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_TILE_BORDER_CIRCLE = registerBlock("marble_tile_border_circle",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("marble_tile_border_circle")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_TILE_BORDER_DETAIL = registerBlock("marble_tile_border_detailed",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("marble_tile_border_detailed")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_TILE_CORNER = registerBlock("marble_tile_corner",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("marble_tile_corner")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_TILE_CORNER_CIRCLE = registerBlock("marble_tile_corner_circle",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("marble_tile_corner_circle")).mapColor(DyeColor.WHITE)));

    public static final RegistryObject<Block> IRIDESCENT_TILES = registerBlock("tiles_iridescent",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("tiles_iridescent")).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> SMALL_IRIDESCENT_TILES = registerBlock("tiles_iridescent_small",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("tiles_iridescent_small")).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> GREEN_TILES = registerBlock("tiles_green",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("tiles_green")).mapColor(DyeColor.GREEN)));
    public static final RegistryObject<Block> SMALL_GREEN_TILES = registerBlock("subway_tiles_green",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("subway_tiles_green")).mapColor(DyeColor.GREEN)));
    public static final RegistryObject<Block> YELLOW_TILES = registerBlock("tiles_yellow",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("tiles_yellow")).mapColor(DyeColor.YELLOW)));
    public static final RegistryObject<Block> SMALL_YELLOW_TILES = registerBlock("subway_tiles_yellow",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("subway_tiles_yellow")).mapColor(DyeColor.YELLOW)));
    public static final RegistryObject<Block> PURPLE_TILES = registerBlock("tiles_purple",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("tiles_purple")).mapColor(DyeColor.PURPLE)));
    public static final RegistryObject<Block> SMALL_PURPLE_TILES = registerBlock("subway_tiles_purple",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("subway_tiles_purple")).mapColor(DyeColor.PURPLE)));
    public static final RegistryObject<Block> PINK_TILES = registerBlock("tiles_pink",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("tiles_pink")).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> SMALL_PINK_TILES = registerBlock("subway_tiles_pink",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("subway_tiles_pink")).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> KITCHEN_TILES = registerBlock("tiles_kitchen",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("tiles_kitchen")).mapColor(DyeColor.RED)));

    public static final RegistryObject<Block> X_TILE_TERRACOTTA = registerBlock("x_tile_terracotta",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("x_tile_terracotta")).mapColor(DyeColor.BROWN)));
    public static final RegistryObject<Block> X_TILE_INVERSE_TERRACOTTA = registerBlock("x_tile_terracotta_inverse",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("x_tile_terracotta_inverse")).mapColor(DyeColor.BROWN)));
    public static final RegistryObject<Block> X_TILE_GRAY = registerBlock("x_tile_gray",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("x_tile_gray")).mapColor(DyeColor.GRAY)));
    public static final RegistryObject<Block> X_TILE_INVERSE_GRAY = registerBlock("x_tile_gray_inverse",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("x_tile_gray_inverse")).mapColor(DyeColor.GRAY)));
    public static final RegistryObject<Block> X_TILE_BLUE = registerBlock("x_tile_blue",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("x_tile_blue")).mapColor(DyeColor.BLUE)));
    public static final RegistryObject<Block> X_TILE_INVERSE_BLUE = registerBlock("x_tile_blue_inverse",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("x_tile_blue_inverse")).mapColor(DyeColor.BLUE)));

    public static final RegistryObject<Block> STONE_TEXTILES = registerBlock("textile_block_stone",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).setId(BLOCKS.key("textile_block_stone"))));

    public static final RegistryObject<Block> WICKER_BLOCK = registerFuelBlock("wicker_block",
            () -> new CustomWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("wicker_block")).sound(SoundType.BAMBOO).strength(0.5f)), 100);
    public static final RegistryObject<Block> CHISELED_GOLD_BLOCK = registerBlock("chiseled_gold_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK).setId(BLOCKS.key("chiseled_gold_block"))));
    public static final RegistryObject<Block> VARYING_BRICKS = registerBlock("antique_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).setId(BLOCKS.key("antique_bricks"))));
    public static final RegistryObject<Block> VARYING_BRICKS_BORDER = registerBlock("antique_bricks_border",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).setId(BLOCKS.key("antique_bricks_border"))));
    public static final RegistryObject<Block> EYE_BLOCK = registerBlock("eye_block",
            () -> new EyeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).setId(BLOCKS.key("eye_block")).sound(SoundType.FROGSPAWN).randomTicks()));
    public static final RegistryObject<Block> PUMPKIN_BOOKSHELF = registerBlock("pumpkin_bookshelf",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("pumpkin_bookshelf")).mapColor(DyeColor.ORANGE)));
    public static final RegistryObject<Block> DYNASTY_DOOR = registerFuelBlock("dynasty_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("dynasty_door")).mapColor(DyeColor.CYAN)), 300);

    public static final RegistryObject<Block> FLOWERING_CARPET_CRABAPPLE = registerBlock("flower_carpet_crabapple",
            () -> new FlowerCarpetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOW_LICHEN).setId(BLOCKS.key("flower_carpet_crabapple")).mapColor(DyeColor.GREEN).lightLevel(p -> 0)));
    public static final RegistryObject<Block> FLOWERING_CARPET_WILLOW = registerBlock("flower_carpet_willow",
            () -> new FlowerCarpetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOW_LICHEN).setId(BLOCKS.key("flower_carpet_willow")).mapColor(DyeColor.GREEN).lightLevel(p -> 0)));
    public static final RegistryObject<Block> FLOWERING_CARPET_POPLAR = registerBlock("flower_carpet_poplar",
            () -> new FlowerCarpetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOW_LICHEN).setId(BLOCKS.key("flower_carpet_poplar")).mapColor(DyeColor.GREEN).lightLevel(p -> 0)));

    public static final RegistryObject<Block> ALABASTER_WINDOW_DIVIDED = registerBlock("alabaster_window_divided",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("alabaster_window_divided"))));
    public static final RegistryObject<Block> ALABASTER_WINDOW_PANE = registerBlock("alabaster_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).setId(BLOCKS.key("alabaster_window_pane"))));

    public static final RegistryObject<Block> GREENHOUSE_WINDOW_ARCH_LEFT = registerBlock("greenhouse_window_arch_left",
            () -> new CustomHorizontalGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("greenhouse_window_arch_left"))));
    public static final RegistryObject<Block> GREENHOUSE_WINDOW_ARCH_RIGHT = registerBlock("greenhouse_window_arch_right",
            () -> new CustomHorizontalGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("greenhouse_window_arch_right"))));
    public static final RegistryObject<Block> GREENHOUSE_WINDOW_CIRCLE = registerBlock("greenhouse_window_circle",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("greenhouse_window_circle"))));
    public static final RegistryObject<Block> GREENHOUSE_WINDOW_POINT = registerBlock("greenhouse_window_pointed",
            () -> new CustomHorizontalGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("greenhouse_window_pointed"))));
    public static final RegistryObject<Block> GREENHOUSE_WINDOW = registerBlock("greenhouse_window",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("greenhouse_window"))));
    public static final RegistryObject<Block> GREENHOUSE_WINDOW_RADIAL_LEFT = registerBlock("greenhouse_window_radial_left",
            () -> new CustomHorizontalGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("greenhouse_window_radial_left"))));
    public static final RegistryObject<Block> GREENHOUSE_WINDOW_RADIAL_RIGHT = registerBlock("greenhouse_window_radial_right",
            () -> new CustomHorizontalGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("greenhouse_window_radial_right"))));
    public static final RegistryObject<Block> GREENHOUSE_WINDOW_ROUNDED = registerBlock("greenhouse_window_rounded",
            () -> new CustomHorizontalGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("greenhouse_window_rounded"))));
    
    public static final RegistryObject<Block> WOOD_WINDOW_DIVIDED = registerBlock("wooden_window_divided",
            () -> new CustomGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("wooden_window_divided")).mapColor(DyeColor.BROWN)));
    public static final RegistryObject<Block> WOOD_WINDOW_PANE = registerBlock("wooden_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE).setId(BLOCKS.key("wooden_window_pane")).mapColor(DyeColor.BROWN)));

    public static final RegistryObject<Block> ALABASTER_SCREEN_DOOR = registerBlock("alabaster_screen_door",
            () -> new DoorBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR).setId(BLOCKS.key("alabaster_screen_door"))));
    public static final RegistryObject<Block> ALABASTER_FRENCH_DOOR = registerBlock("alabaster_french_door",
            () -> new DoorBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR).setId(BLOCKS.key("alabaster_french_door"))));
    public static final RegistryObject<Block> WOOD_SCREEN_DOOR = registerBlock("wooden_screen_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("wooden_screen_door"))));
    public static final RegistryObject<Block> WOOD_FRENCH_DOOR = registerBlock("wooden_french_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("wooden_french_door"))));

    public static final RegistryObject<Block> COLOSSEO_PILLAR = registerBlock("colosseo_pillar",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("colosseo_pillar")).mapColor(DyeColor.RED)));
    public static final RegistryObject<Block> COLOSSEO_PILLAR_BASE = registerBlock("colosseo_pillar_base",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("colosseo_pillar_base")).mapColor(DyeColor.RED)));
    public static final RegistryObject<Block> COLOSSEO_PILLAR_TOP = registerBlock("colosseo_pillar_top",
            () -> new DirectionalPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_PILLAR).setId(BLOCKS.key("colosseo_pillar_top")).mapColor(DyeColor.RED)));

    public static final RegistryObject<Block> HONEY_JAR_BLOCK = registerBlock("jam_jar_honey",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("jam_jar_honey")).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> ORANGE_JAR_BLOCK = registerBlock("jam_jar_orange",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("jam_jar_orange")).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> CHERRY_JAR_BLOCK = registerBlock("jam_jar_cherry",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("jam_jar_cherry")).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> STRAWBERRY_JAR_BLOCK = registerBlock("jam_jar_strawberry",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("jam_jar_strawberry")).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> BLUEBERRY_JAR_BLOCK = registerBlock("jam_jar_blueberry",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("jam_jar_blueberry")).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> APRICOT_JAR_BLOCK = registerBlock("jam_jar_apricot",
            () -> new CustomHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("jam_jar_apricot")).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> MINI_HONEY_JAR_BLOCK = registerBlock("mini_jam_jar_honey",
            () -> new SingleJamJarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("mini_jam_jar_honey")).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> MINI_ORANGE_JAR_BLOCK = registerBlock("mini_jam_jar_orange",
            () -> new SingleJamJarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("mini_jam_jar_orange")).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> MINI_CHERRY_JAR_BLOCK = registerBlock("mini_jam_jar_cherry",
            () -> new SingleJamJarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("mini_jam_jar_cherry")).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> MINI_STRAWBERRY_JAR_BLOCK = registerBlock("mini_jam_jar_strawberry",
            () -> new SingleJamJarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("mini_jam_jar_strawberry")).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> MINI_BLUEBERRY_JAR_BLOCK = registerBlock("mini_jam_jar_blueberry",
            () -> new SingleJamJarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("mini_jam_jar_blueberry")).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> MINI_APRICOT_JAR_BLOCK = registerBlock("mini_jam_jar_apricot",
            () -> new SingleJamJarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("mini_jam_jar_apricot")).sound(SoundType.GLASS).noOcclusion()));

    public static final RegistryObject<Block> ART_NOUVEAU_DOOR = registerFuelBlock("art_nouveau_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("art_nouveau_door")).mapColor(DyeColor.YELLOW)), 300);
    public static final RegistryObject<Block> ART_NOUVEAU_DOOR_DARK = registerFuelBlock("art_nouveau_door_dark",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(BLOCKS.key("art_nouveau_door_dark")).mapColor(DyeColor.BROWN)), 300);


    public static final RegistryObject<Block> MARBLE_BALUSTRADE = registerBlock("marble_balustrade",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).setId(BLOCKS.key("marble_balustrade")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_PICKET_FENCE = registerBlock("marble_picket_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).setId(BLOCKS.key("marble_picket_fence")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MARBLE_PICKET_FENCE_GATE = registerBlock("marble_picket_fence_gate",
            () -> new PicketFenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).setId(BLOCKS.key("marble_picket_fence_gate")).mapColor(DyeColor.WHITE)));

    public static final RegistryObject<Block> CHALCEDONY_BALUSTRADE = registerBlock("chalcedony_balustrade",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).setId(BLOCKS.key("chalcedony_balustrade")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_PICKET_FENCE = registerBlock("chalcedony_picket_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).setId(BLOCKS.key("chalcedony_picket_fence")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> CHALCEDONY_PICKET_FENCE_GATE = registerBlock("chalcedony_picket_fence_gate",
            () -> new PicketFenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).setId(BLOCKS.key("chalcedony_picket_fence_gate")).mapColor(DyeColor.WHITE)));

    public static final RegistryObject<Block> DEEP_CHALCEDONY_BALUSTRADE = registerBlock("deep_chalcedony_balustrade",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).setId(BLOCKS.key("deep_chalcedony_balustrade")).mapColor(DyeColor.BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_PICKET_FENCE = registerBlock("deep_chalcedony_picket_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).setId(BLOCKS.key("deep_chalcedony_picket_fence")).mapColor(DyeColor.BLUE)));
    public static final RegistryObject<Block> DEEP_CHALCEDONY_PICKET_FENCE_GATE = registerBlock("deep_chalcedony_picket_fence_gate",
            () -> new PicketFenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).setId(BLOCKS.key("deep_chalcedony_picket_fence_gate")).mapColor(DyeColor.BLUE)));

    public static final RegistryObject<Block> WOODEN_PICKET_FENCE = registerFuelBlock("wooden_picket_fence",
            () -> new CustomWoodFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(BLOCKS.key("wooden_picket_fence")).mapColor(DyeColor.BROWN)), 300);
    public static final RegistryObject<Block> WOODEN_PICKET_FENCE_GATE = registerFuelBlock("wooden_picket_fence_gate",
            () -> new WoodPicketFenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(BLOCKS.key("wooden_picket_fence_gate")).mapColor(DyeColor.BROWN)), 300);

    //SMALL FURNITURE
    //MISC
    public static final RegistryObject<Block> BIRDHOUSE_UNPAINTED = registerBlock("birdhouse_unpainted",
            () -> new BirdhouseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("birdhouse_unpainted")).noOcclusion()));
    public static final RegistryObject<Block> BIRDHOUSE_RED = registerBlock("birdhouse_red",
            () -> new BirdhouseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("birdhouse_red")).mapColor(DyeColor.RED).noOcclusion()));
    public static final RegistryObject<Block> BIRDHOUSE_BLUE = registerBlock("birdhouse_blue",
            () -> new BirdhouseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("birdhouse_blue")).mapColor(DyeColor.BLUE).noOcclusion()));
    public static final RegistryObject<Block> BIRDHOUSE_PASTEL = registerBlock("birdhouse_pastel",
            () -> new BirdhouseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("birdhouse_pastel")).mapColor(DyeColor.PINK).noOcclusion()));

    public static final RegistryObject<Block> CARDBOARD_BOX = registerBlock("cardboard_box_open",
            () -> new CardboardBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).setId(BLOCKS.key("cardboard_box_open")).mapColor(DyeColor.BROWN)));

    public static final RegistryObject<Block> KITCHEN_SCALE = registerBlock("analog_kitchen_scale",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("analog_kitchen_scale")).mapColor(DyeColor.RED)));
    public static final RegistryObject<Block> ANTIQUE_MINI_TABLE = registerBlock("antique_mini_table",
            () -> new AntiqueMiniTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("antique_mini_table")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_CODEX = registerBlock("ancient_codex",
            () -> new AncientCodexBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("ancient_codex")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> ANTIQUE_BOOK_STAND = registerBlock("antique_book_stand",
            () -> new AntiqueBookStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("antique_book_stand")).mapColor(DyeColor.BROWN).noOcclusion()));



    public static final RegistryObject<Block> BUNNY_BOOK_ENDS = registerBlock("bunny_book_ends",
            () -> new BunnyBookendsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD).setId(BLOCKS.key("bunny_book_ends")).mapColor(DyeColor.YELLOW)));
    public static final RegistryObject<Block> BOX_OF_PAINTS = registerBlock("box_of_paints",
            () -> new ShortMediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("box_of_paints")).mapColor(DyeColor.BROWN)));

    public static final RegistryObject<Block> THREAD_SPOOL_YELLOW = registerBlock("spool_of_thread_yellow",
            () -> new ThreadSpoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("spool_of_thread_yellow"))));
    public static final RegistryObject<Block> THREAD_SPOOL_GREEN = registerBlock("spool_of_thread_green",
            () -> new ThreadSpoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GREEN)).setId(BLOCKS.key("spool_of_thread_green"))));
    public static final RegistryObject<Block> THREAD_SPOOL_PURPLE = registerBlock("spool_of_thread_purple",
            () -> new ThreadSpoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("spool_of_thread_purple"))));
    public static final RegistryObject<Block> THREAD_SPOOL_PINK = registerBlock("spool_of_thread_pink",
            () -> new ThreadSpoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("spool_of_thread_pink"))));
    public static final RegistryObject<Block> CAT_MUGS_CLUTTERED = registerBlock("cat_mugs_cluttered",
            () -> new ShortMediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("cat_mugs_cluttered")).sound(SoundType.DECORATED_POT).strength(0.3f)));
    public static final RegistryObject<Block> CAT_PLANT_POT_BLACK = registerBlock("cat_plant_pot_black",
            () -> new CatPlantPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLACK)).setId(BLOCKS.key("cat_plant_pot_black")).sound(SoundType.DECORATED_POT)));
    public static final RegistryObject<Block> CAT_PLANT_POT_ORANGE = registerBlock("cat_plant_pot_orange",
            () -> new CatPlantPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CONCRETE.pick(DyeColor.ORANGE)).setId(BLOCKS.key("cat_plant_pot_orange")).sound(SoundType.DECORATED_POT)));
    public static final RegistryObject<Block> COFFEE_GRINDER = registerBlock("coffee_grinder",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("coffee_grinder"))));
    public static final RegistryObject<Block> ENDTABLE_DECOR = registerBlock("endtable_decor",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).setId(BLOCKS.key("endtable_decor")).sound(SoundType.DECORATED_POT).noCollision()));
    public static final RegistryObject<Block> MINI_CACTUS_SET = registerBlock("mini_cactus_set",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GREEN)).setId(BLOCKS.key("mini_cactus_set")).sound(SoundType.DECORATED_POT).strength(0.2f)));
    public static final RegistryObject<Block> MUSHROOM_JARS = registerBlock("mushroom_jars",
            () -> new MushroomJarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("mushroom_jars")).sound(SoundType.GLASS).mapColor(DyeColor.BROWN).strength(0.2f)));
    public static final RegistryObject<Block> NEWSPAPER_PILE_SHORT = registerBlock("newspaper_pile_short",
            () -> new ShortPaperPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("newspaper_pile_short")).sound(SoundType.SPORE_BLOSSOM).mapColor(DyeColor.WHITE).strength(0.2f)));
    public static final RegistryObject<Block> NEWSPAPER_PILE_TALL = registerBlock("newspaper_pile_tall",
            () -> new TallPaperPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("newspaper_pile_tall")).sound(SoundType.SPORE_BLOSSOM).mapColor(DyeColor.WHITE).strength(0.2f)));
    public static final RegistryObject<Block> PAPER_PILE = registerBlock("paper_pile",
            () -> new ShortPaperPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("paper_pile")).sound(SoundType.SPORE_BLOSSOM).mapColor(DyeColor.WHITE).strength(0.2f)));
    public static final RegistryObject<Block> FENCE_SHELF = registerBlock("fence_shelf_blue",
            () -> new FenceShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("fence_shelf_blue")).mapColor(DyeColor.BLUE)));
    public static final RegistryObject<Block> HANGING_PLANT_POT_FLOWERS = registerBlock("hanging_plant_pot_flowers",
            () -> new HangingPlantPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("hanging_plant_pot_flowers")).sound(SoundType.DECORATED_POT).mapColor(DyeColor.BROWN).strength(0.4f)));
    public static final RegistryObject<Block> HANGING_PLANT_POT_GRASS = registerBlock("hanging_plant_pot_grass",
            () -> new HangingPlantPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("hanging_plant_pot_grass")).sound(SoundType.DECORATED_POT).mapColor(DyeColor.BROWN).strength(0.4f)));
    public static final RegistryObject<Block> PEDESTAL_HK = registerBlock("pedestal_hk",
            () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("pedestal_hk")).mapColor(DyeColor.ORANGE)));
    public static final RegistryObject<Block> PICNIC_BASKET = registerBlock("picnic_basket",
            () -> new PicnicBasketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("picnic_basket")).mapColor(DyeColor.BLUE)));
    public static final RegistryObject<Block> PICNIC_BASKET_PREPARED = registerBlock("picnic_basket_prepared",
            () -> new PicnicBasketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("picnic_basket_prepared")).mapColor(DyeColor.BLUE)));

    public static final RegistryObject<Block> BASKET_OF_FLOWERS = registerBlock("basket_of_flowers",
            () -> new ProduceBasketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("basket_of_flowers")).mapColor(DyeColor.YELLOW)));
    public static final RegistryObject<Block> BASKET_OF_PRODUCE = registerBlock("basket_of_produce",
            () -> new ProduceBasketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).setId(BLOCKS.key("basket_of_produce")).mapColor(DyeColor.ORANGE)));

    public static final RegistryObject<Block> ROW_OF_SMALL_BOOKS = registerBlock("row_of_small_books",
            () -> new SmallBookRowBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).setId(BLOCKS.key("row_of_small_books")).sound(SoundType.CHERRY_WOOD).mapColor(DyeColor.BLUE)));
    public static final RegistryObject<Block> ROW_OF_SMALL_BOOKS_PASTEL = registerBlock("row_of_small_books_pastel",
            () -> new SmallBookRowBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).setId(BLOCKS.key("row_of_small_books_pastel")).sound(SoundType.CHERRY_WOOD).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> ROW_OF_SMALL_BOOKS_SHELVED = registerBlock("row_of_small_books_shelved",
            () -> new ShelvedBooksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("row_of_small_books_shelved")).mapColor(DyeColor.BLUE)));
    public static final RegistryObject<Block> ROW_OF_SMALL_BOOKS_PASTEL_SHELVED = registerBlock("row_of_small_books_pastel_shelved",
            () -> new ShelvedBooksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("row_of_small_books_pastel_shelved")).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> SMALL_SHELF = registerBlock("small_shelf",
            () -> new SmallShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("small_shelf")).mapColor(DyeColor.BROWN)));
    public static final RegistryObject<Block> SMALL_SHELF_PINK = registerBlock("small_shelf_pink",
            () -> new SmallShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("small_shelf_pink")).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> RUBIKS_CUBE = registerBlock("rubiks_cube",
            () -> new RubiksCubeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("rubiks_cube")).sound(SoundType.DEEPSLATE_BRICKS).mapColor(DyeColor.RED)));
    public static final RegistryObject<Block> RUBIKS_CUBE_PASTEL = registerBlock("rubiks_cube_pastel",
            () -> new RubiksCubeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("rubiks_cube_pastel")).sound(SoundType.DEEPSLATE_BRICKS).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> SCATTERED_PAPERS = registerBlock("scattered_papers",
            () -> new FlatFloorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPORE_BLOSSOM).setId(BLOCKS.key("scattered_papers")).mapColor(DyeColor.WHITE).noCollision()));
    public static final RegistryObject<Block> SEWING_MACHINE_ANTIQUE = registerBlock("sewing_machine_antique",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("sewing_machine_antique")).sound(SoundType.ANVIL).mapColor(DyeColor.BLACK)));
    public static final RegistryObject<Block> SMALL_BUSH = registerBlock("small_bush",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(BLOCKS.key("small_bush"))));
    public static final RegistryObject<Block> TEDDY_BEAR = registerBlock("teddy_bear",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("teddy_bear"))));

    public static final RegistryObject<Block> POLAROID_CAMERA = registerBlock("polaroid_camera",
            () -> new PolaroidCameraBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GRAY)).setId(BLOCKS.key("polaroid_camera")).sound(SoundType.SCAFFOLDING)));

    public static final RegistryObject<Block> RED_MUSHROOM_TV = registerBlock("red_mushroom_tv",
            () -> new MushroomTVBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("red_mushroom_tv")).mapColor(DyeColor.RED).lightLevel(p -> p.getValue(MushroomTVBlock.CHANNEL) == 0 ? 0 : 6)));
    public static final RegistryObject<Block> RED_MUSHROOM_LAMP = registerBlock("red_mushroom_lamp",
            () -> new MushroomLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("red_mushroom_lamp")).mapColor(DyeColor.BLUE).lightLevel(p -> 15)));
    public static final RegistryObject<Block> RED_MUSHROOM_TABLE = registerBlock("red_mushroom_table",
            () -> new MushroomTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("red_mushroom_table")).mapColor(DyeColor.RED)));
    public static final RegistryObject<Block> RED_MUSHROOM_WARDROBE = registerBlock("red_mushroom_wardrobe",
            () -> new MushroomWardrobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("red_mushroom_wardrobe")).mapColor(DyeColor.RED).noOcclusion()));
    public static final RegistryObject<Block> RED_MUSHROOM_BED = registerBlock("red_mushroom_bed",
            () -> new MushroomBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("red_mushroom_bed")).mapColor(DyeColor.RED).bounceRestitution(0.66F)));

    public static final RegistryObject<Block> BLUE_MUSHROOM_TV = registerBlock("blue_mushroom_tv",
            () -> new MushroomTVBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("blue_mushroom_tv")).mapColor(DyeColor.BLUE).lightLevel(p -> p.getValue(MushroomTVBlock.CHANNEL) == 0 ? 0 : 6)));
    public static final RegistryObject<Block> BLUE_MUSHROOM_LAMP = registerBlock("blue_mushroom_lamp",
            () -> new MushroomLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("blue_mushroom_lamp")).mapColor(DyeColor.BLUE).lightLevel(p -> 15)));
    public static final RegistryObject<Block> BLUE_MUSHROOM_TABLE = registerBlock("blue_mushroom_table",
            () -> new MushroomTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("blue_mushroom_table")).mapColor(DyeColor.BLUE)));
    public static final RegistryObject<Block> BLUE_MUSHROOM_WARDROBE = registerBlock("blue_mushroom_wardrobe",
            () -> new MushroomWardrobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("blue_mushroom_wardrobe")).mapColor(DyeColor.BLUE).noOcclusion()));
    public static final RegistryObject<Block> BLUE_MUSHROOM_BED = registerBlock("blue_mushroom_bed",
            () -> new MushroomBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("blue_mushroom_bed")).mapColor(DyeColor.BLUE).bounceRestitution(0.66F)));

    //TODO idr if i ahve another to do somewhere else sorry
    public static final RegistryObject<Block> BOOK_OPEN = registerBlock("book_open",
            () -> new ShortMediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("book_open")).sound(SoundType.CHERRY_WOOD).strength(0.2f)));
    public static final RegistryObject<Block> BRASS_KEY = registerBlock("brass_key",
            () -> new SmallFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("brass_key")).sound(SoundType.STONE).strength(0.5f)));
    public static final RegistryObject<Block> ENVELOPE_STACK = registerBlock("envelope_stack",
            () -> new FlatClutterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("envelope_stack")).sound(SoundType.SPORE_BLOSSOM).strength(0.2f)));
    public static final RegistryObject<Block> FLOWER_DESK_LAMP = registerBlock("flower_desk_lamp",
            () -> new FlowerDeskLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("flower_desk_lamp")).strength(0.4f).sound(SoundType.CHERRY_LEAVES).lightLevel(p -> 15)));
    public static final RegistryObject<Block> GLOW_FLOWER = registerBlock("glow_flower",
            () -> new GlowFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TULIP).setId(BLOCKS.key("glow_flower")).strength(0.2f).sound(SoundType.SPORE_BLOSSOM).lightLevel(p -> 14).noOcclusion()));
    public static final RegistryObject<Block> FLOWER_SHELF_BLUE = registerBlock("flower_shelf_blue",
            () -> new FlowerShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("flower_shelf_blue")).strength(0.4f)));
    public static final RegistryObject<Block> FLOWER_SHELF_GREEN = registerBlock("flower_shelf_green",
            () -> new FlowerShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("flower_shelf_green")).strength(0.4f)));
    public static final RegistryObject<Block> FLOWER_SHELF_PASTEL_YELLOW = registerBlock("flower_shelf_pastel_yellow",
            () -> new FlowerShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("flower_shelf_pastel_yellow")).strength(0.4f)));
    public static final RegistryObject<Block> FLOWER_SHELF_PINK = registerBlock("flower_shelf_pink",
            () -> new FlowerShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("flower_shelf_pink")).strength(0.4f)));
    public static final RegistryObject<Block> FLOWER_SHELF_PURPLE = registerBlock("flower_shelf_purple",
            () -> new FlowerShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("flower_shelf_purple")).strength(0.4f)));
    public static final RegistryObject<Block> FLOWER_SHELF_YELLOW = registerBlock("flower_shelf_yellow",
            () -> new FlowerShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("flower_shelf_yellow")).strength(0.4f)));
    public static final RegistryObject<Block> FLOWER_SHELF_CANDLE_BLUE = registerBlock("flower_shelf_candle_blue",
            () -> new ShelfCandleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("flower_shelf_candle_blue")).sound(SoundType.CANDLE).strength(0.1f).lightLevel(p -> p.getValue(ShelfCandleBlock.LIT) ? 10 : 0)));
    public static final RegistryObject<Block> FLOWER_SHELF_CANDLE_GREEN = registerBlock("flower_shelf_candle_green",
            () -> new ShelfCandleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("flower_shelf_candle_green")).sound(SoundType.CANDLE).strength(0.1f).lightLevel(p -> p.getValue(ShelfCandleBlock.LIT) ? 10 : 0)));
    public static final RegistryObject<Block> FLOWER_SHELF_CANDLE_PASTEL_YELLOW = registerBlock("flower_shelf_candle_pastel_yellow",
            () -> new ShelfCandleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("flower_shelf_candle_pastel_yellow")).sound(SoundType.CANDLE).strength(0.1f).lightLevel(p -> p.getValue(ShelfCandleBlock.LIT) ? 10 : 0)));
    public static final RegistryObject<Block> FLOWER_SHELF_CANDLE_PINK = registerBlock("flower_shelf_candle_pink",
            () -> new ShelfCandleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("flower_shelf_candle_pink")).sound(SoundType.CANDLE).strength(0.1f).lightLevel(p -> p.getValue(ShelfCandleBlock.LIT) ? 10 : 0)));
    public static final RegistryObject<Block> FLOWER_SHELF_CANDLE_PURPLE = registerBlock("flower_shelf_candle_purple",
            () -> new ShelfCandleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("flower_shelf_candle_purple")).sound(SoundType.CANDLE).strength(0.1f).lightLevel(p -> p.getValue(ShelfCandleBlock.LIT) ? 10 : 0)));
    public static final RegistryObject<Block> FLOWER_SHELF_CANDLE_YELLOW = registerBlock("flower_shelf_candle_yellow",
            () -> new ShelfCandleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("flower_shelf_candle_yellow")).sound(SoundType.CANDLE).strength(0.1f).lightLevel(p -> p.getValue(ShelfCandleBlock.LIT) ? 10 : 0)));
    public static final RegistryObject<Block> FLOWER_SHELF_PLANT = registerBlock("flower_shelf_plant",
            () -> new FlowerShelfPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("flower_shelf_plant")).sound(SoundType.DECORATED_POT).strength(0.2f)));
    public static final RegistryObject<Block> FLOWER_TEA_KETTLE = registerBlock("flower_tea_kettle",
            () -> new TeaKettleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("flower_tea_kettle")).sound(SoundType.DECORATED_POT)));
    public static final RegistryObject<Block> HEAVENLY_ORNAMENTAL_ARRAY = registerBlock("heavenly_ornamental_array",
            () -> new HeavenlyArrayBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("heavenly_ornamental_array")).sound(SoundType.AMETHYST).strength(0.3f).lightLevel(p -> 4).noOcclusion()));
    public static final RegistryObject<Block> SALT_PEPPER_SHAKERS = registerBlock("salt_pepper_shakers",
            () -> new SaltAndPepperBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("salt_pepper_shakers"))));
    public static final RegistryObject<Block> SAND_SEAL_PLUSH_BLUE = registerBlock("sand_seal_plush_blue",
            () -> new SandsealPlushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("sand_seal_plush_blue"))));
    public static final RegistryObject<Block> SAND_SEAL_PLUSH_GREEN = registerBlock("sand_seal_plush_green",
            () -> new SandsealPlushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("sand_seal_plush_green"))));
    public static final RegistryObject<Block> SAND_SEAL_PLUSH_RED = registerBlock("sand_seal_plush_red",
            () -> new SandsealPlushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("sand_seal_plush_red"))));
    public static final RegistryObject<Block> SKETCHBOOK_SINGLE = registerBlock("sketchbook_single",
            () -> new FlatClutterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("sketchbook_single")).sound(SoundType.SPORE_BLOSSOM).strength(0.2f)));
    public static final RegistryObject<Block> STACK_OF_BOOKS = registerBlock("stack_of_books",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GREEN)).setId(BLOCKS.key("stack_of_books")).sound(SoundType.CHERRY_WOOD)));
    public static final RegistryObject<Block> STACK_OF_BOOKS_TALL = registerBlock("stack_of_books_tall",
            () -> new BookStackBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GREEN)).setId(BLOCKS.key("stack_of_books_tall")).sound(SoundType.CHERRY_WOOD)));
    public static final RegistryObject<Block> SWEETHEART_BAKING_SET_BOWL = registerBlock("sweetheart_baking_set_bowl",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("sweetheart_baking_set_bowl")).sound(SoundType.WOOD).strength(0.2f)));
    public static final RegistryObject<Block> SWEETHEART_BAKING_SET_INGREDIENTS = registerBlock("sweetheart_baking_set_ingredients",
            () -> new BakingIngredientsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("sweetheart_baking_set_ingredients")).noOcclusion()));
    public static final RegistryObject<Block> WINE_BOTTLE_RACK = registerBlock("wine_bottle_rack",
            () -> new WineBottleRackBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("wine_bottle_rack")).strength(0.5f)));
    public static final RegistryObject<Block> WINE_BOTTLES = registerBlock("wine_bottles",
            () -> new WineBottlesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("wine_bottles")).sound(SoundType.GLASS).strength(0.2f)));
    public static final RegistryObject<Block> YELLOW_NOTEPAD = registerBlock("yellow_notepad",
            () -> new FlatClutterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("yellow_notepad")).sound(SoundType.SPORE_BLOSSOM).strength(0.2f)));
    public static final RegistryObject<Block> FABRIC_BOLTS = registerBlock("fabric_bolts",
            () -> new FabricBoltsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("fabric_bolts")).strength(0.4f)));
    public static final RegistryObject<Block> SCISSORS_AND_THREAD = registerBlock("scissors_and_thread",
            () -> new FlatClutterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("scissors_and_thread")).noCollision().strength(0.2f)));
    public static final RegistryObject<Block> SLICED_BREAD = registerBlock("sliced_bread",
            () -> new SlicedBreadBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("sliced_bread"))));
    public static final RegistryObject<Block> VIAL_STAND = registerBlock("vial_stand",
            () -> new VialStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("vial_stand")).strength(0.4f)));
    public static final RegistryObject<Block> PINEAPPLE = registerBlock("pineapple",
            () -> new PineappleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MELON).setId(BLOCKS.key("pineapple")).strength(0.3f)));
    public static final RegistryObject<Block> HONEYCOMB_LAMP = registerBlock("honeycomb_lamp",
            () -> new HoneycombLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("honeycomb_lamp")).sound(SoundType.HONEY_BLOCK).lightLevel(p -> 15)));
    public static final RegistryObject<Block> SEAWEED_PLANTER = registerBlock("seaweed_planter",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(BLOCKS.key("seaweed_planter")).sound(SoundType.DECORATED_POT).mapColor(DyeColor.GREEN)));
    //TODO remove maybe?
    public static final RegistryObject<Block> MUSHROOM_FLAT = registerBlock("mushroom_flat",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("mushroom_flat"))));

    //SMALL STORAGE
    //MISC
    public static final RegistryObject<Block> BRIEFCASE_BLANK = registerBlock("briefcase_blank",
            () -> new BriefcaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("briefcase_blank")).mapColor(DyeColor.RED)));
    public static final RegistryObject<Block> BRIEFCASE_ROVER = registerBlock("briefcase_rover",
            () -> new BriefcaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("briefcase_rover")).mapColor(DyeColor.RED)));
    public static final RegistryObject<Block> SAFE_NOVAKID = registerBlock("safe_novakid",
            () -> new NovakidSafeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("safe_novakid")).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> FILING_BOX = registerBlock("filing_box",
            () -> new FilingBoxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLACK)).setId(BLOCKS.key("filing_box")).sound(SoundType.WOOD)));

    //KITCHEN SETS
    public static final RegistryObject<Block> KITCHEN_SET_BROWN_CABINET = registerBlock("kitchen_set_brown_cabinet",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_brown_cabinet"))));
    public static final RegistryObject<Block> KITCHEN_SET_BROWN_CABINET_MINI = registerBlock("kitchen_set_brown_cabinet_mini",
            () -> new KitchenHalfCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_brown_cabinet_mini"))));
    public static final RegistryObject<Block> KITCHEN_SET_BROWN_CABINET_GLASS = registerBlock("kitchen_set_brown_cabinet_glass",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_brown_cabinet_glass"))));
    public static final RegistryObject<Block> KITCHEN_SET_BROWN_CABINET_INNER_CORNER = registerBlock("kitchen_set_brown_cabinet_inner_corner",
            () -> new KitchenInnerCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_brown_cabinet_inner_corner"))));
    public static final RegistryObject<Block> KITCHEN_SET_BROWN_CABINET_OUTER_CORNER = registerBlock("kitchen_set_brown_cabinet_outer_corner",
            () -> new KitchenOuterCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_brown_cabinet_outer_corner"))));
    public static final RegistryObject<Block> KITCHEN_SET_BROWN_CABINET_OPEN = registerBlock("kitchen_set_brown_cabinet_open",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_brown_cabinet_open"))));
    public static final RegistryObject<Block> KITCHEN_SET_BROWN_COUNTER = registerBlock("kitchen_set_brown_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_brown_counter"))));
    public static final RegistryObject<Block> KITCHEN_SET_BROWN_COUNTER_INNER_CORNER = registerBlock("kitchen_set_brown_counter_inner_corner",
            () -> new KitchenInnerCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_brown_counter_inner_corner")).noOcclusion()));
    public static final RegistryObject<Block> KITCHEN_SET_BROWN_COUNTER_OUTER_CORNER_LEFT = registerBlock("kitchen_set_brown_counter_outer_corner_left",
            () -> new KitchenCounterLeftBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_brown_counter_outer_corner_left"))));
    public static final RegistryObject<Block> KITCHEN_SET_BROWN_COUNTER_OUTER_CORNER_RIGHT = registerBlock("kitchen_set_brown_counter_outer_corner_right",
            () -> new KitchenCounterRightBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_brown_counter_outer_corner_right"))));
    public static final RegistryObject<Block> KITCHEN_SET_BROWN_COUNTER_SINK = registerBlock("kitchen_set_brown_counter_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_brown_counter_sink"))));

    public static final RegistryObject<Block> KITCHEN_SET_LIGHT_GREEN_CABINET = registerBlock("kitchen_set_light_green_cabinet",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_light_green_cabinet"))));
    public static final RegistryObject<Block> KITCHEN_SET_LIGHT_GREEN_CABINET_MINI = registerBlock("kitchen_set_light_green_cabinet_mini",
            () -> new KitchenHalfCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_light_green_cabinet_mini"))));
    public static final RegistryObject<Block> KITCHEN_SET_LIGHT_GREEN_CABINET_GLASS = registerBlock("kitchen_set_light_green_cabinet_glass",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_light_green_cabinet_glass"))));
    public static final RegistryObject<Block> KITCHEN_SET_LIGHT_GREEN_CABINET_OPEN = registerBlock("kitchen_set_light_green_cabinet_open",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_light_green_cabinet_open"))));
    public static final RegistryObject<Block> KITCHEN_SET_LIGHT_GREEN_CABINET_INNER_CORNER = registerBlock("kitchen_set_light_green_cabinet_inner_corner",
            () -> new KitchenInnerCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_light_green_cabinet_inner_corner"))));
    public static final RegistryObject<Block> KITCHEN_SET_LIGHT_GREEN_CABINET_OUTER_CORNER = registerBlock("kitchen_set_light_green_cabinet_outer_corner",
            () -> new KitchenOuterCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_light_green_cabinet_outer_corner"))));
    public static final RegistryObject<Block> KITCHEN_SET_LIGHT_GREEN_COUNTER = registerBlock("kitchen_set_light_green_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_light_green_counter"))));
    public static final RegistryObject<Block> KITCHEN_SET_LIGHT_GREEN_COUNTER_INNER_CORNER = registerBlock("kitchen_set_light_green_counter_inner_corner",
            () -> new KitchenInnerCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_light_green_counter_inner_corner")).noOcclusion()));
    public static final RegistryObject<Block> KITCHEN_SET_LIGHT_GREEN_COUNTER_OUTER_CORNER_LEFT = registerBlock("kitchen_set_light_green_counter_outer_corner_left",
            () -> new KitchenCounterLeftBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_light_green_counter_outer_corner_left"))));
    public static final RegistryObject<Block> KITCHEN_SET_LIGHT_GREEN_COUNTER_OUTER_CORNER_RIGHT = registerBlock("kitchen_set_light_green_counter_outer_corner_right",
            () -> new KitchenCounterRightBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_light_green_counter_outer_corner_right"))));
    public static final RegistryObject<Block> KITCHEN_SET_LIGHT_GREEN_COUNTER_SINK = registerBlock("kitchen_set_light_green_counter_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_light_green_counter_sink"))));

    public static final RegistryObject<Block> KITCHEN_SET_PINK_CABINET = registerBlock("kitchen_set_pink_cabinet",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_pink_cabinet"))));
    public static final RegistryObject<Block> KITCHEN_SET_PINK_CABINET_MINI = registerBlock("kitchen_set_pink_cabinet_mini",
            () -> new KitchenHalfCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_pink_cabinet_mini"))));
    public static final RegistryObject<Block> KITCHEN_SET_PINK_CABINET_GLASS = registerBlock("kitchen_set_pink_cabinet_glass",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_pink_cabinet_glass"))));
    public static final RegistryObject<Block> KITCHEN_SET_PINK_CABINET_OPEN = registerBlock("kitchen_set_pink_cabinet_open",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_pink_cabinet_open"))));
    public static final RegistryObject<Block> KITCHEN_SET_PINK_CABINET_INNER_CORNER = registerBlock("kitchen_set_pink_cabinet_inner_corner",
            () -> new KitchenInnerCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_pink_cabinet_inner_corner"))));
    public static final RegistryObject<Block> KITCHEN_SET_PINK_CABINET_OUTER_CORNER = registerBlock("kitchen_set_pink_cabinet_outer_corner",
            () -> new KitchenOuterCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_pink_cabinet_outer_corner"))));
    public static final RegistryObject<Block> KITCHEN_SET_PINK_COUNTER = registerBlock("kitchen_set_pink_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_pink_counter"))));
    public static final RegistryObject<Block> KITCHEN_SET_PINK_COUNTER_INNER_CORNER = registerBlock("kitchen_set_pink_counter_inner_corner",
            () -> new KitchenInnerCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_pink_counter_inner_corner")).noOcclusion()));
    public static final RegistryObject<Block> KITCHEN_SET_PINK_COUNTER_OUTER_CORNER_LEFT = registerBlock("kitchen_set_pink_counter_outer_corner_left",
            () -> new KitchenCounterLeftBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_pink_counter_outer_corner_left"))));
    public static final RegistryObject<Block> KITCHEN_SET_PINK_COUNTER_OUTER_CORNER_RIGHT = registerBlock("kitchen_set_pink_counter_outer_corner_right",
            () -> new KitchenCounterRightBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_pink_counter_outer_corner_right"))));
    public static final RegistryObject<Block> KITCHEN_SET_PINK_COUNTER_SINK = registerBlock("kitchen_set_pink_counter_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_pink_counter_sink"))));

    public static final RegistryObject<Block> KITCHEN_SET_PURPLE_CABINET = registerBlock("kitchen_set_purple_cabinet",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_purple_cabinet"))));
    public static final RegistryObject<Block> KITCHEN_SET_PURPLE_CABINET_MINI = registerBlock("kitchen_set_purple_cabinet_mini",
            () -> new KitchenHalfCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_purple_cabinet_mini"))));
    public static final RegistryObject<Block> KITCHEN_SET_PURPLE_CABINET_GLASS = registerBlock("kitchen_set_purple_cabinet_glass",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_purple_cabinet_glass"))));
    public static final RegistryObject<Block> KITCHEN_SET_PURPLE_CABINET_OPEN = registerBlock("kitchen_set_purple_cabinet_open",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_purple_cabinet_open"))));
    public static final RegistryObject<Block> KITCHEN_SET_PURPLE_CABINET_INNER_CORNER = registerBlock("kitchen_set_purple_cabinet_inner_corner",
            () -> new KitchenInnerCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_purple_cabinet_inner_corner"))));
    public static final RegistryObject<Block> KITCHEN_SET_PURPLE_CABINET_OUTER_CORNER = registerBlock("kitchen_set_purple_cabinet_outer_corner",
            () -> new KitchenOuterCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_purple_cabinet_outer_corner"))));
    public static final RegistryObject<Block> KITCHEN_SET_PURPLE_COUNTER = registerBlock("kitchen_set_purple_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_purple_counter"))));
    public static final RegistryObject<Block> KITCHEN_SET_PURPLE_COUNTER_INNER_CORNER = registerBlock("kitchen_set_purple_counter_inner_corner",
            () -> new KitchenInnerCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_purple_counter_inner_corner")).noOcclusion()));
    public static final RegistryObject<Block> KITCHEN_SET_PURPLE_COUNTER_OUTER_CORNER_LEFT = registerBlock("kitchen_set_purple_counter_outer_corner_left",
            () -> new KitchenCounterLeftBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_purple_counter_outer_corner_left"))));
    public static final RegistryObject<Block> KITCHEN_SET_PURPLE_COUNTER_OUTER_CORNER_RIGHT = registerBlock("kitchen_set_purple_counter_outer_corner_right",
            () -> new KitchenCounterRightBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_purple_counter_outer_corner_right"))));
    public static final RegistryObject<Block> KITCHEN_SET_PURPLE_COUNTER_SINK = registerBlock("kitchen_set_purple_counter_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_purple_counter_sink"))));

    public static final RegistryObject<Block> KITCHEN_SET_WHITE_CABINET = registerBlock("kitchen_set_white_cabinet",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_white_cabinet"))));
    public static final RegistryObject<Block> KITCHEN_SET_WHITE_CABINET_MINI = registerBlock("kitchen_set_white_cabinet_mini",
            () -> new KitchenHalfCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_white_cabinet_mini"))));
    public static final RegistryObject<Block> KITCHEN_SET_WHITE_CABINET_GLASS = registerBlock("kitchen_set_white_cabinet_glass",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_white_cabinet_glass"))));
    public static final RegistryObject<Block> KITCHEN_SET_WHITE_CABINET_OPEN = registerBlock("kitchen_set_white_cabinet_open",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_white_cabinet_open"))));
    public static final RegistryObject<Block> KITCHEN_SET_WHITE_CABINET_INNER_CORNER = registerBlock("kitchen_set_white_cabinet_inner_corner",
            () -> new KitchenInnerCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_white_cabinet_inner_corner"))));
    public static final RegistryObject<Block> KITCHEN_SET_WHITE_CABINET_OUTER_CORNER = registerBlock("kitchen_set_white_cabinet_outer_corner",
            () -> new KitchenOuterCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_white_cabinet_outer_corner"))));
    public static final RegistryObject<Block> KITCHEN_SET_WHITE_COUNTER = registerBlock("kitchen_set_white_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_white_counter"))));
    public static final RegistryObject<Block> KITCHEN_SET_WHITE_COUNTER_INNER_CORNER = registerBlock("kitchen_set_white_counter_inner_corner",
            () -> new KitchenInnerCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_white_counter_inner_corner")).noOcclusion()));
    public static final RegistryObject<Block> KITCHEN_SET_WHITE_COUNTER_OUTER_CORNER_LEFT = registerBlock("kitchen_set_white_counter_outer_corner_left",
            () -> new KitchenCounterLeftBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_white_counter_outer_corner_left"))));
    public static final RegistryObject<Block> KITCHEN_SET_WHITE_COUNTER_OUTER_CORNER_RIGHT = registerBlock("kitchen_set_white_counter_outer_corner_right",
            () -> new KitchenCounterRightBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_white_counter_outer_corner_right"))));
    public static final RegistryObject<Block> KITCHEN_SET_WHITE_COUNTER_SINK = registerBlock("kitchen_set_white_counter_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_white_counter_sink"))));

    public static final RegistryObject<Block> KITCHEN_SET_YELLOW_CABINET = registerBlock("kitchen_set_yellow_cabinet",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_yellow_cabinet"))));
    public static final RegistryObject<Block> KITCHEN_SET_YELLOW_CABINET_MINI = registerBlock("kitchen_set_yellow_cabinet_mini",
            () -> new KitchenHalfCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_yellow_cabinet_mini"))));
    public static final RegistryObject<Block> KITCHEN_SET_YELLOW_CABINET_GLASS = registerBlock("kitchen_set_yellow_cabinet_glass",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_yellow_cabinet_glass"))));
    public static final RegistryObject<Block> KITCHEN_SET_YELLOW_CABINET_OPEN = registerBlock("kitchen_set_yellow_cabinet_open",
            () -> new KitchenCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_yellow_cabinet_open"))));
    public static final RegistryObject<Block> KITCHEN_SET_YELLOW_CABINET_INNER_CORNER = registerBlock("kitchen_set_yellow_cabinet_inner_corner",
            () -> new KitchenInnerCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_yellow_cabinet_inner_corner"))));
    public static final RegistryObject<Block> KITCHEN_SET_YELLOW_CABINET_OUTER_CORNER = registerBlock("kitchen_set_yellow_cabinet_outer_corner",
            () -> new KitchenOuterCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_yellow_cabinet_outer_corner"))));
    public static final RegistryObject<Block> KITCHEN_SET_YELLOW_COUNTER = registerBlock("kitchen_set_yellow_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_yellow_counter"))));
    public static final RegistryObject<Block> KITCHEN_SET_YELLOW_COUNTER_INNER_CORNER = registerBlock("kitchen_set_yellow_counter_inner_corner",
            () -> new KitchenInnerCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_yellow_counter_inner_corner")).noOcclusion()));
    public static final RegistryObject<Block> KITCHEN_SET_YELLOW_COUNTER_OUTER_CORNER_LEFT = registerBlock("kitchen_set_yellow_counter_outer_corner_left",
            () -> new KitchenCounterLeftBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_yellow_counter_outer_corner_left"))));
    public static final RegistryObject<Block> KITCHEN_SET_YELLOW_COUNTER_OUTER_CORNER_RIGHT = registerBlock("kitchen_set_yellow_counter_outer_corner_right",
            () -> new KitchenCounterRightBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_yellow_counter_outer_corner_right"))));
    public static final RegistryObject<Block> KITCHEN_SET_YELLOW_COUNTER_SINK = registerBlock("kitchen_set_yellow_counter_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("kitchen_set_yellow_counter_sink"))));


    public static final RegistryObject<Block> CHINA_CABINET = registerBlock("china_cabinet",
            () -> new ChinaCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("china_cabinet")).mapColor(DyeColor.GREEN).noOcclusion()));
    public static final RegistryObject<Block> GENERAL_STORE_CABINET = registerBlock("general_store_cabinet",
            () -> new CardIndexBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("general_store_cabinet")).mapColor(DyeColor.GREEN).noOcclusion()));
    public static final RegistryObject<Block> RETRO_FRIDGE_BLACK = registerBlock("retro_fridge_black",
            () -> new FridgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_fridge_black")).mapColor(DyeColor.BLACK).noOcclusion()));
    public static final RegistryObject<Block> RETRO_FRIDGE_BLUE = registerBlock("retro_fridge_blue",
            () -> new FridgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_fridge_blue")).mapColor(DyeColor.BLUE).noOcclusion()));
    public static final RegistryObject<Block> RETRO_FRIDGE_PINK = registerBlock("retro_fridge_pink",
            () -> new FridgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_fridge_pink")).mapColor(DyeColor.PINK).noOcclusion()));
    public static final RegistryObject<Block> RETRO_FRIDGE_PURPLE = registerBlock("retro_fridge_purple",
            () -> new FridgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_fridge_purple")).mapColor(DyeColor.PURPLE).noOcclusion()));
    public static final RegistryObject<Block> RETRO_FRIDGE_RED = registerBlock("retro_fridge_red",
            () -> new FridgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_fridge_red")).mapColor(DyeColor.RED).noOcclusion()));
    public static final RegistryObject<Block> RETRO_FRIDGE_TURQUOISE = registerBlock("retro_fridge_turquoise",
            () -> new FridgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_fridge_turquoise")).mapColor(DyeColor.CYAN).noOcclusion()));
    public static final RegistryObject<Block> RETRO_FRIDGE_WHITE = registerBlock("retro_fridge_white",
            () -> new FridgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_fridge_white")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> RETRO_FRIDGE_YELLOW = registerBlock("retro_fridge_yellow",
            () -> new FridgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_fridge_yellow")).mapColor(DyeColor.YELLOW).noOcclusion()));
    public static final RegistryObject<Block> FWISH_ARMCHAIR = registerBlock("fwish_armchair",
            () -> new FwishArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("fwish_armchair")).mapColor(DyeColor.BLUE).noOcclusion()));
    public static final RegistryObject<Block> FWISH_OTTOMAN = registerBlock("fwish_ottoman",
            () -> new FwishOttomanBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("fwish_ottoman")).mapColor(DyeColor.BLUE).noOcclusion()));
    public static final RegistryObject<Block> PLANT_LADDER = registerBlock("plant_ladder",
            () -> new PlantLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("plant_ladder")).mapColor(DyeColor.BLUE).noOcclusion()));
    public static final RegistryObject<Block> STEAMPUNK_GLOBE = registerBlock("steampunk_globe",
            () -> new SteampunkGlobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("steampunk_globe")).mapColor(DyeColor.BLUE).noOcclusion()));
    public static final RegistryObject<Block> UNLIVING_CHAIR = registerBlock("unliving_chair",
            () -> new GhostChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("unliving_chair")).mapColor(DyeColor.BLUE).noOcclusion()));

    public static final RegistryObject<Block> TRADITIONAL_RADIO = registerBlock("traditional_radio",
            () -> new TraditionalRadioBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("traditional_radio")).noOcclusion()));
    public static final RegistryObject<Block> TWO_FLOWER_POTS = registerBlock("two_flower_pots",
            () -> new MushroomJarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("two_flower_pots")).sound(SoundType.DECORATED_POT)));
    public static final RegistryObject<Block> SEWING_MANNEQUIN = registerBlock("sewing_mannequin",
            () -> new SewingMannequinBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("sewing_mannequin"))));
    public static final RegistryObject<Block> STARS_PENDANT = registerBlock("stars_pendant",
            () -> new StarPendantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("stars_pendant")).sound(SoundType.SMALL_AMETHYST_BUD).mapColor(DyeColor.YELLOW).lightLevel(p -> 10).noCollision()));
    public static final RegistryObject<Block> MOON_PENDANT = registerBlock("moon_pendant",
            () -> new StarPendantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("moon_pendant")).sound(SoundType.SMALL_AMETHYST_BUD).mapColor(DyeColor.YELLOW).lightLevel(p -> 10).noCollision()));

    public static final RegistryObject<Block> OSSON_PENDANT_BLACK = registerBlock("osson_pendant_black",
            () -> new PendantLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(BLOCKS.key("osson_pendant_black")).lightLevel(p -> 15)));
    public static final RegistryObject<Block> OSSON_PENDANT_BROWN = registerBlock("osson_pendant_brown",
            () -> new PendantLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(BLOCKS.key("osson_pendant_brown")).lightLevel(p -> 15)));
    public static final RegistryObject<Block> OSSON_PENDANT_ORANGE = registerBlock("osson_pendant_orange",
            () -> new PendantLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(BLOCKS.key("osson_pendant_orange")).lightLevel(p -> 15)));
    public static final RegistryObject<Block> OSSON_PENDANT_RACING_GREEN = registerBlock("osson_pendant_racing_green",
            () -> new PendantLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(BLOCKS.key("osson_pendant_racing_green")).lightLevel(p -> 15)));
    public static final RegistryObject<Block> OSSON_PENDANT_SAGE_GREEN = registerBlock("osson_pendant_sage_green",
            () -> new PendantLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(BLOCKS.key("osson_pendant_sage_green")).lightLevel(p -> 15)));
    public static final RegistryObject<Block> OSSON_PENDANT_RED = registerBlock("osson_pendant_red",
            () -> new PendantLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(BLOCKS.key("osson_pendant_red")).lightLevel(p -> 15)));
    public static final RegistryObject<Block> OSSON_PENDANT_YELLOW = registerBlock("osson_pendant_yellow",
            () -> new PendantLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(BLOCKS.key("osson_pendant_yellow")).lightLevel(p -> 15)));
    public static final RegistryObject<Block> OSSON_PENDANT_WHITE = registerBlock("osson_pendant_white",
            () -> new PendantLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(BLOCKS.key("osson_pendant_white")).lightLevel(p -> 15)));

    public static final RegistryObject<Block> COTTAGE_BOOKCASE = registerBlock("cottage_bookcase",
            () -> new CottageBookcaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("cottage_bookcase")).noOcclusion()));
    public static final RegistryObject<Block> COTTAGE_STANDING_LAMP = registerBlock("cottage_standing_lamp",
            () -> new CottageLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("cottage_standing_lamp")).strength(0.5f).lightLevel(p -> 15)));
    public static final RegistryObject<Block> DRYING_HERBS = registerBlock("drying_herbs",
            () -> new DryingHerbsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("drying_herbs"))));
    public static final RegistryObject<Block> HANGING_CLOTH = registerBlock("hanging_cloth",
            () -> new HangingClothBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("hanging_cloth"))));

    public static final RegistryObject<Block> MINI_HANGING_TERRARIUMS = registerBlock("mini_hanging_terrariums",
            () -> new HangingMiniTerrariumsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("mini_hanging_terrariums"))));
    public static final RegistryObject<Block> OFFICE_SUPPLIES_A = registerBlock("office_supplies_a",
            () -> new ShortMediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("office_supplies_a")).strength(0.3f)));
    public static final RegistryObject<Block> OFFICE_SUPPLIES_B = registerBlock("office_supplies_b",
            () -> new ShortMediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("office_supplies_b")).strength(0.3f)));
    public static final RegistryObject<Block> RITO_BOOKS = registerBlock("rito_wooden_books",
            () -> new BunnyBookendsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("rito_wooden_books")).strength(0.4f)));
    public static final RegistryObject<Block> ROVER_MUG = registerBlock("rover_mug",
            () -> new SmallFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("rover_mug")).strength(0.3f).sound(SoundType.DECORATED_POT)));
    public static final RegistryObject<Block> SELTZER_CANS = registerBlock("seltzer_cans",
            () -> new SmallFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("seltzer_cans")).strength(0.3f).sound(SoundType.COPPER)));

    public static final RegistryObject<Block> SMALL_CAULDRON = registerBlock("small_cauldron_set",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK.weathering().unaffected()).setId(BLOCKS.key("small_cauldron_set")).strength(1.0f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> STEAMPUNK_LAMP = registerBlock("steampunk_lamp",
            () -> new SteampunkLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK.weathering().unaffected()).setId(BLOCKS.key("steampunk_lamp")).sound(SoundType.COPPER).lightLevel(p -> 15)));
    public static final RegistryObject<Block> TARRY_TOWN_STOVE = registerBlock("tarrytown_stove",
            () -> new TarrytownStoveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK.weathering().unaffected()).setId(BLOCKS.key("tarrytown_stove")).sound(SoundType.COPPER).lightLevel(p -> p.getValue(TarrytownStoveBlock.LIT) ? 15 : 0).noOcclusion()));

    //TODO
    public static final RegistryObject<Block> HOPPIN_PARK_LANTERN = registerBlock("hoppin_park_lantern",
            () -> new HoppinParkLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(BLOCKS.key("hoppin_park_lantern")).lightLevel(p -> 15)));
    public static final RegistryObject<Block> SEA_GEM_LANTERN = registerBlock("sea_gem_lantern",
            () -> new SeaGemLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(BLOCKS.key("sea_gem_lantern")).lightLevel(p -> 15)));
    public static final RegistryObject<Block> HANGING_SHELVES_PLANTS = registerBlock("hanging_shelves_plants",
            () -> new HangingShelvesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("hanging_shelves_plants")).strength(0.4f)));
    public static final RegistryObject<Block> HANGING_SHELVES_POTTERY = registerBlock("hanging_shelves_pottery",
            () -> new HangingShelvesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("hanging_shelves_pottery")).strength(0.4f)));
    public static final RegistryObject<Block> RETRO_TOASTER_BLACK = registerBlock("retro_toaster_black",
            () -> new ToasterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_toaster_black"))));
    public static final RegistryObject<Block> RETRO_TOASTER_BLUE = registerBlock("retro_toaster_blue",
            () -> new ToasterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_toaster_blue"))));
    public static final RegistryObject<Block> RETRO_TOASTER_PINK = registerBlock("retro_toaster_pink",
            () -> new ToasterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_toaster_pink"))));
    public static final RegistryObject<Block> RETRO_TOASTER_PURPLE = registerBlock("retro_toaster_purple",
            () -> new ToasterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_toaster_purple"))));
    public static final RegistryObject<Block> RETRO_TOASTER_RED = registerBlock("retro_toaster_red",
            () -> new ToasterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_toaster_red"))));
    public static final RegistryObject<Block> RETRO_TOASTER_TURQUOISE = registerBlock("retro_toaster_turquoise",
            () -> new ToasterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_toaster_turquoise"))));
    public static final RegistryObject<Block> RETRO_TOASTER_WHITE = registerBlock("retro_toaster_white",
            () -> new ToasterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_toaster_white"))));
    public static final RegistryObject<Block> RETRO_TOASTER_YELLOW = registerBlock("retro_toaster_yellow",
            () -> new ToasterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("retro_toaster_yellow"))));
    public static final RegistryObject<Block> POK_TA_POK_HOOP = registerBlock("pok_ta_pok_hoop",
            () -> new PokTaPokHoopBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).setId(BLOCKS.key("pok_ta_pok_hoop"))));
    public static final RegistryObject<Block> POK_TA_POK_HOOP_SNAKES = registerBlock("pok_ta_pok_hoop_snakes",
            () -> new PokTaPokHoopSnakesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).setId(BLOCKS.key("pok_ta_pok_hoop_snakes"))));

    public static final RegistryObject<Block> JAM_JARS = registerBlock("jam_jars",
            () -> new JamJarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("jam_jars")).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> WATERING_CAN = registerBlock("watering_can",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("watering_can")).strength(1.0f)));
    public static final RegistryObject<Block> WATERING_CAN_COPPER = registerBlock("watering_can_copper",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK.weathering().unaffected()).setId(BLOCKS.key("watering_can_copper")).strength(1.0f)));

    public static final RegistryObject<Block> VIOLET_SCREEN = registerBlock("violet_screen",
            () -> new VioletScreenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("violet_screen")).sound(SoundType.WOOD)));

    //SMALL TABLES
    public static final RegistryObject<Block> COTTAGE_SIDE_TABLE = registerBlock("cottage_side_table",
            () -> new EndTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("cottage_side_table"))));
    public static final RegistryObject<Block> ENDTABLE_AMETHYST = registerBlock("endtable_amethyst",
            () -> new EndTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("endtable_amethyst"))));
    public static final RegistryObject<Block> ENDTABLE_BUBBLEGUM = registerBlock("endtable_bubblegum",
            () -> new EndTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("endtable_bubblegum"))));
    public static final RegistryObject<Block> ENDTABLE_CHARCOAL = registerBlock("endtable_charcoal",
            () -> new EndTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("endtable_charcoal"))));
    public static final RegistryObject<Block> ENDTABLE_MEADOW = registerBlock("endtable_meadow",
            () -> new EndTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("endtable_meadow"))));
    public static final RegistryObject<Block> ENDTABLE_PERIWINKLE = registerBlock("endtable_periwinkle",
            () -> new EndTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("endtable_periwinkle"))));
    public static final RegistryObject<Block> ENDTABLE_SUNSHINE = registerBlock("endtable_sunshine",
            () -> new EndTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("endtable_sunshine"))));
    public static final RegistryObject<Block> ENDTABLE_WOOD = registerBlock("endtable_wood",
            () -> new EndTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("endtable_wood"))));
    public static final RegistryObject<Block> NIGHTSTAND_GREEN = registerBlock("nightstand_green",
            () -> new EndTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("nightstand_green")).mapColor(DyeColor.GREEN).noOcclusion()));

    public static final RegistryObject<Block> ROSE_END_TABLE = registerBlock("rose_end_table",
            () -> new RoseEndtableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("rose_end_table")).mapColor(DyeColor.GREEN).noOcclusion()));
    public static final RegistryObject<Block> ROSE_END_TABLE_BLACK = registerBlock("rose_end_table_black",
            () -> new RoseEndtableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("rose_end_table_black")).mapColor(DyeColor.GREEN).noOcclusion()));

    public static final RegistryObject<Block> PUZZLE_PIECE_TABLE_BLUE = registerBlock("puzzle_piece_table_blue",
            () -> new PuzzlePieceTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("puzzle_piece_table_blue")).mapColor(DyeColor.BLUE).noOcclusion()));
    public static final RegistryObject<Block> PUZZLE_PIECE_TABLE_PASTEL_BLUE = registerBlock("puzzle_piece_table_pastel_blue",
            () -> new PuzzlePieceTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("puzzle_piece_table_pastel_blue")).mapColor(DyeColor.LIGHT_BLUE).noOcclusion()));
    public static final RegistryObject<Block> PUZZLE_PIECE_TABLE_PASTEL_PINK = registerBlock("puzzle_piece_table_pastel_pink",
            () -> new PuzzlePieceTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("puzzle_piece_table_pastel_pink")).mapColor(DyeColor.PINK).noOcclusion()));
    public static final RegistryObject<Block> PUZZLE_PIECE_TABLE_PASTEL_PURPLE = registerBlock("puzzle_piece_table_pastel_purple",
            () -> new PuzzlePieceTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("puzzle_piece_table_pastel_purple")).mapColor(DyeColor.PURPLE).noOcclusion()));
    public static final RegistryObject<Block> PUZZLE_PIECE_TABLE_PASTEL_YELLOW = registerBlock("puzzle_piece_table_pastel_yellow",
            () -> new PuzzlePieceTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("puzzle_piece_table_pastel_yellow")).mapColor(DyeColor.YELLOW).noOcclusion()));
    public static final RegistryObject<Block> PUZZLE_PIECE_TABLE_RED = registerBlock("puzzle_piece_table_red",
            () -> new PuzzlePieceTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("puzzle_piece_table_red")).mapColor(DyeColor.RED).noOcclusion()));
    public static final RegistryObject<Block> PUZZLE_PIECE_TABLE_YELLOW = registerBlock("puzzle_piece_table_yellow",
            () -> new PuzzlePieceTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("puzzle_piece_table_yellow")).mapColor(DyeColor.YELLOW).noOcclusion()));
    public static final RegistryObject<Block> PUZZLE_PIECE_TABLE_GREEN = registerBlock("puzzle_piece_table_green",
            () -> new PuzzlePieceTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("puzzle_piece_table_green")).mapColor(DyeColor.GREEN).noOcclusion()));

    public static final RegistryObject<Block> LEMON_TABLE = registerBlock("lemon_table",
            () -> new LemonTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CONCRETE.pick(DyeColor.YELLOW)).setId(BLOCKS.key("lemon_table")).mapColor(DyeColor.YELLOW).noOcclusion()));


    //ROTATIONAL FACE BLOCKS
    public static final RegistryObject<Block> ANTIQUE_MAP = registerBlock("antique_map",
            () -> new FlatDirectionalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPORE_BLOSSOM).setId(BLOCKS.key("antique_map")).mapColor(DyeColor.BROWN)));
    public static final RegistryObject<Block> CAULDRON_POSTER = registerBlock("cauldron_poster",
            () -> new FlatDirectionalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPORE_BLOSSOM).setId(BLOCKS.key("cauldron_poster")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> MOON_DECORATION = registerBlock("moon_decoration",
            () -> new FlatDirectionalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("moon_decoration")).lightLevel(p -> 10).sound(SoundType.SMALL_AMETHYST_BUD).mapColor(DyeColor.YELLOW).noOcclusion().noCollision()));
    public static final RegistryObject<Block> CAGED_BULB = registerBlock("caged_bulb",
            () -> new CagedBulbBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(BLOCKS.key("caged_bulb")).mapColor(DyeColor.BLACK).lightLevel(p -> 15)));
    public static final RegistryObject<Block> POLAROIDS_A = registerBlock("polaroids_a",
            () -> new FlatDirectionalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPORE_BLOSSOM).setId(BLOCKS.key("polaroids_a"))));
    public static final RegistryObject<Block> POLAROIDS_B = registerBlock("polaroids_b",
            () -> new FlatDirectionalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPORE_BLOSSOM).setId(BLOCKS.key("polaroids_b"))));
    public static final RegistryObject<Block> POLAROIDS_C = registerBlock("polaroids_c",
            () -> new FlatDirectionalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPORE_BLOSSOM).setId(BLOCKS.key("polaroids_c"))));

    public static final RegistryObject<Block> MINI_FLAG_BI = registerBlock("mini_flag_bi",
            () -> new MiniFlagBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("mini_flag_bi")).strength(0f).noCollision()));
    public static final RegistryObject<Block> MINI_FLAG_LESBIAN = registerBlock("mini_flag_lesbian",
            () -> new MiniFlagBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).setId(BLOCKS.key("mini_flag_lesbian")).strength(0f).noCollision()));
    public static final RegistryObject<Block> MINI_FLAG_TRANS = registerBlock("mini_flag_trans",
            () -> new MiniFlagBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("mini_flag_trans")).strength(0f).noCollision()));
    public static final RegistryObject<Block> MINI_FLAG_NONBINARY = registerBlock("mini_flag_nonbinary",
            () -> new MiniFlagBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("mini_flag_nonbinary")).strength(0f).noCollision()));
    public static final RegistryObject<Block> MINI_FLAG_PAN = registerBlock("mini_flag_pan",
            () -> new MiniFlagBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("mini_flag_pan")).strength(0f).noCollision()));
    public static final RegistryObject<Block> MINI_FLAG_RAINBOW = registerBlock("mini_flag_rainbow",
            () -> new MiniFlagBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("mini_flag_rainbow")).strength(0f).noCollision()));
    public static final RegistryObject<Block> MINI_FLAG_ACE = registerBlock("mini_flag_ace",
            () -> new MiniFlagBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("mini_flag_ace")).strength(0f).noCollision()));

    public static final RegistryObject<Block> ANIMATED_FLAG_ASEXUAL = registerBlock("animated_flag_asexual",
            () -> new AnimatedFlagBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("animated_flag_asexual")).noCollision().sound(SoundType.LANTERN).strength(0.5f)));
    public static final RegistryObject<Block> ANIMATED_FLAG_BISEXUAL = registerBlock("animated_flag_bisexual",
            () -> new AnimatedFlagBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("animated_flag_bisexual")).noCollision().sound(SoundType.LANTERN).strength(0.5f)));
    public static final RegistryObject<Block> ANIMATED_FLAG_PANSEXUAL = registerBlock("animated_flag_pansexual",
            () -> new AnimatedFlagBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("animated_flag_pansexual")).noCollision().sound(SoundType.LANTERN).strength(0.5f)));
    public static final RegistryObject<Block> ANIMATED_FLAG_LESBIAN = registerBlock("animated_flag_lesbian",
            () -> new AnimatedFlagBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("animated_flag_lesbian")).noCollision().sound(SoundType.LANTERN).strength(0.5f)));
    public static final RegistryObject<Block> ANIMATED_FLAG_TRANSGENDER = registerBlock("animated_flag_transgender",
            () -> new AnimatedFlagBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("animated_flag_transgender")).noCollision().sound(SoundType.LANTERN).strength(0.5f)));
    public static final RegistryObject<Block> ANIMATED_FLAG_NONBINARY = registerBlock("animated_flag_nonbinary",
            () -> new AnimatedFlagBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("animated_flag_nonbinary")).noCollision().sound(SoundType.LANTERN).strength(0.5f)));
    public static final RegistryObject<Block> ANIMATED_FLAG_RAINBOW = registerBlock("animated_flag_rainbow",
            () -> new AnimatedFlagBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("animated_flag_rainbow")).noCollision().sound(SoundType.LANTERN).strength(0.5f)));


    //DARKWOOD SET
    public static final RegistryObject<Block> DARKWOOD_CABINET = registerBlock("darkwood_cabinet",
            () -> new DarkwoodCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_cabinet")).mapColor(DyeColor.BROWN)));
    public static final RegistryObject<Block> DARKWOOD_CHAIR_GEOMETRIC = registerBlock("darkwood_chair_geometric",
            () -> new DarkwoodChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_chair_geometric")).noOcclusion()));
    public static final RegistryObject<Block> DARKWOOD_CHAIR_QUILTED = registerBlock("darkwood_chair_quilted",
            () -> new DarkwoodChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_chair_quilted")).noOcclusion()));
    public static final RegistryObject<Block> DARKWOOD_CHAIR_SOUTHERN_FLAIR = registerBlock("darkwood_chair_southern_flair",
            () -> new DarkwoodChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_chair_southern_flair")).noOcclusion()));
    public static final RegistryObject<Block> DARKWOOD_SOFA_GEOMETRIC = registerBlock("darkwood_sofa_geometric",
            () -> new DarkwoodSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_sofa_geometric")).noOcclusion()));
    public static final RegistryObject<Block> DARKWOOD_SOFA_QUILTED = registerBlock("darkwood_sofa_quilted",
            () -> new DarkwoodSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_sofa_quilted")).noOcclusion()));
    public static final RegistryObject<Block> DARKWOOD_SOFA_SOUTHERN_FLAIR = registerBlock("darkwood_sofa_southern_flair",
            () -> new DarkwoodSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("darkwood_sofa_southern_flair")).noOcclusion()));
    public static final RegistryObject<Block> DARKWOOD_CLOCK = registerBlock("darkwood_clock",
            () -> new DarkwoodClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_clock")).strength(0.4f)));
    public static final RegistryObject<Block> DARKWOOD_DECORATIVE_SHELVES_GEOMETRIC = registerBlock("darkwood_decorative_shelves_geometric",
            () -> new DarkwoodShelvesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_decorative_shelves_geometric")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> DARKWOOD_DECORATIVE_SHELVES_QUILTED = registerBlock("darkwood_decorative_shelves_quilted",
            () -> new DarkwoodShelvesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_decorative_shelves_quilted")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> DARKWOOD_DECORATIVE_SHELVES_SOUTHERN_FLAIR = registerBlock("darkwood_decorative_shelves_southern_flair",
            () -> new DarkwoodShelvesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_decorative_shelves_southern_flair")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> DARKWOOD_ENDTABLE = registerBlock("darkwood_endtable",
            () -> new DarkwoodEndtableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_endtable")).mapColor(DyeColor.GREEN).noOcclusion()));
    public static final RegistryObject<Block> DARKWOOD_STOOL = registerBlock("darkwood_stool",
            () -> new DarkwoodStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_stool")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> DARKWOOD_TABLE = registerBlock("darkwood_table",
            () -> new DarkwoodTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_table")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> DARKWOOD_BED_GEOMETRIC = registerBlock("darkwood_bed_geometric",
            () -> new DarkwoodBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_bed_geometric")).mapColor(DyeColor.BROWN).noOcclusion().bounceRestitution(0.66F)));
    public static final RegistryObject<Block> DARKWOOD_BED_QUILTED = registerBlock("darkwood_bed_quilted",
            () -> new DarkwoodBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_bed_quilted")).mapColor(DyeColor.BROWN).noOcclusion().bounceRestitution(0.66F)));
    public static final RegistryObject<Block> DARKWOOD_BED_SOUTHERN_FLAIR = registerBlock("darkwood_bed_southern_flair",
            () -> new DarkwoodBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("darkwood_bed_southern_flair")).mapColor(DyeColor.BROWN).noOcclusion().bounceRestitution(0.66F)));

    //WOODEN BLOCK BOOKSHELF
    public static final RegistryObject<Block> WOODEN_BLOCK_BOOKSHELF_PASTEL = registerBlock("wooden_block_bookshelf_pastel",
            () -> new WoodenBlockBookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("wooden_block_bookshelf_pastel")).mapColor(DyeColor.PINK).noOcclusion()));

    //PASTEL SET
    public static final RegistryObject<Block> PASTEL_BED = registerBlock("pastel_bed",
            () -> new PastelBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("pastel_bed")).mapColor(DyeColor.PINK).noOcclusion().bounceRestitution(0.66F)));
    public static final RegistryObject<Block> PASTEL_CABINET = registerBlock("pastel_cabinet",
            () -> new PastelCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("pastel_cabinet")).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> PASTEL_CHAIR = registerBlock("pastel_chair",
            () -> new PastelChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("pastel_chair")).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> PASTEL_STOOL = registerBlock("pastel_stool",
            () -> new PastelStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("pastel_stool")).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> PASTEL_LIGHT = registerBlock("pastel_light",
            () -> new PastelLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("pastel_light")).mapColor(DyeColor.PINK).lightLevel(p -> 15)));
    public static final RegistryObject<Block> PASTEL_TABLE = registerBlock("pastel_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("pastel_table")).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> PASTEL_PLUSH = registerBlock("pastel_bunny_plushie",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("pastel_bunny_plushie")).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> PASTEL_WARDROBE = registerBlock("pastel_wardrobe",
            () -> new PastelWardrobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("pastel_wardrobe")).mapColor(DyeColor.PINK).noOcclusion()));

    //LAMPS
    public static final RegistryObject<Block> BEE_LAMP = registerBlock("bee_lamp",
            () -> new BeeLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("bee_lamp")).sound(SoundType.GLASS).mapColor(DyeColor.YELLOW).lightLevel(p -> 15), false));
    public static final RegistryObject<Block> BEE_LAMP_ANGRY = registerBlock("bee_lamp_angry",
            () -> new BeeLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("bee_lamp_angry")).sound(SoundType.GLASS).mapColor(DyeColor.YELLOW).lightLevel(p -> 7), true));
    public static final RegistryObject<Block> STAINED_GLASS_LAMP = registerBlock("stained_glass_lamp",
            () -> new StainedGlassLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("stained_glass_lamp")).sound(SoundType.GLASS).mapColor(DyeColor.YELLOW).lightLevel(p -> 15)));
    public static final RegistryObject<Block> COLOSSEO_WALL_LANTERN = registerBlock("colosseo_wall_lantern",
            () -> new ColosseoLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(BLOCKS.key("colosseo_wall_lantern")).mapColor(DyeColor.GREEN).lightLevel(p -> 15)));

    //TERRARIUMS
    public static final RegistryObject<Block> GLOWSHROOM_TERRARIUM_YELLOW = registerBlock("glowshroom_terrarium_yellow",
            () -> new MushroomTerrariumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("glowshroom_terrarium_yellow")).sound(SoundType.GLASS).mapColor(DyeColor.YELLOW).lightLevel(p -> 15), true));
    public static final RegistryObject<Block> GLOWSHROOM_TERRARIUM_GREEN = registerBlock("glowshroom_terrarium_green",
            () -> new MushroomTerrariumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("glowshroom_terrarium_green")).sound(SoundType.GLASS).mapColor(DyeColor.GREEN).lightLevel(p -> 15), true));
    public static final RegistryObject<Block> GLOWSHROOM_TERRARIUM_BLUE = registerBlock("glowshroom_terrarium_blue",
            () -> new MushroomTerrariumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("glowshroom_terrarium_blue")).sound(SoundType.GLASS).mapColor(DyeColor.BLUE).lightLevel(p -> 15), true));
    public static final RegistryObject<Block> GLOWSHROOM_TERRARIUM_PURPLE = registerBlock("glowshroom_terrarium_purple",
            () -> new MushroomTerrariumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("glowshroom_terrarium_purple")).sound(SoundType.GLASS).mapColor(DyeColor.PURPLE).lightLevel(p -> 15), true));
    public static final RegistryObject<Block> GLOWSHROOM_TERRARIUM_PINK = registerBlock("glowshroom_terrarium_pink",
            () -> new MushroomTerrariumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("glowshroom_terrarium_pink")).sound(SoundType.GLASS).mapColor(DyeColor.PINK).lightLevel(p -> 15), true));
    public static final RegistryObject<Block> MUSHROOM_TERRARIUM_RED = registerBlock("mushroom_terrarium_red",
            () -> new MushroomTerrariumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("mushroom_terrarium_red")).sound(SoundType.GLASS).mapColor(DyeColor.RED), false));
    public static final RegistryObject<Block> MUSHROOM_TERRARIUM_BROWN = registerBlock("mushroom_terrarium_brown",
            () -> new MushroomTerrariumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("mushroom_terrarium_brown")).sound(SoundType.GLASS).mapColor(DyeColor.BROWN), false));


    //RECORD PLAYERS
    public static final RegistryObject<Block> RECORD_PLAYER_BLUE = registerBlock("record_player_blue",
            () -> new CustomJukeboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUKEBOX).setId(BLOCKS.key("record_player_blue")).mapColor(DyeColor.BLUE).noOcclusion()));
    public static final RegistryObject<Block> RECORD_PLAYER_BROWN = registerBlock("record_player_brown",
            () -> new CustomJukeboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUKEBOX).setId(BLOCKS.key("record_player_brown")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> RECORD_PLAYER_PINK = registerBlock("record_player_pink",
            () -> new CustomJukeboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUKEBOX).setId(BLOCKS.key("record_player_pink")).mapColor(DyeColor.PINK).noOcclusion()));
    public static final RegistryObject<Block> RECORD_PLAYER_PURPLE = registerBlock("record_player_purple",
            () -> new CustomJukeboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUKEBOX).setId(BLOCKS.key("record_player_purple")).mapColor(DyeColor.PURPLE).noOcclusion()));
    public static final RegistryObject<Block> RECORD_PLAYER_RED = registerBlock("record_player_red",
            () -> new CustomJukeboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUKEBOX).setId(BLOCKS.key("record_player_red")).mapColor(DyeColor.RED).noOcclusion()));
    public static final RegistryObject<Block> RECORD_PLAYER_WHITE = registerBlock("record_player_white",
            () -> new CustomJukeboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUKEBOX).setId(BLOCKS.key("record_player_white")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> RECORD_PLAYER_YELLOW = registerBlock("record_player_yellow",
            () -> new CustomJukeboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUKEBOX).setId(BLOCKS.key("record_player_yellow")).mapColor(DyeColor.YELLOW).noOcclusion()));

    //CAKES
    public static final RegistryObject<Block> HEART_CAKE = registerBlock("heart_cake",
            () -> new HeartCakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE).setId(BLOCKS.key("heart_cake")).mapColor(DyeColor.RED)));
    public static final RegistryObject<Block> BERRY_CAKE = registerBlock("berry_cake",
            () -> new BerryCakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE).setId(BLOCKS.key("berry_cake")).mapColor(DyeColor.RED)));

    //MISC AGAIN
    public static final RegistryObject<Block> GLASS_FLOWER_VASE = registerBlock("glass_vase_of_flowers",
            () -> new GlassFlowerVaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("glass_vase_of_flowers")).mapColor(DyeColor.GREEN)));
    public static final RegistryObject<Block> LUNAR_OBSERVATORY_PAPER_BASKET = registerBlock("lunar_observatory_basket_of_papers",
            () -> new LunarObservatoryBasketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("lunar_observatory_basket_of_papers")).mapColor(DyeColor.GREEN)));
    public static final RegistryObject<Block> LUNAR_OBSERVATORY_BOOKS = registerBlock("lunar_observatory_books",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("lunar_observatory_books")).sound(SoundType.CHERRY_WOOD).mapColor(DyeColor.BLUE)));
    public static final RegistryObject<Block> LUNAR_OBSERVATORY_GLOBE = registerBlock("lunar_observatory_globe",
            () -> new LunarObservatoryGlobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK.weathering().unaffected()).setId(BLOCKS.key("lunar_observatory_globe")).mapColor(DyeColor.YELLOW)));
    public static final RegistryObject<Block> LUNAR_OBSERVATORY_PEDESTAL = registerBlock("lunar_observatory_pedestal_table",
            () -> new LunarObservatoryPedestalTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("lunar_observatory_pedestal_table")).mapColor(DyeColor.RED)));
    public static final RegistryObject<Block> MERMAID_PEARL = registerBlock("mermaid_pearl",
            () -> new MediumFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("mermaid_pearl")).mapColor(DyeColor.RED).lightLevel(p -> 10)));
    public static final RegistryObject<Block> PAINT_WATER_JAR = registerBlock("paint_water_jar",
            () -> new SmallFurnitureBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("paint_water_jar")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> PASTRY_PLATE = registerBlock("pastry_plate",
            () -> new PastryPlateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).setId(BLOCKS.key("pastry_plate")).mapColor(DyeColor.WHITE).noCollision()));

    public static final RegistryObject<Block> ASSORTED_GLASS_JARS = registerBlock("assorted_glass_jars",
            () -> new JarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("assorted_glass_jars")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> SMALL_GLASS_JARS = registerBlock("small_glass_jars",
            () -> new JarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("small_glass_jars")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> ASSORTED_SPICE_JARS = registerBlock("small_spice_jars",
            () -> new JarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("small_spice_jars")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> LUNAR_OBSERVATORY_JARS = registerBlock("lunar_observatory_jar",
            () -> new JarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("lunar_observatory_jar")).mapColor(DyeColor.WHITE).lightLevel(p -> 8)));

    //PASTRIES
    public static final RegistryObject<Block> BLUEBERRY_MUFFIN = registerBlock("blueberry_muffin",
            () -> new PastryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).setId(BLOCKS.key("blueberry_muffin")).mapColor(DyeColor.BROWN), 3, 0.8f));
    public static final RegistryObject<Block> CHOCOLATE_CROISSANT = registerBlock("chocolate_croissant",
            () -> new PastryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).setId(BLOCKS.key("chocolate_croissant")).mapColor(DyeColor.BROWN), 4, 0.5f));
    public static final RegistryObject<Block> CINNAMON_BUN = registerBlock("cinnamon_bun",
            () -> new PastryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).setId(BLOCKS.key("cinnamon_bun")).mapColor(DyeColor.BROWN), 3, 1.5f));
    public static final RegistryObject<Block> CROISSANT = registerBlock("croissant",
            () -> new PastryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).setId(BLOCKS.key("croissant")).mapColor(DyeColor.BROWN), 2, 1.0f));
    public static final RegistryObject<Block> HAM_SANDWICH = registerBlock("ham_sandwich",
            () -> new PastryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).setId(BLOCKS.key("ham_sandwich")).mapColor(DyeColor.BROWN), 9, 1.25f));
    public static final RegistryObject<Block> PANCAKE_STACK = registerBlock("pancake_stack",
            () -> new PastryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).setId(BLOCKS.key("pancake_stack")).mapColor(DyeColor.BROWN), 7, .8f));

    //SMALL CHAIRS
    public static final RegistryObject<Block> APPLE_CHAIR = registerBlock("apple_chair",
            () -> new AppleChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("apple_chair")).mapColor(DyeColor.RED).noOcclusion()));
    public static final RegistryObject<Block> BUTTON_STOOL = registerBlock("button_stool",
            () -> new ButtonStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("button_stool")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> ROVER_STOOL = registerBlock("rover_stool",
            () -> new RoverStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("rover_stool")).mapColor(DyeColor.RED).noOcclusion()));
    public static final RegistryObject<Block> COTTAGE_CHAIR = registerBlock("cottage_chair",
            () -> new CottageChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("cottage_chair")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> COTTAGE_CHAIR_CUSHIONED = registerBlock("cottage_chair_cushioned",
            () -> new CottageChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("cottage_chair_cushioned")).mapColor(DyeColor.PINK).noOcclusion()));
    public static final RegistryObject<Block> COTTAGE_OTTOMAN = registerBlock("cottage_ottoman",
            () -> new CottageOttomanBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("cottage_ottoman")).mapColor(DyeColor.PINK).noOcclusion()));
    public static final RegistryObject<Block> MADONNA_OTTOMAN = registerBlock("madonna_ottoman",
            () -> new MadonnaOttomanBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("madonna_ottoman")).mapColor(DyeColor.BLUE).noOcclusion()));

    //GARLANDS
    public static final RegistryObject<Block> BLACK_CAT_GARLAND = registerBlock("garland_black_cat",
            () -> new GarlandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPORE_BLOSSOM).setId(BLOCKS.key("garland_black_cat")).mapColor(DyeColor.BLACK)));
    public static final RegistryObject<Block> BLOSSOM_GARLAND = registerBlock("garland_blossom",
            () -> new GarlandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPORE_BLOSSOM).setId(BLOCKS.key("garland_blossom")).mapColor(DyeColor.BLACK)));
    public static final RegistryObject<Block> BUNNY_GARLAND = registerBlock("garland_bunny",
            () -> new GarlandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPORE_BLOSSOM).setId(BLOCKS.key("garland_bunny")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> POLAROID_A_GARLAND = registerBlock("garland_polaroid_a",
            () -> new GarlandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPORE_BLOSSOM).setId(BLOCKS.key("garland_polaroid_a")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> POLAROID_B_GARLAND = registerBlock("garland_polaroid_b",
            () -> new GarlandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPORE_BLOSSOM).setId(BLOCKS.key("garland_polaroid_b")).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> SUNFLOWER_GARLAND = registerBlock("garland_sunflower",
            () -> new GarlandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPORE_BLOSSOM).setId(BLOCKS.key("garland_sunflower")).mapColor(DyeColor.YELLOW)));
    public static final RegistryObject<Block> STARRY_GARLAND = registerBlock("garland_starry",
            () -> new GarlandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPORE_BLOSSOM).setId(BLOCKS.key("garland_starry")).mapColor(DyeColor.YELLOW).lightLevel(p -> 5)));

    //KITCHEN SET SMALL
    public static final RegistryObject<Block> BLACK_CAT_COUNTER_DRAWERS= registerBlock("black_cat_counter_drawers",
            () -> new FullCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("black_cat_counter_drawers")).mapColor(DyeColor.PURPLE).noOcclusion()));
    public static final RegistryObject<Block> BLACK_CAT_COUNTER_LEFT_DOOR= registerBlock("black_cat_counter_left_door",
            () -> new FullCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("black_cat_counter_left_door")).mapColor(DyeColor.PURPLE).noOcclusion()));
    public static final RegistryObject<Block> BLACK_CAT_COUNTER_RIGHT_DOOR= registerBlock("black_cat_counter_right_door",
            () -> new FullCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("black_cat_counter_right_door")).mapColor(DyeColor.PURPLE).noOcclusion()));
    public static final RegistryObject<Block> SWEETHEART_COUNTER_DRAWERS= registerBlock("sweetheart_counter_drawers",
            () -> new FullCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("sweetheart_counter_drawers")).mapColor(DyeColor.PINK).noOcclusion()));
    public static final RegistryObject<Block> SWEETHEART_COUNTER_LEFT_DOOR= registerBlock("sweetheart_counter_left_door",
            () -> new FullCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("sweetheart_counter_left_door")).mapColor(DyeColor.PINK).noOcclusion()));
    public static final RegistryObject<Block> SWEETHEART_COUNTER_RIGHT_DOOR= registerBlock("sweetheart_counter_right_door",
            () -> new FullCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("sweetheart_counter_right_door")).mapColor(DyeColor.PINK).noOcclusion()));

    //MULTIBLOCK FURNITURE
    //MISC NO FUNCTION
    public static final RegistryObject<Block> DESK_GREEN = registerBlock("desk_green",
            () -> new GreenDeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("desk_green")).sound(SoundType.WOOD).mapColor(DyeColor.GREEN).noOcclusion()));
    public static final RegistryObject<Block> DESK_BROWN = registerBlock("desk_brown",
            () -> new GreenDeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("desk_brown")).sound(SoundType.WOOD).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> DESK_GREEN_CLUTTERED = registerBlock("desk_green_cluttered",
            () -> new GreenDeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("desk_green_cluttered")).sound(SoundType.WOOD).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> DESK_BROWN_CLUTTERED = registerBlock("desk_brown_cluttered",
            () -> new GreenDeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("desk_brown_cluttered")).sound(SoundType.WOOD).mapColor(DyeColor.BROWN).noOcclusion()));

    public static final RegistryObject<Block> ANTIQUE_LIBRARY_BOOKS = registerBlock("antique_library_books",
            () -> new AntiqueLibraryBooksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).setId(BLOCKS.key("antique_library_books")).sound(SoundType.CHERRY_WOOD).mapColor(DyeColor.RED).noOcclusion()));

    public static final RegistryObject<Block> GUMBALL_MACHINE_RED = registerBlock("gumball_machine_red",
            () -> new GumballMachineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("gumball_machine_red")).mapColor(DyeColor.RED).noOcclusion()));
    public static final RegistryObject<Block> GUMBALL_MACHINE_BLUE = registerBlock("gumball_machine_blue",
            () -> new GumballMachineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("gumball_machine_blue")).mapColor(DyeColor.BLUE)));
    public static final RegistryObject<Block> GUMBALL_MACHINE_PURPLE = registerBlock("gumball_machine_purple",
            () -> new GumballMachineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("gumball_machine_purple")).mapColor(DyeColor.PURPLE)));
    public static final RegistryObject<Block> BULLETIN_BOARD = registerBlock("bulletin_board",
            () -> new BullitenBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("bulletin_board")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> BULLETIN_BOARD_CLUTTERED = registerBlock("bulletin_board_cluttered",
            () -> new BullitenBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("bulletin_board_cluttered")).mapColor(DyeColor.BROWN).noOcclusion()));

    public static final RegistryObject<Block> SMALL_BOOKCASE = registerBlock("small_bookcase",
            () -> new SmallBookcaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("small_bookcase")).mapColor(DyeColor.BROWN).noOcclusion()));

    //CABINETS AND SHELVES
    public static final RegistryObject<Block> CARD_INDEX = registerBlock("card_index",
            () -> new CardIndexBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("card_index")).mapColor(DyeColor.GREEN).noOcclusion()));
    public static final RegistryObject<Block> BAMBOO_BOOKSHELF = registerBlock("bamboo_bookshelf",
            () -> new TwoByTwoFullSizeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("bamboo_bookshelf")).mapColor(DyeColor.GREEN).noOcclusion()));
    public static final RegistryObject<Block> FWISH_BOOKCASE = registerBlock("fwish_bookcase",
            () -> new FwishBookcaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).setId(BLOCKS.key("fwish_bookcase")).mapColor(DyeColor.BLUE).noOcclusion()));

    public static final RegistryObject<Block> RETRO_CAFE_SHELF = registerBlock("retro_cafe_shelf",
            () -> new TwoByTwoFullSizeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("retro_cafe_shelf")).sound(SoundType.WOOD).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> RETRO_CAFE_SHELF_WINDOW = registerBlock("retro_cafe_shelf_window",
            () -> new RetroCafeShelfWindowBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("retro_cafe_shelf_window")).sound(SoundType.GLASS).mapColor(DyeColor.PURPLE).noOcclusion()));

    public static final RegistryObject<Block> POTION_SHELF = registerBlock("potion_shelf",
            () -> new TwoByTwoFullSizeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("potion_shelf")).sound(SoundType.WOOD).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> DORADO_CABINET = registerBlock("dorado_cabinet",
            () -> new DoradoCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("dorado_cabinet")).sound(SoundType.WOOD).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> DORADO_CABINET_CLUTTERED = registerBlock("dorado_cabinet_cluttered",
            () -> new DoradoCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("dorado_cabinet_cluttered")).sound(SoundType.WOOD).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> HAVANA_CABINET = registerBlock("havana_cabinet",
            () -> new DoradoCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("havana_cabinet")).sound(SoundType.WOOD).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> HAVANA_CABINET_CLUTTERED = registerBlock("havana_cabinet_cluttered",
            () -> new DoradoCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("havana_cabinet_cluttered")).sound(SoundType.WOOD).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> MUREX_CABINET = registerBlock("murex_cabinet",
            () -> new DoradoCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("murex_cabinet")).sound(SoundType.WOOD).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> MUREX_CABINET_CLUTTERED = registerBlock("murex_cabinet_cluttered",
            () -> new DoradoCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("murex_cabinet_cluttered")).sound(SoundType.WOOD).mapColor(DyeColor.BROWN).noOcclusion()));

    public static final RegistryObject<Block> MERMAID_DRESSER = registerBlock("mermaid_dresser",
            () -> new MermaidDresserBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(BLOCKS.key("mermaid_dresser")).sound(SoundType.WOOD).mapColor(DyeColor.PINK).noOcclusion()));

    public static final RegistryObject<Block> BLACK_CAT_SINK = registerBlock("black_cat_sink",
            () -> new DoubleSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("black_cat_sink")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> BLACK_CAT_TABLE = registerBlock("black_cat_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("black_cat_table")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> SWEETHEART_SINK = registerBlock("sweetheart_sink",
            () -> new DoubleSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("sweetheart_sink")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> SWEETHEART_TABLE = registerBlock("sweetheart_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("sweetheart_table")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> WEDDING_ARCH = registerBlock("wedding_arch",
            () -> new WeddingArchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("wedding_arch")).mapColor(DyeColor.BROWN).noOcclusion()));

    //TODO
    public static final RegistryObject<Block> CUPID_BENCH = registerBlock("cupid_bench",
            () -> new CupidBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(BLOCKS.key("cupid_bench")).mapColor(DyeColor.WHITE).noOcclusion()));
    public static final RegistryObject<Block> SEWING_CLUTTER = registerBlock("sewing_clutter",
            () -> new SewingClutterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.PINK)).setId(BLOCKS.key("sewing_clutter")).mapColor(DyeColor.GREEN).lightLevel(p -> p.getValue(SewingClutterBlock.MULTIBLOCK_PART) == 2 ? 10 : 0).noOcclusion()));
    public static final RegistryObject<Block> PASTRY_DISPLAY_CASE = registerBlock("pastry_display_case",
            () -> new PastryDisplayCaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("pastry_display_case")).mapColor(DyeColor.BLACK).noOcclusion()));
    public static final RegistryObject<Block> IMPERIAL_CHAIR = registerBlock("imperial_chair",
            () -> new CottageChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("imperial_chair")).mapColor(DyeColor.BLACK)));


    //TABLES
    public static final RegistryObject<Block> TABLE_PLAIN = registerBlock("table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("table")).mapColor(DyeColor.BROWN)));
    public static final RegistryObject<Block> TABLE_TABLECLOTH = registerBlock("table_with_white_tablecloth",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("table_with_white_tablecloth")).mapColor(DyeColor.WHITE)));

    public static final RegistryObject<Block> SEWING_TABLE = registerBlock("sewing_table_with_tablecloth",
            () -> new SewingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("sewing_table_with_tablecloth")).mapColor(DyeColor.BROWN)));
    public static final RegistryObject<Block> IMPERIAL_TABLE = registerBlock("imperial_table",
            () -> new ImperialTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("imperial_table")).mapColor(DyeColor.BLACK)));
    public static final RegistryObject<Block> LUNAR_OBSERVATORY_TABLE = registerBlock("lunar_observatory_table",
            () -> new LunarObservatoryTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("lunar_observatory_table")).mapColor(DyeColor.BROWN)));

    public static final RegistryObject<Block> CONFECTIONERY_TABLE_PINK = registerBlock("confectionery_table_pink",
            () -> new ConfectioneryTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("confectionery_table_pink")).mapColor(DyeColor.BROWN).noOcclusion()));
    public static final RegistryObject<Block> CONFECTIONERY_TABLE_BLUE = registerBlock("confectionery_table_blue",
            () -> new ConfectioneryTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(BLOCKS.key("confectionery_table_blue")).mapColor(DyeColor.BROWN).noOcclusion()));


    //BIKES
    public static final RegistryObject<Block> BIKE_YELLOW = registerBlock("bicycle_yellow",
            () -> new BicycleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("bicycle_yellow")).mapColor(DyeColor.YELLOW).noOcclusion()));
    public static final RegistryObject<Block> BIKE_BLUE = registerBlock("bicycle_blue",
            () -> new BicycleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("bicycle_blue")).mapColor(DyeColor.BLUE).noOcclusion()));
    public static final RegistryObject<Block> BIKE_PURPLE = registerBlock("bicycle_purple",
            () -> new BicycleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("bicycle_purple")).mapColor(DyeColor.PURPLE).noOcclusion()));
    public static final RegistryObject<Block> BIKE_PINK = registerBlock("bicycle_pink",
            () -> new BicycleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("bicycle_pink")).mapColor(DyeColor.PINK).noOcclusion()));
    public static final RegistryObject<Block> BIKE_YELLOW_FLOWERS = registerBlock("bicycle_with_flowers_yellow",
            () -> new BicycleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("bicycle_with_flowers_yellow")).mapColor(DyeColor.YELLOW).noOcclusion()));
    public static final RegistryObject<Block> BIKE_BLUE_FLOWERS = registerBlock("bicycle_with_flowers_blue",
            () -> new BicycleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("bicycle_with_flowers_blue")).mapColor(DyeColor.BLUE).noOcclusion()));
    public static final RegistryObject<Block> BIKE_PURPLE_FLOWERS = registerBlock("bicycle_with_flowers_purple",
            () -> new BicycleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("bicycle_with_flowers_purple")).mapColor(DyeColor.PURPLE).noOcclusion()));
    public static final RegistryObject<Block> BIKE_PINK_FLOWERS = registerBlock("bicycle_with_flowers_pink",
            () -> new BicycleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).setId(BLOCKS.key("bicycle_with_flowers_pink")).mapColor(DyeColor.PINK).noOcclusion()));

    //LAMPS
    public static final RegistryObject<Block> ANTIQUE_STANDING_LAMP = registerBlock("antique_standing_lamp",
            () -> new AntiqueLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).setId(BLOCKS.key("antique_standing_lamp")).mapColor(DyeColor.BROWN).lightLevel(p -> 15)));

    //CHAIRS
    public static final RegistryObject<Block> LOVELY_LOVE_SEAT = registerBlock("lovely_love_seat_basic",
            () -> new LovelyLoveSeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("lovely_love_seat_basic")).noOcclusion()));
    public static final RegistryObject<Block> LOVELY_LOVE_SEAT_BLACK = registerBlock("lovely_love_seat_black",
            () -> new LovelyLoveSeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("lovely_love_seat_black")).noOcclusion()));

    //ARMCHAIRS
    public static final RegistryObject<Block> ARMCHAIR_BLACK = registerBlock("armchair_black",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLACK)).setId(BLOCKS.key("armchair_black")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_BLACK_CAT = registerBlock("armchair_black_cat",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLACK)).setId(BLOCKS.key("armchair_black_cat")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_BLUE = registerBlock("armchair_blue",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("armchair_blue")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_BROWN = registerBlock("armchair_brown",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).setId(BLOCKS.key("armchair_brown")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_CYAN = registerBlock("armchair_cyan",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.CYAN)).setId(BLOCKS.key("armchair_cyan")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_FLOWER = registerBlock("armchair_flower",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("armchair_flower")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_FUCHSIA = registerBlock("armchair_fuchsia",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.MAGENTA)).setId(BLOCKS.key("armchair_fuchsia")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_GRAY = registerBlock("armchair_gray",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GRAY)).setId(BLOCKS.key("armchair_gray")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_GREEN = registerBlock("armchair_green",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GREEN)).setId(BLOCKS.key("armchair_green")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_HEART = registerBlock("armchair_heart",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("armchair_heart")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_IVORY = registerBlock("armchair_ivory",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("armchair_ivory")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_LEMON = registerBlock("armchair_lemon",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("armchair_lemon")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_LIGHT_BLUE = registerBlock("armchair_light_blue",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIGHT_BLUE)).setId(BLOCKS.key("armchair_light_blue")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_LIGHT_GRAY = registerBlock("armchair_light_gray",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIGHT_GRAY)).setId(BLOCKS.key("armchair_light_gray")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_LIME = registerBlock("armchair_lime",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("armchair_lime")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_MAGENTA = registerBlock("armchair_magenta",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLACK)).setId(BLOCKS.key("armchair_magenta")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_ORANGE = registerBlock("armchair_orange",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).setId(BLOCKS.key("armchair_orange")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_PINK = registerBlock("armchair_pink",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("armchair_pink")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_PURPLE = registerBlock("armchair_purple",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).setId(BLOCKS.key("armchair_purple")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_RED = registerBlock("armchair_red",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).setId(BLOCKS.key("armchair_red")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_STARRY = registerBlock("armchair_starry",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).setId(BLOCKS.key("armchair_starry")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_STRAWBERRY = registerBlock("armchair_strawberry",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).setId(BLOCKS.key("armchair_strawberry")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_WATERMELON = registerBlock("armchair_watermelon",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).setId(BLOCKS.key("armchair_watermelon")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_WHITE = registerBlock("armchair_white",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("armchair_white")).noOcclusion()));
    public static final RegistryObject<Block> ARMCHAIR_YELLOW = registerBlock("armchair_yellow",
            () -> new ArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).setId(BLOCKS.key("armchair_yellow")).noOcclusion()));

    public static final RegistryObject<Block> COTTAGE_ARMCHAIR = registerBlock("cottage_armchair",
            () -> new CottageArmchairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).setId(BLOCKS.key("cottage_armchair")).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<T> registerFuelBlock(String name, Supplier<T> block, int burnTime) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerFuelBlockItem(name, toReturn, burnTime);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemRegistration.ITEMS.register(name, () -> new BlockItem(block.get(), blockItemProperties(name)));
    }
    private static <T extends Block> RegistryObject<Item> registerFuelBlockItem(String name, RegistryObject<T> block, int burnTime) {
        return ItemRegistration.ITEMS.register(name, () -> new BlockItem(block.get(),
                withCookingFuel(blockItemProperties(name), burnTime)));
    }

    public static void register (BusGroup eventBus) {
        BLOCKS.register(eventBus);
    }

    public static void registerFabricContent() {
        registerFlammableBlocks();
        registerStrippableBlocks();
    }

    private static Item.Properties blockItemProperties(String name) {
        Item.Properties properties = new Item.Properties().setId(ItemRegistration.ITEMS.key(name));
        ResourceKey<ContextIntProvider> compostable = switch (name) {
            case "flower_carpet_willow", "flower_carpet_poplar", "flower_carpet_crabapple" -> COMPOSTABLE_VERY_LOW;
            case "willow_vines" -> ContextIntProviders.COMPOSTABLE_LOW_MEDIUM;
            case "blue_mushroom_sapling", "red_mushroom_sapling" -> ContextIntProviders.COMPOSTABLE_MEDIUM;
            case "willow_leaves", "willow_sapling", "poplar_leaves", "flowering_poplar_leaves",
                    "poplar_sapling", "crabapple_leaves", "crabapple_sapling", "sycamore_leaves",
                    "sycamore_sapling", "flowering_fluorescent_maple_leaves", "fluorescent_maple_leaves",
                    "fluorescent_maple_sapling" -> ContextIntProviders.COMPOSTABLE_LOW;
            default -> null;
        };
        return compostable == null ? properties : properties.compostable(compostable);
    }

    private static Item.Properties withCookingFuel(Item.Properties properties, int burnTime) {
        return properties.component(DataComponents.COOKING_FUEL, new CookingFuel(
                new ResolvableInt.Constant(burnTime), new ResolvableFloat.Constant(1.0F)));
    }

    private static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        for (RegistryObject<? extends Block> entry : BLOCKS.entries()) {
            Block block = entry.get();

            if (block instanceof CustomLeavesBlock) {
                registry.add(block, 30, 60);
            } else if (block instanceof CustomLogLikeBlock) {
                registry.add(block, 5, 5);
            } else if (isWoodLike(block)) {
                registry.add(block, 5, 20);
            }
        }
    }

    private static void registerStrippableBlocks() {
        for (RegistryObject<? extends Block> entry : BLOCKS.entries()) {
            if (entry.get() instanceof CustomLogLikeBlock log) {
                Block stripped = log.getFabricStrippedCounterpart();
                if (stripped != null) {
                    BlockTransformerHelper.registerStripping(log, stripped);
                }
            }
        }
    }

    private static boolean isWoodLike(Block block) {
        return block instanceof CustomWoodBlock
                || block instanceof CustomHorizontalWoodBlock
                || block instanceof CustomWoodSlabBlock
                || block instanceof CustomWoodStairs
                || block instanceof CustomWoodFenceBlock
                || block instanceof CustomWoodFenceGate
                || block instanceof WoodPicketFenceGateBlock
                || block instanceof DoorBlock
                || block instanceof TrapDoorBlock
                || block instanceof ButtonBlock
                || block instanceof PressurePlateBlock;
    }

}
