package com.neuqer.askforleave.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.neuqer.askforleave.data.AskForLeaveData

/**
 * Time:2020/10/5 18:45
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
@Dao
interface AskForLeaveDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addItem(item: AskForLeaveData)

    @Query("SELECT * FROM ask_for_leave_table ORDER BY askId DESC")
    fun getItems(): LiveData<List<AskForLeaveData>>

    @Query("DELETE FROM ask_for_leave_table WHERE askId = :uuid")
    fun deleteItem(uuid: String)

}