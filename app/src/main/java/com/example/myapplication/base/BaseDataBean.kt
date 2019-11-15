package com.example.myapplication.base

import com.example.myapplication.http.BaseJsonDataEmptyStringAdapterFactory
import com.google.gson.Gson
import com.google.gson.annotations.JsonAdapter
import java.io.Serializable

/**
 * @author bao
 * @description:
 * @date :2019/11/12 15:49
 */
class BaseDataBean<T>(var code:Int,var msg:String,
                      @field:JsonAdapter(BaseJsonDataEmptyStringAdapterFactory::class) var data:T):Serializable {

    fun success():Boolean{
        return code==0
    }

    fun toJson():String{
        return (Gson()).toJson(this)
    }

    fun codeStr():String{
        return code.toString()
    }
    companion object{
        val CODE_SUCCESS:Int=0
    }

}