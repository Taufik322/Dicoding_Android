package com.example.actionbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.dicodingandroid.R
import com.example.dicodingandroid.databinding.ActivityMainActionBarBinding

class MainActivityActionBar : AppCompatActivity() {

    private lateinit var binding: ActivityMainActionBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainActionBarBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main_action_bar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_actionbar, MenuFragmentActionBar())
                    .addToBackStack(null).commit()
                return true
            }
            R.id.menu2 -> {
                val i = Intent(this, MenuActivityActionBar::class.java)
                startActivity(i)
                return true
            }
            else -> return true
        }
    }
}