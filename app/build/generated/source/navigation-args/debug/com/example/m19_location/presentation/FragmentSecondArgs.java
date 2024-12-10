package com.example.m19_location.presentation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.example.m19_location.entity.Gallery;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class FragmentSecondArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private FragmentSecondArgs() {
  }

  @SuppressWarnings("unchecked")
  private FragmentSecondArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings({
      "unchecked",
      "deprecation"
  })
  public static FragmentSecondArgs fromBundle(@NonNull Bundle bundle) {
    FragmentSecondArgs __result = new FragmentSecondArgs();
    bundle.setClassLoader(FragmentSecondArgs.class.getClassLoader());
    if (bundle.containsKey("photos")) {
      Gallery photos;
      if (Parcelable.class.isAssignableFrom(Gallery.class) || Serializable.class.isAssignableFrom(Gallery.class)) {
        photos = (Gallery) bundle.get("photos");
      } else {
        throw new UnsupportedOperationException(Gallery.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (photos == null) {
        throw new IllegalArgumentException("Argument \"photos\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("photos", photos);
    } else {
      throw new IllegalArgumentException("Required argument \"photos\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static FragmentSecondArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    FragmentSecondArgs __result = new FragmentSecondArgs();
    if (savedStateHandle.contains("photos")) {
      Gallery photos;
      photos = savedStateHandle.get("photos");
      if (photos == null) {
        throw new IllegalArgumentException("Argument \"photos\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("photos", photos);
    } else {
      throw new IllegalArgumentException("Required argument \"photos\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Gallery getPhotos() {
    return (Gallery) arguments.get("photos");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("photos")) {
      Gallery photos = (Gallery) arguments.get("photos");
      if (Parcelable.class.isAssignableFrom(Gallery.class) || photos == null) {
        __result.putParcelable("photos", Parcelable.class.cast(photos));
      } else if (Serializable.class.isAssignableFrom(Gallery.class)) {
        __result.putSerializable("photos", Serializable.class.cast(photos));
      } else {
        throw new UnsupportedOperationException(Gallery.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("photos")) {
      Gallery photos = (Gallery) arguments.get("photos");
      if (Parcelable.class.isAssignableFrom(Gallery.class) || photos == null) {
        __result.set("photos", Parcelable.class.cast(photos));
      } else if (Serializable.class.isAssignableFrom(Gallery.class)) {
        __result.set("photos", Serializable.class.cast(photos));
      } else {
        throw new UnsupportedOperationException(Gallery.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    FragmentSecondArgs that = (FragmentSecondArgs) object;
    if (arguments.containsKey("photos") != that.arguments.containsKey("photos")) {
      return false;
    }
    if (getPhotos() != null ? !getPhotos().equals(that.getPhotos()) : that.getPhotos() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getPhotos() != null ? getPhotos().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "FragmentSecondArgs{"
        + "photos=" + getPhotos()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull FragmentSecondArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull Gallery photos) {
      if (photos == null) {
        throw new IllegalArgumentException("Argument \"photos\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("photos", photos);
    }

    @NonNull
    public FragmentSecondArgs build() {
      FragmentSecondArgs result = new FragmentSecondArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setPhotos(@NonNull Gallery photos) {
      if (photos == null) {
        throw new IllegalArgumentException("Argument \"photos\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("photos", photos);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public Gallery getPhotos() {
      return (Gallery) arguments.get("photos");
    }
  }
}
