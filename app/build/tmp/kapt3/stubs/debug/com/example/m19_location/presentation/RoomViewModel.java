package com.example.m19_location.presentation;

import androidx.lifecycle.ViewModel;
import com.example.m19_location.domain.GetGalleryUseCase;
import com.example.m19_location.entity.Gallery;
import com.yandex.mapkit.location.Location;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0014\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0015\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/m19_location/presentation/RoomViewModel;", "Landroidx/lifecycle/ViewModel;", "getGalleryUseCase", "Lcom/example/m19_location/domain/GetGalleryUseCase;", "(Lcom/example/m19_location/domain/GetGalleryUseCase;)V", "allGallery", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/m19_location/entity/Gallery;", "getAllGallery", "()Lkotlinx/coroutines/flow/StateFlow;", "onAdd", "", "gallery", "(Lcom/example/m19_location/entity/Gallery;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onContainsDate", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onContainsPhoto", "photo", "onDelete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUpdate", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public class RoomViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.m19_location.domain.GetGalleryUseCase getGalleryUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.m19_location.entity.Gallery>> allGallery = null;
    
    @javax.inject.Inject()
    public RoomViewModel(@org.jetbrains.annotations.NotNull()
    com.example.m19_location.domain.GetGalleryUseCase getGalleryUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.m19_location.entity.Gallery>> getAllGallery() {
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