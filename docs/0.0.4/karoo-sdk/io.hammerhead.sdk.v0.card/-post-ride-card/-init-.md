---
title: PostRideCard.<init> - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.card](../index.html) / [PostRideCard](index.html) / [&lt;init&gt;](./-init-.html)

# &lt;init&gt;

`PostRideCard(context: `[`SdkContext`](../../io.hammerhead.sdk.v0/-sdk-context/index.html)`, rideDetails: `[`RideDetails`](../-ride-details/index.html)`)`

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

