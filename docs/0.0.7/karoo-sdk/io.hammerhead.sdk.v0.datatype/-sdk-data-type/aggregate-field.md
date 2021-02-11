---
title: SdkDataType.aggregateField - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype](../index.html) / [SdkDataType](index.html) / [aggregateField](./aggregate-field.html)

# aggregateField

`open val aggregateField: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Optional - determines whether this data type should
go idle when not updating or if the value should persist
when source is gone or stops producing values.

Default: false - indicating instantaneous field which becomes idle

