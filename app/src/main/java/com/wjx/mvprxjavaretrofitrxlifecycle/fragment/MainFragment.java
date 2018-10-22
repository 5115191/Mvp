package com.wjx.mvprxjavaretrofitrxlifecycle.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wjx.mvprxjavaretrofitrxlifecycle.R;
import com.wjx.mvprxjavaretrofitrxlifecycle.base.BaseFragment;
import com.wjx.mvprxjavaretrofitrxlifecycle.contract.MainBannerContract;
import com.wjx.mvprxjavaretrofitrxlifecycle.entity.BannerData;
import com.wjx.mvprxjavaretrofitrxlifecycle.presenter.MainPresenter;
import com.wjx.mvprxjavaretrofitrxlifecycle.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.ObservableTransformer;

/**
 * Author: WangJX
 * Time:2018/10/22 11:15
 * Descriprtion:
 */
public class MainFragment extends BaseFragment<MainBannerContract.View, MainBannerContract.Presenter> implements MainBannerContract.View {

    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;
    private ArrayList<String> mBannerTitleList;
    private ArrayList<String> mBannerUrlList;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public MainBannerContract.Presenter createPresenter() {
        return new MainPresenter(this.getActivity());
    }

    @Override
    public MainBannerContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        getPresenter().getBannerData();
    }


    @Override
    public void showBannerData(List<BannerData.DataBean> bannerDataList) {

        mBannerTitleList = new ArrayList<>();
        List<String> bannerImageList = new ArrayList<>();
        mBannerUrlList = new ArrayList<>();
        for (BannerData.DataBean bannerData : bannerDataList) {
            mBannerTitleList.add(bannerData.getTitle());
            bannerImageList.add(bannerData.getImagePath());
            mBannerUrlList.add(bannerData.getUrl());
        }
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(bannerImageList);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.ZoomOutSlide);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(mBannerTitleList);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(4000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
