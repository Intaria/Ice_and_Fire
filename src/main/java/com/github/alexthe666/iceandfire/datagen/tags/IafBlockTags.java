package com.github.alexthe666.iceandfire.datagen.tags;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.block.IafBlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class IafBlockTags extends BlockTagsProvider {
    public static TagKey<Block> CHARRED_BLOCKS = createKey("charred_blocks");
    public static TagKey<Block> FROZEN_BLOCKS = createKey("frozen_blocks");
    public static TagKey<Block> CRACKLED_BLOCKS = createKey("crackled_blocks");
    public static TagKey<Block> DRAGON_ENVIRONMENT_BLOCKS = createKey("dragon_environment_blocks");

    public static TagKey<Block> DRAGON_BLOCK_BREAK_BLACKLIST = createKey("dragon_block_break_blacklist");
    public static TagKey<Block> DRAGON_BLOCK_BREAK_NO_DROPS = createKey("dragon_block_break_no_drops");

    public IafBlockTags(final DataGenerator generator, @Nullable final ExistingFileHelper existingFileHelper) {
        super(generator, IceAndFire.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(CHARRED_BLOCKS)
                .add(IafBlockRegistry.CHARRED_COBBLESTONE.get())
                .add(IafBlockRegistry.CHARRED_DIRT.get())
                .add(IafBlockRegistry.CHARRED_DIRT_PATH.get())
                .add(IafBlockRegistry.CHARRED_GRASS.get())
                .add(IafBlockRegistry.CHARRED_GRAVEL.get())
                .add(IafBlockRegistry.CHARRED_STONE.get());

        tag(FROZEN_BLOCKS)
                .add(IafBlockRegistry.FROZEN_COBBLESTONE.get())
                .add(IafBlockRegistry.FROZEN_DIRT.get())
                .add(IafBlockRegistry.FROZEN_DIRT_PATH.get())
                .add(IafBlockRegistry.FROZEN_GRASS.get())
                .add(IafBlockRegistry.FROZEN_GRAVEL.get())
                .add(IafBlockRegistry.FROZEN_STONE.get())
                .add(IafBlockRegistry.FROZEN_SPLINTERS.get());

        tag(CRACKLED_BLOCKS)
                .add(IafBlockRegistry.CRACKLED_COBBLESTONE.get())
                .add(IafBlockRegistry.CRACKLED_DIRT.get())
                .add(IafBlockRegistry.CRACKLED_DIRT_PATH.get())
                .add(IafBlockRegistry.CRACKLED_GRASS.get())
                .add(IafBlockRegistry.CRACKLED_GRASS.get())
                .add(IafBlockRegistry.CRACKLED_STONE.get());

        tag(DRAGON_ENVIRONMENT_BLOCKS)
                .addTag(CHARRED_BLOCKS)
                .addTag(FROZEN_BLOCKS)
                .addTag(CRACKLED_BLOCKS);

        tag(DRAGON_BLOCK_BREAK_BLACKLIST)
                .addTag(Tags.Blocks.CHESTS)
                .add(Blocks.END_STONE)
                .add(Blocks.IRON_BARS);

        tag(DRAGON_BLOCK_BREAK_NO_DROPS)
                .addTag(BlockTags.DIRT)
                .addTag(Tags.Blocks.STONE)
                .addTag(Tags.Blocks.COBBLESTONE)
                .addTag(DRAGON_ENVIRONMENT_BLOCKS)
                .add(Blocks.GRASS_BLOCK);
    }

    private static TagKey<Block> createKey(final String name) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(IceAndFire.MODID, name));
    }
}
