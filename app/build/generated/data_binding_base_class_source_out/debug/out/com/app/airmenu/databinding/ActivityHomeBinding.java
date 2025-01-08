// Generated by view binder compiler. Do not edit!
package com.app.airmenu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.app.airmenu.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityHomeBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView airmenuStatusText;

  @NonNull
  public final LottieAnimationView connectingStatusAnimation;

  @NonNull
  public final LottieAnimationView connectingStatusAnimationUber;

  @NonNull
  public final TextView countryCode;

  @NonNull
  public final TextView disablePosButton;

  @NonNull
  public final TextView divisionName;

  @NonNull
  public final TextView divisionNameMenu;

  @NonNull
  public final TextView enablePosButton;

  @NonNull
  public final TextView enterpriseName;

  @NonNull
  public final FrameLayout f1;

  @NonNull
  public final FrameLayout f2;

  @NonNull
  public final FrameLayout f3;

  @NonNull
  public final TextView internetStatusText;

  @NonNull
  public final ImageView logoutbutton;

  @NonNull
  public final TextView posName;

  @NonNull
  public final AppCompatButton startServiceBtn;

  @NonNull
  public final ImageView statusImageAirmenu;

  @NonNull
  public final ImageView statusImageInternet;

  @NonNull
  public final ImageView statusImageUber;

  @NonNull
  public final TextView storeName;

  @NonNull
  public final TextView storeStatus;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView tvConfigurations;

  @NonNull
  public final TextView uberStatusText;

  @NonNull
  public final TextView updateStoreStatus;

  private ActivityHomeBinding(@NonNull RelativeLayout rootView, @NonNull TextView airmenuStatusText,
      @NonNull LottieAnimationView connectingStatusAnimation,
      @NonNull LottieAnimationView connectingStatusAnimationUber, @NonNull TextView countryCode,
      @NonNull TextView disablePosButton, @NonNull TextView divisionName,
      @NonNull TextView divisionNameMenu, @NonNull TextView enablePosButton,
      @NonNull TextView enterpriseName, @NonNull FrameLayout f1, @NonNull FrameLayout f2,
      @NonNull FrameLayout f3, @NonNull TextView internetStatusText,
      @NonNull ImageView logoutbutton, @NonNull TextView posName,
      @NonNull AppCompatButton startServiceBtn, @NonNull ImageView statusImageAirmenu,
      @NonNull ImageView statusImageInternet, @NonNull ImageView statusImageUber,
      @NonNull TextView storeName, @NonNull TextView storeStatus, @NonNull Toolbar toolbar,
      @NonNull TextView tvConfigurations, @NonNull TextView uberStatusText,
      @NonNull TextView updateStoreStatus) {
    this.rootView = rootView;
    this.airmenuStatusText = airmenuStatusText;
    this.connectingStatusAnimation = connectingStatusAnimation;
    this.connectingStatusAnimationUber = connectingStatusAnimationUber;
    this.countryCode = countryCode;
    this.disablePosButton = disablePosButton;
    this.divisionName = divisionName;
    this.divisionNameMenu = divisionNameMenu;
    this.enablePosButton = enablePosButton;
    this.enterpriseName = enterpriseName;
    this.f1 = f1;
    this.f2 = f2;
    this.f3 = f3;
    this.internetStatusText = internetStatusText;
    this.logoutbutton = logoutbutton;
    this.posName = posName;
    this.startServiceBtn = startServiceBtn;
    this.statusImageAirmenu = statusImageAirmenu;
    this.statusImageInternet = statusImageInternet;
    this.statusImageUber = statusImageUber;
    this.storeName = storeName;
    this.storeStatus = storeStatus;
    this.toolbar = toolbar;
    this.tvConfigurations = tvConfigurations;
    this.uberStatusText = uberStatusText;
    this.updateStoreStatus = updateStoreStatus;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.airmenu_status_text;
      TextView airmenuStatusText = rootView.findViewById(id);
      if (airmenuStatusText == null) {
        break missingId;
      }

      id = R.id.connecting_status_animation;
      LottieAnimationView connectingStatusAnimation = rootView.findViewById(id);
      if (connectingStatusAnimation == null) {
        break missingId;
      }

      id = R.id.connecting_status_animation_uber;
      LottieAnimationView connectingStatusAnimationUber = rootView.findViewById(id);
      if (connectingStatusAnimationUber == null) {
        break missingId;
      }

      id = R.id.country_code;
      TextView countryCode = rootView.findViewById(id);
      if (countryCode == null) {
        break missingId;
      }

      id = R.id.disable_pos_button;
      TextView disablePosButton = rootView.findViewById(id);
      if (disablePosButton == null) {
        break missingId;
      }

      id = R.id.division_name;
      TextView divisionName = rootView.findViewById(id);
      if (divisionName == null) {
        break missingId;
      }

      id = R.id.division_name_menu;
      TextView divisionNameMenu = rootView.findViewById(id);
      if (divisionNameMenu == null) {
        break missingId;
      }

      id = R.id.enable_pos_button;
      TextView enablePosButton = rootView.findViewById(id);
      if (enablePosButton == null) {
        break missingId;
      }

      id = R.id.enterprise_name;
      TextView enterpriseName = rootView.findViewById(id);
      if (enterpriseName == null) {
        break missingId;
      }

      id = R.id.f1;
      FrameLayout f1 = rootView.findViewById(id);
      if (f1 == null) {
        break missingId;
      }

      id = R.id.f2;
      FrameLayout f2 = rootView.findViewById(id);
      if (f2 == null) {
        break missingId;
      }

      id = R.id.f3;
      FrameLayout f3 = rootView.findViewById(id);
      if (f3 == null) {
        break missingId;
      }

      id = R.id.internet_status_text;
      TextView internetStatusText = rootView.findViewById(id);
      if (internetStatusText == null) {
        break missingId;
      }

      id = R.id.logoutbutton;
      ImageView logoutbutton = rootView.findViewById(id);
      if (logoutbutton == null) {
        break missingId;
      }

      id = R.id.pos_name;
      TextView posName = rootView.findViewById(id);
      if (posName == null) {
        break missingId;
      }

      id = R.id.startServiceBtn;
      AppCompatButton startServiceBtn = rootView.findViewById(id);
      if (startServiceBtn == null) {
        break missingId;
      }

      id = R.id.status_image_airmenu;
      ImageView statusImageAirmenu = rootView.findViewById(id);
      if (statusImageAirmenu == null) {
        break missingId;
      }

      id = R.id.status_image_internet;
      ImageView statusImageInternet = rootView.findViewById(id);
      if (statusImageInternet == null) {
        break missingId;
      }

      id = R.id.status_image_uber;
      ImageView statusImageUber = rootView.findViewById(id);
      if (statusImageUber == null) {
        break missingId;
      }

      id = R.id.store_name;
      TextView storeName = rootView.findViewById(id);
      if (storeName == null) {
        break missingId;
      }

      id = R.id.store_status;
      TextView storeStatus = rootView.findViewById(id);
      if (storeStatus == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = rootView.findViewById(id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.tvConfigurations;
      TextView tvConfigurations = rootView.findViewById(id);
      if (tvConfigurations == null) {
        break missingId;
      }

      id = R.id.uber_status_text;
      TextView uberStatusText = rootView.findViewById(id);
      if (uberStatusText == null) {
        break missingId;
      }

      id = R.id.update_store_status;
      TextView updateStoreStatus = rootView.findViewById(id);
      if (updateStoreStatus == null) {
        break missingId;
      }

      return new ActivityHomeBinding((RelativeLayout) rootView, airmenuStatusText,
          connectingStatusAnimation, connectingStatusAnimationUber, countryCode, disablePosButton,
          divisionName, divisionNameMenu, enablePosButton, enterpriseName, f1, f2, f3,
          internetStatusText, logoutbutton, posName, startServiceBtn, statusImageAirmenu,
          statusImageInternet, statusImageUber, storeName, storeStatus, toolbar, tvConfigurations,
          uberStatusText, updateStoreStatus);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}