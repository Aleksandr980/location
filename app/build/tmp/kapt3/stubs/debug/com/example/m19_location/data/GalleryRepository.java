package com.example.m19_location.data;

import com.example.m19_location.entity.Gallery;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u0012\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u000e\u0010\u0013\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/example/m19_location/data/GalleryRepository;", "", "galleryDao", "Lcom/example/m19_location/data/GalleryDao;", "(Lcom/example/m19_location/data/GalleryDao;)V", "getGalleryDao", "()Lcom/example/m19_location/data/GalleryDao;", "onAdd", "", "gallery", "Lcom/example/m19_location/entity/Gallery;", "(Lcom/example/m19_location/entity/Gallery;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onContainsDate", "", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onContainsPhoto", "photo", "onDelete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUpdate", "app_debug"})
public final class GalleryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.m19_location.data.GalleryDao galleryDao = null;
    
    @javax.inject.Inject()
    public GalleryRepository(@org.jetbrains.annotations.NotNull()
    com.example.m19_location.data.GalleryDao galleryDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.m19_location.data.GalleryDao getGalleryDao() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object onAdd(@org.jetbrains.annotations.NotNull()
    com.example.m19_location.entity.Gallery gallery, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object onUpdate(@org.jetbrains.annotations.NotNull()
    com.example.m19_location.entity.Gallery gallery, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object onDelete(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object onContainsPhoto(@org.jetbrains.annotations.NotNull()
    java.lang.String photo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.m19_location.entity.Gallery>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object onContainsDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.m19_location.entity.Gallery>> $completion) {
        return null;
    }
}