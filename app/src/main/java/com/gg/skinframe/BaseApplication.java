package com.gg.skinframe;

import android.app.Application;

import com.gg.skinframe.skin.SkinManager;

/**
 * Creator:  GG
 * Time   :  2017/9/21.
 * Mail   :  gg.jin.yu@gmail.com
 * Explain:
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.getInstance().init(this);
    }
}
