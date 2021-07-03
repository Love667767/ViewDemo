package com.elson.viewdemo.touch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

/**
 * @author elson
 * @date 2021/7/3
 * @Desc
 */
public class SlideMenuLayout extends FrameLayout {

    private View mMainView;
    private View mMenuView;
    private int mMenuViewWidth = 400;
    private ViewDragHelper mDragHelper;

    public SlideMenuLayout(@NonNull Context context) {
        super(context);
    }

    public SlideMenuLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initView();
    }

    public SlideMenuLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView() {
        if (mDragHelper != null) {
            return;
        }
        mDragHelper = ViewDragHelper.create(this, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(@NonNull View child, int pointerId) {
                return child == mMainView;
            }

            @Override
            public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
                if (left > 0) {
                    return Math.min(left, mMenuViewWidth);
                }
                return 0;
            }

            @Override
            public int getViewVerticalDragRange(@NonNull View child) {
                return 1;
            }

            @Override
            public int getViewHorizontalDragRange(@NonNull View child) {
                return 1;
            }

            @Override
            public void onViewPositionChanged(@NonNull View changedView, int left, int top, int dx, int dy) {
                super.onViewPositionChanged(changedView, left, top, dx, dy);

                float percent = mMainView.getLeft() / (float) mMenuViewWidth;
                mMainView.setScaleX(1 - percent * 0.1f);
                mMainView.setScaleY(1 - percent * 0.1f);

                mMenuView.setScaleX(0.5f + percent * 0.5f);
                mMenuView.setScaleY(0.5f + percent * 0.5f);
                mMenuView.setTranslationX(-mMenuViewWidth/ 2 + mMenuViewWidth / 2 * percent);
            }

            @Override
            public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
                super.onViewReleased(releasedChild, xvel, yvel);
                if (mMainView.getLeft() < mMenuViewWidth / 2) {
                    mDragHelper.smoothSlideViewTo(mMainView, 0, 0);
                } else {
                    mDragHelper.smoothSlideViewTo(mMainView, mMenuViewWidth, 0);
                }
                invalidate();
            }
        });
    }

    public void setView(View mainView, LayoutParams mainLayoutParams, View menuView, LayoutParams menuLayoutParams) {
        this.mMenuView = menuView;
        this.mMenuViewWidth = menuLayoutParams.width;
        addView(menuView);

        this.mMainView = mainView;
        addView(mainView, mainLayoutParams);
    }

    public void closeMenu() {
        mDragHelper.smoothSlideViewTo(mMainView, 0, 0);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mDragHelper.continueSettling(true)) {
            invalidate();
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        return true;
    }
}
