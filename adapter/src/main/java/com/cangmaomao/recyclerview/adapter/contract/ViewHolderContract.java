package com.cangmaomao.recyclerview.adapter.contract;

import android.graphics.drawable.Drawable;

import com.cangmaomao.recyclerview.adapter.CMMViewHolder;


/**
 * ViewHolder 所有方法管理
 */

public interface ViewHolderContract {

    CMMViewHolder setText(int viewId, String str);

    CMMViewHolder setText(int viewId, String str, int size);

    CMMViewHolder setText(int viewId, String str, Object textColor);

    CMMViewHolder setText(int viewId, String str, int direction, Drawable drawable);

    CMMViewHolder setText(int viewId, String str, int size, int textColor);

    CMMViewHolder setTextSize(int viewId, int size);

    CMMViewHolder setTextColor(int viewId, int color);

}
