package net.stevee.tutorialmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stevee.tutorialmod.TutorialMod;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TutorialMod.MOD_ID);

    public static final RegistryObject<MobEffect> TUTORIALLIUM_EFFECT = EFFECTS.register("tutoriallium_effect", () -> new TutorialliumEffect(MobEffectCategory.BENEFICIAL, 0xf7d434));

}
