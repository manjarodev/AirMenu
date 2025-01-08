package com.app.airmenu.ui.posIds

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
import com.app.airmenu.databinding.FragmentPosIdsBinding
import com.app.airmenu.utils.DIVISION_BY_CUSTOMER_ADDRESS
import com.app.airmenu.utils.RequestState
import com.app.airmenu.utils.TransparentProgressDialog
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "FragmentPosIds"

@AndroidEntryPoint
class FragmentPosIds : Fragment(R.layout.fragment_pos_ids) {

    private val mViewModel: PosIdsViewModel by viewModels()
    private lateinit var binding: FragmentPosIdsBinding
    private lateinit var dialog: TransparentProgressDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPosIdsBinding.bind(view)

        dialog = TransparentProgressDialog(requireContext())

        mViewModel.getEnterpriseNames()?.let {
            setUpSpinner(it)
        }

        //listener
        binding.enterpriseNamesSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    //get enterprise id
                    val enterpriseId = mViewModel.getEnterpriseId(position)
                    val enterPriseNmae = mViewModel.getEnterpriseName(position)
                    //save id in preference
                    if (enterpriseId != "nil") {
                        mViewModel.saveEnterpriseId(enterpriseId)
                        mViewModel.saveEnterPriseName(enterPriseNmae)

                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Enterprise id no found!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    Log.e(TAG, "onItemSelected: enterpriseId: $enterpriseId")
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }//listener


        // listener
        binding.divisionIdsSpinnerMenu.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    //get enterprise id
                    val enterpriseId = mViewModel.getEnterpriseId(position)
                    val enterPriseNmae = mViewModel.getEnterpriseName(position)
                    //save id in preference
                    if (enterpriseId != "nil") {
                        mViewModel.saveSelectedDivisionIdMenu(enterpriseId)
                        mViewModel.saveSelectedDivisionNameMenu(enterPriseNmae)

                    } else {
                        Toast.makeText(
                            requireContext(),
                            "No Enterprise found!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    Log.e(TAG, "onItemSelected: enterpriseId: $enterpriseId")

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }//listener


        binding.btnNext.setOnClickListener {
            mViewModel.getPosIds()
        }

        //observer
        mViewModel.requestState.observe(viewLifecycleOwner) { state ->
            when (state) {
                RequestState.LOADING -> {
                    dialog.show()
                }
                RequestState.ERROR -> {
                    dialog.dismiss()
                    Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT)
                        .show()
                }
                RequestState.DONE -> {
                    dialog.dismiss()
                    navigate()
                }
                else -> {
                }
            }
        }

    }//OVC

    private fun setUpSpinner(enterpriseNames: List<String>) {
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, enterpriseNames
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding.enterpriseNamesSpinner.adapter = adapter

        val adapter2 = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, enterpriseNames
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding.divisionIdsSpinnerMenu.adapter = adapter2

    }

    private fun navigate() {
        val action =
            FragmentPosIdsDirections.actionFragmentPosIdsToFragmentNotificationAccess()
        findNavController().navigate(
            action,
            navOptions {
                anim {
                    enter = android.R.animator.fade_in
                    exit = android.R.animator.fade_out
                }
            })
    }

}