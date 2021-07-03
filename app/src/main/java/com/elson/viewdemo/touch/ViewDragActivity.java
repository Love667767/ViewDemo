package com.elson.viewdemo.touch;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.elson.viewdemo.R;

import androidx.appcompat.app.AppCompatActivity;

public class ViewDragActivity extends AppCompatActivity {

    private static final String TAG = ViewDragActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_drag);

        final TextView textView1 = findViewById(R.id.textView1);
        final TextView textView2 = findViewById(R.id.textView2);
        final TextView textView3 = findViewById(R.id.textView3);

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewDragActivity.this, "TextView3", Toast.LENGTH_SHORT).show();
            }
        });
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