package com.example.apiexam

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val savedPref = getPreferences(Context.MODE_PRIVATE)
       // val orientation = this.resources.configuration.orientation
        press1.setOnClickListener {
            val savedText = savedPref.getString(q1.text.toString(), "")
            if (savedText!="")
            {
                result1.text = savedText
            }
            else
            {
                val ans = mutableListOf<String>()
                val service = IApi.create()
                val res = service.getCurrency(q1.text.toString())
                res.enqueue(object : Callback<List<Country>> {
                    override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                        result1.text = "Ошибка подключения к серверу"
                    }

                    override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                        if (response.isSuccessful)
                        {
                            val k = response.body()
                            result1.text = k?.first()!!.name
                        }
                        else
                        {
                            result1.text = "Ошибка входных данных"
                        }
                    }

                })
            }
        }
    }
}
