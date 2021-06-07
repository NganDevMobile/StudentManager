package com.example.assignment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.Database.DbHelper;
import com.example.assignment.model.ChuyenNganh;
import com.example.assignment.model.Nganh;
import com.example.assignment.model.User;

import java.util.ArrayList;
import java.util.List;


public class DAO_Chuyen_Nganh {
    private SQLiteDatabase db;
    DbHelper dbHelper;

    public DAO_Chuyen_Nganh(Context context) {
        dbHelper = new DbHelper( context );
        db = dbHelper.getWritableDatabase();
    }

    public long insert(ChuyenNganh item) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "chuyenNganhID", item.getTenChuyenNganh() );
        values.put( "tenChuyenNganh", item.getTenChuyenNganh() );
        values.put( "nganhID", item.getNganhID() );
        return db.insert( "CHUYEN_NGANH", null, values );
    }

    public int update(ChuyenNganh item) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "chuyenNganhID", item.getTenChuyenNganh() );
        values.put( "tenChuyenNganh", item.getTenChuyenNganh() );
        values.put( "nganhID", item.getNganhID() );
        return db.update( "CHUYEN_NGANH", values, "chuyenNganhID=?", new String[]{String.valueOf( item.getChuyenNganhID() )} );
    }

    public int delete(String maLoai) {
        db = dbHelper.getWritableDatabase();
        return db.delete( "CHUYEN_NGANH", "chuyenNganhID=?", new String[]{maLoai} );
    }




    public ArrayList<ChuyenNganh> get(String sql, String...selectionArgs){
        ArrayList<ChuyenNganh> list = new ArrayList<>();
        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery( sql,selectionArgs );
        c.moveToFirst();
        while (!c.isAfterLast()){
            try {
                String chuyenNganhID = c.getString(0);
                String tenChuyenNganh = c.getString(1);
                String nganhID=c.getString( 2 );
                ChuyenNganh chuyenNganh = new ChuyenNganh(chuyenNganhID, tenChuyenNganh,nganhID);
                list.add(chuyenNganh);
                c.moveToNext();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        c.close();
        return list;
    }
    public ArrayList<ChuyenNganh> getALL(String nganhID){
        String sqlPTGetAll = "SELECT * FROM CHUYEN_NGANH WHERE nganhID like '"+nganhID+"'";
        return get( sqlPTGetAll );
    }


}



