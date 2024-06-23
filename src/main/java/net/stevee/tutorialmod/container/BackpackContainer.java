package net.stevee.tutorialmod.container;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class BackpackContainer extends AbstractContainerMenu {
    public static final MenuType<BackpackContainer> TYPE = null;
    private final ItemStack backpack;

    public BackpackContainer(int windowId, Inventory playerInventory, ItemStack backpack) {
        super(TYPE, windowId);
        this.backpack = backpack;

        // Add custom inventory slots here (e.g., 9 slots for the backpack)
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new SlotItemHandler(new ItemStackHandler(9), i, 8 + i * 18, 18));
        }

        // Add player inventory slots here
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 50 + y * 18));
            }
        }

        for (int x = 0; x < 9; ++x) {
            this.addSlot(new Slot(playerInventory, x, 8 + x * 18, 108));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        // Handle shift-clicking items here
        return ItemStack.EMPTY;
    }
}
