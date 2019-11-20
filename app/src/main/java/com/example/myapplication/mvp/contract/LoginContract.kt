package com.example.myapplication.mvp.contract

import android.content.Context
import com.example.myapplication.base.BaseDataBean
import com.example.myapplication.base.BaseModel
import com.example.myapplication.base.BaseView
import com.example.myapplication.bean.FindBean
import com.example.myapplication.bean.LoginDataBean
import com.example.myapplication.mvp.presenter.LoginPresenter
import io.reactivex.Observable

/**
 * @author bao
 * @description:
 * @date :2019/11/13 14:53
 */
interface LoginContract {
    interface ILoginView:BaseView<LoginPresenter>{
        fun loginSuccess(dataBean: LoginDataBean)
        fun test(bean :MutableList<FindBean>?)
    }

    interface ILoginModel:BaseModel<LoginPresenter>{
        fun login(context: Context,map: HashMap<String,String>): Observable<BaseDataBean<LoginDataBean>>?
        fun loadData(context: Context):Observable<MutableList<FindBean>>?
        fun loadKotlinData(context: Context):MutableList<FindBean>?
    }

}