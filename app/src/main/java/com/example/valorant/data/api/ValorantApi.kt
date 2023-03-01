package com.example.valorant.data.api

import com.example.valorant.data.dto.agents.AgentDetailResponse
import com.example.valorant.data.dto.agents.AgentResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ValorantApi {

    @GET("v1/agents")
    suspend fun getAllAgent(): AgentResponse

    @GET("v1/agents/{agentUuid}")
    suspend fun getAgentByUuid(
        @Path("agentUuid") agentUuid: String
    ): AgentDetailResponse
}