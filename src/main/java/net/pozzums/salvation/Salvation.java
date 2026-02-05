package net.pozzums.salvation;

import net.fabricmc.api.ModInitializer;
import net.pozzums.salvation.registry.ModItems;
import net.pozzums.salvation.registry.ModNetworking;
import net.pozzums.salvation.registry.ModScreens;

public class Salvation implements ModInitializer {

	public static final String MOD_ID = "salvation";

	@Override
	public void onInitialize() {
		ModItems.register();
		ModScreens.register();
		ModNetworking.register();
	}
}
