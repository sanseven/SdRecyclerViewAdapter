SdRecyclerViewAdapter
=====================

wrapper class for RecyclerView Adapter

we dont have to create a new type of adapter each time, instead use SdRecyclerViewAdapter and create a new item type with/without viewholder.

<b>MainActivity.java</b>
```java
SdRecyclerViewAdapter adapter = new SdRecyclerViewAdapter();

adapter.add(new ItemA());
adapter.add(new ItemB());

recyclerView.setAdapter(adapter);
```

<b>ItemA.java</b>
```java
public static class ItemA extends SdRecyclerViewItem<ItemA.ViewHolder>{

    private String mText = "Item A";
  
    @Override
    protected int getViewId() {
        return R.layout.item_a;
    }

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
```
