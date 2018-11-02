package com.example.balu.lyricalmusic

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.add_songs_item.view.*
import com.example.balu.lyricalmusic.viewmvp.SelectSongsObject
import kotlinx.android.synthetic.main.added_songs_item.view.*

class SelectedSongsAdapter(val selectSongsList:ArrayList<SelectSongsObject>
                                 ,val context:Context) :RecyclerView.Adapter<SelectedViewHolder>()
{


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SelectedViewHolder
    {
        return SelectedViewHolder(LayoutInflater.from(context).inflate(R.layout.added_songs_item,p0,false))
    }

    override fun onBindViewHolder(p0: SelectedViewHolder, p1: Int)
    {
        p0.tvtitle.setText(selectSongsList.get(p1).songTitle)
        p0.tvArtist.setText(selectSongsList.get(p1).songArtist)

    }



    override fun getItemCount(): Int {
        Log.d("getItemCount",selectSongsList.size.toString())
        return selectSongsList.size
    }
}

class SelectedViewHolder(view :View) : RecyclerView.ViewHolder( view)
{

    val tvtitle=view.tv_added_song_title
    val tvArtist=view.tv_added_song_artist


}