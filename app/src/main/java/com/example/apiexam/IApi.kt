package com.example.apiexam

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IApi
{
    @GET("rest/v2/currency/{currency}")
    fun getCurrency(@Path("currency") cur:String): Call<List<Country>>
}