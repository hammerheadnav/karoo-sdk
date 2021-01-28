---
title: ModuleFactoryI - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0](../index.html) / [ModuleFactoryI](./index.html)

# ModuleFactoryI

`interface ModuleFactoryI`

Interface for factory to build a custom Karoo SDK module.

``` kotlin
@JvmField
        val factory = object : ModuleFactoryI {
            override fun buildModule(context: SdkContext): Module {
                return SampleModule(context)
            }
        }
```

### Functions

| [buildModule](build-module.html) | `abstract fun buildModule(context: `[`SdkContext`](../-sdk-context/index.html)`): `[`Module`](../-module/index.html)<br>Builds the custom Karoo SDK module for use in the Karoo System. |

