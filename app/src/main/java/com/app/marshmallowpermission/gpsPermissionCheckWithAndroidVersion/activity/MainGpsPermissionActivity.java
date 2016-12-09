package com.app.marshmallowpermission.gpsPermissionCheckWithAndroidVersion.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.marshmallowpermission.R;
import com.app.marshmallowpermission.gpsPermissionCheckWithAndroidVersion.TryPermissionCheckSecond.MainPermissionCheckSecondActivity;

public class MainGpsPermissionActivity extends AppCompatActivity {

    private Button mBtnStartService, mBtnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gps_permission);

        mBtnStartService = (Button) findViewById(R.id.idBtnGpsPermissionCheck_StartService);
        mBtnStopService = (Button) findViewById(R.id.idBtnGpsPermissionCheck_StopService);

        mBtnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (gpsPermissonFineLocation()) {


                    Toast.makeText(MainGpsPermissionActivity.this, "You already have the permission", Toast.LENGTH_LONG).show();
                    return;

                }


                requestFineLocationPermission();
            }
        });

        mBtnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    private void requestFineLocationPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {


            Toast.makeText(MainGpsPermissionActivity.this, "This Permission Require to get your location ", Toast.LENGTH_LONG).show();
        }

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 2);


    }

    private boolean gpsPermissonFineLocation() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (result == PackageManager.PERMISSION_GRANTED)
            return true;

        return false;


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        if (requestCode == 2) {

            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                //Displaying a toast
                Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }

}
