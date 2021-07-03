package com.elson.viewdemo.touch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.elson.viewdemo.ILog;
import com.elson.viewdemo.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.widget.ViewDragHelper;

/**
 * @author elson
 * @date 2021/7/2
 * @Desc
 */
public class ViewDragLinearLayout extends LinearLayout {

    private static final String TAG = ViewDragLinearLayout.class.getSimpleName();
    private ViewDragHelper mViewDragHelper;

    public ViewDragLinearLayout(Context context) {
        super(context);
    }

    public ViewDragLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ViewDragLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mViewDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(@NonNull View child, int pointerId) {
                ILog.d(TAG, "tryCaptureView");
//                return true;
                return child.getId() == R.id.textView1 || child.getId() == R.id.textView2;
            }

            @Override
            public void onViewCaptured(@NonNull View capturedChild, int activePointerId) {
                ILog.d(TAG, "onViewCaptured capturedChild=" + capturedChild);
                super.onViewCaptured(capturedChild, activePointerId);
            }

            @Override
            public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
                return left;
            }

            @Override
            public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
                return top;
            }

            @Override
            public int getViewHorizontalDragRange(@NonNull View child) {
                return 1;
            }

            @Override
            public int getViewVerticalDragRange(@NonNull View child) {
                return 1;
            }

            @Override
            public void onEdgeTouched(int edgeFlags, int pointerId) {
                super.onEdgeTouched(edgeFlags, pointerId);
                ILog.d(TAG, "onEdgeTouched  edgeFlags=" + edgeFlags + " .........");
            }

            @Override
            public void onEdgeDragStarted(int edgeFlags, int pointerId) {
                super.onEdgeDragStarted(edgeFlags, pointerId);
                ILog.d(TAG, "onEdgeDragStarted  edgeFlags=" + edgeFlags + " .........");
                mViewDragHelper.captureChildView(findViewById(R.id.textView3), pointerId);
            }

            @Override
            public boolean onEdgeLock(int edgeFlags) {
                return super.onEdgeLock(edgeFlags);
//                return true;
            }

            @Override
            public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
                super.onViewReleased(releasedChild, xvel, yvel);
                ILog.d(TAG, "onViewReleased");
                if (releasedChild.getId() == R.id.textView2) {
                    View view = findViewById(R.id.textView1);
                    ILog.d(TAG, "onViewReleased smoothSlideViewTo view.top= " + view.getTop());

                    mViewDragHelper.smoothSlideViewTo(releasedChild, view.getLeft(), view.getTop());
//                    mViewDragHelper.settleCapturedViewAt(view.getLeft(), view.getTop());
                    invalidate();
                }
            }
        });
        mViewDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_ALL);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        ILog.d(TAG, "computeScroll");
        if (mViewDragHelper.continueSettling(true)) {
            invalidate();
        }
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
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        ILog.d(TAG, "onInterceptTouchEvent");
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                ILog.d(TAG, "onIntercept ACTION_DOWN");
//                break;
//            case MotionEvent.ACTION_UP:
//                ILog.d(TAG, "onIntercept ACTION_UP");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                ILog.d(TAG, "onIntercept ACTION_MOVE");
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                ILog.d(TAG, "onIntercept ACTION_CANCEL");
//                break;
//            default:
//                break;
//        }
//        return super.onInterceptTouchEvent(ev);
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
//        ILog.d(TAG, "onTouchEvent");
//        switch (ev.getAction()) {
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
//        return super.onTouchEvent(ev);
        mViewDragHelper.processTouchEvent(ev);
        return true;
    }
}
