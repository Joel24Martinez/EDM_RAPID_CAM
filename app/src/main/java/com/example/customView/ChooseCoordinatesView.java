package com.example.customView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.pduc.edm_rapid_cam.MainActivity;

public class ChooseCoordinatesView extends View {
    //Some variables for the View
    private Paint paint;
    private Paint text;
    int Bitmapsize = 1200;
    int maxtouches = 10;
    float[] x = new float[maxtouches];
    float[] y = new float[maxtouches];
    int touches = 0;
    int r=0;

    public ChooseCoordinatesView(Context context) {
        this(context, null);
    }

    public ChooseCoordinatesView(Context context, AttributeSet attrs) {
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
                for (int l = 1; l < touches; l++) {
                    canvas.drawLine(x[l - 1], y[l - 1], x[l], y[l], paint);
                }



    }

    public void DrawCustomShapedCanvas(int in_touches, int in_maxtouches, float[] in_x, float[] in_y) {
        touches= in_touches;
        maxtouches= in_maxtouches;
        x=in_x;
        y=in_y;
        invalidate();
    }




}