package com.github.alexthe666.iceandfire.misc;

import com.github.alexthe666.iceandfire.IceAndFire;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.NewRegistryEvent;

import java.lang.reflect.Field;

import static com.github.alexthe666.iceandfire.IceAndFire.MODID;

@SuppressWarnings("WeakerAccess")
@Mod.EventBusSubscriber(modid = IceAndFire.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class IafSoundRegistry {

    public static final SoundEvent EGG_HATCH = createSoundEvent("egg_hatch");

    public static final SoundEvent FIREDRAGON_BREATH = createSoundEvent("firedragon_breath");

    public static final SoundEvent ICEDRAGON_BREATH = createSoundEvent("icedragon_breath");

    public static final SoundEvent FIREDRAGON_CHILD_IDLE = createSoundEvent("firedragon_child_idle");

    public static final SoundEvent FIREDRAGON_CHILD_HURT = createSoundEvent("firedragon_child_hurt");

    public static final SoundEvent FIREDRAGON_CHILD_DEATH = createSoundEvent("firedragon_child_death");

    public static final SoundEvent FIREDRAGON_CHILD_ROAR = createSoundEvent("firedragon_child_roar");

    public static final SoundEvent FIREDRAGON_TEEN_ROAR = createSoundEvent("firedragon_teen_roar");

    public static final SoundEvent FIREDRAGON_TEEN_IDLE = createSoundEvent("firedragon_teen_idle");

    public static final SoundEvent FIREDRAGON_TEEN_DEATH = createSoundEvent("firedragon_teen_death");

    public static final SoundEvent FIREDRAGON_TEEN_HURT = createSoundEvent("firedragon_teen_hurt");

    public static final SoundEvent FIREDRAGON_ADULT_ROAR = createSoundEvent("firedragon_adult_roar");

    public static final SoundEvent FIREDRAGON_ADULT_IDLE = createSoundEvent("firedragon_adult_idle");

    public static final SoundEvent FIREDRAGON_ADULT_DEATH = createSoundEvent("firedragon_adult_death");

    public static final SoundEvent FIREDRAGON_ADULT_HURT = createSoundEvent("firedragon_adult_hurt");

    public static final SoundEvent ICEDRAGON_CHILD_IDLE = createSoundEvent("icedragon_child_idle");

    public static final SoundEvent ICEDRAGON_CHILD_HURT = createSoundEvent("icedragon_child_hurt");

    public static final SoundEvent ICEDRAGON_CHILD_DEATH = createSoundEvent("icedragon_child_death");

    public static final SoundEvent ICEDRAGON_CHILD_ROAR = createSoundEvent("icedragon_child_roar");

    public static final SoundEvent ICEDRAGON_TEEN_ROAR = createSoundEvent("icedragon_teen_roar");

    public static final SoundEvent ICEDRAGON_TEEN_IDLE = createSoundEvent("icedragon_teen_idle");

    public static final SoundEvent ICEDRAGON_TEEN_DEATH = createSoundEvent("icedragon_teen_death");

    public static final SoundEvent ICEDRAGON_TEEN_HURT = createSoundEvent("icedragon_teen_hurt");

    public static final SoundEvent ICEDRAGON_ADULT_ROAR = createSoundEvent("icedragon_adult_roar");

    public static final SoundEvent ICEDRAGON_ADULT_IDLE = createSoundEvent("icedragon_adult_idle");

    public static final SoundEvent ICEDRAGON_ADULT_DEATH = createSoundEvent("icedragon_adult_death");

    public static final SoundEvent ICEDRAGON_ADULT_HURT = createSoundEvent("icedragon_adult_hurt");

    public static final SoundEvent HIPPOGRYPH_IDLE = createSoundEvent("hippogryph_idle");

    public static final SoundEvent HIPPOGRYPH_HURT = createSoundEvent("hippogryph_hurt");

    public static final SoundEvent HIPPOGRYPH_DIE = createSoundEvent("hippogryph_die");

    public static final SoundEvent PIXIE_IDLE = createSoundEvent("pixie_idle");

    public static final SoundEvent PIXIE_HURT = createSoundEvent("pixie_hurt");

    public static final SoundEvent PIXIE_DIE = createSoundEvent("pixie_die");

    public static final SoundEvent PIXIE_TAUNT = createSoundEvent("pixie_taunt");

    public static final SoundEvent GOLD_PILE_STEP = createSoundEvent("gold_pile_step");

    public static final SoundEvent GOLD_PILE_BREAK = createSoundEvent("gold_pile_break");

    public static final SoundEvent DRAGON_FLIGHT = createSoundEvent("dragon_flight");

    public static final SoundEvent HIPPOCAMPUS_IDLE = createSoundEvent("hippocampus_idle");

    public static final SoundEvent HIPPOCAMPUS_HURT = createSoundEvent("hippocampus_hurt");

    public static final SoundEvent HIPPOCAMPUS_DIE = createSoundEvent("hippocampus_die");

    public static final SoundEvent NAGA_IDLE = createSoundEvent("naga_idle");

    public static final SoundEvent NAGA_ATTACK = createSoundEvent("naga_attack");

    public static final SoundEvent NAGA_HURT = createSoundEvent("naga_hurt");

    public static final SoundEvent NAGA_DIE = createSoundEvent("naga_die");

    public static final SoundEvent MERMAID_IDLE = createSoundEvent("mermaid_idle");

    public static final SoundEvent MERMAID_HURT = createSoundEvent("mermaid_hurt");

    public static final SoundEvent MERMAID_DIE = createSoundEvent("mermaid_die");

    public static final SoundEvent SIREN_SONG = createSoundEvent("siren_song");

    public static final SoundEvent AMPHITHERE_DIE = createSoundEvent("amphithere_die");

    public static final SoundEvent AMPHITHERE_IDLE = createSoundEvent("amphithere_idle");

    public static final SoundEvent AMPHITHERE_HURT = createSoundEvent("amphithere_hurt");

    public static final SoundEvent AMPHITHERE_BITE = createSoundEvent("amphithere_bite");

    public static final SoundEvent AMPHITHERE_GUST = createSoundEvent("amphithere_gust");

    public static final SoundEvent PIXIE_WAND = createSoundEvent("pixie_wand");

    public static final SoundEvent LIGHTNINGDRAGON_CHILD_IDLE = createSoundEvent("lightningdragon_child_idle");

    public static final SoundEvent LIGHTNINGDRAGON_CHILD_HURT = createSoundEvent("lightningdragon_child_hurt");

    public static final SoundEvent LIGHTNINGDRAGON_CHILD_DEATH = createSoundEvent("lightningdragon_child_death");

    public static final SoundEvent LIGHTNINGDRAGON_CHILD_ROAR = createSoundEvent("lightningdragon_child_roar");

    public static final SoundEvent LIGHTNINGDRAGON_TEEN_ROAR = createSoundEvent("lightningdragon_teen_roar");

    public static final SoundEvent LIGHTNINGDRAGON_TEEN_IDLE = createSoundEvent("lightningdragon_teen_idle");

    public static final SoundEvent LIGHTNINGDRAGON_TEEN_DEATH = createSoundEvent("lightningdragon_teen_death");

    public static final SoundEvent LIGHTNINGDRAGON_TEEN_HURT = createSoundEvent("lightningdragon_teen_hurt");

    public static final SoundEvent LIGHTNINGDRAGON_ADULT_ROAR = createSoundEvent("lightningdragon_adult_roar");

    public static final SoundEvent LIGHTNINGDRAGON_ADULT_IDLE = createSoundEvent("lightningdragon_adult_idle");

    public static final SoundEvent LIGHTNINGDRAGON_ADULT_DEATH = createSoundEvent("lightningdragon_adult_death");

    public static final SoundEvent LIGHTNINGDRAGON_ADULT_HURT = createSoundEvent("lightningdragon_adult_hurt");

    public static final SoundEvent LIGHTNINGDRAGON_BREATH = createSoundEvent("lightningdragon_breath");

    public static final SoundEvent LIGHTNINGDRAGON_BREATH_CRACKLE = createSoundEvent("lightningdragon_breath_crackle");

    private static SoundEvent createSoundEvent(final String soundName) {
        final ResourceLocation soundID = new ResourceLocation(MODID, soundName);
        return new SoundEvent(soundID);
    }

    @SubscribeEvent
    public static void registerSoundEvents(final NewRegistryEvent event) {
        try {
            for (Field f : IafSoundRegistry.class.getFields()) {
                Object obj = f.get(null);
                if (obj instanceof SoundEvent) {
                    ForgeRegistries.SOUND_EVENTS.register(((SoundEvent) obj).getLocation(), (SoundEvent) obj);
                } else if (obj instanceof SoundEvent[]) {
                    for (SoundEvent soundEvent : (SoundEvent[]) obj) {
                        ForgeRegistries.SOUND_EVENTS.register(soundEvent.getLocation(), soundEvent);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
