package com.example.firebase.managers

interface AuthHandler {
    fun onSuccess()
    fun onError(exception: Exception?)
}