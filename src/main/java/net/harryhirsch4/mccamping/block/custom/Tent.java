package net.harryhirsch4.mccamping.block.custom;

import it.unimi.dsi.fastutil.booleans.BooleanPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class Tent extends Block {
    public static final BooleanProperty ISOPEN = BooleanProperty.create("isopen");

    private static final VoxelShape SHAPE = Stream.of(
            Block.box(0,0,0,48,32,32))
            .reduce((v1,v2) -> Shapes.join(v1,v2, BooleanOp.OR)).get();
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_60572_, BlockGetter p_60573_, BlockPos p_60574_, CollisionContext p_60575_) {
        return SHAPE;
    }

    public Tent(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(level.isClientSide && hand == InteractionHand.MAIN_HAND){
            /*level.setBlock(pos, state.cycle(ISOPEN), 3);

            long worldTime = level.getDayTime() % 24000; // Get current world time in ticks
            boolean isRaining = level.isRaining();
            boolean isDaytime;
            if(isRaining){
                isDaytime = 12010 <= worldTime && worldTime <= 23991; // Check if it's day
            }
            else{
                isDaytime = 12542 <= worldTime && worldTime <= 23459; // Check if it's day
            }

            if (isRaining) {
                // Do something specific for daytime
                player.sendSystemMessage(Component.literal("rain"));
            }

            if (state.getValue(Tent.ISOPEN)) {
                // Do something specific for daytime
                player.sendSystemMessage(Component.literal("clicked"));
            }*/

            //if(!level.isDay() || level.isThundering()) {
                player.startSleepInBed(pos);
                /*while(!player.isSleepingLongEnough()){
                    if(player.isHurt()){
                        player.stopSleeping();
                    }
                }*/
                player.stopSleeping();
            //}
        }
        return super.use(state, level, pos, player, hand, hitResult);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ISOPEN);
    }
}
