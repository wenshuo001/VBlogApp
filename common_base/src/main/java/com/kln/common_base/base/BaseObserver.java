package com.kln.common_base.base;

import com.kln.common_base.http.ApiException;
import com.kln.common_base.http.ExceptionHandler;
import com.kln.common_base.mvp.IView;

import io.reactivex.observers.DisposableObserver;

public abstract class BaseObserver<T>  extends DisposableObserver<T> {
    private IView baseView;

    public BaseObserver() {

    }

    public BaseObserver(IView baseView) {
        this.baseView = baseView;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (baseView != null) {
            baseView.showLoading();
        }
    }

    @Override
    public void onNext(T respone) {
        if (baseView != null) {
            baseView.hideLoading();
        }
        RespBean baseResponse=(RespBean)respone;
        String errmsg = baseResponse.getMsg();
       // boolean isOk = !baseResponse.isError();
        if (baseResponse.getStatus().equals("success")) {
            // 将服务端获取到的正常数据传递给上层调用方
            onSuccess(baseResponse);
        } else {
            onError(new ApiException(200, errmsg));
        }
//         else if (isOk) {   // gank api
//            T data = baseResponse.getResults();
//            onSuccess(data);
//        }
    }

    /**
     * 回调正常数据
     *
     * @param data
     */
    protected abstract void onSuccess(RespBean data);

    /**
     * 异常处理，包括两方面数据：
     * (1) 服务端没有没有返回数据，HttpException，如网络异常，连接超时;
     * (2) 服务端返回了数据，但 errcode!=0,即服务端返回的data为空，如 密码错误,App登陆超时,token失效
     */
    @Override
    public void onError(Throwable e) {
        ExceptionHandler.handleException(e);
    }

    @Override
    public void onComplete() {
        if (baseView != null) {
            baseView.hideLoading();
        }
    }
}
