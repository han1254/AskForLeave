package com.neuqer.askforleave

import android.app.Application
import com.neuqer.askforleave.data.dao.IAskForLeaveRepository
import com.neuqer.askforleave.global.ServiceLocator

/**
 * Time:2020/10/5 19:22
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
class AskForLeaveApp: Application() {
    val repository: IAskForLeaveRepository
        get() = ServiceLocator.provideRepository(context = this)
}