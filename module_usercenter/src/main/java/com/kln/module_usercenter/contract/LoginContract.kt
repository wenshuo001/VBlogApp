package com.kln.module_usercenter.contract

import com.kln.common_base.base.RespBean
import com.kln.common_base.mvp.IView

/**
 * Creator :Wen
 * DataTime: 2019/8/25
 * Description:
 */
interface LoginContract {

    interface View : IView {
        fun loginSuccess(result: RespBean)
    }

    interface Presenter {
        fun login(phone: String, password: String)
    }
}