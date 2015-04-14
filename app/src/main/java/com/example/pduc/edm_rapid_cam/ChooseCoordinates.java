package com.example.pduc.edm_rapid_cam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.customView.ChooseCoordinatesView;


public class ChooseCoordinates extends Activity {
    //Variable declarations
    private ChooseCoordinatesView ChCoorcanvas;

    EditText ET_X_1;
    EditText ET_Y_1;
    EditText ET_X_2;
    EditText ET_Y_2;
    EditText ET_X_3;
    EditText ET_Y_3;
    EditText ET_X_4;
    EditText ET_Y_4;
    EditText ET_X_5;
    EditText ET_Y_5;
    EditText ET_X_6;
    EditText ET_Y_6;
    EditText ET_X_7;
    EditText ET_Y_7;
    EditText ET_X_8;
    EditText ET_Y_8;
    EditText ET_X_9;
    EditText ET_Y_9;
    EditText ET_X_10;
    EditText ET_Y_10;

    CheckBox CB_L_1;
    CheckBox CB_L_2;
    CheckBox CB_L_3;
    CheckBox CB_L_4;
    CheckBox CB_L_5;
    CheckBox CB_L_6;
    CheckBox CB_L_7;
    CheckBox CB_L_8;
    CheckBox CB_L_9;

    int maxtouches = 10;
    float[] x = new float[maxtouches];
    float[] y = new float[maxtouches];
    int touches = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_coordinates);
        //Getting extra values from last activity
        Bundle extras = getIntent().getExtras();
        touches = extras.getInt("touches");
        maxtouches = extras.getInt("maximumtouches");
        x = extras.getFloatArray("coordinate_x");
        y = extras.getFloatArray("coordinate_y");

        //Assigning layout
        ChCoorcanvas = (ChooseCoordinatesView) findViewById(R.id.custom_view);
        ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java


        ///////////////////TEXTVIEWS
