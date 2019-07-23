package com.example.demo_viewpager.home_screen.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.demo_viewpager.home_screen.fragment.ItemViewFragment;
import com.example.demo_viewpager.home_screen.fragment.ItemAnimationFragment;

public class HomeViewPagerAdapter extends FragmentPagerAdapter {
    private final int PAGE_NUMBER = 2;

    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0 : return  new ItemViewFragment();
            case 1: return new ItemAnimationFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return PAGE_NUMBER;
    }
}
