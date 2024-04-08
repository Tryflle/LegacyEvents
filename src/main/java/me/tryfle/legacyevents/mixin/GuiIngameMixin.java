package me.tryfle.legacyevents.mixin;

import me.tryfle.legacyevents.events.RenderGameOverlayEvent;
import net.minecraft.client.gui.GuiIngame;
import net.weavemc.api.event.EventBus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public class GuiIngameMixin {

    @Inject(method = "renderGameOverlay", at = @At(value = "HEAD"))
    public void onRenderGameOverlay(float partialTicks, CallbackInfo ci) {
        EventBus.postEvent(new RenderGameOverlayEvent.Pre(partialTicks));
    }

    @Inject(method = "renderGameOverlay", at = @At(value = "RETURN"))
    public void onRenderGameOverlayPost(float partialTicks, CallbackInfo ci) {
        EventBus.postEvent(new RenderGameOverlayEvent.Post(partialTicks));
    }
}