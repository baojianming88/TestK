package com.example.myapplication.mvp.presenter

import android.content.Context
import android.util.Log
import com.example.myapplication.base.BaseDataBean
import com.example.myapplication.base.BaseView
import com.example.myapplication.bean.LoginDataBean
import com.example.myapplication.mvp.LoginModel
import com.example.myapplication.mvp.contract.LoginContract
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import com.example.myapplication.base.BaseObserver as BaseBaseObserver

/**
 * @author bao
 * @description:
 * @date :2019/11/13 14:27
 */
class LoginPresenter(contextA: Context,baseView :LoginContract.ILoginView) {
    var context: Context = contextA
    var loginView:LoginContract.ILoginView=baseView
    val loginModel: LoginModel by lazy {
        LoginModel()
    }

    fun login(map: HashMap<String, String>) {

        loginModel.login(this.context, map)?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : Observer<BaseDataBean<LoginDataBean>>{
                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onComplete() {

                    }

                    override fun onNext(t: BaseDataBean<LoginDataBean>?) {
                        if(t!!.success())
                        loginView.loginSuccess(t.data)
                    }
                    override fun onError(e: Throwable?) {
                        RxJavaPlugins.setErrorHandler {
                            Log.e("error",it.message)
                        }
                    }

                })

    }

}

