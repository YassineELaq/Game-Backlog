package com.example.level5gamebacklog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.level5gamebacklog.R
import com.example.level5gamebacklog.model.Game
import kotlinx.android.synthetic.main.item_games.view.*

class GameAdapter (private val games: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(game: Game) {
            itemView.tv_titel.text = game.tile
            itemView.tv_platform.text = game.platform
            itemView.tv_date.text = game.gameDate.toString()

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_games, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }


}