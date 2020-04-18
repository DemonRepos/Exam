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
        press.setOnClickListener {
            val savedText = savedPref.getString(q.text.toString(), "")
            if (savedText!="")
            {
                result.text = savedText
            }
            else
            {
                val service = IApi.create()
                val res = service.getCurrency(q.text.toString())
                res.enqueue(object : Callback<List<Country>> {
                    override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                        result.setText(R.string.error1)
                    }

                    override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                        if (response.isSuccessful)
                        {
                            val k = response.body()
                            var str = ""
                            k?.forEach { str += "${it.name}, " }
                            str = str.substring(0,str.length-2)
                            result.text = str
                            val ed = savedPref.edit()
                            ed.putString(q.text.toString(), result.text.toString())
                            ed.apply()
                        }
                        else
                        {
                            result.setText(R.string.error2)
                        }
                    }

                })
            }
        }
    }

    override fun onPause() {
        super.onPause()
        val sPref = getPreferences(Context.MODE_PRIVATE)
        val ed = sPref.edit()
        ed.putString("last",q.text.toString())

        ed.apply()
    }

    override fun onResume() {
        super.onResume()
        val sPref = getPreferences(Context.MODE_PRIVATE)
        val savedText = sPref.getString("last", "")
        if (savedText != "")
        {
            result.text = sPref.getString(savedText,"")
            q.setText(savedText)
        }
    }
}
