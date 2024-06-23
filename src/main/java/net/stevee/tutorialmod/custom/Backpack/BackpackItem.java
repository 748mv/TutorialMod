package net.stevee.tutorialmod.custom.Backpack;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuConstructor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.stevee.tutorialmod.container.BackpackContainer;

public class BackpackItem extends Item {

    String name = "container.backpack";

    public BackpackItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level world = context.getLevel();
        if (!world.isClientSide && player != null) {
            // Open the backpack GUI
            player.openMenu(getContainer(context.getItemInHand()));
        }
        return InteractionResult.SUCCESS;
    }

    private MenuProvider getContainer(ItemStack stack) {
        return new SimpleMenuProvider(
                (MenuConstructor) (windowId, playerInventory, playerEntity) -> new BackpackContainer(windowId, playerInventory, stack),
                (Component) new TranslatableContents(name)
        );
    }

}
