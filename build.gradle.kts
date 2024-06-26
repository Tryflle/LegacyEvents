plugins {
    `maven-publish`
    kotlin("jvm") version "1.9.23"
    id("net.weavemc.gradle") version "1.0.0-PRE2"
}

group = "me.tryfle"
version = "1.0.2"

weave {
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
    implementation("net.weavemc.api:common:1.0.0-PRE2")
    implementation("net.weavemc:internals:1.0.0-PRE2")
    compileOnly("org.spongepowered:mixin:0.8.5")
}

kotlin {
    jvmToolchain(8)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}
