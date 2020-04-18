package com.example.apiexam

import android.content.res.Resources
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Tester {
    fun test(a:String):String
    {
        var b = ""
        val service = IApi.create()
        val res = service.getCurrency(a)
        try {
            val response = res.execute()
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

        } catch (ex: Exception) {
            b = Resources.getSystem().getString(R.string.error1)
        }
        return b
    }
}