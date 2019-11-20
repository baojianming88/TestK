package com.example.myapplication.http

import android.content.Context
import com.example.myapplication.util.RequestInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author bao
 * @description:
 * @date :2019/11/11 19:43
 */
class HttpUtil(context: Context) {
    var okHttpClient: OkHttpClient? = null
    var retrofit: Retrofit? = null

    init {
        okHttpClient = OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
//                .addInterceptor(RequestInterceptor())
                .build()
        retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(API.BASE_URL)
                .build()
    }

    companion object {
        @Volatile
        var instance: HttpUtil? = null

        fun getInstance(context: Context): HttpUtil? {
            if (null == instance) {
                synchronized(HttpUtil::class.java) {
                    instance = HttpUtil(context)
                }
            }
            return instance
        }
    }

    fun <T> create(service: Class<T>?): T? {
        if (null == service) {
            return null
        }
        return retrofit?.create(service)
    }
}