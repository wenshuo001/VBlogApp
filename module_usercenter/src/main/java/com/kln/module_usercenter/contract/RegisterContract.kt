package com.kln.module_usercenter.contract

import com.kln.common_base.mvp.IView

/**
 * Creator :Wen
 * DataTime: 2019/8/25
 * Description:
 */
interface RegisterContract {
//    interface View : IView {
//        fun registerSuccess(result: RegisterResult)
//    }

    interface Presenter {
        fun register(phone: String, password: String, repassword: String)
    }
}