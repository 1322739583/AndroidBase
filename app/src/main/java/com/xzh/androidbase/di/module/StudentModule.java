package com.xzh.androidbase.di.module;



import com.xzh.androidbase.mvp.model.entry.Student;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class StudentModule {

    @Named("student1")
    @Provides
    public Student provideStudent(){
        return new Student();
    }

    @Named("student2")
    @Provides
    public Student provideStudent2(){
        return new Student("张三");
    }
}
