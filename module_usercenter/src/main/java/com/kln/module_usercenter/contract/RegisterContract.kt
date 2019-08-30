package com.kln.module_usercenter.contract

import com.kln.common_base.base.RespBean
import com.kln.common_base.mvp.IView
import com.kln.module_usercenter.bean.RegisterInfoBean

/**
 * Creator :Wen
 * DataTime: 2019/8/25
 * Description:
 */
interface RegisterContract {

    interface View : IView {
        fun registerSuccess(result: RespBean)
    }

    interface Presenter {
        fun register(bean : RegisterInfoBean)
    }
}