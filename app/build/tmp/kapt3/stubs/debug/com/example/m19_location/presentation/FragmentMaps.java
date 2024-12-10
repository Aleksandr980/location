package com.example.m19_location.presentation;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.example.m19_location.R;
import com.example.m19_location.databinding.MapsFragmentBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKit;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.MapObjectTapListener;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.runtime.image.ImageProvider;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0016J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0016J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0016J\u0006\u0010\"\u001a\u00020\u001dJ\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0016J\u0006\u0010$\u001a\u00020\u001dJ&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u001dH\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\u001a\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00101\u001a\u00020\u001dH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/example/m19_location/presentation/FragmentMaps;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/m19_location/databinding/MapsFragmentBinding;", "binding", "getBinding", "()Lcom/example/m19_location/databinding/MapsFragmentBinding;", "fusedClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "launcherMap", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "locationListener", "Lcom/google/android/gms/location/LocationCallback;", "mapView", "Lcom/yandex/mapkit/mapview/MapView;", "maxZoom", "", "minZoom", "outPoint", "Lcom/yandex/mapkit/geometry/Point;", "placemarkTapListener", "Lcom/yandex/mapkit/map/MapObjectTapListener;", "placemarkTapListener1", "placemarkTapListener2", "zoomLevel", "checkPermissionsMap", "", "currentLocation", "point", "myLocation", "onButtonMinusClick", "onButtonMinusClickCurrentLocation", "onButtonPlusClick", "onButtonPlusClickCurrentLocation", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "onViewCreated", "view", "startLocation", "Companion", "app_debug"})
public final class FragmentMaps extends androidx.fragment.app.Fragment {
    private com.google.android.gms.location.FusedLocationProviderClient fusedClient;
    private com.yandex.mapkit.mapview.MapView mapView;
    private float zoomLevel = 17.0F;
    private final float maxZoom = 23.0F;
    private final float minZoom = 0.0F;
    @org.jetbrains.annotations.Nullable()
    private com.example.m19_location.databinding.MapsFragmentBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private com.yandex.mapkit.geometry.Point outPoint;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> launcherMap = null;
    @org.jetbrains.annotations.NotNull()
    private final com.yandex.mapkit.map.MapObjectTapListener placemarkTapListener = null;
    @org.jetbrains.annotations.NotNull()
    private final com.yandex.mapkit.map.MapObjectTapListener placemarkTapListener1 = null;
    @org.jetbrains.annotations.NotNull()
    private final com.yandex.mapkit.map.MapObjectTapListener placemarkTapListener2 = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.gms.location.LocationCallback locationListener = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] REQUEST_PERMISSIONSMAP = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    @org.jetbrains.annotations.NotNull()
    private static final com.yandex.mapkit.geometry.Point TARGET_LOCATION = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.m19_location.presentation.FragmentMaps.Companion Companion = null;
    
    public FragmentMaps() {
        super();
    }
    
    private final com.example.m19_location.databinding.MapsFragmentBinding getBinding() {
        return null;
    }
    
    public final void currentLocation(@org.jetbrains.annotations.NotNull()
    com.yandex.mapkit.geometry.Point point) {
    }
    
    public final void myLocation(@org.jetbrains.annotations.NotNull()
    com.yandex.mapkit.geometry.Point point) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void startLocation() {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkPermissionsMap() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    public final void onButtonPlusClick(@org.jetbrains.annotations.NotNull()
    com.yandex.mapkit.geometry.Point point) {
    }
    
    public final void onButtonMinusClick(@org.jetbrains.annotations.NotNull()
    com.yandex.mapkit.geometry.Point point) {
    }
    
    public final void onButtonPlusClickCurrentLocation() {
    }
    
    public final void onButtonMinusClickCurrentLocation() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/m19_location/presentation/FragmentMaps$Companion;", "", "()V", "REQUEST_PERMISSIONSMAP", "", "", "[Ljava/lang/String;", "TARGET_LOCATION", "Lcom/yandex/mapkit/geometry/Point;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}