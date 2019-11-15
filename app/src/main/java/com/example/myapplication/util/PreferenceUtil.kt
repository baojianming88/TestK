package com.example.myapplication.util

import android.content.Context
import android.content.SharedPreferences
import com.example.myapplication.MyApplication

/**
 * @author bao
 * @description:
 * @date :2019/11/14 17:25
 */
object PreferenceUtil{

   lateinit var  sharePreference:SharedPreferences
   private fun getPreference(context: Context):SharedPreferences{

       sharePreference=context.getSharedPreferences("test",0)
       return sharePreference
   }

    fun saveStringData(context: Context,key:String,value:String){
        getPreference(context).edit().putString(key,value).apply()
    }

    fun getStringData(context: Context,key: String,default:String):String?{

        return getPreference(context).getString(key,default)

    }






}