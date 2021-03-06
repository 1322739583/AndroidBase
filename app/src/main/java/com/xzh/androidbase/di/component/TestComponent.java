package com.xzh.androidbase.di.component;

import com.xzh.androidbase.di.module.UserModule;
import com.xzh.androidbase.di.scope.TestScope;
import com.xzh.androidbase.di.scope.UserScope;
import com.xzh.androidbase.mvp.ui.activity.MainActivity;

import dagger.Component;


/**
 * AppComponent从业务逻辑上来说是都是全局单例，并且是全局通用的，
 * 因为他提供了像NetModule这样的通用网络功能。
 * 依赖AppComponent的目的就是为了获得这些功能（网络，数据库，地图等）
 * 1.通过dependencies指定依赖的组件
 */
//@TestScope
//@Component(modules = {TestComponent.class},dependencies = {AppComponent.class})
//public interface TestComponent {
//
//   void inject(MainActivity mainActivity);
//}
