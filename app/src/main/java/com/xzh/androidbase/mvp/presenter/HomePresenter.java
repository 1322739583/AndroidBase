package com.xzh.androidbase.mvp.presenter;

import androidx.core.util.Preconditions;

import com.xzh.androidbase.base.mvp.BasePresenter;
import com.xzh.androidbase.mvp.contract.HomeContract;
import com.xzh.androidbase.mvp.model.HomeModel;
import com.xzh.androidbase.mvp.model.entry.Repo;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.google.common.base.Preconditions.checkNotNull;


public class HomePresenter extends BasePresenter {

    private HomeContract.View view;
    private HomeContract.Model model;

    /**
     * Presenter同时关联View和Model
     * @param view
     * @param model
     */
    public HomePresenter(HomeContract.View view, HomeContract.Model model) {
        this.view = checkNotNull(view,"MVP view can't be null");
        this.model = checkNotNull(model,"MVP model can't be null");

        //这个非常关键，就是在这里将View和Presenter关联上的
        this.view.setPresenter(this);
    }


    public void onLoadData(){
        model.initData().subscribe(new Observer<List<Repo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Repo> repos) {

            }

            @Override
            public void onError(Throwable e) {
                   view.showError(e);
            }

            @Override
            public void onComplete() {

            }
        });
    }



}