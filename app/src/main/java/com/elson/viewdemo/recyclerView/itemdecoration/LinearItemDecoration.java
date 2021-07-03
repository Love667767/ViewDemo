package com.elson.viewdemo.recyclerView.itemdecoration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author elson
 * @date 2021/7/3
 * @Desc
 */
public class LinearItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint1, mPaint2, mPaint3;
    public LinearItemDecoration() {
        mPaint1 = new Paint();
        mPaint1.setColor(Color.GREEN);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint3 = new Paint();
        mPaint3.setStyle(Paint.Style.FILL);
        mPaint3.setStrokeWidth(5);
        mPaint3.setColor(Color.GRAY);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        // 设置每个Item的上下左右间距
        outRect.set(100, 30, 100, 50);
    }

    /**
     *
     * @param canvas：是通过getItemOffsets所撑开的空白区域所对应的画布
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(canvas, parent, state);

        int childCount = parent.getChildCount();
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        for (int i = 0; i < childCount; i++) {
            // 每个Item左边画圆
            View child = parent.getChildAt(i);
            int cx = layoutManager.getLeftDecorationWidth(child) / 2;
            int cy = child.getTop() + child.getHeight() / 2;
            canvas.drawCircle(cx, cy, 20, mPaint1);

            // 每个Item 右边画圆
            int cx1 = child.getRight() + layoutManager.getRightDecorationWidth(child) / 2;
            int cy1 = child.getTop() + child.getHeight() / 2;
            canvas.drawCircle(cx1, cy1, 20, mPaint2);

            // 每个Item底部画分割线
            int bottom = layoutManager.getBottomDecorationHeight(child);
            int height = child.getHeight();
            int width = layoutManager.getDecoratedMeasuredWidth(child);
            canvas.drawLine(0, child.getTop() + height + bottom, width, child.getTop() + height + bottom, mPaint3);
        }
    }

    /**
     * 绘制顺序：ItemDecoration.onDraw -> Item.onDraw -> ItemDecoration.onDrawOver
     * @param canvas
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(canvas, parent, state);
    }
}
