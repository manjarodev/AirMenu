// Generated by view binder compiler. Do not edit!
package com.app.airmenu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.app.airmenu.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLoginBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final AppCompatButton btnSubmit;

  @NonNull
  public final CardView cardEmail;

  @NonNull
  public final CardView cardPassword;

  @NonNull
  public final EditText edtEmail;

  @NonNull
  public final EditText edtPassword;

  @NonNull
  public final TextView login;

  @NonNull
  public final TextView loginMsg;

  private FragmentLoginBinding(@NonNull ScrollView rootView, @NonNull AppCompatButton btnSubmit,
      @NonNull CardView cardEmail, @NonNull CardView cardPassword, @NonNull EditText edtEmail,
      @NonNull EditText edtPassword, @NonNull TextView login, @NonNull TextView loginMsg) {
    this.rootView = rootView;
    this.btnSubmit = btnSubmit;
    this.cardEmail = cardEmail;
    this.cardPassword = cardPassword;
    this.edtEmail = edtEmail;
    this.edtPassword = edtPassword;
    this.login = login;
    this.loginMsg = loginMsg;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_submit;
      AppCompatButton btnSubmit = rootView.findViewById(id);
      if (btnSubmit == null) {
        break missingId;
      }

      id = R.id.card_email;
      CardView cardEmail = rootView.findViewById(id);
      if (cardEmail == null) {
        break missingId;
      }

      id = R.id.card_password;
      CardView cardPassword = rootView.findViewById(id);
      if (cardPassword == null) {
        break missingId;
      }

      id = R.id.edt_email;
      EditText edtEmail = rootView.findViewById(id);
      if (edtEmail == null) {
        break missingId;
      }

      id = R.id.edt_password;
      EditText edtPassword = rootView.findViewById(id);
      if (edtPassword == null) {
        break missingId;
      }

      id = R.id.login;
      TextView login = rootView.findViewById(id);
      if (login == null) {
        break missingId;
      }

      id = R.id.login_msg;
      TextView loginMsg = rootView.findViewById(id);
      if (loginMsg == null) {
        break missingId;
      }

      return new FragmentLoginBinding((ScrollView) rootView, btnSubmit, cardEmail, cardPassword,
          edtEmail, edtPassword, login, loginMsg);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
