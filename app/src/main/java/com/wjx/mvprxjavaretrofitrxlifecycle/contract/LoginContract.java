package com.wjx.mvprxjavaretrofitrxlifecycle.contract;

import com.wjx.mvprxjavaretrofitrxlifecycle.base.BasePresenter;
import com.wjx.mvprxjavaretrofitrxlifecycle.base.BaseView;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.LoginData;

import java.util.HashMap;

import io.reactivex.ObservableTransformer;

/**
 * Author: WangJX
 * Time:2018/10/11 14:03
 * Descriprtion:
 */
public interface LoginContract {
     interface View extends BaseView {


        void loginSuccess();

         void result(LoginData data);


         <T> ObservableTransformer<T, T> bindLifecycle();

    }

     abstract class Presenter extends BasePresenter<View> {

         public abstract void login(HashMap<String,String> map, boolean isDialog, boolean cancelable);
    }
}
