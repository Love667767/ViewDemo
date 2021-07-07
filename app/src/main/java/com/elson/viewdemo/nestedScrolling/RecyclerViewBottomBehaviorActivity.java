package com.elson.viewdemo.nestedScrolling;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.elson.viewdemo.R;
import com.elson.viewdemo.recyclerView.adapter.PageAdapter;
import com.elson.viewdemo.recyclerView.data.PageData;
import com.elson.viewdemo.touch.TouchActivity;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewBottomBehaviorActivity extends AppCompatActivity {

    private static final String TAG = RecyclerViewBottomBehaviorActivity.class.getSimpleName();
    private int mHeight;
    private int mWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_recycler_bottom_behavior);

        RecyclerView cardRecyclerView2 = findViewById(R.id.recyclerView);
        cardRecyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ArrayList<PageData> pageData2 = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            pageData2.add(new PageData( "List ：" + i, TouchActivity.class));
        }
        PageAdapter pageAdapter2 = new PageAdapter(pageData2);
        cardRecyclerView2.setAdapter(pageAdapter2);
        pageAdapter2.notifyDataSetChanged();


        findViewById(R.id.bottomView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecyclerViewBottomBehaviorActivity.this, "Bottom被点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }


}