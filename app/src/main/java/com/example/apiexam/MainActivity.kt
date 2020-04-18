package com.example.apiexam

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

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
                val retrofit = MyRetrofit()
            val ans = retrofit.search(q1.text.toString())
            var str = ""
            for (i in ans)
                str +="$i, "
            //str = str.substring(str.length-3)
            result1.text = str
            if (ans.first()!="Ошибка подключения к серверу" && ans.first()!="Ошибка входных данных")
            {
                val ed = savedPref.edit()
                ed.putString(q1.text.toString(), result1.text.toString())
                ed.apply()
            }
            }
        }
    }
}
