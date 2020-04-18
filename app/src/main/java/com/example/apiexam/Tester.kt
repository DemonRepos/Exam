package com.example.apiexam

import android.content.res.Resources
import android.provider.Settings.Global.getString
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Tester {
    fun test(a:String)
    {
        var b = ""
        val service = IApi.create()
        val res = service.getCurrency(a)
        res.enqueue(object : Callback<List<Country>> {
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                b = Resources.getSystem().getString(R.string.error1)

            }

            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if (response.isSuccessful)
                {
                    val k = response.body()
                    var str = ""
                    k?.forEach { str += "${it.name}, " }
                    str = str.substring(0,str.length-2)
                    b = str
                }
                else
                {
                    b = Resources.getSystem().getString(R.string.error2)
                }
            }

        })
    }
}