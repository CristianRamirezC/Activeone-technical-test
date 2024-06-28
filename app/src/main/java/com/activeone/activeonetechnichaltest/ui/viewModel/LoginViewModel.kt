package com.activeone.activeonetechnichaltest.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

): ViewModel() {

    private var _isLoginButtonEnabled: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoginButtonEnabled: LiveData<Boolean> = _isLoginButtonEnabled

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun onLoginChanged(userName: String, password: String) {
        _userName.value = userName
        _password.value = password

        _isLoginButtonEnabled.value = enableLoginButton(userName, password)
    }

    private fun enableLoginButton(userName: String, password: String): Boolean =
        userName.length > 5 && password.length > 5

}