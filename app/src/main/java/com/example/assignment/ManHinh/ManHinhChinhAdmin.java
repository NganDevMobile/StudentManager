package com.example.assignment.ManHinh;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment.DAO.DAO_User;
import com.example.assignment.Database.DbHelper;
import com.example.assignment.News.NewsActivity;
import com.example.assignment.R;
import com.example.assignment.model.User;

import java.util.ArrayList;


public class ManHinhChinhAdmin extends AppCompatActivity {
    ImageView imgCourse,imgNews,imgUser,imgMaps;
    TextView tvAvarta;
    DAO_User dao_user;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_man_hinh_chinh_admin );
        imgCourse= findViewById( R.id.imgCourse );
        imgNews= findViewById( R.id.imgNews );
        imgUser= findViewById( R.id.imgUser );
        imgMaps= findViewById( R.id.imgMaps );
        tvAvarta= findViewById( R.id.tvAvarta );
        dao_user= new DAO_User( this );
        ArrayList<User> list_User= dao_user.getAll();
        for(int i=0;i<list_User.size();i++){
            if(list_User.get( i ).getAccountID()==dbHelper.IDuser){
                tvAvarta.setText( list_User.get( i ).getFullName());
            }
        }

        imgCourse.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intentCourse = new Intent(ManHinhChinhAdmin.this, ManHinhCourse.class);
                startActivity( intentCourse );
            }
        } );
        imgNews.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNews = new Intent(ManHinhChinhAdmin.this, NewsActivity.class);
                startActivity( intentNews );
            }
        } );
        imgUser.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNEWS = new Intent(  ManHinhChinhAdmin.this, Activity_User_Info.class);
                startActivity( intentNEWS );
            }
        } );
        imgMaps.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNEWS = new Intent(  ManHinhChinhAdmin.this, MapsActivity.class);
                startActivity( intentNEWS );
            }
        } );
    }
}
