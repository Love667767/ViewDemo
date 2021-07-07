package com.elson.viewdemo.nestedScrolling;

import android.os.Bundle;
import android.util.Log;

import com.elson.viewdemo.R;
import com.elson.viewdemo.nestedScrolling.fragment.TabFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class StickyLayoutActivity extends AppCompatActivity {

    private static final String TAG = StickyLayoutActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_sticky);

        Log.d(TAG, "height=" + getResources().getDisplayMetrics().heightPixels);

        final String[] titles = {"Tab1", "Tab2"};
        final Fragment[] fragments = {
                TabFragment.newInstance(titles[0]),
                TabFragment.newInstance(titles[1])
        };

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        ViewPager viewPager = findViewById(R.id.viewPager);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @Override
            public int getCount() {
                return titles.length;
            }

            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }


            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });

    }


}