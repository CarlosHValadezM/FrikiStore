package com.example.friki_studio.viewmodel.ServiceWeb

import com.example.friki_studio.viewmodel.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServicesAuth {
    @POST("login.php")
    fun login(
        @Body loginRequest: LoginRequest
    ): Call<LoginResponse>
}
object ObjRetroAuth {
    val RetroAuth : ApiServicesAuth by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.baseUrlAuth)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServicesAuth::class.java)
    }
}
data class LoginResponse (
    val resultado: Resultado,
    val codigo: Int
)
data class Resultado(
    val Contraseña: String,
    val Nombre: String,
    val Usuario: String,
    val idArea: String,
    val idEncargado: String,
    val idPuesto: String
)
data class LoginRequest (
    val usuario: String,
    val contraseniia: String
)
