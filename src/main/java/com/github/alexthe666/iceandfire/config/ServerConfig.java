package com.github.alexthe666.iceandfire.config;

import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class ServerConfig {

    public final ForgeConfigSpec.IntValue dragonGriefing;
    public final ForgeConfigSpec.BooleanValue tamedDragonGriefing;
    public final ForgeConfigSpec.IntValue dragonFlapNoiseDistance;
    public final ForgeConfigSpec.IntValue maxDragonFlight;
    public final ForgeConfigSpec.BooleanValue doDragonsSleep;
    public final ForgeConfigSpec.IntValue dragonBreakBlockCooldown;
    public final ForgeConfigSpec.IntValue dragonTargetSearchLength;
    public final ForgeConfigSpec.IntValue dragonWanderFromHomeDistance;
    public final ForgeConfigSpec.IntValue dragonHungerTickRate;
    public final ForgeConfigSpec.BooleanValue spawnHippogryphs;
    public final ForgeConfigSpec.IntValue hippogryphSpawnRate;
    public final ForgeConfigSpec.IntValue spawnPixiesChance;
    public final ForgeConfigSpec.IntValue pixieVillageSize;
    public final ForgeConfigSpec.BooleanValue pixiesStealItems;
    public final ForgeConfigSpec.DoubleValue sirenMaxHealth;
    public final ForgeConfigSpec.BooleanValue sirenShader;
    public final ForgeConfigSpec.IntValue sirenMaxSingTime;
    public final ForgeConfigSpec.IntValue sirenTimeBetweenSongs;
    public final ForgeConfigSpec.IntValue generateSirenChance;
    public final ForgeConfigSpec.IntValue hippocampusSpawnChance;
    public final ForgeConfigSpec.BooleanValue spawnAmphitheres;
    public final ForgeConfigSpec.IntValue amphithereSpawnRate;
    public final ForgeConfigSpec.IntValue amphithereVillagerSearchLength ;
    public final ForgeConfigSpec.IntValue amphithereTameTime;
    public final ForgeConfigSpec.DoubleValue amphithereFlightSpeed;
    public final ForgeConfigSpec.DoubleValue amphithereMaxHealth;
    public final ForgeConfigSpec.DoubleValue amphithereAttackStrength;
    public final ForgeConfigSpec.BooleanValue weezerTinkers; // FIXME :: Unused
    public final ForgeConfigSpec.BooleanValue generateMausoleums;
    public final ForgeConfigSpec.DoubleValue weezerTinkersDisarmChance; // FIXME :: Unused
    public final ForgeConfigSpec.BooleanValue chunkLoadSummonCrystal;
    public ForgeConfigSpec.IntValue dangerousWorldGenDistanceLimit;
    public ForgeConfigSpec.IntValue dangerousWorldGenSeparationLimit;
    public final ForgeConfigSpec.DoubleValue dragonFlightSpeedMod;
    public final ForgeConfigSpec.DoubleValue hippogryphFlightSpeedMod;
    public final ForgeConfigSpec.DoubleValue hippocampusSwimSpeedMod;
    public ForgeConfigSpec.IntValue dragonPathfindingThreads;
    public ForgeConfigSpec.IntValue maxDragonPathingNodes;
    public ForgeConfigSpec.BooleanValue pathfindingDebug;
    public ForgeConfigSpec.BooleanValue allowAttributeOverriding;

    public ServerConfig(final ForgeConfigSpec.Builder builder) {
        builder.push("Generation");
        builder.push("Structures-Features");
        this.dangerousWorldGenDistanceLimit = buildInt(builder, "Dangerous World Gen Dist From Spawn", "all", 800, 1, 10000, "How far away dangerous structures(dragon roosts, cyclops caves, etc.) must be from spawn.");
        this.dangerousWorldGenSeparationLimit = buildInt(builder, "Dangerous World Gen Dist Seperation", "all", 300, 1, 10000, "How far away dangerous structures(dragon roosts, cyclops caves, etc.) must be from the last generated structure.");

        this.generateMausoleums = buildBoolean(builder, "Generate Mausoleums", "all", true, "True if mausoleums are allowed to generate");

        
        builder.pop();
        builder.pop();
        builder.push("Mobs");
        builder.push("Dragons");
        this.dragonGriefing = buildInt(builder, "Dragon Griefing", "all", 0, 0, 2, "Dragon griefing - 2 is no griefing, 1 is breaking weak blocks, 0 is default. This value is also affected by minecrafts mob griefing rule.");
        this.tamedDragonGriefing = buildBoolean(builder, "Tamed Dragon Griefing", "all", true, "True if tamed dragons can follow the griefing rules.");
        this.dragonFlapNoiseDistance = buildInt(builder, "Dragon Flap Noise Distance", "all", 4, 0, 10000, "Dragon Flap Noise Distance - Larger number, further away you can hear it");
        this.dragonFlightSpeedMod = buildDouble(builder, "Dragon Flight Speed Modifier", "all", 1F, 0.0F, 2.0F, "Change this to slow down or speed up dragon or amphithere flight.");
        this.maxDragonFlight = buildInt(builder, "Max Dragon Flight Height", "all", 256, 100, Integer.MAX_VALUE, "How high dragons can fly, in Y height.");
        this.doDragonsSleep = buildBoolean(builder, "Tamed Dragons Sleep", "all", true, "True if tamed dragons go to sleep at night.");
        this.dragonTargetSearchLength = buildInt(builder, "Dragon Target Search Length", "all", 128, 1, 10000, "How many blocks away can dragons spot potential prey. Note that increasing this could cause lag.");
        this.dragonWanderFromHomeDistance = buildInt(builder, "Dragon Wander From Home Distance", "all", 40, 1, 10000, "How many blocks away can dragons wander from their defined \"home\" position.");
        this.dragonHungerTickRate = buildInt(builder, "Dragon Hunger Tick Rate", "all", 3000, 1, 10000, "Every interval of this number in ticks, dragon hunger decreases.");
        this.dragonBreakBlockCooldown = buildInt(builder, "Dragon Block Break Cooldown", "all", 5, 0, 10000, "Every interval of this number in ticks, dragon allowed to break blocks.");
        builder.pop();

        builder.push("Pixies");
        this.spawnPixiesChance = buildInt(builder, "Spawn Pixies Chance", "all", 60, 1, 10000, "1 out of this number chance per chunk for generation");
        this.pixieVillageSize = buildInt(builder, "Pixie Village Size", "all", 5, 1, 10000, "size of pixie villages");
        this.pixiesStealItems = buildBoolean(builder, "Pixies Steal Items", "all", true, "True if pixies are allowed to steal from players");
        builder.pop();
        builder.push("Sirens");
        this.sirenMaxHealth = buildDouble(builder, "Siren Max Health", "all", 50, 1, 10000, "Maximum siren health");
        this.sirenShader = buildBoolean(builder, "Use Siren Shader", "all", true, "True to make the screen pink when sirens attract players");
        this.generateSirenChance = buildInt(builder, "Spawn Sirens Chance", "all", 400, 1, 10000, "1 out of this number chance per chunk for generation");
        this.sirenMaxSingTime = buildInt(builder, "Siren Max Sing Time", "all", 12000, 100, 24000, "how long(in ticks) can a siren use its sing effect on a player, without a cooldown.");
        this.sirenTimeBetweenSongs = buildInt(builder, "Siren Time Between Songs", "all", 2000, 100, 24000, "how long(in ticks) a siren has to wait after failing to lure in a player");
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
        builder.push("Others");
        
        this.allowAttributeOverriding = buildBoolean(builder, "Allow Attribute Overriding", "all", true, "Allows attributes for mobs to be overridden via the config file. One might want to disable this if other mods are enabled that change mob attributes e.g armor, health etc...");
        builder.pop();
        builder.pop();
        builder.push("Items");
        this.weezerTinkers = buildBoolean(builder, "Weezer", "all", true, "Disable this to remove easter egg with tinkers installed.");
        this.weezerTinkersDisarmChance = buildDouble(builder, "Easter Egg Tinkers Tool Disarm chance", "all", 0.2F, 0F, 1F, "Percentage of critical strike that will disarm with easter egg tinkers material.");
        this.chunkLoadSummonCrystal = buildBoolean(builder, "Chunk Load Summon Crystal", "all", true, "True if the summon crystal can load chunks to find dragons.");
        builder.pop();
        builder.push("Pathfinding");
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
