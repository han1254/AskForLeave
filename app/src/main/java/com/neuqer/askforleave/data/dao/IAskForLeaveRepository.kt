package com.neuqer.askforleave.data.dao

import androidx.lifecycle.LiveData
import com.neuqer.askforleave.data.AskForLeaveData

/**
 * Time:2020/10/5 18:53
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
interface IAskForLeaveRepository {

    suspend fun addItem(
        startDate: String,
        endDate: String,
        startTime: String,
        endTime: String,
        duration: String,
        teacherName: String,
        myName: String,
        reason: String
    )

    fun getItems(): LiveData<List<AskForLeaveData>>

    suspend fun deleteItem(id: String)

}