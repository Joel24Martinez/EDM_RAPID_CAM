package com.example.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    private PointF point;
    private Paint paint;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (point != null) {
            int radius = 50;
            paint.setColor(Color.GREEN);
            canvas.drawCircle(point.x, point.y, radius, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                point = new PointF(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_UP:
                point = null;
                break;
            case MotionEvent.ACTION_MOVE:
                point = new PointF(event.getX(), event.getY());
                break;
        }
        invalidate();
        return true;
    }
}