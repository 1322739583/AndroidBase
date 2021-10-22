package com.xzh.androidbase.mvp.model.entry;

import javax.inject.Inject;

public class User {
    String name;
    String age;

    @Inject
    public User() {
    }

    public User(String name, String age) {
        this.name = name;
    }
}


