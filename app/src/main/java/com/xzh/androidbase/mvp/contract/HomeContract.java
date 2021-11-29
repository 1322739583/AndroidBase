package com.xzh.androidbase.mvp.contract;

import com.xzh.androidbase.base.mvp.BasePresenter;
import com.xzh.androidbase.base.mvp.BaseView;
import com.xzh.androidbase.mvp.model.entry.Repo;

import java.util.List;

import io.reactivex.Observable;

/**
 * 既然都已经取了特定名字的Contract了，那么View和Model里面的具体类型也可以是确定的了，而不需要泛型.
 * 如果要使用Contract这种方式，那么就不可能存在BaseView或者BaseModel这种东西。因为她们已经是class而不是interface.
 * Contract是否是一种好的方式？如果我就是需要实现一些Base功能怎么办？
 *
 */
public interface HomeContract {

    /**
     * 1.加载和加载更多不应该放在这里，需要的时候自己实现就行了，但是因为特别的常用，所以可以考虑单独实现例如QuickView
     * 2.需要分析一个页面视图的构成，把可能的情况都列举出来。
     * 3.实现BaseView和她的子View.
     *
     * @param <T>
     * @param <D>
     */
    interface View<T extends BasePresenter, D> {

        void setPresenter(T presenter);

        /**
         * 第一次更新数据
         *
         * @param data
         */
        //@TODO 类型怎么确定，用Object吗？可以考虑用泛型
        void initData(D data);

        /**
         * 更新数据
         *
         * @param data
         */
        void updateData(D data);
    }

    interface Model {
        /**
         * 获取主页面列表。不要取像initData这种名字，这种名字在Contract里面是不存在的。因为每个请求都有自己的名字。
         */
        void getRepoData();

        /**
         * 获取Banner的数据
         */
        void getBannerData();

        /**
         * 这个方法并不是必须的，因为有的页面没有刷新功能，不会使用到这个接口。
         * 如果是有刷新功能的界面，那么View一定有对应的刷新方法，如showLoading方法。但现在View没有这个方法。
         * 所以也不应该有这个方法。
         * 实际上，根本就不需要这个方法，刷新无非就是再次调用原来的方法。
         */
      //  void refreshDate();

      //  void loadMoreData();
    }
}
