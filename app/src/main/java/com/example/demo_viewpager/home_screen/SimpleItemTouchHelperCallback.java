package com.example.demo_viewpager.home_screen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.demo_viewpager.home_screen.interf.ItemTouchListenner;



public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback{
    private ItemTouchListenner mListenner;
    public SimpleItemTouchHelperCallback(ItemTouchListenner mListenner) {
        this.mListenner = mListenner;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return super.isItemViewSwipeEnabled();
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlag = ItemTouchHelper.UP|ItemTouchHelper.DOWN;
        int swipeFlag = ItemTouchHelper.LEFT| ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlag,swipeFlag);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        mListenner.onMove(viewHolder.getAdapterPosition(),viewHolder1.getAdapterPosition());
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        mListenner.swipe(viewHolder.getAdapterPosition(),i);
    }
}
