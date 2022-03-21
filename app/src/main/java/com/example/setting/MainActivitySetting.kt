package com.example.setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicodingandroid.R

class MainActivitySetting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_setting)

        supportFragmentManager.beginTransaction().add(R.id.setting_holder, MyPreferenceFragment()).commit()
    }
//
}