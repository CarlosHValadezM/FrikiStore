package com.example.friki_studio.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.friki_studio.RetrofitInstance
import com.example.friki_studio.model.LoginResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthViewModel : ViewModel() {

    fun loginVM(user: String, password: String) {
        viewModelScope.launch {
            //val response = RetrofitInstance.authService.login(LoginRequest(user, password))
            val response = RetrofitInstance.authService.getLogin()

            response.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        println("Respuesta del servidor: $loginResponse")
                        // Manejar la respuesta del servidor
                    } else {
                        // Manejar errores
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    println("Error al conectar con el servidor: ${t.message}")
                }
            })
        }

    }
}