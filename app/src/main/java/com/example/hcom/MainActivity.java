package com.example.hcom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.hcom.databinding.ActivityMainBinding;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {
    private AnimatedBottomBar animatedBottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animatedBottomBar = findViewById(R.id.bottom_bar);
        FragmentManager fragmentManager = getSupportFragmentManager();

        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int i, @Nullable AnimatedBottomBar.Tab tab, int i1, @NonNull AnimatedBottomBar.Tab tab1) {
                Log.d("animated_tab", ""+ tab1.getTitle());
                 FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (i1){
                    case 0:
                        transaction.replace(androidx.appcompat.R.id.content, new HomeFragment());
                        break;
                    case 1:
                        transaction.replace(androidx.appcompat.R.id.content, new NewsFeedFragment());
                        break;
                    case 2:
                        transaction.replace(androidx.appcompat.R.id.content, new CampaignsFragment());
                        break;
                    case 3:
                        transaction.replace(androidx.appcompat.R.id.content, new CartFragment());
                        break;
                    case 4:
                        transaction.replace(androidx.appcompat.R.id.content, new AccountFragment());
                }
                transaction.commit();
            }

            @Override
            public void onTabReselected(int i, @NonNull AnimatedBottomBar.Tab tab) {
            }
        });




    }
}