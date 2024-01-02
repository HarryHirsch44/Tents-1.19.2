package net.harryhirsch4.mccamping.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class Tent extends BedBlock {

    public Tent(DyeColor color, Properties properties) {
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
            BlockEntity entity = level.getBlockEntity(pos);
            //if (entity instanceof BedBlockEntity) {
                TentInventoryEntity tentEntity = new TentInventoryEntity(entity.getBlockPos(),entity.getBlockState());
                    System.out.println("entity");
                    player.openMenu(tentEntity);
                    System.out.println("entity2");
                    player.awardStat(Stats.OPEN_SHULKER_BOX);
                    System.out.println("entity3");

                    PiglinAi.angerNearbyPiglins(player, true);

                return InteractionResult.CONSUME;
           // } else {
                //return InteractionResult.PASS;
            //}
        }
        //Detect sneaking of player
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    private static final VoxelShape SHAPE = Stream.of(
        Block.box(0,0,0,16,32,16)
    ).reduce((v1,v2) -> Shapes.join(v1,v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
