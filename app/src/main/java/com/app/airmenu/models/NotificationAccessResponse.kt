package com.app.airmenu.models

import com.google.gson.annotations.SerializedName

data class NotificationAccessResponse(

	@field:SerializedName("port")
	val port: String? = null,

	@field:SerializedName("host")
	val host: String? = null,

	@field:SerializedName("action")
	val action: String? = null,

	@field:SerializedName("version")
	val version: String? = null,

	@field:SerializedName("token")
	val token: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null,

	@SerializedName("errorName")
	val errorName: String? = null,

	@SerializedName("property")
	val property: String? = null
)
