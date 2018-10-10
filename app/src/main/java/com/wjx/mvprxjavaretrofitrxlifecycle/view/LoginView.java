package com.wjx.mvprxjavaretrofitrxlifecycle.view;

import com.wjx.mvprxjavaretrofitrxlifecycle.base.BaseView;

/**
 * Author: WangJX
 * Time:2018/10/10 14:03
 * Descriprtion:
 */
public interface LoginView extends BaseView {

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}