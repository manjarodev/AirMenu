package com.app.airmenu.ui.notification

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.app.airmenu.R

public class FragmentNotificationAccessDirections private constructor() {
  public companion object {
    public fun actionFragmentNotificationAccessToHiltDivisionIds(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentNotificationAccess_to_hilt_DivisionIds)
  }
}
