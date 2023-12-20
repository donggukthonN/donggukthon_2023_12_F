package com.example.donggukton.di

import com.example.donggukton.data.service.AuthService
import com.example.donggukton.data.service.FriendService
import com.example.donggukton.data.service.MyService
import com.example.donggukton.data.service.QuestionService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    private inline fun <reified T> Retrofit.create(): T = this.create(T::class.java)

    @Provides
    @Singleton
    fun provideFriendService(retrofit: Retrofit): FriendService = retrofit.create()

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService = retrofit.create()

    @Provides
    @Singleton
    fun provideQuestionService(retrofit: Retrofit): QuestionService = retrofit.create()

    @Provides
    @Singleton
    fun provideMyService(retrofit: Retrofit): MyService = retrofit.create()
}
