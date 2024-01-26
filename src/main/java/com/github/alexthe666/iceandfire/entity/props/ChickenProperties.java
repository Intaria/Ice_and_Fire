package com.github.alexthe666.iceandfire.entity.props;

import com.github.alexthe666.citadel.server.entity.CitadelEntityData;
import com.github.alexthe666.iceandfire.IafConfig;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;

import java.util.Random;

public class ChickenProperties {
    private static final String CHICKEN_DATA = "TimeUntilNextEggIaf";
    private static final Random rand = new Random();

    private static int createDefaultTime() {
        return rand.nextInt(6000) + 6000;
    }

    private static CompoundTag createDefaultData(CompoundTag nbt) {
        nbt.putInt(CHICKEN_DATA, createDefaultTime());
        return nbt;
    }

    public static int getTimeRemaining(LivingEntity entity) {
        CompoundTag nbt = CitadelEntityData.getOrCreateCitadelTag(entity);
        if (!nbt.contains(CHICKEN_DATA)) {
            createDefaultData(nbt);
            CitadelEntityData.setCitadelTag(entity, nbt);
        }
        return nbt.getInt(CHICKEN_DATA);
    }

    public static void setTimeRemaining(LivingEntity entity, int time) {
        CompoundTag nbt = CitadelEntityData.getOrCreateCitadelTag(entity);
        nbt.putInt(CHICKEN_DATA, time);
        CitadelEntityData.setCitadelTag(entity, nbt);
        // No need to message clients since this can stay server only
    }
}
