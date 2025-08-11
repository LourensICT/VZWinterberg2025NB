package com.example.notebook;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001cH\u0016J\b\u0010#\u001a\u00020\u001eH\u0002J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010\'\u001a\u00020\u001eH\u0002J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0010H\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\n0\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00140\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/example/notebook/AddNoteActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/notebook/databinding/ActivityAddNoteBinding;", "cameraLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "cameraPermissionLauncher", "", "currentLatitude", "", "Ljava/lang/Double;", "currentLongitude", "currentNoteType", "Lcom/example/notebook/data/NoteType;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "locationPermissionLauncher", "", "noteViewModel", "Lcom/example/notebook/ui/NoteViewModel;", "photoAdapter", "Lcom/example/notebook/ui/PhotoAdapter;", "selectedPhotos", "", "checkCameraPermission", "", "getCurrentLocation", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSupportNavigateUp", "openCamera", "saveImageToFile", "bitmap", "Landroid/graphics/Bitmap;", "saveNote", "setNoteType", "type", "setupButtons", "setupPhotoRecyclerView", "updatePhotoVisibility", "app_release"})
public final class AddNoteActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.notebook.databinding.ActivityAddNoteBinding binding;
    private com.example.notebook.ui.NoteViewModel noteViewModel;
    private com.example.notebook.ui.PhotoAdapter photoAdapter;
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    private com.example.notebook.data.NoteType currentNoteType = com.example.notebook.data.NoteType.TEXT;
    private final java.util.List<java.lang.String> selectedPhotos = null;
    private java.lang.Double currentLatitude;
    private java.lang.Double currentLongitude;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> cameraPermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> locationPermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> cameraLauncher = null;
    
    public AddNoteActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupPhotoRecyclerView() {
    }
    
    private final void setupButtons() {
    }
    
    private final void setNoteType(com.example.notebook.data.NoteType type) {
    }
    
    private final boolean checkCameraPermission() {
        return false;
    }
    
    private final void openCamera() {
    }
    
    private final void saveImageToFile(android.graphics.Bitmap bitmap) {
    }
    
    private final void updatePhotoVisibility() {
    }
    
    private final void getCurrentLocation() {
    }
    
    private final void saveNote() {
    }
    
    @java.lang.Override
    public boolean onSupportNavigateUp() {
        return false;
    }
}