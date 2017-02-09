/*
package com.nitj.utkansh.utkansh_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.nitj.utkansh.utkansh_app.helper.SQLiteHelper;

public class Notifications extends AppCompatActivity {


    SQLiteHelper db;
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    String [] notiarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        db = new SQLiteHelper(getApplicationContext());
        if (!checkPlayServices()) {
            Toast.makeText(
                    getApplicationContext(),
                    "This device doesn't support Play services, App will not work normally",
                    Toast.LENGTH_LONG).show();
        }
        notiarray = db.getNotifications();
        if(notiarray.length==0)
        {
            notiarray= new String[1];
            notiarray[0]="No new Notifications";
        }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listitem,notiarray);
            ListView listView = (ListView) findViewById(R.id.listViewNoti);
            listView.setAdapter(adapter);
    }
    // Check if Google Playservices is installed in Device or not
    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);
        // When Play services not found in device
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                // Show Error dialog to install Play services
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                finish();
            }
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {

        Intent i=new Intent(this,Home.class);
        startActivity(i);
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPlayServices();
    }
}*/
