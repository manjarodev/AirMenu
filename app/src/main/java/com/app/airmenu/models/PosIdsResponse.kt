package com.app.airmenu.models

import com.google.gson.annotations.SerializedName

data class PosIdsResponse(

	@field:SerializedName("posIds")
	val posIds: List<String>? = null,

	@field:SerializedName("action")
	val action: String? = null,

	@field:SerializedName("version")
	val version: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)
