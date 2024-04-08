package me.tryfle.legacyevents.events

import net.weavemc.api.event.Event
import net.minecraft.world.World


open class WorldEvent(val world: World) : Event() {

    class Load(world: World) : WorldEvent(world)
    class Unload(world: World) : WorldEvent(world)
}