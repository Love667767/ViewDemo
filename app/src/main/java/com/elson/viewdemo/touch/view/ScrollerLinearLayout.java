package com.elson.viewdemo.touch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;

import com.elson.viewdemo.ILog;

import androidx.annotation.Nullable;

/**
 * @author elson
 * @date 2021/7/2
 * @Desc
 */
public class ScrollerLinearLayout extends LinearLayout {

    private static final String TAG = ScrollerLinearLayout.class.getSimpleName();
    private Scroller mScroller;

    public ScrollerLinearLayout(Context context) {
        super(context);
    }

    public ScrollerLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context, new LinearInterpolator());
    }

    public ScrollerLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ScrollerLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void startScroll(int startX, int dx) {
        mScroller.startScroll(startX, 0, dx, 0);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (!mScroller.isFinished() && mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
        }
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
                break;
            case MotionEvent.ACTION_CANCEL:
                ILog.d(TAG, "onIntercept ACTION_CANCEL");
                break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
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
        return super.onTouchEvent(ev);
    }
}
