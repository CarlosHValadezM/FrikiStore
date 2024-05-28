package com.example.friki_studio

import com.example.friki_studio.network.AuthApi
import com.example.friki_studio.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private val retrofit by lazy {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            Retrofit.Builder()
                .baseUrl(Constants.baseUrlAuth)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val authService: AuthApi by lazy {
            retrofit.create(AuthApi::class.java)
        }
    }






    /*val authService: AuthApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.baseUrlAuth)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(AuthApi::class.java)
    }*/
}
