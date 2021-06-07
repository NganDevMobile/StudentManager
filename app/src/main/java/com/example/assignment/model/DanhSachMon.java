package com.example.assignment.model;

public class DanhSachMon {
    private String  tenMon,monID,nganhID,chuyenNganhID,phong,gio,ngay;
    private int danhSachMonID,tinChi,accountID;

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public DanhSachMon(String tenMon, String monID, String nganhID, String chuyenNganhID, String phong, String gio, String ngay, int tinChi,int accountID) {
        this.tenMon = tenMon;
        this.monID = monID;
        this.nganhID = nganhID;
        this.chuyenNganhID = chuyenNganhID;
        this.phong = phong;
        this.gio = gio;
        this.ngay = ngay;
        this.tinChi = tinChi;
        this.accountID= accountID;
    }

    public DanhSachMon(String tenMon, String monID, String nganhID, String chuyenNganhID, String phong, String gio, String ngay, int danhSachMonID, int tinChi,int accountID) {
        this.tenMon = tenMon;
        this.monID = monID;
        this.nganhID = nganhID;
        this.chuyenNganhID = chuyenNganhID;
        this.phong = phong;
        this.gio = gio;
        this.ngay = ngay;
        this.danhSachMonID = danhSachMonID;
        this.tinChi = tinChi;
        this.accountID= accountID;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getMonID() {
        return monID;
    }

    public void setMonID(String monID) {
        this.monID = monID;
    }

    public String getNganhID() {
        return nganhID;
    }

    public void setNganhID(String nganhID) {
        this.nganhID = nganhID;
    }

    public String getChuyenNganhID() {
        return chuyenNganhID;
    }

    public void setChuyenNganhID(String chuyenNganhID) {
        this.chuyenNganhID = chuyenNganhID;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getDanhSachMonID() {
        return danhSachMonID;
    }

    public void setDanhSachMonID(int danhSachMonID) {
        this.danhSachMonID = danhSachMonID;
    }

    public int getTinChi() {
        return tinChi;
    }

    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }
}
