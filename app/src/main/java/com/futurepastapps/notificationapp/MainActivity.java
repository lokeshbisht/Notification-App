package com.futurepastapps.notificationapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private CheckLaunchType checkLaunchType;

    private ViewPager viewPager;
    private LinearLayout dotsLayout;

    private SliderAdapter sliderAdapter;

    private FirebaseAuth firebaseAuth;

    private TextView[] dotsText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderAdapter = new SliderAdapter(this);

        checkLaunchType = new CheckLaunchType();

        firebaseAuth = FirebaseAuth.getInstance();

        viewPager = findViewById(R.id.mainViewPager);
        dotsLayout = findViewById(R.id.dotsLayout);

        viewPager.addOnPageChangeListener(viewPagerListener);
    }

    @Override
    protected void onStart() {
        super.onStart();

        switch (checkLaunchType.checkAppStart(this)) {

            case NORMAL:
                Toast.makeText(this, "normal", Toast.LENGTH_SHORT).show();
                firebaseAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        if(firebaseAuth.getCurrentUser() == null) {
                            Intent loginActivityIntent = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(loginActivityIntent);
                        } else {
                            Intent homeActivityIntent = new Intent(MainActivity.this , HomeActivity.class);
                            startActivity(homeActivityIntent);

                        }

                    }
                });
                break;

            case FIRST_TIME:
                Toast.makeText(this, "first time", Toast.LENGTH_SHORT).show();
                viewPager.setAdapter(sliderAdapter);
                makeDots(0);
                break;

            case FIRST_TIME_VERSION:
                Toast.makeText(this, "version", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    private void makeDots(int position) {

        dotsText = new TextView[3];
        dotsLayout.removeAllViews();

        for(int i = 0; i < dotsText.length; i++) {
            dotsText[i] = new TextView(this);
            dotsText[i].setText(Html.fromHtml("&#8226;"));
            dotsText[i].setTextSize(35);
            dotsText[i].setTextColor(Color.BLACK);

            dotsLayout.addView(dotsText[i]);
        }

        dotsText[position].setTextColor(Color.BLUE);


    }

    ViewPager.OnPageChangeListener viewPagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            makeDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
