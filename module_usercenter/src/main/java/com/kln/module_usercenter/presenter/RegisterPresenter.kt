package com.kln.module_usercenter.presenter

import com.kln.common_base.base.BaseObserver
import com.kln.common_base.base.RespBean
import com.kln.common_base.constants.Constants
import com.kln.common_base.mvp.BasePresenter
import com.kln.common_base.util.SharedPreferenceUtil
import com.kln.module_usercenter.apiservice.UserCenterApiService
import com.kln.module_usercenter.bean.RegisterInfoBean
import com.kln.module_usercenter.contract.LoginContract
import com.kln.module_usercenter.contract.RegisterContract

/**
 * Creator :Wen
 * DataTime: 2019/8/25
 * Description:
 */
class RegisterPresenter : BasePresenter<RegisterContract.View>(), RegisterContract.Presenter{

    override fun register(bean : RegisterInfoBean) {
        addSubscribe(create(UserCenterApiService::class.java).register(bean), object : BaseObserver<RespBean>(view) {
            override fun onSuccess(data: RespBean) {
                if (isViewAttached()) {
                    view.registerSuccess(data)
                }
            }
        })
    }
}