package com.example.balu.lyricalmusic

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var fab:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab=findViewById(R.id.fab);
        fab.setOnClickListener(View.OnClickListener
        {
            var i=Intent(this,AddSongs::class.java)
            startActivity(i)

            Log.d("fab ","clicked")

        })

        if(shouldAskPermission())
        {
            askPermissions()
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
