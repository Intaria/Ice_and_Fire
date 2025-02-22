package com.github.alexthe666.iceandfire.datagen;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.datagen.tags.*;
import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.RegistryOps;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;


@Mod.EventBusSubscriber(modid = IceAndFire.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        generator.addProvider(event.includeServer(), new BannerPatternTagGenerator(generator, helper));
        generator.addProvider(event.includeServer(), new IafBiomeTagGenerator(generator, helper));
        IafBlockTags blockTagsProvider = new IafBlockTags(generator, helper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new IafItemTags(generator, blockTagsProvider, helper));
        generator.addProvider(event.includeServer(), new IafEntityTags(generator, helper));
        generator.addProvider(event.includeServer(), new IafRecipes(generator));

        RegistryOps<JsonElement> registryOps = RegistryOps.create(JsonOps.INSTANCE, RegistryAccess.builtinCopy());

        generator.addProvider(event.includeServer(), JsonCodecProvider.forDatapackRegistry(
                generator,
                helper,
                IceAndFire.MODID,
                registryOps,
                Registry.CONFIGURED_FEATURE_REGISTRY,
                IafConfiguredFeatures.gather(registryOps)
        ));

        generator.addProvider(event.includeServer(), JsonCodecProvider.forDatapackRegistry(
                generator,
                helper,
                IceAndFire.MODID,
                registryOps,
                Registry.PLACED_FEATURE_REGISTRY,
                IafPlacedFeatures.gather(registryOps)
        ));

        generator.addProvider(event.includeServer(), JsonCodecProvider.forDatapackRegistry(
                generator,
                helper,
                IceAndFire.MODID,
                registryOps,
                ForgeRegistries.Keys.BIOME_MODIFIERS,
                IafBiomeModifierSerializers.gather(registryOps)
        ));
    }
}
