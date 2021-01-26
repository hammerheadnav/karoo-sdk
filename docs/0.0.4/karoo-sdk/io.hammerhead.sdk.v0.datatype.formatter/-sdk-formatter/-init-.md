---
title: SdkFormatter.<init> - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.datatype.formatter](../index.html) / [SdkFormatter](index.html) / [&lt;init&gt;](./-init-.html)

# &lt;init&gt;

`SdkFormatter()`

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

