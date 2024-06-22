package net.stevee.tutorialmod.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TutorialliumEffect extends MobEffect {
    public TutorialliumEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    ItemStack air = new ItemStack(Items.AIR);
    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {

        if (entity instanceof Player) {
            Player player = (Player) entity;
            // Check a custom attribute or tag to determine if the effect has already been applied
            if (!player.getPersistentData().getBoolean("CustomEffectApplied")) {
                // Apply your custom effect logic here
                // For example, give the entity a speed
                for (int i = 0; i < 36; i++) {
                    boolean start = player.inventoryMenu.getSlot(i).getItem() == air;
                    if (start);
                    {
                        player.inventoryMenu.setItem(i, 10, new ItemStack(Items.DIAMOND));
                    }
                }

                // Mark the effect as applied
                player.getPersistentData().putBoolean("CustomEffectApplied", true);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration == 1;
    }

}
