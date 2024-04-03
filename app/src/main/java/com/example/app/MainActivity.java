package com.example.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


    public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    public static String room;
    public static int last_floor;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                bottomNavigationView.getMenu().findItem(R.id.home)
                        .setIcon(R.drawable.home_outlined);
                bottomNavigationView.getMenu().findItem(R.id.shorts)
                        .setIcon(R.drawable.lock_outlined);

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



}
