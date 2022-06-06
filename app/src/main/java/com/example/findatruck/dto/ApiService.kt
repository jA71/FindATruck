package com.example.findatruck.dto

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/camiones")
    fun buscarListaProductos(): Call<List<Product>>
}