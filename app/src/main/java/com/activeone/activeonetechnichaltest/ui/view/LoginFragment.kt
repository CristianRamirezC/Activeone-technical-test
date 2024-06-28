package com.activeone.activeonetechnichaltest.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.activeone.activeonetechnichaltest.databinding.FragmentLoginBinding
import com.activeone.activeonetechnichaltest.ui.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    //ViewModels
    private val loginViewModel: LoginViewModel by viewModels()

    //Views
    private lateinit var userNameET: EditText
    private lateinit var passwordET: EditText
    private lateinit var loginBTN: Button

    private var _userName: String = ""
    private var _password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewBinding()
        setUpViewsListeners()
        setUpObservers()
        setupOnClickListeners()
    }

    private fun setupOnClickListeners() {
        val toTransactionsFragmentDirection: NavDirections =
            LoginFragmentDirections.actionLoginFragmentToTransactionsFragment()
        loginBTN.setOnClickListener{
            navigateToFragment(toTransactionsFragmentDirection)
        }
    }

    private fun navigateToFragment(direction: NavDirections) {
        val navController = findNavController()
        navController.navigate(direction)
    }

    private fun setUpObservers() {
        loginViewModel.userName.observe(viewLifecycleOwner) {
            _userName = it
        }

        loginViewModel.password.observe(viewLifecycleOwner) {
            _password = it
        }

        loginViewModel.isLoginButtonEnabled.observe(viewLifecycleOwner) {
            loginBTN.isEnabled = it
        }
    }

    private fun setUpViewsListeners() {
        userNameET.addTextChangedListener {
            loginViewModel.onLoginChanged(userName = it.toString(), password = _password)
        }

        passwordET.addTextChangedListener {
            loginViewModel.onLoginChanged(userName = _userName, password = it.toString())
        }
    }

    private fun setUpViewBinding() {
        userNameET = binding.etUserName
        passwordET = binding.etPassword
        loginBTN = binding.btnLogin
    }

}