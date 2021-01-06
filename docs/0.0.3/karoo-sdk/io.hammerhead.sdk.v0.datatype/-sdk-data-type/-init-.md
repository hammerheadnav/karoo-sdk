---
title: SdkDataType.<init> - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype](../index.html) / [SdkDataType](index.html) / [&lt;init&gt;](./-init-.html)

# &lt;init&gt;

`SdkDataType(context: `[`SdkContext`](../../io.hammerhead.sdk.v0/-sdk-context/index.html)`)`

Definition of an extended data field to add to the Karoo System.

``` kotlin
class CustomSpeedDataType(context: SdkContext) : SdkDataType(context) {
    override val typeId: String = "custom-speed"
    override val displayName: String = "Custom Speed"
    override val description: String = "Shows speed in custom view"
    override val dependencies = listOf(Dependency.SPEED)

    override fun newView(): SdkView = CustomSpeedSdkView(context)
    override fun newFormatter(): SdkFormatter = BuiltInFormatter.None()
    override fun newTransformer(): SdkTransformer = BuiltInTransformer.Identity(context)
}
```

``` kotlin
class DoubleRideTimeDataType(context: SdkContext) : SdkDataType(context) {
    override val typeId: String = "double-ride-time"
    override val displayName: String = "RideTimeX2"
    override val description: String = "Takes the ride time and doubles it"
    override fun displayIcons(): List<Drawable>? {
        return context.getDrawable(R.drawable.ic_double_ride_time)?.let { listOf(it) }
    }

    override val summaryField: Boolean = true
    override val dependencies = listOf(Dependency.RIDE_TIME)
    override val sampleValue: Double = 11.0

    override fun newView(): SdkView = BuiltInView.Numeric(context)
    override fun newFormatter(): SdkFormatter = BuiltInFormatter.Numeric(0)
    override fun newTransformer(): SdkTransformer = DoubleRideTimeTransformer(context)
}
```

``` kotlin
class AppValDataType(context: SdkContext) : SdkDataType(context) {
    override val typeId: String = "appval"
    override val displayName: String = "AppVal"
    override val description: String = "Shows a value from app"
    override val dependencies = listOf(Dependency.INTERVAL)
    override val sampleValue: Double = 22.0

    override fun newView(): SdkView = BuiltInView.Numeric(context)
    override fun newFormatter(): SdkFormatter = AppValFormatter()
    override fun newTransformer(): SdkTransformer = AppValTransformer(context)
}
```

