package net.harryhirsch4.mccamping.block;

import net.harryhirsch4.mccamping.MCCamping;
import net.harryhirsch4.mccamping.block.entity.Tent;
import net.harryhirsch4.mccamping.block.entity.TentWithChest;
import net.harryhirsch4.mccamping.item.ModCreativeModeTab;
import net.harryhirsch4.mccamping.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCCamping.MOD_ID);

public static final RegistryObject<Block> TENT_WHITE = registerBlock("white_tent",
        () -> new Tent(
                DyeColor.WHITE,
                BlockBehaviour.Properties
                        .copy(Blocks.WHITE_WOOL)
                        .noOcclusion()
                        .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
        ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_LIGHT_GRAY = registerBlock("light_gray_tent",
            () -> new Tent(
                    DyeColor.LIGHT_GRAY,
                    BlockBehaviour.Properties
                            .copy(Blocks.LIGHT_GRAY_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_GRAY = registerBlock("gray_tent",
            () -> new Tent(
                    DyeColor.GRAY,
                    BlockBehaviour.Properties
                            .copy(Blocks.GRAY_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_BLACK = registerBlock("black_tent",
            () -> new Tent(
                    DyeColor.BLACK,
                    BlockBehaviour.Properties
                            .copy(Blocks.BLACK_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_BROWN = registerBlock("brown_tent",
            () -> new Tent(
                    DyeColor.BROWN,
                    BlockBehaviour.Properties
                            .copy(Blocks.BROWN_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_RED = registerBlock("red_tent",
            () -> new Tent(
                    DyeColor.RED,
                    BlockBehaviour.Properties
                            .copy(Blocks.RED_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_ORANGE = registerBlock("orange_tent",
            () -> new Tent(
                    DyeColor.ORANGE,
                    BlockBehaviour.Properties
                            .copy(Blocks.ORANGE_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_YELLOW = registerBlock("yellow_tent",
            () -> new Tent(
                    DyeColor.YELLOW,
                    BlockBehaviour.Properties
                            .copy(Blocks.YELLOW_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_LIME = registerBlock("lime_tent",
            () -> new Tent(
                    DyeColor.LIME,
                    BlockBehaviour.Properties
                            .copy(Blocks.LIME_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_GREEN = registerBlock("green_tent",
            () -> new Tent(
                    DyeColor.GREEN,
                    BlockBehaviour.Properties
                            .copy(Blocks.GREEN_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_CYAN = registerBlock("cyan_tent",
            () -> new Tent(
                    DyeColor.CYAN,
                    BlockBehaviour.Properties
                            .copy(Blocks.CYAN_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_LIGHT_BLUE = registerBlock("light_blue_tent",
            () -> new Tent(
                    DyeColor.LIGHT_BLUE,
                    BlockBehaviour.Properties
                            .copy(Blocks.LIGHT_BLUE_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_BLUE = registerBlock("blue_tent",
            () -> new Tent(
                    DyeColor.BLUE,
                    BlockBehaviour.Properties
                            .copy(Blocks.BLUE_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_PURPLE = registerBlock("purple_tent",
            () -> new Tent(
                    DyeColor.PURPLE,
                    BlockBehaviour.Properties
                            .copy(Blocks.PURPLE_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_MAGENTA = registerBlock("magenta_tent",
            () -> new Tent(
                    DyeColor.MAGENTA,
                    BlockBehaviour.Properties
                            .copy(Blocks.MAGENTA_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
public static final RegistryObject<Block> TENT_PINK = registerBlock("pink_tent",
            () -> new Tent(
                    DyeColor.PINK,
                    BlockBehaviour.Properties
                            .copy(Blocks.PINK_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_WHITE = registerBlock("white_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.WHITE,
                    BlockBehaviour.Properties
                            .copy(Blocks.WHITE_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_LIGHT_GRAY = registerBlock("light_gray_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.LIGHT_GRAY,
                    BlockBehaviour.Properties
                            .copy(Blocks.LIGHT_GRAY_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_GRAY = registerBlock("gray_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.GRAY,
                    BlockBehaviour.Properties
                            .copy(Blocks.GRAY_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_BLACK = registerBlock("black_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.BLACK,
                    BlockBehaviour.Properties
                            .copy(Blocks.BLACK_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_BROWN = registerBlock("brown_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.BROWN,
                    BlockBehaviour.Properties
                            .copy(Blocks.BROWN_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_RED = registerBlock("red_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.RED,
                    BlockBehaviour.Properties
                            .copy(Blocks.RED_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_ORANGE = registerBlock("orange_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.ORANGE,
                    BlockBehaviour.Properties
                            .copy(Blocks.ORANGE_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_YELLOW = registerBlock("yellow_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.YELLOW,
                    BlockBehaviour.Properties
                            .copy(Blocks.YELLOW_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_LIME = registerBlock("lime_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.LIME,
                    BlockBehaviour.Properties
                            .copy(Blocks.LIME_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_GREEN = registerBlock("green_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.GREEN,
                    BlockBehaviour.Properties
                            .copy(Blocks.GREEN_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_CYAN = registerBlock("cyan_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.CYAN,
                    BlockBehaviour.Properties
                            .copy(Blocks.CYAN_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_LIGHT_BLUE = registerBlock("light_blue_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.LIGHT_BLUE,
                    BlockBehaviour.Properties
                            .copy(Blocks.LIGHT_BLUE_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_BLUE = registerBlock("blue_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.BLUE,
                    BlockBehaviour.Properties
                            .copy(Blocks.BLUE_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_PURPLE = registerBlock("purple_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.PURPLE,
                    BlockBehaviour.Properties
                            .copy(Blocks.PURPLE_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_MAGENTA = registerBlock("magenta_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.MAGENTA,
                    BlockBehaviour.Properties
                            .copy(Blocks.MAGENTA_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);
    public static final RegistryObject<Block> TENT_WITH_CHEST_PINK = registerBlock("pink_tent_with_chest",
            () -> new TentWithChest(
                    DyeColor.PINK,
                    BlockBehaviour.Properties
                            .copy(Blocks.PINK_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(TentWithChest.OCCUPIED) ? 10 : 15)),
            ModCreativeModeTab.CAMPING_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab).stacksTo(1)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
