package com.example.firebasetest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        replaceFragment(new HomeFragment(),0);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.home)replaceFragment(new HomeFragment(),1);
            if(item.getItemId() == R.id.buy)replaceFragment(new BuyFragment(),1);
            if(item.getItemId() == R.id.sell)replaceFragment(new SellFragment(),1);
//            if(item.getItemId() == R.id.profile)replaceFragment(new ProfileFragment(),1);
            return true;
        });
    }
    private void replaceFragment(Fragment fragment,int flag){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (flag == 0)fragmentTransaction.add(R.id.frame_layout,fragment);
        else fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}