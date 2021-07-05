package com.elson.viewdemo.nestedScrolling.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;

/**
 * @author elson
 * @date 2021/7/5
 * @Desc
 */
public class StickyNavLayout2 extends LinearLayout implements NestedScrollingParent3 {


    private static final String TAG = "StickyNavLayout2";

    private NestedScrollingParentHelper mParentHelper = new NestedScrollingParentHelper(this);

    private int mTopViewHeight;

    public StickyNavLayout2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StickyNavLayout2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(LinearLayout.VERTICAL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getChildCount() > 0) {
            View child = getChildAt(0);
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
            mTopViewHeight = child.getMeasuredHeight();
            super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec) + mTopViewHeight - 50, MeasureSpec.EXACTLY));
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e(TAG, "onSizeChanged getMeasuredHeight()=" + getMeasuredHeight());
    }

    @Override
    public void scrollTo(int x, int y) {
        int validY = MathUtils.clamp(y, 0, mTopViewHeight);
        super.scrollTo(x, validY);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                Log.e(TAG, "onInterceptTouchEvent ACTION_DOWN");
                Log.e(TAG, "onInterceptTouchEvent mTopViewHeight=" + mTopViewHeight);
                Log.e(TAG, "onInterceptTouchEvent getMeasuredHeight()=" + getMeasuredHeight());
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                Log.e(TAG, "onInterceptTouchEvent ACTION_MOVE");
                break;
            }
            case MotionEvent.ACTION_UP: {
                Log.e(TAG, "onInterceptTouchEvent ACTION_UP");
                break;
            }
            case MotionEvent.ACTION_CANCEL: {
                Log.e(TAG, "onInterceptTouchEvent ACTION_CANCEL");
                break;
            }
            default:
                break;
        }
        return super.onInterceptTouchEvent(event);
    }


    // ---------------------------------------

    // Parent3

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type,@Nullable int[] consumed) {
        Log.e(TAG, "Parent3 onNestedScroll");
        // 下滑
        if (dyUnconsumed < 0) {
            int oldScrollY = getScrollY();
            scrollBy(0, dyUnconsumed);

            if (consumed != null) {
                int myConsumed = getScrollY() - oldScrollY;
                consumed[1] += myConsumed;
            }
        }
    }

    // Parent2

    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int axes, int type) {
        Log.e(TAG, "Parent2 onStartNestedScroll");
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedScrollAccepted(@NonNull View child, @NonNull View target, int axes, int type) {
        Log.e(TAG, "Parent2 onNestedScrollAccepted");
        mParentHelper.onNestedScrollAccepted(child, target, axes);
    }

    @Override
    public void onStopNestedScroll(@NonNull View target, int type) {
        Log.e(TAG, "Parent2 onStopNestedScroll");
        mParentHelper.onStopNestedScroll(target);
    }

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Log.e(TAG, "Parent2 onNestedScroll");
    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        Log.e(TAG, "Parent2 onNestedPreScroll");
        // 向上滑动
        if (dy > 0) {
            int oldScrollY = getScrollY();
            scrollBy(0, dy);
            consumed[1] = getScrollY() - oldScrollY;
        }
    }


    // ViewGroup

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        Log.e(TAG, "Parent onStartNestedScroll");
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
        Log.e(TAG, "Parent onNestedScrollAccepted");
        mParentHelper.onNestedScrollAccepted(child, target, nestedScrollAxes);
    }

    @Override
    public void onStopNestedScroll(View target) {
        Log.e(TAG, "Parent onStopNestedScroll");
        mParentHelper.onStopNestedScroll(target);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        Log.e(TAG, "Parent onNestedPreScroll");
        // 向上滑动
        if (dy > 0) {
            int oldScrollY = getScrollY();
            scrollBy(0, dy);
            consumed[1] = getScrollY() - oldScrollY;
        }
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.e(TAG, "Parent onNestedScroll dyUnconsumed=" + dyUnconsumed);
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        Log.e(TAG, "Parent onNestedPreFling");
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        Log.e(TAG, "Parent onNestedFling");
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override
    public int getNestedScrollAxes() {
        Log.e(TAG, "Parent getNestedScrollAxes");
        return mParentHelper.getNestedScrollAxes();
    }

}
