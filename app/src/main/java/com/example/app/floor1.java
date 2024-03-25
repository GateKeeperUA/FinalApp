package com.example.app;

import static com.example.app.MainActivity.last_floor;
import static com.example.app.MainActivity.room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class floor1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor1);

        Button room101 = findViewById(R.id.room101);
        Button room102 = findViewById(R.id.room102);
        Button room103 = findViewById(R.id.room103);
        Button room104 = findViewById(R.id.room104);
        Button room105 = findViewById(R.id.room105);
        Button room106 = findViewById(R.id.room106);
        Button room107 = findViewById(R.id.room107);
        Button room108 = findViewById(R.id.room108);
        Button room109 = findViewById(R.id.room109);
        Button room110 = findViewById(R.id.room110);
        Button room111 = findViewById(R.id.room111);
        Button room114 = findViewById(R.id.room114);
        Button room115 = findViewById(R.id.room115);
        Button room116 = findViewById(R.id.room116);
        Button room117 = findViewById(R.id.room117);
        Button room118 = findViewById(R.id.room118);
        Button room119 = findViewById(R.id.room119);
        Button room120 = findViewById(R.id.room120);
        Button room121 = findViewById(R.id.room121);
        Button room122 = findViewById(R.id.room122);
        Button room123 = findViewById(R.id.room123);
        Button room124 = findViewById(R.id.room124);
        Button room125 = findViewById(R.id.room125);
        Button room126 = findViewById(R.id.room126);
        Button room127 = findViewById(R.id.room127);
        Button room128 = findViewById(R.id.room128);
        Button room129 = findViewById(R.id.room129);
        Button room130 = findViewById(R.id.room130);

        String currentTime = Calendar.getInstance().getTime().toString();
        Log.d("MQTT_Date",currentTime);

        String day = currentTime.substring(0, 3);
        int hour = Integer.parseInt(currentTime.substring(11,13));
        int minute = Integer.parseInt(currentTime.substring(14,16));
        Log.d("MQTT_Date","Day "+day+" Hour "+hour+" Minute "+minute);

        if(day.equals("Sat") || day.equals("Sun") || hour>=23 || (hour==22 && minute>=30) || (hour==20 && minute>=15 && minute<=45) || hour<8 || (hour==8 && minute<30)) {
            room101.setBackgroundColor(getResources().getColor(R.color.red));
            room102.setBackgroundColor(getResources().getColor(R.color.red));
            room103.setBackgroundColor(getResources().getColor(R.color.red));
            room104.setBackgroundColor(getResources().getColor(R.color.red));
            room105.setBackgroundColor(getResources().getColor(R.color.red));
            room106.setBackgroundColor(getResources().getColor(R.color.red));
            room107.setBackgroundColor(getResources().getColor(R.color.red));
            room108.setBackgroundColor(getResources().getColor(R.color.red));
            room109.setBackgroundColor(getResources().getColor(R.color.red));
            room110.setBackgroundColor(getResources().getColor(R.color.red));
            room111.setBackgroundColor(getResources().getColor(R.color.red));
            room114.setBackgroundColor(getResources().getColor(R.color.red));
            room115.setBackgroundColor(getResources().getColor(R.color.red));
            room116.setBackgroundColor(getResources().getColor(R.color.red));
            room117.setBackgroundColor(getResources().getColor(R.color.red));
            room117.setBackgroundColor(getResources().getColor(R.color.azure));
            room118.setBackgroundColor(getResources().getColor(R.color.azure));
            room119.setBackgroundColor(getResources().getColor(R.color.azure));
            room120.setBackgroundColor(getResources().getColor(R.color.azure));
            room121.setBackgroundColor(getResources().getColor(R.color.azure));
            room122.setBackgroundColor(getResources().getColor(R.color.azure));
            room123.setBackgroundColor(getResources().getColor(R.color.azure));
            room124.setBackgroundColor(getResources().getColor(R.color.azure));
            room125.setBackgroundColor(getResources().getColor(R.color.azure));
            room126.setBackgroundColor(getResources().getColor(R.color.azure));
            room127.setBackgroundColor(getResources().getColor(R.color.azure));
            room128.setBackgroundColor(getResources().getColor(R.color.azure));
            room129.setBackgroundColor(getResources().getColor(R.color.azure));
            room130.setBackgroundColor(getResources().getColor(R.color.azure));


        }
        else {
            room101.setBackgroundColor(getResources().getColor(R.color.green));
            room102.setBackgroundColor(getResources().getColor(R.color.green));
            room103.setBackgroundColor(getResources().getColor(R.color.green));
            room104.setBackgroundColor(getResources().getColor(R.color.green));
            room105.setBackgroundColor(getResources().getColor(R.color.green));
            room106.setBackgroundColor(getResources().getColor(R.color.green));
            room107.setBackgroundColor(getResources().getColor(R.color.green));
            room108.setBackgroundColor(getResources().getColor(R.color.green));
            room109.setBackgroundColor(getResources().getColor(R.color.green));
            room110.setBackgroundColor(getResources().getColor(R.color.green));
            room111.setBackgroundColor(getResources().getColor(R.color.green));
            room114.setBackgroundColor(getResources().getColor(R.color.green));
            room115.setBackgroundColor(getResources().getColor(R.color.green));
            room116.setBackgroundColor(getResources().getColor(R.color.green));
            room117.setBackgroundColor(getResources().getColor(R.color.green));
            room118.setBackgroundColor(getResources().getColor(R.color.green));
            room119.setBackgroundColor(getResources().getColor(R.color.green));
            room120.setBackgroundColor(getResources().getColor(R.color.green));
            room121.setBackgroundColor(getResources().getColor(R.color.green));
            room122.setBackgroundColor(getResources().getColor(R.color.green));
            room123.setBackgroundColor(getResources().getColor(R.color.green));
            room124.setBackgroundColor(getResources().getColor(R.color.green));
            room125.setBackgroundColor(getResources().getColor(R.color.green));
            room126.setBackgroundColor(getResources().getColor(R.color.green));
            room127.setBackgroundColor(getResources().getColor(R.color.green));
            room128.setBackgroundColor(getResources().getColor(R.color.green));
            room129.setBackgroundColor(getResources().getColor(R.color.green));
            room130.setBackgroundColor(getResources().getColor(R.color.green));
        }
    }


    public void backmain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void enterRoom(View v) {
        // Identifica qual botão foi clicado
        String id = v.getResources().getResourceEntryName(v.getId());
        last_floor = 1;

        Intent intent = new Intent(this, Rooms.class);
        startActivity(intent);
        room = id;
        Log.d("MQTT_Rooms", id);
    }
}