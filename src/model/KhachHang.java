/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author uesr
 */
public class KhachHang {
    private String makh;
    private String hoten;
    private String diachi;
    private String sodt;

    public KhachHang(String makh, String hoten, String diachi, String sodt) {
        this.makh = makh;
        this.hoten = hoten;
        this.diachi = diachi;
        this.sodt = sodt;
    }

    public KhachHang() {
    }

    @Override
    public String toString() {
        return "KhachHang{" + "makh=" + makh + ", hoten=" + hoten + ", diachi=" + diachi + ", sodt=" + sodt + '}';
    }
    
    
    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }
    
    
}
