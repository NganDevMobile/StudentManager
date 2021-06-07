package com.example.assignment.model;

public class Nganh {
    private String nganhID, tenNganh;

    public Nganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getNganhID() {
        return nganhID;
    }

    public void setNganhID(String nganhID) {
        this.nganhID = nganhID;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public Nganh(String nganhID, String tenNganh) {
        this.nganhID = nganhID;
        this.tenNganh = tenNganh;
    }
}
