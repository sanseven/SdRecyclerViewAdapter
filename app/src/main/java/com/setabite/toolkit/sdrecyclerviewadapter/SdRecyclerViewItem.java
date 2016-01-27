package com.setabite.toolkit.sdrecyclerviewadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Sangga on 11/4/2014.
 * <p/>
 * extends from this class for item used in SdRecyclerViewAdapter
 */
public abstract class SdRecyclerViewItem<T extends SdRecyclerViewAdapter.ViewHolder> implements SdRecyclerViewItemInterface<T> {

    @Override
    public int getTypeId() {
        return this.getClass().hashCode();
    }

    @Override
    public T createViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(getViewId(), parent, false);

        try {
            String className = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0].toString().split("\\s")[1];
            return (T)Class.forName(className).getConstructor(this.getClass(), View.class).newInstance(this, v);
        } catch (Exception e) {
            throw new RuntimeException("please create a viewholder accepting view as arg");
        }
    }

    @Override
    public void populateViewHolder(SdRecyclerViewAdapter.ViewHolder holder) {
        onPopulateViewHolder((T) holder);
    }

    protected abstract int getViewId();

    protected abstract void onPopulateViewHolder(T holder);
}