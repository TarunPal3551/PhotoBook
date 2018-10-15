package com.example.hp.instawar.Like;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hp.instawar.BottomNavigationHelper;
import com.example.hp.instawar.R;

public class LikeActivity extends AppCompatActivity{
    private static final String TAG="LikeActivity";
    private Context mContext;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);


        mContext=LikeActivity.this;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_icon);
        setupBottomNavigationView();

    }

    private void setupBottomNavigationView(){
        BottomNavigationHelper.enableNavigationClick(mContext,bottomNavigationView);
        Menu menu=bottomNavigationView.getMenu();
        MenuItem menuItem=menu.getItem(2);
        menuItem.setChecked(true);



    }


    }





