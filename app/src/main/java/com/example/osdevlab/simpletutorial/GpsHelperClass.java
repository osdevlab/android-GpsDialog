package com.example.osdevlab.simpletutorial;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;

/**
 * Created by osdevlab on 1/1/15.
 */

//we need to first implements LocationListener
//Four functions will be provided by IDE when implements LocationListener and we have to override those functions.
//For now, we don't need to override those functions yet.

public class GpsHelperClass implements LocationListener {

    protected LocationManager locationManager;
    Context context;

    //at constructor, context is passed from FragmentOne.java and context will be used by GpsHelperClass throughout.
    public GpsHelperClass(Context context) {
        this.context = context;
    }

    public boolean isGpsReadyToUse() {
        //this.context.getSystemService is required if we want to use in separate class
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            //We cannot enable GPS via program.
            //Still need user input to enable for good reason.
            getUserInputToEnableGPS();
        }

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    private void getUserInputToEnableGPS() {
        //Ref from http://www.androidhive.info/2012/07/android-gps-location-manager-tutorial
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("GPS is settings");

        // Setting Dialog Message
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                //Settings.ACTION_LOCATION_SOURCE_SETTINGS == Activity Action: Show settings to allow configuration of current location sources.
                // The Settings provider contains global system-level device preferences.
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);

                //Every Activity is invoked by an Intent. therefore, we are going to start activity which allow to set location
                context.startActivity(intent);
            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
