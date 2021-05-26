package com.example.testtask.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testtask.R
import com.example.testtask.databinding.WelcomeFragmentBinding
import com.example.testtask.presentation.viewmodel.WelcomeViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class WelcomeFragment :
    BaseFragment<WelcomeFragmentBinding>(R.layout.welcome_fragment) {

    private val viewModel: WelcomeViewModel by viewModel()

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): WelcomeFragmentBinding = WelcomeFragmentBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        binding.welcomeButton.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setMessage(getString(R.string.welcome_message, viewModel.nameLiveData.value))
                .setPositiveButton(resources.getString(R.string.accept)) { _, _ ->
                }
                .show()
        }
        /*binding.appBar.setNavigationOnClickListener {
            viewModel.clearData()
            viewModel.navigateTo(Screens.EnterScreen)
        }*/
    }

}