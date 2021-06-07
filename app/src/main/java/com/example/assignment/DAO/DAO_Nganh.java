package com.example.assignment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.Database.DbHelper;
import com.example.assignment.model.Nganh;
import com.example.assignment.model.User;

import java.util.ArrayList;
import java.util.List;


public class DAO_Nganh {
    private SQLiteDatabase db;
    DbHelper dbHelper;

    public DAO_Nganh(Context context) {
        dbHelper = new DbHelper( context );
        db = dbHelper.getWritableDatabase();
    }

    public long insert(Nganh item) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "nganhID", item.getTenNganh() );
        values.put( "tenNganh", item.getTenNganh() );
        return db.insert( "NGANH", null, values );
    }

    public int update(Nganh item) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "nganhID", item.getTenNganh() );
        values.put( "tenNganh", item.getTenNganh() );
        return db.update( "NGANH", values, "nganhID=?", new String[]{String.valueOf( item.getNganhID() )} );
    }


    public int delete(String maLoai) {
        db = dbHelper.getWritableDatabase();
        return db.delete( "NGANH", "nganhID=?", new String[]{maLoai} );
    }




    public ArrayList<Nganh> get(String sql, String...selectionArgs){
        ArrayList<Nganh> list = new ArrayList<>();
        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery( sql,selectionArgs );
        c.moveToFirst();
        while (!c.isAfterLast()){
            try {
                String nganhID = c.getString(0);
                String tenNganh = c.getString(1);
                Nganh nganh = new Nganh(nganhID, tenNganh);
                list.add(nganh);
                c.moveToNext();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        c.close();
        return list;
    }
    public ArrayList<Nganh> getALL(){
        String sqlPTGetAll = "SELECT * FROM NGANH";
        return get( sqlPTGetAll );
    }


}



