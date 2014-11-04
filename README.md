SdRecyclerViewAdapter
=====================

wrapper class for RecyclerView Adapter

we dont have to create a new adapter each time, instead create an item with/without viewholder.

<b>MainAcitvity.java</b>
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
    protected ViewHolder onCreateViewHolder(View view) {
        return new ViewHolder(view, (TextView)view.findViewById(R.id.textview));
    }
  
    @Override
    protected void onPopulateViewHolder(ViewHolder holder) {
        holder.mTextView.setText(mText);
    }
  
    public class ViewHolder extends SdRecyclerViewAdapter.ViewHolder {
        public TextView mTextView;
        public ViewHolder(View itemView, TextView textView) {
            super(itemView);
            this.mTextView = textView;
        }
    }
}
```
