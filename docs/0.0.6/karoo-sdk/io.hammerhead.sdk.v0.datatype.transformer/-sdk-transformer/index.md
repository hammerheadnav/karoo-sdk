---
title: SdkTransformer - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype.transformer](../index.html) / [SdkTransformer](./index.html)

# SdkTransformer

`abstract class SdkTransformer : `[`RideLifecycleListener`](../../io.hammerhead.sdk.v0/-ride-lifecycle-listener/index.html)

Abstract class to extend the way data field is formatted.

``` kotlin
class AppValTransformer(context: SdkContext) : SdkTransformer(context) {

    override fun onDependencyChange(
        timeStamp: Long,
        dependencies: Map<Dependency, Double>
    ): Double {
        return if (rideState == RideState.RECORDING) {
            context.keyValueStore.getDouble("appval") ?: MISSING_VALUE
        } else {
            MISSING_VALUE
        }
    }
}
```

``` kotlin
class PowerHeartRateTransformer(context: SdkContext) : SdkTransformer(context) {
    override fun onDependencyChange(
        timeStamp: Long,
        dependencies: Map<Dependency, Double>
    ): Double {
        val heartRate = dependencies[Dependency.HEART_RATE]
        if (heartRate == null || heartRate == MISSING_VALUE) {
            return MISSING_VALUE
        }
        val power = dependencies[Dependency.POWER]
        if (power == null || power == MISSING_VALUE) {
            return MISSING_VALUE
        }
        return power / heartRate
    }
}
```

**See Also**

[BuiltInTransformer.Identity](../-built-in-transformer/-identity/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `SdkTransformer()`<br>Abstract class to extend the way data field is formatted. |

### Properties

| [rideState](ride-state.html) | `var rideState: `[`RideState`](../../io.hammerhead.sdk.v0/-ride-state/index.html)<br>Current ride state |

### Functions

| [onDependencyChange](on-dependency-change.html) | `abstract fun onDependencyChange(timeStamp: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, dependencies: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Dependency`](../../io.hammerhead.sdk.v0.datatype/-dependency/index.html)`, `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>Called when a dependency changes and a new output for this field should be calculated or with the last value after a lifecycle change. |

### Inherited Functions

| [onLap](../../io.hammerhead.sdk.v0/-ride-lifecycle-listener/on-lap.html) | `open fun onLap(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Lifecycle event hook for when ride lap resets. |

### Companion Object Properties

| [MISSING_VALUE](-m-i-s-s-i-n-g_-v-a-l-u-e.html) | `val MISSING_VALUE: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>Constant value representing that value is unknown or unavailable |

### Inheritors

| [BuiltInTransformer](../-built-in-transformer/index.html) | `sealed class BuiltInTransformer : `[`SdkTransformer`](./index.html) |

