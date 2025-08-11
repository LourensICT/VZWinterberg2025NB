package com.example.notebook.data;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0019\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/example/notebook/data/NoteDao;", "", "deleteNote", "", "note", "Lcom/example/notebook/data/Note;", "(Lcom/example/notebook/data/Note;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNoteById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotes", "Landroidx/lifecycle/LiveData;", "", "getNoteById", "getNotesByType", "type", "Lcom/example/notebook/data/NoteType;", "insertNote", "updateNote", "app_release"})
public abstract interface NoteDao {
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM notes ORDER BY createdAt DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.notebook.data.Note>> getAllNotes();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM notes WHERE type = :type ORDER BY createdAt DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.notebook.data.Note>> getNotesByType(@org.jetbrains.annotations.NotNull
    com.example.notebook.data.NoteType type);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM notes WHERE id = :id")
    public abstract java.lang.Object getNoteById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.notebook.data.Note> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert
    public abstract java.lang.Object insertNote(@org.jetbrains.annotations.NotNull
    com.example.notebook.data.Note note, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateNote(@org.jetbrains.annotations.NotNull
    com.example.notebook.data.Note note, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deleteNote(@org.jetbrains.annotations.NotNull
    com.example.notebook.data.Note note, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "DELETE FROM notes WHERE id = :id")
    public abstract java.lang.Object deleteNoteById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}