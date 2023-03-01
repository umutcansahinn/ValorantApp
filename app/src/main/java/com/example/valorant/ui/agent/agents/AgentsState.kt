package com.example.valorant.ui.agent.agents

import com.example.valorant.domain.model.Agent

sealed class AgentsState {
    object Loading : AgentsState()
    data class Success(val agents: List<Agent>) : AgentsState()
    data class Error(val error: String) : AgentsState()
}
