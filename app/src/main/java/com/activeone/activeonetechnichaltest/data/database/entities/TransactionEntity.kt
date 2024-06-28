package com.activeone.activeonetechnichaltest.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.activeone.activeonetechnichaltest.core.Constants
import com.activeone.activeonetechnichaltest.data.model.TransactionModel

@Entity(Constants.TRANSACTIONS_TABLE_NAME)
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "transaction_concept")
    val transactionConcept: String,

    @ColumnInfo(name = "transaction_value")
    val transactionValue: Double
)

fun TransactionModel.toEntity() = TransactionEntity(
    transactionConcept = transactionConcept,
    transactionValue = transactionValue
)
