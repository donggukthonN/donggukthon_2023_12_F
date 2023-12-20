package com.example.donggukton.di

import com.example.donggukton.data.repository.AuthRepositoryImpl
import com.example.donggukton.data.repository.FriendRepositoryImpl
import com.example.donggukton.data.repository.QuestionRepositoryImpl
import com.example.donggukton.domain.repository.AuthRepository
import com.example.donggukton.domain.repository.FriendRepository
import com.example.donggukton.domain.repository.QuestionRepository
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

    @Provides
    @Singleton
    fun providesAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository =
        authRepositoryImpl

    @Provides
    @Singleton
    fun provideQuestionRepository(questionRepositoryImpl: QuestionRepositoryImpl): QuestionRepository =
        questionRepositoryImpl
}
