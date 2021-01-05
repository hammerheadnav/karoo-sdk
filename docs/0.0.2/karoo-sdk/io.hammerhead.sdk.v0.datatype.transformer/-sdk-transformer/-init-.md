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
class DoubleRideTimeTransformer(context: SdkContext) : SdkTransformer(context) {

    override fun onPause(): Boolean {
        Timber.i("DoubleRideTimeTransformer got pause event, resend dep")
        super.onPause()
        return true
    }

    override fun onDependencyChange(
        timeStamp: Long,
        dependencies: Map<Dependency, Double>
    ): Double {
        return dependencies[Dependency.RIDE_TIME]?.let {
            if (it != MISSING_VALUE) {
                (it * 2.0) / 1000.0
            } else null
        } ?: MISSING_VALUE
    }
}
```

**See Also**

[BuiltInTransformer.Identity](../-built-in-transformer/-identity/index.html)

