package com.wjx.mvprxjavaretrofitrxlifecycle.contract;

import com.wjx.mvprxjavaretrofitrxlifecycle.base.BasePresenter;
import com.wjx.mvprxjavaretrofitrxlifecycle.base.BaseView;

/**
 * Author: WangJX
 * Time:2018/10/22 14:04
 * Descriprtion:
 */
public interface MainContract  {
    interface View extends BaseView{
       void initBanner();
    }

    abstract class Presenter extends BasePresenter<View>{

    }
}
