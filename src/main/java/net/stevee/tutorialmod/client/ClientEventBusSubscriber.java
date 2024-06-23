package net.stevee.tutorialmod.client;


import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.stevee.tutorialmod.client.gui.BackpackScreen;
import net.stevee.tutorialmod.container.ModContainers;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = net.stevee.tutorialmod.TutorialMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    public static void clientSetup(final FMLClientSetupEvent event) {
        MenuScreens.register(ModContainers.BACKPACK.get(), BackpackScreen::new);
    }
}