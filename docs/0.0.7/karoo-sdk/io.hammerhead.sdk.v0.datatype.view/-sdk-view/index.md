---
title: SdkView - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype.view](../index.html) / [SdkView](./index.html)

# SdkView

`abstract class SdkView`

Abstract class to extend the way data fields are displayed in ride.

``` kotlin
class CustomSpeedSdkView(context: Context) : SdkView(context) {
    override fun createView(layoutInflater: LayoutInflater, parent: ViewGroup): View {
        return layoutInflater.inflate(R.layout.custom_speed_view, parent, false)
    }

    override fun onUpdate(view: View, value: Double, formattedValue: String?) {
        view.status_text.visibility = View.GONE
        formattedValue?.let {
            view.speed_text.apply {
                visibility = View.VISIBLE
                text = it
            }
        }
        view.speed_gauge.apply {
            visibility = View.VISIBLE
            val progressPct = (value.coerceAtMost(MAX_SPEED) / MAX_SPEED) * 100f
            progress = progressPct.toFloat()
        }
    }

    override fun onInvalid(view: View) {
        view.status_text.apply {
            text = context.getString(R.string.disconnected)
            visibility = View.VISIBLE
        }
        view.speed_text.visibility = View.GONE
        view.speed_gauge.visibility = View.GONE
    }

    companion object {
        private const val MAX_SPEED = 17.0 // mps
    }
}
```

**See Also**

[BuiltInView.Numeric](../-built-in-view/-numeric/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `SdkView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>Abstract class to extend the way data fields are displayed in ride. |

### Properties

| [context](context.html) | `val context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)<br>associated with this custom view |

### Functions

| [createView](create-view.html) | `abstract fun createView(layoutInflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`): `[`View`](https://developer.android.com/reference/android/view/View.html)<br>Called to inflate the layout or manually create the view required to display the [SdkDataType](../../io.hammerhead.sdk.v0.datatype/-sdk-data-type/index.html). |
| [onInvalid](on-invalid.html) | `abstract fun onInvalid(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Called when the data is unavailable or otherwise invalid. |
| [onUpdate](on-update.html) | `open fun ~~onUpdate~~(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`, value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Called when the view should be updated based on the new value from output of the [SdkTransformer](../../io.hammerhead.sdk.v0.datatype.transformer/-sdk-transformer/index.html).`open fun onUpdate(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`, value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, formattedValue: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Called when the view should be updated based on the new value from output of the [SdkTransformer](../../io.hammerhead.sdk.v0.datatype.transformer/-sdk-transformer/index.html) and [SdkFormatter](../../io.hammerhead.sdk.v0.datatype.formatter/-sdk-formatter/index.html) |

### Inheritors

| [BuiltInView](../-built-in-view/index.html) | `sealed class BuiltInView : `[`SdkView`](./index.html) |

