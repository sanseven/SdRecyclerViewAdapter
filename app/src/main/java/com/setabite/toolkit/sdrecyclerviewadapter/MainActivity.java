package com.setabite.toolkit.sdrecyclerviewadapter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SdRecyclerViewAdapter adapter = new SdRecyclerViewAdapter();

        for (int i = 0; i < 100; i++) {
            adapter.add(new ItemA());
        }
        for (int i = 0; i < 100; i++) {
            adapter.add(new ItemB());
        }
        for (int i = 0; i < 100; i++) {
            adapter.add(new ItemC());
        }

        recyclerView.setAdapter(adapter);
    }

    public static class ItemA extends SdRecyclerViewItem<ItemA.ViewHolder>{

        private String mText = "Item A";

        @Override
        protected int getViewId() {
            return R.layout.item_a;
        }

//        @Override
//        protected ViewHolder onCreateViewHolder(View view) {
//            return new ViewHolder(view, (TextView)view.findViewById(R.id.textview));
//        }

        @Override
        protected void onPopulateViewHolder(ViewHolder holder) {
            holder.mTextView.setText(mText);
        }

        public class ViewHolder extends SdRecyclerViewAdapter.ViewHolder {
            public TextView mTextView;
            public ViewHolder(View itemView) {
                super(itemView);
                this.mTextView = (TextView)itemView.findViewById(R.id.textview);
            }
        }
    }

    public static class ItemB implements SdRecyclerViewItemInterface<ItemB.ViewHolder> {

        private String mText = "Item B";

        @Override
        public int getTypeId() {
            return R.layout.item_b;
        }

        @Override
        public ViewHolder createViewHolder(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_b, parent, false);

            return new ViewHolder(view);
        }

        @Override
        public void populateViewHolder(SdRecyclerViewAdapter.ViewHolder holder) {
            ((ViewHolder)holder).mTextView.setText(mText);
        }


        public class ViewHolder extends SdRecyclerViewAdapter.ViewHolder {
            public TextView mTextView;
            public ViewHolder(View itemView) {
                super(itemView);
                this.mTextView = (TextView)itemView.findViewById(R.id.textview);
            }
        }
    }

    public static class ItemC extends SdRecyclerViewItemSimple{

        private String mText = "Item C";


        @Override
        protected int getViewId() {
            return R.layout.item_c;
        }

        @Override
        protected void onPrepareViewHolder(ViewHolder holder) {
            holder.addView(R.id.textview);
        }

        @Override
        protected void onPopulateViewHolder(ViewHolder holder) {
            ((TextView)holder.findView(R.id.textview)).setText(mText);
        }
    }
}
