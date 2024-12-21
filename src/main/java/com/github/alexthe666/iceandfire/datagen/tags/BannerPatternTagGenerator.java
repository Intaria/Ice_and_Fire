package com.github.alexthe666.iceandfire.datagen.tags;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.recipe.IafBannerPatterns;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class BannerPatternTagGenerator extends TagsProvider<BannerPattern> {
    public static final TagKey<BannerPattern> AMPHITHERE_BANNER_PATTERN = create("pattern_item/amphithere");
    public static final TagKey<BannerPattern> BIRD_BANNER_PATTERN = create("pattern_item/bird");
    public static final TagKey<BannerPattern> EYE_BANNER_PATTERN = create("pattern_item/eye");
    public static final TagKey<BannerPattern> FAE_BANNER_PATTERN = create("pattern_item/fae");
    public static final TagKey<BannerPattern> FEATHER_BANNER_PATTERN = create("pattern_item/feather");
    public static final TagKey<BannerPattern> HIPPOCAMPUS_BANNER_PATTERN = create("pattern_item/hippocampus");
    public static final TagKey<BannerPattern> HIPPOGRYPH_HEAD_BANNER_PATTERN = create("pattern_item/hippogryph_head");
    public static final TagKey<BannerPattern> MERMAID_BANNER_PATTERN = create("pattern_item/mermaid");
    public static final TagKey<BannerPattern> WEEZER_BANNER_PATTERN = create("pattern_item/weezer");

    public BannerPatternTagGenerator(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Registry.BANNER_PATTERN, IceAndFire.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(AMPHITHERE_BANNER_PATTERN).add(IafBannerPatterns.PATTERN_AMPHITHERE.getKey());
        this.tag(BIRD_BANNER_PATTERN).add(IafBannerPatterns.PATTERN_BIRD.getKey());
        this.tag(EYE_BANNER_PATTERN).add(IafBannerPatterns.PATTERN_EYE.getKey());
        this.tag(FAE_BANNER_PATTERN).add(IafBannerPatterns.PATTERN_FAE.getKey());
        this.tag(FEATHER_BANNER_PATTERN).add(IafBannerPatterns.PATTERN_FEATHER.getKey());
        this.tag(HIPPOCAMPUS_BANNER_PATTERN).add(IafBannerPatterns.PATTERN_HIPPOCAMPUS.getKey());
        this.tag(HIPPOGRYPH_HEAD_BANNER_PATTERN).add(IafBannerPatterns.PATTERN_HIPPOGRYPH_HEAD.getKey());
        this.tag(MERMAID_BANNER_PATTERN).add(IafBannerPatterns.PATTERN_MERMAID.getKey());
        this.tag(WEEZER_BANNER_PATTERN).add(IafBannerPatterns.PATTERN_WEEZER.getKey());
    }

    private static TagKey<BannerPattern> create(String name) {
        return TagKey.create(Registry.BANNER_PATTERN_REGISTRY, new ResourceLocation(IceAndFire.MODID, name));
    }

    @Override
    public String getName() {
        return "Ice and Fire Banner Pattern Tags";
    }
}

