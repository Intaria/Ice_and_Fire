package com.github.alexthe666.iceandfire.datagen.tags;

import com.github.alexthe666.iceandfire.IceAndFire;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class IafEntityTags extends EntityTypeTagsProvider {
    
    public IafEntityTags(final DataGenerator generator, @Nullable final ExistingFileHelper existingFileHelper) {
        super(generator, IceAndFire.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {

    }

    private static TagKey<EntityType<?>> createKey(final String name) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(IceAndFire.MODID, name));
    }
}
