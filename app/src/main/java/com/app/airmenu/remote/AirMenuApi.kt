package com.app.airmenu.remote

import com.app.airmenu.models.GoogleAddress
import com.app.airmenu.models.LoginResponse
import com.app.airmenu.utils.PLACES_API_KEY
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.*

interface AirMenuApi {

    @FormUrlEncoded
    @POST("AirMenuAPI")
    suspend fun login(
        @Field("ACTION") action: String,
        @Field("VERSION") version: String,
        @Field("KEY") key: String,
        @Field("DATA") data: String
    ): Response<ResponseBody>

    @FormUrlEncoded
    @POST("AirMenuAPI")
    suspend fun posIds(
        @Field("ACTION") action: String,
        @Field("VERSION") version: String,
        @Field("KEY") key: String,
        @Field("DATA") data: String
    ): Response<ResponseBody>

    @FormUrlEncoded
    @POST("AirMenuAPI")
    suspend fun updateFlags(
        @Field("ACTION") action: String,
        @Field("VERSION") version: String,
        @Field("KEY") key: String,
        @Field("DATA") data: JSONObject
    ): Response<ResponseBody>

    @FormUrlEncoded
    @POST("AirMenuAPI")
    suspend fun notificationAccess(
        @Field("ACTION") action: String,
        @Field("VERSION") version: String,
        @Field("KEY") key: String,
        @Field("DATA") data: String
    ): Response<ResponseBody>

   @FormUrlEncoded
    @POST("AirMenuAPI")
    suspend fun devisionIds(
        @Field("ACTION") action: String,
        @Field("VERSION") version: String,
        @Field("KEY") key: String,
        @Field("DATA") data: String
    ): Response<ResponseBody>

    @FormUrlEncoded
    @POST("AirMenuAPI")
    suspend fun getLocationDivisionEnterprises(
        @Field("ACTION") action: String,
        @Field("VERSION") version: String,
        @Field("KEY") key: String,
        @Field("DATA") data: String
    ): Response<ResponseBody>

  @FormUrlEncoded
    @POST("AirMenuAPI")
    suspend fun createUser(
        @Field("ACTION") action: String,
        @Field("VERSION") version: String,
        @Field("KEY") key: String,
        @Field("DATA") data: JSONObject
    ): Response<ResponseBody>

    @GET("AirMenuAPI")
    suspend fun getOrders(
        @Query("ACTION") action: String,
        @Query("VERSION") version: String,
        @Query("KEY") key: String,
        @Query("DATA") data: JSONObject
    ): Response<ResponseBody>

    @FormUrlEncoded
    @POST("AirMenuAPI")
    suspend fun createOrder(
        @Field("ACTION") action: String,
        @Field("VERSION") version: String,
        @Field("KEY") key: String,
        @Field("DATA") data: JSONObject
    ): Response<ResponseBody>

    @FormUrlEncoded
    @POST("AirMenuAPI")
    suspend fun createMenu(
        @Field("ACTION") action: String,
        @Field("VERSION") version: String,
        @Field("KEY") key: String,
        @Field("DATA") data: JSONObject
    ): Response<ResponseBody>

    @GET("https://maps.googleapis.com/maps/api/place/details/json")
    suspend fun getAddressById(@Query("placeid") orderId: String,@Query("key") key:String):Response<GoogleAddress>
}