package net.stevee.tutorialmod.container;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stevee.tutorialmod.TutorialMod;

public class ModContainers {
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, TutorialMod.MOD_ID);

    public static final RegistryObject<MenuType<BackpackContainer>> BACKPACK = CONTAINERS.register("backpack",
            () -> IForgeMenuType.create((windowId, inv, data) -> new BackpackContainer(windowId, inv, data.readItem())));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
