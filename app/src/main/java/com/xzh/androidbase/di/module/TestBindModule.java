package com.xzh.androidbase.di.module;

import com.xzh.androidbase.mvp.model.entry.AInterface;
import com.xzh.androidbase.mvp.model.entry.AInterfaceImpl01;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class TestBindModule {

    @Binds
    abstract AInterface bindAInterface01(AInterfaceImpl01 impl01);

   @Provides
     static public AInterfaceImpl01 provideAInterfaceImpl01(){
        return new AInterfaceImpl01();
    }
}
