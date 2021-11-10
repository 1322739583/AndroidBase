package com.xzh.androidbase.app;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class SimpleObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }


    @Override
    public void onError(Throwable e) {
           e.printStackTrace();
    }

    @Override
    public void onComplete() {

    }

    public abstract void onNext(T t);
}