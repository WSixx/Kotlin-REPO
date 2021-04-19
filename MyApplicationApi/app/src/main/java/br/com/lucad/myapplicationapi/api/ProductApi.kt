package br.com.lucad.myapplicationapi.api

import android.telecom.Call
import br.com.lucad.myapplicationapi.model.Product
import retrofit2.http.GET

interface ProductApi {
    @GET("getdata.php")
    fun getProductApi(): Call<List<Product>>
}