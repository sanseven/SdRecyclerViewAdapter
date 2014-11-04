package com.setabite.toolkit.sdrecyclerviewadapter;

import android.view.ViewGroup;

/**
 * Created by Sangga on 11/3/2014.
 *
 * implements from this interface for item used in SdRecyclerViewAdapter
 */
public interface SdRecyclerViewItemInterface<T extends SdRecyclerViewAdapter.ViewHolder> {
    int getTypeId();
    T createViewHolder(ViewGroup parent);
    void populateViewHolder(SdRecyclerViewAdapter.ViewHolder holder);
}
