package com.example.valorant.domain.mapper

import com.example.valorant.data.dto.agents.Data
import com.example.valorant.domain.model.Agent

class AgentMapper {

    fun map(agentData: Data): Agent {
        return agentData.toAgent()
    }

    private fun Data.toAgent(): Agent {
        return Agent(
            abilities = abilities.orEmpty(),
            description = description.orEmpty(),
            displayIcon = displayIcon.orEmpty(),
            displayName = displayName.orEmpty(),
            fullPortrait = fullPortrait.orEmpty(),
            role = role,
            uuid = uuid.orEmpty()
        )
    }
}