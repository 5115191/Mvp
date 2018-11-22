package com.wjx.mvprxjavaretrofitrxlifecycle.activity;

import com.wjx.mvprxjavaretrofitrxlifecycle.R;
import com.wjx.mvprxjavaretrofitrxlifecycle.base.BaseActivity;
import com.wjx.mvprxjavaretrofitrxlifecycle.contract.MainContract;
import com.wjx.mvprxjavaretrofitrxlifecycle.fragment.MainFragment;
import com.wjx.mvprxjavaretrofitrxlifecycle.presenter.MainFragmentPresenter;

public class MainActivity extends BaseActivity<MainContract.View,MainContract.Presenter> {


    @Override
    public int getViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainContract.View createView() {
        return null;
    }

    @Override
    protected MainContract.Presenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.content, new MainFragment()).
                commitAllowingStateLoss();
    }

}
