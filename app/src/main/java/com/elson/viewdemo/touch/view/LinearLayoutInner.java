package com.elson.viewdemo.touch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.elson.viewdemo.ILog;

import androidx.annotation.Nullable;

/**
 * @author elson
 * @date 2021/7/2
 * @Desc
 */
public class LinearLayoutInner extends LinearLayout {

    private static final String TAG = LinearLayoutInner.class.getSimpleName();

    public LinearLayoutInner(Context context) {
        super(context);
    }

    public LinearLayoutInner(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearLayoutInner(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LinearLayoutInner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
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
//        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        ILog.d(TAG, "onInterceptTouchEvent");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ILog.d(TAG, "onIntercept ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                ILog.d(TAG, "onIntercept ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                ILog.d(TAG, "onIntercept ACTION_MOVE");
                return true;
//                break;
            case MotionEvent.ACTION_CANCEL:
                ILog.d(TAG, "onIntercept ACTION_CANCEL");
                break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
//        return true;
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
                return true;
//                break;
            case MotionEvent.ACTION_CANCEL:
                ILog.d(TAG, "Touch ACTION_CANCEL");
                break;
            default:
                break;
        }
        return super.onTouchEvent(ev);
//        return true;
    }
}
