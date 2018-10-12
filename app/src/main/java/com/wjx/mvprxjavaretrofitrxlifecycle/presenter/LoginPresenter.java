package com.wjx.mvprxjavaretrofitrxlifecycle.presenter;

import android.content.Context;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wjx.mvprxjavaretrofitrxlifecycle.api.Api;
import com.wjx.mvprxjavaretrofitrxlifecycle.base.BaseResponse;
import com.wjx.mvprxjavaretrofitrxlifecycle.contract.LoginContract;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.ArticleListInfo;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.LoginData;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.UserInfo;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: WangJX
 * Time:2018/10/10 11:09
 * Descriprtion:
 */
public class LoginPresenter extends LoginContract.Presenter {
    private Context context;

    public LoginPresenter(Context context) {
        this.context = context;
    }


    @Override
    public void login(UserInfo userInfo) {
        Api.getApiService().getLoginData("xx5115191", "wjx19920912..")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse<LoginData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse<LoginData> loginDataBaseResponse) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
