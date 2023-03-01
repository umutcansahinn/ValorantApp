package com.example.valorant.ui.agent.agents

import com.example.valorant.domain.model.Agent

data class AgentsState(
    val isLoading: Boolean = false,
    val agents: List<Agent> = emptyList(),
    val error: String = ""
)