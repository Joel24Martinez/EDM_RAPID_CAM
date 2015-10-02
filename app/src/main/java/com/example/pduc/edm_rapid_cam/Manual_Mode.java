package com.example.pduc.edm_rapid_cam;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.customView.ChooseCoordinatesView;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;


public class Manual_Mode extends Activity {
    //Variable declarations

    //Wifi settings
    String networkSSID = "titan";
    String networkPass = "pass";
    Socket s;
    String ip = "1.2.3.4";
    int port = 2000;
    String connectionstate = " ";
    int Buffersize = 3;
    boolean isSocketConnected = false;
    WifiConfiguration conf;
    WifiManager wifiManager;
    List<WifiConfiguration> list;
    boolean isSocketClosed = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_mode);

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

    }

    ;

    public void SocketConnection() {
        while (isSocketConnected == false) {
            try {

                s = new Socket();
                s.connect((new InetSocketAddress(InetAddress.getByName(ip), port)), 2000);
                isSocketConnected = s.isConnected();

            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException ex) {
                Log.e("TCP Error", ex.getLocalizedMessage());
            }
        }
    }

    ;

    public void SocketClosed() {
        while (isSocketClosed == true) {
            try {

                s = new Socket();
                s.connect((new InetSocketAddress(InetAddress.getByName(ip), port)), 2000);
                isSocketClosed = s.isClosed();

            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException ex) {
                Log.e("TCP Error", ex.getLocalizedMessage());
            }
        }
    }

    ;

    boolean isConnectedTo(String t) {

        try {
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();

            if (wifiInfo.getSSID().contains(t))
                return true;
        } catch (Exception a) {
        }

        return false;

    }

    public void XPLUSclicked(View v) {
        sendDatabytes((byte) 3);
    }

    public void XMINUSclicked(View v) {
        sendDatabytes((byte) 5);
    }

    public void YPLUSclicked(View v) {
        sendDatabytes((byte) 7);
    }

    public void YMINUSclicked(View v) {
        sendDatabytes((byte) 9);
    }

    public void ZPLUSclicked(View v) {
        sendDatabytes((byte) 11);
    }

    public void ZMINUSclicked(View v) {
        sendDatabytes((byte) 13);
    }


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

    @Override
    protected void onStop() {
        super.onStop();  // Always call the superclass method first
        try {
            s.close();
        } catch (IOException ex) {
            Log.e("TCP Error", ex.getLocalizedMessage());
        }

    }

}
