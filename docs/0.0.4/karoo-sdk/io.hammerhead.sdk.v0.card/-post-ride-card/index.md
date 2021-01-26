---
title: PostRideCard - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.card](../index.html) / [PostRideCard](./index.html)

# PostRideCard

`abstract class PostRideCard`

Definition of a post-ride card view.

``` kotlin
class RideCard(context: SdkContext, rideDetails: RideDetails) : PostRideCard(context, rideDetails) {
    override fun createView(layoutInflater: LayoutInflater, parent: ViewGroup): View {
        val view = layoutInflater.inflate(R.layout.ride_card_view, parent, false)
        view.activityName.text = rideDetails.name
        view.setOnClickListener {
            val detail = Intent().setClassName("io.hammerhead.sample", "io.hammerhead.sample.DetailActivity")
            context.startActivity(detail)
        }
        return view
    }
}
```

### Constructors

| [&lt;init&gt;](-init-.html) | `PostRideCard(context: `[`SdkContext`](../../io.hammerhead.sdk.v0/-sdk-context/index.html)`, rideDetails: `[`RideDetails`](../-ride-details/index.html)`)`<br>Definition of a post-ride card view. |

### Properties

| [context](context.html) | `val context: `[`SdkContext`](../../io.hammerhead.sdk.v0/-sdk-context/index.html)<br>SDK context |
| [rideDetails](ride-details.html) | `val rideDetails: `[`RideDetails`](../-ride-details/index.html)<br>Details for the ride card |

### Functions

| [createView](create-view.html) | `abstract fun createView(layoutInflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`): `[`View`](https://developer.android.com/reference/android/view/View.html)<br>Called to inflate the layout or manually create the view required for this card to show the [rideDetails](ride-details.html). |

