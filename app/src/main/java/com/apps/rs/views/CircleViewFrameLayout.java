package com.apps.rs.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by ronen on 22-Jun-16.
 */
public class CircleViewFrameLayout extends FrameLayout {

    private Path mClipPath;
    private RectF mOval;
    private int mClipMargin;

    public CircleViewFrameLayout(Context context) {
        super(context);
        init();
    }

    public CircleViewFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleViewFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (null == mOval) {
            mOval = new RectF(mClipMargin, mClipMargin, getWidth() - mClipMargin, getHeight() - mClipMargin);
        }
        mClipPath.addOval(mOval, Path.Direction.CW);
        canvas.clipPath(mClipPath);
    }

    private void init() {
        setWillNotDraw(false);
        mClipMargin = (int) (8 * getContext().getResources().getDisplayMetrics().density);
        mClipPath = new Path();
    }
}
