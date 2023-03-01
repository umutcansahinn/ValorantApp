package com.example.valorant.domain.usecase

import com.example.valorant.domain.usecase.agents.GetAgentDetailUseCase
import com.example.valorant.domain.usecase.agents.GetAgentsUseCase

data class UseCase(
    val getAgentDetailUseCase: GetAgentDetailUseCase,
    val getAgentsUseCase: GetAgentsUseCase
)
