package me.tryfle.legacyevents.events

import net.minecraft.entity.Entity
import net.weavemc.api.event.Event

open class EntityListEvent(val entity: Entity) : Event() {

    class Add(entity: Entity) : EntityListEvent(entity)
    class Remove(entity: Entity) : EntityListEvent(entity)
}