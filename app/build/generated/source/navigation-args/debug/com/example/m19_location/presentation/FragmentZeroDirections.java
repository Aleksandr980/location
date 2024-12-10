package com.example.m19_location.presentation;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.m19_location.R;

public class FragmentZeroDirections {
  private FragmentZeroDirections() {
  }

  @NonNull
  public static NavDirections actionFragmentZeroToFragmentFirst() {
    return new ActionOnlyNavDirections(R.id.action_fragmentZero_to_fragmentFirst);
  }

  @NonNull
  public static NavDirections actionFragmentZeroToFragmentMaps() {
    return new ActionOnlyNavDirections(R.id.action_fragmentZero_to_fragmentMaps);
  }
}
