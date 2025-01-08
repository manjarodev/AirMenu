package com.app.airmenu.remote

import com.app.airmenu.models.GoogleAddress
import com.app.airmenu.utils.PLACES_API_KEY
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val api: AirMenuApi) {

    suspend fun loginWithCredentials(
        action: String,
        version: String,
        key: String,
        data: String
    ) = api.login(
        action,
        version,
        key,
        data
    )

    suspend fun getPosIds(
        action: String,
        version: String,
        key: String,
        data: String
    ) = api.posIds(
        action,
        version,
        key,
        data
    )

    suspend fun updateFlags(
        action: String,
        version: String,
        key: String,
        data: JSONObject
    ) = api.updateFlags(
        action,
        version,
        key,
        data
    )
    suspend fun getOrders(
        action: String,
        version: String,
        key: String,
        data: JSONObject
    ) = api.getOrders(
        action,
        version,
        key,
        data
    )

    suspend fun placeOrder(
        action: String,
        version: String,
        key: String,
        data: JSONObject
    ) = api.createOrder(
        action,
        version,
        key,
        data
    )

    suspend fun createMenu(
        action: String,
        version: String,
        key: String,
        data: JSONObject
    ) = api.createMenu(
        action,
        version,
        key,
        data
    )

    suspend fun getDivisionIds(
        action: String,
        version: String,
        key: String,
        data: String
    ) = api.devisionIds(
        action,
        version,
        key,
        data
    )

    suspend fun getLocationDivisionEnterprises(
        action: String,
        version: String,
        key: String,
        data: String
    ) = api.getLocationDivisionEnterprises(
        action,
        version,
        key,
        data
    )

    suspend fun createUser(
        action: String,
        version: String,
        key: String,
        data: JSONObject
    ) = api.createUser(
        action,
        version,
        key,
        data
    )

    suspend fun getNotificationAccess(
        action: String,
        version: String,
        key: String,
        data: String
    ) = api.posIds(
        action,
        version,
        key,
        data
    )

    suspend fun getAddressByPlaceId(id:String) : Response<GoogleAddress> = api.getAddressById(id,
        PLACES_API_KEY)

}