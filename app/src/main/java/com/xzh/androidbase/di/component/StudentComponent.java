package com.xzh.androidbase.di.component;

import com.xzh.androidbase.di.module.StudentModule;
import com.xzh.androidbase.mvp.ui.activity.SecondActivity;

import dagger.Subcomponent;

@Subcomponent(modules = StudentModule.class)
public interface StudentComponent {

    @Subcomponent.Factory
    interface Factory{
        StudentComponent create();
    }

   void inject(SecondActivity secondActivity);
}
