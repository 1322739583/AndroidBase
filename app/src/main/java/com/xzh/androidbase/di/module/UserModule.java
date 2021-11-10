package com.xzh.androidbase.di.module;

import com.xzh.androidbase.di.scope.UserScope;
import com.xzh.androidbase.mvp.model.HomeModel;
import com.xzh.androidbase.mvp.model.api.ServiceGenerator;
import com.xzh.androidbase.mvp.model.api.service.RepoService;
import com.xzh.androidbase.mvp.model.entry.Repo;
import com.xzh.androidbase.mvp.model.entry.User;
import com.xzh.androidbase.mvp.presenter.HomePresenter;
import com.xzh.androidbase.mvp.ui.fragment.AFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {
    @UserScope
    @Provides
    public User provideUser(){
        return new User();
    }

    @UserScope
    @Provides
    public Repo provideRepo(){
        return new Repo("xzh");
    }






}
