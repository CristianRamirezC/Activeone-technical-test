package com.activeone.activeonetechnichaltest.domain.useCases

import com.activeone.activeonetechnichaltest.data.database.entities.toEntity
import com.activeone.activeonetechnichaltest.data.model.TransactionModel
import com.activeone.activeonetechnichaltest.data.repository.TransactionsRepository
import javax.inject.Inject

class SaveTransactionUseCase @Inject constructor(
    private val transactionsRepository: TransactionsRepository
) {

    suspend operator fun invoke(transactionToSave: TransactionModel) {
        transactionsRepository.storeTransactionDDBB(transactionToSave.toEntity())
    }
}