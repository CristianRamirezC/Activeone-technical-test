package com.activeone.activeonetechnichaltest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.activeone.activeonetechnichaltest.data.database.dao.TransactionsDao
import com.activeone.activeonetechnichaltest.data.database.entities.TransactionEntity

@Database(
    entities = [TransactionEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TransactionsDatabase: RoomDatabase() {

    abstract fun getTransactionsDao(): TransactionsDao
}