package com.example.app;

import static com.example.app.MainActivity.last_floor;
import static com.example.app.MainActivity.room;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class floor3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor3);


        Button room301 = findViewById(R.id.room301);
        Button room302 = findViewById(R.id.room302);
        Button room303 = findViewById(R.id.room303);
        Button room304 = findViewById(R.id.room304);
        Button room305 = findViewById(R.id.room305);
        Button room306 = findViewById(R.id.room306);
        Button room307 = findViewById(R.id.room307);
        Button room308 = findViewById(R.id.room308);
        Button room309 = findViewById(R.id.room309);
        Button room310 = findViewById(R.id.room310);
        Button room311 = findViewById(R.id.room311);
        Button room312 = findViewById(R.id.room312);
        Button room313 = findViewById(R.id.room313);
        Button room314 = findViewById(R.id.room314);
        Button room315 = findViewById(R.id.room315);
        Button room316 = findViewById(R.id.room316);
        Button room317 = findViewById(R.id.room317);
        Button room318 = findViewById(R.id.room318);
        Button room319 = findViewById(R.id.room319);
        Button room320 = findViewById(R.id.room320);
        Button room321 = findViewById(R.id.room321);
        Button room322 = findViewById(R.id.room322);
        Button room323 = findViewById(R.id.room323);
        Button room324 = findViewById(R.id.room324);
        Button room325 = findViewById(R.id.room325);
        Button room326 = findViewById(R.id.room326);
        Button room327 = findViewById(R.id.room327);
        Button room328 = findViewById(R.id.room328);
        Button room329 = findViewById(R.id.room329);
        Button room330 = findViewById(R.id.room330);
        //Button room331 = findViewById(R.id.room331);
        //Button room332 = findViewById(R.id.room332);
        //Button room333 = findViewById(R.id.room333);
        //Button room334 = findViewById(R.id.room334);
        //Button room335 = findViewById(R.id.room335);
        //Button room336 = findViewById(R.id.room336);
        //Button room337 = findViewById(R.id.room337);
        //Button room338 = findViewById(R.id.room338);
        //Button room339 = findViewById(R.id.room339);
        //Button room340 = findViewById(R.id.room340);
        //Button room341 = findViewById(R.id.room341);
        //Button room342 = findViewById(R.id.room342);
        //Button room343 = findViewById(R.id.room343);
        //Button room344 = findViewById(R.id.room344);
        //Button room345 = findViewById(R.id.room345);

        String currentTime = Calendar.getInstance().getTime().toString();
        Log.d("MQTT_Date",currentTime);

        String day = currentTime.substring(0, 3);
        int hour = Integer.parseInt(currentTime.substring(11,13));
        int minute = Integer.parseInt(currentTime.substring(14,16));
        Log.d("MQTT_Date","Day "+day+" Hour "+hour+" Minute "+minute);

            if(day.equals("Sat") || day.equals("Sun") || hour>=23 || (hour==22 && minute>=30) || (hour==20 && minute>=15 && minute<=45) || hour<8 || (hour==8 && minute<30)) {
            room301.setBackgroundColor(Color.RED);
            room302.setBackgroundColor(Color.RED);
            room303.setBackgroundColor(Color.RED);
            room304.setBackgroundColor(Color.RED);
            room305.setBackgroundColor(Color.RED);
            room306.setBackgroundColor(Color.RED);
            room307.setBackgroundColor(Color.RED);
            room308.setBackgroundColor(Color.RED);
            room309.setBackgroundColor(Color.RED);
            room310.setBackgroundColor(Color.RED);
            room311.setBackgroundColor(Color.RED);
            room312.setBackgroundColor(Color.RED);
            room313.setBackgroundColor(Color.RED);
            room314.setBackgroundColor(Color.RED);
            room315.setBackgroundColor(Color.RED);
            room316.setBackgroundColor(Color.RED);
            room317.setBackgroundColor(Color.RED);
            room318.setBackgroundColor(Color.RED);
            room319.setBackgroundColor(Color.RED);
            room320.setBackgroundColor(Color.RED);
            room321.setBackgroundColor(Color.RED);
            room322.setBackgroundColor(Color.RED);
            room323.setBackgroundColor(Color.RED);
            room324.setBackgroundColor(Color.RED);
            room325.setBackgroundColor(Color.RED);
            room326.setBackgroundColor(Color.RED);
            room327.setBackgroundColor(Color.RED);
            room328.setBackgroundColor(Color.RED);
            room329.setBackgroundColor(Color.RED);
            room330.setBackgroundColor(Color.RED);
            //room331.setBackgroundColor(Color.RED);
            //room332.setBackgroundColor(Color.RED);
            //room333.setBackgroundColor(Color.RED);
            //room334.setBackgroundColor(Color.RED);
            //room335.setBackgroundColor(Color.RED);
            //room336.setBackgroundColor(Color.RED);
            //room337.setBackgroundColor(Color.RED);
            //room338.setBackgroundColor(Color.RED);
            //room339.setBackgroundColor(Color.RED);
            //room340.setBackgroundColor(Color.RED);
            //room341.setBackgroundColor(Color.RED);
            //room342.setBackgroundColor(Color.RED);
            //room343.setBackgroundColor(Color.RED);
            //room344.setBackgroundColor(Color.RED);
            //room345.setBackgroundColor(Color.RED);

        }
        else {
            room301.setBackgroundColor(Color.GREEN);
            room302.setBackgroundColor(Color.GREEN);
            room303.setBackgroundColor(Color.GREEN);
            room304.setBackgroundColor(Color.GREEN);
            room305.setBackgroundColor(Color.GREEN);
            room306.setBackgroundColor(Color.GREEN);
            room307.setBackgroundColor(Color.GREEN);
            room308.setBackgroundColor(Color.GREEN);
            room309.setBackgroundColor(Color.GREEN);
            room310.setBackgroundColor(Color.GREEN);
            room311.setBackgroundColor(Color.GREEN);
            room312.setBackgroundColor(Color.GREEN);
            room313.setBackgroundColor(Color.GREEN);
            room314.setBackgroundColor(Color.GREEN);
            room315.setBackgroundColor(Color.GREEN);
            room316.setBackgroundColor(Color.GREEN);
            room317.setBackgroundColor(Color.GREEN);
            room318.setBackgroundColor(Color.GREEN);
            room319.setBackgroundColor(Color.GREEN);
            room320.setBackgroundColor(Color.GREEN);
            room321.setBackgroundColor(Color.GREEN);
            room322.setBackgroundColor(Color.GREEN);
            room323.setBackgroundColor(Color.GREEN);
            room324.setBackgroundColor(Color.GREEN);
            room325.setBackgroundColor(Color.GREEN);
            room326.setBackgroundColor(Color.GREEN);
            room327.setBackgroundColor(Color.GREEN);
            room328.setBackgroundColor(Color.GREEN);
            room329.setBackgroundColor(Color.GREEN);
            room330.setBackgroundColor(Color.GREEN);
            //room331.setBackgroundColor(Color.GREEN);
            //room332.setBackgroundColor(Color.GREEN);
            //room333.setBackgroundColor(Color.GREEN);
            //room334.setBackgroundColor(Color.GREEN);
            //room335.setBackgroundColor(Color.GREEN);
            //room336.setBackgroundColor(Color.GREEN);
            //room337.setBackgroundColor(Color.GREEN);
            //room338.setBackgroundColor(Color.GREEN);
            //room339.setBackgroundColor(Color.GREEN);
            //room340.setBackgroundColor(Color.GREEN);
            //room341.setBackgroundColor(Color.GREEN);
            //room342.setBackgroundColor(Color.GREEN);
            //room343.setBackgroundColor(Color.GREEN);
            //room344.setBackgroundColor(Color.GREEN);
            //room345.setBackgroundColor(Color.GREEN);

        }

    }

    public void backmain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void enterRoom(View v) {
        // Identifica qual botão foi clicado
        String id = v.getResources().getResourceEntryName(v.getId());
        last_floor = 3;

        Intent intent = new Intent(this, Rooms.class);
        startActivity(intent);
        room = id;
        Log.d("MQTT_Rooms", id);
    }
}