package com.varshney.slidingdrawer;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
   LinearLayout content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerLayout);
        content= findViewById(R.id.content);

        drawerLayout.setScrimColor(Color.TRANSPARENT); // prevents form darking the background color on opening drawer.

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close) {

            private float scaleFactor = 6f;

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

                //slideOffset =0 close, 1 open ,0.5 in between
                float slideX = drawerView.getWidth() * slideOffset;

                //Now Play With slideX whatever way u want.
                content.setTranslationX(slideX);

//                content.setScaleX(1 - slideOffset);
//                content.setScaleY(1 - slideOffset);

                //Next Two lines give some effects. Previous Two gives some other effect.
                content.setScaleX(1 - (slideOffset / scaleFactor));
                content.setScaleY(1 - (slideOffset / scaleFactor));

            }

        };
        drawerLayout.setDrawerElevation(0f);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

    }
}
