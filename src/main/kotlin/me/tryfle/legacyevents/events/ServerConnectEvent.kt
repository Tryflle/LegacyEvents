package me.tryfle.legacyevents.events

import net.weavemc.api.event.Event

class ServerConnectEvent(val ip: String, val port : Int) : Event()