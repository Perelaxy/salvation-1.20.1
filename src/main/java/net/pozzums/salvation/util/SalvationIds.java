package net.pozzums.salvation.util;

import net.minecraft.util.Identifier;
import net.pozzums.salvation.Salvation;

public final class SalvationIds {

    private SalvationIds() {}

    public static Identifier id(String path) {
        return new Identifier(Salvation.MOD_ID, path);
    }
}
