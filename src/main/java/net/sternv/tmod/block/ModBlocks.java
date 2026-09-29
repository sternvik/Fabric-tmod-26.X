package net.sternv.tmod.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.sternv.tmod.Tmod;

import java.util.function.Function;

public class ModBlocks  {

    public static final Block TEST_BLOCK = registerBlock("test_block",
            properties -> new Block(properties.strength(4.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Tmod.MOD_ID, name))));
        registerBlockItems(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Tmod.MOD_ID, name), toRegister);
    }

    public static void registerBlockItems(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Tmod.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Tmod.MOD_ID, name)))));

    }

    public static void registerModBlocks(){
        Tmod.LOGGER .info("Registering Mod Blocks for " +  Tmod.MOD_ID);
    }

}
