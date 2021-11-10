package com.xzh.androidbase.mvp.model;

import android.util.Log;

import com.xzh.androidbase.app.SimpleObserver;
import com.xzh.androidbase.di.component.DaggerAppComponent;
import com.xzh.androidbase.mvp.contract.HomeContract;
import com.xzh.androidbase.mvp.model.api.ServiceGenerator;
import com.xzh.androidbase.mvp.model.api.service.RepoService;
import com.xzh.androidbase.mvp.model.entry.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class HomeModel implements HomeContract.Model {

    private HomeCallBack callBack;





    @Override
    public void initData() {
        getData("1322739583",1,10);

    }

    private  void getData(String user, int page, int per_page) {
        ServiceGenerator.createService(RepoService.class)
                .getReposByPage(user,page,per_page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SimpleObserver<List<Repo>>() {
                    @Override
                    public void onNext(List<Repo> repos) {
                       Log.d("HomeModel", "repos:" + repos);
                    }
                });

    }

    @Override
    public void refreshDate() {

    }

    @Override
    public void loadMoreData() {

    }


    interface HomeCallBack{
        void onStart();
        void onComplete();
        void onError(Throwable e);
        void onNext();
    }
}
