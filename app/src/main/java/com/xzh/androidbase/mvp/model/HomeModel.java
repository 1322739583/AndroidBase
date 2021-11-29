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

/**
 * @TODO 好好分析一下Google给的MVP例子,好像Presenter和Model并不是互相关联的，而是单向的
 * @param <T>
 */
public class HomeModel<T> implements HomeContract.Model {

    private HomeCallBack callBack;
    private T mPresenter;


    public void setCallBack(HomeCallBack callBack) {
        this.callBack = callBack;
    }


    @Override
    public void getRepoData() {
        getRepoData("1322739583",1,10);
    }

    /**
     * 需要这种名字一样的私有方法来实现参数传递。
     * 这样写好像是不太对的，Google的MVP例子和MVP Arms网络请求都是放在Presenter来执行的。
     * 这样就可以不用写Callbacke这种回调接口了，在Presenter层，网络请求结束后，直接更新UI。而不是Model通知Presenter，
     * 然后Presneter再去更新UI。
     * 这个方法的作用是通过retrofit获取到一个Observable<Type>对象，而把网络请求交给Presenter。
     * 如果不这样，就是传统的方式在Presenter设置监听，比较麻烦。
     *
     * 这种操作的本质就是网络请求实在Presenter完成的，而不是在Model。如果在Presenter完成网络请求，就不需要Callback接口。
     * 如果是在Model完成网络请求，那么就需要Callback接口。
     * @param user
     * @param page
     * @param per_page
     */
    private  void getRepoData(String user, int page, int per_page) {



        ServiceGenerator.createService(RepoService.class)
                .getReposByPage(user,page,per_page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SimpleObserver<List<Repo>>() {
                    @Override
                    public void onNext(List<Repo> repos) {
                        Log.d("HomeModel", "repos:" + repos);
                        callBack.requestFinished(repos);
                    }
                });

    }

    @Override
    public void getBannerData() {

    }


    /**
     * 这个接口是没有问题的，必须要有。但可以简化，比如只有一个onComplete方法，表示数据请求完成了。
     * 这个接口是完全没有必要有四个方法的，只需要有一个方法就行了，通知Presenter请求已经完成了，要么是成功，要么是失败。
     * 如果是失败的话，是调用SimpleObserver本身的onError方法，根本就不会调用回调。
     */
    public  interface HomeCallBack{
        /**
         * 只需要有这一个方法就行了，而且不要取类似onComplete这个方法，然后搞混。
         * @param t
         */
        void requestFinished(List t);
    }
}
