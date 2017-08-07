package com.test.mvp.presenter;

import android.os.Handler;

import com.test.mvp.GetDataUtil;
import com.test.mvp.ReceiveAddressListActivity;
import com.test.mvp.mode.AddressList;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/7.
 */

public class ReceiveAddressListPresenter implements BasePresenter{
    private Handler  handler=new Handler();
    //下拉刷新状态
    public final  int REFRESH_STATUS=1;
    public boolean  isLoad=false;
    //上拉加载更多状态
    public final  int LOADING_STATUS=2;
    private final ReceiveAddressListActivity receiveAddressListActivity;
    private  ArrayList<AddressList>  addressLists=new ArrayList<>();
    public ReceiveAddressListPresenter(ReceiveAddressListActivity receiveAddressListActivity) {
        this.receiveAddressListActivity=receiveAddressListActivity;
    }

    @Override
    public void getPageData(final int state, final int page) {//这个地方进行网络请求

        if (!isLoad)
        {
            isLoad=true;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ArrayList<AddressList>  lists=  GetDataUtil.getAddressList(page);
                    if (state==REFRESH_STATUS)//刷新数据
                    {
                        addressLists=lists;
                    }else {//上拉加载
                        addressLists.addAll(lists);
                    }
                    receiveAddressListActivity.setRectViewData(addressLists);
                    isLoad=false;
                }
            },1000);
        }

    }

}
