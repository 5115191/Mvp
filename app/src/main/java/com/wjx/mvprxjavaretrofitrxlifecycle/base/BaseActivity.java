package com.wjx.mvprxjavaretrofitrxlifecycle.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends RxAppCompatActivity {
    private V view;
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewId());
        ButterKnife.bind(this);

        if (view == null) {
            view = createView();
        }

        if (presenter == null) {
            presenter = createPresenter();
        }

        init();
    }

    public abstract int getViewId();

    protected abstract V createView();

    protected abstract P createPresenter();

    protected abstract void init();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != presenter)
            presenter.detachView();
    }
}