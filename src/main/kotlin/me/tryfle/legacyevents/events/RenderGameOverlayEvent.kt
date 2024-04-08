package me.tryfle.legacyevents.events

import net.weavemc.api.event.Event

open class RenderGameOverlayEvent(val partialTicks: Float): Event() {

    class Pre(partialTicks: Float) : RenderGameOverlayEvent(partialTicks)
    class Post(partialTicks: Float) : RenderGameOverlayEvent(partialTicks)
}