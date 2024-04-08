package me.tryfle.legacyevents.events

import net.minecraft.util.IChatComponent
import net.weavemc.api.event.Event

class ChatReceivedEvent(val message: IChatComponent) : Event()