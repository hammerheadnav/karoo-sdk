---
title: BuiltInTransformer.Identity.onDependencyChange - karoo-sdk
---

[karoo-sdk](../../../index.html) / [io.hammerhead.sdk.v0.datatype.transformer](../../index.html) / [BuiltInTransformer](../index.html) / [Identity](index.html) / [onDependencyChange](./on-dependency-change.html)

# onDependencyChange

`fun onDependencyChange(timeStamp: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, dependencies: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Dependency`](../../../io.hammerhead.sdk.v0.datatype/-dependency/index.html)`, `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

Overrides [SdkTransformer.onDependencyChange](../../-sdk-transformer/on-dependency-change.html)

Called when a dependency changes and a new output for this field should be calculated
or with the last value after a lifecycle change.

