package com.elson.viewdemo.touch;

import android.os.Bundle;
import android.view.MotionEvent;

import com.elson.viewdemo.ILog;
import com.elson.viewdemo.R;

import androidx.appcompat.app.AppCompatActivity;

public class TouchActivity extends AppCompatActivity {

    private static final String TAG = TouchActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

//        findViewById(R.id.touchTv).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(TouchActivity.this, "点击按钮", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        ILog.d(TAG, "dispatchTouchEvent");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ILog.d(TAG, "dispatch ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                ILog.d(TAG, "dispatch ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                ILog.d(TAG, "dispatch ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                ILog.d(TAG, "dispatch ACTION_CANCEL");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ILog.d(TAG, "onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ILog.d(TAG, "Touch ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                ILog.d(TAG, "Touch ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                ILog.d(TAG, "Touch ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                ILog.d(TAG, "Touch ACTION_CANCEL");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}