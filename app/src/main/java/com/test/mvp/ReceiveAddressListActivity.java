package com.test.mvp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.mvp.View.ReceiveAddressListView;
import com.test.mvp.mode.AddressList;
import com.test.mvp.presenter.ReceiveAddressListPresenter;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */

public class ReceiveAddressListActivity extends BaseActivity implements ReceiveAddressListView, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView rcView;
    private ReceiveAddressListPresenter presenter;
    private ReceiveAddressListAdapter listAdapter;
    private SwipeRefreshLayout swiperefresh;
    private LinearLayoutManager layoutManager;
    private int lastVisibleItem=0;

    @Override
    protected int initView() {
        return R.layout.activity_receive_address_list;
    }

    @Override
    protected void findViewById() {
        rcView = (RecyclerView) findViewById(R.id.rcView);


        swiperefresh = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        swiperefresh.setOnRefreshListener(this);
        initRecyclerView();


    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        layoutManager = new LinearLayoutManager(this);
        rcView.setLayoutManager(layoutManager);
        listAdapter = new ReceiveAddressListAdapter();
        rcView.setAdapter(listAdapter);
    }

    @Override
    protected void initPresenter() {
        presenter = new ReceiveAddressListPresenter(this);
    }

    @Override
    protected void setOnListener() {
        rcView.addOnScrollListener(new RecyclerView.OnScrollListener() {


            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem + 1 == listAdapter.getItemCount()) {
                    // 此处在现实项目中，请换成网络请求数据代码，sendRequest .....
                    presenter.getPageData(presenter.LOADING_STATUS, 2);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            }
        });
    }

    @Override
    protected void creterView() {

        //这样做只是有动画效果不会刷新，所以同时还要调用onRefresh（）这个方法
        swiperefresh.post(new Runnable() {
            @Override
            public void run() {
                swiperefresh.setRefreshing(true);
                onRefresh();

            }
        });
    }


    /**
     * 实现   ReceiveAddressListView  接口方法以便被调用
     *
     * @param viewData
     */
    @Override
    public void setRectViewData(List<AddressList> viewData) {
        swiperefresh.setRefreshing(false);
        listAdapter.setRectViewData(viewData);
    }

    /**
     * 刷新数据
     */
    @Override
    public void onRefresh() {
        presenter.getPageData(presenter.REFRESH_STATUS, 1);
    }


    protected static void start(Context context) {
        Intent intent = new Intent(context, ReceiveAddressListActivity.class);
        context.startActivity(intent);
    }
}
