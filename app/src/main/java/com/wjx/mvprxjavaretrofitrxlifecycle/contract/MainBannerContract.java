package com.wjx.mvprxjavaretrofitrxlifecycle.contract;

import com.wjx.mvprxjavaretrofitrxlifecycle.base.BasePresenter;
import com.wjx.mvprxjavaretrofitrxlifecycle.base.BaseView;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.BannerData;

import java.util.HashMap;
import java.util.List;

import io.reactivex.ObservableTransformer;

/**
 * Author: WangJX
 * Time:2018/10/22 11:20
 * Descriprtion:
 */
public interface MainBannerContract {
    interface View extends BaseView {
       void showBannerData(List<BannerData.DataBean> bannerDataList);
        <T> ObservableTransformer<T, T> bindLifecycle();
    }

    abstract class Presenter extends BasePresenter<View>{
        public abstract void getBannerData();

    }
}
