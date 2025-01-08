package com.app.airmenu.network.response


import com.google.gson.annotations.SerializedName

class StoreDetails(
    @SerializedName("avg_prep_time")
    val avgPrepTime: Int,
    @SerializedName("contact_emails")
    val contactEmails: List<Any>,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String,
    @SerializedName("price_bucket")
    val priceBucket: String,
    @SerializedName("raw_hero_url")
    val rawHeroUrl: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("store_id")
    val storeId: String,
    @SerializedName("timezone")
    val timezone: String
) {
    class Location(
        @SerializedName("address")
        val address: String,
        @SerializedName("address_2")
        val address2: String,
        @SerializedName("city")
        val city: String,
        @SerializedName("country")
        val country: String,
        @SerializedName("latitude")
        val latitude: Double,
        @SerializedName("longitude")
        val longitude: Double,
        @SerializedName("postal_code")
        val postalCode: String,
        @SerializedName("state")
        val state: String
    )
}