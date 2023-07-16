// Generated by view binder compiler. Do not edit!
package com.active.smallmedia.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.active.smallmedia.R;
import com.google.android.gms.common.SignInButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutGLoginBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RelativeLayout coordinator;

  @NonNull
  public final SignInButton signIn;

  private LayoutGLoginBinding(@NonNull RelativeLayout rootView, @NonNull RelativeLayout coordinator,
      @NonNull SignInButton signIn) {
    this.rootView = rootView;
    this.coordinator = coordinator;
    this.signIn = signIn;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutGLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutGLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_g_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutGLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      RelativeLayout coordinator = (RelativeLayout) rootView;

      id = R.id.signIn;
      SignInButton signIn = ViewBindings.findChildViewById(rootView, id);
      if (signIn == null) {
        break missingId;
      }

      return new LayoutGLoginBinding((RelativeLayout) rootView, coordinator, signIn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
