package com.example.customView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.pduc.edm_rapid_cam.R;

public class MyView extends View {
    private PointF point;
    private Paint paint;
    private Paint text;
    boolean erase = false;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        text = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {

            int thickness = 30;
            paint.setColor(Color.BLACK);
            text.setColor(Color.BLACK);
            paint.setStrokeWidth(thickness);
            text.setTextSize(30);
            Bitmap bg = Bitmap.createBitmap(1200, 1200, Bitmap.Config.ARGB_8888);
            canvas.drawLine(300, 100, 900, 100, paint);
            canvas.drawLine(600, 100, 600, 900, paint);
            canvas.drawText("L1 [ mm/1000 ]", 500, 50, text);
            canvas.drawText("L2 [ mm/1000 ]", 360, 500, text);



        if (erase==true){
            canvas.drawColor(Color.WHITE);}


    }

  /*public void Yshapedclicked(View view) {
      erase=true;
      invalidate();
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
    }*/
}