package com.github.alexthe666.iceandfire.client;

import com.github.alexthe666.iceandfire.CommonProxy;
import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.client.particle.*;
import com.github.alexthe666.iceandfire.entity.EntityDragonBase;
import com.github.alexthe666.iceandfire.enums.EnumParticles;
import com.github.alexthe666.iceandfire.event.ClientEvents;
import com.github.alexthe666.iceandfire.event.PlayerRenderEvents;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = IceAndFire.MODID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {

    public static Set<UUID> currentDragonRiders = new HashSet<UUID>();
    private int previousViewType = 0;
    private int thirdPersonViewDragon = 0;
    private Entity referencedMob = null;
    private BlockEntity referencedTE = null;

    @Override
    public void init() {
        IafKeybindRegistry.init();
        MinecraftForge.EVENT_BUS.register(new PlayerRenderEvents());
        MinecraftForge.EVENT_BUS.register(new ClientEvents());
    }

    @Override
    public void postInit() {

    }

    @Override
    public void clientInit() {
        super.clientInit();
        IafClientSetup.clientInit();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void spawnDragonParticle(final EnumParticles name, double x, double y, double z, double motX, double motY, double motZ, EntityDragonBase entityDragonBase) {
        ClientLevel world = Minecraft.getInstance().level;
        if (world == null) {
            return;
        }
        net.minecraft.client.particle.Particle particle = null;
        if (name == EnumParticles.DragonFire) {
            particle = new ParticleDragonFlame(world, x, y, z, motX, motY, motZ, entityDragonBase, 0);
        } else if (name == EnumParticles.DragonIce) {
            particle = new ParticleDragonFrost(world, x, y, z, motX, motY, motZ, entityDragonBase, 0);
        }
        if (particle != null) {
            Minecraft.getInstance().particleEngine.add(particle);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void spawnParticle(final EnumParticles name, double x, double y, double z, double motX, double motY, double motZ, float size) {
        ClientLevel world = Minecraft.getInstance().level;
        if (world == null) {
            return;
        }
        net.minecraft.client.particle.Particle particle = null;
        switch (name) {
            case DragonFire:
                particle = new ParticleDragonFlame(world, x, y, z, motX, motY, motZ, size);
                break;
            case DragonIce:
                particle = new ParticleDragonFrost(world, x, y, z, motX, motY, motZ, size);
                break;
            case Blood:
                particle = new ParticleBlood(world, x, y, z);
                break;
            case If_Pixie:
                particle = new ParticlePixieDust(world, x, y, z, (float) motX, (float) motY, (float) motZ);
                break;
            case Siren_Appearance:
                particle = new ParticleSirenAppearance(world, x, y, z, (int) motX);
                break;
            case Siren_Music:
                particle = new ParticleSirenMusic(world, x, y, z, motX, motY, motZ, 1);
                break;
            default:
                break;
        }
        if (particle != null) {
            Minecraft.getInstance().particleEngine.add(particle);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public Object getFontRenderer() {
        return Minecraft.getInstance().font;
    }

    @Override
    public int getDragon3rdPersonView() {
        return thirdPersonViewDragon;
    }

    @Override
    public void setDragon3rdPersonView(int view) {
        thirdPersonViewDragon = view;
    }

    @Override
    public int getPreviousViewType() {
        return previousViewType;
    }

    @Override
    public void setPreviousViewType(int view) {
        previousViewType = view;
    }

    @Override
    public Entity getReferencedMob() {
        return referencedMob;
    }

    @Override
    public void setReferencedMob(Entity dragonBase) {
        referencedMob = dragonBase;
    }

    @Override
    public BlockEntity getRefrencedTE() {
        return referencedTE;
    }

    @Override
    public void setRefrencedTE(BlockEntity tileEntity) {
        referencedTE = tileEntity;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public Player getClientSidePlayer() {
        return Minecraft.getInstance().player;
    }
}
