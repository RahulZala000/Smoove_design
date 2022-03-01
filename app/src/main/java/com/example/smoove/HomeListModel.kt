package com.example.smoove

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeListModel(var properties:ArrayList<HomeListModelItem>):Parcelable