// Generated by view binder compiler. Do not edit!
package com.active.smallmedia.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.active.smallmedia.R;
import com.google.android.material.card.MaterialCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PostslayoutBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final ImageView Logo;

  @NonNull
  public final TextView Text;

  @NonNull
  public final ImageView comments;

  @NonNull
  public final TextView commentsno;

  @NonNull
  public final MaterialCardView coordinator;

  @NonNull
  public final ImageView liked;

  @NonNull
  public final TextView likes;

  private PostslayoutBinding(@NonNull MaterialCardView rootView, @NonNull ImageView Logo,
      @NonNull TextView Text, @NonNull ImageView comments, @NonNull TextView commentsno,
      @NonNull MaterialCardView coordinator, @NonNull ImageView liked, @NonNull TextView likes) {
    this.rootView = rootView;
    this.Logo = Logo;
    this.Text = Text;
    this.comments = comments;
    this.commentsno = commentsno;
    this.coordinator = coordinator;
    this.liked = liked;
    this.likes = likes;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static PostslayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PostslayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.postslayout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PostslayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Logo;
      ImageView Logo = ViewBindings.findChildViewById(rootView, id);
      if (Logo == null) {
        break missingId;
      }

      id = R.id.Text;
      TextView Text = ViewBindings.findChildViewById(rootView, id);
      if (Text == null) {
        break missingId;
      }

      id = R.id.comments;
      ImageView comments = ViewBindings.findChildViewById(rootView, id);
      if (comments == null) {
        break missingId;
      }

      id = R.id.commentsno;
      TextView commentsno = ViewBindings.findChildViewById(rootView, id);
      if (commentsno == null) {
        break missingId;
      }

      MaterialCardView coordinator = (MaterialCardView) rootView;

      id = R.id.liked;
      ImageView liked = ViewBindings.findChildViewById(rootView, id);
      if (liked == null) {
        break missingId;
      }

      id = R.id.likes;
      TextView likes = ViewBindings.findChildViewById(rootView, id);
      if (likes == null) {
        break missingId;
      }

      return new PostslayoutBinding((MaterialCardView) rootView, Logo, Text, comments, commentsno,
          coordinator, liked, likes);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
