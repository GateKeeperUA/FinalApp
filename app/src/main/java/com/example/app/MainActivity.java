package com.example.app;

import static com.example.app.Biometrics.entered;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.Random;
import java.util.concurrent.Executor;


import android.content.res.Configuration;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static String room;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;

    public static boolean nfc_discovered=false;
    public static MqttClient client;

    private static final String PREF_COLOR_KEY = "color_scheme";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(!entered) {
            setContentView(R.layout.activity_main);
            Biometric(true);
            entered = true;
        } else {
            setContentView(R.layout.activity_main_visible);
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }

        bottomNavigationView.setBackground(null);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                bottomNavigationView.getMenu().findItem(R.id.home).setIcon(R.drawable.home_outlined);
                bottomNavigationView.getMenu().findItem(R.id.shorts).setIcon(R.drawable.lock_outlined);

                Fragment selectedFragment = null;
                if (item.getItemId() == R.id.home) {
                    selectedFragment = new HomeFragment();
                    item.setIcon(R.drawable.nav_home);

                    try {
                        client.disconnect();
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                } else if (item.getItemId() == R.id.shorts) {
                    selectedFragment = new nfcFragment();
                    item.setIcon(R.drawable.nav_lock);
                }

                // Verifica se o fragmento selecionado é o que precisa da mudança de cor

                if (selectedFragment instanceof nfcFragment) {
                    setBottomNavigationItemColor(R.color.white); // Define a cor especificada
                } else {
                    if (isDarkThemeActive()) {
                        setBottomNavigationItemColor(R.color.black_trans); // Tema escuro: cor vermelha
                    } else {
                        setBottomNavigationItemColor(R.color.grey); // Tema claro: cor cinza
                    }
                }

                // Troca para o fragmento selecionado
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
                return false;
            }
        });

        // Inicialização das preferências compartilhadas
        sharedPreferences = getSharedPreferences("AppPreferences", Context.MODE_PRIVATE);

        // Recuperar a preferência do esquema de cores
        boolean isDefaultScheme = sharedPreferences.getBoolean(PREF_COLOR_KEY, true);

        // Obter o item do menu e definir o estado inicial do checkbox
        MenuItem daltonismItem = navigationView.getMenu().findItem(R.id.daltonism);
        View actionView = daltonismItem.getActionView();
        CheckBox checkBox = actionView.findViewById(R.id.checkBox);
        checkBox.setChecked(!isDefaultScheme);

        // Define um listener para a checkbox
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Salva a preferência ao alterar o estado da checkbox
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(PREF_COLOR_KEY, !isChecked);
                editor.apply();
            }
        });
    }

    private boolean isDarkThemeActive() {
        int nightModeFlags = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return nightModeFlags == Configuration.UI_MODE_NIGHT_YES;
    }

    private void setBottomNavigationItemColor(int color) {
        bottomNavigationView.setItemIconTintList(ContextCompat.getColorStateList(this, color));
        bottomNavigationView.setItemTextColor(ContextCompat.getColorStateList(this, color));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.profile) {
            Toast.makeText(MainActivity.this, "Profile Selected", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.logout) {
            Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.help) {
            Toast.makeText(this, "Help Selected", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.aboutus) {
            Toast.makeText(this, "About Us Selected", Toast.LENGTH_SHORT).show();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gatekeeper.web.ua.pt/"));
            startActivity(browserIntent);

        } else if (item.getItemId() == R.id.instagram) {
            Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/gatekeeper_deti?igshid=MTNiYzNiMzkwZA=="));
            startActivity(browserIntent2);

        } else if (item.getItemId() == R.id.rateus) {
            Toast.makeText(this, "Rate Us Selected", Toast.LENGTH_SHORT).show();
            Intent browserIntent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLScsaPy-4hMDuMQLN-qyQRwaG-K3xAgEe8I0Ye3Cy41TwVD4LQ/viewform?usp=sf_link"));
            startActivity(browserIntent3);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent().getAction().equals(NfcAdapter.ACTION_TAG_DISCOVERED)) {
            SharedPreferences sharedPreferences = getSharedPreferences("NFC Tag", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("key", ByteArrayToHexString(getIntent().getByteArrayExtra(NfcAdapter.EXTRA_ID)));
            editor.apply();

            bottomNavigationView.getMenu().findItem(R.id.home).setIcon(R.drawable.home_outlined);
            bottomNavigationView.getMenu().findItem(R.id.shorts).setIcon(R.drawable.lock_outlined);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new nfcFragment()).commit();
            bottomNavigationView.getMenu().findItem(R.id.shorts).setIcon(R.drawable.nav_lock);
            setBottomNavigationItemColor(R.color.white);

            nfc_discovered = true;

            Toast.makeText(this, "NFC Tag saved", Toast.LENGTH_LONG).show();
        }
    }


        private String ByteArrayToHexString(byte [] inarray) {
        int i, j, in;
        String [] hex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        String out= "";

        for(j = 0 ; j < inarray.length ; ++j)
        {
            in = (int) inarray[j] & 0xff;
            i = (in >> 4) & 0x0f;
            out += hex[i];
            i = in & 0x0f;
            out += hex[i];
        }
        return out;
    }


    private void Biometric(boolean able) {
        if (able) {
            BiometricManager biometricManager = BiometricManager.from(this);
            switch (biometricManager.canAuthenticate()) {
                case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                    Toast.makeText(getApplicationContext(), "Device doesn't have fingerprint scanner", Toast.LENGTH_SHORT).show();
                    break;
                case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                    Toast.makeText(getApplicationContext(), "Fingerprint scanner not working", Toast.LENGTH_SHORT).show();
                    break;
                case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                    Toast.makeText(getApplicationContext(), "No fingerprint assigned", Toast.LENGTH_SHORT).show();
                    break;
            }
            Executor executor = ContextCompat.getMainExecutor(this);
            biometricPrompt = new BiometricPrompt(MainActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                    super.onAuthenticationError(errorCode, errString);
                }

                @Override
                public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                    super.onAuthenticationSucceeded(result);
                    drawerLayout.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();
                }
            });

            promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("GateKeeper").setDeviceCredentialAllowed(true).build();
            biometricPrompt.authenticate(promptInfo);
        }
    }

}