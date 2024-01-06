package net.harryhirsch4.mccamping.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ShulkerBoxMenu;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

import javax.annotation.Nullable;
import java.util.stream.IntStream;

public class TentBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
    private DyeColor color;
    public void setColor(DyeColor p_58730_) {
        this.color = p_58730_;
    }

    public static final int COLUMNS = 9;
    public static final int ROWS = 3;
    public static final int CONTAINER_SIZE = 27;
    public static final String ITEMS_TAG = "Items";
    private static final int[] SLOTS = IntStream.range(0, 27).toArray();
    private NonNullList<ItemStack> itemStacks;
    private int openCount;

    public TentBlockEntity(BlockPos p_155115_, BlockState p_155116_) {
        super(ModBlockEntities.TENT_BLOCK.get(), p_155115_, p_155116_);
        this.color = ((BedBlock)p_155116_.getBlock()).getColor();
        this.itemStacks = NonNullList.withSize(27, ItemStack.EMPTY);
    }

    public TentBlockEntity(BlockPos p_155118_, BlockState p_155119_, DyeColor p_155120_) {
        super(ModBlockEntities.TENT_BLOCK.get(), p_155118_, p_155119_);
        this.color = p_155120_;
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public DyeColor getColor() {
        return this.color;
    }

    public int getContainerSize() {
        return this.itemStacks.size();
    }

    public boolean triggerEvent(int p_59678_, int p_59679_) {
        if (p_59678_ == 1) {
            this.openCount = p_59679_;
            if (p_59679_ == 0) {
                doNeighborUpdates(this.getLevel(), this.worldPosition, this.getBlockState());
            }

            if (p_59679_ == 1) {
                doNeighborUpdates(this.getLevel(), this.worldPosition, this.getBlockState());
            }

            return true;
        } else {
            return super.triggerEvent(p_59678_, p_59679_);
        }
    }

    private static void doNeighborUpdates(Level p_155688_, BlockPos p_155689_, BlockState p_155690_) {
        p_155690_.updateNeighbourShapes(p_155688_, p_155689_, 3);
    }

    public void startOpen(Player p_59692_) {
        if (!p_59692_.isSpectator()) {
            if (this.openCount < 0) {
                this.openCount = 0;
            }

            ++this.openCount;
            this.level.blockEvent(this.worldPosition, this.getBlockState().getBlock(), 1, this.openCount);
            if (this.openCount == 1) {
                this.level.gameEvent(p_59692_, GameEvent.CONTAINER_OPEN, this.worldPosition);
                this.level.playSound((Player)null, this.worldPosition, SoundEvents.CHEST_OPEN, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
            }
        }

    }

    public void stopOpen(Player p_59688_) {
        if (!p_59688_.isSpectator()) {
            --this.openCount;
            this.level.blockEvent(this.worldPosition, this.getBlockState().getBlock(), 1, this.openCount);
            if (this.openCount <= 0) {
                this.level.gameEvent(p_59688_, GameEvent.CONTAINER_CLOSE, this.worldPosition);
                this.level.playSound((Player)null, this.worldPosition, SoundEvents.CHEST_CLOSE, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
            }
        }

    }

    public void load(CompoundTag p_155678_) {
        super.load(p_155678_);
        this.loadFromTag(p_155678_);
    }

    protected void saveAdditional(CompoundTag p_187513_) {
        super.saveAdditional(p_187513_);
        if (!this.trySaveLootTable(p_187513_)) {
            ContainerHelper.saveAllItems(p_187513_, this.itemStacks, false);
        }

    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.tent");
    }

    public void loadFromTag(CompoundTag p_59694_) {
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(p_59694_) && p_59694_.contains("Items", 9)) {
            ContainerHelper.loadAllItems(p_59694_, this.itemStacks);
        }

    }

    protected NonNullList<ItemStack> getItems() {
        return this.itemStacks;
    }

    protected void setItems(NonNullList<ItemStack> p_59674_) {
        this.itemStacks = p_59674_;
    }

    public int[] getSlotsForFace(Direction p_59672_) {
        return SLOTS;
    }

    public boolean canPlaceItemThroughFace(int p_59663_, ItemStack p_59664_, @Nullable Direction p_59665_) {
        return !(Block.byItem(p_59664_.getItem()) instanceof ShulkerBoxBlock) && p_59664_.getItem().canFitInsideContainerItems();
    }

    public boolean canTakeItemThroughFace(int p_59682_, ItemStack p_59683_, Direction p_59684_) {
        return true;
    }

    protected AbstractContainerMenu createMenu(int p_59660_, Inventory inv) {
        this.level = inv.player.level;
        return new ShulkerBoxMenu(p_59660_, inv, this);
    }

    protected IItemHandler createUnSidedHandler() {
        return new SidedInvWrapper(this, Direction.UP);
    }
}

