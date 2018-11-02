package com.example.balu.lyricalmusic.viewmvp

import android.database.Cursor
import java.io.Serializable
import java.math.RoundingMode

class SelectSongsObject():Serializable
{
    lateinit var songTitle:String
    lateinit var songArtist:String
    lateinit var songAlbum:String
    lateinit var songDuration:String
    var isChecked:Boolean=false

    fun isSelected():Boolean
    {
        return isChecked
    }
    fun setSelected(isChecked: Boolean)
    {
        this.isChecked=isChecked

    }


     /*var songTitle:String=cursor.getString(0)
     var songArtist:String=cursor.getString(1)
     var songAlbum:String=cursor.getString(2)
     var tmpDuration:Double =  (cursor.getDouble(3)/60000)
     var songDuration=tmpDuration.toBigDecimal().setScale(2,RoundingMode.UP)*/

}