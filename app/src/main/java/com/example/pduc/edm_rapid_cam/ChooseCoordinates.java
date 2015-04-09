package com.example.pduc.edm_rapid_cam;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.customView.ChooseCoordinatesView;
import com.example.customView.MyView;


public class ChooseCoordinates extends Activity {

    private ChooseCoordinatesView ChCoorcanvas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_coordinates);

        Bundle extras = getIntent().getExtras();
        int touches = extras.getInt("touches");
        int maxtouches = extras.getInt("maximumtouches");
        float[] x = extras.getFloatArray("coordinate_x");
        float[] y = extras.getFloatArray("coordinate_y");

        ChCoorcanvas = (ChooseCoordinatesView) findViewById(R.id.custom_view);
        ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y);

    }
    //Call MyView.java for customshape
    public void Customclicked(View v) {
    }


}
