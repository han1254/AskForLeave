package com.neuqer.askforleave.ask_for_leave.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neuqer.askforleave.data.dao.IAskForLeaveRepository
import com.neuqer.askforleave.util.DateTimeUtils
import kotlinx.coroutines.launch
import java.time.Duration

/**
 * Time:2020/10/5 19:32
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
class CreateLeaveViewModel(private val repo: IAskForLeaveRepository): ViewModel() {

    var startDate: MutableLiveData<String> = MutableLiveData("开始日期：01.01")
    var endDate: MutableLiveData<String> = MutableLiveData("开始时间：01.01")

    var startTime: MutableLiveData<String> = MutableLiveData("结束日期：00:00")
    var endTime: MutableLiveData<String> = MutableLiveData("结束时间：00:00")


    fun addItem(
        startDate: String,
        endDate: String,
        startTime: String,
        endTime: String,
        duration: String,
        teacherName: String,
        myName: String,
        reason: String
    ) {
        viewModelScope.launch {

            repo.addItem(
                startDate,
                endDate,
                startTime,
                endTime,
                duration,
                teacherName,
                myName,
                reason
            )
        }
    }

}