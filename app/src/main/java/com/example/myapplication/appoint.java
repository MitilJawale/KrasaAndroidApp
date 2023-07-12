package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class appoint extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Button dateButton, timeButton, bookbtn;
    TextView dateTextView, timeTextView;
    DatabaseReference objectDatabaseReference;
    EditText nameView,numberView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoint);

        dateButton = findViewById(R.id.dateButton);
        timeButton = findViewById(R.id.timeButton);
        bookbtn = findViewById(R.id.bookButton);
        dateTextView = findViewById(R.id.dateTextView);
        nameView = findViewById(R.id.nameText2);
        numberView = findViewById(R.id.numberText2);


        timeTextView = findViewById(R.id.timeTextView);
        objectDatabaseReference = FirebaseDatabase.getInstance().getReference("appointment");

        bookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookappointment();
            }
        });

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleDateButton();
            }
        });
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleTimeButton();
            }
        });



    }

    String dateText;
    private void handleDateButton() {
        Calendar calendar = Calendar.getInstance();
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR, year);
                calendar1.set(Calendar.MONTH, month);
                calendar1.set(Calendar.DATE, date);
                dateText = DateFormat.format("EEEE, MMM d, yyyy", calendar1).toString();

                dateTextView.setText(dateText);
            }
        }, YEAR, MONTH, DATE);

        datePickerDialog.show();




    }
    String dateTime;
    private void handleTimeButton() {
        Calendar calendar = Calendar.getInstance();
        int HOUR = calendar.get(Calendar.HOUR);
        int MINUTE = calendar.get(Calendar.MINUTE);
        boolean is24HourFormat = DateFormat.is24HourFormat(this);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                Log.i(TAG, "onTimeSet: " + hour + minute);
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.HOUR, hour);
                calendar1.set(Calendar.MINUTE, minute);
                dateTime = DateFormat.format("h:mm a", calendar1).toString();
                timeTextView.setText(dateTime);
            }
        }, HOUR, MINUTE, is24HourFormat);

        timePickerDialog.show();

    }
    private void bookappointment(){
        if(!TextUtils.isEmpty(dateText)) {
            String id =  objectDatabaseReference.push().getKey();
            Upload upload = new Upload(id,dateText,dateTime,nameView.getText().toString(),numberView.getText().toString());
            objectDatabaseReference.child(id).setValue(upload);
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            Toast.makeText(this,"Appointment booked Successfully",Toast.LENGTH_LONG).show();


        }else
        {
            Toast.makeText(this,"Fill all",Toast.LENGTH_LONG).show();

        }

    }



}

