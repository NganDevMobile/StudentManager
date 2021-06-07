package com.example.assignment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.Database.DbHelper;
import com.example.assignment.model.DanhSachMon;
import com.example.assignment.model.Mon;

import java.util.ArrayList;


public class DAO_Danh_Sach_Mon {
    private SQLiteDatabase db;
    DbHelper dbHelper;

    public DAO_Danh_Sach_Mon(Context context) {
        dbHelper = new DbHelper( context );
        db = dbHelper.getWritableDatabase();
    }

    public long insert(DanhSachMon item) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "phong", item.getPhong() );
        values.put( "gio", item.getGio() );
        values.put( "ngay", item.getNgay() );
        values.put( "monID", item.getMonID() );
        values.put( "nganhID", item.getNganhID() );
        values.put( "tenMon", item.getTenMon() );
        values.put( "tinChi", item.getTinChi() );
        values.put( "accountID", item.getAccountID() );
        values.put( "chuyenNganhID", item.getChuyenNganhID() );
        return db.insert( "DANHSACHMON", null, values );
    }

    public int update(DanhSachMon item) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "phong", item.getPhong() );
        values.put( "gio", item.getGio() );
        values.put( "ngay", item.getNgay() );
        values.put( "monID", item.getMonID() );
        values.put( "nganhID", item.getNganhID() );
        values.put( "tenMon", item.getTenMon() );
        values.put( "tinChi", item.getTinChi() );
        values.put( "accountID", item.getTinChi() );
        values.put( "chuyenNganhID", item.getChuyenNganhID() );
        return db.update( "DANHSACHMON", values, "danhSachMonID=?", new String[]{String.valueOf( item.getMonID() )} );
    }

    public int delete(String maLoai) {
        db = dbHelper.getWritableDatabase();
        return db.delete( "DANHSACHMON", "danhSachMonID=?", new String[]{maLoai} );
    }




    public ArrayList<DanhSachMon> get(String sql, String...selectionArgs){
        ArrayList<DanhSachMon> list = new ArrayList<>();
        db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery( sql,selectionArgs );
        c.moveToFirst();
        while (!c.isAfterLast()){
            try {
                int danhSachMonID= c.getInt( 0 );
                String tenMon = c.getString(1);
                int tinChi = c.getInt(2);
                String ngay= c.getString( 3 );
                String phong =c.getString( 4 );
                String gio=c.getString( 5 );
                String monID=c.getString( 6);
                String nganhID = c.getString(7);
                String chuyenNganhID  = c.getString(8);
                int accountID =c.getInt( 9 );
                DanhSachMon mon = new DanhSachMon(tenMon,monID,nganhID,chuyenNganhID,phong,gio,ngay,danhSachMonID, tinChi,accountID);
                list.add(mon);
                c.moveToNext();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        c.close();
        return list;
    }
    public ArrayList<DanhSachMon> getALL(String accountID ){
        String sqlPTGetAll = "SELECT * FROM DANHSACHMON" +
                " INNER JOIN ACCOUNT ON DANHSACHMON.accountID=ACCOUNT.accountID WHERE ACCOUNT.accountID LIKE '"+accountID+"'";
        return get( sqlPTGetAll );
    }

}



