package com.cangmaomao.recyclerview.adapter.contract;

import java.util.List;

public interface AdapterContract<T> {

    /**
     * 加入数据
     */
    void addList(List<T> t);

    /**
     * 加入数据position ALL
     */
    void addPositionList(int position, List<T> t);

    /**
     * 加入数据position ALL
     */
    void addAllList(List<T> t);

    /**
     * 加入数据data
     */
    void addData(T t);


    /**
     * 加入数据position data
     */
    void addPositionDate(int position, T t);

    /**
     * remove 一个数据
     */
    void remove(T t, int position);

    /**
     * remove 指定一个数据
     */
    void remove(int position);

    /**
     * clear 所有
     */
    void clear();

    /**
     * 获取集合数据
     */
    Object getData();


    void set(List<T> t);

}
