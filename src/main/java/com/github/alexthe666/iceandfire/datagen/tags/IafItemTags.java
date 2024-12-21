package com.github.alexthe666.iceandfire.datagen.tags;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.block.IafBlockRegistry;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.github.alexthe666.iceandfire.item.ItemMobSkull;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class IafItemTags extends ItemTagsProvider {
    private final static String STORAGE_BLOCK_PATH = Tags.Items.STORAGE_BLOCKS.location().getPath();
    private final static String INGOTS_PATH = Tags.Items.INGOTS.location().getPath();
    private final static String NUGGETS_PATH = Tags.Items.NUGGETS.location().getPath();
    private final static String GEMS = Tags.Items.GEMS.location().getPath();

    //Recipes
    public static TagKey<Item> MOB_SKULLS = createKey("mob_skulls");

    // Forge (+ Recipes)
    public static TagKey<Item> STORAGE_BLOCKS_SILVER = createForgeKey(STORAGE_BLOCK_PATH + "/silver");
    public static TagKey<Item> GEMS_SAPPHIRE = createForgeKey(GEMS + "/sapphire");
    public static TagKey<Item> INGOTS_SILVER = createForgeKey(INGOTS_PATH + "/silver");
    public static TagKey<Item> NUGGETS_COPPER = createForgeKey(NUGGETS_PATH + "/copper");
    public static TagKey<Item> NUGGETS_SILVER = createForgeKey(NUGGETS_PATH + "/silver");
    
    // Logic
    public static TagKey<Item> BREED_AMPITHERE = createKey("breed_ampithere");
    public static TagKey<Item> BREED_HIPPOCAMPUS = createKey("breed_hippocampus");
    public static TagKey<Item> BREED_HIPPOGRYPH = createKey("breed_hippogryph");
    public static TagKey<Item> HEAL_AMPITHERE = createKey("heal_ampithere");
    public static TagKey<Item> HEAL_HIPPOCAMPUS = createKey("heal_hippocampus");
    public static TagKey<Item> HEAL_PIXIE = createKey("heal_pixie");
    public static TagKey<Item> TAME_HIPPOGRYPH = createKey("tame_hippogryph");
    public static TagKey<Item> TAME_PIXIE = createKey("tame_pixie");
    public static TagKey<Item> TEMPT_HIPPOCAMPUS = createKey("tempt_hippocampus");
    public static TagKey<Item> TEMPT_HIPPOGRYPH = createKey("tempt_hippogryph");

    public IafItemTags(final DataGenerator generator, final BlockTagsProvider blockTagsProvider, @Nullable final ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, IceAndFire.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.EGGS)
                .add(IafItemRegistry.HIPPOGRYPH_EGG.get());

        tag(BREED_AMPITHERE)
                .add(Items.COOKIE);

        tag(BREED_HIPPOCAMPUS)
                .add(Items.PRISMARINE_CRYSTALS);

        tag(BREED_HIPPOGRYPH)
                .add(Items.RABBIT_STEW);

        tag(TAME_HIPPOGRYPH)
                .add(Items.RABBIT_FOOT);

        tag(HEAL_AMPITHERE)
                .add(Items.COCOA_BEANS);

        tag(HEAL_HIPPOCAMPUS)
                .add(Items.KELP);

        tag(HEAL_PIXIE)
                .add(Items.SUGAR);

        tag(TAME_PIXIE)
                .add(Items.CAKE);

        tag(TEMPT_HIPPOCAMPUS)
                .add(Items.KELP)
                .add(Items.PRISMARINE_CRYSTALS);

        tag(TEMPT_HIPPOGRYPH)
                .add(Items.RABBIT)
                .add(Items.COOKED_RABBIT);

        IafItemRegistry.ITEMS.getEntries().forEach(registryObject -> {
            Item item = registryObject.get();

            if (item instanceof ArrowItem) {
                tag(ItemTags.ARROWS).add(item);
            } else if (item instanceof SwordItem) {
                tag(Tags.Items.TOOLS_SWORDS).add(item);
            } else if (item instanceof PickaxeItem) {
                tag(Tags.Items.TOOLS_PICKAXES).add(item);
            } else if (item instanceof AxeItem) {
                tag(Tags.Items.TOOLS_AXES).add(item);
            } else if (item instanceof ShovelItem) {
                tag(Tags.Items.TOOLS_SHOVELS).add(item);
            } else if (item instanceof HoeItem) {
                tag(Tags.Items.TOOLS_HOES).add(item);
            } else if (item instanceof BowItem) {
                tag(Tags.Items.TOOLS_BOWS).add(item);
            } else if (item instanceof TridentItem) {
                tag(Tags.Items.TOOLS_TRIDENTS).add(item);
            } else if (item instanceof ArmorItem armorItem) {
                tag(Tags.Items.ARMORS).add(item);

                switch (armorItem.getSlot()) {
                    case HEAD -> tag(Tags.Items.ARMORS_HELMETS).add(item);
                    case CHEST -> tag(Tags.Items.ARMORS_CHESTPLATES).add(item);
                    case LEGS -> tag(Tags.Items.ARMORS_LEGGINGS).add(item);
                    case FEET -> tag(Tags.Items.ARMORS_BOOTS).add(item);
                }
            } else if (item instanceof ItemMobSkull) {
                tag(MOB_SKULLS).add(item);
            }

            if (item instanceof TieredItem || item instanceof BowItem || item instanceof TridentItem) {
                tag(Tags.Items.TOOLS).add(item);
            }
        });
    }

    private static TagKey<Item> createKey(final String name) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(IceAndFire.MODID, name));
    }

    private static TagKey<Item> createForgeKey(final String name) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", name));
    }
}
