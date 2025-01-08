package com.app.airmenu.ui.divisionIds

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.app.airmenu.R

public class DivisionIdsDirections private constructor() {
  public companion object {
    public fun actionFragmentDivisionIdsToFragmentUberLogin(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentDivisionIds_to_fragmentUberLogin)
  }
}
