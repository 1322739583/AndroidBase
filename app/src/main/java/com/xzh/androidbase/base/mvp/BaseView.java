package com.xzh.androidbase.base.mvp;

public class BaseView<T>  implements IView<T>{
    T present;

    @Override
    public void setPresenter(T presenter) {
            this.present=presenter;
    }



}
