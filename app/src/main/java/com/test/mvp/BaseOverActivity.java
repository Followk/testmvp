package com.test.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Administrator on 2017/8/7.
 */

public abstract class BaseOverActivity extends AppCompatActivity {

    public View rootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = LayoutInflater.from(this).inflate(initView(),null);
        setContentView(rootView);
        initPresenter();
        creterView();
    }


    /**
     * 初始化控件
     * @return
     */
    protected   abstract int  initView();


    //初始化控制层
    protected abstract void   initPresenter();

    protected   abstract  void  creterView();
}
