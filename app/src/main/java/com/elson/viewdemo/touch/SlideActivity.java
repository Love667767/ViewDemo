package com.elson.viewdemo.touch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.elson.viewdemo.R;
import com.elson.viewdemo.touch.view.SlideMenuLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SlideActivity extends AppCompatActivity {

    private static final String TAG = SlideActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);



        final SlideMenuLayout menuLayout = findViewById(R.id.slideLayout);
        View menuView = LayoutInflater.from(this).inflate(R.layout.view_slide_menu, menuLayout, false);
        menuView.findViewById(R.id.textView1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SlideActivity.this, "textView1", Toast.LENGTH_SHORT).show();
            }
        });
        menuView.findViewById(R.id.textView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SlideActivity.this, "textView2", Toast.LENGTH_SHORT).show();
            }
        });

        View mainView = LayoutInflater.from(this).inflate(R.layout.view_slide_main, menuLayout, false);
        mainView.findViewById(R.id.mainView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SlideActivity.this, "mainView", Toast.LENGTH_SHORT).show();
                menuLayout.closeMenu();
            }
        });

        menuLayout.setView(mainView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT),
                menuView, new FrameLayout.LayoutParams(300, FrameLayout.LayoutParams.WRAP_CONTENT));
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        ILog.d(TAG, "dispatchTouchEvent");
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                ILog.d(TAG, "dispatch ACTION_DOWN");
//                break;
//            case MotionEvent.ACTION_UP:
//                ILog.d(TAG, "dispatch ACTION_UP");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                ILog.d(TAG, "dispatch ACTION_MOVE");
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                ILog.d(TAG, "dispatch ACTION_CANCEL");
//                break;
//            default:
//                break;
//        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        ILog.d(TAG, "onTouchEvent");
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                ILog.d(TAG, "Touch ACTION_DOWN");
//                break;
//            case MotionEvent.ACTION_UP:
//                ILog.d(TAG, "Touch ACTION_UP");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                ILog.d(TAG, "Touch ACTION_MOVE");
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                ILog.d(TAG, "Touch ACTION_CANCEL");
//                break;
//            default:
//                break;
//        }
        return super.onTouchEvent(event);
    }
}