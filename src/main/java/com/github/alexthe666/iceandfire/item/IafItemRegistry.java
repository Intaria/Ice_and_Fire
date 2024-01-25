package com.github.alexthe666.iceandfire.item;

import com.github.alexthe666.citadel.server.item.CustomArmorMaterial;
import com.github.alexthe666.citadel.server.item.CustomToolMaterial;
import com.github.alexthe666.iceandfire.IafConfig;
import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.datagen.tags.BannerPatternTagGenerator;
import com.github.alexthe666.iceandfire.datagen.tags.IafItemTags;
import com.github.alexthe666.iceandfire.entity.IafEntityRegistry;
import com.github.alexthe666.iceandfire.enums.*;
import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;

import java.util.function.Supplier;

import static com.github.alexthe666.iceandfire.item.DragonSteelTier.*;

@Mod.EventBusSubscriber(modid = IceAndFire.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class IafItemRegistry {
    public static CustomArmorMaterial SILVER_ARMOR_MATERIAL = new IafArmorMaterial("silver", 15, new int[]{1, 4, 5, 2}, 20, SoundEvents.ARMOR_EQUIP_CHAIN, 0);
    public static CustomArmorMaterial COPPER_ARMOR_MATERIAL = new IafArmorMaterial("copper", 10, new int[]{1, 3, 4, 2}, 15, SoundEvents.ARMOR_EQUIP_GOLD, 0);
    public static CustomArmorMaterial BLINDFOLD_ARMOR_MATERIAL = new IafArmorMaterial("blindfold", 5, new int[]{1, 1, 1, 1}, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0);
    public static CustomArmorMaterial SHEEP_ARMOR_MATERIAL = new IafArmorMaterial("sheep", 5, new int[]{1, 3, 2, 1}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0);
    public static CustomArmorMaterial EARPLUGS_ARMOR_MATERIAL = new IafArmorMaterial("earplugs", 5, new int[]{1, 1, 1, 1}, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0);
    public static CustomArmorMaterial DRAGONSTEEL_FIRE_ARMOR_MATERIAL = new DragonsteelArmorMaterial("dragonsteel_fire", (int) (0.02D * IafConfig.dragonsteelBaseDurabilityEquipment), new int[]{IafConfig.dragonsteelBaseArmor - 6, IafConfig.dragonsteelBaseArmor - 3, IafConfig.dragonsteelBaseArmor, IafConfig.dragonsteelBaseArmor - 5}, 30, SoundEvents.ARMOR_EQUIP_DIAMOND, IafConfig.dragonsteelBaseArmorToughness);
    public static CustomArmorMaterial DRAGONSTEEL_ICE_ARMOR_MATERIAL = new DragonsteelArmorMaterial("dragonsteel_ice", (int) (0.02D * IafConfig.dragonsteelBaseDurabilityEquipment), new int[]{IafConfig.dragonsteelBaseArmor - 6, IafConfig.dragonsteelBaseArmor - 3, IafConfig.dragonsteelBaseArmor, IafConfig.dragonsteelBaseArmor - 5}, 30, SoundEvents.ARMOR_EQUIP_DIAMOND, IafConfig.dragonsteelBaseArmorToughness);
    public static CustomArmorMaterial DRAGONSTEEL_LIGHTNING_ARMOR_MATERIAL = new DragonsteelArmorMaterial("dragonsteel_lightning", (int) (0.02D * IafConfig.dragonsteelBaseDurabilityEquipment), new int[]{IafConfig.dragonsteelBaseArmor - 6, IafConfig.dragonsteelBaseArmor - 3, IafConfig.dragonsteelBaseArmor, IafConfig.dragonsteelBaseArmor - 5}, 30, SoundEvents.ARMOR_EQUIP_DIAMOND, IafConfig.dragonsteelBaseArmorToughness);
    public static CustomToolMaterial SILVER_TOOL_MATERIAL = new CustomToolMaterial("silver", 2, 460, 1.0F, 11.0F, 18);
    public static CustomToolMaterial COPPER_TOOL_MATERIAL = new CustomToolMaterial("copper", 2, 300, 0.0F, 0.7F, 10);
    public static CustomToolMaterial DRAGONBONE_TOOL_MATERIAL = new CustomToolMaterial("Dragonbone", 4, 1660, 4.0F, 10.0F, 22);
    public static CustomToolMaterial FIRE_DRAGONBONE_TOOL_MATERIAL = new CustomToolMaterial("FireDragonbone", 4, 2000, 5.5F, 10F, 22);
    public static CustomToolMaterial ICE_DRAGONBONE_TOOL_MATERIAL = new CustomToolMaterial("IceDragonbone", 4, 2000, 5.5F, 10F, 22);
    public static CustomToolMaterial LIGHTNING_DRAGONBONE_TOOL_MATERIAL = new CustomToolMaterial("LightningDragonbone", 4, 2000, 5.5F, 10F, 22);
    public static CustomToolMaterial HIPPOGRYPH_SWORD_TOOL_MATERIAL = new CustomToolMaterial("HippogryphSword", 2, 500, 2.5F, 10F, 10);
    public static CustomToolMaterial AMPHITHERE_SWORD_TOOL_MATERIAL = new CustomToolMaterial("AmphithereSword", 2, 500, 1F, 10F, 10);
    public static CustomToolMaterial HIPPOCAMPUS_SWORD_TOOL_MATERIAL = new CustomToolMaterial("HippocampusSword", 0, 500, -2F, 0F, 50);
    public static CustomToolMaterial DREAD_SWORD_TOOL_MATERIAL = new CustomToolMaterial("DreadSword", 0, 100, 1F, 10F, 0);
    public static CustomToolMaterial DREAD_KNIGHT_TOOL_MATERIAL = new CustomToolMaterial("DreadKnightSword", 0, 1200, 13F, 0F, 10);
    
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IceAndFire.MODID);


    public static final RegistryObject<Item> SAPPHIRE_GEM = registerItem("sapphire_gem", ItemGeneric::new);
    public static final RegistryObject<Item> SILVER_INGOT = registerItem("silver_ingot", ItemGeneric::new);
    public static final RegistryObject<Item> SILVER_NUGGET = registerItem("silver_nugget", ItemGeneric::new);
    public static final RegistryObject<Item> COPPER_NUGGET = registerItem("copper_nugget", ItemGeneric::new);
    public static final RegistryObject<Item> SILVER_HELMET = registerItem("armor_silver_metal_helmet", () -> new ItemSilverArmor(SILVER_ARMOR_MATERIAL, EquipmentSlot.HEAD));
    public static final RegistryObject<Item> SILVER_CHESTPLATE = registerItem("armor_silver_metal_chestplate", () -> new ItemSilverArmor(SILVER_ARMOR_MATERIAL, EquipmentSlot.CHEST));
    public static final RegistryObject<Item> SILVER_LEGGINGS = registerItem("armor_silver_metal_leggings", () -> new ItemSilverArmor(SILVER_ARMOR_MATERIAL, EquipmentSlot.LEGS));
    public static final RegistryObject<Item> SILVER_BOOTS = registerItem("armor_silver_metal_boots", () -> new ItemSilverArmor(SILVER_ARMOR_MATERIAL, EquipmentSlot.FEET));
    public static final RegistryObject<Item> SILVER_SWORD = registerItem("silver_sword", () -> new ItemModSword(SILVER_TOOL_MATERIAL));
    public static final RegistryObject<Item> SILVER_SHOVEL = registerItem("silver_shovel", () -> new ItemModShovel(SILVER_TOOL_MATERIAL));
    public static final RegistryObject<Item> SILVER_PICKAXE = registerItem("silver_pickaxe", () -> new ItemModPickaxe(SILVER_TOOL_MATERIAL));
    public static final RegistryObject<Item> SILVER_AXE = registerItem("silver_axe", () -> new ItemModAxe(SILVER_TOOL_MATERIAL));
    public static final RegistryObject<Item> SILVER_HOE = registerItem("silver_hoe", () -> new ItemModHoe(SILVER_TOOL_MATERIAL));

    public static final RegistryObject<Item> COPPER_HELMET = registerItem("armor_copper_metal_helmet", () -> new ItemCopperArmor(COPPER_ARMOR_MATERIAL, EquipmentSlot.HEAD));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = registerItem("armor_copper_metal_chestplate", () -> new ItemCopperArmor(COPPER_ARMOR_MATERIAL, EquipmentSlot.CHEST));
    public static final RegistryObject<Item> COPPER_LEGGINGS = registerItem("armor_copper_metal_leggings", () -> new ItemCopperArmor(COPPER_ARMOR_MATERIAL, EquipmentSlot.LEGS));
    public static final RegistryObject<Item> COPPER_BOOTS = registerItem("armor_copper_metal_boots", () -> new ItemCopperArmor(COPPER_ARMOR_MATERIAL, EquipmentSlot.FEET));
    public static final RegistryObject<Item> COPPER_SWORD = registerItem("copper_sword", () -> new ItemModSword(COPPER_TOOL_MATERIAL));
    public static final RegistryObject<Item> COPPER_SHOVEL = registerItem("copper_shovel", () -> new ItemModShovel(COPPER_TOOL_MATERIAL));
    public static final RegistryObject<Item> COPPER_PICKAXE = registerItem("copper_pickaxe", () -> new ItemModPickaxe(COPPER_TOOL_MATERIAL));
    public static final RegistryObject<Item> COPPER_AXE = registerItem("copper_axe", () -> new ItemModAxe(COPPER_TOOL_MATERIAL));
    public static final RegistryObject<Item> COPPER_HOE = registerItem("copper_hoe", () -> new ItemModHoe(COPPER_TOOL_MATERIAL));

    public static final RegistryObject<Item> FIRE_STEW = registerItem("fire_stew", ItemGeneric::new);
    public static final RegistryObject<Item> FROST_STEW = registerItem("frost_stew", ItemGeneric::new);
    public static final RegistryObject<Item> LIGHTNING_STEW = registerItem("lightning_stew", ItemGeneric::new);
    public static final RegistryObject<Item> DRAGONEGG_RED = registerItem("dragonegg_red", () -> new ItemDragonEgg(EnumDragonEgg.RED));
    public static final RegistryObject<Item> DRAGONEGG_GREEN = registerItem("dragonegg_green", () -> new ItemDragonEgg(EnumDragonEgg.GREEN));
    public static final RegistryObject<Item> DRAGONEGG_BRONZE = registerItem("dragonegg_bronze", () -> new ItemDragonEgg(EnumDragonEgg.BRONZE));
    public static final RegistryObject<Item> DRAGONEGG_GRAY = registerItem("dragonegg_gray", () -> new ItemDragonEgg(EnumDragonEgg.GRAY));
    public static final RegistryObject<Item> DRAGONEGG_BLUE = registerItem("dragonegg_blue", () -> new ItemDragonEgg(EnumDragonEgg.BLUE));
    public static final RegistryObject<Item> DRAGONEGG_WHITE = registerItem("dragonegg_white", () -> new ItemDragonEgg(EnumDragonEgg.WHITE));
    public static final RegistryObject<Item> DRAGONEGG_SAPPHIRE = registerItem("dragonegg_sapphire", () -> new ItemDragonEgg(EnumDragonEgg.SAPPHIRE));
    public static final RegistryObject<Item> DRAGONEGG_SILVER = registerItem("dragonegg_silver", () -> new ItemDragonEgg(EnumDragonEgg.SILVER));
    public static final RegistryObject<Item> DRAGONEGG_ELECTRIC = registerItem("dragonegg_electric", () -> new ItemDragonEgg(EnumDragonEgg.ELECTRIC));
    public static final RegistryObject<Item> DRAGONEGG_AMYTHEST = registerItem("dragonegg_amythest", () -> new ItemDragonEgg(EnumDragonEgg.AMYTHEST));
    public static final RegistryObject<Item> DRAGONEGG_COPPER = registerItem("dragonegg_copper", () -> new ItemDragonEgg(EnumDragonEgg.COPPER));
    public static final RegistryObject<Item> DRAGONEGG_BLACK = registerItem("dragonegg_black", () -> new ItemDragonEgg(EnumDragonEgg.BLACK));
    public static final RegistryObject<Item> DRAGONSCALES_RED = registerItem("dragonscales_red", () -> new ItemDragonScales(EnumDragonEgg.RED));
    public static final RegistryObject<Item> DRAGONSCALES_GREEN = registerItem("dragonscales_green", () -> new ItemDragonScales(EnumDragonEgg.GREEN));
    public static final RegistryObject<Item> DRAGONSCALES_BRONZE = registerItem("dragonscales_bronze", () -> new ItemDragonScales(EnumDragonEgg.BRONZE));
    public static final RegistryObject<Item> DRAGONSCALES_GRAY = registerItem("dragonscales_gray", () -> new ItemDragonScales(EnumDragonEgg.GRAY));
    public static final RegistryObject<Item> DRAGONSCALES_BLUE = registerItem("dragonscales_blue", () -> new ItemDragonScales(EnumDragonEgg.BLUE));
    public static final RegistryObject<Item> DRAGONSCALES_WHITE = registerItem("dragonscales_white", () -> new ItemDragonScales(EnumDragonEgg.WHITE));
    public static final RegistryObject<Item> DRAGONSCALES_SAPPHIRE = registerItem("dragonscales_sapphire", () -> new ItemDragonScales(EnumDragonEgg.SAPPHIRE));
    public static final RegistryObject<Item> DRAGONSCALES_SILVER = registerItem("dragonscales_silver", () -> new ItemDragonScales(EnumDragonEgg.SILVER));
    public static final RegistryObject<Item> DRAGONSCALES_ELECTRIC = registerItem("dragonscales_electric", () -> new ItemDragonScales(EnumDragonEgg.ELECTRIC));
    public static final RegistryObject<Item> DRAGONSCALES_AMYTHEST = registerItem("dragonscales_amythest", () -> new ItemDragonScales(EnumDragonEgg.AMYTHEST));
    public static final RegistryObject<Item> DRAGONSCALES_COPPER = registerItem("dragonscales_copper", () -> new ItemDragonScales(EnumDragonEgg.COPPER));
    public static final RegistryObject<Item> DRAGONSCALES_BLACK = registerItem("dragonscales_black", () -> new ItemDragonScales(EnumDragonEgg.BLACK));
    public static final RegistryObject<Item> DRAGON_BONE = registerItem("dragonbone", () -> new ItemDragonBone());
    public static final RegistryObject<Item> WITHERBONE = registerItem("witherbone", ItemGeneric::new);
    public static final RegistryObject<Item> FISHING_SPEAR = registerItem("fishing_spear", () -> new ItemFishingSpear());
    public static final RegistryObject<Item> WITHER_SHARD = registerItem("wither_shard", ItemGeneric::new);
    public static final RegistryObject<Item> DRAGONBONE_SWORD = registerItem("dragonbone_sword", () -> new ItemModSword(DRAGONBONE_TOOL_MATERIAL));
    public static final RegistryObject<Item> DRAGONBONE_SHOVEL = registerItem("dragonbone_shovel", () -> new ItemModShovel(DRAGONBONE_TOOL_MATERIAL));
    public static final RegistryObject<Item> DRAGONBONE_PICKAXE = registerItem("dragonbone_pickaxe", () -> new ItemModPickaxe(DRAGONBONE_TOOL_MATERIAL));
    public static final RegistryObject<Item> DRAGONBONE_AXE = registerItem("dragonbone_axe", () -> new ItemModAxe(DRAGONBONE_TOOL_MATERIAL));
    public static final RegistryObject<Item> DRAGONBONE_HOE = registerItem("dragonbone_hoe", () -> new ItemModHoe(DRAGONBONE_TOOL_MATERIAL));
    public static final RegistryObject<Item> DRAGONBONE_SWORD_FIRE = registerItem("dragonbone_sword_fire", () -> new ItemAlchemySword(FIRE_DRAGONBONE_TOOL_MATERIAL));
    public static final RegistryObject<Item> DRAGONBONE_SWORD_ICE = registerItem("dragonbone_sword_ice", () -> new ItemAlchemySword(ICE_DRAGONBONE_TOOL_MATERIAL));
    public static final RegistryObject<Item> DRAGONBONE_SWORD_LIGHTNING = registerItem("dragonbone_sword_lightning", () -> new ItemAlchemySword(LIGHTNING_DRAGONBONE_TOOL_MATERIAL));
    public static final RegistryObject<Item> DRAGONBONE_ARROW = registerItem("dragonbone_arrow", () -> new ItemDragonArrow());
    public static final RegistryObject<Item> DRAGON_BOW = registerItem("dragonbone_bow", () -> new ItemDragonBow());
    public static final RegistryObject<Item> DRAGON_SKULL_FIRE = registerItem(ItemDragonSkull.getName(0), () -> new ItemDragonSkull(0));
    public static final RegistryObject<Item> DRAGON_SKULL_ICE = registerItem(ItemDragonSkull.getName(1), () -> new ItemDragonSkull(1));
    public static final RegistryObject<Item> DRAGON_SKULL_LIGHTNING = registerItem(ItemDragonSkull.getName(2), () -> new ItemDragonSkull(2));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_IRON_0 = registerItem("dragonarmor_iron_" + ItemDragonArmor.getNameForSlot(0), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.IRON, 0));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_IRON_1 = registerItem("dragonarmor_iron_" + ItemDragonArmor.getNameForSlot(1), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.IRON, 1));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_IRON_2 = registerItem("dragonarmor_iron_" + ItemDragonArmor.getNameForSlot(2), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.IRON, 2));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_IRON_3 = registerItem("dragonarmor_iron_" + ItemDragonArmor.getNameForSlot(3), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.IRON, 3));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_COPPER_0 = registerItem("dragonarmor_copper_" + ItemDragonArmor.getNameForSlot(0), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.COPPER, 0));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_COPPER_1 = registerItem("dragonarmor_copper_" + ItemDragonArmor.getNameForSlot(1), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.COPPER, 1));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_COPPER_2 = registerItem("dragonarmor_copper_" + ItemDragonArmor.getNameForSlot(2), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.COPPER, 2));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_COPPER_3 = registerItem("dragonarmor_copper_" + ItemDragonArmor.getNameForSlot(3), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.COPPER, 3));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_GOLD_0 = registerItem("dragonarmor_gold_" + ItemDragonArmor.getNameForSlot(0), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.GOLD, 0));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_GOLD_1 = registerItem("dragonarmor_gold_" + ItemDragonArmor.getNameForSlot(1), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.GOLD, 1));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_GOLD_2 = registerItem("dragonarmor_gold_" + ItemDragonArmor.getNameForSlot(2), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.GOLD, 2));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_GOLD_3 = registerItem("dragonarmor_gold_" + ItemDragonArmor.getNameForSlot(3), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.GOLD, 3));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DIAMOND_0 = registerItem("dragonarmor_diamond_" + ItemDragonArmor.getNameForSlot(0), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.DIAMOND, 0));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DIAMOND_1 = registerItem("dragonarmor_diamond_" + ItemDragonArmor.getNameForSlot(1), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.DIAMOND, 1));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DIAMOND_2 = registerItem("dragonarmor_diamond_" + ItemDragonArmor.getNameForSlot(2), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.DIAMOND, 2));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DIAMOND_3 = registerItem("dragonarmor_diamond_" + ItemDragonArmor.getNameForSlot(3), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.DIAMOND, 3));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_SILVER_0 = registerItem("dragonarmor_silver_" + ItemDragonArmor.getNameForSlot(0), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.SILVER, 0));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_SILVER_1 = registerItem("dragonarmor_silver_" + ItemDragonArmor.getNameForSlot(1), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.SILVER, 1));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_SILVER_2 = registerItem("dragonarmor_silver_" + ItemDragonArmor.getNameForSlot(2), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.SILVER, 2));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_SILVER_3 = registerItem("dragonarmor_silver_" + ItemDragonArmor.getNameForSlot(3), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.SILVER, 3));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DRAGONSTEEL_FIRE_0 = registerItem("dragonarmor_dragonsteel_fire_" + ItemDragonArmor.getNameForSlot(0), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.FIRE, 0));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DRAGONSTEEL_FIRE_1 = registerItem("dragonarmor_dragonsteel_fire_" + ItemDragonArmor.getNameForSlot(1), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.FIRE, 1));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DRAGONSTEEL_FIRE_2 = registerItem("dragonarmor_dragonsteel_fire_" + ItemDragonArmor.getNameForSlot(2), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.FIRE, 2));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DRAGONSTEEL_FIRE_3 = registerItem("dragonarmor_dragonsteel_fire_" + ItemDragonArmor.getNameForSlot(3), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.FIRE, 3));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DRAGONSTEEL_ICE_0 = registerItem("dragonarmor_dragonsteel_ice_" + ItemDragonArmor.getNameForSlot(0), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.ICE, 0));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DRAGONSTEEL_ICE_1 = registerItem("dragonarmor_dragonsteel_ice_" + ItemDragonArmor.getNameForSlot(1), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.ICE, 1));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DRAGONSTEEL_ICE_2 = registerItem("dragonarmor_dragonsteel_ice_" + ItemDragonArmor.getNameForSlot(2), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.ICE, 2));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DRAGONSTEEL_ICE_3 = registerItem("dragonarmor_dragonsteel_ice_" + ItemDragonArmor.getNameForSlot(3), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.ICE, 3));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DRAGONSTEEL_LIGHTNING_0 = registerItem("dragonarmor_dragonsteel_lightning_" + ItemDragonArmor.getNameForSlot(0), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.LIGHTNING, 0));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DRAGONSTEEL_LIGHTNING_1 = registerItem("dragonarmor_dragonsteel_lightning_" + ItemDragonArmor.getNameForSlot(1), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.LIGHTNING, 1));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DRAGONSTEEL_LIGHTNING_2 = registerItem("dragonarmor_dragonsteel_lightning_" + ItemDragonArmor.getNameForSlot(2), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.LIGHTNING, 2));
    public static final RegistryObject<ItemDragonArmor> DRAGONARMOR_DRAGONSTEEL_LIGHTNING_3 = registerItem("dragonarmor_dragonsteel_lightning_" + ItemDragonArmor.getNameForSlot(3), () -> new ItemDragonArmor(ItemDragonArmor.DragonArmorType.LIGHTNING, 3));
    public static final RegistryObject<Item> DRAGON_MEAL = registerItem("dragon_meal", ItemGeneric::new);
    public static final RegistryObject<Item> SICKLY_DRAGON_MEAL = registerItem("sickly_dragon_meal", () -> new ItemGeneric(1));
    public static final RegistryObject<Item> CREATIVE_DRAGON_MEAL = registerItem("creative_dragon_meal", () -> new ItemGeneric(2));
    public static final RegistryObject<Item> FIRE_DRAGON_FLESH = registerItem(ItemDragonFlesh.getNameForType(0), () -> new ItemDragonFlesh(0));
    public static final RegistryObject<Item> ICE_DRAGON_FLESH = registerItem(ItemDragonFlesh.getNameForType(1), () -> new ItemDragonFlesh(1));
    public static final RegistryObject<Item> LIGHTNING_DRAGON_FLESH = registerItem(ItemDragonFlesh.getNameForType(2), () -> new ItemDragonFlesh(2));
    public static final RegistryObject<Item> FIRE_DRAGON_HEART = registerItem("fire_dragon_heart", ItemGeneric::new);
    public static final RegistryObject<Item> ICE_DRAGON_HEART = registerItem("ice_dragon_heart", ItemGeneric::new);
    public static final RegistryObject<Item> LIGHTNING_DRAGON_HEART = registerItem("lightning_dragon_heart", ItemGeneric::new);
    public static final RegistryObject<Item> FIRE_DRAGON_BLOOD = registerItem("fire_dragon_blood", ItemGeneric::new);
    public static final RegistryObject<Item> ICE_DRAGON_BLOOD = registerItem("ice_dragon_blood", ItemGeneric::new);
    public static final RegistryObject<Item> LIGHTNING_DRAGON_BLOOD = registerItem("lightning_dragon_blood", ItemGeneric::new);
    public static final RegistryObject<Item> DRAGON_STAFF = registerItem("dragon_stick", () -> new ItemDragonStaff());
    public static final RegistryObject<Item> DRAGON_HORN = registerItem("dragon_horn", () -> new ItemDragonHorn());
    public static final RegistryObject<Item> DRAGON_FLUTE = registerItem("dragon_flute", () -> new ItemDragonFlute());
    public static final RegistryObject<Item> SUMMONING_CRYSTAL_FIRE = registerItem("summoning_crystal_fire", () -> new ItemSummoningCrystal());
    public static final RegistryObject<Item> SUMMONING_CRYSTAL_ICE = registerItem("summoning_crystal_ice", () -> new ItemSummoningCrystal());
    public static final RegistryObject<Item> SUMMONING_CRYSTAL_LIGHTNING = registerItem("summoning_crystal_lightning", () -> new ItemSummoningCrystal());
    public static final RegistryObject<Item> HIPPOGRYPH_EGG = registerItem("hippogryph_egg", () -> new ItemHippogryphEgg());
    public static final RegistryObject<Item> IRON_HIPPOGRYPH_ARMOR = registerItem("iron_hippogryph_armor", () -> new ItemGeneric(0, 1));
    public static final RegistryObject<Item> GOLD_HIPPOGRYPH_ARMOR = registerItem("gold_hippogryph_armor", () -> new ItemGeneric(0, 1));
    public static final RegistryObject<Item> DIAMOND_HIPPOGRYPH_ARMOR = registerItem("diamond_hippogryph_armor", () -> new ItemGeneric(0, 1));
    public static final RegistryObject<Item> HIPPOGRYPH_TALON = registerItem("hippogryph_talon", () -> new ItemGeneric(1));
    public static final RegistryObject<Item> HIPPOGRYPH_SWORD = registerItem("hippogryph_sword", () -> new ItemHippogryphSword());
    public static final RegistryObject<Item> GORGON_HEAD = registerItem("gorgon_head", () -> new ItemGorgonHead());
    public static final RegistryObject<Item> STONE_STATUE = registerItem("stone_statue", () -> new ItemStoneStatue());
    public static final RegistryObject<Item> BLINDFOLD = registerItem("blindfold", () -> new ItemBlindfold());
    public static final RegistryObject<Item> PIXIE_DUST = registerItem("pixie_dust", () -> new ItemPixieDust());
    public static final RegistryObject<Item> PIXIE_WINGS = registerItem("pixie_wings", () -> new ItemGeneric(1));
    public static final RegistryObject<Item> PIXIE_WAND = registerItem("pixie_wand", () -> new ItemPixieWand());
    public static final RegistryObject<Item> AMBROSIA = registerItem("ambrosia", () -> new ItemAmbrosia());
    public static final RegistryObject<Item> SHEEP_HELMET = registerItem("sheep_helmet", () -> new ItemModArmor(SHEEP_ARMOR_MATERIAL, EquipmentSlot.HEAD));
    public static final RegistryObject<Item> SHEEP_CHESTPLATE = registerItem("sheep_chestplate", () -> new ItemModArmor(SHEEP_ARMOR_MATERIAL, EquipmentSlot.CHEST));
    public static final RegistryObject<Item> SHEEP_LEGGINGS = registerItem("sheep_leggings", () -> new ItemModArmor(SHEEP_ARMOR_MATERIAL, EquipmentSlot.LEGS));
    public static final RegistryObject<Item> SHEEP_BOOTS = registerItem("sheep_boots", () -> new ItemModArmor(SHEEP_ARMOR_MATERIAL, EquipmentSlot.FEET));
    public static final RegistryObject<Item> SHINY_SCALES = registerItem("shiny_scales", ItemGeneric::new);
    public static final RegistryObject<Item> SIREN_TEAR = registerItem("siren_tear", () -> new ItemGeneric(1));
    public static final RegistryObject<Item> SIREN_FLUTE = registerItem("siren_flute", () -> new ItemSirenFlute());
    public static final RegistryObject<Item> HIPPOCAMPUS_FIN = registerItem("hippocampus_fin", () -> new ItemGeneric(1));
    public static final RegistryObject<Item> HIPPOCAMPUS_SLAPPER = registerItem("hippocampus_slapper", () -> new ItemHippocampusSlapper());
    public static final RegistryObject<Item> EARPLUGS = registerItem("earplugs", () -> new ItemModArmor(EARPLUGS_ARMOR_MATERIAL, EquipmentSlot.HEAD));
    public static final RegistryObject<Item> ROTTEN_EGG = registerItem("rotten_egg", () -> new ItemRottenEgg());
    public static final RegistryObject<Item> COCKATRICE_EYE = registerItem("cockatrice_eye", () -> new ItemGeneric(1));
    public static final RegistryObject<Item> ITEM_COCKATRICE_SCEPTER = registerItem("cockatrice_scepter", () -> new ItemCockatriceScepter());
    public static final RegistryObject<Item> AMPHITHERE_FEATHER = registerItem("amphithere_feather", ItemGeneric::new);
    public static final RegistryObject<Item> AMPHITHERE_ARROW = registerItem("amphithere_arrow", () -> new ItemAmphithereArrow());
    public static final RegistryObject<Item> AMPHITHERE_MACUAHUITL = registerItem("amphithere_macuahuitl", () -> new ItemAmphithereMacuahuitl());
    public static final RegistryObject<Item> CHAIN = registerItem("chain", () -> new ItemChain(false));
    public static final RegistryObject<Item> CHAIN_STICKY = registerItem("chain_sticky", () -> new ItemChain(true));
    public static final RegistryObject<Item> DRAGONSTEEL_FIRE_INGOT = registerItem("dragonsteel_fire_ingot", ItemGeneric::new);
    public static final RegistryObject<Item> DRAGONSTEEL_FIRE_SWORD = registerItem("dragonsteel_fire_sword", () -> new ItemModSword(DRAGONSTEEL_TIER_FIRE));
    public static final RegistryObject<Item> DRAGONSTEEL_FIRE_PICKAXE = registerItem("dragonsteel_fire_pickaxe", () -> new ItemModPickaxe(DRAGONSTEEL_TIER_FIRE));
    public static final RegistryObject<Item> DRAGONSTEEL_FIRE_AXE = registerItem("dragonsteel_fire_axe", () -> new ItemModAxe(DRAGONSTEEL_TIER_FIRE));
    public static final RegistryObject<Item> DRAGONSTEEL_FIRE_SHOVEL = registerItem("dragonsteel_fire_shovel", () -> new ItemModShovel(DRAGONSTEEL_TIER_FIRE));
    public static final RegistryObject<Item> DRAGONSTEEL_FIRE_HOE = registerItem("dragonsteel_fire_hoe", () -> new ItemModHoe(DRAGONSTEEL_TIER_FIRE));
    public static final RegistryObject<Item> DRAGONSTEEL_FIRE_HELMET = registerItem("dragonsteel_fire_helmet", () -> new ItemDragonsteelArmor(DRAGONSTEEL_FIRE_ARMOR_MATERIAL, 0, EquipmentSlot.HEAD));
    public static final RegistryObject<Item> DRAGONSTEEL_FIRE_CHESTPLATE = registerItem("dragonsteel_fire_chestplate", () -> new ItemDragonsteelArmor(DRAGONSTEEL_FIRE_ARMOR_MATERIAL, 1, EquipmentSlot.CHEST));
    public static final RegistryObject<Item> DRAGONSTEEL_FIRE_LEGGINGS = registerItem("dragonsteel_fire_leggings", () -> new ItemDragonsteelArmor(DRAGONSTEEL_FIRE_ARMOR_MATERIAL, 2, EquipmentSlot.LEGS));
    public static final RegistryObject<Item> DRAGONSTEEL_FIRE_BOOTS = registerItem("dragonsteel_fire_boots", () -> new ItemDragonsteelArmor(DRAGONSTEEL_FIRE_ARMOR_MATERIAL, 3, EquipmentSlot.FEET));
    public static final RegistryObject<Item> DRAGONSTEEL_ICE_INGOT = registerItem("dragonsteel_ice_ingot", ItemGeneric::new);
    public static final RegistryObject<Item> DRAGONSTEEL_ICE_SWORD = registerItem("dragonsteel_ice_sword", () -> new ItemModSword(DRAGONSTEEL_TIER_ICE));
    public static final RegistryObject<Item> DRAGONSTEEL_ICE_PICKAXE = registerItem("dragonsteel_ice_pickaxe", () -> new ItemModPickaxe(DRAGONSTEEL_TIER_ICE));
    public static final RegistryObject<Item> DRAGONSTEEL_ICE_AXE = registerItem("dragonsteel_ice_axe", () -> new ItemModAxe(DRAGONSTEEL_TIER_ICE));
    public static final RegistryObject<Item> DRAGONSTEEL_ICE_SHOVEL = registerItem("dragonsteel_ice_shovel", () -> new ItemModShovel(DRAGONSTEEL_TIER_ICE));
    public static final RegistryObject<Item> DRAGONSTEEL_ICE_HOE = registerItem("dragonsteel_ice_hoe", () -> new ItemModHoe(DRAGONSTEEL_TIER_ICE));
    public static final RegistryObject<Item> DRAGONSTEEL_ICE_HELMET = registerItem("dragonsteel_ice_helmet", () -> new ItemDragonsteelArmor(DRAGONSTEEL_ICE_ARMOR_MATERIAL, 0, EquipmentSlot.HEAD));
    public static final RegistryObject<Item> DRAGONSTEEL_ICE_CHESTPLATE = registerItem("dragonsteel_ice_chestplate", () -> new ItemDragonsteelArmor(DRAGONSTEEL_ICE_ARMOR_MATERIAL, 1, EquipmentSlot.CHEST));
    public static final RegistryObject<Item> DRAGONSTEEL_ICE_LEGGINGS = registerItem("dragonsteel_ice_leggings", () -> new ItemDragonsteelArmor(DRAGONSTEEL_ICE_ARMOR_MATERIAL, 2, EquipmentSlot.LEGS));
    public static final RegistryObject<Item> DRAGONSTEEL_ICE_BOOTS = registerItem("dragonsteel_ice_boots", () -> new ItemDragonsteelArmor(DRAGONSTEEL_ICE_ARMOR_MATERIAL, 3, EquipmentSlot.FEET));

    public static final RegistryObject<Item> DRAGONSTEEL_LIGHTNING_INGOT = registerItem("dragonsteel_lightning_ingot", ItemGeneric::new);
    public static final RegistryObject<Item> DRAGONSTEEL_LIGHTNING_SWORD = registerItem("dragonsteel_lightning_sword", () -> new ItemModSword(DRAGONSTEEL_TIER_LIGHTNING));
    public static final RegistryObject<Item> DRAGONSTEEL_LIGHTNING_PICKAXE = registerItem("dragonsteel_lightning_pickaxe", () -> new ItemModPickaxe(DRAGONSTEEL_TIER_LIGHTNING));
    public static final RegistryObject<Item> DRAGONSTEEL_LIGHTNING_AXE = registerItem("dragonsteel_lightning_axe", () -> new ItemModAxe(DRAGONSTEEL_TIER_LIGHTNING));
    public static final RegistryObject<Item> DRAGONSTEEL_LIGHTNING_SHOVEL = registerItem("dragonsteel_lightning_shovel", () -> new ItemModShovel(DRAGONSTEEL_TIER_LIGHTNING));
    public static final RegistryObject<Item> DRAGONSTEEL_LIGHTNING_HOE = registerItem("dragonsteel_lightning_hoe", () -> new ItemModHoe(DRAGONSTEEL_TIER_LIGHTNING));
    public static final RegistryObject<Item> DRAGONSTEEL_LIGHTNING_HELMET = registerItem("dragonsteel_lightning_helmet", () -> new ItemDragonsteelArmor(DRAGONSTEEL_LIGHTNING_ARMOR_MATERIAL, 0, EquipmentSlot.HEAD));
    public static final RegistryObject<Item> DRAGONSTEEL_LIGHTNING_CHESTPLATE = registerItem("dragonsteel_lightning_chestplate", () -> new ItemDragonsteelArmor(DRAGONSTEEL_LIGHTNING_ARMOR_MATERIAL, 1, EquipmentSlot.CHEST));
    public static final RegistryObject<Item> DRAGONSTEEL_LIGHTNING_LEGGINGS = registerItem("dragonsteel_lightning_leggings", () -> new ItemDragonsteelArmor(DRAGONSTEEL_LIGHTNING_ARMOR_MATERIAL, 2, EquipmentSlot.LEGS));
    public static final RegistryObject<Item> DRAGONSTEEL_LIGHTNING_BOOTS = registerItem("dragonsteel_lightning_boots", () -> new ItemDragonsteelArmor(DRAGONSTEEL_LIGHTNING_ARMOR_MATERIAL, 3, EquipmentSlot.FEET));


    public static final RegistryObject<Item> WEEZER_BLUE_ALBUM = registerItem("weezer_blue_album", () -> new ItemGeneric(1, true));
    public static final RegistryObject<Item> DRAGON_DEBUG_STICK = registerItem("dragon_debug_stick", () -> new ItemGeneric(1, true), false);
    public static final RegistryObject<Item> DREAD_SWORD = registerItem("dread_sword", () -> new ItemModSword(DREAD_SWORD_TOOL_MATERIAL));
    public static final RegistryObject<Item> DREAD_KNIGHT_SWORD = registerItem("dread_knight_sword", () -> new ItemModSword(DREAD_KNIGHT_TOOL_MATERIAL));
    public static final RegistryObject<Item> LICH_STAFF = registerItem("lich_staff", () -> new ItemLichStaff());
    public static final RegistryObject<Item> DREAD_QUEEN_SWORD = registerItem("dread_queen_sword", () -> new ItemModSword(DRAGONSTEEL_TIER_DREAD_QUEEN));
    public static final RegistryObject<Item> DREAD_QUEEN_STAFF = registerItem("dread_queen_staff", () -> new ItemDreadQueenStaff());
    public static final RegistryObject<Item> DREAD_SHARD = registerItem("dread_shard", () -> new ItemGeneric(0));
    public static final RegistryObject<Item> DREAD_KEY = registerItem("dread_key", () -> new ItemGeneric(0));
    public static final RegistryObject<Item> HYDRA_FANG = registerItem("hydra_fang", () -> new ItemGeneric(0));
    public static final RegistryObject<Item> HYDRA_HEART = registerItem("hydra_heart", () -> new ItemHydraHeart());
    public static final RegistryObject<Item> HYDRA_ARROW = registerItem("hydra_arrow", () -> new ItemHydraArrow());
    public static final RegistryObject<Item> CANNOLI = registerItem("cannoli", () -> new ItemCannoli(), false);
    
    public static final RegistryObject<BannerPatternItem> PATTERN_FIRE = registerItem("banner_pattern_fire", () -> new BannerPatternItem(BannerPatternTagGenerator.FIRE_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_ICE = registerItem("banner_pattern_ice", () -> new BannerPatternItem(BannerPatternTagGenerator.ICE_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_LIGHTNING = registerItem("banner_pattern_lightning", () -> new BannerPatternItem(BannerPatternTagGenerator.LIGHTNING_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_FIRE_HEAD = registerItem("banner_pattern_fire_head", () -> new BannerPatternItem(BannerPatternTagGenerator.FIRE_HEAD_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_ICE_HEAD = registerItem("banner_pattern_ice_head", () -> new BannerPatternItem(BannerPatternTagGenerator.ICE_HEAD_BANNER_PATTERN , unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_LIGHTNING_HEAD = registerItem("banner_pattern_lightning_head", () -> new BannerPatternItem(BannerPatternTagGenerator.LIGHTNING_HEAD_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_AMPHITHERE = registerItem("banner_pattern_amphithere", () -> new BannerPatternItem(BannerPatternTagGenerator.AMPHITHERE_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_BIRD = registerItem("banner_pattern_bird", () -> new BannerPatternItem(BannerPatternTagGenerator.BIRD_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_EYE = registerItem("banner_pattern_eye", () -> new BannerPatternItem(BannerPatternTagGenerator.EYE_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_FAE = registerItem("banner_pattern_fae", () -> new BannerPatternItem(BannerPatternTagGenerator.FAE_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_FEATHER = registerItem("banner_pattern_feather", () -> new BannerPatternItem(BannerPatternTagGenerator.FEATHER_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_GORGON = registerItem("banner_pattern_gorgon", () -> new BannerPatternItem(BannerPatternTagGenerator.GORGON_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_HIPPOCAMPUS = registerItem("banner_pattern_hippocampus", () -> new BannerPatternItem(BannerPatternTagGenerator.HIPPOCAMPUS_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_HIPPOGRYPH_HEAD = registerItem("banner_pattern_hippogryph_head", () -> new BannerPatternItem(BannerPatternTagGenerator.HIPPOGRYPH_HEAD_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_MERMAID = registerItem("banner_pattern_mermaid", () -> new BannerPatternItem(BannerPatternTagGenerator.MERMAID_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_WEEZER = registerItem("banner_pattern_weezer", () -> new BannerPatternItem(BannerPatternTagGenerator.WEEZER_BANNER_PATTERN, unstackable()));
    public static final RegistryObject<BannerPatternItem> PATTERN_DREAD = registerItem("banner_pattern_dread", () -> new BannerPatternItem(BannerPatternTagGenerator.DREAD_BANNER_PATTERN, unstackable()));

    static {
        EnumDragonArmor.initArmors();
        EnumSkullType.initItems();
    }

    public static Item.Properties defaultBuilder() {
        return new Item.Properties().tab(IceAndFire.TAB_ITEMS);
    }

    public static Item.Properties unstackable() {
        return defaultBuilder().stacksTo(1);
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerItems(NewRegistryEvent event) {
        //spawn Eggs
        //@formatter:off
        registerItem("spawn_egg_fire_dragon", () -> new ForgeSpawnEggItem(IafEntityRegistry.FIRE_DRAGON, 0X340000, 0XA52929, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_ice_dragon", () -> new ForgeSpawnEggItem(IafEntityRegistry.ICE_DRAGON, 0XB5DDFB, 0X7EBAF0, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_lightning_dragon", () -> new ForgeSpawnEggItem(IafEntityRegistry.LIGHTNING_DRAGON, 0X422367, 0X725691, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_hippogryph", () -> new ForgeSpawnEggItem(IafEntityRegistry.HIPPOGRYPH, 0XD8D8D8, 0XD1B55D, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_gorgon", () -> new ForgeSpawnEggItem(IafEntityRegistry.GORGON, 0XD0D99F, 0X684530, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_pixie", () -> new ForgeSpawnEggItem(IafEntityRegistry.PIXIE, 0XFF7F89, 0XE2CCE2, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_siren", () -> new ForgeSpawnEggItem(IafEntityRegistry.SIREN, 0X8EE6CA, 0XF2DFC8, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_hippocampus", () -> new ForgeSpawnEggItem(IafEntityRegistry.HIPPOCAMPUS, 0X4491C7, 0X4FC56B, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_cockatrice", () -> new ForgeSpawnEggItem(IafEntityRegistry.COCKATRICE, 0X8F5005, 0X4F5A23, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_amphithere", () -> new ForgeSpawnEggItem(IafEntityRegistry.AMPHITHERE, 0X597535, 0X00AA98, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_dread_thrall", () -> new ForgeSpawnEggItem(IafEntityRegistry.DREAD_THRALL, 0XE0E6E6, 0X00FFFF, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_dread_ghoul", () -> new ForgeSpawnEggItem(IafEntityRegistry.DREAD_GHOUL, 0XE0E6E6, 0X7B838A, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_dread_beast", () -> new ForgeSpawnEggItem(IafEntityRegistry.DREAD_BEAST, 0XE0E6E6, 0X38373C, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_dread_scuttler", () -> new ForgeSpawnEggItem(IafEntityRegistry.DREAD_SCUTTLER, 0XE0E6E6, 0X4D5667, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_lich", () -> new ForgeSpawnEggItem(IafEntityRegistry.DREAD_LICH, 0XE0E6E6, 0X274860, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_dread_knight", () -> new ForgeSpawnEggItem(IafEntityRegistry.DREAD_KNIGHT, 0XE0E6E6, 0X4A6C6E, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_dread_horse", () -> new ForgeSpawnEggItem(IafEntityRegistry.DREAD_HORSE, 0XE0E6E6, 0XACACAC, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
        registerItem("spawn_egg_hydra", () -> new ForgeSpawnEggItem(IafEntityRegistry.HYDRA, 0X8B8B78, 0X2E372B, new Item.Properties().tab(IceAndFire.TAB_ITEMS)));
    }

    public static <I extends Item> RegistryObject<I> registerItem(String name, Supplier<I> item) {
        return registerItem(name, item, true);
    }

    public static <I extends Item> RegistryObject<I> registerItem(String name, Supplier<I> item, boolean putInTab) {
        return ITEMS.register(name, item);
    }

    /**
     Set repair materials etc.
     Due to the priority it should run after {@link DeferredRegister#addEntries( RegisterEvent)}
     (and therefor not cause issues when accessing the suppliers)
    */
    @SubscribeEvent( priority = EventPriority.LOW)
    public static void setRepairMaterials(final RegisterEvent event) {
        if (event.getRegistryKey() != Registry.ITEM_REGISTRY) {
            return;
        }

        IafItemRegistry.BLINDFOLD_ARMOR_MATERIAL.setRepairMaterial(Ingredient.of(Tags.Items.STRING));
        IafItemRegistry.SILVER_ARMOR_MATERIAL.setRepairMaterial(Ingredient.of(IafItemTags.INGOTS_SILVER));
        IafItemRegistry.SILVER_TOOL_MATERIAL.setRepairMaterial(Ingredient.of(IafItemTags.INGOTS_SILVER));
        IafItemRegistry.DRAGONBONE_TOOL_MATERIAL.setRepairMaterial(Ingredient.of(IafItemRegistry.DRAGON_BONE.get()));
        IafItemRegistry.FIRE_DRAGONBONE_TOOL_MATERIAL.setRepairMaterial(Ingredient.of(IafItemRegistry.DRAGON_BONE.get()));
        IafItemRegistry.ICE_DRAGONBONE_TOOL_MATERIAL.setRepairMaterial(Ingredient.of(IafItemRegistry.DRAGON_BONE.get()));
        IafItemRegistry.LIGHTNING_DRAGONBONE_TOOL_MATERIAL.setRepairMaterial(Ingredient.of(IafItemRegistry.DRAGON_BONE.get()));
        for (EnumDragonArmor armor : EnumDragonArmor.values()) {
            armor.armorMaterial.setRepairMaterial(Ingredient.of(EnumDragonArmor.getScaleItem(armor)));
        }
        IafItemRegistry.DRAGONSTEEL_FIRE_ARMOR_MATERIAL.setRepairMaterial(Ingredient.of(IafItemRegistry.DRAGONSTEEL_FIRE_INGOT.get()));
        IafItemRegistry.DRAGONSTEEL_ICE_ARMOR_MATERIAL.setRepairMaterial(Ingredient.of(IafItemRegistry.DRAGONSTEEL_ICE_INGOT.get()));
        IafItemRegistry.DRAGONSTEEL_LIGHTNING_ARMOR_MATERIAL.setRepairMaterial(Ingredient.of(IafItemRegistry.DRAGONSTEEL_LIGHTNING_INGOT.get()));
        IafItemRegistry.SHEEP_ARMOR_MATERIAL.setRepairMaterial(Ingredient.of(Blocks.WHITE_WOOL));
        IafItemRegistry.EARPLUGS_ARMOR_MATERIAL.setRepairMaterial(Ingredient.of(Blocks.OAK_BUTTON));
        IafItemRegistry.HIPPOGRYPH_SWORD_TOOL_MATERIAL.setRepairMaterial(Ingredient.of(IafItemRegistry.HIPPOGRYPH_TALON.get()));
        IafItemRegistry.HIPPOCAMPUS_SWORD_TOOL_MATERIAL.setRepairMaterial(Ingredient.of(IafItemRegistry.SHINY_SCALES.get()));
        IafItemRegistry.AMPHITHERE_SWORD_TOOL_MATERIAL.setRepairMaterial(Ingredient.of(IafItemRegistry.AMPHITHERE_FEATHER.get()));
        IafItemRegistry.DREAD_SWORD_TOOL_MATERIAL.setRepairMaterial(Ingredient.of(IafItemRegistry.DREAD_SHARD.get()));
        IafItemRegistry.DREAD_KNIGHT_TOOL_MATERIAL.setRepairMaterial(Ingredient.of(IafItemRegistry.DREAD_SHARD.get()));
    }
}
