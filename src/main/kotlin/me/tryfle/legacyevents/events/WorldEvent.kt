package me.tryfle.legacyevents.events

import net.weavemc.api.event.Event
import net.minecraft.world.World
import javax.annotation.Nullable


open class WorldEvent(@Nullable world: World) : Event() {

    class Load(@Nullable world: World) : WorldEvent(world)
    class Unload(@Nullable world: World) : WorldEvent(world)
}