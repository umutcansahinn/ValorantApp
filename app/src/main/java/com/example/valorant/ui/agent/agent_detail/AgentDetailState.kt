package com.example.valorant.ui.agent.agent_detail

import com.example.valorant.domain.model.Agent
sealed class AgentDetailState {
    object Loading : AgentDetailState()
    data class Success(val agent: Agent) : AgentDetailState()
    data class Error(val error: String) : AgentDetailState()
}
