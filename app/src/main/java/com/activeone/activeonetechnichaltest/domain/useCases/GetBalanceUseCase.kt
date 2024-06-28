package com.activeone.activeonetechnichaltest.domain.useCases

import com.activeone.activeonetechnichaltest.data.model.TransactionModel
import javax.inject.Inject

class GetBalanceUseCase @Inject constructor(
    private val getAllTransactionsUseCase: GetAllTransactionsUseCase
) {

    suspend operator fun invoke(): Double {
        val allTransactions: List<TransactionModel> = getAllTransactionsUseCase()
        var result = 0.0

        for (transaction in allTransactions) {
            result += transaction.transactionValue
        }

        return result
    }
}