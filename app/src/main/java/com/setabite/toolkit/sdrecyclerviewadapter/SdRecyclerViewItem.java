package com.setabite.toolkit.sdrecyclerviewadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sangga on 11/4/2014.
 * <p/>
 * extends from this class for item used in SdRecyclerViewAdapter
 */
public abstract class SdRecyclerViewItem<T extends SdRecyclerViewAdapter.ViewHolder> implements SdRecyclerViewItemInterface<T> {

//    private int mTypeId = new Random().nextInt((int) (System.currentTimeMillis()));

    @Override
    public int getTypeId() {
        return this.getClass().hashCode();
    }

    @Override
    public T createViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(getViewId(), parent, false);
        return onCreateViewHolder(v);
    }

    @Override
    public void populateViewHolder(SdRecyclerViewAdapter.ViewHolder holder) {
        onPopulateViewHolder((T) holder);
    }

    protected abstract int getViewId();

    protected abstract T onCreateViewHolder(View view);

    protected abstract void onPopulateViewHolder(T holder);
}