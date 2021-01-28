---
title: BuiltInTransformer.Identity - karoo-sdk
---

[karoo-sdk](../../../index.html) / [io.hammerhead.sdk.v0.datatype.transformer](../../index.html) / [BuiltInTransformer](../index.html) / [Identity](./index.html)

# Identity

`class Identity : `[`BuiltInTransformer`](../index.html)

Built-in transformer which provides the dependencies value input directly to the output

### Constructors

| [&lt;init&gt;](-init-.html) | `Identity(context: `[`SdkContext`](../../../io.hammerhead.sdk.v0/-sdk-context/index.html)`)`<br>Built-in transformer which provides the dependencies value input directly to the output |

### Functions

| [onDependencyChange](on-dependency-change.html) | `fun onDependencyChange(timeStamp: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, dependencies: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Dependency`](../../../io.hammerhead.sdk.v0.datatype/-dependency/index.html)`, `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>Called when a dependency changes and a new output for this field should be calculated or with the last value after a lifecycle change. |

