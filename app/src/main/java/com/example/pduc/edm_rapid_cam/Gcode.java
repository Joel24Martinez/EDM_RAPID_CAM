package com.example.pduc.edm_rapid_cam;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customView.ChooseCoordinatesView;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Gcode extends Activity {

    TextView TV_Gcode;

    private ChooseCoordinatesView ChCoorcanvas;

    int maxtouches = 10;
    float[] x = new float[maxtouches];
    float[] y = new float[maxtouches];
    int [] x_int = new int[maxtouches];
    int [] y_int = new int[maxtouches];
    byte[] dataout;

    int touches = 10;

    //Wifi settings
    String networkSSID = "titan";
    String networkPass = "pass";
    Socket s;
    String ip = "1.2.3.4";
    int port = 2000;
    String connectionstate = " ";
    int Buffersize = 3;

    //data transmission
    int testByte = 0;
    String newstring;
    int productfactor;
    int sumfactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcode);

        Bundle extras = getIntent().getExtras();
        touches = extras.getInt("touches");
        maxtouches = extras.getInt("maximumtouches");
        x = extras.getFloatArray("coordinate_x");
        y = extras.getFloatArray("coordinate_y");

        String[] Gcode = new String[touches];
        String previoustext = "N00 G00 X00 Y00";
        TV_Gcode = (TextView) findViewById(R.id.TV_Gcode);
        TV_Gcode.setText("N00 G00 X00 Y00");


        for (int i = 0; i < touches; ) {
            x_int[i]= (int)x[i];
            y_int[i]= (int)y[i];
            if (i == 0) {
                Gcode[i] = "N" + Integer.toString(i + 1) + "0 G00 X" + x_int[i] + " Y" + y_int[i];
            } else {
                Gcode[i] = "N" + Integer.toString(i + 1) + "0 G01 X" + x_int[i] + " Y" + y_int[i];
            }
            previoustext = TV_Gcode.getText().toString();
            TV_Gcode.setText(previoustext + System.getProperty("line.separator") + Gcode[i]);
            i++;
        }
        previoustext = TV_Gcode.getText().toString();
        TV_Gcode.setText(previoustext + System.getProperty("line.separator") + "M30");

        ChCoorcanvas = (ChooseCoordinatesView) findViewById(R.id.custom_view);
        ChCoorcanvas.DrawCustomShapedCanvas(touches, maxtouches, x, y); //Calling mehtod in ChooseCordinateView.java

        //Network connection
        WifiConfiguration conf = new WifiConfiguration();
        conf.SSID = "\"" + networkSSID + "\"";
        conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
        WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        wifiManager.addNetwork(conf);
        List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
        for (WifiConfiguration i : list) {
            if (i.SSID != null && i.SSID.equals("\"" + networkSSID + "\"")) {
                wifiManager.disconnect();
                wifiManager.enableNetwork(i.networkId, true);
                wifiManager.reconnect();
                break;
            }
        }


        s = new Socket();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(mLoop).start();
    }

    private Runnable mLoop = new Runnable() {
        @Override
        public void run() {
            try {
                s.connect((new InetSocketAddress(InetAddress.getByName(ip), port)), 2000);
                s.setReceiveBufferSize(Buffersize);
                s.setSendBufferSize(1024);
            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            while (testByte == 0) {

                sendDatabytes((byte) 11);
                sendDatabytes((byte) touches);
                for (int i = 0; i < touches; ) {
                    sendDatabytes((byte) (13+(i*2)));
                    productfactor=x_int[i]/255;
                    sendDatabytes((byte) productfactor);
                    sumfactor=x_int[i]-productfactor*255;
                    sendDatabytes((byte) (sumfactor & 0xFF));
                    i++;

                }
            }

        }
    };

    public void sendDatabytes(byte str) {
        if (s != null && !s.isClosed()) {
            try {
                OutputStream out = s.getOutputStream();
                out.write(str);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                Toast.makeText(getApplicationContext()
                        , "Please check your WiFi Connection"
                        , Toast.LENGTH_SHORT).show();
            }
        }
    }


}
