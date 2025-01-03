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

public final class SecondFragmentBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final FrameLayout fragmentSecond;

  @NonNull
  public final TextView newcurrentDate;

  @NonNull
  public final ImageView newphoto;

  private SecondFragmentBinding(@NonNull FrameLayout rootView, @NonNull FrameLayout fragmentSecond,
      @NonNull TextView newcurrentDate, @NonNull ImageView newphoto) {
    this.rootView = rootView;
    this.fragmentSecond = fragmentSecond;
    this.newcurrentDate = newcurrentDate;
    this.newphoto = newphoto;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SecondFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SecondFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.second_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SecondFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      FrameLayout fragmentSecond = (FrameLayout) rootView;

      id = R.id.newcurrent_date;
      TextView newcurrentDate = ViewBindings.findChildViewById(rootView, id);
      if (newcurrentDate == null) {
        break missingId;
      }

      id = R.id.newphoto;
      ImageView newphoto = ViewBindings.findChildViewById(rootView, id);
      if (newphoto == null) {
        break missingId;
      }

      return new SecondFragmentBinding((FrameLayout) rootView, fragmentSecond, newcurrentDate,
          newphoto);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
