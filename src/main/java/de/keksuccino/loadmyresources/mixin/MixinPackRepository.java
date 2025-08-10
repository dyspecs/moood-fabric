package de.keksuccino.loadmyresources.mixin;

import de.keksuccino.loadmyresources.LoadMyResources;
import de.keksuccino.loadmyresources.pack.LMRRepositorySource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.class_3283;
import net.minecraft.class_3285;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({class_3283.class})
public class MixinPackRepository {
   @ModifyVariable(
      at = @At("HEAD"),
      method = {"<init>"},
      argsOnly = true
   )
   private static class_3285[] onInit(class_3285[] providers) {
      if (LoadMyResources.init()) {
         List<class_3285> l = new ArrayList(Arrays.asList(providers));
         l.add(new LMRRepositorySource());
         LoadMyResources.LOGGER.info("[LOAD MY RESOURCES] Pack registered!");
         return (class_3285[])l.toArray(new class_3285[0]);
      } else {
         return providers;
      }
   }
}
