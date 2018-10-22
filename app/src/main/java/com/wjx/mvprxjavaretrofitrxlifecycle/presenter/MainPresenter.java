package com.wjx.mvprxjavaretrofitrxlifecycle.presenter;

import android.content.Context;

import com.wjx.mvprxjavaretrofitrxlifecycle.base.BasePresenter;
import com.wjx.mvprxjavaretrofitrxlifecycle.contract.MainBannerContract;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.BannerData;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.LoginData;
import com.wjx.mvprxjavaretrofitrxlifecycle.model.MainBannerModel;
import com.wjx.mvprxjavaretrofitrxlifecycle.progress.ObserverResponseListener;
import com.wjx.mvprxjavaretrofitrxlifecycle.utils.ExceptionHandle;
import com.wjx.mvprxjavaretrofitrxlifecycle.utils.ToastUtil;
import com.wjx.mvprxjavaretrofitrxlifecycle.view.MainView;
import com.youth.banner.Banner;

/**
 * Author: WangJX
 * Time:2018/10/10 15:59
 * Descriprtion:
 */
public class MainPresenter extends MainBannerContract.Presenter{

private Context context;
private MainBannerModel model;


    public MainPresenter(Context context) {
        this.context = context;
        this.model = new MainBannerModel();
    }

    @Override
    public void getBannerData() {
        model.getBannerData(context, false, false, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                if(getView() != null){
                    int errorCode = ((BannerData)o).getErrorCode();
                    if (0 ==errorCode) {
                        getView().showBannerData( ((BannerData) o).getData());
                    }else {
                        ToastUtil.showShortToast(((BannerData) o).getErrorMsg());
                    }
                }

            }

            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }
        });
    }
}
