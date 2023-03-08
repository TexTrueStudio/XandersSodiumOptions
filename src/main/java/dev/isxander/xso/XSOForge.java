package dev.isxander.xso;

import dev.isxander.xso.config.XsoConfig;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.network.NetworkConstants;

import java.nio.file.Path;

@Mod(XSOForge.MODID)
public class XSOForge {
    public static final String MODID = "xanders_sodium_options";
    public static Path getConfigDir() {
        return FMLPaths.CONFIGDIR.get();
    }
    public static boolean isModLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }

    public XSOForge() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onInitializeClient);

        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
    }

    public void onInitializeClient(final FMLClientSetupEvent event) {
        XsoConfig.INSTANCE.load();
    }
}
