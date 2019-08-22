package com.derrick.populartv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.derrick.R
import com.derrick.database.Show
import com.derrick.populartv.PopularAdapter.ViewHolder.Companion.from

class PopularAdapter : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    var data = listOf<Show>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val show = data[position]
        holder.bind(show)
    }


    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster: ImageView = itemView.findViewById(R.id.poster)
        val title: TextView = itemView.findViewById(R.id.show_title)

        fun bind(show: Show) {
            //val res = itemView.context.resources
            title.text = show.originalName
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.show_item, parent, false)
                return ViewHolder(view)
            }
        }
    }


}