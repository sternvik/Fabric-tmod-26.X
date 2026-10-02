package net.sternv.tmod.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.sternv.tmod.Tmod;
import net.sternv.tmod.block.ModBlocks;
import net.sternv.tmod.item.ModItems;

public class ModCreativeModeTabs {

    public static final CreativeModeTab TEST_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Tmod.MOD_ID, "test_items"),
            FabricCreativeModeTab.builder().icon(()-> new ItemStack(ModItems.TEST))
                    .title(Component.translatable("creativemode.tmod.test_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.TEST);
                    })


                    .build());

    public static final CreativeModeTab TEST_BLOCK_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Tmod.MOD_ID, "test_blocks"),
            FabricCreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.TEST_BLOCK))
                    .title(Component.translatable("creativemode.tmod.test_blocks"))
                    .displayItems((parameters,  output) -> {
                        output.accept(ModBlocks.TEST_BLOCK);
                        output.accept(ModBlocks.TEST_BLOCK_ORE);
                    })


                    .build());

    public static void registerModCreativeModeTabs(){
        Tmod.LOGGER.info("Registering Creative Mode Tabs for " + Tmod.MOD_ID);
    }
}
