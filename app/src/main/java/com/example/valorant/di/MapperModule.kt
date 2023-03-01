package com.example.valorant.di

import com.example.valorant.domain.mapper.AgentMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    @Singleton
    fun provideAgentMapper(): AgentMapper {
        return AgentMapper()
    }
}