package com.xzh.androidbase.base.mvp;

public interface IView<T> {
    /**
     * 设置presenter
     * @param presenter
     */
    void setPresenter(T presenter);
}
