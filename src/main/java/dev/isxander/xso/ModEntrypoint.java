package dev.isxander.xso;

import dev.isxander.xso.config.XsoConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ModEntrypoint {
    public static void onInitializeClient(final FMLClientSetupEvent event) {
        XsoConfig.INSTANCE.load();
    }
}
