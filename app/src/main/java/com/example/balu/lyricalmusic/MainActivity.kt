package com.example.balu.lyricalmusic

import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.balu.lyricalmusic.viewmvp.SelectSongsObject

class MainActivity : AppCompatActivity()
{
    lateinit var fab:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tvNoSongs=findViewById<TextView>(R.id.tv_no_songs_added)

        fab=findViewById(R.id.fab)
        fab.setOnClickListener(View.OnClickListener
        {
            var i=Intent(this,AddSongs::class.java)
            startActivityForResult(i,2)
            //startActivity(i)

            Log.d("fab ","clicked")

        })

        if(shouldAskPermission())
        {
            askPermissions()
        }

        /*var intent=intent
        if(intent!=null)
        {
            if(intent.getSerializableExtra("SONG")!=null)
            {
                var selectedSongsList:ArrayList<SelectSongsObject>
                selectedSongsList=intent.getSerializableExtra("SONG") as ArrayList<SelectSongsObject>
                Log.d("SSL ${selectedSongsList.size}",selectedSongsList.get(0).songTitle)
            }

        }*/



    }

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

         if(resultCode==2)
         {
             var selectedSongsList:ArrayList<SelectSongsObject>
             selectedSongsList= data?.getSerializableExtra("SONGS") as ArrayList<SelectSongsObject>
             Log.d("SSL ${selectedSongsList.size}",selectedSongsList.get(0).songTitle)
             var rvSelectedSongs:RecyclerView=findViewById(R.id.rv_selected_songs)
             var tvNoSongs:TextView=findViewById(R.id.tv_no_songs_added)
             rvSelectedSongs.visibility=View.VISIBLE
             tvNoSongs.visibility=View.GONE
             var rvAdapter=SelectedSongsAdapter(selectedSongsList,this)
             var layoutManager= LinearLayoutManager(this)
             rvSelectedSongs.layoutManager= layoutManager
             rvSelectedSongs.adapter=rvAdapter


         }
    }




    fun shouldAskPermission():Boolean
    {
        return (Build.VERSION.SDK_INT> Build.VERSION_CODES.LOLLIPOP_MR1)
    }
    @TargetApi(23)
    fun askPermissions()
    {
        val permission= arrayOf("android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE")
        var requestCode=200
        requestPermissions(permission,requestCode)
    }


}
