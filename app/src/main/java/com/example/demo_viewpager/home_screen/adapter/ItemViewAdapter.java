package com.example.demo_viewpager.home_screen.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo_viewpager.R;

import java.util.List;

public class ItemViewAdapter extends RecyclerView.Adapter<ItemViewAdapter.ViewHolder> {
    private List<String> mDatas;

    public ItemViewAdapter(List<String> mDatas) {
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public ItemViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater mLayoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = mLayoutInflater.inflate(R.layout.item_view,viewGroup,false);
        return new ItemViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewAdapter.ViewHolder viewHolder, int i) {
        String item = mDatas.get(i);
        viewHolder.tvItem.setText(item);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addItem(String item) {
        mDatas.add(item);
        // add item postion
        notifyItemInserted(mDatas.size() - 1);
    }
    public void removeItem(int position) {
        mDatas.remove(position);
        notifyDataSetChanged();
        notifyItemRemoved(position);
    }
    public void replaceItem(int postion, String item) {

        mDatas.remove(postion);
        mDatas.add(postion, item);
        notifyItemChanged(postion);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItem;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);context = itemView.getContext();
            tvItem = itemView.findViewById(R.id.text_item);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    removeItem(getAdapterPosition());
                    Toast.makeText(context, "Removed Animation", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    replaceItem(getAdapterPosition(), "The content has changed");
                    Toast.makeText(context, "Changed Animation", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
