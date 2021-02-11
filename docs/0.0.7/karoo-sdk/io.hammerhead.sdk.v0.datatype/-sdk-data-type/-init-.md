---
title: SdkDataType.<init> - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype](../index.html) / [SdkDataType](index.html) / [&lt;init&gt;](./-init-.html)

# &lt;init&gt;

`SdkDataType(context: `[`SdkContext`](../../io.hammerhead.sdk.v0/-sdk-context/index.html)`)`

Definition of an extended data field to add to the Karoo System.

``` kotlin
class AppValDataType(context: SdkContext) : SdkDataType(context) {
    override val typeId: String = TYPE_ID
    override val displayName: String = "AppVal"
    override val description: String = "Shows a value from app"
    override val dependencies = listOf(Dependency.INTERVAL)
    override val summaryField: Boolean = true
    override val sampleValue: Double = 22.0

    override fun newView(): SdkView = BuiltInView.Numeric(context)
    override fun newFormatter(): SdkFormatter = AppValFormatter()
    override fun newTransformer(): SdkTransformer = AppValTransformer(context)

    companion object {
        const val TYPE_ID = "appval"
    }
}
```

``` kotlin
class CustomSpeedDataType(context: SdkContext) : SdkDataType(context) {
    override val typeId: String = "custom-speed"
    override val displayName: String = "Custom Speed"
    override val description: String = "Shows speed in custom view"
    override val dependencies = listOf(Dependency.SPEED)
    override val sampleValue: Double = 13.0

    override fun newView(): SdkView = CustomSpeedSdkView(context)
    override fun newFormatter(): SdkFormatter = BuiltInFormatter.Numeric(1)
    override fun newTransformer(): SdkTransformer = BuiltInTransformer.Identity(context)
}
```

``` kotlin
class PowerHeartRateDataType(context: SdkContext) : SdkDataType(context) {
    override val typeId: String = "power-hr"
    override val displayName: String = "Power/HR"
    override val description: String = "Ratio of power / heart rate"
    override fun displayIcons(): List<Drawable>? {
        return context.getDrawable(R.drawable.ic_power_hr)?.let { listOf(it) }
    }

    override val dependencies = listOf(Dependency.HEART_RATE, Dependency.POWER)
    override val sampleValue: Double = 1.25

    override fun newView(): SdkView = BuiltInView.Numeric(context)
    override fun newFormatter(): SdkFormatter = BuiltInFormatter.Numeric(2)
    override fun newTransformer(): SdkTransformer = PowerHeartRateTransformer(context)
}
```

