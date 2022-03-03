package com.example.smoove

import android.os.Parcelable
import androidx.navigation.NavType
import kotlinx.android.parcel.Parcelize
@Parcelize
data class HomeListModelItem(
    var id:String?,
    var address_area: String,
    var address_city: String,
    var address_postcode: String,
    var address_street_name: String,
    var bathrooms: Int,
    var bedrooms: Int,
    var deposit_amount: Int,
    var description: String,
    var free_within_days: String,
    var is_suitable_for_student: Int,
    var key_features:List<KeyFeature>,
    var latitude: Double,
    var length_of_stay: String,
    var listing_type: String,
    var longitude: Double,
    var monthly_price: Int,
    var move_in_date: String,
    var nearest_latitude: Double,
    var nearest_location: String,
    var nearest_location_time: String?,
    var nearest_location_type: String,
    var nearest_longitude: Double,
    var person_price: Int,
    var property_images: List<PropertyImage>,
    var property_type: String,
    var property_url: String,
    var room_type: String,
    var status: String,
    var user: User,
):Parcelable