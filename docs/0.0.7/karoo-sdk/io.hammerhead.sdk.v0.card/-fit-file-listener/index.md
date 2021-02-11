---
title: FitFileListener - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.card](../index.html) / [FitFileListener](./index.html)

# FitFileListener

`interface FitFileListener`

Listener interface which is used in [PostRideCard](../-post-ride-card/index.html) to access
FIT file data as it is decoded.

Use with [RideDetailsI.registerFitFileListener](../-ride-details-i/register-fit-file-listener.html) on [PostRideCard](../-post-ride-card/index.html) construction.

### Functions

| [onDescription](on-description.html) | `open fun onDescription(desc: DeveloperFieldDescription): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Called when a [DeveloperFieldDescription](#) is decoded from the FIT file. |
| [onEndDecoding](on-end-decoding.html) | `abstract fun onEndDecoding(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Called when decoding has finished processing all records. No more calls to [onMesg](on-mesg.html) will be made. |
| [onMesg](on-mesg.html) | `abstract fun onMesg(mesg: Mesg): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Called when a [Mesg](#) is decoded from the FIT file. |
| [onMesgDefinition](on-mesg-definition.html) | `open fun onMesgDefinition(mesgDef: MesgDefinition): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Called when a [MesgDefinition](#) is decoded from the FIT file. |
| [onStartDecoding](on-start-decoding.html) | `abstract fun onStartDecoding(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Called when decoding is started. Calls to [onMesg](on-mesg.html) will start. |

