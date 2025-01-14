// Generated by view binder compiler. Do not edit!
package com.app.airmenu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.app.airmenu.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class StoreItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView storeAddress;

  @NonNull
  public final TextView storeCountry;

  @NonNull
  public final ImageView storeImage;

  @NonNull
  public final TextView storeName;

  @NonNull
  public final TextView storeStatus;

  private StoreItemBinding(@NonNull CardView rootView, @NonNull TextView storeAddress,
      @NonNull TextView storeCountry, @NonNull ImageView storeImage, @NonNull TextView storeName,
      @NonNull TextView storeStatus) {
    this.rootView = rootView;
    this.storeAddress = storeAddress;
    this.storeCountry = storeCountry;
    this.storeImage = storeImage;
    this.storeName = storeName;
    this.storeStatus = storeStatus;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static StoreItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static StoreItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.store_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static StoreItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.store_address;
      TextView storeAddress = rootView.findViewById(id);
      if (storeAddress == null) {
        break missingId;
      }

      id = R.id.store_country;
      TextView storeCountry = rootView.findViewById(id);
      if (storeCountry == null) {
        break missingId;
      }

      id = R.id.store_image;
      ImageView storeImage = rootView.findViewById(id);
      if (storeImage == null) {
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

      return new StoreItemBinding((CardView) rootView, storeAddress, storeCountry, storeImage,
          storeName, storeStatus);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
