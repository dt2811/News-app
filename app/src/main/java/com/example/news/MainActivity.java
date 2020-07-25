package com.example.news;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new framenthome()).commit();
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom);
        bottomNavigationView.setOnNavigationItemReselectedListener(navigationItemReselectedListener);
    }
    private BottomNavigationView.OnNavigationItemReselectedListener navigationItemReselectedListener=new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {
            Fragment fragment=null;
            switch (item.getItemId()){
                case R.id.HomeButton:
                    fragment=new framenthome();
                    break;
                case R.id.searchButton:
                        fragment=new framentsearch();
                        break;
                case R.id.watchlater:
                    fragment=new framentlastread();
                    break; }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
        }
    };
}