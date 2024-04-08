package me.tryfle.legacyevents.events

import net.weavemc.api.event.CancellableEvent

//WHO ACTUALLY USES ANYTHING BUT THE CLICK ITSELF LETS BE REAL HERE
// 1 = lmb, 2 = rmb.

class ClickEvent(val button: Int) : CancellableEvent()