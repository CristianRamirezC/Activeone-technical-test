package com.activeone.activeonetechnichaltest.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.activeone.activeonetechnichaltest.core.Constants

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
