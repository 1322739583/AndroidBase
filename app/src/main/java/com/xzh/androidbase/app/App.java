package com.xzh.androidbase.app;

import android.app.Application;
import android.content.Context;



import com.xzh.androidbase.di.component.AppComponent;
import com.xzh.androidbase.di.component.DaggerAppComponent;
import com.xzh.androidbase.di.component.DaggerUserComponent;
import com.xzh.androidbase.di.component.UserComponent;


public class App extends Application {
    static AppComponent appComponent=   DaggerAppComponent.create();
   static UserComponent userComponent;

    public static UserComponent getUserComponent() {
        return userComponent;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }



	private void initMob() {
		//MobSDK.submitPolicyGrantResult(true,null);
	}

    @Override
    public void onCreate() {
        super.onCreate();
		initMob();

        userComponent = DaggerUserComponent.builder().appComponent(appComponent).build();

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
      //  MultiDex.install(this);
        System.out.println("");
    }
}
