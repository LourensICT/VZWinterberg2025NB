package com.example.notebook.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.notebook.data.*
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository: NoteRepository
    val allNotes: LiveData<List<Note>>
    
    init {
        val dao = AppDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }
    
    fun getNotesByType(type: NoteType): LiveData<List<Note>> {
        return repository.getNotesByType(type)
    }
    
    fun insertNote(note: Note) = viewModelScope.launch {
        repository.insertNote(note)
    }
    
    fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNote(note)
    }
    
    fun deleteNote(note: Note) = viewModelScope.launch {
        repository.deleteNote(note)
    }
    
    suspend fun getNoteById(id: Long): Note? {
        return repository.getNoteById(id)
    }
}