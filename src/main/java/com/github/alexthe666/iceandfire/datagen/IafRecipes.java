package com.github.alexthe666.iceandfire.datagen;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.block.IafBlockRegistry;
import com.github.alexthe666.iceandfire.datagen.tags.IafItemTags;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Generates recipes without advancements
 */
public class IafRecipes extends RecipeProvider {
    public IafRecipes(final DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull final Consumer<FinishedRecipe> consumer) {
        createShaped(consumer);
        createShapeless(consumer);

        /*
        smithing(consumer, IafItemRegistry.DRAGONBONE_SWORD.get(), IafItemRegistry.FIRE_DRAGON_BLOOD.get(), IafItemRegistry.DRAGONBONE_SWORD_FIRE.get());
        smithing(consumer, IafItemRegistry.DRAGONBONE_SWORD.get(), IafItemRegistry.ICE_DRAGON_BLOOD.get(), IafItemRegistry.DRAGONBONE_SWORD_ICE.get());
        smithing(consumer, IafItemRegistry.DRAGONBONE_SWORD.get(), IafItemRegistry.LIGHTNING_DRAGON_BLOOD.get(), IafItemRegistry.DRAGONBONE_SWORD_LIGHTNING.get());
        */
    }

    private void createShaped(@NotNull final Consumer<FinishedRecipe> consumer) {
        CustomShaped.shaped(IafItemRegistry.AMPHITHERE_ARROW.get(), 4)
                .pattern("X")
                .pattern("#")
                .pattern("Y")
                .define('#', Tags.Items.RODS_WOODEN)
                .define('X', Items.FLINT)
                .define('Y', IafItemRegistry.AMPHITHERE_FEATHER.get())
                .save(consumer);

        CustomShaped.shaped(IafItemRegistry.AMPHITHERE_MACUAHUITL.get())
                .pattern("OXO")
                .pattern("FXF")
                .pattern("OSO")
                .define('X', ItemTags.PLANKS)
                .define('S', Tags.Items.RODS_WOODEN)
                .define('O', Tags.Items.OBSIDIAN)
                .define('F', IafItemRegistry.AMPHITHERE_FEATHER.get())
                .save(consumer);

        CustomShaped.shaped(IafItemRegistry.BLINDFOLD.get())
                .pattern("SLS")
                .define('L', Tags.Items.LEATHER)
                .define('S', Tags.Items.STRING)
                .save(consumer);

        // FIXME :: Currently uses `minecraft` namespace
        armorSet(consumer, Items.CHAIN,
                Items.CHAINMAIL_HELMET,
                Items.CHAINMAIL_CHESTPLATE,
                Items.CHAINMAIL_LEGGINGS,
                Items.CHAINMAIL_BOOTS
        );

        CustomShaped.shaped(IafItemRegistry.IRON_HIPPOGRYPH_ARMOR.get())
                .pattern("FDF")
                .define('F', Tags.Items.FEATHERS)
                .define('D', Items.IRON_HORSE_ARMOR)
                .save(consumer);

        CustomShaped.shaped(IafItemRegistry.GOLD_HIPPOGRYPH_ARMOR.get())
                .pattern("FDF")
                .define('F', Tags.Items.FEATHERS)
                .define('D', Items.GOLDEN_HORSE_ARMOR)
                .save(consumer);

        CustomShaped.shaped(IafItemRegistry.DIAMOND_HIPPOGRYPH_ARMOR.get())
                .pattern("FDF")
                .define('F', Tags.Items.FEATHERS)
                .define('D', Items.DIAMOND_HORSE_ARMOR)
                .save(consumer);

        CustomShaped.shaped(IafItemRegistry.EARPLUGS.get())
                .pattern("B B")
                .define('B', ItemTags.PLANKS)
                .save(consumer);

        armorSet(consumer, IafItemTags.INGOTS_SILVER,
                IafItemRegistry.SILVER_HELMET.get(),
                IafItemRegistry.SILVER_CHESTPLATE.get(),
                IafItemRegistry.SILVER_LEGGINGS.get(),
                IafItemRegistry.SILVER_BOOTS.get()
        );

        toolSet(consumer, IafItemTags.INGOTS_SILVER, Tags.Items.RODS_WOODEN,
                IafItemRegistry.SILVER_SWORD.get(),
                IafItemRegistry.SILVER_PICKAXE.get(),
                IafItemRegistry.SILVER_AXE.get(),
                IafItemRegistry.SILVER_SHOVEL.get(),
                IafItemRegistry.SILVER_HOE.get()
        );
    }

