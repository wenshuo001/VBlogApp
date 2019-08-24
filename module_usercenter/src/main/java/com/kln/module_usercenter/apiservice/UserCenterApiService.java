package com.kln.module_usercenter.apiservice;


import com.kln.common_base.base.BaseResponse;
import com.kln.module_usercenter.bean.GetPageListBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserCenterApiService {

    @GET("http://192.168.0.111:10010/api/item/brand/page")
    Observable<BaseResponse<GetPageListBean>> getPage(@Query("page") String page,
                                                      @Query("rows") String rows );

}
