package com.babuwyt.carrier.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.babuwyt.carrier.R;
import com.babuwyt.carrier.base.BaseActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by lenovo on 2017/10/26.
 */

@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity {
    @ViewInject(R.id.toolbar)
    Toolbar toolbar;
    @ViewInject(R.id.tv_login)
    TextView tv_login;

    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar(false);
        init();
    }

    private void init() {
        intent=new Intent();
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    @Event(value = {R.id.tv_login})
    private void getE(View v){
        switch (v.getId()){
            case R.id.tv_login:
                intent.setClass(this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
