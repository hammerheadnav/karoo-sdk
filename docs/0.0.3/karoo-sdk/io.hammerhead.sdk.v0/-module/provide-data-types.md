---
title: Module.provideDataTypes - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0](../index.html) / [Module](index.html) / [provideDataTypes](./provide-data-types.html)

# provideDataTypes

`protected abstract fun provideDataTypes(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`SdkDataType`](../../io.hammerhead.sdk.v0.datatype/-sdk-data-type/index.html)`>`

Method for constructing which SDK data types
this module provides. Called when first needed and stored,
therefor this cannot be dynamic.

``` kotlin
return listOf(
    CustomSpeedDataType(context),
    DoubleRideTimeDataType(context),
    AppValDataType(context)
)
```

