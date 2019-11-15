package com.example.myapplication.mvp

import android.content.Context
import com.example.myapplication.base.BaseDataBean
import com.example.myapplication.bean.LoginDataBean
import com.example.myapplication.http.API
import com.example.myapplication.http.HttpUtil
import com.example.myapplication.mvp.contract.LoginContract
import io.reactivex.Observable
import io.reactivex.ObservableSource

/**
 * @author bao
 * @description:
 * @date :2019/11/13 11:18
 */
class LoginModel :LoginContract.ILoginModel {
    override fun login(context: Context, map: HashMap<String, String>) : Observable<BaseDataBean<LoginDataBean>>?{
        var httpUtil = HttpUtil.getInstance(context)
        val apiService = httpUtil?.create(API::class.java)
        return apiService?.login(map)
    }


}