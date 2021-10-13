package com.xzh.androidbase.app;

import android.app.Application;

import com.mob.MobSDK;

public class App extends Application {

	private void initMob() {
		MobSDK.submitPolicyGrantResult(true,null);
	}

    @Override
    public void onCreate() {
        super.onCreate();
		initMob();
    }
}
