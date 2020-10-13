package com.neuqer.askforleave.ask_for_leave.create

import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.neuqer.askforleave.R
import com.neuqer.askforleave.databinding.FragmentCreateLeaveBinding
import com.neuqer.askforleave.global.getVMFactory
import com.neuqer.askforleave.util.DateTimeUtils
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import java.util.*
import kotlin.math.min


class CreateLeaveFragment : Fragment() {

    private val viewModel by viewModels<CreateLeaveViewModel> { getVMFactory() }
    private lateinit var viewDataBinding: FragmentCreateLeaveBinding
    private val now: Calendar = Calendar.getInstance()
    private lateinit var dpdStartDate: DatePickerDialog
    private lateinit var dpdStartTime: TimePickerDialog
    private lateinit var dpdEndDate: DatePickerDialog
    private lateinit var dpdEndTime: TimePickerDialog
    private var startMonth = 1
    private var endMonth = 1
    private var startDay = 1
    private var endDay = 1
    private var startHour = 0
    private var endHour = 0
    private var startMinute = 0
    private var endMinute = 0
    private var startYear = 0
    private var endYear = 0
    private var duration = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewDataBinding = FragmentCreateLeaveBinding.bind(inflater.inflate(
            R.layout.fragment_create_leave,
            container,
            false)
        )
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.viewModel = viewModel
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPicker()
        viewDataBinding.createStartDateSelect.setOnClickListener {

            activity?.supportFragmentManager?.let { it1 -> dpdStartDate.show(it1, "test") }

        }

        viewDataBinding.createStartTimeSelect.setOnClickListener {
            activity?.supportFragmentManager?.let { it1 -> dpdStartTime.show(it1, "test") }
        }

        viewDataBinding.createEndDateSelect.setOnClickListener {
            activity?.supportFragmentManager?.let { it1 -> dpdEndDate.show(it1, "test") }
        }

        viewDataBinding.createEndTimeSelect.setOnClickListener {
            activity?.supportFragmentManager?.let { it1 -> dpdEndTime.show(it1, "test") }
        }

        viewDataBinding.createBtnConfirm.setOnClickListener {

//            if (endMonth < startMonth) {
//                timeErrorInfo()
//            } else if (endMonth == startMonth){
//                if (endDay < startDay) {
//                    timeErrorInfo()
//                } else if (endDay == startDay) {
//                   if (endHour < startHour) {
//                       timeErrorInfo()
//                   } else if (endHour == startHour) {
//                       if (endMinute < startMinute) {
//                           timeErrorInfo()
//                       }
//                   }
//                }
//            }
            val dateFrom = DateTimeUtils.buildDate(startYear, startMonth, startDay, startHour, startMinute)
            val dateTo = DateTimeUtils.buildDate(endYear, endMonth, endDay, endHour, endMinute)

            val dateDis = DateTimeUtils.printDifference(dateFrom, dateTo)
            duration = "共"
            if (dateDis.dDays > 0) {
                duration += "${dateDis.dDays}天"
            }
            if (dateDis.dHours > 0) {
                duration += "${dateDis.dHours}小时"
            }
            if (dateDis.dMinute > 0) {
                duration += "${dateDis.dMinute}分钟"
            }

            viewModel.addItem(
                "${if (startMonth < 10) "0" else ""}$startMonth-${if (startDay < 10) "0" else ""}$startDay",
                "${if (endMonth < 10) "0" else ""}$endMonth-${if (endDay < 10) "0" else ""}$endDay",
                "${if (startHour < 10) "0" else ""}$startHour:${if (startMinute < 10) "0" else ""}$startMinute",
                "${if (endHour < 10) "0" else ""}$endHour:${if (endMinute < 10) "0" else ""}$endMinute",
                duration,
                viewDataBinding.createTxtEditItsName.text.toString().trim(),
                viewDataBinding.createEditMyName.text.toString().trim(),
                viewDataBinding.createTxtEditReason.text.toString().trim()
            )
        }
    }


    private fun timeErrorInfo() {
        Toast.makeText(activity, "检查检查哪里写错了", Toast.LENGTH_SHORT).show()
    }

    private fun initPicker() {

        dpdStartDate = DatePickerDialog.newInstance(
            { _, year, monthOfYear, dayOfMonth ->
                val realMonth = monthOfYear + 1
                startYear = year
                startMonth = realMonth
                startDay = dayOfMonth
                var realMonthStr = realMonth.toString()
                var dayOfMonthStr = dayOfMonth.toString()
                if (realMonth < 10)
                    realMonthStr = "0$realMonthStr"
                if (dayOfMonth < 10)
                    dayOfMonthStr = "0$dayOfMonthStr"

                viewModel.startDate.value = "开始日期：$realMonthStr-$dayOfMonthStr" },
            now.get(Calendar.YEAR),  // Initial year selection
            now.get(Calendar.MONTH),  // Initial month selection
            now.get(Calendar.DAY_OF_MONTH) // Inital day selection
        )

        dpdStartTime = TimePickerDialog.newInstance(
            { view, hourOfDay, minute, second ->
                startHour = hourOfDay
                startMinute = minute
                val hourStr = if (hourOfDay < 10) "0$hourOfDay" else hourOfDay.toString()
                val minuteStr: String = if(minute < 10) "0$minute" else minute.toString()
                viewModel.startTime.value = "开始时间：$hourStr:$minuteStr"
            },
            now.get(Calendar.DAY_OF_MONTH),
            now.get(Calendar.MINUTE),
            true
        )

        dpdEndDate = DatePickerDialog.newInstance(
            { _, year, monthOfYear, dayOfMonth ->
                val realMonth = monthOfYear + 1
                endYear = year
                endMonth = realMonth
                endDay = dayOfMonth
                var realMonthStr = realMonth.toString()
                var dayOfMonthStr = dayOfMonth.toString()
                if (realMonth < 10)
                    realMonthStr = "0$realMonthStr"
                if (dayOfMonth < 10)
                    dayOfMonthStr = "0$dayOfMonthStr"

                viewModel.endDate.value = "结束日期：$realMonthStr-$dayOfMonthStr" },
            now.get(Calendar.YEAR),  // Initial year selection
            now.get(Calendar.MONTH),  // Initial month selection
            now.get(Calendar.DAY_OF_MONTH) // Inital day selection
        )

        dpdEndTime = TimePickerDialog.newInstance(
            { view, hourOfDay, minute, second ->
                endHour = hourOfDay
                endMinute = minute
                val hourStr = if (hourOfDay < 10) "0$hourOfDay" else hourOfDay.toString()
                val minuteStr: String = if(minute < 10) "0$minute" else minute.toString()
                viewModel.endTime.value = "结束时间：$hourStr:$minuteStr"
            },
            now.get(Calendar.DAY_OF_MONTH),
            now.get(Calendar.MINUTE),
            true
        )

    }
}