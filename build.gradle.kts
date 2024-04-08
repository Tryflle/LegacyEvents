plugins {
    kotlin("jvm") version "1.9.23"
    id("net.weavemc.gradle") version "1.0.0-PRE"
}

group = "me.tryfle"
version = "1.0"

minecraft {
    configure {
        name = "LegacyEvents"
        modId = "legacyevents"
        entryPoints = listOf("me.tryfle.legacyevents.Main")
        mixinConfigs = listOf("legacyevents.mixins.json")
        mcpMappings()
    }
    version("1.8.9")
}

repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/maven")
    maven("https://repo.weavemc.dev/releases")
}

dependencies {
    implementation("net.weavemc.api:common:1.0.0-PRE")
    implementation("net.weavemc:internals:1.0.0-PRE")
    compileOnly("org.spongepowered:mixin:0.8.5")
}

kotlin {
    jvmToolchain(17)
}

