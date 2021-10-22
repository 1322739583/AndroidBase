package com.xzh.androidbase.di.component;

import com.xzh.androidbase.di.module.NetModule;
import com.xzh.androidbase.di.module.TestModule;
import com.xzh.androidbase.mvp.model.api.service.RepoService;
import com.xzh.androidbase.mvp.ui.activity.MainActivity;
import com.xzh.androidbase.mvp.ui.activity.SecondActivity;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {NetModule.class })
public interface AppComponent {
    /**
     * 这个方法的名字是随便取的
     *
     */
    void setValue(MainActivity mainActivity);

    void inject(SecondActivity secondActivity);

     Retrofit retrofit();

    RepoService repoService();

     OkHttpClient okHttpClient();
}
