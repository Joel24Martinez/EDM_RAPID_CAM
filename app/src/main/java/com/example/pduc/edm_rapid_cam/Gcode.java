package com.example.pduc.edm_rapid_cam;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.customView.ChooseCoordinatesView;


public class Gcode extends Activity {

    TextView TV_Gcode;

    private ChooseCoordinatesView ChCoorcanvas;

    int maxtouches = 10;
    float[] x = new float[maxtouches];
    float[] y = new float[maxtouches];
    int touches = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcode);

        Bundle extras = getIntent().getExtras();
        touches = extras.getInt("touches");
        maxtouches = extras.getInt("maximumtouches");
        x = extras.getFloatArray("coordinate_x");
        y = extras.getFloatArray("coordinate_y");

        String[] Gcode=new String[touches];
        String previoustext= "N00 G00 X00 Y00";
        TV_Gcode = (TextView) findViewById(R.id.TV_Gcode);
        TV_Gcode.setText("N00 G00 X00 Y00");


        for (int i = 0; i < touches; ) {
            if(i==0){
                Gcode[i]="N"+Integer.toString(i+1)+"0 G00 X"+Float.toString(x[i])+" Y"+Float.toString(y[i]);
            } else {
                Gcode[i]="N"+Integer.toString(i+1)+"0 G01 X"+Float.toString(x[i])+" Y"+Float.toString(y[i]);
            }
            previoustext=TV_Gcode.getText().toString();
            TV_Gcode.setText(previoustext+System.getProperty ("line.separator")+Gcode[i]);
            i++;
        }
        previoustext=TV_Gcode.getText().toString();
        TV_Gcode.setText(previoustext+System.getProperty ("line.separator")+"M30");

        ChCoorcanvas = (ChooseCoordinatesView) findViewById(R.id.custom_view);
        ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java

    }



}
