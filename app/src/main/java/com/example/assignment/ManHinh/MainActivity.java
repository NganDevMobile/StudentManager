package com.example.assignment.ManHinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.assignment.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,ManHinhDangNhap.class));
                finish();
            }
        }, 1500);
    }
}
