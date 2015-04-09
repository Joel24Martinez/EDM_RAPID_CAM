package com.example.customView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.pduc.edm_rapid_cam.ChooseCoordinates;
import com.example.pduc.edm_rapid_cam.MainActivity;
import com.example.pduc.edm_rapid_cam.R;

public class MyView extends View {
    //Some variables for the View
    private Paint paint;
    private Paint text;
    String shape = "tshape";
    int yparam1 = 6;
    int yparam2 = 6;
    int tparam1 = 6;
    int tparam2 = 8;
    int Bitmapsize = 1200;
    int maxtouches = 30;
    public float[] x = new float[maxtouches];
    public float[] y = new float[maxtouches];
    public int touches = 0;

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

        int thickness = 10;
        paint.setColor(Color.BLACK);
        text.setColor(Color.BLACK);
        paint.setStrokeWidth(thickness);
        text.setTextSize(30);
        Bitmap bg = Bitmap.createBitmap(Bitmapsize, Bitmapsize, Bitmap.Config.ARGB_8888);

        if (shape == "tshape") {

            canvas.drawLine((Bitmapsize / 2) - (tparam1 * 100 / 2), 100, (Bitmapsize + (tparam1 * 100)) / 2, 100, paint);
            canvas.drawLine(600, 100, 600, 100 + (tparam2 * 100), paint);
            canvas.drawText("L1 [ mm ]", 550, 50, text);
            canvas.drawText("L2 [ mm ]", 400, 500, text);
        }


        if (shape == "yshape") {
            canvas.drawLine((Bitmapsize / 2) - (yparam1 * 100 / 2), 100, 600, 300, paint);
            canvas.drawLine(600, 300, (Bitmapsize + (yparam1 * 100)) / 2, 100, paint);
            canvas.drawLine(600, 300, 600, 300 + (yparam2 * 100), paint);
            canvas.drawText("L1 [ mm ]", 550, 50, text);
            canvas.drawText("L2 [ mm ]", 400, 500, text);
            ;
        }

        if (shape == "customshape") {
            if (touches > 1) {
                for (int l = 1; l < touches; l++) {
                    canvas.drawLine(x[l - 1], y[l - 1], x[l], y[l], paint);
                }
            }
            ;
        }


    }


    public void DrawYShapedCanvas(int L2chosen, int L1chosen) {
        yparam1 = L1chosen;
        yparam2 = L2chosen;
        shape = "yshape";
        invalidate();
    }

    public void DrawTShapedCanvas(int L2chosen, int L1chosen) {
        tparam1 = L1chosen;
        tparam2 = L2chosen;
        shape = "tshape";
        invalidate();
    }

    public void DrawCustomShapedCanvas() {
        shape = "customshape";
        for (int k = 1; k <= touches; k++) {
            x[k - 1] = 0;
            y[k - 1] = 0;
        }
        touches = 0;



        invalidate();
    }

    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (shape == "custom" +
                        "shape") {
                    if (touches < maxtouches) {
                        x[touches] = event.getX();
                        y[touches] = event.getY();

                        touches = touches + 1;
                        invalidate();
                    }
                }
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                invalidate();
                break;
        }


        return true;
    }


}