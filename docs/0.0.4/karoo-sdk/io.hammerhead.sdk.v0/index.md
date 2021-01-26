---
title: io.hammerhead.sdk.v0 - karoo-sdk
---

[karoo-sdk](../index.html) / [io.hammerhead.sdk.v0](./index.html)

## Package io.hammerhead.sdk.v0

Versioned namespace for first-release of Karoo SDK.

### Types

| [KeyValueStore](-key-value-store/index.html) | `class KeyValueStore`<br>Simple storage of key/value pairs for use by Karoo SDK modules. This allows modules to store values that need to be persisted across rides and reboots. Additionally, allows access between full APK and Karoo SDK plugins and across plugin instances running within different Karoo apps. |
| [Module](-module/index.html) | `abstract class Module : `[`RideLifecycleListener`](-ride-lifecycle-listener/index.html)<br>Karoo SDK Module |
| [ModuleFactoryI](-module-factory-i/index.html) | `interface ModuleFactoryI`<br>Interface for factory to build a custom Karoo SDK module. |
| [RideLifecycleListener](-ride-lifecycle-listener/index.html) | `interface RideLifecycleListener`<br>Interface which is called for lifecycle events related to ride. |
| [RideState](-ride-state/index.html) | `enum class RideState`<br>Enumeration of ride state |
| [SdkContext](-sdk-context/index.html) | `class SdkContext : `[`ContextWrapper`](https://developer.android.com/reference/android/content/ContextWrapper.html)<br>Context wrapper specifically for use within external code (Karoo SDK Module) while running within the Karoo System. This allows use of the originating packages resources within the Karoo System app context. |

