---
title: SdkDataType.newFormatter - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype](../index.html) / [SdkDataType](index.html) / [newFormatter](./new-formatter.html)

# newFormatter

`abstract fun newFormatter(): `[`SdkFormatter`](../../io.hammerhead.sdk.v0.datatype.formatter/-sdk-formatter/index.html)

Method to define how the data field is formatted.

Note: not used in case of custom [SdkView](../../io.hammerhead.sdk.v0.datatype.view/-sdk-view/index.html). Should
be defines for use with [BuiltInView.Numeric](../../io.hammerhead.sdk.v0.datatype.view/-built-in-view/-numeric/index.html).

``` kotlin
BuiltInFormatter.Numeric(0)
```

``` kotlin
AppValFormatter()
```

**See Also**

[SdkFormatter](../../io.hammerhead.sdk.v0.datatype.formatter/-sdk-formatter/index.html)

[BuiltInFormatter](../../io.hammerhead.sdk.v0.datatype.formatter/-built-in-formatter/index.html)

