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

    public static final RegistryObject<BlockEntityType<TentBlockEntity>> TENT_WITH_CHEST_BLOCK =
            BLOCK_ENTITIES.register("tent_block",
                    () -> BlockEntityType.Builder.of(TentBlockEntity::new, ModBlocks.TENT_WITH_CHEST_WHITE.get(),ModBlocks.TENT_WITH_CHEST_LIGHT_GRAY.get(),
                            ModBlocks.TENT_WITH_CHEST_GRAY.get(),ModBlocks.TENT_WITH_CHEST_BLACK.get(),ModBlocks.TENT_WITH_CHEST_BROWN.get(),ModBlocks.TENT_WITH_CHEST_RED.get(),ModBlocks.TENT_WITH_CHEST_ORANGE.get(),
                            ModBlocks.TENT_WITH_CHEST_YELLOW.get(),ModBlocks.TENT_WITH_CHEST_LIME.get(),ModBlocks.TENT_WITH_CHEST_GREEN.get(),ModBlocks.TENT_WITH_CHEST_CYAN.get(),ModBlocks.TENT_WITH_CHEST_LIGHT_BLUE.get(),
                            ModBlocks.TENT_WITH_CHEST_BLUE.get(),ModBlocks.TENT_WITH_CHEST_PURPLE.get(),ModBlocks.TENT_WITH_CHEST_MAGENTA.get(),ModBlocks.TENT_WITH_CHEST_PINK.get()).build(null));

    public static void register(IEventBus eventbus){
        BLOCK_ENTITIES.register(eventbus);
    }
}
