package com.example.balu.lyricalmusic


import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.example.balu.lyricalmusic.model.GetSongsData
import com.example.balu.lyricalmusic.viewmvp.SelectSongsObject
import java.time.Duration
import java.util.jar.Manifest

class AddSongs : AppCompatActivity()
{
    var songsTitles=ArrayList<String>()
    var selectSongsList=ArrayList<SelectSongsObject>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_songs)

        /*if(shouldAskPermission())
        {
            askPermissions()
        }*/
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)
                ==PackageManager.PERMISSION_GRANTED)
        {
            createPlayer()
        }
        else
        {
            Log.d("permission","denges")
        }





        var recyclerView=findViewById<RecyclerView>(R.id.rv_add_songs)
        var recyclerAdapter=SelectSongsRecyclerAdapter(selectSongsList,this)
        var layoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager= layoutManager as RecyclerView.LayoutManager?
        recyclerView.adapter=recyclerAdapter




    }

     /*override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
         if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
         {
             createPlayer()
             Log.d("create player","worked aft request")

         }
         else
         {
             Toast.makeText(this,"Permission denied",Toast.LENGTH_LONG)
             Log.d("permission denied",grantResults[0].toString())
         }
     }*/
    fun createPlayer()
    {
        val getSongsData=GetSongsData()

        /*songsPaths=getSongsData.getDataFromStorage(Environment.getExternalStorageDirectory().absolutePath)
        Log.d("environment data",Environment.getExternalStorageDirectory().toString())

        songsPaths.add(songsPaths.size.toString())
        songsPaths.add(Environment.getExternalStorageDirectory().absolutePath)
        songsPaths.add(Environment.getRootDirectory().absolutePath)*/

        val cursor=getSongsData.getDataFromStorage(this)

        if(cursor!=null)
        {

            cursor.moveToFirst()

            while (cursor.moveToNext())
            {

                var songsObject=SelectSongsObject()
                songsObject.songTitle=cursor.getString(0)
                songsObject.songArtist=cursor.getString(1)
                songsObject.songAlbum=cursor.getString(2)
                var duration=convertCursorDuration(cursor.getLong(3))
                songsObject.songDuration=duration

                selectSongsList.add(songsObject)
            }
        }
        else
        {

        }
    }
    fun convertCursorDuration(cursorDuration:Long) :String
    {
        var seconds=cursorDuration/1000
        lateinit var duration:String
        var minutes=seconds/60
        seconds=seconds%60
        if(seconds<10)
        {
             duration= minutes.toString()+":0"+seconds.toString()
        }
        else
        {
            duration=minutes.toString()+":"+seconds.toString()
        }
        return duration


    }
    /*fun shouldAskPermission():Boolean
    {
        return (Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP_MR1)
    }
    @TargetApi(23)
    fun askPermissions()
    {
        val permission= arrayOf("android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE")
        var requestCode=200
        requestPermissions(permission,requestCode)
    }*/
}
