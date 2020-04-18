package com.example.apiexam

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface IApi
{
    @GET("rest/v2/currency/{currency}")
    fun getCurrency(@Path("currency") cur:String): Call<List<Country>>
    companion object Factory {
        fun create(): IApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://restcountries.eu/")
                .build()

            return retrofit.create(IApi::class.java)
        }
    }
}