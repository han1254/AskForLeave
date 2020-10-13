package com.neuqer.askforleave.global

import androidx.fragment.app.Fragment
import com.neuqer.askforleave.AskForLeaveApp

/**
 * Time:2020/10/5 19:28
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
fun Fragment.getVMFactory(): AskForLeaveViewModelFactory {

    val repo = (activity?.application as AskForLeaveApp).repository
    return AskForLeaveViewModelFactory(this, null, repo)

}