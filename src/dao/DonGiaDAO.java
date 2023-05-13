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
import model.DonGia;

/**
 *
 * @author uesr
 */
public class DonGiaDAO {
    connect connect = new connect();
    Connection conn = connect.getConnection();
    PreparedStatement ps =null;
    ResultSet rs = null;
    public List<DonGia> getList(){
        List<DonGia> list1 = new ArrayList<>();
        String sql = "Select * from DonGia";
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                DonGia donGia = new DonGia();
                donGia.setNgayCn(rs.getDate("NgayCN"));                
                donGia.setGia(rs.getFloat("Gia"));
                list1.add(donGia);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return list1;
    }
    
    public List<DonGia> getDGbySP(String Ma){
        String query = "select * from DonGia where MaSP = N'"+Ma+"' order by NgayCN desc";
        List<DonGia> list1 = new ArrayList<>();
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                DonGia donGia = new DonGia();
                donGia.setNgayCn(rs.getDate("NgayCN"));
                donGia.setGia(rs.getFloat("Gia"));
                list1.add(donGia);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return list1;
    }
    
    public boolean themDon(String Ma, float Gia,String Bday){
        String query = "insert into DonGia values(N'"+Ma+"','"+Bday+"',"+Gia+")";
        try {
                ps = conn.prepareStatement(query);
                return ps.executeUpdate() > 0;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean suaDon(String Ma, float Gia,String Bday){
        String query = "Update DonGia set NgayCN='"+Bday+"', Gia="+Gia+" where MaSP =N'"+Ma+"' ";
        try {
            ps = conn.prepareStatement(query);
            int result = ps.executeUpdate();
            return result > 0;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
