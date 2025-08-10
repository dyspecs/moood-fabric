package de.keksuccino.loadmyresources;

import de.keksuccino.loadmyresources.pack.PackHandler;
import de.keksuccino.loadmyresources.utils.config.Config;
import java.io.File;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_310;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoadMyResources implements ModInitializer {
   public static final String VERSION = "1.0.4";
   public static final File HOME_DIR = new File(getGameDirectory(), "config/loadmyresources/");
   public static Logger LOGGER = LogManager.getLogger();
   public static Config config;
   private static boolean isInitialized = false;

   public static boolean init() {
      if (isInitialized) {
         return true;
      } else if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
         if (!HOME_DIR.exists()) {
            HOME_DIR.mkdirs();
         }

         updateConfig();
         PackHandler.init();
         isInitialized = true;
         return true;
      } else {
         LOGGER.info("## WARNING ## 'Load My Resources' is a client mod and has no effect when loaded on a server!");
         return false;
      }
   }

   public void onInitialize() {
   }

   public static void updateConfig() {
      try {
         config = new Config(HOME_DIR.getAbsolutePath() + "/config.cfg");
         config.registerValue("resource_path", "resources/", "general", "The path to load resources from.");
         config.syncConfig();
         config.clearUnusedValues();
      } catch (Exception var1) {
         var1.printStackTrace();
      }

   }

   public static File getGameDirectory() {
      return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT ? class_310.method_1551().field_1697 : new File("");
   }
}
