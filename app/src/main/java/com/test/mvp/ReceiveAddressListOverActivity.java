package com.test.mvp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.mvp.View.ReceiveAddressListView;
import com.test.mvp.mode.AddressList;
import com.test.mvp.presenter.ReceiveAddressListOverPresenter;
import com.test.mvp.viewmode.ReceiveAddressListOverViewModel;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */

public class ReceiveAddressListOverActivity extends BaseOverActivity implements  ReceiveAddressListOverViewModel.onRefreshListener
{

    private int lastVisibleItem;
    private ReceiveAddressListOverPresenter presenter;
    private ReceiveAddressListOverViewModel listOverViewModel;

    @Override
    protected int initView() {
        return R.layout.activity_receive_address_listover;
    }



    @Override
    protected void initPresenter() {
        listOverViewModel = new ReceiveAddressListOverViewModel(rootView,this);
        presenter = new ReceiveAddressListOverPresenter(this,listOverViewModel);
    }



    @Override
    protected void creterView() {
        listOverViewModel.setonRefreshListener(this);
        listOverViewModel.rcView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem + 1 == listOverViewModel.listAdapter.getItemCount()) {
                    // 此处在现实项目中，请换成网络请求数据代码，sendRequest .....
                    presenter.getPageData(presenter.LOADING_STATUS, 2);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem =  listOverViewModel.layoutManager.findLastVisibleItemPosition();
            }
        });

        //这样做只是有动画效果不会刷新，所以同时还要调用onRefresh（）这个方法
        listOverViewModel.swiperefresh.post(new Runnable() {
            @Override
            public void run() {
                listOverViewModel.swiperefresh.setRefreshing(true);
                onRefresh();
            }
        });


    }

    @Override
    public void onRefresh() {
        presenter.getPageData(presenter.REFRESH_STATUS, 1);
    }


    protected static void start(Context context) {
        Intent intent = new Intent(context, ReceiveAddressListOverActivity.class);
        context.startActivity(intent);
    }

}
