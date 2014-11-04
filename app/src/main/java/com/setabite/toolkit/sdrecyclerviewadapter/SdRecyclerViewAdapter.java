package com.setabite.toolkit.sdrecyclerviewadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sangga on 11/3/2014.
 * <p/>
 * universal recycler view adapter
 */
public class SdRecyclerViewAdapter extends RecyclerView.Adapter<SdRecyclerViewAdapter.ViewHolder> {
    protected List<SdRecyclerViewItemInterface<? extends ViewHolder>> dataset = null;

    public SdRecyclerViewAdapter(List<SdRecyclerViewItemInterface<? extends ViewHolder>> dataset) {
        this.dataset = dataset;
    }

    public SdRecyclerViewAdapter() {
        this.dataset = new ArrayList<SdRecyclerViewItemInterface<? extends ViewHolder>>();
    }

    @Override
    public int getItemViewType(int position) {
        SdRecyclerViewItemInterface<? extends ViewHolder> item = dataset.get(position);
        return item.getTypeId();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        for (SdRecyclerViewItemInterface<? extends ViewHolder> item : dataset) {
            if (item.getTypeId() == i)
                return item.createViewHolder(viewGroup);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        SdRecyclerViewItemInterface<? extends ViewHolder> item = dataset.get(i);
        item.populateViewHolder(viewHolder);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void add(SdRecyclerViewItemInterface item) {
        if (dataset != null)
            dataset.add(item);
    }

    public void add(int index, SdRecyclerViewItemInterface item) {
        if (dataset != null)
            dataset.add(index, item);
    }

    public void remove(SdRecyclerViewItemInterface item) {
        if (dataset != null)
            dataset.remove(item);
    }

    public void remove(int index) {
        if (dataset != null)
            dataset.remove(index);
    }

    public void clear() {
        if (dataset != null)
            dataset.clear();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
