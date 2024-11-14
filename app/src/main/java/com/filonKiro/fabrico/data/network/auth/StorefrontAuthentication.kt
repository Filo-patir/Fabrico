package com.filonKiro.fabrico.data.network.auth

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.ApolloResponse
import com.filonKiro.fabrico.CreateCustomerAccessTokenMutation
import com.filonKiro.fabrico.CreateCustomerMutation
import com.filonKiro.fabrico.type.CustomerAccessTokenCreateInput
import com.filonKiro.fabrico.type.CustomerCreateInput
import javax.inject.Inject

object StorefrontAuthentication {
    @Inject
    lateinit var apolloClient: ApolloClient

    suspend fun createCustomer(input: CustomerCreateInput): ApolloResponse<CreateCustomerMutation.Data> {
        return apolloClient.mutation(CreateCustomerMutation(input)).execute()
    }

    suspend fun getAccessToken(email: String, password: String): ApolloResponse<CreateCustomerAccessTokenMutation.Data> {
        return apolloClient.mutation(CreateCustomerAccessTokenMutation(
            CustomerAccessTokenCreateInput(email = email, password = password))).execute()
    }
}