package com.github.alexthe666.iceandfire;

import com.github.alexthe666.iceandfire.config.ConfigHolder;
import net.minecraftforge.fml.config.ModConfig;

public class IafConfig {
    //public static boolean logCascadingWorldGen = false;
    public static int dragonGriefing = 2;
    public static boolean tamedDragonGriefing = true;
    public static int dragonFlapNoiseDistance = 4;
    public static int maxDragonFlight = 256;
    public static boolean doDragonsSleep = true;
    public static int dragonBreakBlockCooldown = 5;
    public static int dragonTargetSearchLength = 128;
    public static int dragonWanderFromHomeDistance = 40;
    public static int dragonHungerTickRate = 3000;
    public static boolean spawnHippogryphs = true;
    public static int hippogryphSpawnRate = 2;
    public static int spawnPixiesChance = 120;
    public static int pixieVillageSize = 5;
    public static boolean pixiesStealItems = true;
    public static double sirenMaxHealth = 50D;
    public static boolean sirenShader = true;
    public static int sirenMaxSingTime = 12000;
    public static int sirenTimeBetweenSongs = 2000;
    public static int generateSirenChance = 120;
    public static int hippocampusSpawnChance = 40;
    public static boolean spawnAmphitheres = true;
    public static int amphithereSpawnRate = 50;
    public static float amphithereVillagerSearchLength = 48;
    public static int amphithereTameTime = 400;
    public static double amphithereFlightSpeed = 1.75F;
    public static double amphithereMaxHealth = 50D;
    public static double amphithereAttackStrength = 7D;
    public static boolean weezerTinkers = true;
    public static double weezerTinkersDisarmChance = 0.2F;
    public static boolean chunkLoadSummonCrystal = true;
    public static double dangerousWorldGenDistanceLimit = 1000;
    public static double dangerousWorldGenSeparationLimit = 300;
    public static double dragonFlightSpeedMod = 1F;
    public static double hippogryphFlightSpeedMod = 1F;
    public static double hippocampusSwimSpeedMod = 1F;

    public static int dragonPathfindingThreads = 3;
    public static int maxDragonPathingNodes = 5000;
    public static boolean pathfindingDebug = false;
    public static boolean allowAttributeOverriding = true;

    public static void bakeServer(final ModConfig config) {
        try {
            dragonGriefing = ConfigHolder.SERVER.dragonGriefing.get();
            tamedDragonGriefing = ConfigHolder.SERVER.tamedDragonGriefing.get();
            dragonFlapNoiseDistance = ConfigHolder.SERVER.dragonFlapNoiseDistance.get();
            maxDragonFlight = ConfigHolder.SERVER.maxDragonFlight.get();
            doDragonsSleep = ConfigHolder.SERVER.doDragonsSleep.get();
            dragonBreakBlockCooldown = ConfigHolder.SERVER.dragonBreakBlockCooldown.get();
            dragonTargetSearchLength = ConfigHolder.SERVER.dragonTargetSearchLength.get();
            dragonWanderFromHomeDistance = ConfigHolder.SERVER.dragonWanderFromHomeDistance.get();
            dragonHungerTickRate = ConfigHolder.SERVER.dragonHungerTickRate.get();
            spawnHippogryphs = ConfigHolder.SERVER.spawnHippogryphs.get();
            hippogryphSpawnRate = ConfigHolder.SERVER.hippogryphSpawnRate.get();
            spawnPixiesChance = ConfigHolder.SERVER.spawnPixiesChance.get();
            pixieVillageSize = ConfigHolder.SERVER.pixieVillageSize.get();
            pixiesStealItems = ConfigHolder.SERVER.pixiesStealItems.get();
            sirenMaxHealth = ConfigHolder.SERVER.sirenMaxHealth.get();
            sirenShader = ConfigHolder.SERVER.sirenShader.get();
            sirenMaxSingTime = ConfigHolder.SERVER.sirenMaxSingTime.get();
            sirenTimeBetweenSongs = ConfigHolder.SERVER.sirenTimeBetweenSongs.get();
            generateSirenChance = ConfigHolder.SERVER.generateSirenChance.get();
            hippocampusSpawnChance = ConfigHolder.SERVER.hippocampusSpawnChance.get();
            spawnAmphitheres = ConfigHolder.SERVER.spawnAmphitheres.get();
            amphithereSpawnRate = ConfigHolder.SERVER.amphithereSpawnRate.get();
            amphithereVillagerSearchLength = ConfigHolder.SERVER.amphithereVillagerSearchLength.get();
            amphithereTameTime = ConfigHolder.SERVER.amphithereTameTime.get();
            amphithereFlightSpeed = ConfigHolder.SERVER.amphithereFlightSpeed.get();
            amphithereMaxHealth = ConfigHolder.SERVER.amphithereMaxHealth.get();
            amphithereAttackStrength = ConfigHolder.SERVER.amphithereAttackStrength.get();
            weezerTinkers = ConfigHolder.SERVER.weezerTinkers.get();
            weezerTinkersDisarmChance = ConfigHolder.SERVER.weezerTinkersDisarmChance.get();
            chunkLoadSummonCrystal = ConfigHolder.SERVER.chunkLoadSummonCrystal.get();
            dangerousWorldGenDistanceLimit = ConfigHolder.SERVER.dangerousWorldGenDistanceLimit.get();
            dangerousWorldGenSeparationLimit = ConfigHolder.SERVER.dangerousWorldGenSeparationLimit.get();
            dragonFlightSpeedMod = ConfigHolder.SERVER.dragonFlightSpeedMod.get();
            hippogryphFlightSpeedMod = ConfigHolder.SERVER.hippogryphFlightSpeedMod.get();
            hippocampusSwimSpeedMod = ConfigHolder.SERVER.hippocampusSwimSpeedMod.get();
            dragonPathfindingThreads = ConfigHolder.SERVER.dragonPathfindingThreads.get();
            maxDragonPathingNodes = ConfigHolder.SERVER.maxDragonPathingNodes.get();
            allowAttributeOverriding = ConfigHolder.SERVER.allowAttributeOverriding.get();
            pathfindingDebug = ConfigHolder.SERVER.pathfindingDebug.get();
        } catch (Exception e) {
            IceAndFire.LOGGER.warn("An exception was caused trying to load the common config for Ice and Fire.");
            e.printStackTrace();
        }
    }

}
