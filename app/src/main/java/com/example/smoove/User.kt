package com.example.smoove

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var id: String,
    var name: String,
    var profile_image: String?,
    var profile_image_url: String?
):Parcelable