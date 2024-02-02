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
    public static final ResourceKey<PlacedFeature> PLACED_FIRE_DRAGON_CAVE = registerKey("fire_dragon_cave");
    public static final ResourceKey<PlacedFeature> PLACED_ICE_DRAGON_CAVE = registerKey("ice_dragon_cave");
    public static final ResourceKey<PlacedFeature> PLACED_LIGHTNING_DRAGON_CAVE = registerKey("lightning_dragon_cave");
    public static final ResourceKey<PlacedFeature> PLACED_PIXIE_VILLAGE = registerKey("pixie_village");
    public static final ResourceKey<PlacedFeature> PLACED_SIREN_ISLAND = registerKey("siren_island");
    public static final ResourceKey<PlacedFeature> PLACED_SPAWN_DRAGON_SKELETON_L = registerKey("spawn_dragon_skeleton_lightning");
    public static final ResourceKey<PlacedFeature> PLACED_SPAWN_DRAGON_SKELETON_F = registerKey("spawn_dragon_skeleton_fire");
    public static final ResourceKey<PlacedFeature> PLACED_SPAWN_DRAGON_SKELETON_I = registerKey("spawn_dragon_skeleton_ice");
    public static final ResourceKey<PlacedFeature> PLACED_SPAWN_HIPPOCAMPUS = registerKey("spawn_hippocampus");
    public static final ResourceKey<PlacedFeature> PLACED_FIRE_LILY = registerKey("fire_lily");
    public static final ResourceKey<PlacedFeature> PLACED_LIGHTNING_LILY = registerKey("lightning_lily");
    public static final ResourceKey<PlacedFeature> PLACED_FROST_LILY = registerKey("frost_lily");

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new ResourceLocation(IceAndFire.MODID, name));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    public static Map<ResourceLocation, PlacedFeature> gather(RegistryOps<JsonElement> registryOps) {
        Map<ResourceLocation, PlacedFeature> entries = new HashMap<>();

        // Referencing the previously gathered Configured Features causes their data to also appear in the Placed Feature .json
        // The order of the placement modifiers might be important (first heightmap so that the biome check happens on the surface instead of at -64)

        // Surface
        entries.put(PLACED_PIXIE_VILLAGE.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.PIXIE_VILLAGE), List.of(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        entries.put(PLACED_SIREN_ISLAND.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.SIREN_ISLAND), List.of(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        entries.put(PLACED_SPAWN_DRAGON_SKELETON_L.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.SPAWN_DRAGON_SKELETON_L), List.of(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        entries.put(PLACED_SPAWN_DRAGON_SKELETON_F.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.SPAWN_DRAGON_SKELETON_F), List.of(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        entries.put(PLACED_SPAWN_DRAGON_SKELETON_I.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.SPAWN_DRAGON_SKELETON_I), List.of(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        entries.put(PLACED_SPAWN_HIPPOCAMPUS.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.SPAWN_HIPPOCAMPUS), List.of(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        entries.put(PLACED_FIRE_LILY.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.FIRE_LILY), List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        entries.put(PLACED_LIGHTNING_LILY.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.FROST_LILY), List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        entries.put(PLACED_FROST_LILY.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.LIGHTNING_LILY), List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));

        // Underground
        entries.put(PLACED_FIRE_DRAGON_CAVE.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.FIRE_DRAGON_CAVE), List.of(CustomBiomeFilter.biome())));
        entries.put(PLACED_ICE_DRAGON_CAVE.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.ICE_DRAGON_CAVE), List.of(CustomBiomeFilter.biome())));
        entries.put(PLACED_LIGHTNING_DRAGON_CAVE.location(), new PlacedFeature(registryOps.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(IafConfiguredFeatures.LIGHTNING_DRAGON_CAVE), List.of(CustomBiomeFilter.biome())));
        
        return entries;
    }
}
