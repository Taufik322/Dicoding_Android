package com.example.room.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.room.database.Note
import com.example.room.repository.NoteRepository

class MainViewModelRoom(application: Application): ViewModel() {
    private val mnoteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(): LiveData<List<Note>> = mnoteRepository.getAllNotes()
}