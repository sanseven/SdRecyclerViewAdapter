package com.setabite.toolkit.sdrecyclerviewadapter;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

/**
 * Created by Sangga on 11/4/2014.
 */
public abstract class SdRecyclerViewItemSimple implements SdRecyclerViewItemInterface<SdRecyclerViewItemSimple.ViewHolder> {

    private int mTypeId = new Random().nextInt(((int) (System.currentTimeMillis()) <= 0) ? 1 : (int) (System.currentTimeMillis()));

    @Override
    public int getTypeId() {
        return mTypeId;
    }

    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(getViewId(), parent, false);
        ViewHolder holder = new ViewHolder(v);
        onPrepareViewHolder(holder);
        return holder;
    }

    @Override
    public void populateViewHolder(SdRecyclerViewAdapter.ViewHolder holder) {
        onPopulateViewHolder((ViewHolder) holder);
    }

    protected abstract int getViewId();

    protected abstract void onPrepareViewHolder(ViewHolder holder);

    protected abstract void onPopulateViewHolder(ViewHolder holder);

    public static class ViewHolder extends SdRecyclerViewAdapter.ViewHolder {

        SparseArray<View> views = new SparseArray<View>();
        private View mItemView;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
        }

        public View findView(int id) {
            return views.get(id);
        }

        public void addView(int id) {
            View v = mItemView.findViewById(id);
            views.put(v.getId(), v);
        }
    }
}
