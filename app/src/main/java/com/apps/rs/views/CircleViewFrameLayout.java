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
            mOval = new RectF(20, 20, getWidth() - 20, getHeight() - 20);
        }
        mClipPath.addOval(mOval, Path.Direction.CW);
        boolean b = canvas.clipPath(mClipPath);
    }

    private void init() {
        mClipPath = new Path();
    }
}
