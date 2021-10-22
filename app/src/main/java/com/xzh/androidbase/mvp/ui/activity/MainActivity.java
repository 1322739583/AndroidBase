package com.xzh.androidbase.mvp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.next.easynavigation.view.EasyNavigationBar;
import com.xzh.androidbase.R;

import com.xzh.androidbase.app.App;
import com.xzh.androidbase.di.component.DaggerAppComponent;
import com.xzh.androidbase.di.component.DaggerUserComponent;
import com.xzh.androidbase.mvp.model.api.service.RepoService;
import com.xzh.androidbase.mvp.model.entry.Repo;
import com.xzh.androidbase.mvp.model.entry.User;
import com.xzh.androidbase.mvp.ui.fragment.AFragment;
import com.xzh.androidbase.mvp.ui.fragment.BFragment;
import com.xzh.androidbase.mvp.ui.fragment.CFragment;
import com.xzh.androidbase.mvp.ui.fragment.DFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Route(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {
    @Inject
    User user;

    @Inject
    User user2;
    @Inject
    Retrofit retrofit;

    @Inject
    OkHttpClient client;

    @Inject
    RepoService repoService;

    @Inject
    RepoService repoService2;

    @Inject
    RepoService repoService3;

//    @Inject
//    Repo repo;

    private EasyNavigationBar navigationBar;

    private String[] tabText = {"首页", "发现", "消息", "我的"};
    //未选中icon
    private int[] normalIcon = {R.mipmap.index, R.mipmap.find, R.mipmap.message, R.mipmap.me};
    //选中时icon
    private int[] selectIcon = {R.mipmap.index1, R.mipmap.find1, R.mipmap.message1, R.mipmap.me1};

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       //App.getAppComponent().inject(this);
     //  App.getAppComponent().setValue(this);
       App.getUserComponent().inject(this);
     //   DaggerAppComponent.create().setValue(this);

      //  DaggerUserComponent.builder().appComponent(App.getAppComponent()).build().inject(this);

        Log.d("MainActivity", "user:" + user);
        Log.d("MainActivity", "user2:" + user2);
        Log.d("MainActivity", "retrofit:" + retrofit);
        Log.d("MainActivity", "repoService1:" + repoService);
        Log.d("MainActivity", "repoService2:" + repoService2);
        Log.d("MainActivity", "repoService3:" + repoService3);
      //  Log.d("MainActivity", "repo:" + repo);

        navigationBar = findViewById(R.id.navigationBar);

        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());

        navigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .fragmentManager(getSupportFragmentManager())
                .canScroll(true)
                .build();

        startActivity(new Intent( MainActivity.this,SecondActivity.class));


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "user2:" + user2);
    }

    public EasyNavigationBar getNavigationBar() {

        String str=new String();


        return navigationBar;
    }


    public void login(View view) {
        ARouter.getInstance().build("/login/MainActivity").navigation();
    }
}
