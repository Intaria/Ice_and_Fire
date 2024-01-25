package com.github.alexthe666.iceandfire.datagen;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.world.gen.processor.DreadRuinProcessor;
import com.github.alexthe666.iceandfire.world.gen.processor.GorgonTempleProcessor;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import java.util.List;
import java.util.Map;

public class IafProcessorLists {
    public static final ResourceKey<StructureProcessorList> MAUSOLEUM_PROCESSORS = createKey("mausoleum_processors");
    public static final ResourceKey<StructureProcessorList> GORGON_TEMPLE_PROCESSORS = createKey("gorgon_temple_processors");
    public static final ResourceKey<StructureProcessorList> HOUSE_PROCESSOR = createKey("village_house_processor");

    private static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registry.PROCESSOR_LIST_REGISTRY, new ResourceLocation(IceAndFire.MODID, name));
    }

    public static Map<ResourceLocation, StructureProcessorList> gather() {
        return Map.of(
                MAUSOLEUM_PROCESSORS.location(), new StructureProcessorList(List.of(DreadRuinProcessor.INSTANCE)),
                GORGON_TEMPLE_PROCESSORS.location(), new StructureProcessorList(List.of(GorgonTempleProcessor.INSTANCE))
        );
    }
}
