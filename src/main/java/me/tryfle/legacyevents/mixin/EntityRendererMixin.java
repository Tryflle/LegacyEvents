package me.tryfle.legacyevents.mixin;


import me.tryfle.legacyevents.events.RenderHandEvent;
import me.tryfle.legacyevents.events.RenderWorldEvent;
import net.minecraft.client.renderer.EntityRenderer;
import net.weavemc.api.event.EventBus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {

    @Inject(method = "renderHand", at = @At("HEAD"))
    public void onRenderHand(float a, int b, CallbackInfo ci) {
        EventBus.postEvent(new RenderHandEvent(a));
    }

    @Inject(method = "renderWorldPass", at = @At("HEAD"))
    public void onRenderWorld(int a, float b, long c, CallbackInfo ci) {
        EventBus.postEvent(new RenderWorldEvent(b));
    }

}