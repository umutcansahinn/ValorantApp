package com.example.valorant.ui.agent.agent_detail

import com.example.valorant.domain.model.Agent

data class AgentDetailState(
    val isLoading: Boolean = false,
    val agent: Agent? = null,
    val error: String = ""
)
