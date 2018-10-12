package com.wjx.mvprxjavaretrofitrxlifecycle.contract;

import com.wjx.mvprxjavaretrofitrxlifecycle.base.BasePresenter;
import com.wjx.mvprxjavaretrofitrxlifecycle.base.BaseView;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.UserInfo;

/**
 * Author: WangJX
 * Time:2018/10/11 14:03
 * Descriprtion:
 */
public interface LoginContract {
     interface View extends BaseView {
        void setUsernameError();

        void setPasswordError();

        void navigateToHome();


    }

     abstract class Presenter extends BasePresenter<View> {
        public abstract void login(UserInfo userInfo);
    }
}
