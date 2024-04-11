package com.example.app;

import static com.example.app.MainActivity.room;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class floor3 extends AppCompatActivity {


    ImageButton button;
    boolean view=true;
    boolean open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor3);

        setupDropdownMenu();

        button = findViewById(R.id.toggle);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(view) {
                    setContentView(R.layout.activity_map3);
                    view = false;

                    ImageView imageView = findViewById(R.id.imageView);
                    if(open) {
                        imageView.setImageResource(R.drawable.floor_three_open);
                    }
                    else {
                        imageView.setImageResource(R.drawable.floor_three_closed);
                    }

                    button = findViewById(R.id.toggle);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (view) {
                                setContentView(R.layout.activity_map3);
                            } else {
                                recreate();
                            }
                        }
                    });
                }
            }
        });

        Button room303 = findViewById(R.id.room303);
        Button room308 = findViewById(R.id.room308);
        Button room311 = findViewById(R.id.room311);
        Button room317 = findViewById(R.id.room317);
        Button room319 = findViewById(R.id.room319);
        Button room320 = findViewById(R.id.room320);
        Button room327 = findViewById(R.id.room327);
        Button room330 = findViewById(R.id.room330);
        Button room331 = findViewById(R.id.room331);
        Button room332 = findViewById(R.id.room332);
        Button room345 = findViewById(R.id.room345);

        String currentTime = Calendar.getInstance().getTime().toString();
        Log.d("MQTT_Date",currentTime);

        String day = currentTime.substring(0, 3);
        int hour = Integer.parseInt(currentTime.substring(11,13));
        int minute = Integer.parseInt(currentTime.substring(14,16));
        Log.d("MQTT_Date","Day "+day+" Hour "+hour+" Minute "+minute);

            if(day.equals("Sat") || day.equals("Sun") || hour>=23 || (hour==22 && minute>=30) || (hour==20 && minute>=15 && minute<=45) || hour<8 || (hour==8 && minute<30)) {
                room303.setBackgroundColor(getResources().getColor(R.color.red));
                room308.setBackgroundColor(getResources().getColor(R.color.red));
                room311.setBackgroundColor(getResources().getColor(R.color.red));
                room317.setBackgroundColor(getResources().getColor(R.color.red));
                room319.setBackgroundColor(getResources().getColor(R.color.red));
                room320.setBackgroundColor(getResources().getColor(R.color.red));
                room327.setBackgroundColor(getResources().getColor(R.color.red));
                room330.setBackgroundColor(getResources().getColor(R.color.red));
                room331.setBackgroundColor(getResources().getColor(R.color.red));
                room332.setBackgroundColor(getResources().getColor(R.color.red));
                room345.setBackgroundColor(getResources().getColor(R.color.red));

                open = false;
            }
        else {
                room303.setBackgroundColor(getResources().getColor(R.color.green));
                room308.setBackgroundColor(getResources().getColor(R.color.green));
                room311.setBackgroundColor(getResources().getColor(R.color.green));
                room317.setBackgroundColor(getResources().getColor(R.color.green));
                room319.setBackgroundColor(getResources().getColor(R.color.green));
                room320.setBackgroundColor(getResources().getColor(R.color.green));
                room327.setBackgroundColor(getResources().getColor(R.color.green));
                room330.setBackgroundColor(getResources().getColor(R.color.green));
                room331.setBackgroundColor(getResources().getColor(R.color.green));
                room332.setBackgroundColor(getResources().getColor(R.color.green));
                room345.setBackgroundColor(getResources().getColor(R.color.green));

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

    private void setupDropdownMenu() {
        ImageButton infoButton = findViewById(R.id.info);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDropdownMenu(v);
            }
        });
    }

    private void showDropdownMenu(View anchorView) {
        // Inflate the dropdown menu layout
        View popupView = getLayoutInflater().inflate(R.layout.dropdown_menu_layout, null);

        // Create a PopupWindow with WRAP_CONTENT width and height
        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        // Set focusable and outside touchable to true to make it interactable
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        // Show the popup window at the bottom of the anchor view
        popupWindow.showAsDropDown(anchorView);
    }
}