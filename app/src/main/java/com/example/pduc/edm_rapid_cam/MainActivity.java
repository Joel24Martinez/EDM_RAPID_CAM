package com.example.pduc.edm_rapid_cam;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.example.customView.MyView;

public class MainActivity extends Activity {

    private MyView Mycanvas;
    NumberPicker L1;
    NumberPicker L2;
    int L1chosen=6;
    int L2chosen=8;
    String shape = "tshape";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mycanvas = (MyView) findViewById(R.id.custom_view);
        L1=(NumberPicker) findViewById(R.id.L1);
        L1.setMaxValue(6);
        L1.setMinValue(0);
        L1.setValue(6);
        L1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        L2=(NumberPicker) findViewById(R.id.L2);
        L2.setMaxValue(8);
        L2.setMinValue(0);
        L2.setValue(8);
        L2.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        L1.setOnValueChangedListener( new NumberPicker.
                OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker1, int
                    oldVal1, int newVal1) {
                L1chosen=newVal1;
                if(shape=="tshape"){
                    Mycanvas.DrawTShapedCanvas(L2chosen, L1chosen);
                }
                if(shape=="yshape"){
                    Mycanvas.DrawYShapedCanvas(L2chosen, L1chosen);
                }
                            }
        });

        L2.setOnValueChangedListener( new NumberPicker.
                OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker2, int
                    oldVal2, int newVal2) {
                L2chosen=newVal2;
                if(shape=="tshape"){
                    Mycanvas.DrawTShapedCanvas(L2chosen, L1chosen);
                }
                if(shape=="yshape"){
                    Mycanvas.DrawYShapedCanvas(L2chosen, L1chosen);
                }
            }
        });


    }
    public void Yshapedclicked(View v) {
        L1.setMaxValue(6);
        L1.setMinValue(0);
        L2.setMaxValue(6);
        L2.setMinValue(0);
        if (L2chosen>6){
        L2.setValue(6);
            L2chosen=6;
        }
        shape="yshape";
        Mycanvas.DrawYShapedCanvas(L2chosen, L1chosen);
    }

    public void Tshapedclicked(View v) {
        L1.setMaxValue(6);
        L1.setMinValue(0);
        L2.setMaxValue(8);
        L2.setMinValue(0);
        shape="tshape";
        Mycanvas.DrawTShapedCanvas(L2chosen, L1chosen);
    }

}
