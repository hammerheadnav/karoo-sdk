---
title: PostRideCard - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.card](../index.html) / [PostRideCard](./index.html)

# PostRideCard

`abstract class PostRideCard`

Definition of a post-ride card view.

``` kotlin
class RideCard(context: SdkContext, rideDetails: RideDetailsI) : PostRideCard(context, rideDetails), FitFileListener {
    private val elevationPoints = mutableListOf<Double>()
    private var elevationPointsReady = false
    private var view: View? = null

    init {
        rideDetailsI.registerFitFileListener(this)
    }

    override fun createView(layoutInflater: LayoutInflater, parent: ViewGroup): View {
        val view = layoutInflater.inflate(R.layout.ride_card_view, parent, false)
        rideDetailsI.summaryFields[AppValDataType.TYPE_ID]?.let {
            view.finalAppVal.text = AppValFormatter().formatValue(it)
        }
        view.rideName.text = rideDetailsI.name
        view.setOnClickListener {
            val detail = Intent().setClassName("io.hammerhead.sample", "io.hammerhead.sample.DetailActivity")
            context.startActivity(detail)
        }
        Timber.d("Strava external ID is ${rideDetailsI.externalIds[STRAVA]}")
        if (elevationPointsReady) {
            view.elevationBackground.setPoints(elevationPoints)
        }
        this.view = view
        return view
    }

    override fun onMesg(mesg: Mesg) {
        if (mesg.num == 20) {
            val record = RecordMesg(mesg)
            if (record.hasField(RecordMesg.AltitudeFieldNum)) {
                elevationPoints.add(record.getField(RecordMesg.AltitudeFieldNum).doubleValue)
            }
        }
    }

    override fun onStartDecoding() {
        elevationPoints.clear()
        elevationPointsReady = false
    }

    override fun onEndDecoding() {
        view?.elevationBackground?.setPoints(elevationPoints)
        elevationPointsReady = true
    }
}
```

### Constructors

| [&lt;init&gt;](-init-.html) | `PostRideCard(context: `[`SdkContext`](../../io.hammerhead.sdk.v0/-sdk-context/index.html)`, rideDetailsI: `[`RideDetailsI`](../-ride-details-i/index.html)`)``PostRideCard(context: `[`SdkContext`](../../io.hammerhead.sdk.v0/-sdk-context/index.html)`, rideDetails: `[`RideDetails`](../-ride-details/index.html)`?)`<br>Definition of a post-ride card view. |

### Properties

| [context](context.html) | `val context: `[`SdkContext`](../../io.hammerhead.sdk.v0/-sdk-context/index.html)<br>SDK context |
| [rideDetails](ride-details.html) | `val ~~rideDetails~~: `[`RideDetails`](../-ride-details/index.html)`?`<br>Deprecated - use [rideDetailsI](ride-details-i.html) |
| [rideDetailsI](ride-details-i.html) | `lateinit var rideDetailsI: `[`RideDetailsI`](../-ride-details-i/index.html) |

### Functions

| [createView](create-view.html) | `abstract fun createView(layoutInflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`): `[`View`](https://developer.android.com/reference/android/view/View.html)<br>Called to inflate the layout or manually create the view required for this card to show the [rideDetailsI](ride-details-i.html). |

