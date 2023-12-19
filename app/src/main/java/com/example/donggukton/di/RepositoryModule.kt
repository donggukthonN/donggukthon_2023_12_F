package com.example.donggukton.di

import com.example.donggukton.data.repository.FriendRepositoryImpl
import com.example.donggukton.domain.repository.FriendRepository
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
    fun providesFriendRepository(friendRepositoryImpl: FriendRepositoryImpl): FriendRepository =
        friendRepositoryImpl
}
