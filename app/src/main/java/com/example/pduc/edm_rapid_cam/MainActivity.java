package com.example.pduc.edm_rapid_cam;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

@SuppressWarnings("ALL")
public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#CD5C5C"));
        paint.setStrokeWidth(12);
        Bitmap bg = Bitmap.createBitmap(1200, 1800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        canvas.drawLine(50, 1510, 1100, 200, paint);
        LinearLayout ll = (LinearLayout) findViewById(R.id.rect);
        ll.setBackgroundDrawable(new BitmapDrawable(bg));
    }

}


