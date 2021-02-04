---
title: SdkDataType - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype](../index.html) / [SdkDataType](./index.html)

# SdkDataType

`abstract class SdkDataType`

Definition of an extended data field to add to the Karoo System.

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

### Constructors

| [&lt;init&gt;](-init-.html) | `SdkDataType(context: `[`SdkContext`](../../io.hammerhead.sdk.v0/-sdk-context/index.html)`)`<br>Definition of an extended data field to add to the Karoo System. |

### Properties

| [aggregateField](aggregate-field.html) | `open val aggregateField: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Optional - determines whether this data type should go idle when not updating or if the value should persist when source is gone or stops producing values. |
| [context](context.html) | `val context: `[`SdkContext`](../../io.hammerhead.sdk.v0/-sdk-context/index.html)<br>SDK context for use within transformers, views, or formatters. |
| [dependencies](dependencies.html) | `open val dependencies: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Dependency`](../-dependency/index.html)`>`<br>Optional definition of zero or more dependent data types. |
| [description](description.html) | `abstract val description: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Long description of this field. |
| [displayName](display-name.html) | `abstract val displayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name used as a title for this data field. |
| [sampleValue](sample-value.html) | `open val sampleValue: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>Option value to show when showing this field in demo mode. |
| [summaryField](summary-field.html) | `open val summaryField: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Optional - determines whether this data type should be included in ride summary. This should only be set to true for data types whose last value should be shown in the ride-review screen. |
| [typeId](type-id.html) | `abstract val typeId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Unique type identifier for this data field. |

### Functions

| [displayIcons](display-icons.html) | `open fun displayIcons(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Drawable`](https://developer.android.com/reference/android/graphics/drawable/Drawable.html)`>?`<br>Optional definition of icons used to prefix label in-ride for this field. |
| [newFormatter](new-formatter.html) | `abstract fun newFormatter(): `[`SdkFormatter`](../../io.hammerhead.sdk.v0.datatype.formatter/-sdk-formatter/index.html)<br>Method to define how the data field is formatted. |
| [newTransformer](new-transformer.html) | `abstract fun newTransformer(): `[`SdkTransformer`](../../io.hammerhead.sdk.v0.datatype.transformer/-sdk-transformer/index.html)<br>Method to define how the data field output is based on dependencies. |
| [newView](new-view.html) | `abstract fun newView(): `[`SdkView`](../../io.hammerhead.sdk.v0.datatype.view/-sdk-view/index.html)<br>Method to define how the data field is displayed. |

