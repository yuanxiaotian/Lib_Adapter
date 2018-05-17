package com.cangmaomao.recyclerview.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cangmaomao.recyclerview.adapter.contract.ViewHolderContract;


public class CMMViewHolder extends RecyclerView.ViewHolder implements ViewHolderContract {

    //定义SparseArray 存储View



    private SparseArray<View> viewSparseArray = null;

    //View
    private View mItemView;

    public Context mContext;

    CMMViewHolder(View itemView) {
        super(itemView);
        this.mItemView = itemView;
    }

    private CMMViewHolder(View itemView, ViewGroup parent) {
        super(itemView);
        mContext = parent.getContext();
        this.mItemView = itemView;
        viewSparseArray = new SparseArray<>();
    }

    public static CMMViewHolder get(ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new CMMViewHolder(itemView, parent);
    }

    /**
     * 获取ViewID  进行存取
     *
     * @param viewId
     * @param <T>
     * @return
     */
    @SuppressWarnings("all")
    public <T extends View> T getView(int viewId) {
        View view = viewSparseArray.get(viewId);
        if (view == null) {
            view = mItemView.findViewById(viewId);
            viewSparseArray.put(viewId, view);
        }
        return (T) view;
    }

    //0:left       1:right      2:top       3:bottom
    //开始text设置--------------------------------------------------------------------------------------
    @Override
    public CMMViewHolder setText(int viewId, String str) {
        TextView textView = getView(viewId);
        textView.setText(str);
        return this;
    }                                   //|

    @Override
    public CMMViewHolder setText(int viewId, String str, int size) {
        TextView textView = getView(viewId);
        textView.setText(str);
        textView.setTextSize(size);
        return this;
    }                         //|

    @Override
    public CMMViewHolder setText(int viewId, String str, Object textColor) {
        TextView textView = getView(viewId);
        textView.setText(str);
        textView.setTextColor((int) textColor);
        return this;
    }                 //|

    @Override
    public CMMViewHolder setText(int viewId, String str, int direction, Drawable drawable) {
        TextView textView = getView(viewId);
        textView.setText(str);
        switch (direction) {
            case 0:
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
                break;

            case 1:
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                break;

            case 2:
                textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
                break;

            case 3:
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, drawable);
                break;
        }
        return this;
    } //|

    @Override
    public CMMViewHolder setText(int viewId, String str, int size, int textColor) {
        TextView textView = getView(viewId);
        textView.setText(str);
        textView.setTextSize(size);
        textView.setTextColor(textColor);
        return this;
    }          //|

    @Override
    public CMMViewHolder setTextSize(int viewId, int size) {
        TextView textView = getView(viewId);
        textView.setTextSize(size);
        return this;
    }                                 //|

    @Override
    public CMMViewHolder setTextColor(int viewId, int color) {
        TextView textView = getView(viewId);
        textView.setTextColor(color);
        return this;
    }                               //|
    //完毕text--------------------------------------------------------------------------------------

}

