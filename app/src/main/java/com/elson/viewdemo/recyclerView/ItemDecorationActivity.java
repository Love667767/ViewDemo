package com.elson.viewdemo.recyclerView;

import android.os.Bundle;

import com.elson.viewdemo.R;
import com.elson.viewdemo.recyclerView.adapter.PageAdapter;
import com.elson.viewdemo.recyclerView.data.PageData;
import com.elson.viewdemo.recyclerView.itemdecoration.LinearItemDecoration;
import com.elson.viewdemo.touch.TouchActivity;

import java.util.ArrayList;

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

}