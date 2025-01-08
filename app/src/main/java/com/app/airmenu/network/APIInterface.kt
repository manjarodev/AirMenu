package com.imprint.app.network

import com.app.airmenu.network.response.*
import com.app.airmenu.network.response.RestaurantStatus
import com.app.airmenu.utils.*
import com.google.gson.JsonElement
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface APIInterface {

    @FormUrlEncoded
    @POST("")
    fun getOrderToken(
        @Url url: String? = UBER_AUTH_URL,
        @Field(KEY_CLIENT_ID) id: String? = UBER_CLIENT_ID,
        @Field(KEY_CLIENT_SECRET) secret: String? = UBER_CLIENT_SECRET,
        @Field(KEY_GRANT_TYPE) grantType: String? = GRANT_TYPE,
        @Field(KEY_SCOPE) scope: String
    ): Call<TokenResponse>

    @GET("/v1/eats/stores?limit=10")
    fun getMerchantStores(): Call<UberStores>

    @FormUrlEncoded
    @POST("")
    fun getAccessToken(
        @Url url: String? = UBER_AUTH_URL,
        @Field(KEY_CLIENT_ID) id: String? = UBER_CLIENT_ID,
        @Field(KEY_CLIENT_SECRET) secret: String? = UBER_CLIENT_SECRET,
        @Field(KEY_GRANT_TYPE) grantType: String? = GRANT_TYPE,
        @Field("code") code: String,
        @Field("redirect_uri") redirecet_uri: String
    ): Call<TokenResponse>


    @GET("/v2/eats/order/{order_id}")
    fun getOrderDetails(
        @Path(
            value = "order_id",
            encoded = true
        ) orderId: String
    ): Call<OrderDetail>

    @POST("/v1/eats/stores/{store_id}/pos_data")
    fun setupPOS(
        @Path(value = "store_id", encoded = true) storeId: String,
        @Body body: JSONObject
    ): Call<ResponseBody>

    @GET("/v1/eats/stores/{store_id}/pos_data")
    fun getPOSStatus(@Path(value = "store_id", encoded = true) storeId: String): Call<POSStatus>

    @PATCH("/v1/eats/stores/{store_id}/pos_data")
    fun updatePOSStatus(
        @Path(value = "store_id", encoded = true) storeId: String,
        @Body body: RequestBody
    ): Call<POSStatus>

    @DELETE("/v1/eats/stores/{store_id}/pos_data")
    fun deProisionStore(
        @Path(
            value = "store_id",
            encoded = true
        ) storeId: String
    ): Call<ResponseBody>

    @POST("/v1/eats/orders/{order_id}/accept_pos_order")
    fun acceptOrder(
        @Path(value = "order_id", encoded = true) orderId: String,
        @Body body: JSONObject
    ): Call<com.squareup.okhttp.ResponseBody>

    @POST("/v1/eats/orders/{order_id}/deny_pos_order")
    fun denyOrder(
        @Path(value = "order_id", encoded = true) orderId: String,
        @Body body: RequestBody
    ): Call<com.squareup.okhttp.ResponseBody>

    @POST("/v1/eats/orders/{order_id}/cancel")
    fun cancelOrder(
        @Path(value = "order_id", encoded = true) orderId: String,
        @Body body: RequestBody
    ): Call<com.squareup.okhttp.ResponseBody>

    @POST()
    fun login(
        @Field("ACTION") action: String,
        @Field("VERSION") version: String,
        @Field("KEY") key: String,
        @Field("DATA") data: String
    ): Response<ResponseBody>

    @POST("/v1/eats/store/{store_id}/status")
    fun setRestaurantStatus(
        @Path(value = "store_id", encoded = true) storeId: String, @Body body: RequestBody
    ): Call<POSAvailability>

    @GET("/v1/eats/store/{store_id}/status")
    fun getRestaurantStatus(
        @Path(value = "store_id", encoded = true) storeId: String
    ): Call<RestaurantStatus>

    @POST("/v1/eats/orders/{order_id}/restaurantdelivery/status")
    fun updateDeliveryStatus(
        @Path(value = "order_id", encoded = true) orderId: String,
        @Body body: RequestBody
    ): Call<com.squareup.okhttp.ResponseBody>

    @GET("/v1/eats/stores/{store_id}")
    fun getStoreDetails(
        @Path(value = "store_id", encoded = true) storeId: String,
    ): Call<StoreDetails>


}