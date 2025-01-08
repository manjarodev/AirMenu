package com.app.airmenu.models


import com.google.gson.annotations.SerializedName

class DivisionIdsResponse(
    @SerializedName("action")
    val action: String,
    @SerializedName("divisionTree")
    val divisionTree: List<DivisionTree>,
    @SerializedName("divisions")
    val divisions: Divisions,
    @SerializedName("status")
    val status: String,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("version")
    val version: String
) {
    class DivisionTree(
        @SerializedName("childDivisions")
        val childDivisions: List<ChildDivision>,
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String
    ) {
        class ChildDivision(
            @SerializedName("id")
            val id: String,
            @SerializedName("name")
            val name: String
        )
    }

    class Divisions(
        @SerializedName("Lisbon")
        val lisbon: String,
        @SerializedName("Pakistan")
        val pakistan: String,
        @SerializedName("Porto")
        val porto: String,
        @SerializedName("USA")
        val uSA: String
    )
}