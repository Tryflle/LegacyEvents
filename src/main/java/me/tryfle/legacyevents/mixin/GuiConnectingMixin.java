package me.tryfle.legacyevents.mixin;

import me.tryfle.legacyevents.events.ServerConnectEvent;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.weavemc.api.event.EventBus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiConnecting.class)
public class GuiConnectingMixin {

    @Inject(method = "connect", at = @At("HEAD"))
    public void onConnect(String ip, int port, CallbackInfo ci) {
        EventBus.postEvent(new ServerConnectEvent(ip, port));
    }
}
