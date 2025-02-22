package com.github.alexthe666.iceandfire.config;

import com.github.alexthe666.citadel.config.biome.SpawnBiomeConfig;
import com.github.alexthe666.citadel.config.biome.SpawnBiomeData;
import com.github.alexthe666.iceandfire.IceAndFire;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BiomeConfig {
    public static Pair<String, SpawnBiomeData> hippogryphBiomes = Pair.of("iceandfire:hippogryph_biomes", DefaultBiomes.HILLS);
    public static Pair<String, SpawnBiomeData> pixieBiomes = Pair.of("iceandfire:pixie_village_biomes", DefaultBiomes.PIXIES);
    public static Pair<String, SpawnBiomeData> hippocampusBiomes = Pair.of("iceandfire:hippocampus_biomes", DefaultBiomes.OCEANS);
    public static Pair<String, SpawnBiomeData> sirenBiomes = Pair.of("iceandfire:siren_biomes", DefaultBiomes.OCEANS);
    public static Pair<String, SpawnBiomeData> amphithereBiomes = Pair.of("iceandfire:amphithere_biomes", DefaultBiomes.JUNGLE);
    
    public static Pair<String, SpawnBiomeData> mausoleumBiomes = Pair.of("iceandfire:mausoleum_biomes", DefaultBiomes.MAUSOLEUM);
    
    public static Pair<String, SpawnBiomeData> blackHippogryphBiomes = Pair.of("iceandfire:hippogryph_black_biomes", DefaultBiomes.HIPPOGRYPH_BLACK);
    public static Pair<String, SpawnBiomeData> brownHippogryphBiomes = Pair.of("iceandfire:hippogryph_brown_biomes", DefaultBiomes.VERY_HILLY);
    public static Pair<String, SpawnBiomeData> grayHippogryphBiomes = Pair.of("iceandfire:hippogryph_gray_biomes", DefaultBiomes.HIPPOGRYPH_GRAY);
    public static Pair<String, SpawnBiomeData> chestnutHippogryphBiomes = Pair.of("iceandfire:hippogryph_chestnut_biomes", DefaultBiomes.HIPPOGRYPH_CHESTNUT);
    public static Pair<String, SpawnBiomeData> creamyHippogryphBiomes = Pair.of("iceandfire:hippogryph_creamy_biomes", DefaultBiomes.HIPPOGRYPH_CREAMY);
    public static Pair<String, SpawnBiomeData> darkBrownHippogryphBiomes = Pair.of("iceandfire:hippogryph_dark_brown_biomes", DefaultBiomes.HIPPOGRYPH_DARK_BROWN);
    public static Pair<String, SpawnBiomeData> whiteHippogryphBiomes = Pair.of("iceandfire:hippogryph_white_biomes", DefaultBiomes.HIPPOGRYPH_WHITE);

    private static boolean init = false;
    private static final Map<String, SpawnBiomeData> biomeConfigValues = new HashMap<>();

    public static void init() {
        try {
            for (Field f : BiomeConfig.class.getFields()) {
                Object obj = f.get(null);
                if (obj instanceof Pair) {
                    String id = (String)((Pair) obj).getLeft();
                    SpawnBiomeData data = (SpawnBiomeData)((Pair) obj).getRight();
                    biomeConfigValues.put(id, SpawnBiomeConfig.create(new ResourceLocation(id), data));
                }
            }
        }catch (Exception e){
            IceAndFire.LOGGER.warn("Encountered error building iceandfire biome config .json files");
            e.printStackTrace();
        }
        init = true;
    }

    private static ResourceLocation getBiomeName(Holder<Biome> biome) {
        return biome.unwrap().map((resourceKey) -> resourceKey.location(), (noKey) -> null);
    }

    public static boolean test(Pair<String, SpawnBiomeData> entry, Holder<Biome> biome, ResourceLocation name) {
        if (!init) {
            init();
        }
        return biomeConfigValues.get(entry.getKey()).matches(biome, name);
    }

    public static boolean test(Pair<String, SpawnBiomeData> entry, Holder<Biome> biome) {
        return BiomeConfig.test(entry, biome, getBiomeName(biome));
    }
    public static boolean test(Pair<String, SpawnBiomeData> entry, Holder.Reference<Biome> biome) {
        return test(entry, biome, biome.key().location());
    }

}
