package com.elson.viewdemo.nestedScrolling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elson.viewdemo.recyclerView.adapter.PageAdapter;
import com.elson.viewdemo.recyclerView.data.PageData;
import com.elson.viewdemo.touch.TouchActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author elson
 * @date 2021/7/4
 * @Desc
 */
public class TabFragment extends Fragment {

    private String tab;

    public static TabFragment newInstance(String tab) {
        TabFragment tabFragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Tab", tab);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tab = getArguments().getString("Tab");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRecyclerView = new RecyclerView(getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return mRecyclerView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<PageData> pageData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            pageData.add(new PageData(tab + "：" + i, TouchActivity.class));
        }
        PageAdapter pageAdapter = new PageAdapter(pageData);
        mRecyclerView.setAdapter(pageAdapter);
        pageAdapter.notifyDataSetChanged();
    }
}
