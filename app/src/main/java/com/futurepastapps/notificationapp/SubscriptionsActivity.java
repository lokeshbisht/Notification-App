package com.futurepastapps.notificationapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

public class SubscriptionsActivity extends AppCompatActivity {

    private CheckBox placementsCheckbox, studentsCheckbox, societiesCheckbox, universityCheckbox;

    private android.support.v7.widget.Toolbar toolbar;

    private FirebaseAuth firebaseAuth;
    private FirebaseMessaging firebaseMessaging;
    private SharedPreferences sharedPreferences;

    private static final String PLACEMENTS = "placements";
    private static final String STUDENTS = "students";
    private static final String SOCIETIES = "societies";
    private static final String UNIVERSITY = "university";

    private Boolean placements, students, socities, university;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriptions);

        toolbar = findViewById(R.id.subscriptionsBar);

        placementsCheckbox = findViewById(R.id.placementsCheckbox);
        studentsCheckbox = findViewById(R.id.studentsCheckbox);
        societiesCheckbox = findViewById(R.id.societiesCheckbox);
        universityCheckbox = findViewById(R.id.universityCheckbox);

        firebaseAuth = FirebaseAuth.getInstance();

        toolbar.setTitle("My Subscriptions");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        placementsCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    FirebaseMessaging.getInstance().subscribeToTopic("placements");
                    sharedPreferences.edit().putBoolean(PLACEMENTS, true).commit();
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("placements");
                    sharedPreferences.edit().putBoolean(PLACEMENTS, false).commit();
                }
            }
        });

        studentsCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    FirebaseMessaging.getInstance().subscribeToTopic("students");
                    sharedPreferences.edit().putBoolean(STUDENTS, true).commit();
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("students");
                    sharedPreferences.edit().putBoolean(STUDENTS, false).commit();
                }
            }
        });

        societiesCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    FirebaseMessaging.getInstance().subscribeToTopic("societies");
                    sharedPreferences.edit().putBoolean(SOCIETIES, true).commit();
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("societies");
                    sharedPreferences.edit().putBoolean(SOCIETIES, false).commit();
                }
            }
        });

        universityCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    FirebaseMessaging.getInstance().subscribeToTopic("university");
                    sharedPreferences.edit().putBoolean(UNIVERSITY, true).commit();
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("university");
                    sharedPreferences.edit().putBoolean(UNIVERSITY, false).commit();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        placements = sharedPreferences.getBoolean(PLACEMENTS, false);
        students = sharedPreferences.getBoolean(STUDENTS, false);
        socities = sharedPreferences.getBoolean(SOCIETIES, false);
        university = sharedPreferences.getBoolean(UNIVERSITY, false);

        placementsCheckbox.setChecked(placements);
        studentsCheckbox.setChecked(students);
        societiesCheckbox.setChecked(socities);
        universityCheckbox.setChecked(university);
    }
}
