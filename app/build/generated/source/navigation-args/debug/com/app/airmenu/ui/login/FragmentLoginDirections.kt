package com.app.airmenu.ui.login

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.app.airmenu.R

public class FragmentLoginDirections private constructor() {
  public companion object {
    public fun actionFragmentLoginToFragmentPosIds(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentLogin_to_fragmentPosIds)
  }
}
