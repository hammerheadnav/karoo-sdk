---
title: Dependency - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype](../index.html) / [Dependency](./index.html)

# Dependency

`enum class Dependency`

Enumeration of possible dependencies for [SdkDataType](../-sdk-data-type/index.html).

Provided as a list in [SdkDataType.dependencies](../-sdk-data-type/dependencies.html)

### Enum Values

| [SPEED](-s-p-e-e-d.html) | Dependency on highest-priority sensor providing speed in m/s. |
| [POWER](-p-o-w-e-r.html) | Dependency on highest-priority sensor providing power in W. |
| [CADENCE](-c-a-d-e-n-c-e.html) | Dependency on highest-priority sensor providing cadence in rpm. |
| [HEART_RATE](-h-e-a-r-t_-r-a-t-e.html) | Dependency on highest-priority sensor providing heart rate in bpm. |
| [RIDE_TIME](-r-i-d-e_-t-i-m-e.html) | Dependency on active riding time of recording in ms, stops when paused. |
| [ELAPSED_TIME](-e-l-a-p-s-e-d_-t-i-m-e.html) | Dependency on elapsed time recording in ms, continues while paused. |
| [INTERVAL](-i-n-t-e-r-v-a-l.html) | Special dependency with no values but used to ensure [SdkTransformer.onDependencyChange](../../io.hammerhead.sdk.v0.datatype.transformer/-sdk-transformer/on-dependency-change.html) is called at a rate of 1Hz |

