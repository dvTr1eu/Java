/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.HoaDon;

/**
 *
 * @author uesr
 */
public class HoaDonDAO {
    connect connect = new connect();
    Connection conn = connect.getConnection();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public List<HoaDon> getList(){
        List<HoaDon> list = new ArrayList<>();
        String sql = "Select * from HoaDon";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMahd(rs.getString("MaHD"));
                hoaDon.setMakh(rs.getString("MaKH"));
                hoaDon.setManv(rs.getString("MaNV"));
                hoaDon.setNgaylap(rs.getDate("NgayLap"));
                hoaDon.setThanhtoan(rs.getFloat("ThanhToan"));
                list.add(hoaDon);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    public List<HoaDon> findList(String find){
        List<HoaDon> lists = new ArrayList<>();
        String sql = "select * from HoaDon where NgayLap = '"+find+"'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMahd(rs.getString("MaHD"));
                hoaDon.setMakh(rs.getString("MaKH"));
                hoaDon.setManv(rs.getString("MaNV"));
                hoaDon.setNgaylap(rs.getDate("NgayLap"));
                hoaDon.setThanhtoan(rs.getFloat("ThanhToan"));
                lists.add(hoaDon);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return lists;
    }
    
    public boolean them(String mahd, String makh,String manv,String ngaylap,float thanhtoan){
        String query = "insert into HoaDon values(N'"+mahd+"',N'"+makh+"',N'"+manv+"','"+ngaylap+"',"+thanhtoan+")";
        try {
                pst = conn.prepareStatement(query);
                return pst.executeUpdate() > 0;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean sua(String mahd, String makh,String manv,String ngaylap,float thanhtoan){
        String query = "update HoaDon set MaHD = N'"+mahd+"',MaKH = N'"+makh+"', MaNV = N'"+manv+"'"
                + ", NgayLap = '"+ngaylap+"',ThanhToan = N'"+thanhtoan+"' where MaHD = N'"+mahd+"'";
        try {
                pst = conn.prepareStatement(query);
                return pst.executeUpdate() > 0;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean xoa(String madel){
        String query = "delete from HoaDon where MaHD = N'"+madel+"'";
        try {
                pst = conn.prepareStatement(query);
                return pst.executeUpdate() > 0;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
