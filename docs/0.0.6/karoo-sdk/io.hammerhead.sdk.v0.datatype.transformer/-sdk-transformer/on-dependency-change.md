---
title: SdkTransformer.onDependencyChange - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype.transformer](../index.html) / [SdkTransformer](index.html) / [onDependencyChange](./on-dependency-change.html)

# onDependencyChange

`abstract fun onDependencyChange(timeStamp: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, dependencies: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Dependency`](../../io.hammerhead.sdk.v0.datatype/-dependency/index.html)`, `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

Called when a dependency changes and a new output for this field should be calculated
or with the last value after a lifecycle change.

