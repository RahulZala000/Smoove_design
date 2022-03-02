package com.example.smoove

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pivot(
    var key_feature_id: Int,
    var property_id: Int
):Parcelable