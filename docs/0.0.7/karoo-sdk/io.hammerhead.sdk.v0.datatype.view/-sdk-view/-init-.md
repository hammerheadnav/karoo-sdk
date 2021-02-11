---
title: SdkView.<init> - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype.view](../index.html) / [SdkView](index.html) / [&lt;init&gt;](./-init-.html)

# &lt;init&gt;

`SdkView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`

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

