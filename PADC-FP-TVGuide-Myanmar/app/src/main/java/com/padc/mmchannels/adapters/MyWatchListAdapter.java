package com.padc.mmchannels.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.mmchannels.R;
import com.padc.mmchannels.MMChannelsApp;
import com.padc.mmchannels.data.vos.MyWatchListVO;
import com.padc.mmchannels.views.holders.MyWatchListViewHolder;

import java.util.List;

/**
 * Created by Administrator's user on 09-Sep-16.
 */
public class MyWatchListAdapter extends RecyclerView.Adapter<MyWatchListViewHolder> {

    private LayoutInflater inflater;
    private List<MyWatchListVO> mMyWatchListVOs;
    private MyWatchListViewHolder.ControllerMyWatchListItem mControllerMyWatchListItem;

    public MyWatchListAdapter(List<MyWatchListVO> programList, MyWatchListViewHolder.ControllerMyWatchListItem controllerMyWatchListItem) {
        inflater = LayoutInflater.from(MMChannelsApp.getContext());
        mMyWatchListVOs = programList;
        mControllerMyWatchListItem = controllerMyWatchListItem;
    }

    @Override
    public MyWatchListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_item_my_watchlist,parent,false);
        MyWatchListViewHolder watchListVH = new MyWatchListViewHolder(view, mControllerMyWatchListItem);
        return watchListVH;
    }

    @Override
    public void onBindViewHolder(MyWatchListViewHolder holder, int position) {
        holder.bindData(mMyWatchListVOs.get(position));
    }

    @Override
    public int getItemCount() {
        return mMyWatchListVOs.size();
    }

    public void setNewData(List<MyWatchListVO> newMyWatchListVOs) {
        mMyWatchListVOs = newMyWatchListVOs;
        notifyDataSetChanged();
        Log.e(MMChannelsApp.TAG, "MyWatchListAdapter.setNewData.newMyWatchListVOs.size : " + newMyWatchListVOs.size());
    }
}