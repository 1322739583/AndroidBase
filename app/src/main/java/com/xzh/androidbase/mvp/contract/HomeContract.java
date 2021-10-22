package com.xzh.androidbase.mvp.contract;

import com.xzh.androidbase.base.mvp.BaseView;
import com.xzh.androidbase.mvp.model.entry.Repo;
import java.util.List;
import io.reactivex.Observable;

public interface HomeContract {

    interface View<T>   {
        void showLoading();
        void hideLoading();
        void showError(Throwable e);
        void setPresenter(T presenter);
    }

    interface Model{
        Observable<List<Repo>> initData();
       void refreshDate();
       void loadMoreData();
    }
}
