package com.elson.viewdemo.nestedScrolling.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.google.android.material.appbar.AppBarLayout;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/**
 * @author elson
 * @date 2021/7/7
 * @Desc
 */
public class BottomBehavior extends CoordinatorLayout.Behavior<View> {

    private static final String TAG = BottomBehavior.class.getSimpleName();

    private int mBottomHeight = 0;

    public BottomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onLayoutChild(@NonNull CoordinatorLayout parent, @NonNull View child, int layoutDirection) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        if (layoutParams != null && layoutParams.height != 0) {
            mBottomHeight = layoutParams.height;
            child.layout(0, parent.getHeight(), parent.getWidth(), parent.getHeight() + mBottomHeight);
            return true;
        }
        return super.onLayoutChild(parent, child, layoutDirection);
    }


    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        //计算出AppBarLayout移动的距离
        int top = dependency.getTop();
        Log.e(TAG, "AppBarLayout移动的距离" + top);
        if (Math.abs(dependency.getTranslationY()) < mBottomHeight) {
            int transY = Math.abs(top) > mBottomHeight ? -mBottomHeight : top;
            child.setTranslationY(transY);
            return true;
        }
        return super.onDependentViewChanged(parent, child, dependency);
    }

}
