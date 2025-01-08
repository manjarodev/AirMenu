package com.app.airmenu.models


import com.google.gson.annotations.SerializedName

data class GoogleAddress(
    @SerializedName("html_attributions")
    val htmlAttributions: List<Any>,
    @SerializedName("result")
    val result: Result,
    @SerializedName("status")
    val status: String
) {
    data class Result(
        @SerializedName("address_components")
        val addressComponents: List<AddressComponent>,
        @SerializedName("adr_address")
        val adrAddress: String,
        @SerializedName("formatted_address")
        val formattedAddress: String,
        @SerializedName("geometry")
        val geometry: Geometry,
        @SerializedName("icon")
        val icon: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("place_id")
        val placeId: String,
        @SerializedName("plus_code")
        val plusCode: PlusCode,
        @SerializedName("reference")
        val reference: String,
        @SerializedName("types")
        val types: List<String>,
        @SerializedName("url")
        val url: String,
        @SerializedName("utc_offset")
        val utcOffset: Int,
        @SerializedName("vicinity")
        val vicinity: String
    ) {
        data class AddressComponent(
            @SerializedName("long_name")
            val longName: String,
            @SerializedName("short_name")
            val shortName: String,
            @SerializedName("types")
            val types: List<String>
        )

        data class Geometry(
            @SerializedName("location")
            val location: Location,
            @SerializedName("viewport")
            val viewport: Viewport
        ) {
            data class Location(
                @SerializedName("lat")
                val lat: Double,
                @SerializedName("lng")
                val lng: Double
            )

            data class Viewport(
                @SerializedName("northeast")
                val northeast: Northeast,
                @SerializedName("southwest")
                val southwest: Southwest
            ) {
                data class Northeast(
                    @SerializedName("lat")
                    val lat: Double,
                    @SerializedName("lng")
                    val lng: Double
                )

                data class Southwest(
                    @SerializedName("lat")
                    val lat: Double,
                    @SerializedName("lng")
                    val lng: Double
                )
            }
        }

        data class PlusCode(
            @SerializedName("compound_code")
            val compoundCode: String,
            @SerializedName("global_code")
            val globalCode: String
        )
    }
}