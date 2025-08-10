package de.keksuccino.loadmyresources.mixin;

import net.minecraft.class_521.class_4271;
import net.minecraft.class_5369.class_5371;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_4271.class})
public interface IMixinTransferableSelectionListPackEntry {
   @Accessor("pack")
   class_5371 getPackLoadMyResources();
}
