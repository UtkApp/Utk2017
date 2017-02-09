
package com.nitj.utkansh.utkansh_app;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsTest extends FragmentActivity implements LocationListener {

    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //show error dialog if GoolglePlayServices not available
        if (!isGooglePlayServicesAvailable()) {
            finish();
        }


        GPSCheck();
        setContentView(R.layout.activity_maps);

        settingLayout();

    }

    public void settingLayout()
    {

       // googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();


        googleMap.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
        } else {
            // Show rationale and request permission.
        }
        Location location = locationManager.getLastKnownLocation(bestProvider);


        if (location != null) {
            onLocationChanged(location);
        }


        locationManager.requestLocationUpdates(bestProvider, 20000, 0, this);
        final LatLng pos1 = new LatLng(31.39416,75.53301);
        final LatLng pos2=new LatLng(31.394601,75.533828);
        final LatLng pos3=new LatLng(31.395947,75.534457);
        final LatLng pos4=new LatLng(31.394844,75.535772);
        final LatLng pos5=new LatLng(31.39447283,75.53692013);
        final LatLng pos6=new LatLng(31.395367,75.537210);
        final LatLng pos7=new LatLng(31.39576412,75.53567559);
        final LatLng pos8=new LatLng(31.39586944,75.53287536);
        final LatLng pos9=new LatLng(31.393160,75.536217);
        // final LatLng pos = new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude());






        Marker marker1 = googleMap.addMarker(new MarkerOptions().position(pos1).title("NIT JALANDHAR"));
        Marker marker2 = googleMap.addMarker(new MarkerOptions().position(pos2).title("OAT"));
        Marker marker3 = googleMap.addMarker(new MarkerOptions().position(pos3).title("CSH"));
        Marker marker4 = googleMap.addMarker(new MarkerOptions().position(pos4).title("IT PARK"));
        Marker marker5 = googleMap.addMarker(new MarkerOptions().position(pos5).title("LTC"));
        Marker marker6 = googleMap.addMarker(new MarkerOptions().position(pos6).title("SC-06"));
        Marker marker7 = googleMap.addMarker(new MarkerOptions().position(pos7).title("ECE Building"));
        Marker marker8 = googleMap.addMarker(new MarkerOptions().position(pos8).title("Main Ground"));
        Marker marker9 = googleMap.addMarker(new MarkerOptions().position(pos9).title("Community Center"));


        CameraUpdate location1 = CameraUpdateFactory.newLatLngZoom(pos1, 17);
        CameraUpdate location2 = CameraUpdateFactory.newLatLngZoom(pos2, 17);
        CameraUpdate location3 = CameraUpdateFactory.newLatLngZoom(pos3, 17);
        CameraUpdate location4 = CameraUpdateFactory.newLatLngZoom(pos4, 17);
        CameraUpdate location5 = CameraUpdateFactory.newLatLngZoom(pos5, 17);
        CameraUpdate location6 = CameraUpdateFactory.newLatLngZoom(pos6,17);
        CameraUpdate location7 = CameraUpdateFactory.newLatLngZoom(pos7,17);
        CameraUpdate location8 = CameraUpdateFactory.newLatLngZoom(pos8,17);
        CameraUpdate location9 = CameraUpdateFactory.newLatLngZoom(pos9,17);

        googleMap.animateCamera(location1);
        googleMap.animateCamera(location2);
        googleMap.animateCamera(location3);
        googleMap.animateCamera(location4);
        googleMap.animateCamera(location5);
        googleMap.animateCamera(location6);
        googleMap.animateCamera(location7);
        googleMap.animateCamera(location8);
        googleMap.animateCamera(location9);

    }

    @Override
    public void onLocationChanged(Location location) {

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        LatLng latLng = new LatLng(latitude, longitude);
        googleMap.addMarker(new MarkerOptions().position(latLng));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(20));

    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
    }

    private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (ConnectionResult.SUCCESS == status) {
            return true;
        } else {
            GooglePlayServicesUtil.getErrorDialog(status, this, 0).show();
            return false;
        }
    }



    public void GPSCheck()
    {

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){




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
                        Intent i=new Intent(MapsTest.this,Home.class);
                        startActivity(i);
                        finish();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }


    @Override
    public void onRestart()
    {
        super.onRestart();
        GPSCheck();;
        settingLayout();
    }

}
