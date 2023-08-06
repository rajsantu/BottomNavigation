package com.mainpackage.bottomnavigation;

import static com.mainpackage.bottomnavigation.R.id.home;
import static com.mainpackage.bottomnavigation.R.id.profile;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    FragmentUser fragmentUser = new FragmentUser();
    FragmentHome fragmentHome = new FragmentHome();
    FragmentSetting fragmentSetting = new FragmentSetting();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(home);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == profile) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, fragmentUser)
                    .commit();

        } else if (item.getItemId() == home) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, fragmentHome)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, fragmentSetting)
                    .commit();

        }
        return false;
    }
}