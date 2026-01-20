package com.example.mytask

import com.example.mytask.Model.User
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("users")
    fun getUserData() : Call<List<User?>?>?
}