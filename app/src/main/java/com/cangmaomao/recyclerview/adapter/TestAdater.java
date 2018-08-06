package com.cangmaomao.recyclerview.adapter;

import java.util.List;

public class TestAdater extends CMMAdapter<String> {


    public TestAdater(int layoutId, List<String> mData) {
        super(layoutId, mData);
    }

    @Override
    protected void convert(CMMViewHolder holder, String s, int position) {
        holder.setText(R.id.text1, s);
    }
}
