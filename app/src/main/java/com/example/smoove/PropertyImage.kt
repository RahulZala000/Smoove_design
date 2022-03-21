package com.example.smoove

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PropertyImage(
    var path: String,
    var thumbnail: String,
    var type: String,
    var user_id: Int
):Parcelable