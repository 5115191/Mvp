package com.wjx.mvprxjavaretrofitrxlifecycle.api;


import com.wjx.mvprxjavaretrofitrxlifecycle.entity.ArticleListInfo;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.BannerData;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.LoginData;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
     * @return 登陆数据
     */
    @POST("user/login")
    Observable<LoginData> login(@QueryMap Map<String, String> map);



    /**
     * 广告栏
     * http://www.wanandroid.com/banner/json
     *
     * @return 广告栏数据
     */
    @GET("banner/json")
    Observable<BannerData> getBannerData();

}
