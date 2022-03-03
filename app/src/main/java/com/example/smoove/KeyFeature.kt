package com.example.smoove

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class KeyFeature(
    var color_icon: String,
    var color_icon_url: String,
    var name: String,
):Parcelable