package com.babuwyt.carrier.base;

import android.app.Application;
import android.text.TextUtils;

import com.babuwyt.carrier.bean.User;
import com.babuwyt.carrier.finals.SharePrefKeys;
import com.babuwyt.carrier.util.SharePreferencesUtils;
import com.google.gson.Gson;

import org.xutils.x;


/**
 * Created by lenovo on 2017/6/28.
 */

public class ClientApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        x.Ext.init(this);
        initUserInfo();
//        Location();
    }
    /**
     * 初始化用户信息
     */
    private void initUserInfo() {
        String data = SharePreferencesUtils.getString(this, SharePrefKeys.XML_PREFERENCES, SharePrefKeys.XML_NAME_USER_INFO, "");
        if (!TextUtils.isEmpty(data)) {
            Gson gson = new Gson();
            User user = gson.fromJson(data, User.class);
            SessionManager sessionManager = SessionManager.getInstance();
            if (user != null) {
                sessionManager.setUser(user);
            }
        }
    }
    /**
     * 保存登录用户的信息
     *
     * @param user
     */
    public void saveLoginUser(User user) {
        if (user == null) {
            return;
        }
        Gson gson = new Gson();
        String data = gson.toJson(user);

        SharePreferencesUtils.saveString(this, SharePrefKeys.XML_PREFERENCES, SharePrefKeys.XML_NAME_USER_INFO, data);
        this.initUserInfo();
    }
    /**
     * 清除用户登录信息
     */
    public  void clearLoginUser() {
        SharePreferencesUtils.clearAll(this, SharePrefKeys.XML_PREFERENCES);
        SessionManager sessionManager = SessionManager.getInstance();
        sessionManager.setUser(null);
    }
}
