package com.wjx.mvprxjavaretrofitrxlifecycle.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends RxAppCompatActivity {
    private V view;
    private P presenter;
    private Unbinder unbinder;

    public P getPresenter() {
        return presenter;
    }

    public BaseActivity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewId());
        unbinder = ButterKnife.bind(this);
        mContext = this;
        if (view == null) {
            view = createView();
        }

        if (presenter == null) {
            presenter = createPresenter();
        }
        if (presenter != null && view != null) {
            presenter.attachView(view);
        }
        init();
    }

    public abstract int getViewId();

    protected abstract V createView();

    protected abstract P createPresenter();

    protected abstract void init();


    @Override
    protected void onDestroy() {
        if (null != presenter) {
            presenter.detachView();
        }
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();

    }
}
