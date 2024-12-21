package com.github.alexthe666.iceandfire.client;


import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.block.IafBlockRegistry;
import com.github.alexthe666.iceandfire.client.gui.IafGuiRegistry;
import com.github.alexthe666.iceandfire.client.model.*;
import com.github.alexthe666.iceandfire.client.model.util.*;
import com.github.alexthe666.iceandfire.client.render.entity.*;
import com.github.alexthe666.iceandfire.client.render.tile.*;
import com.github.alexthe666.iceandfire.entity.IafEntityRegistry;
import com.github.alexthe666.iceandfire.entity.tile.IafTileEntityRegistry;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterShadersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.io.IOException;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD, modid = IceAndFire.MODID)
public class IafClientSetup {
   
    public static void clientInit() {
        EntityRenderers.register(IafEntityRegistry.HIPPOGRYPH_EGG.get(), ThrownItemRenderer::new);
        EntityRenderers.register(IafEntityRegistry.HIPPOGRYPH.get(), RenderHippogryph::new);
        EntityRenderers.register(IafEntityRegistry.PIXIE.get(), RenderPixie::new);
        EntityRenderers.register(IafEntityRegistry.SIREN.get(), RenderSiren::new);
        EntityRenderers.register(IafEntityRegistry.HIPPOCAMPUS.get(), RenderHippocampus::new);
        EntityRenderers.register(IafEntityRegistry.AMPHITHERE.get(), RenderAmphithere::new);
        EntityRenderers.register(IafEntityRegistry.AMPHITHERE_ARROW.get(), RenderAmphithereArrow::new);
        EntityRenderers.register(IafEntityRegistry.PIXIE_CHARGE.get(), RenderNothing::new);
        EntityRenderers.register(IafEntityRegistry.SLOW_MULTIPART.get(), RenderNothing::new);
        
        BlockEntityRenderers.register(IafTileEntityRegistry.PIXIE_HOUSE.get(), RenderPixieHouse::new);
        BlockEntityRenderers.register(IafTileEntityRegistry.PIXIE_JAR.get(), RenderJar::new);

    }

    @SubscribeEvent
    public static void setupShaders(RegisterShadersEvent event) throws IOException {
        
    }

    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            IafGuiRegistry.register();


        ItemBlockRenderTypes.setRenderLayer(IafBlockRegistry.GOLD_PILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(IafBlockRegistry.SILVER_PILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(IafBlockRegistry.JAR_EMPTY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(IafBlockRegistry.JAR_PIXIE_0.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(IafBlockRegistry.JAR_PIXIE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(IafBlockRegistry.JAR_PIXIE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(IafBlockRegistry.JAR_PIXIE_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(IafBlockRegistry.JAR_PIXIE_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(IafBlockRegistry.PIXIE_HOUSE_MUSHROOM_BROWN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(IafBlockRegistry.PIXIE_HOUSE_MUSHROOM_RED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(IafBlockRegistry.PIXIE_HOUSE_OAK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(IafBlockRegistry.PIXIE_HOUSE_BIRCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(IafBlockRegistry.PIXIE_HOUSE_SPRUCE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(IafBlockRegistry.PIXIE_HOUSE_DARK_OAK.get(), RenderType.cutout());
        });
    }

}
