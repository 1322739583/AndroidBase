package com.xzh.androidbase.mvp.presenter;

import com.xzh.androidbase.base.mvp.BasePresenter;
import com.xzh.androidbase.mvp.contract.HomeContract;
import com.xzh.androidbase.mvp.model.HomeModel;
import com.xzh.androidbase.mvp.model.entry.Repo;

import java.util.List;

//import static com.google.common.base.Preconditions.checkNotNull;


public class HomePresenter extends BasePresenter  implements HomeModel.HomeCallBack {

    private HomeContract.View view;
    private HomeModel model;

    /**
     * Presenter同时关联View和Model
     * @param view
     *
     */
    public HomePresenter(HomeContract.View view) {
     //   this.view = checkNotNull(view,"MVP view can't be null");
      //  this.model = checkNotNull(model,"MVP model can't be null");
      this.view=view;
      this.model=new HomeModel();
      //这个非常关键，就是在这里将View和Presenter关联上的
       this.view.setPresenter(this);
       model.setCallBack(this);
    }

    /**
     * 获取数据，这个方法非常关键
     */
    public void onLoadData(){
       model.initData();
    }





    @Override
    public void onStart() {

    }

    @Override
    public void onComplete(List list) {
       view.updata(list);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext() {

    }
}
