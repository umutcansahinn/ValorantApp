package com.example.valorant.di

import com.example.valorant.data.api.ValorantApi
import com.example.valorant.data.repository.ValorantRepositoryImpl
import com.example.valorant.domain.repository.ValorantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideValorantRepository(valorantApi: ValorantApi): ValorantRepository {
        return ValorantRepositoryImpl(valorantApi = valorantApi)
    }
}