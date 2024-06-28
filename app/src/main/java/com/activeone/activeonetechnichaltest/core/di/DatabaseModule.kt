package com.activeone.activeonetechnichaltest.core.di

import android.content.Context
import androidx.room.Room
import com.activeone.activeonetechnichaltest.core.Constants
import com.activeone.activeonetechnichaltest.data.database.TransactionsDatabase
import com.activeone.activeonetechnichaltest.data.database.dao.TransactionsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context): TransactionsDatabase =
        Room.databaseBuilder(context, TransactionsDatabase::class.java, Constants.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideTransactionsDao(db: TransactionsDatabase): TransactionsDao = db.getTransactionsDao()

}