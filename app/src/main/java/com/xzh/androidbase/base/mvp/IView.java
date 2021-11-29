package com.xzh.androidbase.base.mvp;

public interface IView<T> {
    /**
     * 设置presenter
     * @param presenter
     */
    void setPresenter(T presenter);

    /**
     * 显示加载
     */
    default void showLoading() {

    }

    /**
     * 隐藏加载
     */
    default void hideLoading() {

    }
}
