# LegacyEvents
An all in one library that brings back all the events from Legacy Weave!
# How to use
```kotlin
repositories {
    // Add Jitpack to your repositories.
    maven("https://jitpack.io")
    mavenCentral()
}

dependencies {
    // Add the dependency.
    implementation("com.github.Tryflle:LegacyEvents:1.0.0")
}
```
# Events
- ChatReceivedEvent
- ChatSentEvent (Cancellable)
- ClickEvent (Cancellable, 1 = lmb, 2 = rmb)
- EntityListEvent (Add, Remove)
- GuiOpenEvent
- KeyboardEvent (Cancellable, doesn't have states, use LWJGL)
- PacketEvent (Cancellable, Send, Receive)
- PostGameStartEvent
- RenderGameOverlayEvent (Pre, Post)
- RenderWorldEvent
- RenderHandEvent (Cancellable)
- ServerConnectEvent
- ShutdownEvent
- TickEvent (Pre, Post)
-~~WorldEvent (Load, Unload)~~ (Broken)
# Todo Events
- RenderLivingEvent
# Notes
This hasn't been tested lol. It probably works, I can't be asked to check right now. If you run into any issues, please make an issue.
