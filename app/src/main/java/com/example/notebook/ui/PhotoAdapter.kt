package com.example.notebook.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.notebook.R
import com.example.notebook.databinding.PhotoItemBinding
import java.io.File

class PhotoAdapter(
    private val onPhotoClick: (String) -> Unit,
    private val onRemovePhoto: (Int) -> Unit
) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private var photos = listOf<String>()

    fun updatePhotos(newPhotos: List<String>) {
        photos = newPhotos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = PhotoItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position], position)
    }

    override fun getItemCount(): Int = photos.size

    inner class PhotoViewHolder(private val binding: PhotoItemBinding) : 
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photoPath: String, position: Int) {
            // Load image using Glide
            Glide.with(binding.root.context)
                .load(File(photoPath))
                .placeholder(R.drawable.ic_image)
                .error(R.drawable.ic_image)
                .into(binding.photoImage)

            // Set click listeners
            binding.photoImage.setOnClickListener {
                onPhotoClick(photoPath)
            }

            binding.btnRemovePhoto.setOnClickListener {
                onRemovePhoto(position)
            }
        }
    }
}