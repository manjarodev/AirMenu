package com.app.airmenu.ui.posIds

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.app.airmenu.R

public class FragmentPosIdsDirections private constructor() {
  public companion object {
    public fun actionFragmentPosIdsToFragmentNotificationAccess(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentPosIds_to_fragmentNotificationAccess)
  }
}
