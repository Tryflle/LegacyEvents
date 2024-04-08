package me.tryfle.legacyevents.events

import net.weavemc.api.event.CancellableEvent
import net.minecraft.client.gui.GuiScreen


class GuiOpenEvent(val screen: GuiScreen?) : CancellableEvent()