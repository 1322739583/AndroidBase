package com.xzh.androidbase.base;

import android.app.Activity;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    public void startActivity(Class target){
        startActivity(new Intent(this,target));
    }
}
