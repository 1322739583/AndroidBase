package com.xzh.androidbase.base.mvp;

public class BasePresenter<V extends IView,M extends IModel>  implements IPresenter{
    V view;
    M model;

    @Override
    public void start() {

    }
}
