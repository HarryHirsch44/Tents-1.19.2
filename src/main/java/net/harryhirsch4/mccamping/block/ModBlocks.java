package net.harryhirsch4.mccamping.block;

import net.harryhirsch4.mccamping.MCCamping;
import net.harryhirsch4.mccamping.block.entity.Tent;
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
                    DyeColor.BLACK,
                    BlockBehaviour.Properties
                            .copy(Blocks.LIME_WOOL)
                            .noOcclusion()
                            .lightLevel(value -> value.getValue(Tent.OCCUPIED) ? 15 : 10)),
            ModCreativeModeTab.CAMPING_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
