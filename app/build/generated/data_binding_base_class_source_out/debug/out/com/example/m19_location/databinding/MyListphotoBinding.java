// Generated by view binder compiler. Do not edit!
package com.example.m19_location.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.m19_location.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MyListphotoBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final TextView currentDate;

  @NonNull
  public final ImageView photo;

  @NonNull
  public final FrameLayout photoView;

  private MyListphotoBinding(@NonNull FrameLayout rootView, @NonNull TextView currentDate,
      @NonNull ImageView photo, @NonNull FrameLayout photoView) {
    this.rootView = rootView;
    this.currentDate = currentDate;
    this.photo = photo;
    this.photoView = photoView;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MyListphotoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MyListphotoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.my_listphoto, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MyListphotoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.current_date;
      TextView currentDate = ViewBindings.findChildViewById(rootView, id);
      if (currentDate == null) {
        break missingId;
      }

      id = R.id.photo;
      ImageView photo = ViewBindings.findChildViewById(rootView, id);
      if (photo == null) {
        break missingId;
      }

      FrameLayout photoView = (FrameLayout) rootView;

      return new MyListphotoBinding((FrameLayout) rootView, currentDate, photo, photoView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}