package com.github.alexthe666.iceandfire.entity.tile;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.block.IafBlockRegistry;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class IafTileEntityRegistry {

    public static final DeferredRegister<BlockEntityType<?>> TYPES = DeferredRegister
        .create(ForgeRegistries.BLOCK_ENTITY_TYPES, IceAndFire.MODID);

    //@formatter:off
    public static final RegistryObject<BlockEntityType<TileEntityPixieHouse>> PIXIE_HOUSE = registerTileEntity(() -> BlockEntityType.Builder.of(TileEntityPixieHouse::new, IafBlockRegistry.PIXIE_HOUSE_MUSHROOM_RED.get(), IafBlockRegistry.PIXIE_HOUSE_MUSHROOM_BROWN.get(), IafBlockRegistry.PIXIE_HOUSE_OAK.get(), IafBlockRegistry.PIXIE_HOUSE_BIRCH.get(), IafBlockRegistry.PIXIE_HOUSE_BIRCH.get(), IafBlockRegistry.PIXIE_HOUSE_SPRUCE.get(), IafBlockRegistry.PIXIE_HOUSE_DARK_OAK.get()), "pixie_house");
    public static final RegistryObject<BlockEntityType<TileEntityJar>> PIXIE_JAR = registerTileEntity(() -> BlockEntityType.Builder.of(TileEntityJar::new, IafBlockRegistry.JAR_EMPTY.get(), IafBlockRegistry.JAR_PIXIE_0.get(), IafBlockRegistry.JAR_PIXIE_1.get(), IafBlockRegistry.JAR_PIXIE_2.get(), IafBlockRegistry.JAR_PIXIE_3.get(), IafBlockRegistry.JAR_PIXIE_4.get()), "pixie_jar");

    public static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> registerTileEntity(
            Supplier<BlockEntityType.Builder<T>> supplier, String entityName) {
        return TYPES.register(entityName, () -> supplier.get().build(null));
    }
}
