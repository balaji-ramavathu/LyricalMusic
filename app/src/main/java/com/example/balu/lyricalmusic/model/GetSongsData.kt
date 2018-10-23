package com.example.balu.lyricalmusic.model

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.util.Log
import java.io.File
import java.util.jar.Manifest

class GetSongsData
{
    var fileList=ArrayList<String>()
    fun getDataFromStorage( /*root:String*/context:Context) : Cursor
    {
        /*try
        {
            var rootFolder=File(root)
            var canRead=rootFolder.canRead()
            Log.d("CAN READ", canRead.toString())

            var files=rootFolder.listFiles()
            for(file:File in files)
            {
                if(file.isDirectory )
                {
                    if(getDataFromStorage(file.absolutePath)!=null)
                    {
                        fileList.addAll(getDataFromStorage(file.absolutePath))
                    }
                    else
                    {
                        break
                    }

                }
                else if(file.name.endsWith(".mp3"))
                {

                    fileList.add(file.absolutePath)
                }
            }

        }
        catch (e:Exception)
        {
            Log.d("caught EXCEPTION",e.toString())
            fileList.add(e.toString())
        }

        return fileList*/


        var selection=MediaStore.Audio.Media.IS_MUSIC+" != 0"
        val projection= arrayOf(MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media._ID)


        var uri=MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

        var cursor=context.contentResolver.query(uri
                ,projection,selection,null,MediaStore.Audio.Media.TITLE)
        return cursor
    }


}