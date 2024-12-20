package com.github.alexthe666.iceandfire.world;

import com.github.alexthe666.citadel.config.biome.SpawnBiomeData;
import com.github.alexthe666.iceandfire.IafConfig;
import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.config.BiomeConfig;
import com.github.alexthe666.iceandfire.datagen.IafPlacedFeatures;
import com.github.alexthe666.iceandfire.entity.EntityDragonBase;
import com.github.alexthe666.iceandfire.entity.IafEntityRegistry;
import com.github.alexthe666.iceandfire.world.feature.*;
import com.github.alexthe666.iceandfire.world.gen.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.storage.LevelData;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

public class IafWorldRegistry {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, IceAndFire.MODID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> PIXIE_VILLAGE = register("pixie_village", () -> new WorldGenPixieVillage(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SIREN_ISLAND = register("siren_island", () -> new WorldGenSirenIsland(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SPAWN_HIPPOCAMPUS = register("spawn_hippocampus", () -> new SpawnHippocampus(NoneFeatureConfiguration.CODEC));
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T extends RegistryObject<EntityType<? extends EntityDragonBase>>> T castToBase(final RegistryObject entityType) {
        return (T) entityType;
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> RegistryObject<F> register(final String name, final Supplier<? extends F> supplier) {
        return FEATURES.register(name, supplier);
    }

    public static boolean isFarEnoughFromSpawn(final LevelAccessor level, final BlockPos position) {
        LevelData spawnPoint = level.getLevelData();
        BlockPos spawnRelative = new BlockPos(spawnPoint.getXSpawn(), position.getY(), spawnPoint.getYSpawn());
        return !spawnRelative.closerThan(position, IafConfig.dangerousWorldGenDistanceLimit);
    }

    public static boolean isFarEnoughFromDangerousGen(final ServerLevelAccessor level, final BlockPos position, final String id) {
        return isFarEnoughFromDangerousGen(level, position, id, IafWorldData.FeatureType.SURFACE);
    }

    public static boolean isFarEnoughFromDangerousGen(final ServerLevelAccessor level, final BlockPos position, final String id, final IafWorldData.FeatureType type) {
        IafWorldData data = IafWorldData.get(level.getLevel());
        return data.check(type, position, id);
    }

    public static HashMap<String, Boolean> LOADED_FEATURES;

    static {
        LOADED_FEATURES = new HashMap<>();
        LOADED_FEATURES.put("iceandfire:pixie_village", false);
        LOADED_FEATURES.put("iceandfire:siren_island", false);
        LOADED_FEATURES.put("iceandfire:spawn_hippocampus", false);
    }

    // Only a global variable because it's too bothersome to add it to the method call (alternative: method returns identifier or null)
    private static List<String> ADDED_FEATURES;

    public static void addFeatures(Holder<Biome> biome, HashMap<String, Holder<PlacedFeature>> features, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        ADDED_FEATURES = new ArrayList<>();

        if (safelyTestBiome(BiomeConfig.pixieBiomes, biome)) {
            addFeatureToBiome(IafPlacedFeatures.PLACED_PIXIE_VILLAGE, features, builder);
        }
        if (safelyTestBiome(BiomeConfig.sirenBiomes, biome)) {
            addFeatureToBiome(IafPlacedFeatures.PLACED_SIREN_ISLAND, features, builder);
        }

        if (safelyTestBiome(BiomeConfig.hippocampusBiomes, biome)) {
            addFeatureToBiome(IafPlacedFeatures.PLACED_SPAWN_HIPPOCAMPUS, features, builder);
        }

        if (!ADDED_FEATURES.isEmpty()) {
            StringBuilder featureList = new StringBuilder();

            for (String feature : ADDED_FEATURES) {
                featureList.append("\n").append("\t- ").append(feature);
            }

            IceAndFire.LOGGER.debug("Added the following features to the biome [{}]: {}", biome.unwrapKey().get().location(), featureList);
        }

        ADDED_FEATURES = null;
    }

    private static void addFeatureToBiome(ResourceKey<PlacedFeature> feature, HashMap<String, Holder<PlacedFeature>> features, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        addFeatureToBiome(feature, features, builder, GenerationStep.Decoration.SURFACE_STRUCTURES);
    }

    private static void addFeatureToBiome(ResourceKey<PlacedFeature> featureResource, HashMap<String, Holder<PlacedFeature>> features, ModifiableBiomeInfo.BiomeInfo.Builder builder, GenerationStep.Decoration step) {
        String identifier = featureResource.location().toString();
        Holder<PlacedFeature> feature = features.get(identifier);

        if (feature != null) {
            builder.getGenerationSettings().getFeatures(step).add(feature);
            LOADED_FEATURES.put(identifier, true);
            ADDED_FEATURES.add(identifier);
        } else {
            IceAndFire.LOGGER.warn("Feature [{}] could not be found", identifier);
        }
    }


    private static boolean safelyTestBiome(Pair<String, SpawnBiomeData> entry, Holder<Biome> biomeHolder) {
        try {
            return BiomeConfig.test(entry, biomeHolder);
        } catch (Exception e) {
            return false;
        }
    }

}
