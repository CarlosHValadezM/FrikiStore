package com.example.friki_studio.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.friki_studio.viewmodel.ServiceWeb.LoginRequest
import com.example.friki_studio.viewmodel.ServiceWeb.LoginResponse
import com.example.friki_studio.viewmodel.ServiceWeb.ObjRetroAuth
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthVM : ViewModel(){
    fun loginVM(usario : String, contraseniia : String) {
        viewModelScope.launch {
            val loginRequest = LoginRequest(usuario = usario, contraseniia =  contraseniia)
            val response = ObjRetroAuth.RetroAuth.login(loginRequest)

            response.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
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