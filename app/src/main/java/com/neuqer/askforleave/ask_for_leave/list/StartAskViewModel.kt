package com.neuqer.askforleave.ask_for_leave.list

import androidx.lifecycle.*
import com.neuqer.askforleave.data.AskForLeaveData
import com.neuqer.askforleave.data.dao.IAskForLeaveRepository
import kotlinx.coroutines.launch

/**
 * Time:2020/10/5 19:35
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
class StartAskViewModel(private val repo: IAskForLeaveRepository): ViewModel() {

    var items: LiveData<List<AskForLeaveData>> = repo.getItems().distinctUntilChanged()
    var tempSelectedStr: String = ""

    fun deleteItem() {
        if (tempSelectedStr.isNotEmpty()) {
            viewModelScope.launch {
                repo.deleteItem(tempSelectedStr)
            }
        }
    }

}