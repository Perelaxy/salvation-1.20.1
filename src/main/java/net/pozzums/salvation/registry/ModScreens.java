package net.pozzums.salvation.registry;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.pozzums.salvation.screen.ContractScreenHandler;
import net.pozzums.salvation.util.SalvationIds;

public class ModScreens {

    public static ScreenHandlerType<ContractScreenHandler> CONTRACT;

    public static void register() {
        CONTRACT = ScreenHandlerRegistry.registerSimple(
                SalvationIds.id("contract"),
                ContractScreenHandler::new
        );
    }
}
