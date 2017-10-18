package com.babuwyt.carrier.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import org.xutils.x;

/**
 * Created by lenovo on 2017/6/28.
 */

public class BaseActivity extends AppCompatActivity {
    @SuppressLint({"NewApi", "ResourceAsColor"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
}
