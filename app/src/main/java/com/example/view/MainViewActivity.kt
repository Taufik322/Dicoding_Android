package com.example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicodingandroid.R

class MainViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view)
        supportActionBar?.title = "Google Pixel"
    }
}