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

    override fun onUpdate(view: View, value: Double) {
        view.text_speed.text = context.getString(R.string.valid)
        view.numeric_speed.apply {
            visibility = View.VISIBLE
            text = String.format("%.2f", value).reversed()
        }
    }

    override fun onInvalid(view: View) {
        view.text_speed.text = context.getString(R.string.invalid)
        view.numeric_speed.visibility = View.GONE
    }
}
```

**See Also**

[BuiltInView.Numeric](../-built-in-view/-numeric/index.html)

