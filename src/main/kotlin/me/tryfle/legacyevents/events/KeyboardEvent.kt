package me.tryfle.legacyevents.events

import net.weavemc.api.event.CancellableEvent

// If you are looking for keyboard state stuff, just use lwjgl smh

class KeyboardEvent(val keyCode: Int) : CancellableEvent()