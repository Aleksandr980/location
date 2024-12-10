package com.example.m19_location.presentation;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.m19_location.R;

public class FragmentSecondDirections {
  private FragmentSecondDirections() {
  }

  @NonNull
  public static NavDirections actionFragmentSecondToFragmentFirst() {
    return new ActionOnlyNavDirections(R.id.action_fragmentSecond_to_fragmentFirst);
  }
}
