package com.kln.module_main

import com.alibaba.android.arouter.facade.annotation.Route
import com.kln.common_base.base.BaseActivity


@Route(path = "/main/MainActivity")
class MainActivity :BaseActivity(){

    override fun getLayoutResId() = R.layout.activity_main

    override fun initView() {

    }


}