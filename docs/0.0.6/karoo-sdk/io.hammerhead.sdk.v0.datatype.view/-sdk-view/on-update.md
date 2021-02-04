---
title: SdkView.onUpdate - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype.view](../index.html) / [SdkView](index.html) / [onUpdate](./on-update.html)

# onUpdate

`open fun ~~onUpdate~~(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`, value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
**Deprecated:** legacy signature

Called when the view should be updated based on the new value from output of the
[SdkTransformer](../../io.hammerhead.sdk.v0.datatype.transformer/-sdk-transformer/index.html).

Legacy implementation for [onUpdate](./on-update.html) without `formattedValue`.

### Parameters

`view` - original view created from `createView`

`value` - from out put of transformer`open fun onUpdate(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`, value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, formattedValue: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Called when the view should be updated based on the new value from output of the
[SdkTransformer](../../io.hammerhead.sdk.v0.datatype.transformer/-sdk-transformer/index.html) and [SdkFormatter](../../io.hammerhead.sdk.v0.datatype.formatter/-sdk-formatter/index.html)

Preferred implementation for [onUpdate](./on-update.html) with `formattedValue`.

### Parameters

`view` - original view created from `createView`

`value` - from out put of transformer

`formattedValue` - from out put of formatter if specified