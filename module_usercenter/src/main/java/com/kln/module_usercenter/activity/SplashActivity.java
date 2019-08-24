package com.kln.module_usercenter.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;


import com.kln.common_base.annotation.BindEventBus;
import com.kln.common_base.base.BaseActivity;
import com.kln.common_base.base.BaseObserver;
import com.kln.common_base.json.GsonUtils;
import com.kln.module_usercenter.R;
import com.kln.module_usercenter.apiservice.UserCenterApiService;
import com.kln.module_usercenter.bean.GetPageListBean;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@BindEventBus
public class SplashActivity extends BaseActivity {

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(String BB) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        gotoMainActivity();
    }

    private void gotoMainActivity() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        addSubscribe(create(UserCenterApiService.class).getPage("1", "5"), new BaseObserver<GetPageListBean>() {

            @Override
            protected void onSuccess(GetPageListBean data) {
               Log.d("didadi",GsonUtils.toJson(data));  // 可以运行
            }

        });
    }
}
