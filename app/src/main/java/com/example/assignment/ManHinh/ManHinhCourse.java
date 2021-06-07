package com.example.assignment.ManHinh;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.assignment.Fragment.Fragment_Change_Pass;
import com.example.assignment.Fragment.Fragment_Exam;
import com.example.assignment.Fragment.Fragment_Info;
import com.example.assignment.Fragment.Fragment_TimeTable;
import com.example.assignment.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ManHinhCourse extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_course );
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_course);
        if (savedInstanceState == null){
            loadFragment(new Fragment_TimeTable());
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.botTimeTable:
                        fragment = new Fragment_TimeTable();
                        loadFragment(fragment);
                        break;
                    case R.id.botExam:
                        fragment = new Fragment_Exam();
                        loadFragment(fragment);
                        break;
                }
                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fr_, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void onBackPressed() {
        finish();
    }

}
