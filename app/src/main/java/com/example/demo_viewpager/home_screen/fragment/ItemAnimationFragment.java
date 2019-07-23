package com.example.demo_viewpager.home_screen.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo_viewpager.R;
import com.example.demo_viewpager.home_screen.SimpleItemTouchHelperCallback;
import com.example.demo_viewpager.home_screen.adapter.ItemAnimationAdapter;
import com.example.demo_viewpager.home_screen.adapter.ItemViewAdapter;
import com.example.demo_viewpager.home_screen.interf.ItemTouchListenner;

import java.util.ArrayList;
import java.util.List;

public class ItemAnimationFragment extends Fragment {
    private ItemAnimationAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_animation, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        mAdapter = new ItemAnimationAdapter(getData());
        mRecyclerView = view.findViewById(R.id.rv_items);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        addItemTouchCallback(mRecyclerView);
    }

    private void addItemTouchCallback(RecyclerView recyclerView) {
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(new ItemTouchListenner() {
            @Override
            public void onMove(int oldPosition, int newPosition) {
                mAdapter.onMove(oldPosition, newPosition);
            }

            @Override
            public void swipe(int position, int direction) {
                mAdapter.swipe(position, direction);
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private List getData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("Never Give Up " + i);
        }
        return data;
    }
}
