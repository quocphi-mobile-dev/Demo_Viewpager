package com.example.demo_viewpager.home_screen;

import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.demo_viewpager.R;
import com.example.demo_viewpager.home_screen.adapter.HomeViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    HomeViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        viewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.news_feeds);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_folder_shared);
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager){
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                super.onTabReselected(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                super.onTabUnselected(tab);
                tab.getIcon().setColorFilter(getResources().getColor(R.color.color_black), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                tab.getIcon().setColorFilter(getResources().getColor(R.color.color_cornflower_blue), PorterDuff.Mode.SRC_IN);
            }
        });

    }
}
