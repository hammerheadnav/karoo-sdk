---
title: SdkContext.INTENT_INITIALIZE - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0](../index.html) / [SdkContext](index.html) / [INTENT_INITIALIZE](./-i-n-t-e-n-t_-i-n-i-t-i-a-l-i-z-e.html)

# INTENT_INITIALIZE

`const val INTENT_INITIALIZE: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Broadcast by Karoo System when online initialization should be performed.

`io.hammerhead.sdk.INITIALIZE`

Should be added to manifest with a [android.content.BroadcastReceiver](https://developer.android.com/reference/android/content/BroadcastReceiver.html) to
handle app setup.

``` kotlin
class SdkInitReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Timber.d("SdkInitReceiver: Karoo is ONLINE")
        val sdkContext = SdkContext.buildSdkContext(context)
        if (sdkContext.keyValueStore.getDouble(APP_VAL) == null) {
            Timber.d("Setting initial app val")
            sdkContext.keyValueStore.putDouble(APP_VAL, 111.11)
        }
    }
}
```

