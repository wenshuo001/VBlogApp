package com.kln.module_usercenter.activity

import android.app.Activity
import com.alibaba.android.arouter.facade.annotation.Route
import com.kln.common_base.base.BaseMVPActivity
import com.kln.module_usercenter.contract.LoginContract
import com.kln.module_usercenter.presenter.LoginPresenter


@Route(path = "/user/LoginActivity")
class LoginActivity : BaseMVPActivity<LoginPresenter>(), LoginContract.View{

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutResId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createPresenter(): LoginPresenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginSuccess(result: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}