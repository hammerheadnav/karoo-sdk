---
title: RideDetailsI - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.card](../index.html) / [RideDetailsI](./index.html)

# RideDetailsI

`interface RideDetailsI`

Access to details from a recorded ride.

Can be used to show custom post-ride card with [PostRideCard](../-post-ride-card/index.html).

### Properties

| [distance](distance.html) | `abstract val distance: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>Ride distance in meters |
| [duration](duration.html) | `abstract val duration: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Ride duration in ms. |
| [externalIds](external-ids.html) | `abstract val externalIds: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>External IDs that have been successfully synced. Keys will be one of: [STRAVA](-s-t-r-a-v-a.html), [TRAINING_PEAKS](-t-r-a-i-n-i-n-g_-p-e-a-k-s.html), [KOMOOT](-k-o-m-o-o-t.html), [RIDE_WITH_GPS](-r-i-d-e_-w-i-t-h_-g-p-s.html), [XERT](-x-e-r-t.html). |
| [id](id.html) | `abstract val id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Hammerhead Ride ID |
| [name](name.html) | `abstract val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Ride name |
| [summaryFields](summary-fields.html) | `abstract val summaryFields: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>`<br>Map of summary fields (SdkDataType where summaryField is true) to last double value produced from ride. |

### Functions

| [registerFitFileListener](register-fit-file-listener.html) | `abstract fun registerFitFileListener(listener: `[`FitFileListener`](../-fit-file-listener/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Called to register a listener for access to FIT file records for this ride as they are decoded. |

### Companion Object Properties

| [KOMOOT](-k-o-m-o-o-t.html) | `val KOMOOT: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Value representing string key for Komoot in `externalIds` |
| [RIDE_WITH_GPS](-r-i-d-e_-w-i-t-h_-g-p-s.html) | `val RIDE_WITH_GPS: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Value representing string key for RideWithGPS in `externalIds` |
| [STRAVA](-s-t-r-a-v-a.html) | `val STRAVA: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Value representing string key for Strava in `externalIds` |
| [TRAINING_PEAKS](-t-r-a-i-n-i-n-g_-p-e-a-k-s.html) | `val TRAINING_PEAKS: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Value representing string key for TrainingPeaks in `externalIds` |
| [XERT](-x-e-r-t.html) | `val XERT: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Value representing string key for Xert in `externalIds` |

