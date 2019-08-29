package com.kln.module_usercenter.apiservice;


import com.kln.common_base.base.BaseResponse;
import com.kln.common_base.base.RespBean;
import com.kln.module_usercenter.bean.GetPageListBean;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserCenterApiService {

    @GET("http://192.168.0.111:10010/api/item/brand/page")
    Observable<BaseResponse<GetPageListBean>> getPage(@Query("page") String page,
                                                      @Query("rows") String rows );
    /**
     * 注册
     *
     * @param username
     * @param password
     * @param repassword
     * @return
     */
    @POST("user/register")
    @FormUrlEncoded
    Observable<RespBean> register(@Field("username") String username,
                                  @Field("password") String password,
                                  @Field("repassword") String repassword);


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
