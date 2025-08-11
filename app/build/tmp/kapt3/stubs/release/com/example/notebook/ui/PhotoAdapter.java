package com.example.notebook.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B-\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00020\u00062\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0014\u0010\u0014\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/notebook/ui/PhotoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/notebook/ui/PhotoAdapter$PhotoViewHolder;", "onPhotoClick", "Lkotlin/Function1;", "", "", "onRemovePhoto", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "photos", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updatePhotos", "newPhotos", "PhotoViewHolder", "app_release"})
public final class PhotoAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.notebook.ui.PhotoAdapter.PhotoViewHolder> {
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onPhotoClick = null;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onRemovePhoto = null;
    private java.util.List<java.lang.String> photos;
    
    public PhotoAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onPhotoClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onRemovePhoto) {
        super();
    }
    
    public final void updatePhotos(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> newPhotos) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.notebook.ui.PhotoAdapter.PhotoViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.notebook.ui.PhotoAdapter.PhotoViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/notebook/ui/PhotoAdapter$PhotoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/notebook/databinding/PhotoItemBinding;", "(Lcom/example/notebook/ui/PhotoAdapter;Lcom/example/notebook/databinding/PhotoItemBinding;)V", "bind", "", "photoPath", "", "position", "", "app_release"})
    public final class PhotoViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.example.notebook.databinding.PhotoItemBinding binding = null;
        
        public PhotoViewHolder(@org.jetbrains.annotations.NotNull
        com.example.notebook.databinding.PhotoItemBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        java.lang.String photoPath, int position) {
        }
    }
}