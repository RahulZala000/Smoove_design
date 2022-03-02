package com.example.smoove

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class KeyFeature(
    var color_icon: String,
    var color_icon_url: String,
    var dark_icon: String,
    var dark_icon_url: String,
    var id: Int,
    var name: String,
    var pivot: Pivot,
    var type: String
):Parcelable