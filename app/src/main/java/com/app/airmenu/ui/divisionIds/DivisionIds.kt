package com.app.airmenu.ui.divisionIds

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.app.airmenu.R
import com.app.airmenu.databinding.FragmentDivisionIdsBinding
import com.app.airmenu.databinding.FragmentLoginBinding
import com.app.airmenu.models.DivisionIdsResponse
import com.app.airmenu.ui.HomeActivity
import com.app.airmenu.ui.login.FragmentLoginDirections
import com.app.airmenu.ui.login.LoginViewModel
import com.app.airmenu.utils.DIVISION_BY_CUSTOMER_ADDRESS
import com.app.airmenu.utils.RequestState
import com.app.airmenu.utils.TransparentProgressDialog
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "DivisionIds"

@AndroidEntryPoint
class DivisionIds : Fragment(R.layout.fragment_division_ids) {

    private var binding:FragmentDivisionIdsBinding?= null
    private val mViewModel: DivisionIdsViewModel by viewModels()
    private lateinit var divisionsList:ArrayList<DivisionIdsResponse.DivisionTree>
    private lateinit var dialog: TransparentProgressDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDivisionIdsBinding.bind(view)

        dialog = TransparentProgressDialog(requireContext())

        var divisionId: String? = null
        var divisionName: String? = null

        mViewModel.getDivisionList()?.let {
            if (!it.isNullOrEmpty()){
                divisionsList = ArrayList()
                it.forEach {
                    divisionsList.add(it)
                }

                val list = ArrayList<String>()

                divisionsList.forEach {
                    list.add(it.name)
                }
                list.add("Choose Division Using Customer Address")
                setUpSpinner(list)
            }

        }

        //listener
        binding?.divisionIdsSpinner?.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (position == divisionsList.size){
                        divisionId = DIVISION_BY_CUSTOMER_ADDRESS
                        divisionName= DIVISION_BY_CUSTOMER_ADDRESS
                    }else{
                        divisionId = divisionsList[position].id
                        divisionName = divisionsList[position].name
                    }
                    Log.e(TAG, "onItemSelected: divisionId to be saved: $divisionId")
                    mViewModel.saveSelectedDivisionId(divisionId!!)
                    mViewModel.saveSelectedDivisionName(divisionName!!)

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }//listener




        //connect button listener
        binding?.btnConnect?.setOnClickListener {

            if (divisionId == null){
                Toast.makeText(requireContext(), "Division id is not selected", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }
          navigate()
           // mViewModel.getSocketInfo(divisionId!!)
        }




    }
    private fun navigate() {

        findNavController().navigate(
            R.id.action_fragmentDivisionIds_to_fragmentUberLogin,
            null,
            navOptions {
                anim {
                    enter = android.R.animator.fade_in
                    exit = android.R.animator.fade_out
                }
            })
    }

    private fun setUpSpinner(it: ArrayList<String>) {

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, it
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding?.divisionIdsSpinner?.adapter = adapter

    }



}