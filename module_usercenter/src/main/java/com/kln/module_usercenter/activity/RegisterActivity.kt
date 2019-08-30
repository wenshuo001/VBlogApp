package com.kln.module_usercenter.activity

import android.annotation.TargetApi
import android.os.Build
import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.kln.common_base.base.BaseMVPActivity
import com.kln.common_base.base.RespBean
import com.kln.common_base.util.ToastUtil
import com.kln.module_usercenter.R
import com.kln.module_usercenter.bean.RegisterInfoBean
import com.kln.module_usercenter.contract.RegisterContract
import com.kln.module_usercenter.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*


@Route(path = "/user/RegisterActivity")
class RegisterActivity : BaseMVPActivity<RegisterPresenter>(), RegisterContract.View,View.OnClickListener{


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun initView() {
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.register)
        toolbar?.setNavigationOnClickListener {
            finish()
        }

    }
    override fun initData() {
        super.initData()
        btn_register.setOnClickListener {

            val username = et_register_username.getText().toString().trim()
            val password = et_register_password.getText().toString().trim()
            val repassword = et_register_repassword.getText().toString().trim()
            if (TextUtils.isEmpty(username)) {
                ToastUtil.show(mContext, "请输入用户名")
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(password)) {
                ToastUtil.show(mContext, "请输入密码")
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(repassword)) {
                ToastUtil.show(mContext, "请再次输入密码")
                return@setOnClickListener
            }
            if (!TextUtils.equals(password, repassword)) {
                ToastUtil.show(mContext, "两次密码不相同")
                return@setOnClickListener
            }
            val bean  = RegisterInfoBean(username,password,"",username)
            presenter.register(bean)
        }
    }


    override fun registerSuccess(result: RespBean) {
        ToastUtil.show(mContext, result.msg+"")
    }

    override fun onClick(v: View?) {

    }


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun getLayoutResId(): Int = R.layout.activity_register

    override fun createPresenter(): RegisterPresenter = RegisterPresenter()

}