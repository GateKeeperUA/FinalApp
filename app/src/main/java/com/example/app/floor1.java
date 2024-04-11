package com.example.app;

import static com.example.app.MainActivity.room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class floor1 extends AppCompatActivity {

    ImageButton button;
    boolean view=true;
    boolean open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor1);

        button = findViewById(R.id.toggle);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(view) {
                    setContentView(R.layout.activity_map1);
                    view = false;

                    ImageView imageView = findViewById(R.id.imageView);
                    if(open) {
                        imageView.setImageResource(R.drawable.floor_one_open);
                    }
                    else {
                        imageView.setImageResource(R.drawable.floor_one_closed);
                    }

                    button = findViewById(R.id.toggle);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (view) {
                                setContentView(R.layout.activity_map1);
                            } else {
                                recreate();
                            }
                        }
                    });
                }
            }
        });

        Button room101 = findViewById(R.id.room101);
        Button room102 = findViewById(R.id.room102);
        Button room104 = findViewById(R.id.room104);
        Button room106 = findViewById(R.id.room106);
        Button room118 = findViewById(R.id.room118);
        Button room119 = findViewById(R.id.room119);
        Button room120 = findViewById(R.id.room120);
        Button room123 = findViewById(R.id.room123);
        Button room124 = findViewById(R.id.room124);
        Button room128 = findViewById(R.id.room128);
        Button room136 = findViewById(R.id.room136);

        String currentTime = Calendar.getInstance().getTime().toString();
        Log.d("MQTT_Date",currentTime);

        String day = currentTime.substring(0, 3);
        int hour = Integer.parseInt(currentTime.substring(11,13));
        int minute = Integer.parseInt(currentTime.substring(14,16));
        Log.d("MQTT_Date","Day "+day+" Hour "+hour+" Minute "+minute);

        if(day.equals("Sat") || day.equals("Sun") || hour>=23 || (hour==22 && minute>=30) || (hour==20 && minute>=15 && minute<=45) || hour<8 || (hour==8 && minute<30)) {
            room101.setBackgroundColor(getResources().getColor(R.color.red));
            room102.setBackgroundColor(getResources().getColor(R.color.red));
            room104.setBackgroundColor(getResources().getColor(R.color.red));
            room106.setBackgroundColor(getResources().getColor(R.color.red));
            room118.setBackgroundColor(getResources().getColor(R.color.azure));
            room119.setBackgroundColor(getResources().getColor(R.color.azure));
            room120.setBackgroundColor(getResources().getColor(R.color.azure));
            room123.setBackgroundColor(getResources().getColor(R.color.azure));
            room124.setBackgroundColor(getResources().getColor(R.color.azure));
            room128.setBackgroundColor(getResources().getColor(R.color.azure));
            room136.setBackgroundColor(getResources().getColor(R.color.azure));

            open = false;
        }
        else {
            room101.setBackgroundColor(getResources().getColor(R.color.green));
            room102.setBackgroundColor(getResources().getColor(R.color.green));
            room104.setBackgroundColor(getResources().getColor(R.color.green));
            room106.setBackgroundColor(getResources().getColor(R.color.green));
            room118.setBackgroundColor(getResources().getColor(R.color.green));
            room119.setBackgroundColor(getResources().getColor(R.color.green));
            room120.setBackgroundColor(getResources().getColor(R.color.green));
            room123.setBackgroundColor(getResources().getColor(R.color.green));
            room124.setBackgroundColor(getResources().getColor(R.color.green));
            room128.setBackgroundColor(getResources().getColor(R.color.green));
            room136.setBackgroundColor(getResources().getColor(R.color.green));

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