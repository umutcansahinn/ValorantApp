package com.example.valorant.data.dto.agents


import com.google.gson.annotations.SerializedName

data class AgentDetailResponse(
    @SerializedName("data")
    val data: Data?,
    @SerializedName("status")
    val status: Int?
)