package com.app.airmenu.ui.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.app.airmenu.R
import com.app.airmenu.databinding.FragmentLoginBinding
import com.app.airmenu.utils.RequestState
import com.app.airmenu.utils.TransparentProgressDialog
import com.elvishew.xlog.XLog
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "FragmentLogin"

@AndroidEntryPoint
class FragmentLogin : Fragment(R.layout.fragment_login) {

    private val mViewModel: LoginViewModel by viewModels()
    private lateinit var dialog: TransparentProgressDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentLoginBinding.bind(view)
        dialog = TransparentProgressDialog(requireContext())
        //listener
        binding.apply {
            btnSubmit.setOnClickListener {

                val email = edtEmail.text.toString()
                val password = edtPassword.text.toString()

                if (mViewModel.validator(email, password)) {
                    mViewModel.loginWithCredentials(email, password)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "Please enter valid credentials",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }//btn

        }//binding

        //observer
        mViewModel.requestState.observe(viewLifecycleOwner) {
            Log.e(TAG, "REQUEST STATE: $it")
            if (it.equals(RequestState.LOADING)) {

                dialog.show()

            } else if (it.equals(RequestState.DONE)) {
                //schedule work
                dialog.dismiss()
                XLog.e("$TAG - Airmenu login successful")
                navigate()


            }//done
        }//observer

        mViewModel.errorDescription.observe(viewLifecycleOwner) {
            dialog.dismiss()
            if (!it.isNullOrEmpty()) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }

    }//OVC

    private fun navigate() {
        val action =
            FragmentLoginDirections.actionFragmentLoginToFragmentPosIds()
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