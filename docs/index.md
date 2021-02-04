---
title: Karoo SDK Quick Start
---

The Karoo SDK can easily be added to an existing Android application. If you
don't already have an Android application, create a new Android project now.

### Dependency Setup

Add jitpack repository to your buildscript in `build.gradle`:
```
repositories {
    jcenter()
    ...
    maven { url "https://jitpack.io" }
}
```

Add Karoo SDK dependency:
```
implementation 'io.hammerhead:karoo-sdk:0.0.6'
```

### Implementation

#### Module

The main declaration required to enable your app to use the Karoo SDK is a [Module](0.0.6/karoo-sdk/io.hammerhead.sdk.v0/-module/index.html)
which includes a `factory` static member variable.

With a [Module](0.0.6/karoo-sdk/io.hammerhead.sdk.v0/-module/index.html) setup, you can now
provide a list of [SdkDataType](0.0.6/karoo-sdk/io.hammerhead.sdk.v0.datatype/-sdk-data-type/index.html) and a
[PostRideCard](0.0.6/karoo-sdk/io.hammerhead.sdk.v0.card/-post-ride-card/index.html) along with
the basic module detail definitions for [name](0.0.6/karoo-sdk/io.hammerhead.sdk.v0/-module/name.html) and [version](0.2.4/karoo-sdk/io.hammerhead.sdk.v0/-module/version.html).

#### Manifest

In order to make your your module visible to the Karoo System,
the following meta data should be added to your `AndroidManifest.xml` within the `<application></application>`.

```
<meta-data
    android:name="io.hammerhead.sdk.v0.SDK_MODULE"
    android:value="io.hammerhead.samplemodule.kotlin.SampleModule" />
```

where `io.hammerhead.samplemodule.kotlin.SampleModule` is replaced with the symbol within your application
that extends [Module](0.0.6/karoo-sdk/io.hammerhead.sdk.v0/-module/index.html) and has a static member `factory` which implements the [ModuleFactoryI](0.2.4/karoo-sdk/io.hammerhead.sdk.v0/-module-factory-i/index.html) interface.

#### Proguard

Because the code referenced in the manifest `SDK_MODULE` is not called by your application directly
but instead is loaded by the Karoo System by class name, it cannot be minified by proguard or
optimized out of your APK build.

To ensure the symbols are included correctly, and the Karoo SDK works within your application,
update your `proguard-rules.pro` to include:
```
-keep class io.hammerhead.samplemodule.** { *; }
```
where `io.hammerhead.samplemodule` is the package which contains your SDK module and
is referenced in meta `SDK_MODULE`.

#### Design Guidelines

This is the kit for creating visual data fields for the Hammerhead Karoo OS. The components in this kit are the building blocks of what make a visual data field functional,  legible, and feel like an integrated part of the Karoo experience.

[Figma Design Guidelines](https://www.figma.com/file/Adr23SlulPNE2RBu1VI28C/H-Visual-Data-Field-System?node-id=0%3A1)
