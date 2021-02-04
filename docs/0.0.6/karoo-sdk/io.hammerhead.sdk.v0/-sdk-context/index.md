---
title: SdkContext - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0](../index.html) / [SdkContext](./index.html)

# SdkContext

`class SdkContext : `[`ContextWrapper`](https://developer.android.com/reference/android/content/ContextWrapper.html)

Context wrapper specifically for use within external code (Karoo SDK Module)
while running within the Karoo System. This allows use of the originating packages
resources within the Karoo System app context.

### Properties

| [keyValueStore](key-value-store.html) | `val keyValueStore: `[`KeyValueStore`](../-key-value-store/index.html)<br>Access the key-value storage associated with this context. Can be used to persist values across boot, between the module when run within different Karoo apps, or between SDK module and full app instance when used with [buildSdkContext](build-sdk-context.html) |
| [supportsKarooSdk](supports-karoo-sdk.html) | `val supportsKarooSdk: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Boolean if running on a device which supports the Karoo SDK. |

### Companion Object Properties

| [INTENT_INITIALIZE](-i-n-t-e-n-t_-i-n-i-t-i-a-l-i-z-e.html) | `const val INTENT_INITIALIZE: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Broadcast by Karoo System when online initialization should be performed. |

### Companion Object Functions

| [buildModuleContext](build-module-context.html) | `fun buildModuleContext(sourcePackageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, baseContext: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, moduleResources: `[`Resources`](https://developer.android.com/reference/android/content/res/Resources.html)`, classLoader: `[`ClassLoader`](https://developer.android.com/reference/java/lang/ClassLoader.html)`): `[`SdkContext`](./index.html)<br>Builder for [SdkContext](./index.html) context to be used within a [io.hammerhead.sdk.v0.Module](../-module/index.html). Called by the Karoo system and passed to module on [io.hammerhead.sdk.v0.Module](../-module/index.html) construction. |
| [buildSdkContext](build-sdk-context.html) | `fun buildSdkContext(appContext: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`SdkContext`](./index.html)<br>Builder for [SdkContext](./index.html) when a Karoo SDK Context is required within normal application, not within a [io.hammerhead.sdk.v0.Module](../-module/index.html). |

