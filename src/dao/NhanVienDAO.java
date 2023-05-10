/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;

/**
 *
 * @author uesr
 */
public class NhanVienDAO {
    connect connect = new connect();
    Connection conn = connect.getConnection();
    PreparedStatement ps =null;
    ResultSet rs = null;
    public List<NhanVien> getList(){
        List<NhanVien> list = new ArrayList<>();
        String sql = "Select * from NhanVien";
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                NhanVien nhanVien = new NhanVien();
                nhanVien.setManv(rs.getString("MaNV"));
                nhanVien.setTennv(rs.getString("HoTen"));
                nhanVien.setNgaysinh(rs.getDate("NgaySinh"));
                nhanVien.setGioitinh(rs.getString("GioiTinh"));                
                nhanVien.setSodienthoai(rs.getString("SoDT"));
                nhanVien.setDiachi(rs.getString("DiaChi"));
                list.add(nhanVien);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    public boolean them(String Ma, String Ten,String Bday,String gt, String SDT, String Dc){
        String query = "insert into NhanVien values(N'"+Ma+"',N'"+Ten+"','"+Bday+"',N'"+gt+"',N'"+SDT+"',N'"+Dc+"')";
        try {
                ps = conn.prepareStatement(query);
                return ps.executeUpdate() > 0;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean sua(String Ma, String Ten,String Bday,String gt, String SDT, String Dc){
        String query = "Update NhanVien set HoTen = ?, NgaySinh = ?,GioiTinh = ?, SoDT = ?,DiaChi = ? where MaNV = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(6, Ma);
            ps.setString(1, Ten);
            ps.setString(2, Bday);
            ps.setString(3, gt);
            ps.setString(4, SDT);
            ps.setString(5, Dc);
            return ps.executeUpdate() > 0;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
