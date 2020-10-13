package com.neuqer.askforleave.ask_for_leave.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.neuqer.askforleave.R
import com.neuqer.askforleave.data.AskForLeaveData
import com.neuqer.askforleave.databinding.FragmentLeaveDetailBinding
import com.neuqer.askforleave.global.getVMFactory


class LeaveDetailFragment : Fragment() {
    private val viewModel by viewModels<LeaveDetailViewModel> { getVMFactory() }
    private lateinit var viewDataBinding: FragmentLeaveDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewDataBinding = FragmentLeaveDetailBinding.bind(inflater.inflate(R.layout.fragment_leave_detail, container, false))
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.viewModel = viewModel
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item = arguments?.get("ask_for_leave_item") as AskForLeaveData
        viewModel.startTime.value = "${item.startDate} ${item.startTime}"
        viewModel.endTime.value = "${item.endDate} ${item.endTime}"
        viewModel.reason.value = item.reason
        viewModel.myName.value = "${item.myName} - 发起申请"
        viewModel.itsName.value = "[辅导员]${item.teacherName}-审批通过"

        viewDataBinding.detailImgBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}