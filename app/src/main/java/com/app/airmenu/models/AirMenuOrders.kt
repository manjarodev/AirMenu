package com.app.airmenu.models


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import org.json.JSONObject
import java.util.*

class AirMenuOrders(
    @SerializedName("action")
    val action: String,
    @SerializedName("orders")
    val orders: Orders,
    @SerializedName("status")
    val status: String,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("version")
    val version: String,
    @SerializedName("errorName")
    val errorName: String,
    @SerializedName("property")
    val property: String
) {
    class Orders(
        @SerializedName("Pakistan")
        val pakistan: List<Pakistan>,
        @SerializedName("USA")
        val usa: List<USA>,
        @SerializedName("UK")
        val uk: List<OrdDtl>,
        @SerializedName("Porto")
        val porto: List<Porto>,
        @SerializedName("Lisbon")
        val lisbon: List<Porto>
    ) {

        class Pakistan(
            @SerializedName("activeFlags")
            val activeFlags: List<ActiveFlag>,
            @SerializedName("available")
            val available: Boolean,
            @SerializedName("childs")
            val childs: List<Child>,
            @SerializedName("extraInfo")
            val extraInfo: List<Object>,
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
                @SerializedName("date")
                val date: String,
                @SerializedName("time")
                val time: String
            )
        }
        class USA(
            @SerializedName("activeFlags")
            val activeFlags: List<ActiveFlag>,
            @SerializedName("available")
            val available: Boolean,
            @SerializedName("childs")
            val childs: List<Child>,
            @SerializedName("extraInfo")
            val extraInfo: List<Object>,
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
                @SerializedName("date")
                val date: String,
                @SerializedName("time")
                val time: String
            )
        }
        class OrdDtl(
            @SerializedName("activeFlags")
            val activeFlags: List<ActiveFlag>,
            @SerializedName("available")
            val available: Boolean,
            @SerializedName("childs")
            val childs: List<Child>,
            @SerializedName("extraInfo")
            val extraInfo: List<Object>,
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
            class ExtraInfo1(
                @SerializedName("date")
                val date: String,
                @SerializedName("time")
                val time: String
            )

            class ExtraInfo3(
                @SerializedName("address")
                val address: String,
                @SerializedName("city")
                val city: String,
                @SerializedName("complement")
                val complement: String,
                @SerializedName("latitude")
                val latitude: String,
                @SerializedName("longitude")
                val longitude: String,
                @SerializedName("number")
                val number: String,
                @SerializedName("phone")
                val phone: String,
                @SerializedName("phone2")
                val phone2: String,
                @SerializedName("postalCode")
                val postalCode: String,
                @SerializedName("referencePoint")
                val referencePoint: String,
                @SerializedName("timezone")
                val timezone: String,
                @SerializedName("UK")
                val uK: String
            )
        }
        class Porto(
            @SerializedName("activeFlags")
            val activeFlags: List<ActiveFlag>,
            @SerializedName("available")
            val available: Boolean,
            @SerializedName("childs")
            val childs: List<Child>,
            @SerializedName("extraInfo")
            val extraInfo: List<Object>,
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
                @SerializedName("date")
                val date: String,
                @SerializedName("time")
                val time: String
            )
            class ExtraInfo2(
                @SerializedName("date")
                val date: String,
                @SerializedName("time")
                val time: String
            )
        }

    }



}


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