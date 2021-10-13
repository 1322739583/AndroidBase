package com.xzh.androidbase.mvp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.next.easynavigation.view.EasyNavigationBar;
import com.xzh.androidbase.R;
import com.xzh.androidbase.mvp.ui.fragment.AFragment;
import com.xzh.androidbase.mvp.ui.fragment.BFragment;
import com.xzh.androidbase.mvp.ui.fragment.CFragment;
import com.xzh.androidbase.mvp.ui.fragment.DFragment;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {

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


    }

    public EasyNavigationBar getNavigationBar() {

        return navigationBar;
    }



    public void login(View view) {
        ARouter.getInstance().build("/login/MainActivity").navigation();
    }
}
