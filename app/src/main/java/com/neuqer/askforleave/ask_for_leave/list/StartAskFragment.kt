package com.neuqer.askforleave.ask_for_leave.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ListAdapter
import com.neuqer.askforleave.R
import com.neuqer.askforleave.data.AskForLeaveData
import com.neuqer.askforleave.databinding.FragmentStartAskBinding
import com.neuqer.askforleave.global.getVMFactory
import java.util.*
import java.util.stream.Collectors


class StartAskFragment : Fragment() {

    lateinit var viewDataBinding: FragmentStartAskBinding
    val viewModel by viewModels<StartAskViewModel> { getVMFactory() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_start_ask, container, false)
        viewDataBinding = FragmentStartAskBinding.bind(view)
        viewDataBinding.lifecycleOwner = this
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel.refresh()
        viewDataBinding.startAskBtnStart.setOnClickListener {
            findNavController().navigate(R.id.action_startAskFragment_to_createLeaveFragment)
        }
//        viewDataBinding.startAskImgBack.setOnClickListener {
//            findNavController().navigate(R.id.action_startAskFragment_to_leaveDetailFragment)
//        }

        viewDataBinding.startAskRecyclerview.adapter = StartAskListAdapter(object : OnItemClick {
            override fun onClick(view: View, item: AskForLeaveData) {
//                Toast.makeText(activity, "点击", Toast.LENGTH_SHORT).show()
                val bundle = Bundle()
                bundle.putSerializable("ask_for_leave_item", item)
                findNavController().navigate(R.id.action_startAskFragment_to_leaveDetailFragment, bundle)
            }

            override fun onLongClick(view: View, item: AskForLeaveData): Boolean {
                Toast.makeText(activity, "长按", Toast.LENGTH_SHORT).show()
                return true
            }

        })

        viewModel.items.observe(this as LifecycleOwner,
            Observer<List<AskForLeaveData>> {
                (viewDataBinding.startAskRecyclerview.adapter as StartAskListAdapter).submitList(it)
            })
    }
}