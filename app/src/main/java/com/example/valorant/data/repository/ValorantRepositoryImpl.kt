package com.example.valorant.data.repository

import com.example.valorant.data.api.ValorantApi
import com.example.valorant.data.dto.agents.AgentDetailResponse
import com.example.valorant.data.dto.agents.AgentResponse
import com.example.valorant.domain.repository.ValorantRepository

class ValorantRepositoryImpl(
    private val valorantApi: ValorantApi
):ValorantRepository {

    override suspend fun getAgents(): AgentResponse {
        return valorantApi.getAllAgent()
    }

    override suspend fun getAgentByUuid(agendUuid: String): AgentDetailResponse {
        return valorantApi.getAgentByUuid(agentUuid = agendUuid)
    }
}