package com.example.motionlayoutexamples

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val data: Array<Demo>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_item, parent, false) as ConstraintLayout
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.layoutFileId = data[position].layout
        holder.activity = data[position].activity
        holder.exampleType = data[position].type
        holder.title.text = data[position].title
    }

    override fun getItemCount(): Int =data.size

    class ViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout) {
        var title = layout.findViewById(R.id.titleTextView) as TextView
        var rootLayout = layout.findViewById(R.id.rootLayout) as ConstraintLayout
        var layoutFileId = 0
        var activity: Class<*>? = null
        var exampleType: Types? = null

        init {
            layout.setOnClickListener {
                val context = it?.context as MainActivity
                activity?.let {
                    context.start(it, layoutFileId, exampleType, layoutPosition)
                }

            }
        }
    }
}