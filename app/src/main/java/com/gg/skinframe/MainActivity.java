package com.gg.skinframe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.gg.skinframe.skin.SkinManager;
import com.gg.skinframe.skin.SkinResource;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class MainActivity extends BaseSkinActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.btn1) Button mBtn1;
    @BindView(R.id.btn2) Button mBtn2;
    @BindView(R.id.btn3) Button mBtn3;
    @BindView(R.id.img) ImageView mImg;

    Unbinder mUnbinder;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mUnbinder = ButterKnife.bind(this);
    }

    @Override
    public void changeSkin(SkinResource skinResource) {

    }


    @OnClick(R.id.btn1)
    public void onMBtn1Clicked() {
        Toast.makeText(this, "1111", Toast.LENGTH_SHORT).show();

        String skinPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "skin.skin";

        SkinManager.getInstance().loadSkin(skinPath);
    }

    @OnClick(R.id.btn2)
    public void onMBtn2Clicked() {
        Toast.makeText(this, "2222", Toast.LENGTH_SHORT).show();

        SkinManager.getInstance().restoreDefault();
    }

    @OnClick(R.id.btn3)
    public void onMBtn3Clicked() {
        Toast.makeText(this, "3333", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,MainActivity.class);

        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }
}
