package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Arrays;
import java.util.concurrent.Executor;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    public static String room;
    public static int last_floor;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Biometric(true);

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
                Log.d("Mudança","ola");

                if (item.getItemId() == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                    item.setIcon(R.drawable.nav_home);
                    return true;

                } else if (item.getItemId() == R.id.shorts) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new nfcFragment()).commit();
                    item.setIcon(R.drawable.nav_lock);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.profile) {
            Toast.makeText(MainActivity.this, "Profile Selected", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.logout) {
            Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();

        }else if (item.getItemId() == R.id.Settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new settingsFragment()).commit();

        }else if (item.getItemId() == R.id.help) {
            Toast.makeText(this, "Help Selected", Toast.LENGTH_SHORT).show();

        }else if (item.getItemId() == R.id.aboutus) {
            Toast.makeText(this, "About Us Selected", Toast.LENGTH_SHORT).show();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gatekeeper.web.ua.pt/"));
            startActivity(browserIntent);

        }else if (item.getItemId() == R.id.instagram) {
            Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/gatekeeper_deti?igshid=MTNiYzNiMzkwZA=="));
            startActivity(browserIntent2);
        }else if (item.getItemId() == R.id.rateus) {
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

            Toast.makeText(this,"NFC Tag saved",Toast.LENGTH_LONG).show();
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