//===================================
        //Assigning TextViews
        ET_X_1 = (EditText) findViewById(R.id.ET_X_1);
        ET_Y_1 = (EditText) findViewById(R.id.ET_Y_1);
        //Setting initial values
        ET_X_1.setText(Float.toString(x[0]));
        ET_Y_1.setText(Float.toString(y[0]));
        //Extracting values from TextViews
        ET_X_1.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_1.getText().toString().equals("")) {
                    x[0] = 0;
                    ET_X_1.setText(Float.toString(x[0]));
                } else if (ET_Y_1.getText().toString().equals("")) {
                    y[0] = 0;
                    ET_Y_1.setText(Float.toString(y[0]));
                } else {
                    x[0] = Float.parseFloat(ET_X_1.getText().toString());
                    y[0] = Float.parseFloat(ET_Y_1.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        ET_Y_1.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_1.getText().toString().equals("")) {
                    x[0] = 0;
                    ET_X_1.setText(Float.toString(x[0]));
                } else if (ET_Y_1.getText().toString().equals("")) {
                    y[0] = 0;
                    ET_Y_1.setText(Float.toString(y[0]));
                } else {
                    x[0] = Float.parseFloat(ET_X_1.getText().toString());
                    y[0] = Float.parseFloat(ET_Y_1.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
//===================================
        //Assigning TextViews
        ET_X_2 = (EditText) findViewById(R.id.ET_X_2);
        ET_Y_2 = (EditText) findViewById(R.id.ET_Y_2);
        //Setting initial values
        ET_X_2.setText(Float.toString(x[1]));
        ET_Y_2.setText(Float.toString(y[1]));
        //Extracting values from TextViews
        ET_X_2.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_2.getText().toString().equals("")) {
                    x[1] = 0;
                    ET_X_2.setText(Float.toString(x[1]));
                } else if (ET_Y_2.getText().toString().equals("")) {
                    y[1] = 0;
                    ET_Y_2.setText(Float.toString(y[1]));
                } else {
                    x[1] = Float.parseFloat(ET_X_2.getText().toString());
                    y[1] = Float.parseFloat(ET_Y_2.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        ET_Y_2.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_2.getText().toString().equals("")) {
                    x[1] = 0;
                    ET_X_2.setText(Float.toString(x[1]));
                } else if (ET_Y_2.getText().toString().equals("")) {
                    y[1] = 0;
                    ET_Y_2.setText(Float.toString(y[1]));
                } else {
                    x[1] = Float.parseFloat(ET_X_2.getText().toString());
                    y[1] = Float.parseFloat(ET_Y_2.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
//===================================
        //Assigning TextViews
        ET_X_3 = (EditText) findViewById(R.id.ET_X_3);
        ET_Y_3 = (EditText) findViewById(R.id.ET_Y_3);
        //Setting initial values
        ET_X_3.setText(Float.toString(x[2]));
        ET_Y_3.setText(Float.toString(y[2]));
        //Extracting values from TextViews
        ET_X_3.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_3.getText().toString().equals("")) {
                    x[2] = 0;
                    ET_X_3.setText(Float.toString(x[2]));
                } else if (ET_Y_3.getText().toString().equals("")) {
                    y[2] = 0;
                    ET_Y_3.setText(Float.toString(y[2]));
                } else {
                    x[2] = Float.parseFloat(ET_X_3.getText().toString());
                    y[2] = Float.parseFloat(ET_Y_3.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        ET_Y_3.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_3.getText().toString().equals("")) {
                    x[2] = 0;
                    ET_X_3.setText(Float.toString(x[2]));
                } else if (ET_Y_3.getText().toString().equals("")) {
                    y[2] = 0;
                    ET_Y_3.setText(Float.toString(y[2]));
                } else {
                    x[2] = Float.parseFloat(ET_X_3.getText().toString());
                    y[2] = Float.parseFloat(ET_Y_3.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
//===================================
        //Assigning TextViews
        ET_X_4 = (EditText) findViewById(R.id.ET_X_4);
        ET_Y_4 = (EditText) findViewById(R.id.ET_Y_4);
        //Setting initial values
        ET_X_4.setText(Float.toString(x[3]));
        ET_Y_4.setText(Float.toString(y[3]));
        //Extracting values from TextViews
        ET_X_4.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_4.getText().toString().equals("")) {
                    x[3] = 0;
                    ET_X_4.setText(Float.toString(x[3]));
                } else if (ET_Y_4.getText().toString().equals("")) {
                    y[3] = 0;
                    ET_Y_4.setText(Float.toString(y[3]));
                } else {
                    x[3] = Float.parseFloat(ET_X_4.getText().toString());
                    y[3] = Float.parseFloat(ET_Y_4.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        ET_Y_4.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_4.getText().toString().equals("")) {
                    x[3] = 0;
                    ET_X_4.setText(Float.toString(x[3]));
                } else if (ET_Y_4.getText().toString().equals("")) {
                    y[3] = 0;
                    ET_Y_4.setText(Float.toString(y[3]));
                } else {
                    x[3] = Float.parseFloat(ET_X_4.getText().toString());
                    y[3] = Float.parseFloat(ET_Y_4.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
//===================================
        //Assigning TextViews
        ET_X_5 = (EditText) findViewById(R.id.ET_X_5);
        ET_Y_5 = (EditText) findViewById(R.id.ET_Y_5);
        //Setting initial values
        ET_X_5.setText(Float.toString(x[4]));
        ET_Y_5.setText(Float.toString(y[4]));
        //Extracting values from TextViews
        ET_X_5.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_5.getText().toString().equals("")) {
                    x[4] = 0;
                    ET_X_5.setText(Float.toString(x[4]));
                } else if (ET_Y_5.getText().toString().equals("")) {
                    y[4] = 0;
                    ET_Y_5.setText(Float.toString(y[4]));
                } else {
                    x[4] = Float.parseFloat(ET_X_5.getText().toString());
                    y[4] = Float.parseFloat(ET_Y_5.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        ET_Y_5.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_5.getText().toString().equals("")) {
                    x[4] = 0;
                    ET_X_5.setText(Float.toString(x[4]));
                } else if (ET_Y_5.getText().toString().equals("")) {
                    y[4] = 0;
                    ET_Y_5.setText(Float.toString(y[4]));
                } else {
                    x[4] = Float.parseFloat(ET_X_5.getText().toString());
                    y[4] = Float.parseFloat(ET_Y_5.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
//===================================
        //Assigning TextViews
        ET_X_6 = (EditText) findViewById(R.id.ET_X_6);
        ET_Y_6 = (EditText) findViewById(R.id.ET_Y_6);
        //Setting initial values
        ET_X_6.setText(Float.toString(x[5]));
        ET_Y_6.setText(Float.toString(y[5]));
        //Extracting values from TextViews
        ET_X_6.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_6.getText().toString().equals("")) {
                    x[5] = 0;
                    ET_X_6.setText(Float.toString(x[5]));
                } else if (ET_Y_6.getText().toString().equals("")) {
                    y[5] = 0;
                    ET_Y_6.setText(Float.toString(y[5]));
                } else {
                    x[5] = Float.parseFloat(ET_X_6.getText().toString());
                    y[5] = Float.parseFloat(ET_Y_6.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        ET_Y_6.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_6.getText().toString().equals("")) {
                    x[5] = 0;
                    ET_X_6.setText(Float.toString(x[5]));
                } else if (ET_Y_6.getText().toString().equals("")) {
                    y[5] = 0;
                    ET_Y_6.setText(Float.toString(y[5]));
                } else {
                    x[5] = Float.parseFloat(ET_X_6.getText().toString());
                    y[5] = Float.parseFloat(ET_Y_6.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
//===================================
        //Assigning TextViews
        ET_X_7 = (EditText) findViewById(R.id.ET_X_7);
        ET_Y_7 = (EditText) findViewById(R.id.ET_Y_7);
        //Setting initial values
        ET_X_7.setText(Float.toString(x[6]));
        ET_Y_7.setText(Float.toString(y[6]));
        //Extracting values from TextViews
        ET_X_7.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_7.getText().toString().equals("")) {
                    x[6] = 0;
                    ET_X_7.setText(Float.toString(x[6]));
                } else if (ET_Y_7.getText().toString().equals("")) {
                    y[6] = 0;
                    ET_Y_7.setText(Float.toString(y[6]));
                } else {
                    x[6] = Float.parseFloat(ET_X_7.getText().toString());
                    y[6] = Float.parseFloat(ET_Y_7.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        ET_Y_7.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_7.getText().toString().equals("")) {
                    x[6] = 0;
                    ET_X_7.setText(Float.toString(x[6]));
                } else if (ET_Y_7.getText().toString().equals("")) {
                    y[6] = 0;
                    ET_Y_7.setText(Float.toString(y[6]));
                } else {
                    x[6] = Float.parseFloat(ET_X_7.getText().toString());
                    y[6] = Float.parseFloat(ET_Y_7.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
//===================================
        //Assigning TextViews
        ET_X_8 = (EditText) findViewById(R.id.ET_X_8);
        ET_Y_8 = (EditText) findViewById(R.id.ET_Y_8);
        //Setting initial values
        ET_X_8.setText(Float.toString(x[7]));
        ET_Y_8.setText(Float.toString(y[7]));
        //Extracting values from TextViews
        ET_X_8.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_8.getText().toString().equals("")) {
                    x[7] = 0;
                    ET_X_8.setText(Float.toString(x[7]));
                } else if (ET_Y_8.getText().toString().equals("")) {
                    y[7] = 0;
                    ET_Y_8.setText(Float.toString(y[7]));
                } else {
                    x[7] = Float.parseFloat(ET_X_8.getText().toString());
                    y[7] = Float.parseFloat(ET_Y_8.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        ET_Y_8.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_8.getText().toString().equals("")) {
                    x[7] = 0;
                    ET_X_8.setText(Float.toString(x[7]));
                } else if (ET_Y_8.getText().toString().equals("")) {
                    y[7] = 0;
                    ET_Y_8.setText(Float.toString(y[7]));
                } else {
                    x[7] = Float.parseFloat(ET_X_8.getText().toString());
                    y[7] = Float.parseFloat(ET_Y_8.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        //===================================
        //Assigning TextViews
        ET_X_9 = (EditText) findViewById(R.id.ET_X_9);
        ET_Y_9 = (EditText) findViewById(R.id.ET_Y_9);
        //Setting initial values
        ET_X_9.setText(Float.toString(x[8]));
        ET_Y_9.setText(Float.toString(y[8]));
        //Extracting values from TextViews
        ET_X_9.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_9.getText().toString().equals("")) {
                    x[8] = 0;
                    ET_X_9.setText(Float.toString(x[8]));
                } else if (ET_Y_9.getText().toString().equals("")) {
                    y[8] = 0;
                    ET_Y_9.setText(Float.toString(y[8]));
                } else {
                    x[8] = Float.parseFloat(ET_X_9.getText().toString());
                    y[8] = Float.parseFloat(ET_Y_9.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        ET_Y_9.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_9.getText().toString().equals("")) {
                    x[8] = 0;
                    ET_X_9.setText(Float.toString(x[8]));
                } else if (ET_Y_9.getText().toString().equals("")) {
                    y[8] = 0;
                    ET_Y_9.setText(Float.toString(y[8]));
                } else {
                    x[8] = Float.parseFloat(ET_X_9.getText().toString());
                    y[8] = Float.parseFloat(ET_Y_9.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        //===================================
        //Assigning TextViews
        ET_X_10 = (EditText) findViewById(R.id.ET_X_10);
        ET_Y_10 = (EditText) findViewById(R.id.ET_Y_10);
        //Setting initial values
        ET_X_10.setText(Float.toString(x[9]));
        ET_Y_10.setText(Float.toString(y[9]));
        //Extracting values from TextViews
        ET_X_10.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_10.getText().toString().equals("")) {
                    x[9] = 0;
                    ET_X_10.setText(Float.toString(x[9]));
                } else if (ET_Y_10.getText().toString().equals("")) {
                    y[9] = 0;
                    ET_Y_10.setText(Float.toString(y[9]));
                } else {
                    x[9] = Float.parseFloat(ET_X_10.getText().toString());
                    y[9] = Float.parseFloat(ET_Y_10.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        ET_Y_10.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (ET_X_10.getText().toString().equals("")) {
                    x[9] = 0;
                    ET_X_10.setText(Float.toString(x[9]));
                } else if (ET_Y_10.getText().toString().equals("")) {
                    y[9] = 0;
                    ET_Y_10.setText(Float.toString(y[9]));
                } else {
                    x[9] = Float.parseFloat(ET_X_10.getText().toString());
                    y[9] = Float.parseFloat(ET_Y_10.getText().toString());
                    ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        //============================================
        //CHECKBOXES
        //============================================
        //Assigning Checkboxes
        CB_L_1 = (CheckBox) findViewById (R.id.CB_L_1);
        CB_L_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    ET_X_2.setText(Float.toString(x[0]));
                }
                else{
                    ET_X_2.setText(Float.toString(x[1]));
                }
            }
        });
        //============================================
        //Assigning Checkboxes
        CB_L_2 = (CheckBox) findViewById (R.id.CB_L_2);
        CB_L_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    ET_Y_3.setText(Float.toString(y[1]));
                }
                else{
                    ET_Y_3.setText(Float.toString(y[2]));
                }
            }
        });

        //============================================
        //Assigning Checkboxes
        CB_L_3 = (CheckBox) findViewById (R.id.CB_L_3);
        CB_L_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    ET_X_4.setText(Float.toString(x[2]));
                }
                else{
                    ET_X_4.setText(Float.toString(x[3]));
                }
            }
        });
        //============================================
        //Assigning Checkboxes
        CB_L_4 = (CheckBox) findViewById (R.id.CB_L_4);
        CB_L_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    ET_Y_5.setText(Float.toString(y[3]));
                }
                else{
                    ET_Y_5.setText(Float.toString(y[4]));
                }
            }
        });
        //============================================
        //Assigning Checkboxes
        CB_L_5 = (CheckBox) findViewById (R.id.CB_L_5);
        CB_L_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    ET_X_6.setText(Float.toString(x[4]));
                }
                else{
                    ET_X_6.setText(Float.toString(x[5]));
                }
            }
        });
        //============================================
        //Assigning Checkboxes
        CB_L_6 = (CheckBox) findViewById (R.id.CB_L_6);
        CB_L_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    ET_Y_7.setText(Float.toString(y[5]));
                }
                else{
                    ET_Y_7.setText(Float.toString(y[6]));
                }
            }
        });
        //============================================
        //Assigning Checkboxes
        CB_L_7 = (CheckBox) findViewById (R.id.CB_L_7);
        CB_L_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    ET_X_8.setText(Float.toString(x[6]));
                }
                else{
                    ET_X_8.setText(Float.toString(x[7]));
                }
            }
        });
        //============================================
        //Assigning Checkboxes
        CB_L_8 = (CheckBox) findViewById (R.id.CB_L_8);
        CB_L_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    ET_Y_9.setText(Float.toString(y[7]));
                }
                else{
                    ET_Y_9.setText(Float.toString(y[8]));
                }
            }
        });
        //============================================
        //Assigning Checkboxes
        CB_L_9 = (CheckBox) findViewById (R.id.CB_L_9);
        CB_L_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    ET_X_10.setText(Float.toString(x[8]));
                }
                else{
                    ET_X_10.setText(Float.toString(x[9]));
                }
            }
        });



    }

    public void Gcodeclicked(View v) {
        final Context context = this;
        Intent getGcode = new Intent(context, Gcode.class);
        getGcode.putExtra("touches", touches);
        getGcode.putExtra("maximumtouches", maxtouches);
        getGcode.putExtra("coordinate_x", x);
        getGcode.putExtra("coordinate_y", y);
        startActivity(getGcode);
    }


}
