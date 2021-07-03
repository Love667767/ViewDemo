package com.elson.viewdemo.touch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.elson.viewdemo.ILog;

import androidx.annotation.Nullable;

/**
 * @author elson
 * @date 2021/7/2
 * @Desc
 */
public class CustomTextView extends androidx.appcompat.widget.AppCompatTextView {

    private static final String TAG = CustomTextView.class.getSimpleName();

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ILog.d(TAG, "onTouch");
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ILog.d(TAG, "onTouch ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        ILog.d(TAG, "onTouch ACTION_UP");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        ILog.d(TAG, "onTouch ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        ILog.d(TAG, "onTouch ACTION_CANCEL");
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    public boolean onTouchEvent(MotionEvent ev) {
        ILog.d(TAG, "onTouchEvent");
        switch (ev.getAction()) {
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
        return true;
//        return super.onTouchEvent(ev);
    }
}
