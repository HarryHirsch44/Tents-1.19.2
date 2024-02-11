package net.harryhirsch4.mccamping.block.entity;

import net.harryhirsch4.mccamping.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class TentWithChest extends BedBlock {
    public static final ResourceLocation CONTENTS;


    public TentWithChest(DyeColor color, Properties properties) {
        super(color, properties);
    }

    @Override
    public void setBedOccupied(BlockState state, Level level, BlockPos pos, LivingEntity sleeper, boolean occupied) {
        super.setBedOccupied(state, level, pos, sleeper, occupied);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(!player.isCrouching()){
            return super.use(state, level, pos, player, hand, result);
        }
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else if (player.isSpectator()) {
            return InteractionResult.CONSUME;
        } else {
            if (state.getValue(PART) != BedPart.FOOT){
                pos = pos.relative((Direction)state.getValue(FACING));
            }
                BlockEntity entity = level.getBlockEntity(pos);
            if (entity instanceof TentBlockEntity) {
                TentBlockEntity tent = (TentBlockEntity)entity;
                player.openMenu(tent);
                player.awardStat(Stats.OPEN_SHULKER_BOX);
                PiglinAi.angerNearbyPiglins(player, true);

                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    private static final VoxelShape SHAPE = Stream.of(
        Block.box(0,0,0,16,15.9,16)
    ).reduce((v1,v2) -> Shapes.join(v1,v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TentBlockEntity(pos,state);
    }

    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (state.getValue(PART) != BedPart.FOOT){
            pos = pos.relative((Direction)state.getValue(FACING));
        }
        BlockEntity entity = level.getBlockEntity(pos);
        if (entity instanceof TentBlockEntity $$5) {
            if (!level.isClientSide && player.isCreative() && !$$5.isEmpty() && state.getValue(PART) == BedPart.FOOT) {
                ItemStack $$6 = getColoredItemStack(this.getColor());
                entity.saveToItem($$6);
                if ($$5.hasCustomName()) {
                    $$6.setHoverName($$5.getCustomName());
                }

                ItemEntity $$7 = new ItemEntity(level, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, $$6);
                $$7.setDefaultPickUpDelay();
                level.addFreshEntity($$7);
            } else {
                $$5.unpackLootTable(player);
            }
        }
    }

    public static ItemStack getColoredItemStack(@Nullable DyeColor p_56251_) {
        return new ItemStack(getBlockByColor(p_56251_));
    }

    public static Block getBlockByColor(@Nullable DyeColor p_56191_) {
        if (p_56191_ == null) {
            return ModBlocks.TENT_WITH_CHEST_WHITE.get();
        } else {
            switch (p_56191_) {
                case WHITE:
                default:
                    return ModBlocks.TENT_WITH_CHEST_WHITE.get();
                case ORANGE:
                    return ModBlocks.TENT_WITH_CHEST_ORANGE.get();
                case MAGENTA:
                    return ModBlocks.TENT_WITH_CHEST_MAGENTA.get();
                case LIGHT_BLUE:
                    return ModBlocks.TENT_WITH_CHEST_LIGHT_BLUE.get();
                case YELLOW:
                    return ModBlocks.TENT_WITH_CHEST_YELLOW.get();
                case LIME:
                    return ModBlocks.TENT_WITH_CHEST_LIME.get();
                case PINK:
                    return ModBlocks.TENT_WITH_CHEST_PINK.get();
                case GRAY:
                    return ModBlocks.TENT_WITH_CHEST_GRAY.get();
                case LIGHT_GRAY:
                    return ModBlocks.TENT_WITH_CHEST_LIGHT_GRAY.get();
                case CYAN:
                    return ModBlocks.TENT_WITH_CHEST_CYAN.get();
                case PURPLE:
                    return ModBlocks.TENT_WITH_CHEST_PURPLE.get();
                case BLUE:
                    return ModBlocks.TENT_WITH_CHEST_BLUE.get();
                case BROWN:
                    return ModBlocks.TENT_WITH_CHEST_BROWN.get();
                case GREEN:
                    return ModBlocks.TENT_WITH_CHEST_GREEN.get();
                case RED:
                    return ModBlocks.TENT_WITH_CHEST_RED.get();
                case BLACK:
                    return ModBlocks.TENT_WITH_CHEST_BLACK.get();
            }
        }
    }

    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        if(state.getValue(PART) != BedPart.FOOT)
        {
            return Collections.emptyList();
        }
        BlockEntity $$2 = (BlockEntity)builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if ($$2 instanceof TentBlockEntity $$3) {
            builder = builder.withDynamicDrop(CONTENTS, (p_56218_, p_56219_) -> {
                for(int $$3x = 0; $$3x < $$3.getContainerSize(); ++$$3x) {
                    p_56219_.accept($$3.getItem($$3x));
                }

            });
        }

        return super.getDrops(state, builder);
    }

    static {
        CONTENTS = new ResourceLocation("contents");
    }
}