package com.example.isaac.wifienabledvideo;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.content.Context;
import android.text.format.Formatter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static android.R.attr.action;


public class MainActivity extends AppCompatActivity {
    Button enableButton,disableButton,getConnectionInfoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declare the buttons
        //declare the buttons
        enableButton=(Button)findViewById(R.id.button1);
        disableButton=(Button)findViewById(R.id.button2);
        getConnectionInfoButton = (Button)findViewById(R.id.button3);

        getConnectionInfoButton.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
//WifiInfo getConnectionInfo ()

                //Stack Over Flow Example
               // if (WifiManager.NETWORK_STATE_CHANGED_ACTION.equals (action)) {
                 //   NetworkInfo netInfo = intent.getParcelableExtra (WifiManager.EXTRA_NETWORK_INFO);
                   // if (ConnectivityManager.TYPE_WIFI == netInfo.getType ()) {
                     //   WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                       // WifiInfo wifi_info = WifiManager.getConnectionInfo();
                    //}}

                 WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                String hostName;
                try{

                    InetAddress intetObj = InetAddress.getLocalHost();
                    hostName = intetObj.getHostName();
                    Toast.makeText(MainActivity.this,hostName,Toast.LENGTH_SHORT).show();

                }
             catch (UnknownHostException ex) {
                 hostName = null;
            }


                //String test = intetObj.getHostName();
            }
        });

        enableButton.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                //Create object associated with WifiManager
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true);
                Toast.makeText(MainActivity.this,"Enabled",Toast.LENGTH_SHORT).show();
            }
        });

        disableButton.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);
                Toast.makeText(MainActivity.this,"Disabled",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
//Run on real Hardware