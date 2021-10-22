package com.xzh.androidbase.di.module;

import com.xzh.androidbase.mvp.model.HomeModel;
import com.xzh.androidbase.mvp.model.api.service.RepoService;
import com.xzh.androidbase.mvp.model.entry.AddRelease;
import com.xzh.androidbase.mvp.model.entry.AddReleaseResponse;
import com.xzh.androidbase.mvp.model.entry.AddUserResponse;
import com.xzh.androidbase.mvp.model.entry.AssertResponse;
import com.xzh.androidbase.mvp.model.entry.Release;
import com.xzh.androidbase.mvp.model.entry.Repo;
import com.xzh.androidbase.mvp.model.entry.User;
import com.xzh.androidbase.mvp.ui.adapter.HomeAdapter;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

@Module
public class NetModule {

    @Singleton
    @Provides
    public OkHttpClient providekHttpClient(){
        return new OkHttpClient.Builder()
                .callTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient client ){
        return new Retrofit
                .Builder()
                .baseUrl("https://www.google.com")
                .client(client)
                .build();
    }

    @Singleton
    @Provides
    public RepoService provideRepoService(Retrofit retrofit){
        return retrofit.create(RepoService.class);
    }

    @Singleton
    @Provides
    public Interceptor providerInterceptor(){
        return new HttpLoggingInterceptor();
    }
    @Singleton
    @Provides
    public User provideUser(){
        return new User();
    }

    @Singleton
    @Provides
    public HomeModel provideHomeAdapter(){
        return new HomeModel();
    }

    @Singleton
    @Provides
    public AddRelease provideAddRelease(){
        return new AddRelease();
    }

    @Singleton
    @Provides
    public Release provideRelease(){
        return new Release();
    }

    @Singleton
    @Provides
    public AddUserResponse provideAUR(){
        return new  AddUserResponse();
    }





}
