package com.example.notebook.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val content: String,
    val type: NoteType,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val latitude: Double? = null,
    val longitude: Double? = null,
    val locationName: String? = null,
    val imagePaths: String? = null // JSON array of image paths
)

enum class NoteType {
    TEXT,
    LOCATION,
    PHOTO
}