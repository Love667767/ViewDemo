package com.elson.viewdemo.recyclerView.adapter;

import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.elson.viewdemo.recyclerView.data.PageData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author elson
 * @date 2021/7/4
 * @Desc
 */
public class PageAdapter extends RecyclerView.Adapter<PageAdapter.SimpleViewHolder> {

    private List<PageData> mPageData;

    public PageAdapter(List<PageData> pageData) {
        mPageData = pageData;
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = new TextView(parent.getContext());
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        textView.setBackgroundColor(Color.WHITE);

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 50 * 3);
//            layoutParams.setMargins(0, 20, 0, 0);
        textView.setLayoutParams(layoutParams);
        return new PageAdapter.SimpleViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull PageAdapter.SimpleViewHolder holder, final int position) {
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
