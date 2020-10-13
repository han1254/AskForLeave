package com.neuqer.askforleave.data.dao

import androidx.lifecycle.LiveData
import com.neuqer.askforleave.data.AskForLeaveData

/**
 * Time:2020/10/5 18:59
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
class AskForLeaveRepositoryImpl(private val dataSource: IAskForLeaveDataSource)
    : IAskForLeaveRepository {

    override suspend fun addItem(
        startDate: String,
        endDate: String,
        startTime: String,
        endTime: String,
        duration: String,
        teacherName: String,
        myName: String,
        reason: String
    ) {



        val item = AskForLeaveData(
            startDate = startDate,
            endDate = endDate,
            startTime = startTime,
            endTime = endTime,
            timeLength = duration,
            teacherName = teacherName,
            myName = myName,
            reason = reason
        )
        dataSource.addItem(item)
    }

    override fun getItems(): LiveData<List<AskForLeaveData>> = dataSource.getItems()

    override suspend fun deleteItem(id: String) = dataSource.deleteItem(id)
}