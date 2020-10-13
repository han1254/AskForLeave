package com.neuqer.askforleave.global

import android.content.Context
import androidx.room.Room
import com.neuqer.askforleave.data.dao.*

/**
 * Time:2020/10/5 18:44
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */

object ServiceLocator {

    private var mDatabase: AskForLeaveDatabase ?= null
    @Volatile
    var repository: IAskForLeaveRepository ?= null

    fun provideRepository(context: Context): IAskForLeaveRepository {
        synchronized(this) {
            return repository
                ?: createRepository(
                    context
                )
        }
    }

    private fun createRepository(context: Context): IAskForLeaveRepository {
        val repo = AskForLeaveRepositoryImpl(
            provideDataSource(
                context
            )
        )
        repository = repo
        return repo
    }

    private fun provideDataSource(context: Context): IAskForLeaveDataSource {
        val database = mDatabase
            ?: createDataBase(
                context
            )
        return AskForLeaveDataSourceImpl(database.getDao())
    }

    private fun createDataBase(context: Context): AskForLeaveDatabase {
        val database = Room.databaseBuilder(
            context,
            AskForLeaveDatabase::class.java,
            "ask_for_leave.db"
        ).build()
        mDatabase = database
        return database
    }

}