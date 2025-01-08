package com.app.airmenu.models


import com.google.gson.annotations.SerializedName

class OrderResponseAirMenu(
    @SerializedName("action")
    val action: String,
    @SerializedName("orders")
    val orders: Orders,
    @SerializedName("status")
    val status: String,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("version")
    val version: String
) {
    class Orders(
        @SerializedName("UK")
        val uK: List<UK>
    ) {
        class UK(
            @SerializedName("activeFlags")
            val activeFlags: List<ActiveFlag>,
            @SerializedName("available")
            val available: Boolean,
            @SerializedName("childs")
            val childs: List<Child>,
            @SerializedName("extraInfo")
            val extraInfo: List<ExtraInfo>,
            @SerializedName("firstName")
            val firstName: String,
            @SerializedName("lastName")
            val lastName: String,
            @SerializedName("menuRelation")
            val menuRelation: String,
            @SerializedName("orderCounter")
            val orderCounter: Int,
            @SerializedName("orderDate")
            val orderDate: Long,
            @SerializedName("orderId")
            val orderId: Int,
            @SerializedName("paymentMethod")
            val paymentMethod: String,
            @SerializedName("plu")
            val plu: String,
            @SerializedName("title")
            val title: String,
            @SerializedName("trackingUrl")
            val trackingUrl: String,
            @SerializedName("userId")
            val userId: String,
            @SerializedName("username")
            val username: String
        ) {
            class ActiveFlag(
                @SerializedName("datetime")
                val datetime: Long,
                @SerializedName("key")
                val key: String,
                @SerializedName("operator")
                val operator: String,
                @SerializedName("operatorEmail")
                val operatorEmail: String,
                @SerializedName("orderId")
                val orderId: String
            )

            class Child(
                @SerializedName("available")
                val available: Boolean,
                @SerializedName("childs")
                val childs: List<Any>,
                @SerializedName("count")
                val count: Int,
                @SerializedName("extraInfo")
                val extraInfo: List<ExtraInfo>,
                @SerializedName("id")
                val id: String,
                @SerializedName("menuRelation")
                val menuRelation: String,
                @SerializedName("plu")
                val plu: String,
                @SerializedName("price")
                val price: Double,
                @SerializedName("title")
                val title: String
            ) {
                class ExtraInfo(
                    @SerializedName("desc")
                    val desc: String
                )
            }

            class ExtraInfo(
                @SerializedName("ADDRESS")
                val aDDRESS: String,
                @SerializedName("address")
                val address: String,
                @SerializedName("CAPACITY")
                val cAPACITY: String,
                @SerializedName("city")
                val city: String,
                @SerializedName("complement")
                val complement: String,
                @SerializedName("date")
                val date: String,
                @SerializedName("ITEM_AVAILABILITY")
                val iTEMAVAILABILITY: String,
                @SerializedName("latitude")
                val latitude: String,
                @SerializedName("longitude")
                val longitude: String,
                @SerializedName("MISSING_INFO")
                val mISSINGINFO: String,
                @SerializedName("MISSING_ITEM")
                val mISSINGITEM: String,
                @SerializedName("number")
                val number: String,
                @SerializedName("OTHER")
                val oTHER: String,
                @SerializedName("POS_NOT_READY")
                val pOSNOTREADY: String,
                @SerializedName("POS_OFFLINE")
                val pOSOFFLINE: String,
                @SerializedName("PRICING")
                val pRICING: String,
                @SerializedName("phone")
                val phone: String,
                @SerializedName("phone2")
                val phone2: String,
                @SerializedName("postalCode")
                val postalCode: String,
                @SerializedName("referencePoint")
                val referencePoint: String,
                @SerializedName("SPECIAL_INSTRUCTIONS")
                val sPECIALINSTRUCTIONS: String,
                @SerializedName("STORE_CLOSED")
                val sTORECLOSED: String,
                @SerializedName("time")
                val time: String,
                @SerializedName("timezone")
                val timezone: String,
                @SerializedName("UK")
                val uK: String
            )
        }
    }
}