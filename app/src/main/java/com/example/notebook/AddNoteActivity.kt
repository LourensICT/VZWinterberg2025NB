package com.example.notebook

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notebook.data.Note
import com.example.notebook.data.NoteType
import com.example.notebook.databinding.ActivityAddNoteBinding
import com.example.notebook.ui.NoteViewModel
import com.example.notebook.ui.PhotoAdapter
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class AddNoteActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var photoAdapter: PhotoAdapter
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    
    private var currentNoteType: NoteType = NoteType.TEXT
    private val selectedPhotos = mutableListOf<String>()
    private var currentLatitude: Double? = null
    private var currentLongitude: Double? = null
    
    private val cameraPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            openCamera()
        } else {
            Toast.makeText(this, R.string.camera_permission_required, Toast.LENGTH_SHORT).show()
        }
    }
    
    private val locationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        if (permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
            permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true) {
            getCurrentLocation()
        } else {
            Toast.makeText(this, R.string.location_permission_required, Toast.LENGTH_SHORT).show()
        }
    }
    
    private val cameraLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val imageBitmap = result.data?.extras?.get("data") as? Bitmap
            imageBitmap?.let { saveImageToFile(it) }
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        
        setupPhotoRecyclerView()
        setupButtons()
    }
    
    private fun setupPhotoRecyclerView() {
        photoAdapter = PhotoAdapter(
            onPhotoClick = { /* Could open full screen view */ },
            onRemovePhoto = { position ->
                selectedPhotos.removeAt(position)
                photoAdapter.updatePhotos(selectedPhotos)
                updatePhotoVisibility()
            }
        )
        
        binding.photoRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@AddNoteActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = photoAdapter
        }
    }
    
    private fun setupButtons() {
        binding.btnTextNote.setOnClickListener {
            setNoteType(NoteType.TEXT)
        }
        
        binding.btnLocationNote.setOnClickListener {
            setNoteType(NoteType.LOCATION)
        }
        
        binding.btnPhotoNote.setOnClickListener {
            setNoteType(NoteType.PHOTO)
        }
        
        binding.btnAddPhoto.setOnClickListener {
            if (checkCameraPermission()) {
                openCamera()
            } else {
                cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
        
        binding.btnSaveNote.setOnClickListener {
            saveNote()
        }
    }
    
    private fun setNoteType(type: NoteType) {
        currentNoteType = type
        
        // Update UI visibility
        binding.locationNameLayout.visibility = if (type == NoteType.LOCATION) {
            android.view.View.VISIBLE
        } else {
            android.view.View.GONE
        }
        
        binding.photoRecyclerView.visibility = if (type == NoteType.PHOTO) {
            android.view.View.VISIBLE
        } else {
            android.view.View.GONE
        }
        
        binding.btnAddPhoto.visibility = if (type == NoteType.PHOTO) {
            android.view.View.VISIBLE
        } else {
            android.view.View.GONE
        }
        
        // Get location if needed
        if (type == NoteType.LOCATION) {
            getCurrentLocation()
        }
    }
    
    private fun checkCameraPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this, Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }
    
    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraLauncher.launch(intent)
    }
    
    private fun saveImageToFile(bitmap: Bitmap) {
        try {
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val imageFileName = "NOTE_${timeStamp}.jpg"
            val imagesDir = File(filesDir, "images")
            if (!imagesDir.exists()) {
                imagesDir.mkdirs()
            }
            
            val imageFile = File(imagesDir, imageFileName)
            val outputStream = FileOutputStream(imageFile)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
            outputStream.close()
            
            selectedPhotos.add(imageFile.absolutePath)
            photoAdapter.updatePhotos(selectedPhotos)
            updatePhotoVisibility()
            
        } catch (e: Exception) {
            Toast.makeText(this, R.string.error_loading_photos, Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun updatePhotoVisibility() {
        binding.photoRecyclerView.visibility = if (selectedPhotos.isNotEmpty()) {
            android.view.View.VISIBLE
        } else {
            android.view.View.GONE
        }
    }
    
    private fun getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            locationPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
            return
        }
        
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            location?.let {
                currentLatitude = it.latitude
                currentLongitude = it.longitude
            }
        }.addOnFailureListener {
            Toast.makeText(this, R.string.error_getting_location, Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun saveNote() {
        val title = binding.editTitle.text.toString().trim()
        val content = binding.editContent.text.toString().trim()
        
        if (title.isEmpty()) {
            binding.editTitle.error = "Title is required"
            return
        }
        
        val note = Note(
            title = title,
            content = content,
            type = currentNoteType,
            latitude = currentLatitude,
            longitude = currentLongitude,
            locationName = binding.editLocationName.text.toString().trim().takeIf { it.isNotEmpty() },
            imagePaths = if (selectedPhotos.isNotEmpty()) {
                com.google.gson.Gson().toJson(selectedPhotos)
            } else null
        )
        
        noteViewModel.insertNote(note)
        Toast.makeText(this, R.string.note_saved, Toast.LENGTH_SHORT).show()
        finish()
    }
    
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}