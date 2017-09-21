package com.gg.skinframe.skin.callback;


import com.gg.skinframe.skin.SkinResource;

/**
 * Creator:  GG
 * Time   :  2017/9/20.
 * Mail   :  gg.jin.yu@gmail.com
 * Explain:  给自定义控件提供更换皮肤的Resource
 */

public interface ISkinChangeListener {

    void changeSkin(SkinResource skinResource);
}
