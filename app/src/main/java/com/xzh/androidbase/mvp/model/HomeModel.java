package com.xzh.androidbase.mvp.model;

import android.util.Log;

import com.xzh.androidbase.app.SimpleObserver;
import com.xzh.androidbase.mvp.contract.HomeContract;
import com.xzh.androidbase.mvp.model.api.ServiceGenerator;
import com.xzh.androidbase.mvp.model.api.service.RepoService;
import com.xzh.androidbase.mvp.model.entry.Repo;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class HomeModel<T>  implements HomeContract.Model {

    private HomeCallBack callBack;


    public void setCallBack(HomeCallBack callBack) {
        this.callBack = callBack;
    }

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
                       callBack.onComplete(repos);
                    }
                });

    }

    @Override
    public void refreshDate() {

    }

    @Override
    public void loadMoreData() {

    }


    /**
     * 这个接口是没有问题的，必须要有。但可以简化，比如只有一个onComplete方法，表示数据请求完成了。
     */
    public  interface HomeCallBack{
        void onStart();
        void onComplete(List t);
        void onError(Throwable e);
        void onNext();
    }
}
