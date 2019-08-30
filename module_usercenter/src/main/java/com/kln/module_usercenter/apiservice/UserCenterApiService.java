package com.kln.module_usercenter.apiservice;


import com.kln.common_base.base.BaseResponse;
import com.kln.common_base.base.RespBean;
import com.kln.module_usercenter.bean.GetPageListBean;
import com.kln.module_usercenter.bean.RegisterInfoBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface UserCenterApiService {

    @GET("http://192.168.0.111:10010/api/item/brand/page")
    Observable<BaseResponse<GetPageListBean>> getPage(@Query("page") String page,
                                                      @Query("rows") String rows );
    /**
     * 注册
     *
     * @return
     */
    @POST("/reg")
    Observable<RespBean> register(@Body RegisterInfoBean bean);


    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @POST("/login")
    @FormUrlEncoded
    Observable<RespBean> login(@Field("username") String username,
                                                @Field("password") String password);

}
