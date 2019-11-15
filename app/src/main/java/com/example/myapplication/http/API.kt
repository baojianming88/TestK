package com.example.myapplication.http

import com.example.myapplication.base.BaseDataBean
import com.example.myapplication.bean.LoginDataBean
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @author bao
 * @description:
 * @date :2019/11/12 10:50
 */
interface API {

    companion object {
        const val BASE_URL = "https://api.smartcinema.com.cn"
    }

    @FormUrlEncoded
    @POST("/user/login")
    fun login(@FieldMap map: Map<String, String>?): Observable<BaseDataBean<LoginDataBean>>
}