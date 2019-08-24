package com.kln.module_usercenter.activity;


import com.kln.common_base.base.BaseActivity;
import com.kln.module_usercenter.R;
import java.util.concurrent.TimeUnit;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


public class SplashActivity extends BaseActivity {

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
    private Disposable mdDisposable;
    @Override
    protected void initView() {
        //从0开始发射11个数字为：0-10依次输出，延时0s执行，每1s发射一次。
        mdDisposable = Flowable.intervalRange(0, 2, 0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                      //  btnGetCode.setText("重新获取(" + (10 - aLong) + ")");
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        //倒计时完毕置为可点击状态
//                        btnGetCode.setEnabled(true);
//                        btnGetCode.setText("获取验证码");
//                          ARouter.getInstance().build(ArouterURL.MainActivity).navigation();
//                          finish();
                    }
                })
                .subscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mdDisposable != null) {
            mdDisposable.dispose();
        }
    }
}
