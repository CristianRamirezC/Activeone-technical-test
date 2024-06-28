package com.activeone.activeonetechnichaltest.data.repository

import com.activeone.activeonetechnichaltest.data.database.dao.TransactionsDao
import com.activeone.activeonetechnichaltest.data.database.entities.TransactionEntity
import javax.inject.Inject

class TransactionsRepository @Inject constructor(
    private val transactionsDao: TransactionsDao
) {

    suspend fun storeTransactionDDBB(transaction: TransactionEntity) {
        transactionsDao.insertTransaction(transaction)
    }

    suspend fun getAllTransactionsDDBB(): List<TransactionEntity> {
        return transactionsDao.getAllTransactions()
    }

}