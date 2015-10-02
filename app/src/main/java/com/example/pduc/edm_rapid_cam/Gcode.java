package com.example.pduc.edm_rapid_cam;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
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
    boolean isSocketConnected=false;
    WifiConfiguration conf;
    WifiManager wifiManager;
    List<WifiConfiguration> list;
    boolean isSocketClosed=true;

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

        while (isConnectedTo(networkSSID) == false) {
            sendConnectionRequest();
        }

        new Thread(SocketRequest).start();

        while (isSocketConnected == false) {
        }

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
                //s.connect((new InetSocketAddress(InetAddress.getByName(ip), port)), 2000);
                s.setReceiveBufferSize(Buffersize);
                s.setSendBufferSize(1024);
            }
            /*catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } */
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            while (testByte == 0) {

                sendDatabytes((byte) 15);
                sendDatabytes((byte) touches);
                for (int i = 0; i < touches; ) {
                    sendDatabytes((byte) (17+(i*2)));
                    productfactor=x_int[i]/255;
                    sendDatabytes((byte) productfactor);
                    sumfactor=x_int[i]-productfactor*255;
                    sendDatabytes((byte) (sumfactor & 0xFF));

                    productfactor=y_int[i]/255;
                    sendDatabytes((byte) (productfactor & 0xFF));
                    sumfactor=y_int[i]-productfactor*255;
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

    private Runnable SocketRequest = new Runnable() {
        @Override
        public void run() {
            SocketConnection();
            isSocketClosed = s.isClosed();
            SocketClosed();
        }
    };


    public void sendConnectionRequest() {

        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        conf = new WifiConfiguration();
        conf.SSID = "\"" + networkSSID + "\"";
        conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);

        wifiManager.addNetwork(conf);
        list = wifiManager.getConfiguredNetworks();
        for (WifiConfiguration i : list) {
            if (i.SSID != null && i.SSID.equals("\"" + networkSSID + "\"")) {
                wifiManager.disconnect();
                wifiManager.enableNetwork(i.networkId, true);
                wifiManager.reconnect();
                break;
            }
        }

    };

    public void SocketConnection(){
        while (isSocketConnected == false) {
            try {

                s = new Socket();
                s.connect((new InetSocketAddress(InetAddress.getByName(ip), port)), 2000);
                isSocketConnected = s.isConnected();

            }catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            catch (IOException ex) {
                Log.e("TCP Error", ex.getLocalizedMessage());
            }
        }
    };

    public void SocketClosed(){
        while (isSocketClosed == true) {
            try {

                s = new Socket();
                s.connect((new InetSocketAddress(InetAddress.getByName(ip), port)), 2000);
                isSocketClosed = s.isClosed();

            }catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            catch (IOException ex) {
                Log.e("TCP Error", ex.getLocalizedMessage());
            }
        }
    };






    boolean isConnectedTo(String t) {

        try {
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();

            if (wifiInfo.getSSID().contains(t))
                return true;
        } catch (Exception a) {
        }

        return false;

    }

    @Override
    protected void onStop() {
        super.onStop();  // Always call the superclass method first
        try {
            s.close();
        }
        catch (IOException ex) {
            Log.e("TCP Error", ex.getLocalizedMessage());
        }

    }




}
