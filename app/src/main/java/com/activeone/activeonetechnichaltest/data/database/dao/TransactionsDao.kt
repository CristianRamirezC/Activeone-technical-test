package com.activeone.activeonetechnichaltest.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.activeone.activeonetechnichaltest.core.Constants
import com.activeone.activeonetechnichaltest.data.database.entities.TransactionEntity

@Dao
interface TransactionsDao {

    @Query("SELECT * FROM ${Constants.TRANSACTIONS_TABLE_NAME}")
    suspend fun getAllTransactions(): List<TransactionEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTransaction(transaction: TransactionEntity)


}