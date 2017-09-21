package com.gg.skinframe.skin.attr;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gg.skinframe.skin.SkinManager;
import com.gg.skinframe.skin.SkinResource;


/**
 * Created by GG on 2017/9/16.
 */

public enum SkinType {


    TEXT_COLOR("textColor") {
        @Override
        public void skin(View view, String resName) {
            SkinResource skinResource = getSkinResource();

            ColorStateList colorStateList = skinResource.getColorByName(resName);
            if (colorStateList == null)
                return;

            ((TextView) view).setTextColor(colorStateList);
        }
    }, BACKGROUND("background") {
        @Override
        public void skin(View view, String resName) {
            SkinResource skinResource = getSkinResource();
            Drawable drawable = skinResource.getDrawableByName(resName);
            if (drawable != null) {
                ((ImageView) view).setImageDrawable(drawable);
                return;
            }

            //可能是颜色
            ColorStateList colorStateList = skinResource.getColorByName(resName);
            if (colorStateList != null) {
                view.setBackgroundColor(colorStateList.getDefaultColor());
                return;
            }
        }
    }, SRC("src") {
        @Override
        public void skin(View view, String resName) {
            SkinResource skinResource = getSkinResource();
            Drawable drawable = skinResource.getDrawableByName(resName);
            if (drawable != null) {
                ((ImageView) view).setImageDrawable(drawable);
                return;
            }
        }
    };

    //会根据名字调用对应的方法
    private String mResName;

    SkinType(String resName) {
        this.mResName = resName;
    }

    public abstract void skin(View view, String resName);

    public String getResName() {
        return mResName;
    }

    public SkinResource getSkinResource() {
        return SkinManager.getInstance().getSkinResource();
    }
}
