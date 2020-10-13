package com.neuqer.askforleave.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

/**
 * Time:2020/10/5 21:30
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */

object DateTimeUtils {
    //1 minute = 60 seconds
    //1 hour = 60 x 60 = 3600
    //1 day = 3600 x 24 = 86400
    fun printDifference(startDate: Date, endDate: Date): DateDistance {

        //milliseconds
        var different = endDate.time - startDate.time
//        println("startDate : $startDate")
//        println("endDate : $endDate")
//        println("different : $different")
        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24
        val elapsedDays = different / daysInMilli
        different %= daysInMilli
        val elapsedHours = different / hoursInMilli
        different %= hoursInMilli
        val elapsedMinutes = different / minutesInMilli
        different %= minutesInMilli
        val elapsedSeconds = different / secondsInMilli
//        System.out.printf(
//            "%d days, %d hours, %d minutes, %d seconds%n",
//            elapsedDays,
//            elapsedHours, elapsedMinutes, elapsedSeconds
//        )
        return DateDistance(elapsedDays.toInt(), elapsedHours.toInt(), elapsedMinutes.toInt())
    }

    @SuppressLint("SimpleDateFormat")
    fun buildDate(year: Int, month: Int, day: Int, hour: Int, minute: Int): Date {
        val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm")
        val parseStr = "$day/$month/$year $hour:$minute"
        return simpleDateFormat.parse(parseStr)
    }

}

data class DateDistance(val dDays: Int, val dHours: Int, val dMinute: Int)