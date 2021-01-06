---
title: Module.<init> - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0](../index.html) / [Module](index.html) / [&lt;init&gt;](./-init-.html)

# &lt;init&gt;

`Module(context: `[`SdkContext`](../-sdk-context/index.html)`)`

Karoo SDK Module

``` kotlin
class SampleModule(context: SdkContext) : Module(context) {
    override val name: String = "sample"
    override val version: String = "1.0"
    override val settingsIntent: Intent? by lazy {
        Intent().setClassName("io.hammerhead.sample", "io.hammerhead.sample.DetailActivity")
    }

    override fun onStart(): Boolean {
        Timber.i("SampleModule received ride start event")
        return false
    }

    override fun provideDataTypes(): List<SdkDataType> {
        return listOf(
            CustomSpeedDataType(context),
            DoubleRideTimeDataType(context),
            AppValDataType(context)
        )
    }

    override fun postRideCard(details: RideDetails): PostRideCard? {
        return RideCard(context, details)
    }

    companion object {
        @JvmField
        val factory = object : ModuleFactoryI {
            override fun buildModule(context: SdkContext): Module {
                return SampleModule(context)
            }
        }
    }
}
```

### Parameters

`context` - provided by the Karoo System when loading the module