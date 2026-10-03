package net.sternv.tmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.TestBlock;
import net.sternv.tmod.block.ModBlocks;
import net.sternv.tmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
            @Override
            public void buildRecipes() {
                List<ItemLike> TEST_SMELTABLES = List.of(ModItems.TEST, ModBlocks.TEST_BLOCK_ORE);

                oreSmelting(TEST_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.TEST, 0.25f, 200, "test");
                oreBlasting(TEST_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.TEST, 0.25f, 100, "test");

                //nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.TEST, RecipeCategory.DECORATIONS, ModBlocks.TEST_BLOCK);

                shaped(RecipeCategory.MISC, ModBlocks.TEST_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModItems.TEST)
                        .unlockedBy(getHasName(ModItems.TEST), has(ModItems.TEST))
                        .group("test")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.TEST, 9)
                        .requires(ModBlocks.TEST_BLOCK)
                        .unlockedBy(getHasName(ModBlocks.TEST_BLOCK), has(ModBlocks.TEST_BLOCK))
                        .group("test")
                        .save(output);

            }
        };
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
