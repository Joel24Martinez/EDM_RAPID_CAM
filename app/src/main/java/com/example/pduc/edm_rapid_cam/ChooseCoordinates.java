package com.example.pduc.edm_rapid_cam;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.customView.MyView;


public class ChooseCoordinates extends Activity {

    private MyView Mycanvas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_coordinates);

        Mycanvas = (MyView) findViewById(R.id.custom_view);
    }


}
