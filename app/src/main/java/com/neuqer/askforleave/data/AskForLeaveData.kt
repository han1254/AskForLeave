package com.neuqer.askforleave.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

/**
 * Time:2020/10/5 15:17
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
@Entity(tableName = "ask_for_leave_table")
data class AskForLeaveData @JvmOverloads constructor(

    @ColumnInfo(name = "startDate")
    val startDate: String,

    @ColumnInfo(name = "endDate")
    val endDate: String,

    @ColumnInfo(name = "startTime")
    val startTime: String,

    @ColumnInfo(name = "endTime")
    val endTime: String,

    @ColumnInfo(name = "timeLength")
    val timeLength: String,

    @ColumnInfo(name = "teacherName")
    val teacherName: String,

    @ColumnInfo(name = "myName")
    val myName: String,

    @ColumnInfo(name = "reason")
    val reason: String,

    @ColumnInfo(name = "askId")
    val askId: String = UUID.randomUUID().toString()
): Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "positionId")
    var positionId: Int ?= null
    val combinationTime: String
        get() = "$startDate $startTime ~ $endDate $endTime($timeLength)"
}