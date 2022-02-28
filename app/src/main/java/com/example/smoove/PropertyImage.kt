package com.example.smoove

data class PropertyImage(
    var id: Int,
    var path: String,
    var property_id: Int,
    var thumbnail: String,
    var type: String,
    var user_id: Int
)