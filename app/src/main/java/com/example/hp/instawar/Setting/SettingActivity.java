package com.example.hp.instawar.Setting;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.hp.instawar.BottomNavigationHelper;
import com.example.hp.instawar.Home.Home_activity;
import com.example.hp.instawar.Like.LikeActivity;
import com.example.hp.instawar.Profile.ProfileActivity;
import com.example.hp.instawar.R;

public class SettingActivity extends AppCompatActivity{
    private static final String TAG="SettingActivity";
    Context mContext;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        TextView textView =(TextView)findViewById(R.id.textView);
        mContext=SettingActivity.this;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_icon);
        setupBottomNavigationView();


    }
    private void setupBottomNavigationView(){

        BottomNavigationHelper.enableNavigationClick(mContext,bottomNavigationView);
        Menu menu=bottomNavigationView.getMenu();
        MenuItem menuItem=menu.getItem(3);
        menuItem.setChecked(true);



    }
}
