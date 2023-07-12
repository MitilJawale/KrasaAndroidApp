package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //private static int SPLASH_TIME_OUT = 4000;
    Button procedure,medicalHistory,Map,aboutDoctor,appointment,careTips;

    public void proced(View view)
    {
        Intent intent=new Intent(getApplicationContext(),procedureList.class);
        startActivity(intent);
    }
    public void tip(View view)
    {
        Intent intent=new Intent(getApplicationContext(),tip.class);
        startActivity(intent);
    }

    public void aboutDoctor(View view)
    {
        Intent intent = new Intent(getApplicationContext(),aboutDoctor.class);
        startActivity(intent);
    }
    public void appointmentmethod(View view)
    {
        Intent intent=new Intent(getApplicationContext(),appoint.class);
        startActivity(intent);
    }

    public void mapmethod(View view)
    {
        Intent intent=new Intent(getApplicationContext(),MapsActivity2.class);
        startActivity(intent);
    }
    public void historymethod(View view)
    {
        Intent intent=new Intent(getApplicationContext(),medicalhistory.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //BELOW CODE IS FOR SPLASH SCREEN
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, Login.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);*/


        procedure=(Button)findViewById(R.id.procedureButton);
        medicalHistory=(Button)findViewById(R.id.medicalHistoryButton);
        Map=(Button)findViewById(R.id.mapButton);
        aboutDoctor=(Button)findViewById(R.id.aboutDoctorButton);
         appointment=(Button)findViewById(R.id.appointment);
        careTips=(Button)findViewById(R.id.tipsButton);



    }
}
