package com.example.valorant.domain.usecase.agents

import com.example.valorant.common.Resource
import com.example.valorant.domain.mapper.AgentMapper
import com.example.valorant.domain.model.Agent
import com.example.valorant.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAgentDetailUseCase @Inject constructor(
    private val valorantRepository: ValorantRepository,
    private val mapper: AgentMapper
) {

    operator fun invoke(agentUuid: String): Flow<Resource<Agent>> {
        return flow {
            try {
                emit(Resource.Loading)
                valorantRepository.getAgentByUuid(agentUuid = agentUuid).data?.let { data ->
                    mapper.map(agentData = data).also {
                        emit(Resource.Success(data = it))
                    }
                }
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage.orEmpty()))
            } catch (e: IOException) {
                emit(Resource.Error(e.localizedMessage.orEmpty()))
            }
        }
    }
}