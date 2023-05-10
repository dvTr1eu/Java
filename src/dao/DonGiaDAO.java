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
                donGia.setMaSP(rs.getString("MaSP"));
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
}
