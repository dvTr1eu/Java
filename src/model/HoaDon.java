/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author uesr
 */
public class HoaDon {
    private String mahd;
    private String makh;
    private String manv;
    private Date ngaylap;
    private float thanhtoan;

    public HoaDon() {
    }

    public HoaDon(String mahd, String makh, String manv, Date ngaylap, float thanhtoan) {
        this.mahd = mahd;
        this.makh = makh;
        this.manv = manv;
        this.ngaylap = ngaylap;
        this.thanhtoan = thanhtoan;
    }

    
    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }

    public float getThanhtoan() {
        return thanhtoan;
    }

    public void setThanhtoan(float thanhtoan) {
        this.thanhtoan = thanhtoan;
    }
    
    
}
