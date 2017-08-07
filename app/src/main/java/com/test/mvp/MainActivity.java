package com.test.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_01,tv_02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int initView() {
        return R.layout.activity_main;
    }


    @Override
    protected void findViewById() {
         tv_01 = (TextView) findViewById(R.id.tv_01);
          tv_02= (TextView) findViewById(R.id.tv_02);
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void setOnListener() {
        tv_01.setOnClickListener(this);
        tv_02.setOnClickListener(this);
    }

    @Override
    protected void creterView() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tv_01:
                ReceiveAddressListActivity.start(this);
                break;
            case R.id.tv_02:
                ReceiveAddressListOverActivity.start(this);
                break;
            default:
                break;
        }
    }
}
