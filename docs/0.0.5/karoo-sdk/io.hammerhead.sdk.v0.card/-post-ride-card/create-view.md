---
title: PostRideCard.createView - karoo-sdk
---

[karoo-sdk](../../index.html) / [io.hammerhead.sdk.v0.card](../index.html) / [PostRideCard](index.html) / [createView](./create-view.html)

# createView

`protected abstract fun createView(layoutInflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`): `[`View`](https://developer.android.com/reference/android/view/View.html)

Called to inflate the layout or manually create the view
required for this card to show the [rideDetails](ride-details.html).

### Parameters

`layoutInflater` - to be used for calls to [LayoutInflater.inflate](https://developer.android.com/reference/android/view/LayoutInflater.html#inflate(int, android.view.ViewGroup)) to ensure
access to resources from module's containing APK

`parent` - the parent layout of the view being inflated