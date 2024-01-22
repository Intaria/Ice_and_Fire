package com.github.alexthe666.iceandfire.config;

import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class ServerConfig {

    public final ForgeConfigSpec.BooleanValue generateDragonSkeletons;
    public final ForgeConfigSpec.IntValue generateDragonSkeletonChance;
    public final ForgeConfigSpec.IntValue generateDragonDenChance;
    public final ForgeConfigSpec.IntValue generateDragonRoostChance;
    public final ForgeConfigSpec.IntValue dragonDenGoldAmount;
    public final ForgeConfigSpec.BooleanValue spawnGlaciers;
    public final ForgeConfigSpec.IntValue glacierSpawnChance;
    public final ForgeConfigSpec.IntValue oreToStoneRatioForDragonCaves;
    public final ForgeConfigSpec.IntValue dragonEggTime;
    public final ForgeConfigSpec.IntValue dragonGriefing;
    public final ForgeConfigSpec.BooleanValue tamedDragonGriefing;
    public final ForgeConfigSpec.IntValue dragonFlapNoiseDistance;
    public final ForgeConfigSpec.IntValue dragonFluteDistance;
    public final ForgeConfigSpec.DoubleValue dragonHealth;
    public final ForgeConfigSpec.IntValue dragonAttackDamage;
    public final ForgeConfigSpec.DoubleValue dragonAttackDamageFire;
    public final ForgeConfigSpec.DoubleValue dragonAttackDamageIce;
    public final ForgeConfigSpec.DoubleValue dragonAttackDamageLightning;
    public final ForgeConfigSpec.IntValue maxDragonFlight;
    public final ForgeConfigSpec.IntValue dragonGoldSearchLength;
    public final ForgeConfigSpec.BooleanValue canDragonsHealFromBiting;
    public final ForgeConfigSpec.BooleanValue canDragonsDespawn;
    public final ForgeConfigSpec.BooleanValue doDragonsSleep;
    public final ForgeConfigSpec.BooleanValue dragonDigWhenStuck;
    public final ForgeConfigSpec.IntValue dragonBreakBlockCooldown;
    public final ForgeConfigSpec.BooleanValue dragonDropSkull;
    public final ForgeConfigSpec.BooleanValue dragonDropHeart;
    public final ForgeConfigSpec.BooleanValue dragonDropBlood;
    public final ForgeConfigSpec.IntValue dragonTargetSearchLength;
    public final ForgeConfigSpec.IntValue dragonWanderFromHomeDistance;
    public final ForgeConfigSpec.IntValue dragonHungerTickRate;
    public final ForgeConfigSpec.BooleanValue spawnHippogryphs;
    public final ForgeConfigSpec.IntValue hippogryphSpawnRate;
    public final ForgeConfigSpec.BooleanValue generateGorgonTemple;
    public final ForgeConfigSpec.DoubleValue gorgonMaxHealth;
    public final ForgeConfigSpec.IntValue spawnPixiesChance;
    public final ForgeConfigSpec.IntValue pixieVillageSize;
    public final ForgeConfigSpec.BooleanValue pixiesStealItems;
    public final ForgeConfigSpec.IntValue spawnWanderingCyclopsChance;
    public final ForgeConfigSpec.IntValue spawnCyclopsCaveChance;
    public final ForgeConfigSpec.IntValue cyclopesSheepSearchLength;
    public final ForgeConfigSpec.DoubleValue cyclopsMaxHealth;
    public final ForgeConfigSpec.DoubleValue cyclopsAttackStrength;
    public final ForgeConfigSpec.DoubleValue cyclopsBiteStrength;
    public final ForgeConfigSpec.BooleanValue cyclopsGriefing;
    public final ForgeConfigSpec.DoubleValue sirenMaxHealth;
    public final ForgeConfigSpec.BooleanValue sirenShader;
    public final ForgeConfigSpec.IntValue sirenMaxSingTime;
    public final ForgeConfigSpec.IntValue sirenTimeBetweenSongs;
    public final ForgeConfigSpec.IntValue generateSirenChance;
    public final ForgeConfigSpec.IntValue hippocampusSpawnChance;
    public final ForgeConfigSpec.IntValue cockatriceChickenSearchLength;
    public final ForgeConfigSpec.IntValue cockatriceEggChance;
    public final ForgeConfigSpec.DoubleValue cockatriceMaxHealth;
    public final ForgeConfigSpec.BooleanValue chickensLayRottenEggs;
    public final ForgeConfigSpec.BooleanValue spawnCockatrices;
    public final ForgeConfigSpec.IntValue cockatriceSpawnRate;
    public final ForgeConfigSpec.BooleanValue spawnTrolls;
    public final ForgeConfigSpec.IntValue trollSpawnRate;
    public final ForgeConfigSpec.BooleanValue trollsDropWeapon;
    public final ForgeConfigSpec.DoubleValue trollMaxHealth;
    public final ForgeConfigSpec.DoubleValue trollAttackStrength;
    public final ForgeConfigSpec.BooleanValue villagersFearDragons;
    public final ForgeConfigSpec.BooleanValue animalsFearDragons;
    public final ForgeConfigSpec.BooleanValue spawnAmphitheres;
    public final ForgeConfigSpec.IntValue amphithereSpawnRate;
    public final ForgeConfigSpec.IntValue amphithereVillagerSearchLength ;
    public final ForgeConfigSpec.IntValue amphithereTameTime;
    public final ForgeConfigSpec.DoubleValue amphithereFlightSpeed;
    public final ForgeConfigSpec.DoubleValue amphithereMaxHealth;
    public final ForgeConfigSpec.DoubleValue amphithereAttackStrength;
    public final ForgeConfigSpec.DoubleValue dragonsteelBaseDamage;
    public final ForgeConfigSpec.IntValue dragonsteelBaseArmor;
    public final ForgeConfigSpec.DoubleValue dragonsteelBaseArmorToughness;
    public final ForgeConfigSpec.IntValue dragonsteelBaseDurability;
    public final ForgeConfigSpec.IntValue dragonsteelBaseDurabilityEquipment;
    public final ForgeConfigSpec.BooleanValue dragonMovedWronglyFix; // FIXME :: Unused
    public final ForgeConfigSpec.BooleanValue weezerTinkers; // FIXME :: Unused
    public final ForgeConfigSpec.DoubleValue dragonBlockBreakingDropChance;
    public final ForgeConfigSpec.BooleanValue completeDragonPathfinding; // FIXME :: Unused
    public final ForgeConfigSpec.BooleanValue generateMausoleums;
    public final ForgeConfigSpec.BooleanValue spawnLiches;
    public final ForgeConfigSpec.IntValue lichSpawnRate;
    public final ForgeConfigSpec.IntValue lichSpawnChance;
    public final ForgeConfigSpec.DoubleValue hydraMaxHealth;
    public final ForgeConfigSpec.IntValue generateHydraChance;
    public final ForgeConfigSpec.BooleanValue explosiveDragonBreath;
    public final ForgeConfigSpec.DoubleValue weezerTinkersDisarmChance; // FIXME :: Unused
    public final ForgeConfigSpec.BooleanValue chunkLoadSummonCrystal;
    public ForgeConfigSpec.IntValue dangerousWorldGenDistanceLimit;
    public ForgeConfigSpec.IntValue dangerousWorldGenSeparationLimit;
    public final ForgeConfigSpec.DoubleValue dragonFlightSpeedMod;
    public final ForgeConfigSpec.DoubleValue hippogryphFlightSpeedMod;
    public final ForgeConfigSpec.DoubleValue hippocampusSwimSpeedMod;
    public final ForgeConfigSpec.DoubleValue ghostMaxHealth;
    public final ForgeConfigSpec.DoubleValue ghostAttackStrength;
    public final ForgeConfigSpec.BooleanValue generateGraveyards;
    public final ForgeConfigSpec.BooleanValue ghostSpawnFromPlayerDeaths;
    public ForgeConfigSpec.IntValue dragonPathfindingThreads;
    public ForgeConfigSpec.IntValue maxDragonPathingNodes;
    public ForgeConfigSpec.BooleanValue pathfindingDebug;
    public final ForgeConfigSpec.BooleanValue dragonWeaponFireAbility;
    public final ForgeConfigSpec.BooleanValue dragonWeaponIceAbility;
    public final ForgeConfigSpec.BooleanValue dragonWeaponLightningAbility;
    public ForgeConfigSpec.IntValue villagerHouseWeight;
    public ForgeConfigSpec.BooleanValue allowAttributeOverriding;

    public ServerConfig(final ForgeConfigSpec.Builder builder) {
        builder.push("Generation");
        builder.push("Dragon");
        this.generateDragonSkeletons = buildBoolean(builder, "Generate Dragon Skeletons", "all", true, "Whether to generate dragon skeletons or not");
        this.generateDragonSkeletonChance = buildInt(builder, "Generate Dragon Skeleton Chance", "all", 300, 1, 10000, "1 out of this number chance per chunk for generation");
        this.generateDragonDenChance = buildInt(builder, "Generate Dragon Cave Chance", "all", 180, 1, 10000, "1 out of this number chance per chunk for generation");
        this.generateDragonRoostChance = buildInt(builder, "Generate Dragon Roost Chance", "all", 360, 1, 10000, "1 out of this number chance per chunk for generation");
        this.dragonDenGoldAmount = buildInt(builder, "Dragon Den Gold Amount", "all", 4, 1, 10000, "1 out of this number chance per block that gold will generate in dragon lairs.");
        this.oreToStoneRatioForDragonCaves = buildInt(builder, "Dragon Cave Ore Ratio", "all", 45, 1, 10000, "Ratio of Stone(this number) to Ores in Dragon Caves");
        builder.pop();
        builder.push("Structures-Features");
        this.dangerousWorldGenDistanceLimit = buildInt(builder, "Dangerous World Gen Dist From Spawn", "all", 800, 1, 10000, "How far away dangerous structures(dragon roosts, cyclops caves, etc.) must be from spawn.");
        this.dangerousWorldGenSeparationLimit = buildInt(builder, "Dangerous World Gen Dist Seperation", "all", 300, 1, 10000, "How far away dangerous structures(dragon roosts, cyclops caves, etc.) must be from the last generated structure.");

        this.spawnGlaciers = buildBoolean(builder, "Generate Glaciers", "all", true, "Whether to generate glacier biomes or not");
        this.glacierSpawnChance = buildInt(builder, "Glacier Spawn Weight", "all", 4, 1, 10000, "Glacier Spawn Weight. Higher number = more common");

        this.generateMausoleums = buildBoolean(builder, "Generate Mausoleums", "all", true, "True if mausoleums are allowed to generate");

        this.generateGraveyards = buildBoolean(builder, "Generate Graveyards", "all", true, "Whether to generate graveyards or not");

        this.generateGorgonTemple = buildBoolean(builder, "Generate Gorgon Temple", "all", true, "True if gorgon temples are allowed to spawn");

        builder.pop();
        builder.pop();
        builder.push("Dragons");
        builder.push("Griefing");
        this.dragonGriefing = buildInt(builder, "Dragon Griefing", "all", 0, 0, 2, "Dragon griefing - 2 is no griefing, 1 is breaking weak blocks, 0 is default. This value is also affected by minecrafts mob griefing rule.");
        this.tamedDragonGriefing = buildBoolean(builder, "Tamed Dragon Griefing", "all", true, "True if tamed dragons can follow the griefing rules.");
        this.dragonBlockBreakingDropChance = buildDouble(builder, "Dragon Block Breaking Drop Chance", "all", 0.1F, 0.0F, 1.0F, "The percentage chance for a block to drop as an item when a dragon breaks it.");
        builder.pop();
        builder.push("Attributes");
        this.dragonEggTime = buildInt(builder, "Dragon Egg Hatch Time", "all", 7200, 1, Integer.MAX_VALUE, "How long it takes(in ticks) for a dragon egg to hatch");
        this.dragonFlapNoiseDistance = buildInt(builder, "Dragon Flap Noise Distance", "all", 4, 0, 10000, "Dragon Flap Noise Distance - Larger number, further away you can hear it");
        this.dragonFluteDistance = buildInt(builder, "Dragon Flute Distance", "all", 4, 0, 10000, "Dragon Flute Distance - how many chunks away is the dragon flute effective?");
        this.dragonHealth = buildDouble(builder, "Dragon Health", "all", 500, 1, 100000, "Max dragon health. Health is scaled to this");
        this.dragonAttackDamage = buildInt(builder, "Dragon Attack Damage", "all", 17, 1, 10000, "Max dragon attack damage. Attack Damage is scaled to this");
        this.dragonAttackDamageFire = buildDouble(builder, "Dragon Attack Damage(Fire breath)", "all", 2.0F, 0, 10000, "Damage dealt from a successful fire breath attack. Attack Damage is scaled to by age, so a stage 5 dragon will deal 5x as much as this number");
        this.dragonAttackDamageIce = buildDouble(builder, "Dragon Attack Damage(Ice breath)", "all", 2.5F, 0, 10000, "Damage dealt from a successful ice breath attack. Attack Damage is scaled to by age, so a stage 5 dragon will deal 5x as much as this number");
        this.dragonAttackDamageLightning = buildDouble(builder, "Dragon Attack Damage(Lightning breath)", "all", 3.5F, 0, 10000, "Damage dealt from a successful lightning breath attack. Attack Damage is scaled to by age, so a stage 5 dragon will deal 5x as much as this number");
        this.dragonFlightSpeedMod = buildDouble(builder, "Dragon Flight Speed Modifier", "all", 1F, 0.0F, 2.0F, "Change this to slow down or speed up dragon or amphithere flight.");
        this.dragonMovedWronglyFix = buildBoolean(builder, "Dragon Moved Wrongly Error Fix", "all", false, "Enable this if your server is being bombarded with moved wrongly or moved too fast console messages. REQUIRES RESTART!");
        builder.pop();
        builder.push("Behaviour");
        this.maxDragonFlight = buildInt(builder, "Max Dragon Flight Height", "all", 256, 100, Integer.MAX_VALUE, "How high dragons can fly, in Y height.");
        this.dragonGoldSearchLength = buildInt(builder, "Dragon Gold Search Length", "all", 30, 0, 10000, "How far away dragons will detect gold blocks being destroyed or chests being opened");
        this.canDragonsHealFromBiting = buildBoolean(builder, "Dragon Bite Heal", "all", true, "Whether the bite attack from a dragon heals them or not.");
        this.canDragonsDespawn = buildBoolean(builder, "Dragons Despawn", "all", true, "True if dragons can despawn. Note that if this is false there may be SERIOUS lag issues.");
        this.doDragonsSleep = buildBoolean(builder, "Tamed Dragons Sleep", "all", true, "True if tamed dragons go to sleep at night.");
        this.dragonDigWhenStuck = buildBoolean(builder, "Dragons Dig When Stuck", "all", true, "True if dragons can break blocks if they get stuck. Turn this off if your dragons randomly explode.");
        this.dragonDropSkull = buildBoolean(builder, "Dragons Drop Skull", "all", true, "True if dragons can drop their skull on death.");
        this.dragonDropHeart = buildBoolean(builder, "Dragons Drop Heart", "all", true, "True if dragons can drop their heart on death.");
        this.dragonDropBlood = buildBoolean(builder, "Dragons Drop Blood", "all", true, "True if dragons can drop their blood on death.");
        this.explosiveDragonBreath = buildBoolean(builder, "Explosive Dragon Breath", "all", false, "True if dragons fire/ice charges create secondary explosions that launch blocks everywhere. Turn this to true if you like unfair explosions. Or lag.");
        this.dragonTargetSearchLength = buildInt(builder, "Dragon Target Search Length", "all", 128, 1, 10000, "How many blocks away can dragons spot potential prey. Note that increasing this could cause lag.");
        this.dragonWanderFromHomeDistance = buildInt(builder, "Dragon Wander From Home Distance", "all", 40, 1, 10000, "How many blocks away can dragons wander from their defined \"home\" position.");
        this.dragonHungerTickRate = buildInt(builder, "Dragon Hunger Tick Rate", "all", 3000, 1, 10000, "Every interval of this number in ticks, dragon hunger decreases.");
        this.dragonBreakBlockCooldown = buildInt(builder, "Dragon Block Break Cooldown", "all", 5, 0, 10000, "Every interval of this number in ticks, dragon allowed to break blocks.");
        this.villagersFearDragons = buildBoolean(builder, "Villagers Fear Dragons", "all", true, "True if villagers should run away and hide from dragons and other hostile Ice and Fire mobs.");
        this.animalsFearDragons = buildBoolean(builder, "Animals Fear Dragons", "all", true, "True if animals should run away and hide from dragons and other hostile Ice and Fire mobs.");
        this.completeDragonPathfinding = buildBoolean(builder, "Intelligent Dragon Pathfinding", "all", false, "A more intelligent dragon pathfinding system, but is also laggier. Turn this on if you think dragons are too stupid.");
        builder.pop();
        builder.pop();
        builder.push("Mobs");

        builder.push("Pixies");
        this.spawnPixiesChance = buildInt(builder, "Spawn Pixies Chance", "all", 60, 1, 10000, "1 out of this number chance per chunk for generation");
        this.pixieVillageSize = buildInt(builder, "Pixie Village Size", "all", 5, 1, 10000, "size of pixie villages");
        this.pixiesStealItems = buildBoolean(builder, "Pixies Steal Items", "all", true, "True if pixies are allowed to steal from players");
        builder.pop();
        builder.push("Cyclops");
        this.spawnCyclopsCaveChance = buildInt(builder, "Spawn Cyclops Cave Chance", "all", 100, 1, 10000, "1 out of this number chance per chunk for generation");
        this.spawnWanderingCyclopsChance = buildInt(builder, "Spawn Wandering Cyclops Chance", "all", 100, 1, 10000, "1 out of this number chance per chunk for generation");
        this.cyclopsMaxHealth = buildDouble(builder, "Cyclops Max Health", "all", 150, 1, 10000, "Maximum cyclops health");
        this.cyclopesSheepSearchLength = buildInt(builder, "Cyclopes Sheep Search Length", "all", 17, 1, 10000, "How many blocks away can cyclopes detect sheep. Note that increasing this could cause lag.");
        this.cyclopsAttackStrength = buildDouble(builder, "Cyclops Attack Strength", "all", 15, 1, 10000, "Cyclops attack strength");
        this.cyclopsBiteStrength = buildDouble(builder, "Cyclops Bite Strength", "all", 40, 1, 10000, "Amount of damage done with cyclops bite attack.");
        this.cyclopsGriefing = buildBoolean(builder, "Cyclops Griefing", "all", true, "Whether or not cyclops can break logs or leaves in their way");
        builder.pop();
        builder.push("Sirens");
        this.sirenMaxHealth = buildDouble(builder, "Siren Max Health", "all", 50, 1, 10000, "Maximum siren health");
        this.sirenShader = buildBoolean(builder, "Use Siren Shader", "all", true, "True to make the screen pink when sirens attract players");
        this.generateSirenChance = buildInt(builder, "Spawn Sirens Chance", "all", 400, 1, 10000, "1 out of this number chance per chunk for generation");
        this.sirenMaxSingTime = buildInt(builder, "Siren Max Sing Time", "all", 12000, 100, 24000, "how long(in ticks) can a siren use its sing effect on a player, without a cooldown.");
        this.sirenTimeBetweenSongs = buildInt(builder, "Siren Time Between Songs", "all", 2000, 100, 24000, "how long(in ticks) a siren has to wait after failing to lure in a player");
        builder.pop();
        builder.push("Cockatrice");
        this.cockatriceMaxHealth = buildDouble(builder, "Cockatrice Health", "all", 40, 1, 10000, "Maximum cockatrice health");
        this.cockatriceChickenSearchLength = buildInt(builder, "Cockatrice chicken Search Length", "all", 32, 1, 10000, "How many blocks away can cockatrices detect chickens. Note that increasing this could cause lag.");
        this.cockatriceEggChance = buildInt(builder, "Cockatrice chicken Search Length", "all", 30, 1, Integer.MAX_VALUE, "1 out of this number chance per 6000 ticks for a chicken to lay a cockatrice egg.");
        this.chickensLayRottenEggs = buildBoolean(builder, "Chickens Lay Rotten Eggs", "all", true, "True if chickens lay rotten eggs.");
        this.spawnCockatrices = buildBoolean(builder, "Spawn Cockatrices", "all", true, "True if cockatrices are allowed to spawn");
        this.cockatriceSpawnRate = buildInt(builder, "Cockatrice Spawn Weight", "all", 4, 1, 10000, "Cockatrice spawn weight. Lower = lower chance to spawn");
        builder.pop();
        builder.push("Trolls");
        this.spawnTrolls = buildBoolean(builder, "Spawn Trolls", "all", true, "True if trolls are allowed to spawn");
        this.trollsDropWeapon = buildBoolean(builder, "Trolls Drop Weapon", "all", true, "True if trolls are allowed to drop their weapon on death.");
        this.trollSpawnRate = buildInt(builder, "Troll Spawn Weight", "all", 40, 1, 10000, "Troll spawn weight. Lower = lower chance to spawn");
        this.trollMaxHealth = buildDouble(builder, "Troll Max Health", "all", 50, 1, 10000, "Maximum troll health");
        this.trollAttackStrength = buildDouble(builder, "Troll Attack Strength", "all", 10, 1, 10000, "Troll attack strength");
        builder.pop();
        builder.push("Amphitheres");
        this.spawnAmphitheres = buildBoolean(builder, "Spawn Amphitheres", "all", true, "True if amphitheres are allowed to spawn");
        this.amphithereSpawnRate = buildInt(builder, "Amphithere Spawn Weight", "all", 50, 1, 10000, "Amphithere spawn weight. Lower = lower chance to spawn");
        this.amphithereVillagerSearchLength = buildInt(builder, "Amphithere Villager Search Length", "all", 64, 1, 10000, "How many blocks away can ampitheres detect villagers being hurt. Note that increasing this could cause lag.");
        this.amphithereTameTime = buildInt(builder, "Amphithere Tame Time", "all", 400, 1, 10000, "How many ticks it takes while riding an untamed amphithere to tame it.");
        this.amphithereFlightSpeed = buildDouble(builder, "Amphithere Flight Speed", "all", 1.75F, 0.0F, 3.0F, "How fast amphitheres fly.");
        this.amphithereMaxHealth = buildDouble(builder, "Amphithere Max Health", "all", 50, 1, 10000, "Maximum amphithere health");
        this.amphithereAttackStrength = buildDouble(builder, "Amphithere Attack Strength", "all", 7, 1, 10000, "Amphithere attack strength");
        builder.pop();
        builder.push("Hippocampus");
        this.hippocampusSpawnChance = buildInt(builder, "Spawn Hippocampus Chance", "all", 40, 1, 10000, "1 out of this number chance per chunk for generation");
        this.hippocampusSwimSpeedMod = buildDouble(builder, "Hippocampus Swim Speed Modifier", "all", 1F, 0.0F, 2.0F, "Change this to slow down or speed up hippocampus swimming.");
        builder.pop();
        builder.push("Hippogryph");
        this.spawnHippogryphs = buildBoolean(builder, "Spawn Hippogryphs", "all", true, "True if hippogryphs are allowed to spawn");
        this.hippogryphSpawnRate = buildInt(builder, "Hippogryph Spawn Weight", "all", 2, 1, 10000, "Hippogryph spawn weight. Lower = lower chance to spawn.");
        this.hippogryphFlightSpeedMod = buildDouble(builder, "Hippogryph Flight Speed Modifier", "all", 1F, 0.0F, 2.0F, "Change this to slow down or speed up hippogryph flight.");
        builder.pop();
        builder.push("Gorgons");
        this.gorgonMaxHealth = buildDouble(builder, "Gorgon Max Health", "all", 100, 1, 10000, "Maximum gorgon health");
        builder.pop();
        builder.push("Others");
        this.spawnLiches = buildBoolean(builder, "Spawn Liches", "all", true, "True if dread liches are allowed to spawn");
        this.lichSpawnRate = buildInt(builder, "Lich Spawn Weight", "all", 2, 1, 10000, "Dread Lich spawn weight. Lower = lower chance to spawn");
        this.lichSpawnChance = buildInt(builder, "Lich Spawn Chance", "all", 30, 1, 10000, "Dread Lich spawn chance. Lower = higher chance to spawn");

        this.hydraMaxHealth = buildDouble(builder, "Hydra Max Health", "all", 250, 1, 10000, "Maximum hydra health");
        this.generateHydraChance = buildInt(builder, "Hydra Caves Gen Chance", "all", 60, 1, 10000, "One out of this number chance per chunk to generate a hydra cave.");

        this.ghostMaxHealth = buildDouble(builder, "Ghost Max Health", "all", 30F, 1.0F, 10000.0F, "Maximum ghost health.");
        this.ghostAttackStrength = buildDouble(builder, "Ghost Attack Strength", "all", 3F, 0.0F, 10000.0F, "Maximum ghost attack strength.");
        this.ghostSpawnFromPlayerDeaths = buildBoolean(builder, "Ghost Spawn from PvP deaths", "all", true, "True if ghosts can rarely spawn from brutal PvP deaths.");
        this.villagerHouseWeight = buildInt(builder, "Villager Scribe House Weight", "all", 5, 0, 10000, "Villager Scribe House generation weight. Lower = lower chance to spawn");

        this.allowAttributeOverriding = buildBoolean(builder, "Allow Attribute Overriding", "all", true, "Allows attributes for mobs to be overridden via the config file. One might want to disable this if other mods are enabled that change mob attributes e.g armor, health etc...");
        builder.pop();
        builder.pop();
        builder.push("Items");
        this.dragonsteelBaseDamage = buildDouble(builder, "Dragonsteel Sword Base Attack Strength", "all", 25, 5, Integer.MAX_VALUE, "Default attack strength of a dragonsteel sword.");
        this.dragonsteelBaseArmor = buildInt(builder, "Dragonsteel Base Armor", "all", 12, 7, Integer.MAX_VALUE, "Default armor value of dragonsteel chestplate.");
        this.dragonsteelBaseArmorToughness = buildDouble(builder, "Dragonsteel Base Armor Toughness", "all", 6, 0, Double.MAX_VALUE, "Default armor toughness value of dragonsteel.");
        this.dragonsteelBaseDurability = buildInt(builder, "Dragonsteel Base Durability", "all", 8000, 1, Integer.MAX_VALUE, "Default durability value of dragonsteel tools.");
        this.dragonsteelBaseDurabilityEquipment = buildInt(builder, "Dragonsteel Base Durability Equipment", "all", 8000, 1, Integer.MAX_VALUE, "Default durability value of dragonsteel equipment.");
        this.weezerTinkers = buildBoolean(builder, "Weezer", "all", true, "Disable this to remove easter egg with tinkers installed.");
        this.weezerTinkersDisarmChance = buildDouble(builder, "Easter Egg Tinkers Tool Disarm chance", "all", 0.2F, 0F, 1F, "Percentage of critical strike that will disarm with easter egg tinkers material.");
        this.chunkLoadSummonCrystal = buildBoolean(builder, "Chunk Load Summon Crystal", "all", true, "True if the summon crystal can load chunks to find dragons.");
        this.dragonWeaponFireAbility = buildBoolean(builder, "Dragon Bone Fire Abilities", "all", true, "True if the dragon bone fire sword ignites attackers.");
        this.dragonWeaponIceAbility = buildBoolean(builder, "Dragon Bone Ice Abilities", "all", true, "True if the dragon bone ice sword freezes attackers.");
        this.dragonWeaponLightningAbility = buildBoolean(builder, "Dragon Bone Lightning Abilities", "all", true, "True if the dragon bone lightning sword strikes attackers.");
        builder.pop();
        builder.push("Pathfinding");
        this.dragonPathfindingThreads = buildInt(builder, "Dragon Pathfinding Threads", "all", 3, 1, Integer.MAX_VALUE, "Maximum threads to use for dragon/myrmex pathfinding. Increase this number if pathing is slow and you have many cores.");
        this.maxDragonPathingNodes = buildInt(builder, "Dragon Max Pathfinding Nodes", "all", 5000, 1, Integer.MAX_VALUE, "Maximum nodes for dragons/myrmex to path too. Decrease this is dragon pathfinding is super slow or intensive.");
        this.pathfindingDebug = buildBoolean(builder, "Debug Pathfinding Mode", "all", false, "Enables the option to draw the pathfinding nodes when enabled (use a stick on an entity)");
    }

    private static ForgeConfigSpec.BooleanValue buildBoolean(ForgeConfigSpec.Builder builder, String name, String catagory, boolean defaultValue, String comment){
        return builder.comment(comment).translation(name).define(name, defaultValue);
    }

    private static ForgeConfigSpec.IntValue buildInt(ForgeConfigSpec.Builder builder, String name, String catagory, int defaultValue, int min, int max, String comment){
        return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
    }

    private static ForgeConfigSpec.DoubleValue buildDouble(ForgeConfigSpec.Builder builder, String name, String catagory, double defaultValue, double min, double max, String comment){
        return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
    }
}
