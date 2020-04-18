package com.example.apiexam

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {
    private val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
    .baseUrl("https://restcountries.eu/")
    .build()
    fun search(cur:String):List<String>
    {
        val ans = mutableListOf<String>()
        val service = retrofit.create(IApi::class.java)
        val res = service.getCurrency(cur)
        res.enqueue(object : Callback<List<Country>> {
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                ans.add("Ошибка подключения к серверу")
            }

            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if (response.isSuccessful)
                {
                    val k = response.body()
                    k?.forEach { ans.add(it.name) }
                }
                else
                {
                    ans.add("Ошибка входных данных")
                }
            }

        })
        return ans
    }
}