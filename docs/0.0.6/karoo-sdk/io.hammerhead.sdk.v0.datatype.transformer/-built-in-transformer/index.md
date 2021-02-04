---
title: BuiltInTransformer - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype.transformer](../index.html) / [BuiltInTransformer](./index.html)

# BuiltInTransformer

`sealed class BuiltInTransformer : `[`SdkTransformer`](../-sdk-transformer/index.html)

### Types

| [Identity](-identity/index.html) | `class Identity : `[`BuiltInTransformer`](./index.html)<br>Built-in transformer which provides the dependencies value input directly to the output |

### Inherited Properties

| [rideState](../-sdk-transformer/ride-state.html) | `var rideState: `[`RideState`](../../io.hammerhead.sdk.v0/-ride-state/index.html)<br>Current ride state |

### Inherited Functions

| [onDependencyChange](../-sdk-transformer/on-dependency-change.html) | `abstract fun onDependencyChange(timeStamp: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, dependencies: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Dependency`](../../io.hammerhead.sdk.v0.datatype/-dependency/index.html)`, `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>Called when a dependency changes and a new output for this field should be calculated or with the last value after a lifecycle change. |

### Inheritors

| [Identity](-identity/index.html) | `class Identity : `[`BuiltInTransformer`](./index.html)<br>Built-in transformer which provides the dependencies value input directly to the output |

