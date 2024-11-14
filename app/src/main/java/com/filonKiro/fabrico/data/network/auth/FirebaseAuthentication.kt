package com.filonKiro.fabrico.data.network.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

object FirebaseAuthentication {
    @Inject
    private lateinit var auth: FirebaseAuth
    fun logout() = auth.signOut()

    fun getUser() = auth.currentUser

    fun signUp(email: String, password: String) : Boolean {
        val result = auth.createUserWithEmailAndPassword(email, password)
        return if (result.isSuccessful) true else throw Exception(result.exception)
    }

    suspend fun login(email: String, password: String): FirebaseUser {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            result.user ?: throw Exception("User Not Found")
        } catch (e: Exception) {
            throw Exception(e)
        }
    }
}