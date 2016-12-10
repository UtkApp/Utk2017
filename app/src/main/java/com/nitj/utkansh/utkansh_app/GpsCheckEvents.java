
package com.nitj.utkansh.utkansh_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class GpsCheckEvents extends AppCompatActivity {
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_check);
        android.support.v7.app.ActionBar actionBar =  getSupportActionBar();
        actionBar.hide();

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);


        Intent intent=getIntent();
        name= intent.getExtras().getString("name");


        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Intent i=new Intent(GpsCheckEvents.this, com.nitj.utkansh.utkansh_app.MapsTestEvents.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            i.putExtra("name",name);
            startActivity(i);
            this.finish();


        }else{

            showGPSDisabledAlertToUser();
        }


    }
    private void showGPSDisabledAlertToUser(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("GPS is disabled in your device. Would you like to enable it?")
                .setCancelable(false)
                .setPositiveButton("Enable GPS",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);
                            }
                        });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gps_check, menu);
        return true;
    }

    @Override
    public void onStart()
    {
        super.onStart();

    }
    @Override
    public void  onResume()
    {
        super.onResume();


    }


    @Override
    public void onRestart()
    {
        super.onRestart();
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){



            Intent i=new Intent(GpsCheckEvents.this, com.nitj.utkansh.utkansh_app.MapsTestEvents.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            i.putExtra("name",name);
            startActivity(i);

            this.finish();

        }else{

            showGPSDisabledAlertToUser();
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
