package com.example.myapplication.util

import android.content.Context
import android.os.Build
import com.example.myapplication.MyApplication
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author bao
 * @description:
 * @date :2019/11/14 16:38
 */
class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
    var request=chain?.request()
    var builder=  request?.newBuilder()
        builder?.
            addHeader("client_type", "Android")
                ?.addHeader("platformType","1")
                ?.addHeader("Authorization",PreferenceUtil.getStringData(MyApplication.applicationInstance as Context,"Authorization",""))
       request=builder?.build()
        var response=chain?.proceed(request)
        var code=response?.code()
        if(code==200){

        }

        return response!!
    }

}