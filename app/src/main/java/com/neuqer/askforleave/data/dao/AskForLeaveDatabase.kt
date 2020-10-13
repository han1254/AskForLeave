package com.neuqer.askforleave.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.neuqer.askforleave.data.AskForLeaveData

/**
 * Time:2020/10/5 18:50
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
@Database(entities = [AskForLeaveData::class], version = 1, exportSchema = false)
abstract class AskForLeaveDatabase: RoomDatabase() {

    abstract fun getDao(): AskForLeaveDao

}