package com.github.alexthe666.iceandfire.block;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.item.BlockItemWithRender;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.github.alexthe666.iceandfire.misc.IafSoundRegistry;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = IceAndFire.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class IafBlockRegistry {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IceAndFire.MODID);

    public static final SoundType SOUND_TYPE_GOLD = new SoundType(1.0F, 1.0F, IafSoundRegistry.GOLD_PILE_BREAK, IafSoundRegistry.GOLD_PILE_STEP, IafSoundRegistry.GOLD_PILE_BREAK, IafSoundRegistry.GOLD_PILE_STEP, IafSoundRegistry.GOLD_PILE_STEP);

    public static final RegistryObject<Block> GOLD_PILE = register("gold_pile", BlockGoldPile::new);
    public static final RegistryObject<Block> SILVER_PILE = register("silver_pile", BlockGoldPile::new);
    public static final RegistryObject<Block> COPPER_PILE = register("copper_pile", BlockGoldPile::new);
    
    public static final RegistryObject<Block> PIXIE_HOUSE_MUSHROOM_RED = registerWithRender(BlockPixieHouse.name("mushroom_red"), BlockPixieHouse::new);
    public static final RegistryObject<Block> PIXIE_HOUSE_MUSHROOM_BROWN = registerWithRender(BlockPixieHouse.name("mushroom_brown"), BlockPixieHouse::new);
    public static final RegistryObject<Block> PIXIE_HOUSE_OAK = registerWithRender(BlockPixieHouse.name("oak"), BlockPixieHouse::new);
    public static final RegistryObject<Block> PIXIE_HOUSE_BIRCH = registerWithRender(BlockPixieHouse.name("birch"), BlockPixieHouse::new);
    public static final RegistryObject<Block> PIXIE_HOUSE_SPRUCE = registerWithRender(BlockPixieHouse.name("spruce"), BlockPixieHouse::new);
    public static final RegistryObject<Block> PIXIE_HOUSE_DARK_OAK = registerWithRender(BlockPixieHouse.name("dark_oak"), BlockPixieHouse::new);
    public static final RegistryObject<Block> JAR_EMPTY = register(BlockJar.name(-1), () -> new BlockJar(-1));
    public static final RegistryObject<Block> JAR_PIXIE_0 = register(BlockJar.name(0), () -> new BlockJar(0));
    public static final RegistryObject<Block> JAR_PIXIE_1 = register(BlockJar.name(1), () -> new BlockJar(1));
    public static final RegistryObject<Block> JAR_PIXIE_2 = register(BlockJar.name(2), () -> new BlockJar(2));
    public static final RegistryObject<Block> JAR_PIXIE_3 = register(BlockJar.name(3), () -> new BlockJar(3));
    public static final RegistryObject<Block> JAR_PIXIE_4 = register(BlockJar.name(4), () -> new BlockJar(4));
    
    public static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = BLOCKS.register(name, block);
        IafItemRegistry.registerItem(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(IceAndFire.TAB_BLOCKS)), false);
        return ret;
    }

    public static <T extends TorchBlock> RegistryObject<T> registerWallBlock(String name, Supplier<T> block) {
        RegistryObject<T> ret = BLOCKS.register(name, block);
        IafItemRegistry.registerItem(name, () -> new StandingAndWallBlockItem(ret.get(), ((IWallBlock) ret.get()).wallBlock(), new Item.Properties().tab(IceAndFire.TAB_BLOCKS)), false);
        return ret;
    }

    public static <T extends Block> RegistryObject<T> registerWithRender(String name, Supplier<T> block) {
        RegistryObject<T> ret = BLOCKS.register(name, block);
        IafItemRegistry.registerItem(name, () -> new BlockItemWithRender(ret.get(), new Item.Properties().tab(IceAndFire.TAB_BLOCKS)), false);
        return ret;
    }

    public static <T extends WallTorchBlock> RegistryObject<T> registerWallTorch(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

}
