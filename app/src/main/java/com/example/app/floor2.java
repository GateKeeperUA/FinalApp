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

public class floor2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor2);

        Button room201 = findViewById(R.id.room201);
        Button room202 = findViewById(R.id.room202);
        Button room203 = findViewById(R.id.room203);
        Button room204 = findViewById(R.id.room204);
        Button room205 = findViewById(R.id.room205);
        Button room206 = findViewById(R.id.room206);
        Button room207 = findViewById(R.id.room207);
        Button room208 = findViewById(R.id.room208);
        Button room209 = findViewById(R.id.room209);
        Button room210 = findViewById(R.id.room210);
        Button room211 = findViewById(R.id.room211);
        Button room212 = findViewById(R.id.room212);
        Button room213 = findViewById(R.id.room213);
        Button room214 = findViewById(R.id.room214);
        Button room215 = findViewById(R.id.room215);
        Button room216 = findViewById(R.id.room216);
        Button room217 = findViewById(R.id.room217);
        Button room218 = findViewById(R.id.room218);
        Button room219 = findViewById(R.id.room219);
        Button room220 = findViewById(R.id.room220);
        Button room221 = findViewById(R.id.room221);
        Button room222 = findViewById(R.id.room222);
        Button room223 = findViewById(R.id.room223);
        Button room224 = findViewById(R.id.room224);
        Button room225 = findViewById(R.id.room225);
        Button room226 = findViewById(R.id.room226);
        Button room227 = findViewById(R.id.room227);
        Button room228 = findViewById(R.id.room228);
        Button room229 = findViewById(R.id.room229);
        Button room230 = findViewById(R.id.room230);
        //Button room231 = findViewById(R.id.room231);
        //Button room232 = findViewById(R.id.room232);
        //Button room233 = findViewById(R.id.room233);
        //Button room234 = findViewById(R.id.room234);
        //Button room235 = findViewById(R.id.room235);
        //Button room236 = findViewById(R.id.room236);
        //Button room237 = findViewById(R.id.room237);
        //Button room238 = findViewById(R.id.room238);
        //Button room239 = findViewById(R.id.room239);
        //Button room240 = findViewById(R.id.room240);
        //Button room241 = findViewById(R.id.room241);
        //Button room242 = findViewById(R.id.room242);
        //Button room243 = findViewById(R.id.room243);
        //Button room244 = findViewById(R.id.room244);
        //Button room245 = findViewById(R.id.room245);

        String currentTime = Calendar.getInstance().getTime().toString();
        Log.d("MQTT_Date",currentTime);

        String day = currentTime.substring(0, 3);
        int hour = Integer.parseInt(currentTime.substring(11,13));
        int minute = Integer.parseInt(currentTime.substring(14,16));
        Log.d("MQTT_Date","Day "+day+" Hour "+hour+" Minute "+minute);

        if(day.equals("Sat") || day.equals("Sun") || hour>=23 || (hour==22 && minute>=30) || (hour==20 && minute>=15 && minute<=45) || hour<8 || (hour==8 && minute<30)) {
            room201.setBackgroundColor(Color.RED);
            room202.setBackgroundColor(Color.RED);
            room203.setBackgroundColor(Color.RED);
            room204.setBackgroundColor(Color.RED);
            room205.setBackgroundColor(Color.RED);
            room206.setBackgroundColor(Color.RED);
            room207.setBackgroundColor(Color.RED);
            room208.setBackgroundColor(Color.RED);
            room209.setBackgroundColor(Color.RED);
            room210.setBackgroundColor(Color.RED);
            room211.setBackgroundColor(Color.RED);
            room212.setBackgroundColor(Color.RED);
            room213.setBackgroundColor(Color.RED);
            room214.setBackgroundColor(Color.RED);
            room215.setBackgroundColor(Color.RED);
            room216.setBackgroundColor(Color.RED);
            room217.setBackgroundColor(Color.RED);
            room218.setBackgroundColor(Color.RED);
            room219.setBackgroundColor(Color.RED);
            room220.setBackgroundColor(Color.RED);
            room221.setBackgroundColor(Color.RED);
            room222.setBackgroundColor(Color.RED);
            room223.setBackgroundColor(Color.RED);
            room224.setBackgroundColor(Color.RED);
            room225.setBackgroundColor(Color.RED);
            room226.setBackgroundColor(Color.RED);
            room227.setBackgroundColor(Color.RED);
            room228.setBackgroundColor(Color.RED);
            room229.setBackgroundColor(Color.RED);
            room230.setBackgroundColor(Color.RED);
            //room231.setBackgroundColor(Color.RED);
            //room232.setBackgroundColor(Color.RED);
            //room233.setBackgroundColor(Color.RED);
            //room234.setBackgroundColor(Color.RED);
            //room235.setBackgroundColor(Color.RED);
            //room236.setBackgroundColor(Color.RED);
            //room237.setBackgroundColor(Color.RED);
            //room238.setBackgroundColor(Color.RED);
            //room239.setBackgroundColor(Color.RED);
            //room240.setBackgroundColor(Color.RED);
            //room241.setBackgroundColor(Color.RED);
            //room242.setBackgroundColor(Color.RED);
            //room243.setBackgroundColor(Color.RED);
            //room244.setBackgroundColor(Color.RED);
            //room245.setBackgroundColor(Color.RED);
        }
        else {
            room201.setBackgroundColor(Color.GREEN);
            room202.setBackgroundColor(Color.GREEN);
            room203.setBackgroundColor(Color.GREEN);
            room204.setBackgroundColor(Color.GREEN);
            room205.setBackgroundColor(Color.GREEN);
            room206.setBackgroundColor(Color.GREEN);
            room207.setBackgroundColor(Color.GREEN);
            room208.setBackgroundColor(Color.GREEN);
            room209.setBackgroundColor(Color.GREEN);
            room210.setBackgroundColor(Color.GREEN);
            room211.setBackgroundColor(Color.GREEN);
            room212.setBackgroundColor(Color.GREEN);
            room213.setBackgroundColor(Color.GREEN);
            room214.setBackgroundColor(Color.GREEN);
            room215.setBackgroundColor(Color.GREEN);
            room216.setBackgroundColor(Color.GREEN);
            room217.setBackgroundColor(Color.GREEN);
            room218.setBackgroundColor(Color.GREEN);
            room219.setBackgroundColor(Color.GREEN);
            room220.setBackgroundColor(Color.GREEN);
            room221.setBackgroundColor(Color.GREEN);
            room222.setBackgroundColor(Color.GREEN);
            room223.setBackgroundColor(Color.GREEN);
            room224.setBackgroundColor(Color.GREEN);
            room225.setBackgroundColor(Color.GREEN);
            room226.setBackgroundColor(Color.GREEN);
            room227.setBackgroundColor(Color.GREEN);
            room228.setBackgroundColor(Color.GREEN);
            room229.setBackgroundColor(Color.GREEN);
            room230.setBackgroundColor(Color.GREEN);
            //room231.setBackgroundColor(Color.GREEN);
            //room232.setBackgroundColor(Color.GREEN);
            //room233.setBackgroundColor(Color.GREEN);
            //room234.setBackgroundColor(Color.GREEN);
            //room235.setBackgroundColor(Color.GREEN);
            //room236.setBackgroundColor(Color.GREEN);
            //room237.setBackgroundColor(Color.GREEN);
            //room238.setBackgroundColor(Color.GREEN);
            //room239.setBackgroundColor(Color.GREEN);
            //room240.setBackgroundColor(Color.GREEN);
            //room241.setBackgroundColor(Color.GREEN);
            //room242.setBackgroundColor(Color.GREEN);
            //room243.setBackgroundColor(Color.GREEN);
            //room244.setBackgroundColor(Color.GREEN);
            //room245.setBackgroundColor(Color.GREEN);
        }
    }

    public void backmain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void enterRoom(View v) {
        // Identifica qual botão foi clicado
        String id = v.getResources().getResourceEntryName(v.getId());
        last_floor = 2;

        Intent intent = new Intent(this, Rooms.class);
        startActivity(intent);
        room = id;
        Log.d("MQTT_Rooms", id);
    }
}