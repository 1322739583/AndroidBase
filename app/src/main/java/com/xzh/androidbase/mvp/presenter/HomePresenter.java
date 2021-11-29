package com.xzh.androidbase.mvp.presenter;

import com.xzh.androidbase.base.mvp.BasePresenter;
import com.xzh.androidbase.mvp.contract.HomeContract;
import com.xzh.androidbase.mvp.model.HomeModel;
import java.util.List;

//import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @TODO 实现Adapter的注入功能
 * 网络请求是需要在Presneter里面完成的，需要通过Adaper(View的框架一般是RecycleView.Adapter)来更新View.
 * 而且这个Adapter可以通过Dagger在Module里面注入，还是比较神奇的，不然的话，就需要传参。那样的话，代码就非常的乱。
 * 而且非常的冗余。到处都是set方法。
 */
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
       model.getRepoData();
       //获取别的接口数据
       //model.getBannerData();
    }

    @Override
    public void requestFinished(List list) {
        view.initData(list);
    }
}
