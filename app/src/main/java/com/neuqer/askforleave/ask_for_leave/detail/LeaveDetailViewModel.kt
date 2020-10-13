package com.neuqer.askforleave.ask_for_leave.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neuqer.askforleave.data.AskForLeaveData

/**
 * Time:2020/10/5 23:35
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
class LeaveDetailViewModel: ViewModel() {

    val startTime: MutableLiveData<String> = MutableLiveData()

    val endTime: MutableLiveData<String> = MutableLiveData()

    val reason: MutableLiveData<String> = MutableLiveData()

    val myName: MutableLiveData<String> = MutableLiveData()

    val itsName: MutableLiveData<String> = MutableLiveData()


}