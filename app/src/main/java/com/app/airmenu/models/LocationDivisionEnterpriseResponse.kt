package com.app.airmenu.models


import com.google.gson.annotations.SerializedName

class LocationDivisionEnterpriseResponse(
    @SerializedName("action")
    val action: String,
    @SerializedName("foundDivisions")
    val foundDivisions: List<String>,
    @SerializedName("foundDivisionsIdAndName")
    val foundDivisionsIdAndName: List<FoundDivisionsIdAndName>,
    @SerializedName("foundEnterprises")
    val foundEnterprises: List<Any>,
    @SerializedName("status")
    val status: String,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("version")
    val version: String
) {
    class FoundDivisionsIdAndName(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String
    )
}