package com.example.myapplication.http

import com.example.myapplication.base.BaseDataBean
import com.example.myapplication.bean.FindBean
import com.example.myapplication.bean.LoginDataBean
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * @author bao
 * @description:
 * @date :2019/11/12 10:50
 */
interface API {

    companion object {
//        const val BASE_URL = "https://api.smartcinema.com.cn"
        const val BASE_URL = "http://baobab.kaiyanapp.com/api/"
    }

    @FormUrlEncoded
    @POST("/user/login")
    fun login(@FieldMap map: Map<String, String>?): Observable<BaseDataBean<LoginDataBean>>

    //获取发现频道信息
    @GET("v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getFindData() : Observable<MutableList<FindBean>>

    //获取发现频道信息
    @GET("v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getKotlinFindData() : MutableList<FindBean>
}