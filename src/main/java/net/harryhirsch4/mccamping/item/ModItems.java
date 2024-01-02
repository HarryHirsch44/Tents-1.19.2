package net.harryhirsch4.mccamping.item;

import net.harryhirsch4.mccamping.MCCamping;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class  ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MCCamping.MOD_ID);

    public static final RegistryObject<Item> RAW_MARSHMALLOW = ITEMS.register("raw_marshmallow",
            ()-> new Item(new Item.Properties().tab(ModCreativeModeTab.CAMPING_TAB)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(2f).build())));
    public static final RegistryObject<Item> MARSHMALLOW = ITEMS.register("marshmallow",
            ()-> new Item(new Item.Properties().tab(ModCreativeModeTab.CAMPING_TAB)
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(2f).build())));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
