package com.github.alexthe666.iceandfire.recipe;

import com.github.alexthe666.iceandfire.IceAndFire;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IafBannerPatterns {
    public static final DeferredRegister<BannerPattern> BANNERS = DeferredRegister.create(Registry.BANNER_PATTERN_REGISTRY, IceAndFire.MODID);
    public static final RegistryObject<BannerPattern> PATTERN_AMPHITHERE = BANNERS.register("amphithere", () -> new BannerPattern("iaf_amphithere"));
    public static final RegistryObject<BannerPattern> PATTERN_BIRD = BANNERS.register("bird", () -> new BannerPattern("iaf_bird"));
    public static final RegistryObject<BannerPattern> PATTERN_EYE = BANNERS.register("eye", () -> new BannerPattern("iaf_eye"));
    public static final RegistryObject<BannerPattern> PATTERN_FAE = BANNERS.register("fae", () -> new BannerPattern("iaf_fae"));
    public static final RegistryObject<BannerPattern> PATTERN_FEATHER = BANNERS.register("feather", () -> new BannerPattern("iaf_feather"));
    public static final RegistryObject<BannerPattern> PATTERN_HIPPOCAMPUS = BANNERS.register("hippocampus", () -> new BannerPattern("iaf_hippocampus"));
    public static final RegistryObject<BannerPattern> PATTERN_HIPPOGRYPH_HEAD = BANNERS.register("hippogryph_head", () -> new BannerPattern("iaf_hippogryph_head"));
    public static final RegistryObject<BannerPattern> PATTERN_MERMAID = BANNERS.register("mermaid", () -> new BannerPattern("iaf_mermaid"));
    public static final RegistryObject<BannerPattern> PATTERN_WEEZER = BANNERS.register("weezer", () -> new BannerPattern("iaf_weezer"));
    
}
