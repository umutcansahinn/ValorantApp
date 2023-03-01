package com.example.valorant.data.dto.agents


import com.google.gson.annotations.SerializedName

data class AgentResponse(
    @SerializedName("data")
    val data: List<Data>?,
    @SerializedName("status")
    val status: Int?
)