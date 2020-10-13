package com.neuqer.askforleave.global

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.neuqer.askforleave.ask_for_leave.create.CreateLeaveViewModel
import com.neuqer.askforleave.ask_for_leave.detail.LeaveDetailViewModel
import com.neuqer.askforleave.ask_for_leave.list.StartAskViewModel
import com.neuqer.askforleave.data.dao.IAskForLeaveRepository
import java.lang.Exception
import java.lang.IllegalArgumentException

/**
 * Time:2020/10/5 19:25
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
@Suppress("UNCHECKED_CAST")
class AskForLeaveViewModelFactory(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle ?= null,
    private val repo: IAskForLeaveRepository)
    : AbstractSavedStateViewModelFactory(owner,
    defaultArgs) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = with(modelClass){
        when {
            isAssignableFrom(CreateLeaveViewModel::class.java)
                    -> CreateLeaveViewModel(repo)
            isAssignableFrom(StartAskViewModel::class.java)
                    -> StartAskViewModel(repo)
            isAssignableFrom(LeaveDetailViewModel::class.java)
                    -> LeaveDetailViewModel()
            else
                -> throw IllegalArgumentException("unknown type of viewModel")
        }
    } as T
}