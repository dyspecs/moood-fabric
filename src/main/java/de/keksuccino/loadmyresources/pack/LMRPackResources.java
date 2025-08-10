package de.keksuccino.loadmyresources.pack;

import com.google.common.base.CharMatcher;
import com.google.common.collect.Sets;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Set;
import javax.annotation.Nullable;
import net.minecraft.class_151;
import net.minecraft.class_156;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3259;
import net.minecraft.class_3264;
import net.minecraft.class_3270;
import net.minecraft.class_7367;
import net.minecraft.class_156.class_158;
import net.minecraft.class_3262.class_7664;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class LMRPackResources extends class_3259 {
   private static final Logger LOGGER = LogManager.getLogger("loadmyresources/LMRPackResources");
   private static final boolean ON_WINDOWS;
   private static final CharMatcher BACKSLASH_MATCHER;
   private final File file;

   public LMRPackResources() {
      super("loadmyresources.hiddenpack", PackHandler.resourcesDirectory.toPath(), true);
      this.file = PackHandler.resourcesDirectory;
   }

   public <T> T method_14407(class_3270<T> serializer) throws IOException {
      InputStream in = class_310.method_1551().method_1478().open(PackHandler.DUMMY_PACK_META);

      Object o;
      try {
         o = method_14392(serializer, in);
      } catch (Throwable var7) {
         if (in != null) {
            try {
               in.close();
            } catch (Throwable var6) {
               var7.addSuppressed(var6);
            }
         }

         throw var7;
      }

      if (in != null) {
         in.close();
      }

      return o;
   }

   @NotNull
   public Set<String> method_14406(@NotNull class_3264 type) {
      Set<String> s = Sets.newHashSet();
      File[] files = this.file.listFiles(DirectoryFileFilter.DIRECTORY);
      if (files != null) {
         File[] var4 = files;
         int var5 = files.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            File f = var4[var6];
            String path = getRelativePath(this.file, f);
            if (path.equals(path.toLowerCase(Locale.ROOT))) {
               s.add(path.substring(0, path.length() - 1));
            } else {
               this.logWarning(path);
            }
         }
      }

      return s;
   }

   private static String getPathFromLocation(class_3264 p_10227_, class_2960 p_10228_) {
      return String.format(Locale.ROOT, "%s/%s/%s", p_10227_.method_14413(), p_10228_.method_12836(), p_10228_.method_12832());
   }

   @Nullable
   public class_7367<InputStream> method_14405(@NotNull class_3264 packType, @NotNull class_2960 location) {
      try {
         File f = this.getFile(getPathFromLocation(location));
         if (f != null) {
            return class_7367.create(f.toPath());
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return null;
   }

   @Nullable
   private File getFile(String p_10282_) {
      try {
         File file1 = new File(this.file, p_10282_);
         if (file1.isFile() && validatePath(file1, p_10282_)) {
            return file1;
         }
      } catch (IOException var3) {
      }

      return null;
   }

   public static boolean validatePath(File p_10274_, String p_10275_) throws IOException {
      String s = p_10274_.getCanonicalPath();
      if (ON_WINDOWS) {
         s = BACKSLASH_MATCHER.replaceFrom(s, '/');
      }

      return s.endsWith(p_10275_);
   }

   private static String getPathFromLocation(class_2960 location) {
      return String.format("%s/%s", location.method_12836(), location.method_12832());
   }

   public void method_14408(@NotNull class_3264 packType, @NotNull String namespace, @NotNull String resourcePreNamePath, @NotNull class_7664 output) {
      this.listFiles(new File(new File(this.file, namespace), resourcePreNamePath), namespace, resourcePreNamePath + "/", output);
   }

   private void listFiles(File file, String string, String string2, class_7664 output) {
      File[] files = file.listFiles();
      if (files != null) {
         int var8 = files.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            File file2 = files[var9];
            if (file2.isDirectory()) {
               this.listFiles(file2, string, string2 + file2.getName() + "/", output);
            } else if (!file2.getName().endsWith(".mcmeta")) {
               try {
                  String string3 = string2 + file2.getName();
                  class_2960 resourceLocation = class_2960.method_43902(string, string3);
                  if (resourceLocation == null) {
                     LOGGER.warn("Invalid path in datapack: {}:{}, ignoring", string, string3);
                  } else {
                     output.accept(resourceLocation, class_7367.create(file2.toPath()));
                  }
               } catch (class_151 var11) {
                  LOGGER.error(var11.getMessage());
               }
            }
         }
      }

   }

   protected static String getRelativePath(File p_10218_, File p_10219_) {
      return p_10218_.toURI().relativize(p_10219_.toURI()).getPath();
   }

   protected void logWarning(String p_10231_) {
      LOGGER.warn("ResourcePack: ignored non-lowercase namespace: {} in {}", p_10231_, this.file);
   }

   static {
      ON_WINDOWS = class_156.method_668() == class_158.field_1133;
      BACKSLASH_MATCHER = CharMatcher.is('\\');
   }
}
