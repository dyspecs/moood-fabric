package de.keksuccino.loadmyresources.mixin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import net.minecraft.class_521;
import net.minecraft.class_5375;
import net.minecraft.class_521.class_4271;
import net.minecraft.class_5369.class_5371;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_5375.class})
public class MixinPackSelectionScreen {
   @Inject(
      at = {@At("TAIL")},
      method = {"updateList"}
   )
   private void onUpdatePackList(class_521 widget, Stream<class_5371> packs, CallbackInfo info) {
      List<class_4271> remove = new ArrayList();
      Iterator var5 = widget.method_25396().iterator();

      class_4271 e;
      while(var5.hasNext()) {
         e = (class_4271)var5.next();
         class_5371 p = this.getPackFromEntryLoadMyResources(e);
         if (p != null) {
            String name = p.method_29650().getString();
            if (name.equals("loadmyresources.hiddenpack")) {
               remove.add(e);
            }
         }
      }

      var5 = remove.iterator();

      while(var5.hasNext()) {
         e = (class_4271)var5.next();
         widget.method_25396().remove(e);
      }

   }

   @Unique
   private class_5371 getPackFromEntryLoadMyResources(@NotNull class_4271 entry) {
      return ((IMixinTransferableSelectionListPackEntry)entry).getPackLoadMyResources();
   }
}
