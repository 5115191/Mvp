package com.wjx.mvprxjavaretrofitrxlifecycle.activity;

import com.wjx.mvprxjavaretrofitrxlifecycle.R;
import com.wjx.mvprxjavaretrofitrxlifecycle.base.BaseActivity;
import com.wjx.mvprxjavaretrofitrxlifecycle.base.BasePresenter;
import com.wjx.mvprxjavaretrofitrxlifecycle.base.BaseView;
import com.wjx.mvprxjavaretrofitrxlifecycle.presenter.MainPresenter;
import com.wjx.mvprxjavaretrofitrxlifecycle.view.MainView;

public class MainActivity extends BaseActivity<MainView,MainPresenter> implements MainView {


    @Override
    public int getViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainView createView() {
        return this;
    }

    @Override
    protected MainPresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }
}
