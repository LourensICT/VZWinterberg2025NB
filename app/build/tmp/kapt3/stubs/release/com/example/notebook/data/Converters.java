package com.example.notebook.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/example/notebook/data/Converters;", "", "()V", "dateToTimestamp", "", "date", "Ljava/util/Date;", "(Ljava/util/Date;)Ljava/lang/Long;", "fromStringList", "", "", "value", "fromTimestamp", "(Ljava/lang/Long;)Ljava/util/Date;", "toStringList", "list", "app_release"})
public final class Converters {
    
    public Converters() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.TypeConverter
    public final java.util.Date fromTimestamp(@org.jetbrains.annotations.Nullable
    java.lang.Long value) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.TypeConverter
    public final java.lang.Long dateToTimestamp(@org.jetbrains.annotations.Nullable
    java.util.Date date) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.util.List<java.lang.String> fromStringList(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.lang.String toStringList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> list) {
        return null;
    }
}