package com.example.assignment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.assignment.Database.DbHelper;
import com.example.assignment.model.User;

import java.util.ArrayList;
import java.util.List;


public class DAO_User {
    private SQLiteDatabase db;
    DbHelper dbHelper;

    public DAO_User(Context context) {
        dbHelper = new DbHelper( context );
        db = dbHelper.getWritableDatabase();
    }

    public long insert(User item) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "userName", item.getUsername() );
        values.put( "passWord", item.getPassword() );
        values.put( "fullName", item.getFullName() );
        values.put( "address", item.getAddress() );
        values.put( "phoneNumber", item.getPhoneNumber() );
        return db.insert( "ACCOUNT", null, values );
    }

    public int update(User item) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "userName", item.getUsername() );
        values.put( "fullName", item.getFullName() );
        values.put( "address", item.getAddress() );
        values.put( "phoneNumber", item.getPhoneNumber() );
        return db.update( "ACCOUNT", values, "accountID=?", new String[]{String.valueOf( item.getAccountID() )} );
    }
    public int updatePass(User item) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "passWord", item.getPassword() );
        return db.update( "ACCOUNT", values, "accountID=?", new String[]{String.valueOf( item.getAccountID() )} );
    }

    public int delete(String maLoai) {
        db = dbHelper.getWritableDatabase();
        return db.delete( "ACCOUNT", "accountID=?", new String[]{maLoai} );
    }




    public List<User> get(String sql, String...selectionArgs){
        List<User> list = new ArrayList<>();
        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery( sql,selectionArgs );
        c.moveToFirst();
        while (!c.isAfterLast()){
            try {
                int accountID = Integer.parseInt(c.getString(0));
                String username = c.getString(1);
                String password = c.getString(2);
                String fullname = c.getString(3);
                String address = c.getString(4);
                String phoneNumber = c.getString(5);
                User account = new User(accountID, username, password, fullname, address, phoneNumber);
                list.add(account);
                c.moveToNext();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        c.close();
        return list;
    }
    public String getNameAD(){
        String userName="";
        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery( "SELECT fullName" +
                " FROM ACCOUNT",null );
        c.moveToFirst();
        userName=c.getString( 0 );
        c.close();
        return userName;
    }    public List<User> getUser(){
            String sqlGetName = "SELECT * FROM ACCOUNT ";
            return get( sqlGetName );
    }
    public List<User> getUser(Integer id){
        String sqlGetName = "SELECT * FROM ACCOUNT WHERE accountID= "+id;
        return get( sqlGetName );
    }

    public ArrayList<User> getAll() {
        db = dbHelper.getWritableDatabase();
        ArrayList<User> list = new ArrayList<User>();

        Cursor c = db.rawQuery( "SELECT * FROM ACCOUNT", null );
        c.moveToPosition(1);
        while (!c.isAfterLast()) {
            int accountID = Integer.parseInt( c.getString( 0 ) );
            String username = c.getString( 1 );
            String password = c.getString( 2 );
            String fullname = c.getString( 3 );
            String address = c.getString( 4 );
            String phoneNumber = c.getString( 5 );
            User account = new User( accountID, username, password, fullname, address, phoneNumber );
            list.add( account );
            c.moveToNext();
        }
        return list;
    }
    public ArrayList<User> getAll(Integer id) {
        db = dbHelper.getWritableDatabase();
        ArrayList<User> list = new ArrayList<User>();

        Cursor c = db.rawQuery( "SELECT * FROM ACCOUNT WHERE accountID=?"+id, null );
        c.moveToFirst();
        while (!c.isAfterLast()) {
            int accountID = Integer.parseInt( c.getString( 0 ) );
            String username = c.getString( 1 );
            String password = c.getString( 2 );
            String fullname = c.getString( 3 );
            String address = c.getString( 4 );
            String phoneNumber = c.getString( 5 );
            User account = new User( accountID, username, password, fullname, address, phoneNumber );
            list.add( account );
            c.moveToNext();
        }
        return list;
    }
}



