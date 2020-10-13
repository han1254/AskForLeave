package com.neuqer.askforleave.data.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.ServiceLifecycleDispatcher
import com.neuqer.askforleave.data.AskForLeaveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Time:2020/10/5 19:04
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
class AskForLeaveDataSourceImpl(private val dao: AskForLeaveDao,
                                private val dispatcherIO: CoroutineDispatcher = Dispatchers.IO):
    IAskForLeaveDataSource{

    override suspend fun addItem(item: AskForLeaveData) = withContext(dispatcherIO) {
        dao.addItem(item)
    }
    override fun getItems(): LiveData<List<AskForLeaveData>> = dao.getItems()

    override suspend fun deleteItem(id: String) = withContext(dispatcherIO) {
        dao.deleteItem(id)
    }

}