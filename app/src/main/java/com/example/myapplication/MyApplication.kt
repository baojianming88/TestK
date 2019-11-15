package com.example.myapplication

import android.app.Application
import android.content.Context

/**
 * @author bao
 * @description:
 * @date :2019/11/14 17:23
 */
class MyApplication: Application() {
   companion object{
      var applicationInstance:MyApplication?=null
   }


    override fun onCreate() {
        super.onCreate()
        applicationInstance=this
    }
}