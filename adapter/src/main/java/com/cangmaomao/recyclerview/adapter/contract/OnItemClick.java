package com.cangmaomao.recyclerview.adapter.contract;


import com.cangmaomao.recyclerview.adapter.CMMAdapter;

public interface OnItemClick {

    void onItemClick(CMMAdapter adapter, Object obj, int position);

//    boolean onItemLongClick(CMMAdapter adapter, Object obj, int position);
}
