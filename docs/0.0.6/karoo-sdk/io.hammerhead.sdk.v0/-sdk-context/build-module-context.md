---
title: SdkContext.buildModuleContext - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0](../index.html) / [SdkContext](index.html) / [buildModuleContext](./build-module-context.html)

# buildModuleContext

`@JvmStatic fun buildModuleContext(sourcePackageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, baseContext: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, moduleResources: `[`Resources`](https://developer.android.com/reference/android/content/res/Resources.html)`, classLoader: `[`ClassLoader`](https://developer.android.com/reference/java/lang/ClassLoader.html)`): `[`SdkContext`](index.html)

Builder for [SdkContext](index.html) context to be used within a [io.hammerhead.sdk.v0.Module](../-module/index.html).
Called by the Karoo system and passed to module on [io.hammerhead.sdk.v0.Module](../-module/index.html) construction.

