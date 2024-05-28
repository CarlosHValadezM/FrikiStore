package com.example.friki_studio.network

import com.example.friki_studio.model.LoginRequest
import com.example.friki_studio.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {
    @POST("login.php")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("https://run.mocky.io/v3/4335abdb-ebde-4ca5-9a86-45ce8532364c")
    fun getLogin(): Call<LoginResponse>
}