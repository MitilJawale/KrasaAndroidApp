package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class procedureList extends AppCompatActivity {
    public void peeling(View view)
    {
        Intent intent=new Intent(getApplicationContext(),peeling.class);
        startActivity(intent);
    }
    public void stretch(View view)
    {
        Intent intent=new Intent(getApplicationContext(),stretch.class);
        startActivity(intent);
    }
    public void hairloss(View view)
    {
        Intent intent=new Intent(getApplicationContext(),hairloss.class);
        startActivity(intent);
    }
    public void tatoo(View view)
    {
        Intent intent=new Intent(getApplicationContext(),tatoo.class);
        startActivity(intent);
    }
    public void laser(View view)
    {
        Intent intent=new Intent(getApplicationContext(),laser.class);
        startActivity(intent);
    }
    public void anti(View view)
    {
        Intent intent=new Intent(getApplicationContext(),anti.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedure_list);
    }
}
