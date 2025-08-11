package com.example.notebook

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notebook.databinding.ActivityMainBinding
import com.example.notebook.ui.NoteAdapter
import com.example.notebook.ui.NoteViewModel

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var adapter: NoteAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setSupportActionBar(binding.toolbar)
        
        // Initialize ViewModel
        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        
        // Setup RecyclerView
        setupRecyclerView()
        
        // Setup FloatingActionButton
        binding.fabAddNote.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
        
        // Observe notes
        noteViewModel.allNotes.observe(this) { notes ->
            adapter.submitList(notes)
        }
    }
    
    private fun setupRecyclerView() {
        adapter = NoteAdapter { note ->
            // Handle note click - could open detail view
        }
        
        binding.notesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }
    
    override fun onResume() {
        super.onResume()
        // Refresh the list when returning from AddNoteActivity
        noteViewModel.allNotes.value?.let { notes ->
            adapter.submitList(notes)
        }
    }
}