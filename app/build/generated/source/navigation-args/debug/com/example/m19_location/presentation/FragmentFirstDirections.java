package com.example.m19_location.presentation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.m19_location.R;
import com.example.m19_location.entity.Gallery;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class FragmentFirstDirections {
  private FragmentFirstDirections() {
  }

  @NonNull
  public static ActionFragmentFirstToFragmentSecond actionFragmentFirstToFragmentSecond(
      @NonNull Gallery photos) {
    return new ActionFragmentFirstToFragmentSecond(photos);
  }

  @NonNull
  public static NavDirections actionFragmentFirstToFragment() {
    return new ActionOnlyNavDirections(R.id.action_fragmentFirst_to_fragment);
  }

  @NonNull
  public static NavDirections actionFragmentFirstToFragmentZero() {
    return new ActionOnlyNavDirections(R.id.action_fragmentFirst_to_fragmentZero);
  }

  public static class ActionFragmentFirstToFragmentSecond implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionFragmentFirstToFragmentSecond(@NonNull Gallery photos) {
      if (photos == null) {
        throw new IllegalArgumentException("Argument \"photos\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("photos", photos);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionFragmentFirstToFragmentSecond setPhotos(@NonNull Gallery photos) {
      if (photos == null) {
        throw new IllegalArgumentException("Argument \"photos\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("photos", photos);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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

    @Override
    public int getActionId() {
      return R.id.action_fragmentFirst_to_fragmentSecond;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Gallery getPhotos() {
      return (Gallery) arguments.get("photos");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionFragmentFirstToFragmentSecond that = (ActionFragmentFirstToFragmentSecond) object;
      if (arguments.containsKey("photos") != that.arguments.containsKey("photos")) {
        return false;
      }
      if (getPhotos() != null ? !getPhotos().equals(that.getPhotos()) : that.getPhotos() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getPhotos() != null ? getPhotos().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionFragmentFirstToFragmentSecond(actionId=" + getActionId() + "){"
          + "photos=" + getPhotos()
          + "}";
    }
  }
}
