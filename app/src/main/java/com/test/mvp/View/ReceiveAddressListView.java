package com.test.mvp.View;

import com.test.mvp.mode.AddressList;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 *
 * view  层抽象类
 */

public interface ReceiveAddressListView {

    public  void  setRectViewData(List<AddressList>  viewData);
}
