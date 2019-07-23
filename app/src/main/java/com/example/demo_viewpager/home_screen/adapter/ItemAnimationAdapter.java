package com.example.demo_viewpager.home_screen.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demo_viewpager.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemAnimationAdapter extends RecyclerView.Adapter<ItemAnimationAdapter.ViewHolder> {
    List<String> mData;

    public ItemAnimationAdapter() {
        mData = new ArrayList();
    }

    public ItemAnimationAdapter(List<String> mData) {
        this.mData = mData;
    }

    public void addData(List<String> data) {
        mData.addAll(data);
        notifyItemInserted(mData.size() - 1);
        notifyDataSetChanged();
    }
    public void onMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mData, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mData, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }
    public void swipe(int position, int direction) {
        mData.remove(position);
        notifyItemRemoved(position);
    }
    @NonNull
    @Override
    public ItemAnimationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater mLayoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = mLayoutInflater.inflate(R.layout.item_animation_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAnimationAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bindData(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextTitle;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            mTextTitle = itemView.findViewById(R.id.text_title);
        }
        private void bindData(String data) {
            if (data == null) {
                return;
            }
            mTextTitle.setText(data);
        }
    }
}
