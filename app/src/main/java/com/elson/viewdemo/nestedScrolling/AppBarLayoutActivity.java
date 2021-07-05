package com.elson.viewdemo.nestedScrolling;

import android.os.Bundle;
import android.widget.ImageView;

import com.elson.viewdemo.ILog;
import com.elson.viewdemo.R;
import com.elson.viewdemo.nestedScrolling.fragment.TabFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class AppBarLayoutActivity extends AppCompatActivity {

    private static final String TAG = AppBarLayoutActivity.class.getSimpleName();
    private int mHeight;
    private int mWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbarlayout);

        final ImageView backgroundIv = findViewById(R.id.backgroundIv);
        AppBarLayout appBarLayout = findViewById(R.id.appbarLayout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                ILog.d(TAG, "i=" + verticalOffset);
                if (mHeight == 0) {
                    mHeight = backgroundIv.getHeight();
                    ILog.d(TAG, "Height=" + mHeight);
                }
                if (mWidth == 0) {
                    mWidth = backgroundIv.getWidth();
                    ILog.d(TAG, "Width=" + mWidth);
                }
                float percent = (float) ((mHeight + verticalOffset) * 1.0 / mHeight);
                ILog.d(TAG, "percent=" + percent);
                backgroundIv.setPivotX(mWidth / 2);
                backgroundIv.setPivotY(mHeight / 2);
                backgroundIv.setScaleX(percent);
                backgroundIv.setScaleY(percent);
            }
        });

        final String[] titles = {"Tab1", "Tab2"};
        final Fragment[] fragments = {TabFragment.newInstance(titles[0]), TabFragment.newInstance(titles[1])};
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