package me.tryfle.legacyevents.mixin;

import io.netty.channel.ChannelHandlerContext;
import me.tryfle.legacyevents.events.PacketEvent;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.weavemc.api.event.EventBus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class NetworkManagerMixin {

    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    public void sendPacket(Packet p_sendPacket_1_, CallbackInfo ci) {
        PacketEvent packetEvent = new PacketEvent.Send(p_sendPacket_1_);
        EventBus.postEvent(packetEvent);
        if (packetEvent.isCancelled()) ci.cancel();
    }

    @Inject(method = "channelRead0(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    public void receivePacket(ChannelHandlerContext p_channelRead0_1_, Packet p_channelRead0_2_, CallbackInfo ci) {
        PacketEvent packetEvent = new PacketEvent.Receive(p_channelRead0_2_);
        EventBus.postEvent(packetEvent);
        if (packetEvent.isCancelled()) ci.cancel();
    }
}