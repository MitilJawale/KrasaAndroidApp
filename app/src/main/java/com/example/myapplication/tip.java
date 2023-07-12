package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class tip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);
        ListView mylistview = findViewById(R.id.mylistView);
        ArrayList<String> myfamily=new ArrayList<String>();
        myfamily.add("Protect your skin from the sun every day.");
        myfamily.add("Apply self-tanner rather than get a tan.");
        myfamily.add("If you smoke, stop.");
        myfamily.add("Avoid repetitive facial expressions. ");
        myfamily.add("Eat a healthy, well-balanced diet.");
        myfamily.add("Drink less alcohol.");
        myfamily.add("Exercise most days of the week");
        myfamily.add("Cleanse your skin gently.");
        myfamily.add("Scrubbing your skin clean can irritate your skin.Never do that.");
        myfamily.add("Wash your face twice a day and after sweating heavily. ");
        myfamily.add("Apply a facial moisturizer every day.");
        myfamily.add("Stop using skin care products that sting or burn. ");
        myfamily.add(" Wearing sunglasses can help reduce lines caused by squinting.");
        myfamily.add("Harmful UV rays that accelerate how quickly your skin ages.Sunscreen is must.");
        myfamily.add("Finding healthy ways to manage stress can help your skin, too.");
        myfamily.add("Resist the urge to scrub your skin clean.");
        myfamily.add("Touch wood but check your skin for skin cancer.");
        myfamily.add("And finally if nothing goes right visit your dermatologist if you dislike something about your skin.");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myfamily);
        mylistview.setAdapter(arrayAdapter);


    }
}
