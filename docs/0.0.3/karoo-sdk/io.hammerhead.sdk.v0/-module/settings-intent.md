---
title: Module.settingsIntent - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0](../index.html) / [Module](index.html) / [settingsIntent](./settings-intent.html)

# settingsIntent

`open val settingsIntent: `[`Intent`](https://developer.android.com/reference/android/content/Intent.html)`?`

Optional to set a target intent to open when
settings app selects this module.

Default: null - no click action

``` kotlin
override val settingsIntent: Intent? by lazy {
        Intent().setClassName("io.hammerhead.sample", "io.hammerhead.sample.DetailActivity")
    }
```

