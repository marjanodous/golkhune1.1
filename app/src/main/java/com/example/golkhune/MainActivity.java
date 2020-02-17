package com.example.golkhune;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    // for BottomNavigation
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    search search;
    home home;
    dastebandi dastebandi;

    ImageView about,play,pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // for BottomNavigation
        frameLayout =findViewById(R.id.frame_layout_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        search = new search();
        home = new home();
        dastebandi = new dastebandi();
        setFragment(home);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.item_home:
                        setFragment(home);

                        return  true;
                    case R.id.item_dastebandi:
                        setFragment(dastebandi);
                        return true;
                    case R.id.item_search:
                        setFragment(search);
                        return true;
                }
                return false;
            }
        });

       about =findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,about.class));
            }
        });

    }




    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_main,fragment);
        fragmentTransaction.commit();

    }
    //======================change font===============================
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}