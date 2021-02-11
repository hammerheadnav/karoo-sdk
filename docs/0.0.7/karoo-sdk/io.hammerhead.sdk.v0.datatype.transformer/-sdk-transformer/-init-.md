---
title: SdkTransformer.<init> - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype.transformer](../index.html) / [SdkTransformer](index.html) / [&lt;init&gt;](./-init-.html)

# &lt;init&gt;

`SdkTransformer()`

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