    private void createShapeless(@NotNull final Consumer<FinishedRecipe> consumer) {
        CustomShapeless.shapeless(IafItemRegistry.AMBROSIA.get())
                .requires(IafItemRegistry.PIXIE_DUST.get())
                .requires(Items.BOWL)
                .save(consumer);

        CustomShapeless.shapeless(IafBlockRegistry.COPPER_PILE.get())
                .requires(IafItemTags.NUGGETS_COPPER, 2)
                .save(consumer);

        CustomShapeless.shapeless(Items.BONE_MEAL, 5)
                .requires(IafItemTags.MOB_SKULLS)
                .save(consumer, location("skull_to_bone_meal"));

        CustomShapeless.shapeless(IafBlockRegistry.GOLD_PILE.get())
                .requires(Tags.Items.NUGGETS_GOLD, 2)
                .save(consumer);
    }

    private void smithing(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike base, final ItemLike material, final Item result) {
        // The `unlocks` doesn't really matter here since this generator doesn't generate the advancement .json
        UpgradeRecipeBuilder.smithing(Ingredient.of(base), Ingredient.of(material), result)
                .unlocks("has_" + ForgeRegistries.ITEMS.getKey(material.asItem()).getPath(), has(material))
                .save(consumer, location(ForgeRegistries.ITEMS.getKey(result).getPath()));
    }

    private void compact(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike unpacked, final ItemLike packed) {
        String packedPath = ForgeRegistries.ITEMS.getKey(packed.asItem()).getPath();
        String unpackedPath = ForgeRegistries.ITEMS.getKey(unpacked.asItem()).getPath();

        nineBlockStorageRecipes(consumer, unpacked, packed
                , locationString(unpackedPath + "_to_" + packedPath), null
                , locationString(packedPath + "_to_" + unpackedPath), null);
    }

    private void toolSet(@NotNull final Consumer<FinishedRecipe> consumer, final TagKey<Item> material, final TagKey<Item> handle, final ItemLike... items) {
        toolSet(consumer, Ingredient.of(material), Ingredient.of(handle), items);
    }

    private void toolSet(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike material, final TagKey<Item> handle, final ItemLike... items) {
        toolSet(consumer, Ingredient.of(material), Ingredient.of(handle), items);
    }

    private void toolSet(@NotNull final Consumer<FinishedRecipe> consumer, final TagKey<Item> material, final ItemLike handle, final ItemLike... items) {
        toolSet(consumer, Ingredient.of(material), Ingredient.of(handle), items);
    }

    private void toolSet(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike material, final ItemLike handle, final ItemLike... items) {
        toolSet(consumer, Ingredient.of(material), Ingredient.of(handle), items);
    }

    private void toolSet(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient material, final Ingredient handle, final ItemLike... results) {
        for (ItemLike result : results) {
            Item item = result.asItem();

            if (item instanceof SwordItem) {
                sword(consumer, material, handle, result);
            } else if (item instanceof PickaxeItem) {
                pickaxe(consumer, material, handle, result);
            } else if (item instanceof AxeItem) {
                axe(consumer, material, handle, result);
            } else if (item instanceof ShovelItem) {
                shovel(consumer, material, handle, result);
            } else if (item instanceof HoeItem) {
                hoe(consumer, material, handle, result);
            } else {
                throw new IllegalArgumentException("Result is not a valid tool: [" + result + "]");
            }
        }
    }

