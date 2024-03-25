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
        Button room331 = findViewById(R.id.room331);
        Button room332 = findViewById(R.id.room332);
        Button room334 = findViewById(R.id.room334);
        Button room336 = findViewById(R.id.room336);
        Button room337 = findViewById(R.id.room337);
        Button room338 = findViewById(R.id.room338);
        Button room339 = findViewById(R.id.room339);
        Button room340 = findViewById(R.id.room340);
        Button room341 = findViewById(R.id.room341);
        Button room342 = findViewById(R.id.room342);
        Button room343 = findViewById(R.id.room343);
        Button room344 = findViewById(R.id.room344);
        Button room345 = findViewById(R.id.room345);
        Button room346 = findViewById(R.id.room346);

        String currentTime = Calendar.getInstance().getTime().toString();
        Log.d("MQTT_Date",currentTime);

        String day = currentTime.substring(0, 3);
        int hour = Integer.parseInt(currentTime.substring(11,13));
        int minute = Integer.parseInt(currentTime.substring(14,16));
        Log.d("MQTT_Date","Day "+day+" Hour "+hour+" Minute "+minute);

            if(day.equals("Sat") || day.equals("Sun") || hour>=23 || (hour==22 && minute>=30) || (hour==20 && minute>=15 && minute<=45) || hour<8 || (hour==8 && minute<30)) {
                room301.setBackgroundColor(getResources().getColor(R.color.red));
                room302.setBackgroundColor(getResources().getColor(R.color.red));
                room303.setBackgroundColor(getResources().getColor(R.color.red));
                room304.setBackgroundColor(getResources().getColor(R.color.red));
                room305.setBackgroundColor(getResources().getColor(R.color.red));
                room306.setBackgroundColor(getResources().getColor(R.color.red));
                room307.setBackgroundColor(getResources().getColor(R.color.red));
                room308.setBackgroundColor(getResources().getColor(R.color.red));
                room309.setBackgroundColor(getResources().getColor(R.color.red));
                room310.setBackgroundColor(getResources().getColor(R.color.red));
                room311.setBackgroundColor(getResources().getColor(R.color.red));
                room312.setBackgroundColor(getResources().getColor(R.color.red));
                room313.setBackgroundColor(getResources().getColor(R.color.red));
                room314.setBackgroundColor(getResources().getColor(R.color.red));
                room317.setBackgroundColor(getResources().getColor(R.color.red));
                room318.setBackgroundColor(getResources().getColor(R.color.red));
                room319.setBackgroundColor(getResources().getColor(R.color.red));
                room320.setBackgroundColor(getResources().getColor(R.color.red));
                room321.setBackgroundColor(getResources().getColor(R.color.red));
                room322.setBackgroundColor(getResources().getColor(R.color.red));
                room323.setBackgroundColor(getResources().getColor(R.color.red));
                room324.setBackgroundColor(getResources().getColor(R.color.red));
                room325.setBackgroundColor(getResources().getColor(R.color.red));
                room326.setBackgroundColor(getResources().getColor(R.color.red));
                room327.setBackgroundColor(getResources().getColor(R.color.red));
                room328.setBackgroundColor(getResources().getColor(R.color.red));
                room329.setBackgroundColor(getResources().getColor(R.color.red));
                room330.setBackgroundColor(getResources().getColor(R.color.red));
                room331.setBackgroundColor(getResources().getColor(R.color.red));
                room332.setBackgroundColor(getResources().getColor(R.color.red));
                room334.setBackgroundColor(getResources().getColor(R.color.red));
                room336.setBackgroundColor(getResources().getColor(R.color.red));
                room337.setBackgroundColor(getResources().getColor(R.color.red));
                room338.setBackgroundColor(getResources().getColor(R.color.red));
                room339.setBackgroundColor(getResources().getColor(R.color.red));
                room340.setBackgroundColor(getResources().getColor(R.color.red));
                room341.setBackgroundColor(getResources().getColor(R.color.red));
                room342.setBackgroundColor(getResources().getColor(R.color.red));
                room343.setBackgroundColor(getResources().getColor(R.color.red));
                room344.setBackgroundColor(getResources().getColor(R.color.red));
                room345.setBackgroundColor(getResources().getColor(R.color.red));
                room346.setBackgroundColor(getResources().getColor(R.color.red));
            }
        else {
                room301.setBackgroundColor(getResources().getColor(R.color.green));
                room302.setBackgroundColor(getResources().getColor(R.color.green));
                room303.setBackgroundColor(getResources().getColor(R.color.green));
                room304.setBackgroundColor(getResources().getColor(R.color.green));
                room305.setBackgroundColor(getResources().getColor(R.color.green));
                room306.setBackgroundColor(getResources().getColor(R.color.green));
                room307.setBackgroundColor(getResources().getColor(R.color.green));
                room308.setBackgroundColor(getResources().getColor(R.color.green));
                room309.setBackgroundColor(getResources().getColor(R.color.green));
                room310.setBackgroundColor(getResources().getColor(R.color.green));
                room311.setBackgroundColor(getResources().getColor(R.color.green));
                room312.setBackgroundColor(getResources().getColor(R.color.green));
                room313.setBackgroundColor(getResources().getColor(R.color.green));
                room314.setBackgroundColor(getResources().getColor(R.color.green));
                room317.setBackgroundColor(getResources().getColor(R.color.green));
                room318.setBackgroundColor(getResources().getColor(R.color.green));
                room319.setBackgroundColor(getResources().getColor(R.color.green));
                room320.setBackgroundColor(getResources().getColor(R.color.green));
                room321.setBackgroundColor(getResources().getColor(R.color.green));
                room322.setBackgroundColor(getResources().getColor(R.color.green));
                room323.setBackgroundColor(getResources().getColor(R.color.green));
                room324.setBackgroundColor(getResources().getColor(R.color.green));
                room325.setBackgroundColor(getResources().getColor(R.color.green));
                room326.setBackgroundColor(getResources().getColor(R.color.green));
                room327.setBackgroundColor(getResources().getColor(R.color.green));
                room328.setBackgroundColor(getResources().getColor(R.color.green));
                room329.setBackgroundColor(getResources().getColor(R.color.green));
                room330.setBackgroundColor(getResources().getColor(R.color.green));
                room331.setBackgroundColor(getResources().getColor(R.color.green));
                room332.setBackgroundColor(getResources().getColor(R.color.green));
                room334.setBackgroundColor(getResources().getColor(R.color.green));
                room336.setBackgroundColor(getResources().getColor(R.color.green));
                room337.setBackgroundColor(getResources().getColor(R.color.green));
                room338.setBackgroundColor(getResources().getColor(R.color.green));
                room339.setBackgroundColor(getResources().getColor(R.color.green));
                room340.setBackgroundColor(getResources().getColor(R.color.green));
                room341.setBackgroundColor(getResources().getColor(R.color.green));
                room342.setBackgroundColor(getResources().getColor(R.color.green));
                room343.setBackgroundColor(getResources().getColor(R.color.green));
                room344.setBackgroundColor(getResources().getColor(R.color.green));
                room345.setBackgroundColor(getResources().getColor(R.color.green));
                room346.setBackgroundColor(getResources().getColor(R.color.green));
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