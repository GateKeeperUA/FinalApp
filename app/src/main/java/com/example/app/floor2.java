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
        Button room231 = findViewById(R.id.room231);
        Button room234 = findViewById(R.id.room234);
        Button room235 = findViewById(R.id.room235);
        Button room236 = findViewById(R.id.room236);
        Button room237 = findViewById(R.id.room237);
        Button room238 = findViewById(R.id.room238);
        Button room239 = findViewById(R.id.room239);
        Button room240 = findViewById(R.id.room240);
        Button room241 = findViewById(R.id.room241);
        Button room242 = findViewById(R.id.room242);
        Button room243 = findViewById(R.id.room243);
        Button room244 = findViewById(R.id.room244);
        Button room245 = findViewById(R.id.room245);
        Button room246 = findViewById(R.id.room246);

        String currentTime = Calendar.getInstance().getTime().toString();
        Log.d("MQTT_Date",currentTime);

        String day = currentTime.substring(0, 3);
        int hour = Integer.parseInt(currentTime.substring(11,13));
        int minute = Integer.parseInt(currentTime.substring(14,16));
        Log.d("MQTT_Date","Day "+day+" Hour "+hour+" Minute "+minute);

        if(day.equals("Sat") || day.equals("Sun") || hour>=23 || (hour==22 && minute>=30) || (hour==20 && minute>=15 && minute<=45) || hour<8 || (hour==8 && minute<30)) {
            room201.setBackgroundColor(getResources().getColor(R.color.red));
            room202.setBackgroundColor(getResources().getColor(R.color.red));
            room203.setBackgroundColor(getResources().getColor(R.color.red));
            room204.setBackgroundColor(getResources().getColor(R.color.red));
            room205.setBackgroundColor(getResources().getColor(R.color.red));
            room206.setBackgroundColor(getResources().getColor(R.color.red));
            room207.setBackgroundColor(getResources().getColor(R.color.red));
            room208.setBackgroundColor(getResources().getColor(R.color.red));
            room209.setBackgroundColor(getResources().getColor(R.color.red));
            room210.setBackgroundColor(getResources().getColor(R.color.red));
            room211.setBackgroundColor(getResources().getColor(R.color.red));
            room214.setBackgroundColor(getResources().getColor(R.color.red));
            room215.setBackgroundColor(getResources().getColor(R.color.red));
            room216.setBackgroundColor(getResources().getColor(R.color.red));
            room217.setBackgroundColor(getResources().getColor(R.color.red));
            room218.setBackgroundColor(getResources().getColor(R.color.red));
            room219.setBackgroundColor(getResources().getColor(R.color.red));
            room220.setBackgroundColor(getResources().getColor(R.color.red));
            room221.setBackgroundColor(getResources().getColor(R.color.red));
            room222.setBackgroundColor(getResources().getColor(R.color.red));
            room223.setBackgroundColor(getResources().getColor(R.color.red));
            room224.setBackgroundColor(getResources().getColor(R.color.red));
            room225.setBackgroundColor(getResources().getColor(R.color.red));
            room226.setBackgroundColor(getResources().getColor(R.color.red));
            room227.setBackgroundColor(getResources().getColor(R.color.red));
            room228.setBackgroundColor(getResources().getColor(R.color.red));
            room229.setBackgroundColor(getResources().getColor(R.color.red));
            room230.setBackgroundColor(getResources().getColor(R.color.red));
            room231.setBackgroundColor(getResources().getColor(R.color.red));
            room234.setBackgroundColor(getResources().getColor(R.color.red));
            room235.setBackgroundColor(getResources().getColor(R.color.red));
            room236.setBackgroundColor(getResources().getColor(R.color.red));
            room237.setBackgroundColor(getResources().getColor(R.color.red));
            room238.setBackgroundColor(getResources().getColor(R.color.red));
            room239.setBackgroundColor(getResources().getColor(R.color.red));
            room240.setBackgroundColor(getResources().getColor(R.color.red));
            room241.setBackgroundColor(getResources().getColor(R.color.red));
            room242.setBackgroundColor(getResources().getColor(R.color.red));
            room243.setBackgroundColor(getResources().getColor(R.color.red));
            room244.setBackgroundColor(getResources().getColor(R.color.red));
            room245.setBackgroundColor(getResources().getColor(R.color.red));
            room246.setBackgroundColor(getResources().getColor(R.color.red));
        }
        else {
            room201.setBackgroundColor(getResources().getColor(R.color.green));
            room202.setBackgroundColor(getResources().getColor(R.color.green));
            room203.setBackgroundColor(getResources().getColor(R.color.green));
            room204.setBackgroundColor(getResources().getColor(R.color.green));
            room205.setBackgroundColor(getResources().getColor(R.color.green));
            room206.setBackgroundColor(getResources().getColor(R.color.green));
            room207.setBackgroundColor(getResources().getColor(R.color.green));
            room208.setBackgroundColor(getResources().getColor(R.color.green));
            room209.setBackgroundColor(getResources().getColor(R.color.green));
            room210.setBackgroundColor(getResources().getColor(R.color.green));
            room211.setBackgroundColor(getResources().getColor(R.color.green));
            room214.setBackgroundColor(getResources().getColor(R.color.green));
            room215.setBackgroundColor(getResources().getColor(R.color.green));
            room216.setBackgroundColor(getResources().getColor(R.color.green));
            room217.setBackgroundColor(getResources().getColor(R.color.green));
            room218.setBackgroundColor(getResources().getColor(R.color.green));
            room219.setBackgroundColor(getResources().getColor(R.color.green));
            room220.setBackgroundColor(getResources().getColor(R.color.green));
            room221.setBackgroundColor(getResources().getColor(R.color.green));
            room222.setBackgroundColor(getResources().getColor(R.color.green));
            room223.setBackgroundColor(getResources().getColor(R.color.green));
            room224.setBackgroundColor(getResources().getColor(R.color.green));
            room225.setBackgroundColor(getResources().getColor(R.color.green));
            room226.setBackgroundColor(getResources().getColor(R.color.green));
            room227.setBackgroundColor(getResources().getColor(R.color.green));
            room228.setBackgroundColor(getResources().getColor(R.color.green));
            room229.setBackgroundColor(getResources().getColor(R.color.green));
            room230.setBackgroundColor(getResources().getColor(R.color.green));
            room231.setBackgroundColor(getResources().getColor(R.color.green));
            room234.setBackgroundColor(getResources().getColor(R.color.green));
            room235.setBackgroundColor(getResources().getColor(R.color.green));
            room236.setBackgroundColor(getResources().getColor(R.color.green));
            room237.setBackgroundColor(getResources().getColor(R.color.green));
            room238.setBackgroundColor(getResources().getColor(R.color.green));
            room239.setBackgroundColor(getResources().getColor(R.color.green));
            room240.setBackgroundColor(getResources().getColor(R.color.green));
            room241.setBackgroundColor(getResources().getColor(R.color.green));
            room242.setBackgroundColor(getResources().getColor(R.color.green));
            room243.setBackgroundColor(getResources().getColor(R.color.green));
            room244.setBackgroundColor(getResources().getColor(R.color.green));
            room245.setBackgroundColor(getResources().getColor(R.color.green));
            room246.setBackgroundColor(getResources().getColor(R.color.green));
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