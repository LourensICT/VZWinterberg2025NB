package com.example.notebook.data

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {
    
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()
    
    fun getNotesByType(type: NoteType): LiveData<List<Note>> {
        return noteDao.getNotesByType(type)
    }
    
    suspend fun insertNote(note: Note): Long {
        return noteDao.insertNote(note)
    }
    
    suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }
    
    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }
    
    suspend fun getNoteById(id: Long): Note? {
        return noteDao.getNoteById(id)
    }
}