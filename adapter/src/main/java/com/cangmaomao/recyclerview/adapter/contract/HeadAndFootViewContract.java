package com.cangmaomao.recyclerview.adapter.contract;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public interface HeadAndFootViewContract {


    /**
     * 添加头部
     */
    void addHeadView(int view);


    /**
     * 添加底部
     */
    void addFootView(int view);

    /**
     * 获取ViewHolder 添加过head的pos
     */
    int getRealPosition(RecyclerView.ViewHolder holder);


}
