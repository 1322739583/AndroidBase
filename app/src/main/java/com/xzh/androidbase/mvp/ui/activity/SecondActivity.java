package com.xzh.androidbase.mvp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import com.xzh.androidbase.R;
import com.xzh.androidbase.app.App;
import com.xzh.androidbase.mvp.model.api.service.RepoService;
import com.xzh.androidbase.mvp.model.entry.AInterface;
import com.xzh.androidbase.mvp.model.entry.Student;
import com.xzh.androidbase.mvp.model.entry.User;
import com.xzh.androidbase.mvp.model.entry.annotation.StudentNoArgs;
import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {
    @Inject
    User user;

    @Inject
    User user2;
    @Inject
    RepoService repoService;

    @Inject
    RepoService repoService2;

//    @StudentNoArgs
//    @Inject
//    Student student;

//    @StudentNoArgs
//    @Inject
//    Student student2;

    @Inject
    AInterface aInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

      //  App.getUserComponent().inject(this);
      //  DaggerUserComponent.builder().appComponent(App.getAppComponent()).build().inject(this);

       // DaggerAppComponent.create().studentComponent().create().inject(this);
        App.getAppComponent().studentComponent().create().inject(this);

        Log.d("SecondActivity", "user:" + user);
        Log.d("SecondActivity", "user2:" + user2);
        Log.d("SecondActivity", "repoService:" + repoService);
        Log.d("SecondActivity", "repoService2:" + repoService2);

      //  Log.d("SecondActivity", "student:" + student);
      //  Log.d("SecondActivity", "student2:" + student2);
        Log.d("SecondActivity", "aInterface:" + aInterface);


    }
}
