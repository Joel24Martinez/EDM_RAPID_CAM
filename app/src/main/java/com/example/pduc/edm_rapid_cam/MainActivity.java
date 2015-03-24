package com.example.pduc.edm_rapid_cam;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.customView.MyView;

public class MainActivity extends Activity {

    private MyView Mycanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mycanvas = (MyView) findViewById(R.id.custom_view);

    }
    public void Yshapedclicked(View v) {
        Mycanvas.DrawYShapedCanvas();
    }

    public void Tshapedclicked(View v) {
        Mycanvas.DrawTShapedCanvas();
    }

}
