package com.activeone.activeonetechnichaltest.domain.useCases

import com.activeone.activeonetechnichaltest.data.model.TransactionModel
import com.activeone.activeonetechnichaltest.data.model.toModel
import com.activeone.activeonetechnichaltest.data.repository.TransactionsRepository
import javax.inject.Inject

class GetAllTransactionsUseCase @Inject constructor(
    private val transactionsRepository: TransactionsRepository
) {

    suspend operator fun invoke(): List<TransactionModel> {
        return transactionsRepository.getAllTransactionsDDBB().map {
            it.toModel()
        }
    }
}