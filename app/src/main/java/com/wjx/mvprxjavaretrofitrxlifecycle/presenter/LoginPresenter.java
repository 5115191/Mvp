package com.wjx.mvprxjavaretrofitrxlifecycle.presenter;

import com.wjx.mvprxjavaretrofitrxlifecycle.base.BasePresenter;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.UserInfo;
import com.wjx.mvprxjavaretrofitrxlifecycle.interactor.LoginInteractor;
import com.wjx.mvprxjavaretrofitrxlifecycle.view.LoginView;

/**
 * Author: WangJX
 * Time:2018/10/10 11:09
 * Descriprtion:
 */
public class LoginPresenter extends BasePresenter<LoginView> implements LoginInteractor.OnLoginFinishedListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;


    public LoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void login(UserInfo userInfo){
        loginInteractor.login(userInfo,this);
    }

    @Override
    public void onUsernameError() {
        if (null != loginView)
            loginView.setUsernameError();
    }

    @Override
    public void onPasswordError() {
        if (null != loginView)

            loginView.setPasswordError();
    }

    @Override
    public void onLoginSuccess() {
        if (null != loginView)

            loginView.navigateToHome();
    }
}
