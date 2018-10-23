package com.example.balu.lyricalmusic

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.add_songs_item.view.*
import com.example.balu.lyricalmusic.viewmvp.SelectSongsObject

class SelectSongsRecyclerAdapter(val selectSongsList:ArrayList<SelectSongsObject>
                                 ,val context:Context) :RecyclerView.Adapter<ViewHolder>()
{

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder
    {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.add_songs_item,p0,false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int)
    {
        p0.tvtitle.setText(selectSongsList.get(p1).songTitle)
        p0.tvalbum.setText(selectSongsList.get(p1).songAlbum)
        p0.tvduration.setText(selectSongsList.get(p1).songDuration.toString())
        p0.tvArtist.setText(selectSongsList.get(p1).songArtist)



    }

    override fun getItemCount(): Int {
        Log.d("getItemCount",selectSongsList.size.toString())
        return selectSongsList.size
    }
}

    class ViewHolder(view :View) : RecyclerView.ViewHolder( view)
    {
        val tvtitle=view.song_title
        val tvalbum=view.song_album
        val tvduration=view.song_duration
        val tvArtist=view.tvartist




    }