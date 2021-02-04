---
title: Module - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0](../index.html) / [Module](./index.html)

# Module

`abstract class Module : `[`RideLifecycleListener`](../-ride-lifecycle-listener/index.html)

Karoo SDK Module

``` kotlin
class SampleModule(context: SdkContext) : Module(context) {
    override val name: String = "sample"
    override val version: String = "1.0"

    override fun onStart(): Boolean {
        Timber.i("SampleModule received ride start event")
        return false
    }

    override fun provideDataTypes(): List<SdkDataType> {
        return listOf(
            CustomSpeedDataType(context),
            PowerHeartRateDataType(context),
            AppValDataType(context)
        )
    }

    override fun postRideCard(details: RideDetails): PostRideCard? {
        return RideCard(context, details)
    }

    companion object {
        @JvmField
        val factory = object : ModuleFactoryI {
            override fun buildModule(context: SdkContext): Module {
                return SampleModule(context)
            }
        }
    }
}
```

### Parameters

`context` - provided by the Karoo System when loading the module

### Constructors

| [&lt;init&gt;](-init-.html) | `Module(context: `[`SdkContext`](../-sdk-context/index.html)`)`<br>Karoo SDK Module |

### Properties

| [context](context.html) | `val context: `[`SdkContext`](../-sdk-context/index.html)<br>provided by the Karoo System when loading the module |
| [name](name.html) | `abstract val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name uniquely identifying this module. |
| [packageIcon](package-icon.html) | `val packageIcon: `[`Drawable`](https://developer.android.com/reference/android/graphics/drawable/Drawable.html)<br>Icon from originating package. Cannot be overridden, set during initialization when loading module. |
| [packageName](package-name.html) | `val packageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of originating package. Cannot be overridden, set during initialization when loading module. |
| [settingsIntent](settings-intent.html) | `open val ~~settingsIntent~~: `[`Intent`](https://developer.android.com/reference/android/content/Intent.html)`?`<br>Deprecated - no longer called |
| [version](version.html) | `abstract val version: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Current version of this module. Independent of Karoo SDK version. |

### Functions

| [postRideCard](post-ride-card.html) | `open fun postRideCard(details: `[`RideDetails`](../../io.hammerhead.sdk.v0.card/-ride-details/index.html)`): `[`PostRideCard`](../../io.hammerhead.sdk.v0.card/-post-ride-card/index.html)`?`<br>Method for optionally creating a Post-Ride Card view based on [RideDetails](../../io.hammerhead.sdk.v0.card/-ride-details/index.html). |
| [provideDataTypes](provide-data-types.html) | `abstract fun provideDataTypes(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`SdkDataType`](../../io.hammerhead.sdk.v0.datatype/-sdk-data-type/index.html)`>`<br>Method for constructing which SDK data types this module provides. Called when first needed and stored, therefor this cannot be dynamic. |

### Inherited Functions

| [onEnd](../-ride-lifecycle-listener/on-end.html) | `open fun onEnd(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Lifecycle event hook for when ride stops recording. |
| [onLap](../-ride-lifecycle-listener/on-lap.html) | `open fun onLap(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Lifecycle event hook for when ride lap resets. |
| [onPause](../-ride-lifecycle-listener/on-pause.html) | `open fun onPause(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Lifecycle event hook for when ride is paused. |
| [onResume](../-ride-lifecycle-listener/on-resume.html) | `open fun onResume(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Lifecycle event hook for when ride is resumed. |
| [onStart](../-ride-lifecycle-listener/on-start.html) | `open fun onStart(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Lifecycle event hook for when ride starts recording. |

