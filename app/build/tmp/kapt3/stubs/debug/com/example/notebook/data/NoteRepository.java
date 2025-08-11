package com.example.notebook.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0014\u001a\u00020\u0015J\u0019\u0010\u0016\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/example/notebook/data/NoteRepository;", "", "noteDao", "Lcom/example/notebook/data/NoteDao;", "(Lcom/example/notebook/data/NoteDao;)V", "allNotes", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/notebook/data/Note;", "getAllNotes", "()Landroidx/lifecycle/LiveData;", "deleteNote", "", "note", "(Lcom/example/notebook/data/Note;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNoteById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotesByType", "type", "Lcom/example/notebook/data/NoteType;", "insertNote", "updateNote", "app_debug"})
public final class NoteRepository {
    private final com.example.notebook.data.NoteDao noteDao = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.notebook.data.Note>> allNotes = null;
    
    public NoteRepository(@org.jetbrains.annotations.NotNull
    com.example.notebook.data.NoteDao noteDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.notebook.data.Note>> getAllNotes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.notebook.data.Note>> getNotesByType(@org.jetbrains.annotations.NotNull
    com.example.notebook.data.NoteType type) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertNote(@org.jetbrains.annotations.NotNull
    com.example.notebook.data.Note note, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateNote(@org.jetbrains.annotations.NotNull
    com.example.notebook.data.Note note, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteNote(@org.jetbrains.annotations.NotNull
    com.example.notebook.data.Note note, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getNoteById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.notebook.data.Note> continuation) {
        return null;
    }
}