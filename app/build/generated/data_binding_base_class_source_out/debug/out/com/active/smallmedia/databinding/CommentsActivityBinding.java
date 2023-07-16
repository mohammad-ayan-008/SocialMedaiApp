// Generated by view binder compiler. Do not edit!
package com.active.smallmedia.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.active.smallmedia.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CommentsActivityBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RelativeLayout coordinator;

  @NonNull
  public final EditText mesaage;

  @NonNull
  public final RecyclerView recyc;

  @NonNull
  public final Button send;

  private CommentsActivityBinding(@NonNull RelativeLayout rootView,
      @NonNull RelativeLayout coordinator, @NonNull EditText mesaage, @NonNull RecyclerView recyc,
      @NonNull Button send) {
    this.rootView = rootView;
    this.coordinator = coordinator;
    this.mesaage = mesaage;
    this.recyc = recyc;
    this.send = send;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CommentsActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CommentsActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.comments_activity, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CommentsActivityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      RelativeLayout coordinator = (RelativeLayout) rootView;

      id = R.id.mesaage;
      EditText mesaage = ViewBindings.findChildViewById(rootView, id);
      if (mesaage == null) {
        break missingId;
      }

      id = R.id.recyc;
      RecyclerView recyc = ViewBindings.findChildViewById(rootView, id);
      if (recyc == null) {
        break missingId;
      }

      id = R.id.send;
      Button send = ViewBindings.findChildViewById(rootView, id);
      if (send == null) {
        break missingId;
      }

      return new CommentsActivityBinding((RelativeLayout) rootView, coordinator, mesaage, recyc,
          send);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}