package com.fdo.prasanga.getgpslocation;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

Button btnShowLocation;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowLocation = (Button) findViewById(R.id.showLocation);
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPSTracker(MainActivity.this);

                if(gps.canGetLocation()){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    Toast.makeText(getApplicationContext(),
                            "Your Location is:\nLat: "+latitude+"\nLong: "+longitude, Toast.LENGTH_LONG).show();
                }else{
                    gps.showSettingsAlert();
                }
            }
        });
    }


}
