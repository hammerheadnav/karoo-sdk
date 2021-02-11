---
title: SdkDataType.displayIcons - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype](../index.html) / [SdkDataType](index.html) / [displayIcons](./display-icons.html)

# displayIcons

`open fun displayIcons(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Drawable`](https://developer.android.com/reference/android/graphics/drawable/Drawable.html)`>?`

Optional definition of icons used to prefix label in-ride for this field.

Default: null - resulting in standard icon(s) based on dependencies.

``` kotlin
return context.getDrawable(R.drawable.ic_power_hr)?.let { listOf(it) }
```

**See Also**

[dependencies](dependencies.html)

