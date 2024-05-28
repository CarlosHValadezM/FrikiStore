package com.example.friki_studio.model

data class LoginResponse(
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
