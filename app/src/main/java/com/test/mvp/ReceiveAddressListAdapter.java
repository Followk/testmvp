package com.test.mvp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.mvp.mode.AddressList;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */
public class ReceiveAddressListAdapter extends RecyclerView.Adapter {
    private List<AddressList> viewData;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item_text, null);

        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder=   (MyViewHolder)holder;
       String addressStr = viewData.get(position).address;
        String nameStr = viewData.get(position).name;
        String phoneStr = viewData.get(position).phone;
        viewHolder.name.setText(nameStr);
        viewHolder.iphone.setText(phoneStr);
        viewHolder.addr.setText(addressStr);
    }

    @Override
    public int getItemCount() {
        return viewData != null ? viewData.size() : 0;
    }

    public void setRectViewData(List<AddressList> viewData) {
        this.viewData = viewData;
        notifyDataSetChanged();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView addr, iphone, name;

        public MyViewHolder(View itemView) {
            super(itemView);
            addr = (TextView) itemView.findViewById(R.id.addr);
            iphone = (TextView) itemView.findViewById(R.id.iphone);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
