package com.cangmaomao.recyclerview.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cangmaomao.recyclerview.adapter.contract.AdapterContract;
import com.cangmaomao.recyclerview.adapter.contract.HeadAndFootViewContract;
import com.cangmaomao.recyclerview.adapter.contract.OnItemClick;

import java.util.ArrayList;
import java.util.List;

public abstract class CMMAdapter<T> extends RecyclerView.Adapter<CMMViewHolder> implements AdapterContract<T>, HeadAndFootViewContract {

    private static final int BASE_ITEM_TYPE_HEADER = 0;
    private static final int BASE_ITEM_TYPE_FOOTER = 1;
    private static final int BASE_ITEM_TYPE_NOT = 2;

    private List<T> mData;
    private int mLayoutId;
    private View mHeaderView;
    private boolean noMoreData = true;
    private OnItemClick onItemClickListener;


    public CMMAdapter(List<T> mData) {
        this.mData = mData;
    }

    public CMMAdapter(int layoutId) {
        this.mLayoutId = layoutId;
    }

    public CMMAdapter(int layoutId, List<T> mData) {
        this.mData = mData;
        this.mLayoutId = layoutId;
    }


    @NonNull
    @Override
    public CMMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mHeaderView != null && viewType == BASE_ITEM_TYPE_HEADER) {
            return new CMMViewHolder(mHeaderView);
        }
        return CMMViewHolder.get(parent, mLayoutId);
    }


    @Override
    public int getItemViewType(int position) {
        if (mHeaderView == null) return BASE_ITEM_TYPE_NOT;
        if (position == 0) return BASE_ITEM_TYPE_HEADER;
        return BASE_ITEM_TYPE_NOT;
    }

    @Override
    public void onBindViewHolder(@NonNull CMMViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        if (getItemViewType(position) == BASE_ITEM_TYPE_HEADER) return;
        final int pos = getRealPosition(holder);
        convert(holder, mData.get(pos), pos);
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(CMMAdapter.this, mData.get(pos), pos);
                }
            });
        }
    }

    @Override
    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    @SuppressWarnings("all")
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == BASE_ITEM_TYPE_HEADER
                            ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        if (mData == null) return 0;
        return mHeaderView == null ? mData.size() : mData.size() + 1;
    }

    protected abstract void convert(CMMViewHolder holder, T t, int position);


    /**
     * 加入数据
     */
    @Override
    public void addList(List<T> t) {
        if (mData == null) {
            mData = t;
            notifyDataSetChanged();
            return;
        }
        if (t != null && t.size() > 0) {
            mData.addAll(t);
            notifyDataSetChanged();
        }
    }

    /**
     * 加入数据position ALL
     */
    @Override
    public void addPositionList(int position, List<T> t) {
        if (t != null && t.size() > 0) {
            mData.addAll(position, t);
            notifyItemChanged(position);
        }
    }

    /**
     * 加入数据position ALL
     */
    @Override
    public void addAllList(List<T> t) {
        if (t != null && t.size() > 0) {
            mData.clear();
            mData.addAll(t);
            notifyDataSetChanged();
        }
    }

    /**
     * 加入数据data
     */
    @Override
    public void addData(T t) {
        if (t != null) {
            if (mData == null) {
                mData = new ArrayList<>();
            }
            mData.add(t);
            notifyDataSetChanged();
        }
    }


    /**
     * 加入数据position data
     */
    @Override
    public void addPositionDate(int position, T t) {
        if (t != null) {
            mData.add(position, t);
            notifyItemChanged(position);
        }
    }

    /**
     * remove 一个数据
     */
    @Override
    public void remove(T t, int position) {
        if (t != null) {
            mData.remove(t);
            notifyItemChanged(position);
        }
    }

    /**
     * remove 指定一个数据
     */
    @Override
    public void remove(int position) {
        mData.remove(position);
        notifyItemChanged(position);
    }


    /**
     * clear 所有
     */
    @Override
    public void clear() {
        if (mData != null) {
            mData.clear();
        }
    }

    @Override
    public List<T> getData() {
        return mData;
    }

    /**
     * 获取集合数据
     *
     * @param
     */


    public void setOnItemClickListener(OnItemClick onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * 添加头部
     */
    @Override
    public void addHeadView(View view) {
        mHeaderView = view;
        notifyItemChanged(0);
    }

    /**
     * 添加底部
     */
    @Override
    public void addFootView(View view) {
        mHeaderView = view;
        notifyItemChanged(mData.size() + 1);
    }

    public boolean isNoMoreData() {
        return noMoreData;
    }

    public void setNoMoreData(boolean noMoreData) {
        this.noMoreData = noMoreData;
    }
}


