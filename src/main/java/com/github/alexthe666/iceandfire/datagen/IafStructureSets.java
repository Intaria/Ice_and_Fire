package com.github.alexthe666.iceandfire.datagen;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.google.gson.JsonElement;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

import java.util.Map;

public class IafStructureSets {
    public static final ResourceKey<StructureSet> GORGON_TEMPLE = registerKey("gorgon_temple");

    private static ResourceKey<StructureSet> registerKey(String name) {
        return ResourceKey.create(Registry.STRUCTURE_SET_REGISTRY, new ResourceLocation(IceAndFire.MODID, name));
    }

    public static Map<ResourceLocation, StructureSet> gather(RegistryOps<JsonElement> registryOps) {
        return Map.of(
                GORGON_TEMPLE.location(), new StructureSet(registryOps.registry(Registry.STRUCTURE_REGISTRY).get().getOrCreateHolderOrThrow(IafStructures.GORGON_TEMPLE), new RandomSpreadStructurePlacement(32, 12, RandomSpreadType.LINEAR, 76489509))
        );
    }
}
