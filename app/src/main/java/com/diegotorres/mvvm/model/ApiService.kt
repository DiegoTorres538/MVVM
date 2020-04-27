package com.diegotorres.mvvm.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("getOffers/?format=json")
    fun getCuponStore(@Query("API_KEY") apiKey:String): Call<Cupones>

    companion object{

        val urlApi = "http://feed.linkmydeals.com/"

        fun create():ApiService{
            val retrofit = Retrofit.Builder().baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}