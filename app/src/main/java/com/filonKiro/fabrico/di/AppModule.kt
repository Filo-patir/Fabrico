package com.filonKiro.fabrico.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        TODO("INSERT BASE URL")
//        return Retrofit.Builder()
//            .baseUrl("https://jsonplaceholder.typicode.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
    }

    @Provides
    @Singleton
    fun provideString() = "Keorlos Raouf"
}