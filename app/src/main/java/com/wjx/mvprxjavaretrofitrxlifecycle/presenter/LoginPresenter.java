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
import com.wjx.mvprxjavaretrofitrxlifecycle.model.LoginModel;
import com.wjx.mvprxjavaretrofitrxlifecycle.progress.ObserverResponseListener;
import com.wjx.mvprxjavaretrofitrxlifecycle.utils.ExceptionHandle;
import com.wjx.mvprxjavaretrofitrxlifecycle.utils.SnackbarUtils;
import com.wjx.mvprxjavaretrofitrxlifecycle.utils.ToastUtil;

import java.util.HashMap;
import java.util.List;

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
    private LoginModel model;

    public LoginPresenter(Context context) {
        this.model = new LoginModel();
        this.context = context;
    }


    @Override
    public void login(HashMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.login(context, map, isDialog, cancelable, getView().bindLifecycle(),new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if(getView() != null){
                    getView().result((LoginData) o);
                    int errorCode = ((LoginData) o).getErrorCode();
                    if (0 ==errorCode) {
                        getView().loginSuccess();
                    }else {
                        ToastUtil.showShortToast(((LoginData) o).getErrorMsg());
                    }
                }
            }
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if(getView() != null){
                    ////  自定义处理异常
                    ToastUtil.showShortToast(ExceptionHandle.handleException(e).message);
                }
            }
        });

    }
}
