package com.activeone.activeonetechnichaltest.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.activeone.activeonetechnichaltest.data.model.TransactionModel
import com.activeone.activeonetechnichaltest.domain.useCases.GetAllTransactionsUseCase
import com.activeone.activeonetechnichaltest.domain.useCases.GetBalanceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val getBalanceUseCase: GetBalanceUseCase,
    private val getAllTransactionsUseCase: GetAllTransactionsUseCase
): ViewModel(){

    private var _allTransactions: MutableLiveData<List<TransactionModel>> = MutableLiveData()
    val allTransactions: LiveData<List<TransactionModel>> = _allTransactions

    private var _balance: MutableLiveData<Double> = MutableLiveData()
    val balance: LiveData<Double> = _balance

    fun calculateBalance() {
        viewModelScope.launch(Dispatchers.IO) {
            val balance = getBalanceUseCase()
            _balance.postValue(balance)
        }
    }

    fun getAllTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            val transactions = getAllTransactionsUseCase()
            _allTransactions.postValue(transactions)
        }
    }

}