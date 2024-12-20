package com.github.alexthe666.iceandfire.datagen;

import com.github.alexthe666.iceandfire.block.IafBlockRegistry;
import com.github.alexthe666.iceandfire.world.IafWorldRegistry;
import com.google.gson.JsonElement;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public final class IafConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PIXIE_VILLAGE = registerKey("pixie_village");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SIREN_ISLAND = registerKey("siren_island");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPAWN_DRAGON_SKELETON_L = registerKey("spawn_dragon_skeleton_lightning");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPAWN_DRAGON_SKELETON_F = registerKey("spawn_dragon_skeleton_fire");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPAWN_DRAGON_SKELETON_I = registerKey("spawn_dragon_skeleton_ice");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPAWN_HIPPOCAMPUS = registerKey("spawn_hippocampus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FIRE_LILY = registerKey("fire_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FROST_LILY = registerKey("frost_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHTNING_LILY = registerKey("lightning_lily");

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation("iceandfire", name));
    }

    private static final Function<Block, RandomPatchConfiguration> FLOWER_CONFIGURATION = (block) -> FeatureUtils.simpleRandomPatchConfiguration(8, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block.defaultBlockState().getBlock()))));

    public static Map<ResourceLocation, ConfiguredFeature<?, ?>> gather(RegistryOps<JsonElement> registryOps) {
        Map<ResourceLocation, ConfiguredFeature<?, ?>> entries = new HashMap<>();

        entries.put(PIXIE_VILLAGE.location(), new ConfiguredFeature<>(IafWorldRegistry.PIXIE_VILLAGE.get(), FeatureConfiguration.NONE));
        entries.put(SIREN_ISLAND.location(), new ConfiguredFeature<>(IafWorldRegistry.SIREN_ISLAND.get(), FeatureConfiguration.NONE));
        entries.put(SPAWN_DRAGON_SKELETON_L.location(), new ConfiguredFeature<>(IafWorldRegistry.SPAWN_DRAGON_SKELETON_L.get(), FeatureConfiguration.NONE));
        entries.put(SPAWN_DRAGON_SKELETON_F.location(), new ConfiguredFeature<>(IafWorldRegistry.SPAWN_DRAGON_SKELETON_F.get(), FeatureConfiguration.NONE));
        entries.put(SPAWN_DRAGON_SKELETON_I.location(), new ConfiguredFeature<>(IafWorldRegistry.SPAWN_DRAGON_SKELETON_I.get(), FeatureConfiguration.NONE));
        entries.put(SPAWN_HIPPOCAMPUS.location(), new ConfiguredFeature<>(IafWorldRegistry.SPAWN_HIPPOCAMPUS.get(), FeatureConfiguration.NONE));
        entries.put(FIRE_LILY.location(), new ConfiguredFeature<>(Feature.FLOWER, FLOWER_CONFIGURATION.apply(IafBlockRegistry.FIRE_LILY.get())));
        entries.put(FROST_LILY.location(), new ConfiguredFeature<>(Feature.FLOWER, FLOWER_CONFIGURATION.apply(IafBlockRegistry.FROST_LILY.get())));
        entries.put(LIGHTNING_LILY.location(), new ConfiguredFeature<>(Feature.FLOWER, FLOWER_CONFIGURATION.apply(IafBlockRegistry.LIGHTNING_LILY.get())));

        return entries;
    }
}
