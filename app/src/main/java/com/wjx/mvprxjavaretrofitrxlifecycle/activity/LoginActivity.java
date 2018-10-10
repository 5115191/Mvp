package com.wjx.mvprxjavaretrofitrxlifecycle.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wjx.mvprxjavaretrofitrxlifecycle.R;
import com.wjx.mvprxjavaretrofitrxlifecycle.base.BaseActivity;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.UserInfo;
import com.wjx.mvprxjavaretrofitrxlifecycle.interactor.LoginInteractor;
import com.wjx.mvprxjavaretrofitrxlifecycle.presenter.LoginPresenter;
import com.wjx.mvprxjavaretrofitrxlifecycle.utils.RxAnimationTool;
import com.wjx.mvprxjavaretrofitrxlifecycle.utils.RxKeyboardTool;
import com.wjx.mvprxjavaretrofitrxlifecycle.view.LoginView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Author: WangJX
 * Time:2018/10/10 10:15
 * Descriprtion:登录界面
 */
public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {
    @BindView(R.id.et_user_name)
    EditText etUserName;
    @BindView(R.id.iv_clean_user_name)
    ImageView ivCleanUserName;
    @BindView(R.id.et_user_pwd)
    EditText etUserPwd;
    @BindView(R.id.iv_clean_user_pwd)
    ImageView ivCleanUserPwd;
    @BindView(R.id.iv_show_pwd)
    ImageView ivShowPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.regist)
    TextView regist;
    @BindView(R.id.forget_password)
    TextView forgetPassword;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.service)
    LinearLayout service;

    @BindView(R.id.content)
    LinearLayout mContent;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;

    private int screenHeight = 0;//屏幕高度
    private int keyHeight = 0; //软件盘弹起后所占高度


    @Override
    public int getViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginView createView() {
        return this;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this, new LoginInteractor());
    }


    @Override
    protected void init() {

        initEvent();
    }


    @Override
    public void setUsernameError() {
        etUserName.setError("用户名错误");
    }

    @Override
    public void setPasswordError() {
        etUserPwd.setError("密码错误");
    }

    @Override
    public void navigateToHome() {

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void initEvent() {
        screenHeight = this.getResources().getDisplayMetrics().heightPixels; //获取屏幕高度
        keyHeight = screenHeight / 3;//弹起高度为屏幕高度的1/3

        etUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && ivCleanUserName.getVisibility() == View.GONE) {
                    ivCleanUserName.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    ivCleanUserName.setVisibility(View.GONE);
                }
            }
        });
        etUserPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && ivCleanUserPwd.getVisibility() == View.GONE) {
                    ivCleanUserPwd.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    ivCleanUserPwd.setVisibility(View.GONE);
                }
                if (s.toString().isEmpty()) {
                    return;
                }
                if (!s.toString().matches("[A-Za-z0-9]+")) {
                    String temp = s.toString();
                    Toast.makeText(mContext, "请输入数字或字母", Toast.LENGTH_SHORT).show();
                    s.delete(temp.length() - 1, temp.length());
                    etUserPwd.setSelection(s.length());
                }
            }
        });

        //禁止键盘弹起的时候可以滚动
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        scrollView.addOnLayoutChangeListener(new ViewGroup.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
              /* old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值
              现在认为只要控件将Activity向上推的高度超过了1/3屏幕高，就认为软键盘弹起*/
                if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > keyHeight)) {
                    int dist = mContent.getBottom() - bottom;
                    if (dist > 0) {
                        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(mContent, "translationY", 0.0f, -dist);
                        mAnimatorTranslateY.setDuration(300);
                        mAnimatorTranslateY.setInterpolator(new LinearInterpolator());
                        mAnimatorTranslateY.start();
                        RxAnimationTool.zoomIn(ivLogo, 0.6f, dist);
                    }
                    service.setVisibility(View.INVISIBLE);

                } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > keyHeight)) {
                    if ((mContent.getBottom() - oldBottom) > 0) {
                        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(mContent, "translationY", mContent.getTranslationY(), 0);
                        mAnimatorTranslateY.setDuration(300);
                        mAnimatorTranslateY.setInterpolator(new LinearInterpolator());
                        mAnimatorTranslateY.start();
                        //键盘收回后，logo恢复原来大小，位置同样回到初始位置
                        RxAnimationTool.zoomOut(ivLogo, 0.6f);
                    }
                    service.setVisibility(View.VISIBLE);
                }
            }
        });


    }


    @OnClick({R.id.iv_clean_user_name, R.id.iv_clean_user_pwd, R.id.iv_show_pwd, R.id.btn_login, R.id.regist, R.id.forget_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_clean_user_name:
                etUserName.setText("");
                break;
            case R.id.iv_clean_user_pwd:
                etUserPwd.setText("");
                break;
            case R.id.iv_show_pwd:
                if (etUserPwd.getInputType() != InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    etUserPwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    ivShowPwd.setImageResource(R.mipmap.pass_visuable);
                } else {
                    etUserPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    ivShowPwd.setImageResource(R.mipmap.pass_gone);
                }
                String pwd = etUserPwd.getText().toString();
                if (!TextUtils.isEmpty(pwd))
                    etUserPwd.setSelection(pwd.length());
                break;
            case R.id.btn_login:
                getPresenter().login(new UserInfo(etUserName.getText().toString().trim(), etUserPwd.getText().toString().trim()));
                RxKeyboardTool.hideSoftInput(mContext);
                break;
            case R.id.regist:
                break;
            case R.id.forget_password:
                break;
        }
    }


}
