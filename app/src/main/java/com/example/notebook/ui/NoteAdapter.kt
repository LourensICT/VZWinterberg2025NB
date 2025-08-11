package com.example.notebook.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.notebook.R
import com.example.notebook.data.Note
import com.example.notebook.data.NoteType
import com.example.notebook.databinding.NoteItemBinding
import java.text.SimpleDateFormat
import java.util.*

class NoteAdapter(private val onNoteClick: (Note) -> Unit) : 
    ListAdapter<Note, NoteAdapter.NoteViewHolder>(NoteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NoteViewHolder(private val binding: NoteItemBinding) : 
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onNoteClick(getItem(position))
                }
            }
        }

        fun bind(note: Note) {
            binding.noteTitle.text = note.title
            binding.noteContent.text = note.content
            
            // Format date
            val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
            binding.noteDate.text = dateFormat.format(note.createdAt)
            
            // Set icon based on note type
            when (note.type) {
                NoteType.TEXT -> {
                    binding.noteTypeIcon.setImageResource(R.drawable.ic_text)
                    binding.noteImage.visibility = android.view.View.GONE
                    binding.locationInfo.visibility = android.view.View.GONE
                }
                NoteType.LOCATION -> {
                    binding.noteTypeIcon.setImageResource(R.drawable.ic_location)
                    binding.noteImage.visibility = android.view.View.GONE
                    binding.locationInfo.visibility = android.view.View.VISIBLE
                    binding.locationName.text = note.locationName ?: "Unknown Location"
                }
                NoteType.PHOTO -> {
                    binding.noteTypeIcon.setImageResource(R.drawable.ic_camera)
                    binding.locationInfo.visibility = android.view.View.GONE
                    
                    // Load first image if available
                    val imagePaths = note.imagePaths?.let { 
                        com.google.gson.Gson().fromJson(it, Array<String>::class.java).toList() 
                    } ?: emptyList()
                    
                    if (imagePaths.isNotEmpty()) {
                        binding.noteImage.visibility = android.view.View.VISIBLE
                        Glide.with(binding.root.context)
                            .load(imagePaths.first())
                            .placeholder(R.drawable.ic_image)
                            .error(R.drawable.ic_image)
                            .into(binding.noteImage)
                    } else {
                        binding.noteImage.visibility = android.view.View.GONE
                    }
                }
            }
        }
    }

    class NoteDiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }
}