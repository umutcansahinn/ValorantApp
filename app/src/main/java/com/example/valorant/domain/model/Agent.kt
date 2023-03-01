package com.example.valorant.domain.model

import com.example.valorant.data.dto.agents.Ability
import com.example.valorant.data.dto.agents.Role

data class Agent(
    val abilities: List<Ability>,
    val description: String,
    val displayIcon: String,
    val displayName: String,
    val fullPortrait: String,
    val role: Role?,
    val uuid: String
)
