package com.neuqer.askforleave.ask_for_leave.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.neuqer.askforleave.data.AskForLeaveData
import com.neuqer.askforleave.databinding.ItemAskForLeaveBinding

/**
 * Time:2020/10/5 22:32
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
class StartAskListAdapter(private val listener: OnItemClick): ListAdapter<AskForLeaveData, StartAskListViewHolder>(StartAskListDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartAskListViewHolder {
        return StartAskListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: StartAskListViewHolder, position: Int) {
        holder.bindView(getItem(position), listener)
    }
}

class StartAskListViewHolder(private val itemBinding: ItemAskForLeaveBinding): RecyclerView.ViewHolder(itemBinding.root) {

    fun bindView(item: AskForLeaveData, clickListener: OnItemClick) {
        itemBinding.item = item
        itemBinding.root.setOnClickListener {
            clickListener.onClick(it, item)
        }
        itemBinding.root.setOnLongClickListener {
            clickListener.onLongClick(it, item)
        }
        itemBinding.executePendingBindings()
    }
    companion object {
        fun from(parent: ViewGroup): StartAskListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemAskForLeaveBinding.inflate(layoutInflater, parent, false)

            return StartAskListViewHolder(binding)
        }
    }
}

class StartAskListDiffUtil: DiffUtil.ItemCallback<AskForLeaveData>() {
    override fun areItemsTheSame(oldItem: AskForLeaveData, newItem: AskForLeaveData): Boolean {
        return oldItem.positionId == newItem.positionId
    }

    override fun areContentsTheSame(oldItem: AskForLeaveData, newItem: AskForLeaveData): Boolean {
        return oldItem == newItem
    }

}


interface OnItemClick {

    fun onClick(view: View, item: AskForLeaveData)

    fun onLongClick(view: View, item: AskForLeaveData): Boolean
}