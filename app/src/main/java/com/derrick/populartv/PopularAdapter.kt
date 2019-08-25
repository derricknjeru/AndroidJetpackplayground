package com.derrick.populartv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.derrick.database.Show
import com.derrick.populartv.PopularAdapter.ViewHolder.Companion.from
import android.app.Activity
import android.app.Application
import com.derrick.R
import com.derrick.database.GenresOperator
import com.derrick.util.SampleData


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
        val txt_genre: TextView = itemView.findViewById(R.id.show_genres)

        fun bind(show: Show) {
            //val res = itemView.context.resources
            val app = requireNotNull(itemView.context as Activity).application
            txt_genre.text = genresByName(app, show)
            title.text = show.name
        }

        private fun genresByName(
            app: Application,
            show: Show
        ): String {
            val genresData = SampleData.getGenres(app)
            //operator overload
            val genres = GenresOperator(genresData)

            val listOfGenres = mutableListOf<String>()
            //getting genres names
            show.genreIds?.forEach {
                listOfGenres.add(genres[it].name)
            }
            return listOfGenres.joinToString()
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