package com.wjx.mvprxjavaretrofitrxlifecycle.interactor;

import android.os.Handler;
import android.text.TextUtils;

import com.wjx.mvprxjavaretrofitrxlifecycle.entity.UserInfo;

/**
 * Author: WangJX
 * Time:2018/10/10 11:08
 * Descriprtion:
 */
public class LoginInteractor {
    public interface OnLoginFinishedListener{
        void onUsernameError();

        void onPasswordError();

        void onLoginSuccess();
    }

    public void login(final UserInfo userInfo, final OnLoginFinishedListener listener){

        //模拟登录
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(userInfo.getUserName())) {
                    listener.onUsernameError();
                    return;
                }
                if (TextUtils.isEmpty(userInfo.getUserPwd())) {
                    listener.onPasswordError();
                    return;
                }
                listener.onLoginSuccess();
            }
        },2000);
    }
}