    private void armorSet(@NotNull final Consumer<FinishedRecipe> consumer, final TagKey<Item> tag, final ItemLike... results) {
        armorSet(consumer, Ingredient.of(tag), results);
    }

    private void armorSet(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike item, final ItemLike... results) {
        armorSet(consumer, Ingredient.of(item), results);
    }

    private void armorSet(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike... results) {
        for (ItemLike result : results) {
            if (result.asItem() instanceof ArmorItem armorItem) {
                switch (armorItem.getSlot()) {
                    case HEAD -> helmet(consumer, ingredient, result);
                    case CHEST -> chestPlate(consumer, ingredient, result);
                    case LEGS -> leggings(consumer, ingredient, result);
                    case FEET -> boots(consumer, ingredient, result);
                    default -> throw new IllegalArgumentException("Result is not a valid armor item: [" + result + "]");
                }
            } else {
                throw new IllegalArgumentException("Result is not an armor item: [" + result + "]");
            }
        }
    }

    private void helmet(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("###")
                .pattern("# #")
                .define('#', ingredient)
                .save(consumer);
    }

    private void chestPlate(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ingredient)
                .save(consumer);
    }

    private void leggings(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ingredient)
                .save(consumer);
    }

    private void boots(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("# #")
                .pattern("# #")
                .define('#', ingredient)
                .save(consumer);
    }

    private void sword(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient material, final Ingredient handle, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("M")
                .pattern("M")
                .pattern("H")
                .define('M', material)
                .define('H', handle)
                .save(consumer);
    }

    private void pickaxe(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient material, final Ingredient handle, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("MMM")
                .pattern(" H ")
                .pattern(" H ")
                .define('M', material)
                .define('H', handle)
                .save(consumer);
    }

    private void axe(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient material, final Ingredient handle, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("MM")
                .pattern("MH")
                .pattern(" H")
                .define('M', material)
                .define('H', handle)
                .save(consumer);
    }

    private void shovel(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient material, final Ingredient handle, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("M")
                .pattern("H")
                .pattern("H")
                .define('M', material)
                .define('H', handle)
                .save(consumer);
    }

    private void hoe(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient material, final Ingredient handle, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("MM")
                .pattern(" H")
                .pattern(" H")
                .define('M', material)
                .define('H', handle)
                .save(consumer);
    }

    private void dragonHead(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("   ")
                .pattern(" ##")
                .pattern("###")
                .define('#', ingredient)
                .save(consumer);
    }

    private void dragonNeck(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("   ")
                .pattern("###")
                .pattern(" ##")
                .define('#', ingredient)
                .save(consumer);
    }

    private void dragonBody(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("###")
                .pattern("###")
                .pattern("# #")
                .define('#', ingredient)
                .save(consumer);
    }

    private void dragonTail(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("   ")
                .pattern("  #")
                .pattern("## ")
                .define('#', ingredient)
                .save(consumer);
    }

    private void forgeBrick(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike brick, final TagKey<Item> scales, final ItemLike result) {
        CustomShaped.shaped(result, 4)
                .pattern("SBS")
                .pattern("BSB")
                .pattern("SBS")
                .define('S', Ingredient.of(scales))
                .define('B', brick)
                .save(consumer);
    }

    private void forgeCore(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike brick, final ItemLike heart, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("BBB")
                .pattern("BHB")
                .pattern("BBB")
                .define('H', heart)
                .define('B', brick)
                .save(consumer);
    }

    private void forgeInput(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike brick, final TagKey<Item> material, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("BIB")
                .pattern("I I")
                .pattern("BIB")
                .define('I', Ingredient.of(material))
                .define('B', brick)
                .save(consumer);
    }

    /**
     * Remove the serialization of the advancements
     */
    public void run(@NotNull final CachedOutput output) {
        Set<ResourceLocation> set = Sets.newHashSet();
        buildCraftingRecipes((finishedRecipe) -> {
            if (!set.add(finishedRecipe.getId())) {
                throw new IllegalStateException("Duplicate recipe " + finishedRecipe.getId());
            } else {
                saveRecipe(output, finishedRecipe.serializeRecipe(), this.recipePathProvider.json(finishedRecipe.getId()));
            }
        });
    }

    /**
     * Private access
     */
    private static void saveRecipe(final CachedOutput output, final JsonObject recipeJson, final Path path) {
        try {
            DataProvider.saveStable(output, recipeJson, path);
        } catch (IOException exception) {
            IceAndFire.LOGGER.error("Couldn't save recipe {}", path, exception);
        }
    }

    private static ResourceLocation location(final String path) {
        return new ResourceLocation(IceAndFire.MODID, path);
    }

    private static String locationString(final String path) {
        return IceAndFire.MODID + ":" + path;
    }

    /**
     * Remove checks regarding advancements since their implementation is unoptimized and creates lag
     */
    private static class CustomShaped extends ShapedRecipeBuilder {
        public CustomShaped(final ItemLike result, int count) {
            super(result, count);
        }

        public static CustomShaped shaped(final ItemLike result) {
            return shaped(result, 1);
        }

        public static CustomShaped shaped(final ItemLike result, int count) {
            return new CustomShaped(result, count);
        }

        @Override
        public CustomShaped pattern(@NotNull final String pattern) {
            super.pattern(pattern);
            return this;
        }

        @Override
        public CustomShaped define(@NotNull final Character symbol, @NotNull final Ingredient ingredient) {
            super.define(symbol, ingredient);
            return this;
        }

        @Override
        public void save(final Consumer<FinishedRecipe> finishedRecipe, @NotNull final ResourceLocation recipeId) {
            this.ensureValid(recipeId);
            finishedRecipe.accept(new ShapedRecipeBuilder.Result(recipeId, this.result, this.count, this.group == null ? "" : this.group, this.rows, this.key, this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + recipeId.getPath())));
        }

        private void ensureValid(final ResourceLocation id) {
            if (this.rows.isEmpty()) {
                throw new IllegalStateException("No pattern is defined for shaped recipe " + id + "!");
            } else {
                Set<Character> set = Sets.newHashSet(this.key.keySet());
                set.remove(' ');

                for (String s : this.rows) {
                    for (int i = 0; i < s.length(); ++i) {
                        char c0 = s.charAt(i);
                        if (!this.key.containsKey(c0) && c0 != ' ') {
                            throw new IllegalStateException("Pattern in recipe " + id + " uses undefined symbol '" + c0 + "'");
                        }

                        set.remove(c0);
                    }
                }

                if (!set.isEmpty()) {
                    throw new IllegalStateException("Ingredients are defined but not used in pattern for recipe " + id);
                } else if (this.rows.size() == 1 && this.rows.get(0).length() == 1) {
                    throw new IllegalStateException("Shaped recipe " + id + " only takes in a single item - should it be a shapeless recipe instead?");
                }
            }
        }
    }

    /**
     * Remove checks regarding advancements since their implementation is unoptimized and creates lag
     */
    private static class CustomShapeless extends ShapelessRecipeBuilder {
        public CustomShapeless(final ItemLike result, int count) {
            super(result, count);
        }

        public static CustomShapeless shapeless(final ItemLike result) {
            return shapeless(result, 1);
        }

        public static CustomShapeless shapeless(final ItemLike result, int count) {
            return new CustomShapeless(result, count);
        }

        public CustomShapeless requires(@NotNull final TagKey<Item> tag, int count) {
            for (int i = 0; i < count; i++) {
                this.requires(Ingredient.of(tag));
            }

            return this;
        }

        @Override
        public CustomShapeless requires(@NotNull final Ingredient ingredient, int quantity) {
            super.requires(ingredient, quantity);
            return this;
        }

        @Override
        public void save(final Consumer<FinishedRecipe> finishedRecipe, @NotNull final ResourceLocation recipeId) {
            finishedRecipe.accept(new CustomShapeless.Result(recipeId, this.result, this.count, this.group == null ? "" : this.group, this.ingredients, this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + recipeId.getPath())));
        }
    }
}
