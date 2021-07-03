package com.elson.viewdemo.touch;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.elson.viewdemo.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class DrawerActivity extends AppCompatActivity {

    private static final String TAG = DrawerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        findViewById(R.id.menuLl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.LEFT);
                Toast.makeText(DrawerActivity.this, "menu 被点击了", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.contentLl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
                Toast.makeText(DrawerActivity.this, "Content 被点击了", Toast.LENGTH_SHORT).show();
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