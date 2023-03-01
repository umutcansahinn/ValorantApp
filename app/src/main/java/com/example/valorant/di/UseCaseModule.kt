package com.example.valorant.di

import com.example.valorant.domain.mapper.AgentMapper
import com.example.valorant.domain.repository.ValorantRepository
import com.example.valorant.domain.usecase.UseCase
import com.example.valorant.domain.usecase.agents.GetAgentDetailUseCase
import com.example.valorant.domain.usecase.agents.GetAgentsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(valorantRepository: ValorantRepository,mapper: AgentMapper): UseCase {
        return UseCase(
            getAgentsUseCase = GetAgentsUseCase(
                valorantRepository = valorantRepository,
                mapper = mapper
            ),
            getAgentDetailUseCase = GetAgentDetailUseCase(
                valorantRepository = valorantRepository,
                mapper = mapper
            )
        )
    }
}