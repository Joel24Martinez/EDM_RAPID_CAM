package com.example.pduc.edm_rapid_cam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.example.customView.MyView;

public class MainActivity extends Activity {

    //Variables for the activity
    private MyView Mycanvas; //to display the drawing
    NumberPicker L1;//To choose parameter
    NumberPicker L2;//To choose parameter
    int L1chosen = 6;//Parameter value
    int L2chosen = 8;//Parameter value
    String shape = "tshape";//Type of shape
    int maxtouches = 10;
    float[] x = new float[maxtouches];
    float[] y = new float[maxtouches];
    int touches = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Layout assignment

        Mycanvas = (MyView) findViewById(R.id.custom_view);//Canvas layout assignment

        L1 = (NumberPicker) findViewById(R.id.L1);//Number picker layout assignment
        L1.setMaxValue(6);
        L1.setMinValue(0);
        L1.setValue(6);
        L1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        L2 = (NumberPicker) findViewById(R.id.L2); //Number picker layout assignment
        L2.setMaxValue(8);
        L2.setMinValue(0);
        L2.setValue(8);
        L2.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        //RT detection of changes of parameters L1 and L2
        L1.setOnValueChangedListener(new NumberPicker.
                OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker1, int
                    oldVal1, int newVal1) {
                L1chosen = newVal1;
                if (shape == "tshape") {
                    Mycanvas.DrawTShapedCanvas(L2chosen, L1chosen);
                }
                if (shape == "yshape") {
                    Mycanvas.DrawYShapedCanvas(L2chosen, L1chosen);
                }
            }
        });
        L2.setOnValueChangedListener(new NumberPicker.
                OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker2, int
                    oldVal2, int newVal2) {
                L2chosen = newVal2;
                if (shape == "tshape") {
                    Mycanvas.DrawTShapedCanvas(L2chosen, L1chosen);
                }
                if (shape == "yshape") {
                    Mycanvas.DrawYShapedCanvas(L2chosen, L1chosen);
                }
            }
        });
    }

    //Call MyView.java for yshape
    public void Yshapedclicked(View v) {
        L1.setMaxValue(6);
        L1.setMinValue(0);
        L2.setMaxValue(6);
        L2.setMinValue(0);
        if (L2chosen > 6) {
            L2.setValue(6);
            L2chosen = 6;
        }
        shape = "yshape";
        Mycanvas.DrawYShapedCanvas(L2chosen, L1chosen);
    }

    //Call MyView.java for tshape
    public void Tshapedclicked(View v) {
        L1.setMaxValue(6);
        L1.setMinValue(0);
        L2.setMaxValue(8);
        L2.setMinValue(0);
        shape = "tshape";
        Mycanvas.DrawTShapedCanvas(L2chosen, L1chosen);
    }

    //Call MyView.java for customshape
    public void Customclicked(View v) {
        shape = "cshape";
        Mycanvas.DrawCustomShapedCanvas();
    }



    //Call ChooseCoordinates.java
    public void ChooseCclicked(View v) {
        touches=Mycanvas.touches;
        x=Mycanvas.x;
        y=Mycanvas.y;
        final Context context = this;
        Intent choosecoo = new Intent(context, ChooseCoordinates.class);
        choosecoo.putExtra("touches", touches);
        choosecoo.putExtra("maximumtouches", maxtouches);
        choosecoo.putExtra("coordinate_x", x);
        choosecoo.putExtra("coordinate_y", y);
        startActivity(choosecoo);
    }


}
