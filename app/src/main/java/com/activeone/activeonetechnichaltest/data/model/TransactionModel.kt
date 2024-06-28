package com.activeone.activeonetechnichaltest.data.model

import com.activeone.activeonetechnichaltest.data.database.entities.TransactionEntity

data class TransactionModel(
    val transactionConcept: String,
    val transactionValue: Double
)

fun TransactionEntity.toModel() = TransactionModel(
    transactionConcept = transactionConcept,
    transactionValue = transactionValue
)
