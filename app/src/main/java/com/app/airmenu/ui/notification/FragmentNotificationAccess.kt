package com.app.airmenu.ui.notification

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.app.airmenu.R
import com.app.airmenu.broadcast.OnServiceDestroyReceiver
import com.app.airmenu.databinding.FragmentNotificationAccessBinding
import com.app.airmenu.utils.RequestState
import com.app.airmenu.utils.TransparentProgressDialog
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val TAG = "FragmentNotificationAcc"

@AndroidEntryPoint
class FragmentNotificationAccess : Fragment(R.layout.fragment_notification_access) {

    @Inject
    lateinit var serviceDestroyBroadcast: OnServiceDestroyReceiver

    private val mViewModel: NotificationAccessViewModel by viewModels()
    private lateinit var binding: FragmentNotificationAccessBinding
    private lateinit var dialog: TransparentProgressDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNotificationAccessBinding.bind(view)
        dialog= TransparentProgressDialog(requireContext())

        var posId: String? = null

        mViewModel.getPosIdsList()?.let {
            setUpSpinner(it)
        }


        //listener
        binding.posIdsSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    //get enterprise id
                    posId = mViewModel.getPosIdAtPosition(position)
                    Log.e(TAG, "onItemSelected: $posId")


                    if (posId == "nil") {
                        Toast.makeText(
                            requireContext(),
                            "Pos id no found!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }else{
                        mViewModel.saveSelectedPOSId(posId!!)
                    }

                    Log.e(TAG, "onItemSelected: posId: $posId")
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }//listener

        binding.btnNext.setOnClickListener {
         //   mViewModel.getSocketInfo(posId!!)

            if (posId == "nil") {
                Toast.makeText(
                    requireContext(),
                    "Please select a POS Id.",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            mViewModel.getDivisionIds()


        }

        //observers
        mViewModel.requestState.observe(viewLifecycleOwner) { state ->
            when (state) {
                RequestState.LOADING -> {
                    dialog.show()
                }
                RequestState.DONE -> {
                    dialog.dismiss()
//                    val intentToScreen = Intent(requireContext(), HomeActivity::class.java)
//                    intentToScreen.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
//                    intentToScreen.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                    startActivity(intentToScreen)
//                    requireActivity().overridePendingTransition(0, 0)
//                    requireActivity().finish()
                    navigate()
                }
                RequestState.ERROR -> {
                    dialog.dismiss()
                    mViewModel.errorMessage.observe(viewLifecycleOwner) {
                        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                    }
                }
                else -> {
                }
            }
        }


    }//OCV

    private fun navigate() {
        val action =
            FragmentNotificationAccessDirections.actionFragmentNotificationAccessToHiltDivisionIds()
        findNavController().navigate(
            action,
            navOptions {
                anim {
                    enter = android.R.animator.fade_in
                    exit = android.R.animator.fade_out
                }
            })
    }

    private fun setUpSpinner(enterpriseNames: List<String>) {
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, enterpriseNames
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding.posIdsSpinner.adapter = adapter

    }

}