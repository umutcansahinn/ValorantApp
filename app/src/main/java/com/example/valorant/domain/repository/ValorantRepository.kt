package com.example.valorant.domain.repository

import com.example.valorant.data.dto.agents.AgentDetailResponse
import com.example.valorant.data.dto.agents.AgentResponse

interface ValorantRepository {

    suspend fun getAgents(): AgentResponse
    suspend fun getAgentByUuid(agendUuid: String): AgentDetailResponse
}