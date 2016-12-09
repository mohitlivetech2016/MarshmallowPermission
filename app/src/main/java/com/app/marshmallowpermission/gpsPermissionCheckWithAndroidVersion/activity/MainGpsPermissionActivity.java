package com.app.marshmallowpermission.gpsPermissionCheckWithAndroidVersion.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.app.marshmallowpermission.R;

public class MainGpsPermissionActivity extends AppCompatActivity {

    private Button mBtnStartService,mBtnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gps_permission);

        mBtnStartService=(Button)findViewById(R.id.idBtnGpsPermissionCheck_StartService);
        mBtnStopService=(Button)findViewById(R.id.idBtnGpsPermissionCheck_StopService);

        mBtnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        mBtnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });








    }

}
