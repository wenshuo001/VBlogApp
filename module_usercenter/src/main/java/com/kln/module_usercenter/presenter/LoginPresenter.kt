package com.kln.module_usercenter.presenter

import com.kln.common_base.base.BaseObserver
import com.kln.common_base.base.RespBean
import com.kln.common_base.constants.Constants
import com.kln.common_base.mvp.BasePresenter
import com.kln.common_base.util.SharedPreferenceUtil
import com.kln.module_usercenter.apiservice.UserCenterApiService
import com.kln.module_usercenter.contract.LoginContract

/**
 * Creator :Wen
 * DataTime: 2019/8/25
 * Description:
 */
class LoginPresenter : BasePresenter<LoginContract.View>(), LoginContract.Presenter{

    override fun login(phone: String, password: String) {
        addSubscribe(create(UserCenterApiService::class.java).login(phone, password), object : BaseObserver<RespBean>(view) {
              override fun onSuccess(data: RespBean) {
                if (isViewAttached()) {
                    view.loginSuccess(data)
                }
            }
        })
    }

    /**
     * 保存手机号和密码
     *
     * @param username
     * @param password
     */
    fun saveUsernamePassword(username: String, password: String) {
        SharedPreferenceUtil.write(Constants.USER_LOGIN, Constants.USERNAME, username)
        SharedPreferenceUtil.write(Constants.USER_LOGIN, Constants.PASSWORD, password)
    }

    fun readUsernamePassword(key: String): String {
        return SharedPreferenceUtil.read(Constants.USER_LOGIN, key, "")
    }
}