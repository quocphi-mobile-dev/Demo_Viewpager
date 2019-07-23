package com.example.demo_viewpager.home_screen.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.demo_viewpager.R;
import com.example.demo_viewpager.home_screen.adapter.ItemViewAdapter;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;


public class ItemViewFragment extends Fragment {
    private Button mButtonAddItem ;
    private RecyclerView mRecyclerViewItem;
    private  ItemViewAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_view, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        addListener();
    }

    private void addListener() {
        mButtonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.addItem("New Item !!!!!!");
                mRecyclerViewItem.scrollToPosition(mAdapter.getItemCount() - 1);
            }
        });
    }


    private void init(View view) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            data.add("Old Item  " + i);
        }
        mButtonAddItem = view.findViewById(R.id.button_add_item);
        mRecyclerViewItem = view.findViewById(R.id.rv_items);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        mAdapter = new ItemViewAdapter(data);

        mRecyclerViewItem.setAdapter(new ScaleInAnimationAdapter(mAdapter));
        //set ItemAnimator for RecyclerView
        mRecyclerViewItem.setItemAnimator(new SlideInUpAnimator());
        mRecyclerViewItem.setLayoutManager(gridLayoutManager);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerViewItem);
    }


}
