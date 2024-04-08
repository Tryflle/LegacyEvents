package me.tryfle.legacyevents.events

import net.weavemc.api.event.Event

open class TickEvent : Event() {

    class Pre : TickEvent()
    class Post: TickEvent()
}