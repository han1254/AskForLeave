package com.neuqer.askforleave.data

/**
 * Time:2020/10/13 16:54
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
interface IAskForLeaveData {
    enum class DataType {
        NORMAL,

        FOOTER
    }

    fun dataType(): DataType
}