package com.yzj.minus.getappkotlin

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView.layoutManager = LinearLayoutManager(this)

        progress.visibility = View.VISIBLE
        thread {
            val dataList = AppData.get(this)
            runOnUiThread {
                progress.visibility = View.GONE
                recycleView.adapter = AppAdapter(dataList)
            }
        }
    }
}