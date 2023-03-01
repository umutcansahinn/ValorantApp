package com.example.valorant.data.dto.agents


import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("wave")
    val wave: String?,
    @SerializedName("wwise")
    val wwise: String?
)