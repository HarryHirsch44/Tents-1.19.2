package net.harryhirsch4.mccamping;

import com.mojang.logging.LogUtils;
import net.harryhirsch4.mccamping.block.ModBlocks;
import net.harryhirsch4.mccamping.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MCCamping.MOD_ID)
public class MCCamping {
    public static final String MOD_ID = "mccamping";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MCCamping() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void clientSetup (final FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_WHITE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_LIGHT_GRAY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_GRAY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_BLACK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_BROWN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_RED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_ORANGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_YELLOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_LIME.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_GREEN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_CYAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_LIGHT_BLUE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_BLUE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_PURPLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_MAGENTA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TENT_PINK.get(), RenderType.cutout());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
