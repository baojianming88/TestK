package com.example.myapplication.ui

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.bean.FindBean
import com.example.myapplication.bean.LoginDataBean
import com.example.myapplication.mvp.contract.LoginContract
import com.example.myapplication.mvp.presenter.LoginPresenter
import com.example.myapplication.util.MD5Util
import kotlinx.android.synthetic.main.login_layout.*
import java.security.Permission
import java.util.jar.Manifest

/**
 * @author bao
 * @description:
 * @date :2019/11/11 11:47
 */
class LoginAct : AppCompatActivity(),LoginContract.ILoginView, View.OnClickListener {
    override fun test(bean: MutableList<FindBean>?) {
      for (findBean in bean!!){
          Log.e("test",findBean.name)
      }
    }

    var loginPresenter:LoginPresenter?=null
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
        bt_login.setOnClickListener(this)
        loginPresenter= LoginPresenter(this,this)
        val permissions:Array<String>?= arrayOf(android.Manifest.permission.INTERNET)
        if(this.checkSelfPermission(android.Manifest.permission.INTERNET)!=PackageManager.PERMISSION_GRANTED){
            requestPermissions(permissions!!,1)
        }
    }


    override fun loginSuccess(dataBean: LoginDataBean) {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show()
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.bt_login->{
                val name=et_name.text.toString()
                val pwd=et_pwd.text.toString()
                val paramsMap=HashMap<String,String>()
                paramsMap["uMobile"] = name
                paramsMap["uPassword"]=MD5Util.getMD5Str(pwd)
                loginPresenter?.getLoadData()
            }
        }
    }




}