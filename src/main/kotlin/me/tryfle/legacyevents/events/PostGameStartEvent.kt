package me.tryfle.legacyevents.events

import net.weavemc.api.event.Event

//Non cancellable event that is called when the game starts. This is used to fix premature initialization thanks to SOMEONE forgetting to add an Init method smh..

class PostGameStartEvent : Event()