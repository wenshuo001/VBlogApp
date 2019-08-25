package com.kln.module_usercenter.presenter

import com.kln.common_base.mvp.BasePresenter
import com.kln.module_usercenter.contract.LoginContract

/**
 * Creator :Wen
 * DataTime: 2019/8/25
 * Description:
 */
class LoginPresenter : BasePresenter<LoginContract.View>(), LoginContract.Presenter{
    override fun login(phone: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}