package com.example.assignment.model;

public class Mon {
    private String monID, tenMon,chuyenNganhID,tenNganh,tenChuyenNganh;
    private int tinChi;

    public Mon(String monID, String tenMon, String chuyenNganhID, String tenNganh, String tenChuyenNganh, int tinChi) {
        this.monID = monID;
        this.tenMon = tenMon;
        this.chuyenNganhID = chuyenNganhID;
        this.tenNganh = tenNganh;
        this.tenChuyenNganh = tenChuyenNganh;
        this.tinChi = tinChi;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getTenChuyenNganh() {
        return tenChuyenNganh;
    }

    public void setTenChuyenNganh(String tenChuyenNganh) {
        this.tenChuyenNganh = tenChuyenNganh;
    }

    public Mon(String monID, String tenMon, String chuyenNganhID, int tinChi) {
        this.monID = monID;
        this.tenMon = tenMon;
        this.chuyenNganhID = chuyenNganhID;
        this.tinChi = tinChi;
    }

    public String getMonID() {
        return monID;
    }

    public void setMonID(String monID) {
        this.monID = monID;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getChuyenNganhID() {
        return chuyenNganhID;
    }

    public void setChuyenNganhID(String chuyenNganhID) {
        this.chuyenNganhID = chuyenNganhID;
    }

    public int getTinChi() {
        return tinChi;
    }

    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }
}
