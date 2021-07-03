package com.elson.viewdemo.touch;

import android.os.Bundle;
import android.view.View;

import com.elson.viewdemo.R;
import com.elson.viewdemo.touch.view.ScrollerLinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ScrollerActivity extends AppCompatActivity {

    private static final String TAG = ScrollerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller);

        final ScrollerLinearLayout scrollerView = findViewById(R.id.scrollToLl);
        findViewById(R.id.scrollToTv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollerView.startScroll(0, (int) (100*getResources().getDisplayMetrics().density));
            }
        });

        findViewById(R.id.resetScrollToTv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollerView.startScroll((int) (100*getResources().getDisplayMetrics().density), (int) (-100*getResources().getDisplayMetrics().density));
            }
        });

    }
}