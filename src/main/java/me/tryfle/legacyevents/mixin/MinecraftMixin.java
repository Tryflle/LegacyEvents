package me.tryfle.legacyevents.mixin;

import me.tryfle.legacyevents.events.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.weavemc.api.event.EventBus;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Inject(method = "startGame", at = @At("RETURN"))
    public void onStartGame(CallbackInfo ci) {
        EventBus.postEvent(new PostGameStartEvent());
    }

    @Inject(method = "runTick", at = @At("HEAD"))
    public void onTick(CallbackInfo ci) {
        EventBus.postEvent(new TickEvent.Pre());
    }

    @Inject(method = "runTick", at = @At("RETURN"))
    public void onEndTick(CallbackInfo ci) {
        EventBus.postEvent(new TickEvent.Post());
    }

    @Inject(method = "dispatchKeypresses", at = @At("HEAD"), cancellable = true)
    public void onKey(CallbackInfo ci) {
        KeyboardEvent keyEvent = new KeyboardEvent(Keyboard.getEventKey());
        EventBus.postEvent(keyEvent);
        if (keyEvent.isCancelled()) ci.cancel();
    }

    @Inject(method = "clickMouse", at = @At("HEAD"), cancellable = true)
    public void onClickMouse(CallbackInfo ci) {
        ClickEvent clickEvent = new ClickEvent(1);
        EventBus.postEvent(clickEvent);
        if (clickEvent.isCancelled()) ci.cancel();
    }

    @Inject(method = "rightClickMouse", at = @At("HEAD"), cancellable = true)
    public void onRightClickMouse(CallbackInfo ci) {
        ClickEvent clickEvent = new ClickEvent(2);
        EventBus.postEvent(clickEvent);
        if (clickEvent.isCancelled()) ci.cancel();
    }

    @Inject(method = "loadWorld(Lnet/minecraft/client/multiplayer/WorldClient;)V", at = @At("HEAD"))
    public void onLoadWorld(WorldClient a, CallbackInfo ci) {
        if (a != null) EventBus.postEvent(new WorldEvent.Load(a));
        if (a == null) EventBus.postEvent(new WorldEvent.Unload(null));
    }

    @Inject(method = "shutdownMinecraftApplet", at = @At("HEAD"))
    public void onShutdown(CallbackInfo ci) {
        EventBus.postEvent(new ShutdownEvent());
    }

    @Inject(method = "displayGuiScreen", at = @At("HEAD"))
    public void onDisplayGuiScreen(GuiScreen s, CallbackInfo ci) {
        EventBus.postEvent(new GuiOpenEvent(s));
    }
}
