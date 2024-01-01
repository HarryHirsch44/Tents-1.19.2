package net.harryhirsch4.mccamping.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
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
    public static final EnumProperty COLOR = EnumProperty.create("color", DyeColor.class);

    public Tent(DyeColor color, Properties properties) {
        super(color, properties);
        //this.registerDefaultState(this.stateDefinition.any().setValue(COLOR, color));
    }

    @Override
    public void setBedOccupied(BlockState state, Level level, BlockPos pos, LivingEntity sleeper, boolean occupied) {
        super.setBedOccupied(state, level, pos, sleeper, occupied);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        System.out.println(state.getValue(COLOR));
        return super.use(state, level, pos, player, hand, result);
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

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        //builder.add(COLOR);
        super.createBlockStateDefinition(builder);
    }
}
