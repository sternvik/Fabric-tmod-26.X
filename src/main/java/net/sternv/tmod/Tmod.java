package net.sternv.tmod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import net.sternv.tmod.creativemodetab.ModCreativeModeTabs;
import net.sternv.tmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tmod implements ModInitializer {
	public static final String MOD_ID = "tmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();

		ModItems.registerModItems();
	}

}
