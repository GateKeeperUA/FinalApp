package com.example.app;

import static com.example.app.MainActivity.room;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Calendar;
import java.util.Date;

public class floor3 extends AppCompatActivity {


    ImageButton button;
    boolean view=true;
    boolean open;
    ImageButton[] roomButtons;
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


        roomButtons = new ImageButton[]{
                findViewById(R.id.room303), findViewById(R.id.room308), findViewById(R.id.room311), findViewById(R.id.room317),
                findViewById(R.id.room319), findViewById(R.id.room320), findViewById(R.id.room327), findViewById(R.id.room330),
                findViewById(R.id.room331), findViewById(R.id.room332), findViewById(R.id.room345)
        };

        String currentTime = Calendar.getInstance().getTime().toString();
        Log.d("MQTT_Date",currentTime);

        String day = currentTime.substring(0, 3);
        int hour = Integer.parseInt(currentTime.substring(11,13));
        int minute = Integer.parseInt(currentTime.substring(14,16));
        Log.d("MQTT_Date","Day "+day+" Hour "+hour+" Minute "+minute);

        applyColorScheme();
    }

    private void applyColorScheme() {
        boolean isDaltonismEnabled = AppPreferences.isDaltonismEnabled(this);

        Drawable bgOccupied;
        Drawable bgFree;

        if (isDaltonismEnabled) {

            bgOccupied = ContextCompat.getDrawable(this, R.drawable.bg_daltonism_occupied); // Seu arquivo XML de textura de linhas
            bgFree = ContextCompat.getDrawable(this, R.drawable.bg_daltonism_free); // Seu arquivo XML de textura de quadrado
        } else {

            bgOccupied = ContextCompat.getDrawable(this, R.drawable.bg_default_occupied);
            bgFree = ContextCompat.getDrawable(this, R.drawable.bg_default_free);
        }


        String currentTime = Calendar.getInstance().getTime().toString();
        String day = currentTime.substring(0, 3);
        int hour = Integer.parseInt(currentTime.substring(11, 13));
        int minute = Integer.parseInt(currentTime.substring(14, 16));

        for (ImageButton button : roomButtons) {
            if (day.equals("Sat") || day.equals("Sun") || hour >= 23 || (hour == 22 && minute >= 30) || (hour == 20 && minute >= 15 && minute <= 45) || hour < 8 || (hour == 8 && minute < 30)) {
                button.setBackground(bgOccupied);

            } else {
                button.setBackground(bgFree);

            }
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
        boolean isDaltonismEnabled = AppPreferences.isDaltonismEnabled(this);
        // Inflate the dropdown menu layout
        View popupView = getLayoutInflater().inflate(R.layout.dropdown_menu_layout, null);

        // Create a PopupWindow with WRAP_CONTENT width and height
        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        ImageView accessible = popupView.findViewById(R.id.Accessible);
        ImageView notAccessible = popupView.findViewById(R.id.Not);

        Drawable ddOccupied;
        Drawable ddFree;

        if (isDaltonismEnabled) {

            ddOccupied = ContextCompat.getDrawable(this, R.drawable.dd_red_daltism); // Seu arquivo XML de textura de linhas
            ddFree = ContextCompat.getDrawable(this, R.drawable.dd_green_daltism); // Seu arquivo XML de textura de quadrado
        } else {

            ddOccupied = ContextCompat.getDrawable(this, R.drawable.bg_default_occupied);
            ddFree = ContextCompat.getDrawable(this, R.drawable.bg_default_free);
        }

        accessible.setBackground(ddFree);
        notAccessible.setBackground(ddOccupied);

        // Set focusable and outside touchable to true to make it interactable
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        // Show the popup window at the bottom of the anchor view
        popupWindow.showAsDropDown(anchorView);
    }
}