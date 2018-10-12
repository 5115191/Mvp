package com.wjx.mvprxjavaretrofitrxlifecycle.api;


import com.wjx.mvprxjavaretrofitrxlifecycle.base.BaseResponse;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.ArticleListInfo;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.LoginData;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.UserInfo;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * api service
 */
public interface ApiService {

    @GET("article/list/0/json")
    Observable<ArticleListInfo> getArticleList();


    /**
     * 登陆
     * http://www.wanandroid.com/user/login
     *
     * @param username user name
     * @param password password
     * @return 登陆数据
     */
    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseResponse<LoginData>> getLoginData(@Field("username") String username, @Field("password") String password);

}
