package com.zhadko.composedemoapp.models

data class Place(
    val id: Int,
    val company_name: String,
    val area_served: String,
    val cover_photo: Image,
    val shop_type: String,
    var favorited: Boolean,
    val follow: Boolean,
    val business_type: String,
    val categories: List<Category>,
    val tags: List<Tag>
)
