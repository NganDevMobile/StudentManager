package com.example.assignment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.Database.DbHelper;
import com.example.assignment.model.ChuyenNganh;
import com.example.assignment.model.Mon;
import com.example.assignment.model.User;

import java.util.ArrayList;
import java.util.List;


public class DAO_Mon {
    private SQLiteDatabase db;
    DbHelper dbHelper;

    public DAO_Mon(Context context) {
        dbHelper = new DbHelper( context );
        db = dbHelper.getWritableDatabase();
    }

    public long insert(Mon item) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "monID", item.getTenMon() );
        values.put( "tenMon", item.getTenMon() );
        values.put( "tinChi", item.getTinChi() );
        values.put( "chuyenNganhID", item.getChuyenNganhID() );
        return db.insert( "MONHOC", null, values );
    }

    public int update(Mon item) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "monID", item.getTenMon() );
        values.put( "tenMon", item.getTenMon() );
        values.put( "tinChi", item.getTinChi() );
        values.put( "chuyenNganhID", item.getChuyenNganhID() );
        return db.update( "MONHOC", values, "monID=?", new String[]{String.valueOf( item.getMonID() )} );
    }

    public int delete(String maLoai) {
        db = dbHelper.getWritableDatabase();
        return db.delete( "MONHOC", "monID=?", new String[]{maLoai} );
    }




    public ArrayList<Mon> get(String sql, String...selectionArgs){
        ArrayList<Mon> list = new ArrayList<>();
        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery( sql,selectionArgs );
        c.moveToFirst();
        while (!c.isAfterLast()){
            try {
                String monID = c.getString(0);
                String tenMon = c.getString(1);
                int tinChi=c.getInt( 2 );
                String chuyenNganhID = c.getString(3);
                Mon mon = new Mon(monID, tenMon,chuyenNganhID,tinChi);
                list.add(mon);
                c.moveToNext();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        c.close();
        return list;
    }
    public ArrayList<Mon> getALL(String chuyenNganhID){
        String sqlPTGetAll = "SELECT * FROM MONHOC WHERE chuyenNganhID like '"+chuyenNganhID+"'";
        return get( sqlPTGetAll );
    }
    public ArrayList<Mon> getTinChi(String monID){
        String sqlPTGetAll = "SELECT tinChi FROM MONHOC WHERE monID like '"+monID+"'";
        return get( sqlPTGetAll );
    }
}



