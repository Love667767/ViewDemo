package com.elson.viewdemo.recyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.elson.viewdemo.R;
import com.elson.viewdemo.recyclerView.itemdecoration.LinearItemDecoration;
import com.elson.viewdemo.touch.TouchActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDecorationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_item_decoration);


        ArrayList<PageData> pageData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            pageData.add(new PageData("Item" + i, TouchActivity.class));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PageAdapter pageAdapter = new PageAdapter(pageData);
        recyclerView.setAdapter(pageAdapter);
        recyclerView.addItemDecoration(new LinearItemDecoration());
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
            TextView textView = new TextView(ItemDecorationActivity.this);
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(20);
            textView.setBackgroundColor(Color.WHITE);

            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 50 * 3);
//            layoutParams.setMargins(0, 20, 0, 0);
            textView.setLayoutParams(layoutParams);
            return new SimpleViewHolder(textView);
        }

        @Override
        public void onBindViewHolder(@NonNull SimpleViewHolder holder, final int position) {
            holder.mTextView.setText(mPageData.get(position).title);
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

    class PageData {
        String title;
        Class clazz;

        public PageData(String title, Class clazz) {
            this.title = title;
            this.clazz = clazz;
        }
    }
}