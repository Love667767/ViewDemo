package com.elson.viewdemo.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.elson.viewdemo.ILog;

/**
 * @author elson
 * @date 2021/7/10
 * @Desc
 */
public class CustomLinearLayout extends ViewGroup {


    private static final String TAG = CustomLinearLayout.class.getSimpleName();

    private Path mPath = new Path();

    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 测量子控件
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int maxWidth = 0;
        int height = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            int measuredWidth = child.getMeasuredWidth();
            if (measuredWidth > maxWidth) {
                maxWidth = measuredWidth;
            }
            int measuredHeight = child.getMeasuredHeight();
            height += measuredHeight;
        }

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(maxWidth, height);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(maxWidth, heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, height);
        } else {
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int top = 0;
        int maxWidth = getMeasuredWidth();
        ILog.d(TAG, "maxWidth=" + maxWidth);
        int left = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            int childMeasuredWidth = child.getMeasuredWidth();
            int childMeasuredHeight = child.getMeasuredHeight();
            if (maxWidth > childMeasuredWidth) {
                ILog.d(TAG, "maxWidth > childMeasuredWidth childMeasuredWidth=" + childMeasuredWidth);
                left = (maxWidth - childMeasuredWidth) / 2;
            } else {
                ILog.d(TAG, "maxWidth <= childMeasuredWidth childMeasuredWidth=" + childMeasuredWidth);
                left = 0;
            }
            ILog.d(TAG, "left=" + left);
            child.layout(left, top, left + childMeasuredWidth, top + childMeasuredHeight);
            top += childMeasuredHeight;
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        mPath.reset();
        mPath.addRoundRect(new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight()), 30, 30, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(mPath);
        canvas.drawColor(Color.BLACK);
        super.dispatchDraw(canvas);
        canvas.restore();
    }
}
