---
title: SdkFormatter - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype.formatter](../index.html) / [SdkFormatter](./index.html)

# SdkFormatter

`abstract class SdkFormatter`

Abstract class to extend the way data field is formatted.

``` kotlin
class AppValFormatter : SdkFormatter() {
    override fun formatValue(value: Double): String {
        return "AV:$value"
    }
}
```

**See Also**

[BuiltInFormatter.Numeric](../-built-in-formatter/-numeric/index.html)

[BuiltInFormatter.None](../-built-in-formatter/-none/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `SdkFormatter()`<br>Abstract class to extend the way data field is formatted. |

### Functions

| [formatValue](format-value.html) | `abstract fun formatValue(value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Convert numeric value to textual representation. |

### Inheritors

| [BuiltInFormatter](../-built-in-formatter/index.html) | `sealed class BuiltInFormatter : `[`SdkFormatter`](./index.html) |

