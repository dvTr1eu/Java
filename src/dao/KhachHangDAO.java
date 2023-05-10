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
import javax.swing.JOptionPane;
import model.KhachHang;


/**
 *
 * @author uesr
 */
public class KhachHangDAO {
    connect connect = new connect();
    Connection conn = connect.getConnection();
    
    public List<KhachHang> getList(){
        List<KhachHang> list = new ArrayList<>();
        String sql = "Select * from KhachHang";
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
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
      
    public boolean them(KhachHang khachHang){
        String sql = "Insert into KhachHang Values (?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, khachHang.getMakh());
                pst.setString(2, khachHang.getHoten());
                pst.setString(3, khachHang.getDiachi());
                pst.setString(4, khachHang.getSodt());
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
            PreparedStatement pst = conn.prepareStatement(sql);
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
//    public static void main(String[] args) {
//        KhachHangDAO khachHangDAO = new KhachHangDAO();
//    }
}
