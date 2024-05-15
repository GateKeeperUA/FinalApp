package com.example.app;

import static com.example.app.MainActivity.room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class floor2 extends AppCompatActivity {
    private static final String PREF_COLOR_KEY = "color_scheme"; // Chave para a preferência de esquema de cores
    ImageButton button;
    boolean view = true;
    boolean open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor2);

        setupDropdownMenu();

        button = findViewById(R.id.toggle);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view) {
                    setContentView(R.layout.activity_map1);
                    view = false;

                    ImageView imageView = findViewById(R.id.imageView);
                    if (open) {
                        imageView.setImageResource(R.drawable.floor_two_open);
                    } else {
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

        // Recuperar a preferência do esquema de cores
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isDefaultScheme = sharedPreferences.getBoolean(PREF_COLOR_KEY, true);

        // Definir as cores com base na preferência
        int colorOcupado = isDefaultScheme ? getResources().getColor(R.color.red) : getResources().getColor(R.color.amethyst);
        int colorLivre = isDefaultScheme ? getResources().getColor(R.color.green) : getResources().getColor(R.color.yellow);

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
        Log.d("MQTT_Date", currentTime);

        String day = currentTime.substring(0, 3);
        int hour = Integer.parseInt(currentTime.substring(11, 13));
        int minute = Integer.parseInt(currentTime.substring(14, 16));
        Log.d("MQTT_Date", "Day " + day + " Hour " + hour + " Minute " + minute);

        if (day.equals("Sat") || day.equals("Sun") || hour >= 23 || (hour == 22 && minute >= 30) || (hour == 20 && minute >= 15 && minute <= 45) || hour < 8 || (hour == 8 && minute < 30)) {
            room201.setBackgroundColor(colorOcupado);
            room202.setBackgroundColor(colorOcupado);
            room203.setBackgroundColor(colorOcupado);
            room204.setBackgroundColor(colorOcupado);
            room205.setBackgroundColor(colorOcupado);
            room206.setBackgroundColor(colorOcupado);
            room207.setBackgroundColor(colorOcupado);
            room208.setBackgroundColor(colorOcupado);
            room211.setBackgroundColor(colorOcupado);
            room214.setBackgroundColor(colorOcupado);
            room215.setBackgroundColor(colorOcupado);
            room216.setBackgroundColor(colorOcupado);
            room217.setBackgroundColor(colorOcupado);
            room220.setBackgroundColor(colorOcupado);
            room225.setBackgroundColor(colorOcupado);
            room227.setBackgroundColor(colorOcupado);
            room231.setBackgroundColor(colorOcupado);

            open = false;
        } else {
            room201.setBackgroundColor(colorLivre);
            room202.setBackgroundColor(colorLivre);
            room203.setBackgroundColor(colorLivre);
            room204.setBackgroundColor(colorLivre);
            room205.setBackgroundColor(colorLivre);
            room206.setBackgroundColor(colorLivre);
            room207.setBackgroundColor(colorLivre);
            room208.setBackgroundColor(colorLivre);
            room211.setBackgroundColor(colorLivre);
            room214.setBackgroundColor(colorLivre);
            room215.setBackgroundColor(colorLivre);
            room216.setBackgroundColor(colorLivre);
            room217.setBackgroundColor(colorLivre);
            room220.setBackgroundColor(colorLivre);
            room225.setBackgroundColor(colorLivre);
            room227.setBackgroundColor(colorLivre);
            room231.setBackgroundColor(colorLivre);

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
