package com.app.airmenu.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @SerializedName("enterpriseIds")
    val enterpriseIds: List<String>? = null,

    @SerializedName("enterpriseNames")
    val enterpriseNames: List<String>? = null,

    @SerializedName("action")
    val action: String? = null,

    @SerializedName("sessionId")
    val sessionId: String? = null,

    @SerializedName("version")
    val version: String? = null,

    @SerializedName("status")
    val status: String? = null,

    @SerializedName("statusCode")
    val statusCode: Int? = null,

    @SerializedName("errorName")
    val errorName: String? = null,

    @SerializedName("errorCode")
    val errorCode: Int? = null,

    @SerializedName("property")
    val property: String? = null
)
