package com.example.testtask.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.example.testtask.R
import com.example.testtask.databinding.RegistrationFragmentBinding
import com.example.testtask.presentation.validation.ValidatorComposer
import com.example.testtask.presentation.validation.validators.*
import com.example.testtask.presentation.viewmodel.RegistrationViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment :
    BaseFragment<RegistrationFragmentBinding>(R.layout.registration_fragment) {

    private val viewModel: RegistrationViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpCalendar()
        setObservers()
        setListeners()
        binding.root.post {
            choice()
        }
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): RegistrationFragmentBinding = RegistrationFragmentBinding.inflate(inflater, container, false)

    private fun setUpCalendar() {
        val datePickerDialogBuilder = MaterialDatePicker.Builder.datePicker()
            .setTitleText(R.string.edit_birth_date)
            .build()
        binding.editBirthDate.setOnClickListener {
            if (!datePickerDialogBuilder.isAdded) {
                datePickerDialogBuilder.show(
                    parentFragmentManager,
                    getString(R.string.date_picker_tag_text)
                )
            }
        }
        datePickerDialogBuilder.addOnPositiveButtonClickListener {
            viewModel.converterDate(datePickerDialogBuilder.selection)
        }
    }


    private fun setObservers() {
        with(binding) {
            viewModel.firstNameLiveData.observe(viewLifecycleOwner) {
                editFirstName.setText(it)
            }
            viewModel.secondNameLiveData.observe(viewLifecycleOwner) {
                editSecondName.setText(it)
            }
            viewModel.birthDateLiveData.observe(viewLifecycleOwner) {
                editBirthDate.setText(it)
            }
            viewModel.passwordLiveData.observe(viewLifecycleOwner) {
                editPassword.setText(it)
            }
            viewModel.confirmPasswordLiveData.observe((viewLifecycleOwner)) {
                editConfirmPassword.setText(it)
            }
        }
    }

    private fun choice() {
        if (viewModel.isAlreadyRegistration()) viewModel.navigateTo(Screens.WelcomeScreen)
    }

    private fun setListeners() {
        with(binding) {
            buttonRegistration.setOnClickListener {
                with(viewModel) {
                    firstNameLiveData.value = editFirstName.text.toString()
                    secondNameLiveData.value = editSecondName.text.toString()
                    birthDateLiveData.value = editBirthDate.text.toString()
                    passwordLiveData.value = editPassword.text.toString()
                    confirmPasswordLiveData.value = editConfirmPassword.text.toString()
                }
                if (viewModel.isValid()
                ) {
                    val name: String =
                        viewModel.firstNameLiveData.value + " " + viewModel.secondNameLiveData.value
                    viewModel.finishRegistration(name)
                    viewModel.navigateTo(Screens.WelcomeScreen)
                } else {
                    MaterialAlertDialogBuilder(requireContext())
                        .setMessage(R.string.Error_message_registration)
                        .setPositiveButton(resources.getString(R.string.accept)) { _, _ ->
                        }
                        .show()

                }

            }

            editFirstName.doOnTextChanged { text, _, _, _ ->
                val nameValidatorsComposer: ValidatorComposer<String> = ValidatorComposer(
                    listOf(
                        EmptyValidator(),
                        NameValidator(),
                        AccessCharValidator()
                    )
                )
                if (nameValidatorsComposer.isValid(text.toString())) {
                    inputFirstName.error = nameValidatorsComposer.getError()
                    viewModel.firstNameErrorLiveData.value = nameValidatorsComposer.getError()
                } else {
                    inputFirstName.error = null
                    viewModel.firstNameErrorLiveData.value = null
                }
            }

            editSecondName.doOnTextChanged { text, _, _, _ ->
                val nameValidatorsComposer: ValidatorComposer<String> = ValidatorComposer(
                    listOf(
                        EmptyValidator(),
                        NameValidator(),
                        AccessCharValidator()
                    )
                )
                if (nameValidatorsComposer.isValid(text.toString())) {
                    inputSecondName.error =
                        nameValidatorsComposer.getError()
                    viewModel.secondNameErrorLiveData.value = nameValidatorsComposer.getError()
                } else {
                    inputSecondName.error = null
                    viewModel.secondNameErrorLiveData.value = null
                }
            }

            editBirthDate.doOnTextChanged { text, _, _, _ ->
                val dateValidatorsComposer: ValidatorComposer<String> = ValidatorComposer(
                    listOf(
                        EmptyValidator()
                    )
                )
                if (dateValidatorsComposer.isValid(text.toString())) {
                    inputBirthDate.error = dateValidatorsComposer.getError()
                    viewModel.dateBirthErrorLiveData.value = dateValidatorsComposer.getError()
                } else {
                    inputBirthDate.error = null
                    viewModel.dateBirthErrorLiveData.value = null
                }
            }

            editPassword.doOnTextChanged { text, _, _, _ ->
                val passwordValidatorsComposer: ValidatorComposer<String> = ValidatorComposer(
                    listOf(
                        LengthValidator(),
                        LowerCaseValidator(),
                        UpperCaseValidator()
                    )
                )
                if (passwordValidatorsComposer.isValid(text.toString())) {
                    inputPassword.error = passwordValidatorsComposer.getError()
                    viewModel.passwordErrorLiveData.value = passwordValidatorsComposer.getError()
                } else {
                    inputPassword.error = null
                    viewModel.passwordErrorLiveData.value = null
                }
            }

            editConfirmPassword.doOnTextChanged { text, _, _, _ ->
                inputConfirmPassword.error = null
                if (text.toString() != editPassword.text.toString()) {
                    inputConfirmPassword.error = getString(R.string.password_not_match)
                    viewModel.confirmPasswordErrorLiveData.value =
                        inputConfirmPassword.error.toString()
                } else {
                    inputConfirmPassword.error = null
                    viewModel.confirmPasswordErrorLiveData.value = null
                }
            }
        }
    }
}