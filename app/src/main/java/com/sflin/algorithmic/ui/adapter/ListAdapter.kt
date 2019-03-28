package com.sflin.algorithmic.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sflin.algorithmic.R

/**
 * Created by MagicFrost
 *
 */
class ListAdapter(private val mList: MutableList<String>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var mOnCallBack: OnCallBack? = null

    interface OnCallBack {
        fun onClick(name:String)
    }

    fun setOnClickListener(mOnCallBack: OnCallBack) {
        this.mOnCallBack = mOnCallBack
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adpter_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        holder.mName.text = mList[position]

        holder.itemView.setOnClickListener {
            mOnCallBack?.let {
                mOnCallBack!!.onClick(mList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mName: TextView = itemView.findViewById(R.id.name)
    }
}