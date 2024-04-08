package me.tryfle.legacyevents

import net.weavemc.api.ModInitializer
import java.lang.instrument.Instrumentation

class Main : ModInitializer {

    override fun preInit(inst: Instrumentation) {
        println("[LegacyEvents] Loaded.")
    }
}