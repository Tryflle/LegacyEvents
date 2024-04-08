package me.tryfle.legacyevents.events

import net.weavemc.api.event.CancellableEvent


open class PacketEvent(val packet: Any): CancellableEvent() {

    class Send(packet: Any) : PacketEvent(packet)
    class Receive(packet: Any) : PacketEvent(packet)
}