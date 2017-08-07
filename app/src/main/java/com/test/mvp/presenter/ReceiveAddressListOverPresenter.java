package com.test.mvp.presenter;

import android.os.Handler;

import com.test.mvp.GetDataUtil;
import com.test.mvp.ReceiveAddressListOverActivity;
import com.test.mvp.mode.AddressList;
import com.test.mvp.presenter.BasePresenter;
import com.test.mvp.viewmode.ReceiveAddressListOverViewModel;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/7.
 */
public class ReceiveAddressListOverPresenter  implements BasePresenter {
    private final ReceiveAddressListOverActivity receiveAddressListOverActivity;
    private final ReceiveAddressListOverViewModel listOverViewModel;

    private Handler handler=new Handler();
    //下拉刷新状态
    public final  int REFRESH_STATUS=1;
    public boolean  isLoad=false;
    //上拉加载更多状态
    public final  int LOADING_STATUS=2;
    private ArrayList<AddressList> addressLists=new ArrayList<>();

    public ReceiveAddressListOverPresenter(ReceiveAddressListOverActivity receiveAddressListOverActivity, ReceiveAddressListOverViewModel listOverViewModel) {
        this.receiveAddressListOverActivity=receiveAddressListOverActivity;
        this.listOverViewModel=listOverViewModel;
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
                    listOverViewModel.setRectViewData(addressLists);
                    isLoad=false;
                }
            },1000);
        }

    }
}
