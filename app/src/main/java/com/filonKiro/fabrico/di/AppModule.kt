package com.filonKiro.fabrico.di

import com.apollographql.apollo.ApolloClient
import com.filonKiro.fabrico.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
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
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://android-alex-team4.myshopify.com/api/2024-10/graphql.json")
            .addHttpHeader("X-Shopify-Storefront-Access-Token", BuildConfig.STOREFRONT_KEY)
            .build()
    }
}