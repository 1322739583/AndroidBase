package com.xzh.androidbase.mvp.model;

import com.xzh.androidbase.mvp.contract.HomeContract;
import com.xzh.androidbase.mvp.model.api.ServiceGenerator;
import com.xzh.androidbase.mvp.model.api.service.RepoService;
import com.xzh.androidbase.mvp.model.entry.Repo;

import java.util.List;
import io.reactivex.Observable;


public class HomeModel implements HomeContract.Model {

    private HomeCallBack callBack;

    @Override
    public Observable<List<Repo>> initData() {
         return getData("1322739583",1,10);
    }

    private Observable<List<Repo>> getData(String user, int page, int per_page) {
        return ServiceGenerator.createService(RepoService.class)
                .getReposByPage(user,page,per_page);
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
