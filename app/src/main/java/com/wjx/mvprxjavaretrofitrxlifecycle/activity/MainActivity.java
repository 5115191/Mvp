package com.wjx.mvprxjavaretrofitrxlifecycle.activity;

import com.wjx.mvprxjavaretrofitrxlifecycle.R;
import com.wjx.mvprxjavaretrofitrxlifecycle.base.BaseActivity;
import com.wjx.mvprxjavaretrofitrxlifecycle.base.BasePresenter;
import com.wjx.mvprxjavaretrofitrxlifecycle.base.BaseView;

public class MainActivity extends BaseActivity  {


    @Override
    public int getViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected BaseView createView() {
        return null;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }
}
