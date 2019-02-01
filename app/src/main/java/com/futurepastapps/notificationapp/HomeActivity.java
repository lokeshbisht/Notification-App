package com.futurepastapps.notificationapp;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    private Button logout;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private BottomNavigationViewEx bottomNavigationViewEx;

    private android.support.v7.widget.Toolbar toolbar;

    private ImageView userImage;
    private TextView userName, userEmail;
    private NavigationView navigationView;
    private View view;
    private RelativeLayout loggedInLayout;
    private Button signInButton;

    private Glide glide;

    private ViewPager viewPager;
    private SectionsPager sectionsPager;
    private TabLayout tabLayout;
    private RelativeLayout mainLayout, drawerMainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navigationView = findViewById(R.id.homeNavigationView);
        view = navigationView.getHeaderView(0);
        drawerMainLayout = view.findViewById(R.id.drawerMainLayout);
        userName = view.findViewById(R.id.headerUsername);
        userEmail = view.findViewById(R.id.headerUserEmail);
        userImage = view.findViewById(R.id.headerUserImage);
        loggedInLayout = view.findViewById(R.id.drawerLoggedInLayout);
        signInButton = view.findViewById(R.id.headerSignInButton);
        mainLayout = findViewById(R.id.homeMainLayout);


        drawerLayout = findViewById(R.id.homeDrawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar , R.string.open, R.string.close);

        firebaseAuth = FirebaseAuth.getInstance();

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        viewPager = findViewById(R.id.homeViewPager);
        sectionsPager = new SectionsPager(getSupportFragmentManager());
        viewPager.setAdapter(sectionsPager);
        tabLayout = findViewById(R.id.homeTabLayout);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0) {
                    drawerMainLayout.setBackgroundColor(getResources().getColor(R.color.societiesColor));
                    mainLayout.setBackgroundColor(getResources().getColor(R.color.societiesColor));
                }
                if(position == 1) {
                    drawerMainLayout.setBackgroundColor(getResources().getColor(R.color.universityColor));
                    mainLayout.setBackgroundColor(getResources().getColor(R.color.universityColor));
                }
                if(position == 2) {
                    drawerMainLayout.setBackgroundColor(getResources().getColor(R.color.placementsColor));
                    mainLayout.setBackgroundColor(getResources().getColor(R.color.placementsColor));
                }
                if(position == 3) {
                    drawerMainLayout.setBackgroundColor(getResources().getColor(R.color.studentsColor));
                    mainLayout.setBackgroundColor(getResources().getColor(R.color.studentsColor));
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.logout) {
                  firebaseAuth.signOut();
                }
                if(item.getItemId() == R.id.mySubscriptions) {
                    Intent subscriptionsIntent = new Intent(HomeActivity.this, SubscriptionsActivity.class);
                    startActivity(subscriptionsIntent);
                }

                return true;
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        toolbar = findViewById(R.id.homeToolbar);

        toolbar.setTitle("hello");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();

        firebaseAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    signInButton.setVisibility(View.VISIBLE);
                    loggedInLayout.setVisibility(View.GONE);
                } else {

                    loggedInLayout.setVisibility(View.VISIBLE);
                    signInButton.setVisibility(View.GONE);
                    navigationView.getMenu().setGroupVisible(R.id.loggedInGroup , true);
                    GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(HomeActivity.this);
                    String personName = acct.getDisplayName();
                    String personEmail = acct.getEmail();
                    Uri personPhoto = acct.getPhotoUrl();

                    userName.setText(personName);
                    userEmail.setText(personEmail);
                    glide.with(HomeActivity.this).load(personPhoto).into(userImage);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}
