package com.github.alexthe666.iceandfire.datagen;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.world.CustomBiomeFilter;
import com.google.gson.JsonElement;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class IafPlacedFeatures {
    public static final ResourceKey<PlacedFeature> PLACED_PIXIE_VILLAGE = registerKey("pixie_village");
    public static final ResourceKey<PlacedFeature> PLACED_SIREN_ISLAND = registerKey("siren_island");
    public static final ResourceKey<PlacedFeature> PLACED_SPAWN_HIPPOCAMPUS = registerKey("spawn_hippocampus");
    
    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new ResourceLocation(IceAndFire.MODID, name));
    }

    public static Map<ResourceLocation, PlacedFeature> gather(RegistryOps<JsonElement> registryOps) {
        Map<ResourceLocation, PlacedFeature> entries = new HashMap<>();

        // Referencing the previously gathered Configured Features causes their data to also appear in the Placed Feature .json
        // The order of the placement modifiers might be important (first heightmap so that the biome check happens on the surface instead of at -64)

        // Surface
        entries.put(PLACED_PIXIE_VILLAGE.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.PIXIE_VILLAGE), List.of(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        entries.put(PLACED_SIREN_ISLAND.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.SIREN_ISLAND), List.of(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        entries.put(PLACED_SPAWN_HIPPOCAMPUS.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.SPAWN_HIPPOCAMPUS), List.of(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        
        // Underground
        return entries;
    }
}
