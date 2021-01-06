---
title: SdkDataType - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype](../index.html) / [SdkDataType](./index.html)

# SdkDataType

`abstract class SdkDataType`

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

### Constructors

| [&lt;init&gt;](-init-.html) | `SdkDataType(context: `[`SdkContext`](../../io.hammerhead.sdk.v0/-sdk-context/index.html)`)`<br>Definition of an extended data field to add to the Karoo System. |

### Properties

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

