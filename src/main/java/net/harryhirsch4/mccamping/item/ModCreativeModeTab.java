package net.harryhirsch4.mccamping.item;

import net.harryhirsch4.mccamping.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CAMPING_TAB = new CreativeModeTab("camping") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.TENT_GREEN.get());
        }
    };
}
