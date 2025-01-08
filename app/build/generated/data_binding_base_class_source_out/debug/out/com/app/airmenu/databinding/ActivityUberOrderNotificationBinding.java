// Generated by view binder compiler. Do not edit!
package com.app.airmenu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.app.airmenu.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityUberOrderNotificationBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView logoutbutton;

  @NonNull
  public final TextView noItemFound;

  @NonNull
  public final RecyclerView notificationRecyclerView;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView totalNotifications;

  private ActivityUberOrderNotificationBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageView logoutbutton, @NonNull TextView noItemFound,
      @NonNull RecyclerView notificationRecyclerView, @NonNull Toolbar toolbar,
      @NonNull TextView totalNotifications) {
    this.rootView = rootView;
    this.logoutbutton = logoutbutton;
    this.noItemFound = noItemFound;
    this.notificationRecyclerView = notificationRecyclerView;
    this.toolbar = toolbar;
    this.totalNotifications = totalNotifications;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityUberOrderNotificationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityUberOrderNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_uber_order_notification, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityUberOrderNotificationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.logoutbutton;
      ImageView logoutbutton = rootView.findViewById(id);
      if (logoutbutton == null) {
        break missingId;
      }

      id = R.id.no_item_found;
      TextView noItemFound = rootView.findViewById(id);
      if (noItemFound == null) {
        break missingId;
      }

      id = R.id.notification_recycler_view;
      RecyclerView notificationRecyclerView = rootView.findViewById(id);
      if (notificationRecyclerView == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = rootView.findViewById(id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.total_notifications;
      TextView totalNotifications = rootView.findViewById(id);
      if (totalNotifications == null) {
        break missingId;
      }

      return new ActivityUberOrderNotificationBinding((RelativeLayout) rootView, logoutbutton,
          noItemFound, notificationRecyclerView, toolbar, totalNotifications);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}