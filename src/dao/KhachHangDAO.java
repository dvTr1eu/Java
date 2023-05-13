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
import model.KhachHang;


/**
 *
 * @author uesr
 */
public class KhachHangDAO {
    connect connect = new connect();
    Connection conn = connect.getConnection();
    PreparedStatement pst = null;
    ResultSet rs = null;
    public List<KhachHang> getList(){
        List<KhachHang> list = new ArrayList<>();
        String sql = "Select * from KhachHang";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                KhachHang khachHang = new KhachHang();
                khachHang.setMakh(rs.getString("MaKH"));
                khachHang.setHoten(rs.getString("HoTen"));
                khachHang.setDiachi(rs.getString("DiaChi"));
                khachHang.setSodt(rs.getString("SoDT"));
                list.add(khachHang);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    public List<KhachHang> findList(String find){
        List<KhachHang> lists = new ArrayList<>();
        String sql = "select * from KhachHang where HoTen like '%"+find+"%'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                KhachHang khachHang = new KhachHang();
                khachHang.setMakh(rs.getString("MaKH"));
                khachHang.setHoten(rs.getString("HoTen"));
                khachHang.setDiachi(rs.getString("DiaChi"));
                khachHang.setSodt(rs.getString("SoDT"));
                lists.add(khachHang);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return lists;
    }
      
    public boolean them(String Ma, String Ten, String Dc, String SDT){
        String sql = "Insert into KhachHang Values (?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
                pst.setString(1, Ma);
                pst.setString(2, Ten);
                pst.setString(3, Dc);
                pst.setString(4, SDT);
                return pst.executeUpdate() > 0;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean sua(String Ma, String Ten, String Dc, String SDT){
        String sql = "Update KhachHang set HoTen = ?, DiaChi = ?, SoDT = ? where MaKH = ?";
        try {
            pst = conn.prepareStatement(sql);
                pst.setString(4, Ma);
                pst.setString(1, Ten);
                pst.setString(2, Dc);
                pst.setString(3, SDT);
                return pst.executeUpdate() > 0;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean xoa(String MaDel){
        String sql = "delete from KhachHang where MaKH = N'"+MaDel+"'";
        try {
                pst = conn.prepareStatement(sql);
                return pst.executeUpdate() > 0;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
