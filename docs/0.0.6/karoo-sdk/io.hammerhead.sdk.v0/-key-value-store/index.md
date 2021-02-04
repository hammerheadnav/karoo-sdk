---
title: KeyValueStore - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0](../index.html) / [KeyValueStore](./index.html)

# KeyValueStore

`class KeyValueStore`

Simple storage of key/value pairs for use by Karoo SDK modules.
This allows modules to store values that need to be persisted
across rides and reboots. Additionally, allows access between
full APK and Karoo SDK plugins and across plugin
instances running within different Karoo apps.

### Functions

| [getDouble](get-double.html) | `fun getDouble(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`?`<br>Get module-specific numeric value based on key. |
| [getString](get-string.html) | `fun getString(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Get module-specific string value based on key. |
| [getToken](get-token.html) | `fun getToken(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Get module-specific token. |
| [putDouble](put-double.html) | `fun putDouble(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Store module-specific numeric value associated with key. |
| [putString](put-string.html) | `fun putString(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Store module-specific string value associated with key. |
| [putToken](put-token.html) | `fun putToken(token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Store module-specific token. |

