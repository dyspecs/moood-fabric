package de.keksuccino.loadmyresources.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionHelper {
   public static Field findField(Class<?> c, String... names) throws NoSuchFieldException {
      Field f = null;
      String[] var3 = names;
      int var4 = names.length;
      int var5 = 0;

      while(var5 < var4) {
         String s = var3[var5];

         try {
            f = c.getDeclaredField(s);
            f.setAccessible(true);
            break;
         } catch (Exception var8) {
            ++var5;
         }
      }

      if (f == null) {
         throw new NoSuchFieldException("No field found matching one of the given names: " + names);
      } else {
         return f;
      }
   }

   public static Method findMethod(Class<?> c, String deobName, String obName, Class<?>... args) throws NoSuchMethodException {
      Method m = null;

      try {
         m = c.getDeclaredMethod(deobName, args);
         m.setAccessible(true);
      } catch (Exception var7) {
      }

      try {
         m = c.getDeclaredMethod(obName, args);
         m.setAccessible(true);
      } catch (Exception var6) {
      }

      if (m == null) {
         throw new NoSuchMethodException("No method found matching one of the given names or arguments: " + deobName + ", " + obName);
      } else {
         return m;
      }
   }
}
