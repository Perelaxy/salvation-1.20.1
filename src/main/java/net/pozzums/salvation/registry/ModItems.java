package net.pozzums.salvation.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.pozzums.salvation.Salvation;
import net.pozzums.salvation.item.ContractScrollItem;
import net.pozzums.salvation.util.SalvationIds;

public class ModItems {

    public static final Item CONTRACT_SCROLL =
            new ContractScrollItem(new Item.Settings().maxCount(1));

    public static void register() {
        Registry.register(
                Registries.ITEM,
                SalvationIds.id("contract_scroll"),
                CONTRACT_SCROLL
        );
    }
}
