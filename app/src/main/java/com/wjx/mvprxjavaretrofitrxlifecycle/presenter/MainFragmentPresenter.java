package com.wjx.mvprxjavaretrofitrxlifecycle.presenter;

import android.content.Context;

import com.wjx.mvprxjavaretrofitrxlifecycle.contract.MainBannerContract;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.BannerData;
import com.wjx.mvprxjavaretrofitrxlifecycle.model.MainBannerModel;
import com.wjx.mvprxjavaretrofitrxlifecycle.progress.ObserverResponseListener;
import com.wjx.mvprxjavaretrofitrxlifecycle.utils.ExceptionHandle;
import com.wjx.mvprxjavaretrofitrxlifecycle.utils.ToastUtil;

/**
 * Author: WangJX
 * Time:2018/10/10 15:59
 * Descriprtion:
 */
public class MainFragmentPresenter extends MainBannerContract.Presenter{

private Context context;
private MainBannerModel model;


    public MainFragmentPresenter(Context context) {
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
