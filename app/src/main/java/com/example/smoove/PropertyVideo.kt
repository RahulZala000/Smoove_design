package com.example.smoove

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PropertyVideo(
    var id: String,
    var path: String,
    var property_id: String,
    var thumbnail: String,
    var type: String,
    var user_id: String
):Parcelable