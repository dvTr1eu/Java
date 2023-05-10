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
public class DonGia {
    private String Masp;
    private float gia;
    private Date NgayCn;
    
    public DonGia(){
        
    }

    public DonGia(String Masp,float gia, Date NgayCn) {
        this.Masp = Masp;
        this.gia = gia;
        this.NgayCn = NgayCn;
    }

    public String getMaSP() {
        return Masp;
    }

    public void setMaSP(String Masp) {
        this.Masp = Masp;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public Date getNgayCn() {
        return NgayCn;
    }

    public void setNgayCn(Date NgayCn) {
        this.NgayCn = NgayCn;
    }
}
