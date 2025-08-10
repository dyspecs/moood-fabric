package de.keksuccino.loadmyresources.pack;

import de.keksuccino.loadmyresources.LoadMyResources;
import java.io.File;
import java.util.List;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_3281;
import net.minecraft.class_3288;
import net.minecraft.class_5352;
import net.minecraft.class_7701;
import net.minecraft.class_3288.class_3289;
import net.minecraft.class_3288.class_7679;
import net.minecraft.class_3288.class_7680;

public class PackHandler {
   public static final String PACK_NAME = "loadmyresources.hiddenpack";
   public static final int PACK_FORMAT = 8;
   public static final String PACK_DESCRIPTION = "LMR Resources";
   public static final class_2960 DUMMY_PACK_META = new class_2960("loadmyresources", "dummy.pack.mcmeta");
   public static File resourcesDirectory = new File(LoadMyResources.getGameDirectory(), "resources/");

   public static void init() {
      if (LoadMyResources.config != null) {
         resourcesDirectory = new File(LoadMyResources.getGameDirectory(), (String)LoadMyResources.config.getOrDefault("resource_path", "resources/"));
      } else {
         LoadMyResources.LOGGER.error("[LOAD MY RESOURCES] ERROR: Config not loaded! Can't get resource path! Path set to default 'resources/'!");
      }

      LoadMyResources.LOGGER.info("[LOAD MY RESOURCES] PackHandler initialized! Resources path set to: " + resourcesDirectory.getAbsolutePath());
   }

   public static void prepareResourcesFolder() {
      if (!resourcesDirectory.isDirectory()) {
         resourcesDirectory.mkdirs();
      }

   }

   public static class_3288 createPack(class_7680 resources) {
      class_7679 info = new class_7679(class_2561.method_43470("LMR Resources"), class_3281.field_14224, class_7701.field_40182, List.of());
      return class_3288.method_14456("loadmyresources.hiddenpack", class_2561.method_43470("loadmyresources.hiddenpack"), true, resources, info, class_3289.field_14280, true, class_5352.field_25347);
   }
}
