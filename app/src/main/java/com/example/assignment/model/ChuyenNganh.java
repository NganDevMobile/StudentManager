package com.example.assignment.model;

public class ChuyenNganh {
    private String chuyenNganhID, tenChuyenNganh,nganhID;

    public ChuyenNganh(String chuyenNganhID, String tenChuyenNganh, String nganhID) {
        this.chuyenNganhID = chuyenNganhID;
        this.tenChuyenNganh = tenChuyenNganh;
        this.nganhID = nganhID;
    }

    public String getChuyenNganhID() {
        return chuyenNganhID;
    }

    public void setChuyenNganhID(String chuyenNganhID) {
        this.chuyenNganhID = chuyenNganhID;
    }

    public String getTenChuyenNganh() {
        return tenChuyenNganh;
    }

    public void setTenChuyenNganh(String tenChuyenNganh) {
        this.tenChuyenNganh = tenChuyenNganh;
    }

    public String getNganhID() {
        return nganhID;
    }

    public void setNganhID(String nganhID) {
        this.nganhID = nganhID;
    }
}
