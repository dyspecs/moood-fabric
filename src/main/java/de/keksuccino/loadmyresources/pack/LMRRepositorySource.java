package de.keksuccino.loadmyresources.pack;

import java.util.function.Consumer;
import net.minecraft.class_3262;
import net.minecraft.class_3285;
import net.minecraft.class_3288;
import net.minecraft.class_3288.class_7679;
import net.minecraft.class_3288.class_7680;
import org.jetbrains.annotations.NotNull;

public class LMRRepositorySource implements class_3285 {
   public void method_14453(@NotNull Consumer<class_3288> consumer) {
      PackHandler.prepareResourcesFolder();
      class_3288 p = PackHandler.createPack(this.createSupplier());
      consumer.accept(p);
   }

   protected class_7680 createSupplier() {
      return new class_7680() {
         @NotNull
         public class_3262 method_52424(@NotNull String string) {
            return new LMRPackResources();
         }

         @NotNull
         public class_3262 method_52425(@NotNull String string, @NotNull class_7679 info) {
            return new LMRPackResources();
         }
      };
   }
}
