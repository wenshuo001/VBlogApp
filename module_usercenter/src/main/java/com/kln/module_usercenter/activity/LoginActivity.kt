package com.kln.module_usercenter.activity

import android.graphics.Paint
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.kln.common_base.base.BaseMVPActivity
import com.kln.common_base.base.RespBean
import com.kln.common_base.constants.Constants
import com.kln.common_base.manager.UserLoginManager
import com.kln.common_base.util.SoftKeyboardUtil
import com.kln.module_usercenter.R
import com.kln.module_usercenter.contract.LoginContract
import com.kln.module_usercenter.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*


@Route(path = "/user/LoginActivity")
class LoginActivity : BaseMVPActivity<LoginPresenter>(), LoginContract.View,View.OnClickListener{
    override fun initView() {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun initData() {
        super.initData()
        // 添加下划线
        tv_register.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG)
        val cacheUsername = presenter.readUsernamePassword(Constants.USERNAME)
        val cachePassword = presenter.readUsernamePassword(Constants.PASSWORD)
//        String cacheUsername = "xing2019";
//        String cachePassword = "123456";
        et_login_username.setText(cacheUsername)
        et_login_username.setSelection(cacheUsername.length)
        et_login_password.setText(cachePassword)
        et_login_password.setSelection(cachePassword.length)

        btn_login.setOnClickListener(this)
        tv_register.setOnClickListener(this)
        cb_login_pwd_visible.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                et_login_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                et_login_password.setSelection(et_login_password.getText().toString().length)
            } else {
                et_login_password.setTransformationMethod(PasswordTransformationMethod.getInstance())
                et_login_password.setSelection(et_login_password.getText().toString().length)
            }
        })
        et_login_password.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                SoftKeyboardUtil.hideSoftKeyboard(et_login_password)
                login()
                return@OnEditorActionListener true
            }
            false
        })
    }

    override fun getLayoutResId(): Int = R.layout.activity_login

    override fun createPresenter(): LoginPresenter = LoginPresenter()

    override fun onClick(v: View?) {
        val i = v?.getId()
        if (i == R.id.btn_login) {
            login()
        } else if (i == R.id.tv_register) {
            gotoRegisterActivity()
        }
    }

    /**
     * 开始登陆
     * xing2019 / 123456
     */
    private fun login() {
        val username = et_login_username.getText().toString().trim()
        val password = et_login_password.getText().toString().trim()
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(mContext, R.string.please_input_username, Toast.LENGTH_LONG).show()
            return
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(mContext, R.string.please_input_password, Toast.LENGTH_LONG).show()
            return
        }
        presenter.login(username, password)
    }

    /**
     * 跳转注册页面
     */
    private fun gotoRegisterActivity() {
        ARouter.getInstance().build("/user/RegisterActivity").navigation()
    }

    /**
     * 跳转主界面
     */
    private fun gotoMainActivity() {
        ARouter.getInstance().build("/main/MainActivity").navigation()
        finish()
    }


    override fun loginSuccess(result: RespBean) {
        UserLoginManager.getInstance().setLoggedin(true)
        val username = et_login_username.getText().toString().trim()
        val password = et_login_password.getText().toString().trim()
        presenter.saveUsernamePassword(username, password)
        gotoMainActivity()
    }

}