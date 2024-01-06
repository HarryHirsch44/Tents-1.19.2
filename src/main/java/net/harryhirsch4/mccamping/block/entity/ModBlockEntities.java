package net.harryhirsch4.mccamping.block.entity;

import net.harryhirsch4.mccamping.MCCamping;
import net.harryhirsch4.mccamping.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MCCamping.MOD_ID);

    public static final RegistryObject<BlockEntityType<TentBlockEntity>> TENT_BLOCK =
            BLOCK_ENTITIES.register("tent_block",
                    () -> BlockEntityType.Builder.of(TentBlockEntity::new, ModBlocks.TENT_WHITE.get(),ModBlocks.TENT_LIGHT_GRAY.get(),
                            ModBlocks.TENT_GRAY.get(),ModBlocks.TENT_BLACK.get(),ModBlocks.TENT_BROWN.get(),ModBlocks.TENT_RED.get(),ModBlocks.TENT_ORANGE.get(),
                            ModBlocks.TENT_YELLOW.get(),ModBlocks.TENT_LIME.get(),ModBlocks.TENT_GREEN.get(),ModBlocks.TENT_CYAN.get(),ModBlocks.TENT_LIGHT_BLUE.get(),
                            ModBlocks.TENT_BLUE.get(),ModBlocks.TENT_PURPLE.get(),ModBlocks.TENT_MAGENTA.get(),ModBlocks.TENT_PINK.get()).build(null));

    public static void register(IEventBus eventbus){
        BLOCK_ENTITIES.register(eventbus);
    }
}
