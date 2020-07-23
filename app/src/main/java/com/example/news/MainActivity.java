package com.example.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

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
                    Log.i("inside","jome");
                    fragment=new framenthome();
                    break;
                case R.id.searchButton:
                        fragment=new framentsearch();
                    Log.i("inside","search");
                        break;
                case R.id.watchlater:
                    Log.i("inside","watchlater");
                    fragment=new framentlastread();
                    break; }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
        }
    };
}