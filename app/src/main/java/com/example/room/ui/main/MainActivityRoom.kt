package com.example.room.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicodingandroid.R
import com.example.dicodingandroid.databinding.ActivityMainBinding
import com.example.dicodingandroid.databinding.ActivityMainRoomBinding
import com.example.room.helper.ViewModelFactory
import com.example.room.ui.insert.NoteAddUpdateActivityRoom

class MainActivityRoom : AppCompatActivity() {

    private var _activityMainBinding: ActivityMainRoomBinding? = null
    private val binding get() = _activityMainBinding

    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMainBinding = ActivityMainRoomBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val mainViewModel = obtainViewModel(this@MainActivityRoom)
        mainViewModel.getAllNotes().observe(this, { noteList ->
            if (noteList != null) {
                adapter.setListNotes(noteList)
            }
        })
//

        adapter = NoteAdapter()

        binding?.rvNotes?.layoutManager = LinearLayoutManager(this)
        binding?.rvNotes?.setHasFixedSize(true)
        binding?.rvNotes?.adapter = adapter

        binding?.fabAdd?.setOnClickListener { view ->
            if (view.id == R.id.fab_add) {
                val intent = Intent(this@MainActivityRoom, NoteAddUpdateActivityRoom::class.java)
                startActivity(intent)
            }
        }
    }

    private fun obtainViewModel(activity: AppCompatActivity): MainViewModelRoom {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(MainViewModelRoom::class.java)
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityMainBinding = null
    }

}