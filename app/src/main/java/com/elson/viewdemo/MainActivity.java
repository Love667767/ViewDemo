package com.elson.viewdemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.elson.viewdemo.nestedScrolling.AppBarLayoutActivity;
import com.elson.viewdemo.nestedScrolling.RecyclerViewBottomBehaviorActivity;
import com.elson.viewdemo.nestedScrolling.StickyLayoutActivity;
import com.elson.viewdemo.nestedScrolling.SuspendedLayoutActivity;
import com.elson.viewdemo.recyclerView.ItemDecorationActivity;
import com.elson.viewdemo.touch.DrawerActivity;
import com.elson.viewdemo.touch.ScrollerActivity;
import com.elson.viewdemo.touch.SlideActivity;
import com.elson.viewdemo.touch.TouchActivity;
import com.elson.viewdemo.touch.ViewDragActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<PageData> pageData = new ArrayList<>();
        pageData.add(new PageData("Touch", TouchActivity.class));
        pageData.add(new PageData("Scroller", ScrollerActivity.class));
        pageData.add(new PageData("ViewDrag", ViewDragActivity.class));
        pageData.add(new PageData("SlideMenu", SlideActivity.class));
        pageData.add(new PageData("DrawerLayout", DrawerActivity.class));
        pageData.add(new PageData("Recycler ItemDecoration", ItemDecorationActivity.class));
        pageData.add(new PageData("Nested AppBarLayout", AppBarLayoutActivity.class));
        pageData.add(new PageData("Nested SuspendedLayout", SuspendedLayoutActivity.class));
        pageData.add(new PageData("Nested Sticky", StickyLayoutActivity.class));
        pageData.add(new PageData("Nested BottomBehavior", RecyclerViewBottomBehaviorActivity.class));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PageAdapter pageAdapter = new PageAdapter(pageData);
        recyclerView.setAdapter(pageAdapter);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        pageAdapter.notifyDataSetChanged();
    }

    class PageAdapter extends RecyclerView.Adapter<PageAdapter.SimpleViewHolder> {

        private List<PageData> mPageData;

        public PageAdapter(List<PageData> pageData) {
            mPageData = pageData;
        }

        @NonNull
        @Override
        public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            TextView textView = new TextView(MainActivity.this);
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(20);
            textView.setBackgroundColor(Color.WHITE);

            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 50 * 3);
            layoutParams.setMargins(0, 20, 0, 0);
            textView.setLayoutParams(layoutParams);
            return new SimpleViewHolder(textView);
        }

        @Override
        public void onBindViewHolder(@NonNull SimpleViewHolder holder, final int position) {
            holder.mTextView.setText(mPageData.get(position).title);
            holder.mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(mPageData.get(position).clazz);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mPageData.size();
        }

        class SimpleViewHolder extends RecyclerView.ViewHolder {

            public TextView mTextView;

            public SimpleViewHolder(TextView textView) {
                super(textView);
                mTextView = textView;
            }
        }
    }

    private void startActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    class PageData {
        String title;
        Class clazz;

        public PageData(String title, Class clazz) {
            this.title = title;
            this.clazz = clazz;
        }
    }
}