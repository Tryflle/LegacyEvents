package me.tryfle.legacyevents.events

import net.weavemc.api.event.CancellableEvent

class ChatSentEvent(val message: String) : CancellableEvent()