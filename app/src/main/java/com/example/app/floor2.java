package com.example.app;

import static com.example.app.MainActivity.room;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class floor2 extends AppCompatActivity {

    ImageButton button;
    boolean view=true;
    boolean open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor2);
        button = findViewById(R.id.toggle);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(view) {
                    setContentView(R.layout.activity_map1);
                    view = false;

                    ImageView imageView = findViewById(R.id.imageView);
                    if(open) {
                        imageView.setImageResource(R.drawable.floor_two_open);
                    }
                    else {
                        imageView.setImageResource(R.drawable.floor_two_closed);
                    }

                    button = findViewById(R.id.toggle);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (view) {
                                setContentView(R.layout.activity_map2);
                            } else {
                                recreate();
                            }
                        }
                    });
                }
            }
        });


        Button room201 = findViewById(R.id.room201);
        Button room202 = findViewById(R.id.room202);
        Button room203 = findViewById(R.id.room203);
        Button room204 = findViewById(R.id.room204);
        Button room205 = findViewById(R.id.room205);
        Button room206 = findViewById(R.id.room206);
        Button room207 = findViewById(R.id.room207);
        Button room208 = findViewById(R.id.room208);
        Button room211 = findViewById(R.id.room211);
        Button room214 = findViewById(R.id.room214);
        Button room215 = findViewById(R.id.room215);
        Button room216 = findViewById(R.id.room216);
        Button room217 = findViewById(R.id.room217);
        Button room220 = findViewById(R.id.room220);
        Button room225 = findViewById(R.id.room225);
        Button room227 = findViewById(R.id.room227);
        Button room231 = findViewById(R.id.room231);

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
            room211.setBackgroundColor(getResources().getColor(R.color.red));
            room214.setBackgroundColor(getResources().getColor(R.color.red));
            room215.setBackgroundColor(getResources().getColor(R.color.red));
            room216.setBackgroundColor(getResources().getColor(R.color.red));
            room217.setBackgroundColor(getResources().getColor(R.color.red));
            room220.setBackgroundColor(getResources().getColor(R.color.red));
            room225.setBackgroundColor(getResources().getColor(R.color.red));
            room227.setBackgroundColor(getResources().getColor(R.color.red));
            room231.setBackgroundColor(getResources().getColor(R.color.red));

            open = false;
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
            room211.setBackgroundColor(getResources().getColor(R.color.green));
            room214.setBackgroundColor(getResources().getColor(R.color.green));
            room215.setBackgroundColor(getResources().getColor(R.color.green));
            room216.setBackgroundColor(getResources().getColor(R.color.green));
            room217.setBackgroundColor(getResources().getColor(R.color.green));
            room220.setBackgroundColor(getResources().getColor(R.color.green));
            room225.setBackgroundColor(getResources().getColor(R.color.green));
            room227.setBackgroundColor(getResources().getColor(R.color.green));
            room231.setBackgroundColor(getResources().getColor(R.color.green));

            open = true;
        }
    }

    public void backmain(View view) {
        onBackPressed();
    }

    public void enterRoom(View v) {
        // Identifica qual botão foi clicado
        String id = v.getResources().getResourceEntryName(v.getId());

        Intent intent = new Intent(this, Rooms.class);
        startActivity(intent);
        room = id;
        Log.d("MQTT_Rooms", id);
    }
}