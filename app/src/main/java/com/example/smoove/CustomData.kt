package com.example.smoove

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CustomData(
    var address_area: String,
    var address_city: String,
    var address_country_code: String,
    var address_postcode: String,
    var address_street_name: String,
    var bathrooms: Int,
    var bedrooms: Int,
    var current_flatmates: Int,
    var deposit_amount: Int,
    var description: String,
    var free_to_contact: String,
    var free_within_days: String,
    var id: Int,
    var is_free_to_contact: Boolean,
    var is_suitable_for_student: Int,
    var latitude: Double,
    var length_of_stay: String,
    var listing_type: String,
    var longitude: Double,
    var monthly_price: Int,
    var move_in_date: String,
    var nearest_latitude: Double,
    var nearest_location: String,
    var nearest_location_time: String,
    var nearest_location_type: String,
    var nearest_longitude: Double,
    var person_price: Int,
    var property_type: String,
    var property_url: String,
    var room_type: String,
    var slug: String,
    var status: String,
    var type: String,
    var updated_at: String,
    var updated_by: Int,
    var user_id: Int
):Parcelable