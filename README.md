# Karoo SDK

## References

[Quick Start](https://hammerheadnav.github.io/karoo-sdk/index.html)

[API Documentation](https://hammerheadnav.github.io/karoo-sdk/0.0.7/karoo-sdk/index.html)

[Jitpack Build](https://jitpack.io/#io.hammerhead/karoo-sdk)

[Design Guidelines](https://www.figma.com/file/Adr23SlulPNE2RBu1VI28C/H-Visual-Data-Field-System?node-id=0%3A1)

## Sample App

Within [sample/](sample/), a sample application with Karoo SDK integration is provided with
examples for various extensions that can be added to Karoo.

The sample module is provided as Java and Kotlin code, both implementing the same 3
data types:
1. `AppVal` - Shows value from Key/Value store set in [MainActivity](sample/src/main/java/io/hammerhead/sample/MainActivity.kt).
1. `Custom Speed` - Uses speed dependency with a custom view to display it.
1. `Power/HR` - Uses a transformer to display ratio of Power/HR with built-in numeric view and formatting.

Additionally, the sample modules (Java and Kotlin) create a simple post-ride card that show
the activity name in a purple box.

To install the basic sample app:
```bash
./gradlew sample:installDebug
```

### Sample Kotlin Module

The Kotlin sample module is available in [sample/src/main/java/io/hammerhead/samplemodule/kotlin](sample/src/main/java/io/hammerhead/samplemodule/kotlin)
This is a good starting point or reference if you have an existing Android app written in Kotlin.

### Sample Java Module

The Java sample module is available in [sample/src/main/java/io/hammerhead/samplemodule/java](sample/src/main/java/io/hammerhead/samplemodule/java).
This is a good starting point or reference if you have an existing Android app written in Java.

### Screenshots

![SDK fields in ride](screenshots/ride.png?raw=true "SDK fields in ride")
![SDK fields in editor](screenshots/pages-preview.png?raw=true "SDK fields in editor")
![SDK field selection](screenshots/pages-select.png?raw=true "SDK field selection")
![SDK post-ride card](screenshots/post-ride.png?raw=true "SDK Post-Ride Card")
