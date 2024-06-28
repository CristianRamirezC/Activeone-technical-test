package com.activeone.activeonetechnichaltest.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.activeone.activeonetechnichaltest.data.model.TransactionModel
import com.activeone.activeonetechnichaltest.domain.useCases.SaveTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTransactionViewModel @Inject constructor(
    private val saveTransactionUseCase: SaveTransactionUseCase
) : ViewModel() {

    fun saveTransaction(transaction: TransactionModel) {
        viewModelScope.launch(Dispatchers.IO) {
            saveTransactionUseCase(transaction)
        }
    }
}