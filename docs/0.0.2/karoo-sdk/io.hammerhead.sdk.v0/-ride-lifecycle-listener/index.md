---
title: RideLifecycleListener - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0](../index.html) / [RideLifecycleListener](./index.html)

# RideLifecycleListener

`interface RideLifecycleListener`

Interface which is called for lifecycle events related to ride.

### Functions

| [onEnd](on-end.html) | `open fun onEnd(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Lifecycle event hook for when ride stops recording. |
| [onLap](on-lap.html) | `open fun onLap(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Lifecycle event hook for when ride lap resets. |
| [onPause](on-pause.html) | `open fun onPause(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Lifecycle event hook for when ride is paused. |
| [onResume](on-resume.html) | `open fun onResume(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Lifecycle event hook for when ride is resumed. |
| [onStart](on-start.html) | `open fun onStart(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Lifecycle event hook for when ride starts recording. |

### Inheritors

| [Module](../-module/index.html) | `abstract class Module : `[`RideLifecycleListener`](./index.html)<br>Karoo SDK Module |
| [SdkTransformer](../../io.hammerhead.sdk.v0.datatype.transformer/-sdk-transformer/index.html) | `abstract class SdkTransformer : `[`RideLifecycleListener`](./index.html)<br>Abstract class to extend the way data field is formatted. |

