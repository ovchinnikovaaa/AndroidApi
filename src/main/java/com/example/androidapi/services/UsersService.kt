package com.example.androidapi.services

import com.example.androidapi.models.User
import com.example.androidapi.models.ListUsers

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersService {

    @GET("/users")
    fun getUsers(): Call<List<User?>?>?

    @GET("/users/{id}")
    fun getUserById(@Query(value="id") id: Long): Call<User?>?


}