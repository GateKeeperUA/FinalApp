package com.example.app;

import static com.example.app.MainActivity.room;

import android.content.Intent;
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

public class floor1 extends AppCompatActivity {

    ImageButton button;
    boolean view=true;
    boolean open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor1);

        setupDropdownMenu();

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

        ImageButton room101 = findViewById(R.id.room101);
        ImageButton room102 = findViewById(R.id.room102);
        ImageButton room104 = findViewById(R.id.room104);
        ImageButton room106 = findViewById(R.id.room106);
        ImageButton room118 = findViewById(R.id.room118);
        ImageButton room119 = findViewById(R.id.room119);
        ImageButton room123 = findViewById(R.id.room123);
        ImageButton room124 = findViewById(R.id.room124);
        ImageButton room128 = findViewById(R.id.room128);
        ImageButton room136 = findViewById(R.id.room136);

        String currentTime = Calendar.getInstance().getTime().toString();
        Log.d("MQTT_Date",currentTime);

        String day = currentTime.substring(0, 3);
        int hour = Integer.parseInt(currentTime.substring(11,13));
        int minute = Integer.parseInt(currentTime.substring(14,16));
        Log.d("MQTT_Date","Day "+day+" Hour "+hour+" Minute "+minute);

        boolean isDaltonismEnabled = AppPreferences.isDaltonismEnabled(this);

        Drawable bgOccupied;
        Drawable bgFree;
        Drawable bdCard = getDrawable(R.drawable.bg_default);

        if (isDaltonismEnabled) {

            bgOccupied = ContextCompat.getDrawable(this, R.drawable.bg_daltonism_occupied); // Seu arquivo XML de textura de linhas
            bgFree = ContextCompat.getDrawable(this, R.drawable.bg_daltonism_free); // Seu arquivo XML de textura de quadrado
        } else {

            bgOccupied = ContextCompat.getDrawable(this, R.drawable.bg_default_occupied);
            bgFree = ContextCompat.getDrawable(this, R.drawable.bg_default_free);
        }


        if(day.equals("Sat") || day.equals("Sun") || hour>=23 || (hour==22 && minute>=30) || (hour==20 && minute>=15 && minute<=45) || hour<8 || (hour==8 && minute<30)) {
            room101.setBackground(bgOccupied);
            room102.setBackground(bgOccupied);
            room104.setBackground(bgOccupied);
            room106.setBackground(bgOccupied);
            room118.setBackground(bdCard);
            room119.setBackground(bdCard);
            room123.setBackground(bdCard);
            room124.setBackground(bdCard);
            room128.setBackground(bdCard);
            room136.setBackground(bdCard);

            open = false;
        }
        else {
            room101.setBackground(bgFree);;
            room102.setBackground(bgFree);
            room104.setBackground(bgFree);
            room106.setBackground(bgFree);
            room118.setBackground(bgFree);
            room119.setBackground(bgFree);
            room123.setBackground(bgFree);
            room124.setBackground(bgFree);
            room128.setBackground(bgFree);
            room136.setBackground(bgFree);

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