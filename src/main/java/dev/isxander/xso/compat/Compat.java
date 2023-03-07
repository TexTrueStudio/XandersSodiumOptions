package dev.isxander.xso.compat;

import dev.isxander.xso.XSOForge;

public class Compat {
    public static final boolean SODIUM_EXTRA = mod("sodium-extra");
    //public static final boolean MORE_CULLING = mod("moreculling");
    public static final boolean IRIS = mod("iris");
    //public static final boolean ENTITY_VIEW_DIST = mod("entity-view-distance");

    private static boolean mod(String id) {
        return XSOForge.isModLoaded(id);
    }
}
