package com.test.mvp.viewmode;

import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.test.mvp.R;
import com.test.mvp.ReceiveAddressListAdapter;
import com.test.mvp.ReceiveAddressListOverActivity;
import com.test.mvp.View.ReceiveAddressListView;
import com.test.mvp.mode.AddressList;

import java.util.List;

import static android.support.v7.recyclerview.R.attr.layoutManager;

/**
 * Created by Administrator on 2017/8/7.
 */

public class ReceiveAddressListOverViewModel implements ReceiveAddressListView, SwipeRefreshLayout.OnRefreshListener {
    private final View view;
    private final Activity context;
    public RecyclerView rcView;
    public SwipeRefreshLayout swiperefresh;
    public LinearLayoutManager layoutManager;
    public ReceiveAddressListAdapter listAdapter;
    private onRefreshListener refreshListener;

    public ReceiveAddressListOverViewModel(View view,Activity context) {
        this.view=view;
        this.context=context;
        findViewById();
        initRecyclerView();
    }

    protected void findViewById() {
        rcView = (RecyclerView) view.findViewById(R.id.rcView);


        swiperefresh = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        swiperefresh.setOnRefreshListener(this);
        initRecyclerView();
    }


    private void initRecyclerView() {
        layoutManager = new LinearLayoutManager(context);
        rcView.setLayoutManager(layoutManager);
        listAdapter = new ReceiveAddressListAdapter();
        rcView.setAdapter(listAdapter);
    }

    @Override
    public void setRectViewData(List<AddressList> viewData) {
        swiperefresh.setRefreshing(false);
        listAdapter.setRectViewData(viewData);
    }

    @Override
    public void onRefresh() {
        if (refreshListener!=null)
        {
            refreshListener.onRefresh();
        }
    }


    public  interface   onRefreshListener
    {
        void onRefresh();
    }

    public  void setonRefreshListener(onRefreshListener  refreshListener)
    {
        this.refreshListener=refreshListener;
    }
}
