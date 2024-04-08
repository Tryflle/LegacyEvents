package me.tryfle.legacyevents.mixin;

import net.minecraft.client.renderer.entity.RendererLivingEntity;
import org.spongepowered.asm.mixin.Mixin;


@Mixin(RendererLivingEntity.class)
public class RenderLivingEntityMixin {
    // Will do this later. For RenderLivingEvent. It's just a bit complex to make sense of from the hook to convert it to mixin.
}
