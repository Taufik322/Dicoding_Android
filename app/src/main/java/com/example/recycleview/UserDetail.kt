package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.dicodingandroid.R

class UserDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val name = intent.getStringExtra(EXTRA_NAME)
        val tvUserDetail: TextView = findViewById(R.id.user_name)

        tvUserDetail.text = name
    }
}